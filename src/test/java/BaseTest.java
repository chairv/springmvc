import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

/**
 * Created by tancw on 2016/1/26.
 */
public class BaseTest {

	@Test
	public void test() {
		Integer orderIndex = 71; // 最小打败值
		Integer orderEnd = 80; // 最大打败值
		Integer sub = orderEnd - orderIndex; // 名次区间
		BigDecimal wealth = new BigDecimal("1800"); // 分数
		BigDecimal min =new BigDecimal("1600"); // 最小分
		BigDecimal max = new BigDecimal("1800"); // 最大分
		// 分数在分数区间占比 * 打败值区间
		Integer orderAdd = (wealth.subtract(min).divide(max.subtract(min),3,BigDecimal.ROUND_UP)).multiply(new BigDecimal(sub)).intValue();
		System.out.println(orderIndex + orderAdd);
	}

	@Test
	public void test1() throws ParseException {
		Date sdate = DateUtils.parseDate("2016-04-01 18:44:44",new String[]{"yyyy-MM-dd HH:mm:SS"});
		Date edate = DateUtils.parseDate("2016-04-01 18:45:44",new String[]{"yyyy-MM-dd HH:mm:SS"});
		System.out.println(sdate.after(edate));
	}

	@Test
	public void test2(){
		BigDecimal b1 = new BigDecimal(100);
		b1.add(new BigDecimal("2"));
		System.out.println(b1.intValue());
	}

	@Test
	public void tstring(){
        String rs = "monthReport201604";
		System.out.println(rs.substring(11));
	}
}
