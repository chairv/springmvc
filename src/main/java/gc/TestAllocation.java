package gc;

import java.util.Date;

/**
 * Created by tancw on 2017/11/1.
 */
public class TestAllocation {
    private static final int _1MB  = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 =  new byte[_1MB/4];
        allocation2 =  new byte[4 * _1MB];
        allocation3 =  new byte[4 * _1MB];
        allocation4 =  new byte[4 * _1MB];

        Date now = new Date(1509676036347L);
        System.out.println(now);
    }
}
