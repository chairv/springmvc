package dao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.testng.annotations.Test;

/**
 * Created by tancw on 2017/11/17.
 */
public class NumUtils {


    @Test
    void  floor(){
        BigDecimal num = new BigDecimal("2032.3682212");
        BigDecimal num2 = new BigDecimal("2032.3311233");
        System.out.println(num.setScale(2,RoundingMode.HALF_UP));
        System.out.println(num2.setScale(2, RoundingMode.HALF_UP));
    }
}
