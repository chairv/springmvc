package com.sort;

import java.util.Arrays;

/**
 * Created by tancw on 2017/4/5.
 * 第一趟比较前两个数,然后把第二个数按大小插入有序表中
 * 第二趟把第三个数据与前两个数据从前后扫描,把第三个数按大小插入到有序表中
 [26, 53, 48, 11, 13, 48, 32, 15]
 [26, 48, 53, 11, 13, 48, 32, 15]
 [11, 26, 48, 53, 13, 48, 32, 15]
 [11, 13, 26, 48, 53, 48, 32, 15]
 [11, 13, 26, 48, 48, 53, 32, 15]
 [11, 13, 26, 32, 48, 48, 53, 15]
 [11, 13, 15, 26, 32, 48, 48, 53]
 */
public class InsertSort {

    static void sort1(int[] r, int n) {
        int i, j, t;
        for (i = 1; i < n; i++) {
            t = r[i];     //53
            for (j = i - 1; j >= 0; j--) {
                /**
                 * 1. j=0,i=1,t=53,r[j]:26
                 * 不满足
                 */
                if (t < r[j]) {
                    r[j + 1] = r[j];
                } else {
                    break;
                }
            }
            r[j + 1] = t;
            System.out.println(Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        int[] r = {26, 53, 48, 11, 13, 48, 32, 15};
        sort1(r, 8);
//        System.out.println(Arrays.toString(r));
    }
}


