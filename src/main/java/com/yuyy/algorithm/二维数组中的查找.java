package com.yuyy.algorithm;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length-1<0||matrix[i][0]>target||matrix[i][matrix[i].length-1]<target){
                continue;   
            }
            int low=0;
            int heigh=matrix[0].length-1;
            while(low<=heigh){
                int mid=low+((heigh-low)>>1);
                if(matrix[i][mid]>target){
                    heigh=mid-1;
                }else if(matrix[i][mid]<target){
                    low=mid+1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        二维数组中的查找 cla=new 二维数组中的查找();
//        System.out.println(cla.findNumberIn2DArray(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
        System.out.println(cla.findNumberIn2DArray(new int[][]{{}},1));
    }
}
