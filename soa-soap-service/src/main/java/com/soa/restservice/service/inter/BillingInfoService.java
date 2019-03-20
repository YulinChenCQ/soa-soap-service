
/**
 * <一句话功能描述>
 * <p> 发票信息业务层接口
 * @author 陈宇林
 * @version [版本号, 2019年3月7日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.restservice.service.inter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soa.restservice.entity.BillDetailInfo;
import com.soa.restservice.entity.BillMainInfo;
import com.soa.restservice.entity.QueryCondition;

@Service
public interface BillingInfoService {

	/**
	 * 获取发票主表信息
	 * 
	 * @param condition
	 * @return
	 */
	public List<BillMainInfo> getMainBillingInfo(QueryCondition condition);

	/**
	 * 获取发票明细表信息
	 * @param condition
	 * @return
	 */
	public List<BillDetailInfo> getDetailBillingInfo(QueryCondition condition);

	/**
	 * 发送开票信息回执到SAP系统
	 * @param billMainInfos
	 * @return
	 */
	public List<String> sendBillReceipt(List<BillMainInfo> billMainInfos);

}
