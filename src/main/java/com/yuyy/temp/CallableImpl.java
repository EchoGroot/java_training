package com.yuyy.temp;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author yuyy
 * @date 2019/9/25 10:55
 */
public class CallableImpl implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random=new Random();
        System.out.println(Thread.currentThread().getName());
        return random.nextInt(10);
    }
}
