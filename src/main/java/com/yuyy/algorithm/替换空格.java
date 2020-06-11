package com.yuyy.algorithm;

public class 替换空格 {
    public String replaceSpace(String s) {
        if(s.length()==0){
            return s;
        }
        int spaceCount=0;
        for (int i = 0; i < s.length(); i++) {
            if(' '==(s.charAt(i))){
                spaceCount++;
            }
        }
        int k=s.length()+spaceCount*2-1;
        char[] arr=new char[k+1];
        for (int i = s.length()-1; i >=0 ; i--) {
            if(' '==(s.charAt(i))){
                arr[k--]='0';
                arr[k--]='2';
                arr[k--]='%';
            }else{
                arr[k--]=s.charAt(i);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        替换空格 clazz=new 替换空格();
        System.out.println(clazz.replaceSpace("We are happy."));
        System.out.println(clazz.replaceSpace("a s d"));
    }
}
