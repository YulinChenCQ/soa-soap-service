
/**
 * <一句话功能描述>
 * <p>发票信息处理类
 * @author 陈宇林
 * @version [版本号, 2019年3月7日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.restservice.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soa.restservice.entity.BillDetailInfo;
import com.soa.restservice.entity.BillMainInfo;
import com.soa.restservice.entity.QueryCondition;
import com.soa.restservice.entity.TableResponseObject;
import com.soa.restservice.service.inter.BillingInfoService;

@RestController
@RequestMapping(value = "/billing")
public class BillingInfoControl {

	@Autowired
	private BillingInfoService billingInfoService;

	/**
	 * 根据条件获取发票主表信息
	 * 
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @param billNumber
	 *            单号
	 * @param buyerName
	 *            购方名称
	 * @param buyerDutyParagraph
	 *            购方税号
	 * @param page 页码
	 * @param pageSize 
	 * @return
	 */
	@RequestMapping(value = "/getMainBillingInfo")
	public TableResponseObject<List<BillMainInfo>> getMainBillingInfo(
			@RequestParam(value = "beginDate", required = false) String beginDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "billNumber", required = false) String billNumber,
			@RequestParam(value = "buyerName", required = false) String buyerName,
			@RequestParam(value = "buyerDutyParagraph", required = false) String buyerDutyParagraph,
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "limit", required = false) int pageSize) {

		QueryCondition condition = new QueryCondition(beginDate, endDate, billNumber, buyerName, buyerDutyParagraph,
				page, pageSize);

		List<BillMainInfo> billMainInfo = billingInfoService.getMainBillingInfo(condition);

		TableResponseObject<List<BillMainInfo>> reObj = new TableResponseObject<List<BillMainInfo>>(0, "success",
				billMainInfo.size(), billMainInfo);

		return reObj;
	}

	/**
	 * 根据条件获取发票附表信息
	 * 
	 * @param billNumber
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getDetailBillingInfo")
	public TableResponseObject<List<BillDetailInfo>> getDetailBillingInfo(
			@RequestParam(value = "billNumber", required = false) String billNumber,
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "limit", required = false) int pageSize) {

		QueryCondition condition = new QueryCondition();
		condition.setBillNumber(billNumber);
		condition.setPage(page);

		List<BillDetailInfo> result = billingInfoService.getDetailBillingInfo(condition);

		TableResponseObject<List<BillDetailInfo>> reObj = new TableResponseObject<List<BillDetailInfo>>(0, "success",
				result.size(), result);

		return reObj;
	}

	/**
	 * 发送发票信息回执
	 * 
	 * @param billMainInfos
	 * @return
	 */
	@RequestMapping("/sendBillReceipt")
	public TableResponseObject<List<String>> sendBillReceipt(@RequestBody List<BillMainInfo> billMainInfos) {

		System.out.println(billMainInfos);

		List<String> result = billingInfoService.sendBillReceipt(billMainInfos);

		TableResponseObject<List<String>> reObj = new TableResponseObject<List<String>>(0, "success", result.size(),
				result);
		return reObj;
	}

}
