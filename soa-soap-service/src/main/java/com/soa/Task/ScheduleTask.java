
/**
 * <一句话功能描述>
 * <p>任务类
 * @author 陈宇林
 * @version [版本号, 2019年3月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.soa.config.PropertiesConfig;
import com.soa.restservice.dao.BillMainInfoMapper;
import com.soa.restservice.entity.BillMainInfo;
import com.soa.util.HttpUtil;
import com.soa.util.JaxbUtil;
import com.soa.util.SerialNoUtil;
import com.soa.webservice.entity.SAPResponse;
import com.soa.webservice.entity.TReturn;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScheduleTask extends QuartzJobBean {

	@Autowired
	private BillMainInfoMapper mainMapper;

	@Autowired
	private PropertiesConfig config;

	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

	private static int i = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.
	 * quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		i++;
		System.out.println("任务正在执行:" + i);
		List<BillMainInfo> results = mainMapper.selectByState("FALSE");
		System.out.println(results);
		if (results.isEmpty()) {
			// 数据库未查询到需要发送的数据，结束此次发送任务
			log.info(new Date() + "：未查询到需要发送的回执信息，结束本次任务");
			return;
		}

		StringBuffer message = new StringBuffer("<Request>");
		for (BillMainInfo result : results) {
			System.out.println(result);
			/**
			 * 获取数据，拼装报文
			 */
			message.append("<T_DATA>");
			message.append("<GTD_NMBR>" + result.getBillNumber() + "</GTD_NMBR>");
			message.append("<GTVBELN>" + result.getReBillNumber() + "</GTVBELN>");
			message.append("</T_DATA>");

		}

		message.append("</Request>");

		System.out.println(message.toString());

		/**
		 * 发送HTTP请求
		 */
		String serialNo = config.getSerId() + sdf1.format(new Date()) + SerialNoUtil.getSerialNo();

		String resMsg;

		try {
			resMsg = HttpUtil.getInstance().requestHttp(config.getUrlOfHttpToSap(), message.toString(),
					config.getSerId(), config.getSerId(), serialNo);
			log.info("(SerialNo:" + serialNo + ") resMsg:\n" + resMsg + "\n");

			System.out.println("resMsg:" + resMsg);

			/**
			 * 接收到返回数据后，修改对应的数据的发送状态
			 */
			// 将xml字符串格式消息解析成实体类
			SAPResponse sapResponse = JaxbUtil.xmlToBean(resMsg, SAPResponse.class);

			List<TReturn> tReturns = sapResponse.getTReturns();

			for (TReturn tReturn : tReturns) {
				if ("S".equals(tReturn.getMessageType())) {

					/**
					 * 当SAP返回成功的消息时，修改数据库中的发送回执状态；若不成功，则下一次任务会继续发送该条回执信息
					 */
					BillMainInfo billMainInfo = new BillMainInfo();
					billMainInfo.setBillNumber(tReturn.getBillNumber());// 单号
					billMainInfo.setState("TRUE");// 回执发送状态
					int result = mainMapper.updateStateByBillNumber(billMainInfo);
					if (result > 0) {
						log.info("单号为：" + billMainInfo.getBillNumber() + "的发票回执信息发送状态成功修改为已发送");
					} else {
						log.info("单号为：" + billMainInfo.getBillNumber() + "的发票回执信息发送状态成功修改失败");
					}
				}
			}
		} catch (JAXBException e) {
			log.error(new Date() + " xml格式错误");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
