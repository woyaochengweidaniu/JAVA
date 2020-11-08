package com.lcm.se.sort;

/**
 * @author liuchaomin
 * @date 2020/11/8 18:38
 */
public class MySort {

    public static final int[] ints = new int[]{9,3,5,1,6,4};

    public static void main(String[] args) {

        SortService sortService = new SortServiceImpl();


//        sortService.maoPao(ints);
//        sortService.xuaZe(ints);
        sortService.chaRu(ints);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }



}
