
/**
 * <一句话功能描述>
 * <p> SAP接收发票信息回执返回的消息实体类
 * @author 陈宇林
 * @version [版本号, 2019年3月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "GTD_NMBR", "GTVBELN", "MSGTY", "MESSAGE" })
@XmlRootElement(name = "T_RETURN")
public class TReturn {

	@XmlElement(name = "GTD_NMBR")
	private String billNumber;// 金税单据号

	@XmlElement(name = "GTVBELN")
	private String reBillnumber;// 金税发票号码

	@XmlElement(name = "MSGTY")
	private String messageType;// 消息类型: S 成功,E 错误,W 警告,I 信息,A 中断

	@XmlElement(name = "MESSAGE")
	private String message;// 消息文本

}
