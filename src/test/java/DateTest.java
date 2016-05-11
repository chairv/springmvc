import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

/**
 * Created by tancw on 2016/2/16.
 */
public class DateTest {

	@Test
	public void test() {
		Date date = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        System.out.println(c1.get(Calendar.MONTH));
    }

    @Test
    public void test2(){
        for(int i = 0,j=1;i < 10;i++,j++){
            System.out.println(i);
            System.out.println(j);
        }
    }

    @Test
    public void test3() throws ParseException {
        Date date1 = DateUtils.parseDate("20151231",new String[]{"yyyyMMdd"});
        System.out.println(date1);
    }
}
