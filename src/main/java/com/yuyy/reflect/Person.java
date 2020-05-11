package com.yuyy.reflect;


import lombok.*;

/**
 * @author yuyy
 * @date 2020/5/5 22:03
 */
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private int age;
    public String a;        //最大范围public
    protected String b;     //受保护类型
    String c;               //默认的访问权限
    private String d;       //私有类型

    //无参构造函数
    public Person() {

    }

    //单个参数的构造函数，且为私有构造方法
    private Person(String name){

    }

    //有参构造函数
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //无参方法
    public void eat(){
        System.out.println("eat...");
    }

    //重载有参方法
    public void eat(String food){
        System.out.println("eat..."+food);
    }

}
