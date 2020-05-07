package com.yuyy.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置Redis
 * @author yuyy
 * @date 2020/2/2 16:00
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Bean
    public RedisTemplate<Object,Object> getRedisTemplate(){
        System.out.println(redisTemplate);
        //配置key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //配置value的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
