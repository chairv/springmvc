import java.math.BigDecimal;

import org.junit.Test;

/**
 * Created by tancw on 2016/11/15.
 */
public class NumberTest {

    @Test public  void test(){
        BigDecimal b= new BigDecimal("20.12312312");
        System.out.println(b.setScale(2));
    }
}
