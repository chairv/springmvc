package com.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tancw on 2016/10/12.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList();
        for (int i = 0; i < 249; i++) {
            nums.add(i);
        }
        System.out.println(nums);
        int listSize = nums.size();
        int itemSize = 200;
        int start = 0;
        int itemCnt = listSize % itemSize == 0 ? listSize / itemSize : (listSize / itemSize) + 1;
        System.out.println("itemCnt:" + itemCnt);
        for (int i = 1; i <= itemCnt; i++) {
            int preEnd = i * itemSize;
            int end = preEnd > listSize ? listSize : preEnd;
            System.out.println("start: " + start + ",end:" + end);
            List<Integer> subList = nums.subList(start, end);
            System.out.println(subList);
            if (end == listSize) break;
            start = end;
        }


    }


}
