import java.sql.Timestamp;
import java.util.TimeZone;

import org.junit.Test;

import bean.User;

/**
 * Created by tancw on 2017/2/16.
 */
public class TimeTest {

    @Test
    public void test() {
        long current = System.currentTimeMillis();//当前时间毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
//        System.out.println(current/(1000*3600*24));
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒的毫秒数
//        System.out.println((twelve - current)/60*60*1000);
        System.out.println(TimeZone.getDefault().getRawOffset() / (1000 * 3600));

        long yesterday = System.currentTimeMillis() - 24 * 60 * 60 * 1000;//昨天的这一时间的毫秒数
        System.out.println(new Timestamp(current));//当前时间
        System.out.println(new Timestamp(yesterday));//昨天这一时间点
        System.out.println(new Timestamp(zero));//今天零点零分零秒
        System.out.println(new Timestamp(twelve));//今天23点59分59秒

    }

    public void test2(User user) {
        user = new User();
        System.out.println(user.hashCode());
    }


}
