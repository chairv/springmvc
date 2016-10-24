package com.collections;

/**
 * Created by tancw on 2016/10/12.
 */
public class ListDemo {
	public static void main(String[] args) {
		ListDemo demo = new ListDemo();
		try {
			for (int i = 0; i < 100; i++) {
				demo.check(i);
			}
		}catch (Exception e){
			 System.out.println(e);
			 return;
		}
		System.out.println("over");
	}

	private void check(int i) throws Exception {
		if (i == 50) {
			throw new NullPointerException();
		}
		System.out.println(i);
	}

}
