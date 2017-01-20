package com.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * Created by tancw on 2016/8/19.
 */
public class CalDemo {
	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		// System.out.println(now);
		//
		 Calendar c = Calendar.getInstance();
		 c.setTime(now);
	     c.set(Calendar.DAY_OF_WEEK,2);
		 c.add(Calendar.DAY_OF_YEAR,7);
		// c.add(Calendar.MONTH,1);
		// System.out.println(c.getTime());
//		System.out.println(DateUtils.truncate(now, Calendar.DAY_OF_MONTH));
		System.out.println(DateFormatUtils.format(c,"yyyy-MM-dd"));
	}

}
