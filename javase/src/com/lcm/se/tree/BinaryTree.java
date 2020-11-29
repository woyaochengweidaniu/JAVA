package com.lcm.se.tree;

import java.util.LinkedList;

/**
 * 使用三叉链表创建二叉树
 * @author liuchaomin
 * @date 2020/11/29 18:41
 */
public class BinaryTree {

    private BinaryTreeNode root;


    public BinaryTree(BinaryTreeNode BinaryTreeNode){
        this.root = BinaryTreeNode;
    }

    //获取二叉树的结点数
    public int getSize(){
        if (root == null){
            return 0;
        }
        return root.getSize();
    }
    //判断二叉树是否为空
    public boolean isEmpty(){
        return getSize()==0;
    }
    //返回根结点
    public BinaryTreeNode getRoot(){
        return root;
    }
    //返回树的高度
    public int getHeigh(){
        return isEmpty()?0:root.getHeight();
    }

    /***************先序遍历*********************/
    //先根后左在右  可以将结果放在一个list中
    public void preOrderRecusion(BinaryTreeNode root, LinkedList<Object> linkedList){
        if (root == null){
            return;
        }
        linkedList.add(root.getData());
        preOrderRecusion(root.getLChild(),linkedList);
        preOrderRecusion(root.getRChild(),linkedList);
    }
    /***************中序遍历*********************/
    public void inOrderRecursion(BinaryTreeNode root, LinkedList<Object> linkedList){
        if (root == null){
            return;
        }
        inOrderRecursion(root.getLChild(),linkedList);
        linkedList.add(root.getData());
        inOrderRecursion(root.getRChild(),linkedList);
    }
    /***************后序遍历*********************/
    public void postOrderRecursion(BinaryTreeNode root, LinkedList<Object> linkedList){
        if (root == null){
            return;
        }
        postOrderRecursion(root.getLChild(),linkedList);
        postOrderRecursion(root.getRChild(),linkedList);
        linkedList.add(root);
    }

    /********二叉树层序遍历***************************/
    //一层一层的遍历，从左到右，从上到下，可以用队列实现遍历
    public void levelOrderTranverse(BinaryTreeNode root, LinkedList<Object> linkedList){
        if (root == null){
            return;
        }

        //定义一个队列，存储结点
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        //根结点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            linkedList.add(node.getData());
            if (node.hasLChild()){
                queue.offer(node.getLChild());
            }
            if (node.hasRChild()){
                queue.offer(node.getRChild());
            }
        }
    }

    public void preOrder(){
        LinkedList<Object> linkedList = new LinkedList<>();
        preOrderRecusion(root,linkedList);
        System.out.println(linkedList);
    }

    public void inOrder(){
        LinkedList<Object> linkedList = new LinkedList<>();
        inOrderRecursion(root,linkedList);
        System.out.println(linkedList);
    }

    public void postOrder(){
        LinkedList<Object> linkedList = new LinkedList<>();
        postOrderRecursion(root,linkedList);
        System.out.println(linkedList);
    }

    public void levelOrder(){
        LinkedList<Object> linkedList = new LinkedList<>();
        levelOrderTranverse(root,linkedList);
        System.out.println(linkedList);
    }

}
