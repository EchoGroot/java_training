package com.yuyy.algorithm;

import org.junit.jupiter.api.Test;

public class 在D天内送达包裹的能力 {

    public int shipWithinDays(int[] weights, int D) {
        int sum=0;
        int max=0;
        for (int i = 0; i < weights.length; i++) {
            sum+=weights[i];
            max=max<weights[i]?weights[i]:max;
        }
        int low=max;
        int heigh=sum;
        while(low<=heigh){
            int mid=low+((heigh-low)>>1);
            if(fun(mid,weights)>D){
                low=mid+1;
            }else{
                heigh=mid-1;
            }
        }
        return heigh+1;
    }

    public static int fun(int minWeight,int[] weights){
        int weight=0;
        int days=1;
        for (int i=0;i<weights.length;i++){
            if((weight+weights[i])>minWeight){
                days++;
                weight=weights[i];
            }else{
                weight+=weights[i];
            }
        }
        return days;
    }

    @Test
    public void test(){
//        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] arr=new int[]{1,2,3,1,1};
//        int d=5;
        int d=4;
        在D天内送达包裹的能力 clazz = new 在D天内送达包裹的能力();
        System.out.println(clazz.shipWithinDays(arr,d));
    }
}
