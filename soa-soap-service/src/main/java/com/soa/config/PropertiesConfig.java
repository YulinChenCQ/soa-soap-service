
/**
 * <一句话功能描述>
 * <p> 自定义配置属性类
 * @author 陈宇林
 * @version [版本号, 2019年3月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "soa.propertity")
public class PropertiesConfig {

	/**
	 * 定时任务执行间隔时间
	 */
	
	private int interval;

	/**
	 * osb消息流发布的http到sap的服务地址
	 */
	private String urlOfHttpToSap;

	/**
	 * osb消息流服务调用所需参数（针对http to sap）
	 */
	private String sysId;

	/**
	 * osb消息流服务id
	 */
	private String serId;

	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @return the urlOfHttpToSap
	 */
	public String getUrlOfHttpToSap() {
		return urlOfHttpToSap;
	}

	/**
	 * @return the sysId
	 */
	public String getSysId() {
		return sysId;
	}

	/**
	 * @return the serId
	 */
	public String getSerId() {
		return serId;
	}

	/**
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * @param urlOfHttpToSap
	 *            the urlOfHttpToSap to set
	 */
	public void setUrlOfHttpToSap(String urlOfHttpToSap) {
		this.urlOfHttpToSap = urlOfHttpToSap;
	}

	/**
	 * @param sysId
	 *            the sysId to set
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	/**
	 * @param serId
	 *            the serId to set
	 */
	public void setSerId(String serId) {
		this.serId = serId;
	}

}
