package com.rand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tancw on 2016/12/1.
 */
public class Demo {

	public static void main(String[] args) {
		float[] radio = { 10, 11, 11, 10, 10, 10, 10, 9, 8, 5, 3, (float) 1.5, 1, (float) 0.5 };
		List<Float> list = new ArrayList<Float>();

		int max = 100000;
        float begin = 0f;
		for (int index = 0; index < radio.length; index++) {
			float num = radio[index] * max / 100;
			begin += num;
			list.add(begin);
		}
		System.out.println(list);
        int rand = new Random().nextInt(max - 1) + 1;
        System.out.println(rand);
    }
}
