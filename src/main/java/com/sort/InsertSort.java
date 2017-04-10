package com.sort;

/**
 * Created by tancw on 2017/4/5.
 * 第一趟比较前两个数,然后把第二个数按大小插入有序表中
 * 第二趟把第三个数据与前两个数据从前后扫描,把第三个数按大小插入到有序表中
 */
public class InsertSort {

    /**
     * 第一趟:  i = 1, t = r[1] = 26,
     * j=i-1=0; r[0]=53,
     * 判断 t < r[j] 即 26 < 53 则 r[i] = r[0],j-- = -1
     * r[-1+1=0] = t;
     *
     * @param r
     * @param n
     */
    static void sort1(int[] r, int n) {
        int j, t;
        for (int i = 1; i < n; i++) {
            t = r[i];
            for (j = i - 1; j >= 0 && t < r[j]; j--) {
                r[j + 1] = r[j];
            }
            r[j + 1] = t;  //此时j = -1, j[0] = t
            Sort.out(r);
        }
    }

    static void sortFlag(int[] r, int n) {
        int j, t;
        for (int i = 1; i < n; i++) {
            t = r[i];
            for (j = i - 1; j >= 0; j--) {
                if (t < r[j]) {
                    r[j + 1] = r[j];
                }else{
                    break;
                }
            }
            r[j + 1] = t;
            Sort.out(r);
        }
    }


    public static void main(String[] args) {
        int[] r = {53, 26, 48, 11, 13, 48, 32, 15};
        sortFlag(r, 8);
    }
}


