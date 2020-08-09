package com.yuyy.annotation.资料.src.cn.itcast.annotation.demo;


/**
 * 小明定义的计算器类
 */
public class Calculator {

    //加法
    @Check
    public int add(int param,int param1){
        String str = null;
        str.toString();
        System.out.println("1 + 0 =" + (1 + 0));
        return param+param1;
    }
    //减法
    @Check
    public int sub(int param,int param1){
        return param/param1;
    }
    //乘法
    @Check
    public void mul(){
        System.out.println("1 * 0 =" + (1 * 0));
    }
    //除法
    @Check
    public void div(){
        System.out.println("1 / 0 =" + (1 / 0));
    }


    public void show(){
        System.out.println("永无bug...");
    }

}
