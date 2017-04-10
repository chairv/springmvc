package com.sort;


/**
 * Created by tancw on 2017/4/10.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] r = {1, 3, 9, 12, 32, 41, 45, 62, 75, 77, 82, 95, 100};
        System.out.println(search(r, 82));
    }

    static int search(int[] r, int num) {
        int low = 0;
        int high = r.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.printf("%d,%d\n",mid,r[mid]);
            if (num == r[mid]) {
                return mid;
            } else if (num < r[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
