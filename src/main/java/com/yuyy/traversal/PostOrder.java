package com.yuyy.traversal;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author yuyy
 * @date 2019/9/20 13:01
 */
public class PostOrder {
    public Node init(){
        Node I=new Node(null,null,8);
        Node H=new Node(null,null,4);
        Node G=new Node(null,null,2);
        Node F=new Node(null,I,7);
        Node E=new Node(H,null,5);
        Node D=new Node(null,G,1);
        Node C=new Node(F,null,9);
        Node B=new Node(D,E,3);
        Node A=new Node(B,C,6);
        return A;
    }

    /**
     * 后序非递归
     * @param root
     * @return
     */
    public LinkedList get(Node root){
        Stack<Node> stack=new Stack<>();
        LinkedList<Integer> result=new LinkedList<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while(!stack.empty()){
            Node cur=stack.pop();
            result.add(0,cur.getVal());
            if (cur.getLeft()!=null){
                stack.push(cur.getLeft());
            }
            if (cur.getRight()!=null){
                stack.push(cur.getRight());
            }
        }
        return result;
    }

    /**
     * 后续递归
     * @param root
     * @param result
     */
    public void recursive(Node root,LinkedList result){
        if (null==root){
            return;
        }
        recursive(root.getLeft(),result);
        recursive(root.getRight(),result);
        result.add(root.getVal());
    }

}
