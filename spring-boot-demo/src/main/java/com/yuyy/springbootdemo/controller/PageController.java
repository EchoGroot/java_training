package com.yuyy.springbootdemo.controller;

import com.yuyy.springbootdemo.config.RedisConfig;
import com.yuyy.springbootdemo.model.TestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuyy
 * @date 2020/1/20 13:50
 */
@Controller
public class PageController {

    @Autowired
    private RedisConfig redisConfig;

    @Value(value = "${spring.redis.host}")
    private String temp;

    @RequestMapping("index")
    public String showPageHome(Model model){
        model.addAttribute("msg","Hello Yuyy");
        System.out.println("come in ");
        System.out.println(temp);
        RedisTemplate<Object, Object> redisTemplate = redisConfig.getRedisTemplate();

        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(TestParam.class));
        redisTemplate.opsForValue().set("yuyy",TestParam.builder().a(55).b(52).c(98).build());
        redisTemplate.opsForValue().set("dd","fdsfdsfsdfds");
        TestParam yuyy = (TestParam)redisTemplate.opsForValue().get("yuyy");
        System.out.println(yuyy);
        return "index";
    }
}
