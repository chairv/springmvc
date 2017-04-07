package com.sort;

/**
 * Created by tancw on 2017/4/7.
 * <p>
 * 冒泡排序:
 * 临近的数字两两进行比较,按照从小到大或者从大到小的顺序进行交换
 * 时间复杂度:
 */
public class MaopiaoSort {
    public static void main(String[] args) {
        int[] ary = {26, 53, 48, 11, 13, 48, 32, 15};
        sortBase(ary);
    }

    static void sortBase(int[] ary) {
        int n = ary.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ary[j] < ary[i]) {
                    Sort.swap(ary, i, j);
                }
            }
            Sort.out(ary);
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
                    Sort.swap(ary, j, j - 1);
                    flag = true;
                }
            }
            Sort.out(ary);
        }
    }
}
