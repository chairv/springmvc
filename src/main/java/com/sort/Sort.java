package com.sort;

import java.util.Arrays;

/**
 * Created by tancw on 2017/4/7.
 */
public class Sort {

    public static void swap(int[] ary, int a, int b) {
        int tmp = ary[a];
        ary[a] = ary[b];
        ary[b] = tmp;
    }

    public static void out(int[] r) {
        System.out.println(Arrays.toString(r));
    }
}
