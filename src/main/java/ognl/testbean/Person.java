package ognl.testbean;

import java.util.Date;

public class Person {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 人员出生日期
    private Date birthday;

    //属性的getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
