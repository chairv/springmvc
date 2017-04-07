package com.sort;

import java.util.Arrays;

/**
 * Created by tancw on 2017/4/7.
 */
public class MaopiaoSort {
    public static void main(String[] args) {
        int[] ary = {26, 53, 48, 11, 13, 48, 32, 15};
        sortUp(ary);
//        System.out.println(Arrays.toString(ary));
    }

    static void sortBase(int[] ary) {
        int n = ary.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ary[j] < ary[i]) {
                    int tmp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = tmp;
                }
            }
        }
    }

    static void sortUp(int[] ary) {
        int i, j;
        int n = ary.length;
        boolean flag = true;
        for (i = 1; i < n && flag; i++) {
            flag = false;
            for (j = n - 1; j >= i; j--) {
                if (ary[j - 1] > ary[j]) {
                    int temp = ary[j];
                    ary[j] = ary[j - 1];
                    ary[j - 1] = temp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(ary));
        }
    }
}
