
/**
 * <一句话功能描述>
 * <p>Quartz配置
 * @author 陈宇林
 * @version [版本号, 2019年3月18日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soa.Task.ScheduleTask;

@Configuration
public class QuartzConfig {

	@Autowired
	private PropertiesConfig config;

	@Bean
	public JobDetail scheduleTask() {
		return JobBuilder.newJob(ScheduleTask.class).withIdentity("soaQuartz").storeDurably().build();
	}

	@Bean
	public Trigger testQuartzTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(config.getInterval()) // 设置时间周期单位秒
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(scheduleTask()).withIdentity("ScheduleTask")
				.withSchedule(scheduleBuilder).build();
	}

}
