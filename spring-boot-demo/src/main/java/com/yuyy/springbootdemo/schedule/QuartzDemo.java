package com.yuyy.springbootdemo.schedule;

import com.yuyy.springbootdemo.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author yuyy
 * @date 20-2-5 下午3:11
 */
public class QuartzDemo implements Job {

    @Autowired
    private UserService userService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //System.out.println("Quartz定时器执行--------"+new Date());
        userService.testQuartz();
    }
}
