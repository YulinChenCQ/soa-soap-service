
/**
 * <一句话功能描述>
 * <p>rest配置
 * @author 陈宇林
 * @version [版本号, 2019年3月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestConfiguration {

	@Autowired
	RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

}
