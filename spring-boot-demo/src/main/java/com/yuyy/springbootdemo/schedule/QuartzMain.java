package com.yuyy.springbootdemo.schedule;

import lombok.Builder;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author yuyy
 * @date 20-2-5 下午3:16
 */

public class QuartzMain {

    public void excute() throws SchedulerException {
        //创建job对象，做什么
        JobDetail jobDetail=JobBuilder.newJob(QuartzDemo.class).build();
        //创建Trigger对象，什么时候做
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        //创建Scheduler对象，在什么时间做什么事
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
