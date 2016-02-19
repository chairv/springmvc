import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tancw on 2016/2/16.
 */
public class DateTest {

	@Test
	public void test() {
		Date date = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        System.out.println(c1.get(Calendar.ERA));
    }
}
