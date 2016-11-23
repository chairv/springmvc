package com.drools;

/**
 * Created by tancw on 2016/11/23.
 */
public class PointDomain {
	private String username;
	private boolean birthDay;
	private long point;
	private int buyNums;
	private int backNums;
	private double buyMoney;
	private double backMondy;
	private int billThisMonth;

	public void recordPointLog(String username, String type) {
		System.out.println("增加对" + username + "的类型为" + type + "的积分操作记录");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isBirthDay() {
		return birthDay;
	}

	public void setBirthDay(boolean birthDay) {
		this.birthDay = birthDay;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	public int getBuyNums() {
		return buyNums;
	}

	public void setBuyNums(int buyNums) {
		this.buyNums = buyNums;
	}

	public int getBackNums() {
		return backNums;
	}

	public void setBackNums(int backNums) {
		this.backNums = backNums;
	}

	public double getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(double buyMoney) {
		this.buyMoney = buyMoney;
	}

	public double getBackMondy() {
		return backMondy;
	}

	public void setBackMondy(double backMondy) {
		this.backMondy = backMondy;
	}

	public int getBillThisMonth() {
		return billThisMonth;
	}

	public void setBillThisMonth(int billThisMonth) {
		this.billThisMonth = billThisMonth;
	}
}
