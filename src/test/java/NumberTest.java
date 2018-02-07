import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Created by tancw on 2016/11/15.
 */
public class NumberTest {

    @Test
    public void test() {
        BigDecimal b = new BigDecimal("20.12312312");
        System.out.println(b.setScale(2));
    }

    @Test
    public void testFormat() {
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMinimumFractionDigits(2);
//        System.out.println(format.format(17.2/100.0));


        BigDecimal number = new BigDecimal("0.16");
        System.out.println(format.format(number.doubleValue()));
    }

    @Test
    public void bigInt() {
        BigDecimal bigDecimal = new BigDecimal("1.5");
        System.out.println(bigDecimal.toPlainString());
        System.out.println(StringUtils.capitalize("name"));
    }

    @Test
    public void bigFormat() {
        DecimalFormat percentageFormat = new DecimalFormat("0.##%");
        BigDecimal big = new BigDecimal("0.1010");
        System.out.println(percentageFormat.format(big));
    }

    @Test
    public void divTest() {
        BigDecimal num = new BigDecimal(700);
        BigDecimal num2 = new BigDecimal(12000);
        System.out.println(num.divide(num2, 4, RoundingMode.UP).toPlainString());
    }

    @Test
    public void tsestSb() {
        String idcard = "423423198811042515";
        String rs = StringUtils.substring(idcard, 0, 6) + "****" + StringUtils.substring(idcard, 14);
        System.out.println(rs);
    }
}
