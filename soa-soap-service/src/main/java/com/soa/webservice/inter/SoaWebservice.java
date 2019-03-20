
/**
 * <一句话功能描述>
 * <p>webservice 接口
 * @author 陈宇林
 * @version [版本号, 2019年3月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.inter;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.UnmarshalException;

import org.apache.ibatis.annotations.Param;

import com.soa.webservice.entity.BillingRecipt;
import com.soa.webservice.entity.ResponseObj;
import com.soa.webservice.entity.THeader;
import com.soa.webservice.entity.TItem;

@WebService
public interface SoaWebservice {

	@WebMethod(operationName = "sayHello")
	@WebResult(name = "out")
	public String sayHello(@WebParam(name = "username") String username, @WebParam(name = "city") String city);

	/**
	 * 模拟接收开票信息回执
	 * 
	 * @param recipt
	 * @return
	 * @throws UnmarshalException
	 */
	@WebMethod(operationName = "getRecipt")
	@WebResult(name = "Result")
	public ResponseObj getRecipt(@WebParam(name = "Table") List<BillingRecipt> recipts) throws UnmarshalException;

	/**
	 * 接收申请开票信息数据，并存入出数据库
	 * 
	 * @param billInfos
	 * @return
	 */

	@WebMethod(operationName = "applyBilling")
	@WebResult(name = "Result")
	public ResponseObj applyBilling(@WebParam(name = "T_HEADER") List<THeader> tHeaders,
			@WebParam(name = "T_ITEM") List<TItem> tItems);

}
