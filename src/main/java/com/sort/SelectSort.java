package com.sort;


/**
 * Created by tancw on 2017/4/7.
 * 比如在一个长度为N的无序数组中，在第一趟遍历N个数据，
 * 找出其中最小的数值与第一个元素交换，第二趟遍历剩下的N-1个数据，
 * 找出其中最小的数值与第二个元素交换......第N-1趟遍历剩下的2个数据，
 * 找出其中最小的数值与第N-1个元素交换，至此选择排序完成
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] r = {53, 26, 48, 11, 13, 48, 32, 15};
        int index;
        int n = r.length;
        for (int i = 0; i < n; i++) {
            index = i;
            for (int j = i + 1; j < n; j++) {
                //把出最小的数的位置
                if (r[index] > r[j]) {
                    index = j;
                }
            }
            //最小数位置与i交换
            if (i != index) Sort.swap(r, i, index);
            Sort.out(r);
        }
    }
}
