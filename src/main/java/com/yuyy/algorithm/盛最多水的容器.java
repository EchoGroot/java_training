package com.yuyy.algorithm;

/**
 * @author yuyy
 * @date 2020/5/17 22:46
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int j = 0;
            while (true) {
                int flag=0;
                if(j<i){
                    if (height[j] >= height[i]) {
                        ans=Math.max(ans,height[i] * (i - j));
                        break;
                    }
                }else{
                    flag++;
                }
                if(height.length-j-1>i){
                    if (height[height.length-j-1] >= height[i]) {
                        ans=Math.max(ans,height[i] * (height.length-j-1-i));
                        break;
                    }
                }else{
                    flag++;
                }
                if(flag==2){
                    break;
                }
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        盛最多水的容器 cla=new 盛最多水的容器();
        System.out.println(cla.maxArea(new int[]{1,1}));
    }
}
