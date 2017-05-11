package com.sort;

/**
 * Created by tancw on 2017/4/17.
 * 归并排序的思想:把待排序的记录序列分成若干个字符列
 * 先将每个子序列的记录排序,再将已排序的子序列合并,得到
 * 完成排序的记录序列,归并排序可分为多路归并排序各二路
 * 归并排序
 */
public class MergeSort {
    /**
     * 二路归并排序的算法思路:
     *   对任意长度为n的序列,首先看成是n个长度为1的有序
     *   序列,然后两两归并为n/2个有序表,再对n/2个有序表两两归并
     *   直到得到一个长度为n的有序表
     */
    public static void mergerTwoWay(int[] ary,int low,int high){

    }


    public static void main(String[] args) {
        int x[] = {0,5,-2,1,-8,7,6,-3};
        mergerTwoWay(x,0,7);
    }
}
