package com.lcm.se.sort;

import java.util.LinkedList;

/**
 * @author liuchaomin
 * @date 2020/11/8 18:43
 */
public class SortServiceImpl implements SortService {

    /**
     * 冒泡排序   他的时间复杂都O(N*N)
     *
     * @param arry
     */
    @Override
    public void maoPao(int[] arry) {
        //左右相比 左边比右边大就交换位置  否则不变
        for (int j = 0; j < arry.length; j++) {
            //轮到最后一个数字就不需要比较了所以length-i  并且每循环一次都会排序好一个较大的数字，所以需要length-1-j
            for (int i = 0; i < arry.length - 1 - j; i++) {
                if (arry[i] > arry[i + 1]) {
                    int temp = arry[i + 1];
                    arry[i + 1] = arry[i];
                    arry[i] = temp;
                }
            }
        }

    }

    /**
     * 选择排序比优化了冒泡， 减少了交换次数
     *
     * @param arry
     */
    @Override
    public void xuaZe(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            int minIndex = i;  //最小数的下标
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[minIndex] > arry[j]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = arry[i];
                arry[i] = arry[minIndex];
                arry[minIndex] = temp;
            }
        }
    }

    /**
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     * 插入排序非常类似于整扑克牌。在开始摸牌时，左手是空的，牌面朝下放在桌上。接着，一次从
     * 桌上摸起一张牌，并将它插入到左手一把牌中的正确位置上。为了找到这张牌的正确位置，要将
     * 它与手中已有的牌从右到左地进行比较。无论什么时候，左手中的牌都是排好序的。
     * 从左到右从小到大
     *
     * @param arr
     */

    @Override
    public void chaRu(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            //插入的数
            int num = arr[i];  //当前数
            //被插入数的前一个数的下表，也是后面移动被插入的数字下表
            int index = i - 1; //前面一个数

            //如果当前数比前面一个数要小，那么前面一个数排在当前数的后面
            while (index >= 0 && num < arr[index]) {
                //前面的数在排在当前数字后面
                arr[index + 1] = arr[index];
                //当前数继续向前
                index--;
            }
            //只到找到自己的位置  index+1
            arr[index + 1] = num;
        }
    }

    @Override
    public void kuaiPai(int[] arry) {
        int low = 0;
        int high = arry.length;
        quickSort(arry,low,high-1);

    }

    /**
     * 思想：        挖坑填数---分治
     *
     * 下面的left  就是一个坑  值是key 从数组取出来，然后  将数组中所有的值比较，如果比key小的在key的左边，比key大的在右边
     *
     * 其实key的下标是最后才确定的，我们通过两个下标相向循环,找到比key小的数和比key大的数，其中用到的就是挖坑，填数
     *
     * @param arry  需要排序的数组
     * @param left 左侧下标
     * @param right 右侧下标
     */
    private void quickSort(int[] arry,int left,int right){
        if (left<right){
            int i = left;
            int j = right;

            //用第一个数挖坑，下面的while循环都是为了找到key在数组中的位置，同时将数据分为比key小的数在他的左边，比他大的数在右边
            int key = arry[left];

            while (i<j){

                //先从右向左找比key小的数
                while (arry[j]>=key&&j>i){
                    //如果没有，j就减一，继续向前找
                    j--;
                }

                if (i<j){
                    //如果有我们就把比key大的数放在i所在的位置，由于我们已经把第一个i的数字取出来了，就是key不用担心数组混乱
                    arry[i] = arry[j];
                    //然后i加一
                    i++;
                }

                //从左向右找比key大的数
                while (arry[i]<key&&i<j){
                    //如果没有i就加1继续向后面找
                    i++;
                }
                if (i<j){
                    //如果找到比key大的数，那么就填到上次j留下的坑中
                    arry[j] = arry[i];
                    //然后j-1缩小范围
                    j--;
                }
                //退出循环就是i=j   也就是我们key的应该所在的位置
            }
            arry[i] = key;
            quickSort(arry,left,i-1);
            quickSort(arry,i+1,right);
        }

    }


}
