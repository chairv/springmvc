package com.sort;

/**
 * Created by tancw on 2017/4/5.
 * 第一趟比较前两个数,然后把第二个数按大小插入有序表中
 * 第二趟把第三个数据与前两个数据从前后扫描,把第三个数按大小插入到有序表中
 */
public class InsertSort {

    static void sort1(int[] r, int n) {
        int j, t;
        for (int i = 1; i < n; i++) {
            t = r[i];
            for (j = i - 1; j >= 0; j--) {
                if (t < r[j]) {
                    r[j + 1] = r[j]; //j=0, j+1= i, 1与0对换  将的值换成前一个数
                } else {
                    break;
                }
            }
            r[j + 1] = t;  //此时j = -1, j[0] = t
            Sort.out(r);
        }
    }

    static void sortFlag(int[] r, int n) {
        int j;
        for (int i = 2; i <= n; i++) {
            if (r[i] < r[i - 1]) {
                r[0] = r[i];
                j = i - 2;   //0
                while (r[0] < r[j]) {
                    r[j + 1] = r[j];
                    j--;
                }
                r[j + 1] = r[0];
            }
            Sort.out(r);
        }
    }

    public static void main(String[] args) {
        int[] r = {53, 26, 48, 11, 13, 48, 32, 15};
        sortFlag(r, 8);
    }
}


