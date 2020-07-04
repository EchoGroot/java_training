package com.yuyy.algorithm;

import java.util.Stack;

/**
 * @author yuyy
 * @date 2020/6/26 15:09
 */
public class 验证二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public class TreeNode1 {
        Integer val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1 parent;
        Boolean isLeftChild;

        TreeNode1(int val,TreeNode1 parent,Boolean isLeftChild) {
            this.val = val;
            this.parent=parent;
            this.isLeftChild=isLeftChild;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(null == root){
            return true;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<TreeNode1> nodeStack1 = new Stack<>();
        nodeStack.push(root);
        nodeStack1.push(new TreeNode1(root.val,null,null));
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            TreeNode1 node1 = nodeStack1.pop();
            if(!isSearchTree(node1,node1.val)){
                return false;
            }
            if (node.right!=null){
                nodeStack.push(node.right);
                node1.right=new TreeNode1(node.right.val,node1,false);
                nodeStack1.push(node1.right);
            }
            if(node.left!=null){
                nodeStack.push(node.left);
                node1.left=new TreeNode1(node.left.val,node1,true);
                nodeStack1.push(node1.left);
            }
        }
        return true;
    }

    public boolean isSearchTree(TreeNode1 node,int val){
        if(null== node.parent){
            return true;
        }
        if (node.isLeftChild){
            if(val<node.parent.val){
                return isSearchTree(node.parent,val);
            }
        }else{
            if(val>node.parent.val){
                return isSearchTree(node.parent,val);
            }
        }
        return false;
    }
}
