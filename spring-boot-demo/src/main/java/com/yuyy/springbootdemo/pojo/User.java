package com.yuyy.springbootdemo.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author yuyy
 * @date 2020/1/21 11:20
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//产生的setter返回的this而不是void
public class User {
    private Integer id;
    private String name;
    private String age;
}
