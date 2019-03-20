
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年3月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class SAPResponse {
	
	@XmlElement(name = "T_RETURN")
	private List<TReturn> tReturns;

}
