package com.yuyy.springbootdemo.config;

import com.yuyy.springbootdemo.schedule.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * SpringBoot整合Quartz的配置类
 * @author yuyy
 * @date 20-2-5 下午4:32
 */
@Configuration
public class QuartzConfig {
    /**
     * 创建job对象
     * 做什么
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        //关联自定义的job类
        factoryBean.setJobClass(QuartzDemo.class);
        return factoryBean;
    }

    /**
     * 创建Trigger对象
     * 什么时候做
     */
    //@Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        //关联jobdetail
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //执行相隔毫秒
        factoryBean.setRepeatInterval(2000);
        //执行重复次数
        factoryBean.setRepeatCount(5);
        return factoryBean;
    }
    /**
     * 使用cron表达式
     * 创建Trigger对象
     * 什么时候做
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        //关联jobdetail
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        factoryBean.setCronExpression("0/2 * * * * ?");
        return factoryBean;
    }

    /**
     * 创建Schedul对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean
    ,MyAdaptableJobFactory MyAdaptableJobFactory){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        factoryBean.setJobFactory(MyAdaptableJobFactory);
        return factoryBean;
    }
}
