package utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import bean.User;

/**
 * Created by tancw on 2017/2/8.
 */
public class BeanTest {

    @Test
    public void test() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User();
        user.setUsername("dear");
        user.setAge(20);
        String name = BeanUtils.getProperty(user, "username");
        String age = BeanUtils.getProperty(user, "age");
        System.out.println(name);
        System.out.println(age);
    }

}
