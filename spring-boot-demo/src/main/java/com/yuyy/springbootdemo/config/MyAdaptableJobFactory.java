package com.yuyy.springbootdemo.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 重写AdaptableJobFactory的createJobInstance()方法
 * 避免在Quartz job中无法使用ioc里的对象，例如service
 * @author yuyy
 * @date 20-2-5 下午4:57
 */
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //将对象添加到springIOC容器中，并且完成该对象注入
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
