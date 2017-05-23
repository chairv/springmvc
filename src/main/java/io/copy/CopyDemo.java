package io.copy;

import java.math.BigDecimal;

/**
 * Created by tancw on 2017/5/15.
 */
public class CopyDemo {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("1.223434234").setScale(2,BigDecimal.ROUND_DOWN);
        BigDecimal c = new BigDecimal("1.2234342342").setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(b.multiply(c));
    }
}
