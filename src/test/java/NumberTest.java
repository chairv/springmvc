import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.Test;

/**
 * Created by tancw on 2016/11/15.
 */
public class NumberTest {

    @Test public  void test(){
        BigDecimal b= new BigDecimal("20.12312312");
        System.out.println(b.setScale(2));
    }

    @Test
    public void testFormat(){
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMinimumFractionDigits(2);
//        System.out.println(format.format(17.2/100.0));


        BigDecimal number  = new BigDecimal("0.16");
        System.out.println(format.format(number.doubleValue()));
    }
}
