package com.yuyy.springbootdemo.model;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author yuyy
 * @date 2020/2/1 15:08
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//产生的setter返回的this而不是void
public class TestParam {
    private Integer a;
    private Integer b;
    private Integer c;


}
