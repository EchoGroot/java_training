package com.yuyy.springbootdemo.service;

import com.yuyy.springbootdemo.model.TestParam;
import com.yuyy.springbootdemo.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author yuyy
 * @date 2020/1/21 11:32
 */

public interface UserService {
    User findUser(int id, TestParam param);
    void cacheEvict();
}
