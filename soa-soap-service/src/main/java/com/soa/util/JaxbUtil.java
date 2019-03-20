
/**
 * <一句话功能描述>
 * <p>xml工具类
 * @author 陈宇林
 * @version [版本号, 2019年3月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class JaxbUtil {

	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xmlPath, Class<T> load) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(load);

		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (T) unmarshaller.unmarshal(new StringReader(xmlPath));
	}
}
