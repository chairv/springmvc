package map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;


/**
 * Created by tancw on 2017/3/21.
 */
public class MapTest {

    @Test
    public void test() {
        Map map = new ConcurrentHashMap<String, String>(2);
        Object result0 = map.put("c", "a");
        Object result = map.put("a", "a");
        Object result2 = map.put(null, "a");
        System.out.println(map);

//        Map map2 = new ConcurrentHashMap<>(3);
    }
}
