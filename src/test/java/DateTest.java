import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

/**
 * Created by tancw on 2016/2/16.
 */
public class DateTest {
	Date now = new Date();

	@Test
	public void test() {
		Date date = new Date();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		System.out.println(c1.get(Calendar.MONTH));
	}

	@Test
	public void test2() {
		for (int i = 0, j = 1; i < 10; i++, j++) {
			System.out.println(i);
			System.out.println(j);
		}
	}

	@Test
	public void test3() throws ParseException {
		Date date1 = DateUtils.parseDate("20151231", new String[] { "yyyyMMdd" });
		System.out.println(date1);
	}

	@Test
	public void testTrun() {
		Date now = new Date();
		Date d2 = DateUtils.addYears(now, 1);
		System.out.println(DateUtils.truncatedEquals(now, d2, Calendar.YEAR));
	}

	@Test
	public void test4() {
		System.out.println(DateUtils.truncate(now, 5));
	}

	@Test
	public void add() throws ParseException {
		Date date = DateUtils.parseDate("2016-11-11", new String[] { "yyyy-MM-dd" });
		Date date2 = DateUtils.parseDate("2016-01-30", new String[] { "yyyy-MM-dd" });
		System.out.println(DateUtils.addDays(date, -27));
	}

	@Test
	public void testTime() {
		Long dt = System.currentTimeMillis();
		System.out.println(dt);

		Long dtlong = 1504683344536L;
		System.out.println(new Date(dtlong));

		String state = "dssf_stime" + dtlong;
		System.out.println(state);
		System.out.println(StringUtils.contains(state, "_stime"));
		System.out.println(new Date(Long.parseLong(StringUtils.substringAfter(state, "_stime"))));
		System.out.println(StringUtils.substringBefore(state, "_stime"));
	}

	@Test
	public void testTimer() {
		Timer noteTask = new Timer();
		System.out.println("1");
		noteTask.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("1");
			}
		}, 1000);
		try {
			Thread.sleep(1000 * 2L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBase64() {
		String str = "http://pimwx.ittun.com/share/sharePmbox?dreamId=101126&state=share_101126";
		try {
			byte[] encodeByte = java.util.Base64.getEncoder().encode(str.getBytes("UTF-8"));
			String d = new String(encodeByte, "UTF-8");

			byte[] decodeByte = java.util.Base64.getDecoder().decode(d);
            System.out.println(new String(decodeByte,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
