package com.yuyy.springbootdemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务Demo
 * @author yuyy
 * @date 20-2-5 下午2:18
 */
//@Component
public class ScheduleDemo {

    /**
     * 设置定时任务方法
     * cron表达式
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduleMethod(){
        System.out.println("定时器："+new Date());
    }
}
