
/**
 * <一句话功能描述>
 * <p> 发票信息业务层实现类
 * @author 陈宇林
 * @version [版本号, 2019年3月7日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.restservice.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soa.config.PropertiesConfig;
import com.soa.restservice.dao.BillDetailInfoMapper;
import com.soa.restservice.dao.BillMainInfoMapper;
import com.soa.restservice.entity.BillDetailInfo;
import com.soa.restservice.entity.BillMainInfo;
import com.soa.restservice.entity.QueryCondition;
import com.soa.restservice.service.inter.BillingInfoService;
import com.soa.util.HttpUtil;
import com.soa.util.JaxbUtil;
import com.soa.util.SerialNoUtil;
import com.soa.webservice.entity.SAPResponse;
import com.soa.webservice.entity.TReturn;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BillingInfoServiceImpl implements BillingInfoService {
	
	@Autowired
	private BillMainInfoMapper billMainInfoMapper;
	
	@Autowired
	private BillDetailInfoMapper billDetailInfoMapper ;
	
	@Autowired
	private PropertiesConfig config;
	
	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	
	

	/* (non-Javadoc)
	 * @see com.soa.restservice.service.inter.BillingInfoService#getMainBillingInfo(com.soa.restservice.entity.QueryCondition)
	 */
	@Override
	public List<BillMainInfo> getMainBillingInfo(QueryCondition condition) {
		
		List<BillMainInfo> mainBillingInfos = billMainInfoMapper.selectByCondition(condition);
		
		
		return mainBillingInfos;
	}



	/* (non-Javadoc)
	 * @see com.soa.restservice.service.inter.BillingInfoService#getDetailBillingInfo(com.soa.restservice.entity.QueryCondition)
	 */
	@Override
	public List<BillDetailInfo> getDetailBillingInfo(QueryCondition condition) {
		
		List<BillDetailInfo> detailBillingInfo = billDetailInfoMapper.selectByCondition(condition);
		
		return detailBillingInfo;
	}



	/* (non-Javadoc)
	 * @see com.soa.restservice.service.inter.BillingInfoService#sendBillReceipt(java.util.List)
	 */
	@Override
	public List<String> sendBillReceipt(List<BillMainInfo> billMainInfos) {
		
		
		//存储成功发送回执并成功更改状态的发票单号
		List<String> successBillNumber = new ArrayList<String>();
		
		if (billMainInfos == null || billMainInfos.isEmpty()) {
			// 数据库未查询到需要发送的数据，结束此次发送任务
			log.info(new Date() + "：未查询到需要发送的回执信息，结束本次任务");
			return null;
		}

		StringBuffer message = new StringBuffer("<Request>");
		for (BillMainInfo result : billMainInfos) {
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
					int result = billMainInfoMapper.updateStateByBillNumber(billMainInfo);
					if (result > 0) {
						log.info("单号为：" + billMainInfo.getBillNumber() + "的发票回执信息发送状态成功修改为已发送");
						successBillNumber.add(billMainInfo.getBillNumber());
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
		return successBillNumber;
	}

	

}
