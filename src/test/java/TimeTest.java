import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Created by tancw on 2017/2/16.
 */
public class TimeTest {

    @Test
    public void test() {
        Date now = new Date();
        int hour = get(now, Calendar.HOUR_OF_DAY);
        int min = get(now, Calendar.MINUTE);
        int s = get(now, Calendar.SECOND);
        System.out.println(hour * 60 * 60);
        System.out.println(min * 60);
        System.out.println(s);
    }

    public static int get(Date now, int field) {
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        // 月份加1
        if (Calendar.MONTH == field) {
            return c.get(field) + 1;
        }
        return c.get(field);
    }
}
