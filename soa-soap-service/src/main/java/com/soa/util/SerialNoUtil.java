
/**
 * <一句话功能描述>
 * <p>序列号工具类
 * @author 陈宇林
 * @version [版本号, 2019年3月18日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.util;

import java.util.concurrent.atomic.AtomicInteger;

public class SerialNoUtil {
	
	private static AtomicInteger  serialNo = new AtomicInteger(1000001);
	
	/**
	 * 获取当前流水号并递增
	 * @return
	 */
	public static String getSerialNo() {
		String serialNoStr = Integer.toString(serialNo.getAndIncrement());
		return serialNoStr.substring(1);
	}
	

}
