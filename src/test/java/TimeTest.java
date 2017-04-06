import org.junit.Test;

import bean.User;

/**
 * Created by tancw on 2017/2/16.
 */
public class TimeTest {

    @Test
    public void test() {
        User user = new User();
        System.out.println(user.hashCode());
        test2(user);
        System.out.println(user.hashCode());
    }

    public void test2(User user) {
        user = new User();
        System.out.println(user.hashCode());
    }

}
