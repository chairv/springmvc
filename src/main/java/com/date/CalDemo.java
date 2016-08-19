package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * Created by tancw on 2016/8/19.
 */
public class CalDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Calendar c = DateUtils.truncate(calendar,2);
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.printf(f.format(c.getTime()));
    }
}
