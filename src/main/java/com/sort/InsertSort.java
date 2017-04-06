package com.sort;

import java.util.Arrays;

/**
 * Created by tancw on 2017/4/5.
 * 第一趟比较前两个数,然后把第二个数按大小插入有序表中
 * 第二趟把第三个数据与前两个数据从前后扫描,把第三个数按大小插入到有序表中
 *
 */
public class InsertSort {


    static void sort(int[] r, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            if (r[i] < r[i - 1]) {
                int temp = r[i];
                r[i] = r[i - 1];
                int j = i - 2;
                for (; j > low && temp < r[j]; j--) {
                    r[j + 1] = r[j];
                }
                r[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] r = new int[]{26, 53, 48, 11, 13, 48, 32, 15};
        sort(r, 0, 7);
        System.out.println(Arrays.toString(r));
    }
}


