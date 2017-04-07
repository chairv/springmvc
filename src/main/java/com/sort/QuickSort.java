package com.sort;

/**
 * Created by tancw on 2017/4/7.
 * 快速排序
 * O(N*logN)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] r = {53, 26, 48, 11, 13, 48, 32, 15};
        qsort(r, 0, 7);
        Sort.out(r);
    }

    static void qsort(int[] ary, int low, int high) {
        if (low < high) {
            int privotloc = partition(ary, low, high);
            qsort(ary, low, privotloc - 1);
            qsort(ary, privotloc + 1, high);
        }
    }

    /**
     * 取一个数做基准数
     * 分区过程,将比这个数大的放到右边,小的放左边
     * 再对左右区间重复第二步,直到各区间只有一个数
     * @param ary
     * @param low
     * @param high
     * @return
     */
    static int partition(int[] ary, int low, int high) {
        int baseKey = ary[low];  //基准元素  ary[low]成为第一个坑
        while (low < high) {
            //从右向左找小于x的数来填ary[low]
            while (low < high && ary[high] > baseKey) high--;
            //将大于基数的值放到基数位...ary[low]坑填了,此时high坑出来
            if (low < high) ary[low++] = ary[high];
            //low++表示从low 前后面 到high
            while (low < high && ary[low] < baseKey) low++;
            if (low < high) ary[high--] = ary[low];

        }
        ary[low] = baseKey;
        Sort.out(ary);
        return low;
    }

}
