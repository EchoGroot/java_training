package com.yuyy.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历 {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        if(null == root){
            return result;
        }
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()){
            TreeNode treeNode = treeNodeStack.pop();
            result.add(treeNode.val);
            if(null != treeNode.right){
                treeNodeStack.push(treeNode.right);
            }
            if(null != treeNode.left){
                treeNodeStack.push(treeNode.left);
            }
        }
        return result;
    }
}
