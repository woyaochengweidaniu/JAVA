package com.lcm.se.sort;

/**
 * @author liuchaomin
 * @date 2020/11/8 18:39
 */
public interface SortService {
    //接口中方法的修饰符默认是public  缺省


    /**
     * 冒泡排序
     * @param ints
     */
     void maoPao(int[] ints);

    /**
     * 选择排序
     * @param ints
     */
     void xuaZe(int[] ints);

    /**
     * 插入排序
     * @param ints
     */
     void chaRu(int[] ints);


    /**
     * 快速排序
     * @param ints  数组
     */
     void kuaiPai(int[] ints);





}
