package com.yuyy.springbootdemo.service.Impl;

import com.yuyy.springbootdemo.mapper.UserMapper;
import com.yuyy.springbootdemo.model.TestParam;
import com.yuyy.springbootdemo.pojo.User;
import com.yuyy.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yuyy
 * @date 2020/1/21 11:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    //@Cacheable:对当前查询的对象做缓存处理
    //value：选择缓存策略，可以自定义
    //key:配置缓存对象的key
    @Cacheable(value = "users",key = "#param.a")
    public User findUser(int id, TestParam param) {
        System.out.println(param);
        return userMapper.findUser(id);
    }

    @Override
    //清除缓存
    //value：绑定缓存策略
    @CacheEvict(value = "users",allEntries=true)
    public void cacheEvict() {
    }
}
