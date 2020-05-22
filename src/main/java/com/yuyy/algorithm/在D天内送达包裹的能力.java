package com.yuyy.algorithm;

public class 在D天内送达包裹的能力 {

    public int shipWithinDays(int[] weights, int D) {
        int sum=0;
        for (int i = 0; i < weights.length; i++) {
            sum+=weights[i];
        }
        int low=weights[weights.length-1];
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
        int days=0;
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


}
