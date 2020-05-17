package com.thunisoft.leetcode.y202005.yuyouyang;


/**
 * @author yuyy
 * @date 2020/5/11 22:29
 */
public class BottleDrop {
   
    public static int drop(int bottles,int floors){
        int[][] num=new int[bottles+1][floors+1]; //为了表达更清楚，存储数据下标不从0开始
        for (int i =1; i <= bottles; i++) {
            for(int j=1;j<=floors;j++){
                num[i][j]=j; //最坏情况的次数，例如5个鸡蛋，10层楼，最坏就是摔10次
            }
        }
        for (int i = 2; i <= bottles; i++) { //从两个个鸡蛋开始，因为一个鸡蛋的情况就是最坏的情况，已得出
            for(int j=1;j<=floors;j++){ // 从一楼开始打表
                for(int k=1;k<j;k++){ // 从一楼一直扔到j-1楼，取最小的次数
                    num[i][j]=Math.min(num[i][j],1+Math.max(num[i-1][k-1],num[i][j-k]));
                }
            }
        }
        return num[bottles][floors]; //因数组处理过，下标并不是0开始，可直接取
    }
}
