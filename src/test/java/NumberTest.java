import java.math.BigDecimal;

import org.junit.Test;

/**
 * Created by tancw on 2016/11/15.
 */
public class NumberTest {

    @Test public  void test(){
        BigDecimal b= new BigDecimal("1123123001111.1");
        System.out.println(b.movePointLeft(2).setScale(14,BigDecimal.ROUND_FLOOR));
    }
}
