package com.eygo;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.Random;

/**
 * Created by tancw on 2016/4/19. 10000001 + (sum(50 times) + randomNumber) %totalCount;
 */
public class CalculationWin {
	final int orgNumber = 10000001;

	public long getWinCode() {
		long sumTimes = 0;
		for (int i = 0; i <= 50; i++) {
			int time = timeNumber();
			sumTimes += time;
		}
		System.out.println("50 sum times: " + sumTimes);
		Random random = new Random();
		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

		System.out.println("random number: " + rannum);

		return ((sumTimes + rannum) % 2999) + 10000001;
	}

	public int timeNumber() {
		Date date = new Date();
		return Integer.parseInt(DateFormatUtils.format(date, "HHmmssS"));
	}

	public static void main(String[] args) {
		// 10219824 10460218 10806809 10845736
		// System.out.println(12185911302L%1708888);
		Date date = new Date();
		String min = DateFormatUtils.format(date, "HHmmssS");
		//System.out.println(min);
		float nowNumber = 12185911302L;
		int result = 0;
		while (true) {
			nowNumber += result;
            if(nowNumber%1708888 == 219824 ){
				System.out.println(result/1000/60);
				break;
			}
			result += 1;
		}
	}

}
