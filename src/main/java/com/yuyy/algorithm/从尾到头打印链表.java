package com.yuyy.algorithm;

import java.util.Stack;

public class 从尾到头打印链表 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(null!=head){
            stack.push(head.val);
            head=head.next;
        }
        int[] ints = new int[stack.size()];
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            ints[i]=stack.pop();
        }
        return ints;
    }

    private int[] arr;
    private int k;
    private int size;
    public int[] reversePrint1(ListNode head) {
        k=0;
        size=0;
        dg(head);
        return arr;
    }

    public void dg(ListNode listNode){
        size++;
        if(null==listNode){
            arr=new int[--size];
            return;
        }
        dg(listNode.next);
        arr[k++]=listNode.val;
    }

    public ListNode create(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2= new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next=listNode1;
        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
        return listNode;
    }

    public static void main(String[] args) {
        从尾到头打印链表 clazz = new 从尾到头打印链表();
        int[] arr=clazz.reversePrint1(clazz.create());
//        int[] arr=clazz.reversePrint(new ListNode(1));
        for (int i = 0; i < clazz.k; i++) {
            System.out.println(arr[i]);
        }
    }
}
