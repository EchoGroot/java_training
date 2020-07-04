package com.yuyy.algorithm;

import org.junit.jupiter.api.Order;

import java.util.*;
import java.util.logging.Level;

public class 重建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preorder.length == 0 ? null : buildNode(preorder, inorder);
    }

    public TreeNode buildNode(int[] preorder, int[] inorder) {
        int rootNodeIndex = -1;
        int rootNodeValue = 0;
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }

        for (int i = 0; i < preorder.length; i++) {
                if (null != inorderMap.get(preorder[i])) {
                    rootNodeIndex = inorderMap.get(preorder[i]);
                    rootNodeValue = preorder[i];
                    break;
                }
        }

        TreeNode treeNode = new TreeNode(rootNodeValue);
        treeNode.left = rootNodeIndex > 0 ?
                buildNode(preorder, Arrays.copyOfRange(inorder, 0, rootNodeIndex)) :
                null;
        treeNode.right = rootNodeIndex < inorder.length - 1 ?
                buildNode(preorder, Arrays.copyOfRange(inorder, rootNodeIndex + 1, inorder.length)) :
                null;
        return treeNode;
    }

    public static void main(String[] args) {
        重建二叉树 clazz = new 重建二叉树();
        TreeNode treeNode = clazz.buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
