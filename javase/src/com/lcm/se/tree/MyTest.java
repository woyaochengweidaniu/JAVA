package com.lcm.se.tree;

/**
 * 二叉树前，中，后序遍历  测试
 * @author liuchaomin
 * @date 2020/11/29 18:58
 */
public class MyTest {

    public static void main(String[] args) {
        //创建根结点
        BinaryTreeNode root = new BinaryTreeNode("oo");


        //创建两个结点设置为root根结点的左孩子 和右孩子
        BinaryTreeNode xx = new BinaryTreeNode("xx");
        BinaryTreeNode yy = new BinaryTreeNode("yy");
		root.setLChild(xx);
		root.setRChild(yy);

        //创建两个结点, 作为xx结点的左孩子 和右孩子
        BinaryTreeNode xl = new BinaryTreeNode("xll");
        BinaryTreeNode xr = new BinaryTreeNode("xrr");
		xx.setLChild(xl);
		xx.setRChild(xr);

        //创建一个结点作为yy结点的右孩子
        BinaryTreeNode yr = new BinaryTreeNode("yrr");
		yy.setRChild(yr);

        //创建二叉树
        BinaryTree tree = new BinaryTree(root);
        //先序遍历
        tree.preOrder();  //[oo, xx, xll, xrr, yy, yrr]
        //中序遍历
        tree.inOrder();
        //后序遍历
        tree.postOrder();
        //层序遍历
        tree.levelOrder();
    }




}
