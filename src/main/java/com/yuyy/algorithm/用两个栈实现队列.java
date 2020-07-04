package com.yuyy.algorithm;
import	java.util.LinkedList;

import java.util.LinkedList;

/**
 * @author yuyy
 * @date 2020/6/26 10:50
 */
public class 用两个栈实现队列 {
    public class CQueue{
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;
        public CQueue() {
            stack1 = new LinkedList<Integer> ();
            stack2 = new LinkedList<Integer> ();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            int result = stack2.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

}
