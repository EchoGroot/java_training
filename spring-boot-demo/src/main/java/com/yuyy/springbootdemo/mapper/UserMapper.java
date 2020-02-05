package com.yuyy.springbootdemo.mapper;

import com.yuyy.springbootdemo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author yuyy
 * @date 2020/1/21 11:26
 */

public interface UserMapper {
    User findUser(int id);
}
