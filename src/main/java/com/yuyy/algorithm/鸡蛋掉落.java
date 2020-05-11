package com.yuyy.algorithm;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

/**
 * @author yuyy
 * @date 2020/5/11 22:29
 */
@Getter
@Setter
public class 鸡蛋掉落 {
    private Integer totalFloor;
    private Integer totalEgg;
    public int fun(int floor,int egg){
        if(floor<1||egg<1){
            return 0;
        }
        return Math.max(fun(totalFloor-floor,egg),fun(floor-1,egg-1))+1;
    }
    @Test
    public void test(){
        totalFloor=14;
        totalEgg=3;
        System.out.println(fun(totalFloor,totalEgg));
    }

    @Test
    public void countMinStep(){
        int eggs=3;
        int levels=14;
        int[][] counts=new int[eggs+1][levels+1];
        for(int i=1;i<=eggs;i++){
            for(int j=1;j<=levels;j++){
                counts[i][j]=j;
            }
        }
        for(int n=2;n<=eggs;n++){
            for(int m=1;m<=levels;m++){
                for(int k=1;k<m;k++){
                    counts[n][m]=Math.min(counts[n][m], 1+Math.max(counts[n-1][k-1], counts[n][m-k]));
                }
            }
        }
        System.out.println(counts[eggs][levels]);
    }

    @Test
    public void dg(int egg,int floor){
        int[][] num=new int[egg+1][floor+1]; //为了表达更清楚，存储数据下标不从0开始
        for (int i =1; i <= egg; i++) {
            for(int j=1;j<=floor;j++){
                num[i][j]=j; //最坏情况的次数，例如5个鸡蛋，10层楼，最坏就是摔10次
            }
        }
        for (int i = 2; i <= egg; i++) { //从两个个鸡蛋开始，因为一个鸡蛋的情况就是最坏的情况，已得出
            for(int j=1;j<=floor;j++){ // 从一楼开始打表
                for(int k=1;k<j;k++){ // 从一楼一直扔到j-1楼，取最小的次数
                    num[i][j]=Math.min(num[i][j],1+Math.max(num[i-1][k-1],num[i][j-k]));
                }
            }
        }
        System.out.println(num[egg][floor]); //因数组处理过，下标并不是0开始，可直接取
    }
}
