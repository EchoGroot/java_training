package com.yuyy.io.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Person implements Serializable {
    private String username;
    private Integer age;
    private transient String password;
    public static String adas="das";
}
