
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年3月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.UnmarshalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.soa.restservice.dao.BillDetailInfoMapper;
import com.soa.restservice.dao.BillMainInfoMapper;
import com.soa.restservice.entity.BillDetailInfo;
import com.soa.restservice.entity.BillMainInfo;
import com.soa.webservice.entity.BillingRecipt;
import com.soa.webservice.entity.ResponseObj;
import com.soa.webservice.entity.THeader;
import com.soa.webservice.entity.TItem;
import com.soa.webservice.inter.SoaWebservice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebService(targetNamespace = "http://inter.webservice.soa.com/", endpointInterface = "com.soa.webservice.inter.SoaWebservice")
@Component
public class SoaWebserviceImpl implements SoaWebservice {

	@Autowired
	private BillMainInfoMapper mainInfoMapper;

	@Autowired
	private BillDetailInfoMapper detailInfoMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soa.webservice.inter.SoaWebservice#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String username, String city) {

		System.out.println(username);
		System.out.println(city);

		return city + "的" + username + ",hello," + new Date();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.soa.webservice.inter.SoaWebservice#getRecipt(com.soa.webservice.entity.
	 * BillingRecipt)
	 */
	@CrossOrigin(origins = { "http://192.168.1.111:7003", "null" })
	@Override
	public ResponseObj getRecipt(List<BillingRecipt> recipts) throws UnmarshalException {

		for (BillingRecipt recipt : recipts) {
			System.out.println(recipt);
		}

		ResponseObj reObj = new ResponseObj();
		reObj.setCode(1);
		reObj.setMsg("接收成功！！！");

		return reObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soa.webservice.inter.SoaWebservice#applyBilling(java.util.List)
	 */
	@Override
	public ResponseObj applyBilling(List<THeader> tHeaders, List<TItem> tItems) {

		List<BillMainInfo> billMainInfos = new ArrayList<BillMainInfo>();

		List<BillDetailInfo> billDetailInfos = new ArrayList<BillDetailInfo>();
		
		/**
		 * 主表信息保存成功的单号
		 */
		List<String> successBillNumbers = new ArrayList<String>();

		ResponseObj reObj = new ResponseObj();

		try {
			/**
			 * 封装数据
			 */
			for (THeader tHeader : tHeaders) {
				BillMainInfo billMainInfo = new BillMainInfo();
				billMainInfo.setBillNumber(tHeader.getREFVBELN());// 单号
				billMainInfo.setBillDate(tHeader.getDOC_DATE());// 单据日期
				billMainInfo.setBuyerName(tHeader.getKNAME1());// 购方名称
				billMainInfo.setBuyerDutyParagraph(tHeader.getKSTCD5());// 税号
				billMainInfo.setBuyerAddrPhone(tHeader.getKSTRAS());// 地址、电话
				billMainInfo.setBuyerBankAccount(tHeader.getKBANKA());// 银行
				billMainInfo.setTotalAmount(tHeader.getZJEHJ());// 金额
				billMainInfo.setOperator(tHeader.getVUSNAM());// 操作员

				billMainInfos.add(billMainInfo);
			}

			for (TItem tItem : tItems) {
				BillDetailInfo billDetailInfo = new BillDetailInfo();
				billDetailInfo.setBillNumber(tItem.getREFVBELN());// 单号
				billDetailInfo.setTradeName(tItem.getMAKTX());// 商品名称
				billDetailInfo.setSpecificationsAndModel(tItem.getMSPEC());// 规格型号
				billDetailInfo.setUnit(tItem.getMEINS());// 计量单位
				billDetailInfo.setQuantity(tItem.getFKIMG());// 数量
				billDetailInfo.setPriceExcludingTax(tItem.getUNITPE());// 单价（不含税）
				billDetailInfo.setSumExcludingTax(tItem.getNETWR());// 金额
				billDetailInfo.setTaxRate(tItem.getTAXRATE());// 增值税税 率
				billDetailInfo.setTax(tItem.getTAXAMT());// 税金
				billDetailInfo.setTaxClassCode(tItem.getMATL_CAT_NAME());// 分类编码名称

				billDetailInfos.add(billDetailInfo);
			}

			/**
			 * 数据持久化
			 */

			// 发票主表数据持久化
			for (BillMainInfo billMainInfo : billMainInfos) {
				try {
					int result = mainInfoMapper.insertSelective(billMainInfo);
					if (result > 0) {
						log.info("单号为：" + billMainInfo.getBillNumber() + "的发票主表信息保存成功");
						successBillNumbers.add(billMainInfo.getBillNumber());
					} else {
						log.info("单号为：" + billMainInfo.getBillNumber() + "的发票主表信息保存失败");
					}
				} catch (Exception e) {
					log.info("单号为：" + billMainInfo.getBillNumber() + "的发票主表信息保存失败");
				}
			}

			
			
			
			// 发票明细表数据持久化
			for (BillDetailInfo billDetailInfo : billDetailInfos) {
				
				/**
				 * 排除主表信息保存失败的单号
				 */
				if(! successBillNumbers.contains(billDetailInfo.getBillNumber())) {
					continue;
				}
				
				
				try {
					int result = detailInfoMapper.insertSelective(billDetailInfo);
					if (result > 0) {
						log.info("单号为：" + billDetailInfo.getBillNumber() + "的发票明细表信息保存成功");
					} else {
						log.info("单号为：" + billDetailInfo.getBillNumber() + "的发票明细表信息保存失败");
					}
				} catch (Exception e) {
					log.info("单号为：" + billDetailInfo.getBillNumber() + "的发票明细表信息保存失败");
				}
			}

			reObj.setCode(1);
			reObj.setMsg("接收成功！！！");

		} catch (Exception e) {
			log.error("发生错误" + e.getMessage());

			reObj.setCode(0);
			reObj.setMsg("接收失败！！！");
		}

		return reObj;

	}

}
