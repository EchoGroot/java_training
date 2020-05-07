package com.yuyy.algorithm;

import java.util.Scanner;

/**
 * @author yuyy
 * @date 20-3-25 下午12:40
 */
public class 三维形体的表面积 {
    public int surfaceArea(int[][] grid) {
        int sum=0;
        int[][][] arr=new int[51][51][51];
//        赋初值
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                for(int k=0;k<grid[i][j];k++){
                    arr[i][j][k]=1;
                }
            }
        }
//        开始计算面积
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(arr[i][j][0]!=0)sum+=2;
                for(int k=0;arr[i][j][k]!=0;k++){
                    if(j==0)sum++;
                    if(j>0&&arr[i][j-1][k]==0)sum++;
                    if(j<50&&arr[i][j+1][k]==0)sum++;
                    if(i==0)sum++;
                    if(i>0&&arr[i-1][j][k]==0)sum++;
                    if(i<50&&arr[i+1][j][k]==0)sum++;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[][] arr={{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(new 三维形体的表面积().surfaceArea(arr));
    }
}
