package com.lcm.se.tree;


/**
 * 三叉链表存储结构
 *
 * @author liuchaomin
 * @date 2020/11/29 18:02
 */
public class BinaryTreeNode {
    private  Object data; 			//数据域
    private BinaryTreeNode parent;	//父结点指针域
    private BinaryTreeNode lChild;	//左孩子指针域
    private BinaryTreeNode rChild;	//右孩子指针域
    private int height;				//以当前结点为根结点的二叉树的高度
    private int size; 				//以当前结点为根结点的二叉树所有结点的数量

    /********构造方法**********************************/
    //根据指定的数据创建一个结点
    public BinaryTreeNode( Object e) {
        data = e;
        parent = null;
        lChild = null;
        rChild = null;
        height = 1; 			//二叉树的高度是从1开始
        size = 1;
    }
    public BinaryTreeNode() {
        this(null);
    }

    /********判断当前结点的情况**********************************/
    //判断是否有父结点
    public boolean hasParent() {
        return parent != null;
    }
    //判断是否有左孩子
    public boolean hasLChild() {
        return lChild != null;
    }
    //判断是否有右孩子
    public boolean hasRChild() {
        return rChild != null;
    }
    //判断是否为叶子结点
    public boolean isLeaf() {
        return lChild == null && rChild == null;
    }
    //判断是否为父结点的左孩子
    public boolean isLChild() {
        return parent !=null && parent.lChild == this;
    }
    //判断是否为父结点的右孩子
    public boolean isRChild() {
        return parent != null && this == parent.rChild;
    }

    /********与height高度相关的操作**********************************/
    //返回高度
    public int getHeight() {
        return height;
    }
    //更新当前结点的高度, 祖先结点的高度
    public void updateHeight() {
        int  newHeight = 0 ;			//保存新的高度

        //当前结点的高度 为  左子树的高度 或者 右子树的高度 较的那个 再加1
        if (hasLChild() ) {
            newHeight = Math.max(newHeight,  getLChild().getHeight() + 1 );
        }
        if ( hasRChild()) {
            newHeight = Math.max( newHeight,  getRChild().getHeight() + 1 );
        }

        //如果当前结点高度有变化,递归更新祖先结点的高度
        if (newHeight == height) {
            //刚刚计算出来的高度与原来的高度一样, 不需要更新祖先的高度
            return;
        }
        //把新的高度作为当前结点的高度
        height = newHeight;
        //更新祖先结点的高度
        if ( hasParent()) {
            getParent().updateHeight();
        }
    }

    /********与size结点个数相关的操作**********************************/
    //返回以当前结点为根的二叉树的结点数
    public int getSize() {
        return size;
    }
    //更新当前结点及祖先的结点数
    public void updateSize() {
        size = 1; 			//当前结点本身
        //累加左子树的结点数
        if (hasLChild()) {
            size += getLChild().getSize();
        }
        //累加右子树的结点数
        if (hasRChild()) {
            size += getRChild().getSize();
        }
        //递归更新祖先结点数
        if ( hasParent() ) {
            getParent().updateSize();
        }
    }

    /************与父结点相关的操作*****************************/
    //返回父结点
    public BinaryTreeNode getParent() {
        return parent;
    }
    //断开与父结点的关系
    public void disInheritence() {
        //如果没有父结点
        if ( !hasParent() ) {
            return;
        }

        //修改父结点的左孩子 或右孩子 为null
        if ( isLChild() ) { 		//当前结点是父结点的左孩子
            parent.lChild = null;
        }else if (isRChild()) {
            parent.rChild = null; 		//当前结点是右孩子
        }

        parent.updateHeight(); 		//更新父结点的高度
        parent.updateSize(); 		//更新结点数
        parent = null; 				//修改当前结点的父结点指针
    }


    /************与左孩子 相关的操作*****************************/
    //返回左孩子
    public BinaryTreeNode getLChild() {
        return lChild;
    }
    //设置当前结点的左孩子 , 把原来的左孩子返回
    public BinaryTreeNode setLChild(BinaryTreeNode newLChild) {
        BinaryTreeNode oldLChild = this.lChild; 			//保存原来的左孩子
        //先断开当前结点的左孩子
        if ( hasLChild()) {
            lChild.disInheritence();
        }
        //设置新的左孩子为参数结点
        if (newLChild != null ) {
            newLChild.disInheritence(); 	//先把参数结点断开与原来父结点的关系
            this.lChild = newLChild; 		//把参数结点设置左孩子
            newLChild.parent = this; 		//设置参数结点的父结点
            this.updateHeight();
            this.updateSize();
        }

        return oldLChild ;			//返回原来的左孩子结点
    }


    /************与右孩子 相关的操作*****************************/
    //返回右孩子
    public BinaryTreeNode getRChild() {
        return rChild;
    }
    //设置右孩子
    public BinaryTreeNode setRChild(BinaryTreeNode newRChild) {
        BinaryTreeNode old = this.rChild ;		//保存原来的右孩子
        //断开右孩子 结点
        if ( hasRChild() ) {
            rChild.disInheritence();
        }
        //设置右孩子结点
        if ( newRChild != null ) {
            newRChild.disInheritence(); 	//参数结点先断开与原来父结点的关系
            this.rChild = newRChild; 		//设置当前结点的右孩子
            newRChild.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return old;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
