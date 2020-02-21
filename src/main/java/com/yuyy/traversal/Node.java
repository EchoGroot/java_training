package com.yuyy.traversal;

/**
 * @author yuyy
 * @date 2019/9/20 13:02
 */
public class Node {
    private Node left;
    private Node right;
    private int val;

    public Node(Node left, Node right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
