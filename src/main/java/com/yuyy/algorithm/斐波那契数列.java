package com.yuyy.algorithm;

/**
 * @author yuyy
 * @date 2020/6/26 12:04
 */
public class 斐波那契数列 {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int[] arr=new int[n+1];
//        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <= n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
            if(arr[i]>1000000007){
                arr[i]%=1000000007;
            }
        }
        return arr[n];
    }
}
