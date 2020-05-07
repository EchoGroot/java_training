package com.yuyy.springbootdemo.service.Impl;

import com.yuyy.springbootdemo.SpringBootDemoApplication;
import com.yuyy.springbootdemo.model.TestParam;
import com.yuyy.springbootdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author yuyy
 * @date 2020/1/21 11:58
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= SpringBootDemoApplication.class)
public class UserServiceImplTest {

    @Value(value = "${test.temp}")
    private String temp;
    @Autowired
    private UserService userService;
    @Test
    @ConfigurationProperties(prefix = "test")
    void findUser() {
        System.out.println(null==userService);
        TestParam param = TestParam.builder().a(1).b(0).c(0).build();
        TestParam param1 = TestParam.builder().a(0).b(1).c(0).build();
        TestParam param2 = TestParam.builder().a(0).b(0).c(1).build();
        System.out.println(userService.findUser(6, param));
        System.out.println(userService.findUser(6, param1));
        userService.cacheEvict();
        System.out.println(userService.findUser(6, param2));

        System.out.println(temp);
    }
}