package com.yuyy.annotation;
import java.lang.annotation.*;

/**
 * description:  这是一个注解<br>
 * version: 1.0 <br>
 * date: 2020/7/12 15:42 <br>
 * author: objcat <br>
 * 
 * @param null
 * @return 
 */ 
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno1 {
    String name();
    int age();
}
