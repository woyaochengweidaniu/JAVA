package com.lcm.se.sort;

/**
 * @author liuchaomin
 * @date 2020/11/8 18:43
 */
public class SortServiceImpl implements SortService {

    /**
     * 冒泡排序   他的时间复杂都O(N*N)
     *
     * @param ints
     */
    @Override
    public void maoPao(int[] ints) {
        //左右相比 左边比右边大就交换位置  否则不变
        for (int j = 0; j < ints.length; j++) {
            //轮到最后一个数字就不需要比较了所以length-i  并且每循环一次都会排序好一个较大的数字，所以需要length-1-j
            for (int i = 0; i < ints.length - 1 - j; i++) {
                if (ints[i] > ints[i + 1]) {
                    int temp = ints[i + 1];
                    ints[i + 1] = ints[i];
                    ints[i] = temp;
                }
            }
        }

    }

    /**
     * 选择排序比优化了冒泡， 减少了交换次数
     *
     * @param ints
     */
    @Override
    public void xuaZe(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int minIndex = i;  //最小数的下标
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[minIndex] > ints[j]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = ints[i];
                ints[i] = ints[minIndex];
                ints[minIndex] = temp;
            }
        }
    }

    /**
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     * 插入排序非常类似于整扑克牌。在开始摸牌时，左手是空的，牌面朝下放在桌上。接着，一次从
     * 桌上摸起一张牌，并将它插入到左手一把牌中的正确位置上。为了找到这张牌的正确位置，要将
     * 它与手中已有的牌从右到左地进行比较。无论什么时候，左手中的牌都是排好序的。
     * @param arr
     */

    @Override
    public void chaRu(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //插入的数
            int num = arr[i];
            //被插入数的前一个数的下表，也是后面移动被插入的数字下表
            int index = i - 1;

            //如果插入的数字小于前面的数字
            while (index >= 0 && num < arr[index]) {

                //前面的数字向后移
                arr[index+1] = arr[index];
                //插入数的下标向前移动
                index--;
            }

            //插入数放在适合的位置
            arr[index+1] = num;


        }
    }

    @Override
    public void duiXiang(int[] ints) {

    }
}
