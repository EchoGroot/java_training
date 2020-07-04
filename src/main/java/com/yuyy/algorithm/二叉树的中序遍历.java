package com.yuyy.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
 }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        while (root!=null || !treeNodeStack.isEmpty()){
            if (null != root){
                treeNodeStack.push(root);
                root=root.left;
            }else{
                TreeNode treeNode = treeNodeStack.pop();
                result.add(treeNode.val);
                root=treeNode.right;
            }
        }
        return result;
    }
}
