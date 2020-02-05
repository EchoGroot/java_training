package com.yuyy.springbootdemo;

import com.yuyy.springbootdemo.schedule.QuartzMain;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.yuyy.springbootdemo.mapper")
@EnableCaching
@EnableScheduling   //启用定时器
public class SpringBootDemoApplication {
    public static void main(String[] args) throws SchedulerException {

        //QuartzMain quartzMain = new QuartzMain();
        SpringApplication.run(SpringBootDemoApplication.class, args);
        //quartzMain.excute();
    }
}
