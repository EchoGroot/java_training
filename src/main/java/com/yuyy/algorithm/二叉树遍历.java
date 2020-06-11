package com.yuyy.algorithm;

import java.util.LinkedList;
import java.util.Stack;

public class 二叉树遍历 {
    
    public static class Node{
        private Integer val;
        private Node leftChild;
        private Node rightChild;

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node(int val){
            this.val=val;
        }
        
    }

    public void recursivePreOrder(Node root, LinkedList resultList){
        if(null==root){
            return;
        }
        resultList.add(root.val);
        recursivePreOrder(root.leftChild,resultList);
        recursivePreOrder(root.rightChild,resultList);
    }

    public void notRecursivePreOrder(Node root,LinkedList resultList){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            resultList.add(node.val);
            if(null!=node.rightChild){
                stack.push(node.rightChild);
            }
            if(null!=node.leftChild){
                stack.push(node.leftChild);
            }
        }
    }

    public void notRecursiveMidOrder(Node root,LinkedList resultList){
        Stack<Node> stack = new Stack<>();
        while(null!=root||!stack.isEmpty()){
            if(null!=root){
                stack.push(root);
                root=root.leftChild;
            }else{
                Node pop = stack.pop();
                resultList.add(pop.val);
                root=pop.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        二叉树遍历 clazz = new 二叉树遍历();
        Node node = new Node(7);
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(2);
        Node node6 = new Node(4);
        Node node7 = new Node(1);
        Node node8 = new Node(3);
        node.setLeftChild(node1);
        node.setRightChild(node2);
        node1.setRightChild(node4);
        node1.setLeftChild(node3);
        node4.setLeftChild(node5);
        node.setRightChild(node6);
        node6.setLeftChild(node7);
        node7.setRightChild(node8);
        LinkedList<Integer> list = new LinkedList<>();
//        clazz.recursivePreOrder(node,list);
//        clazz.notRecursivePreOrder(node,list);
        clazz.notRecursiveMidOrder(node,list);
        list.forEach(System.out::println);
    }
}
