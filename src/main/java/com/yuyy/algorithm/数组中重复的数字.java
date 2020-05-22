package com.yuyy.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        int[] arr=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(arr[nums[i]]!=0){
                return nums[i];
            }else{
                arr[nums[i]]++;
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        int temp=0;
        int i=0;
        while(true){
            if(nums[i]==i){
                i++;
            }else{
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }else{
                    temp=nums[i];
                    nums[i]=nums[nums[i]];
                    nums[temp]=temp;
                }
            }
        }
    }

    public int findRepeatNumber2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if(nums[i] == nums[nums[i]])
                    return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        数组中重复的数字 c=new 数组中重复的数字();
        System.out.println(c.findRepeatNumber(new int[]{5,6,5,2,4,6,3,8,4,5}));
    }
}
