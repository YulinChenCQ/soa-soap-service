
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年3月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soa.webservice.inter.SoaWebservice;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private SoaWebservice webservice;
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), webservice);
		
		endpoint.publish("/soaWebservice");
		
		return endpoint;
	}

}
