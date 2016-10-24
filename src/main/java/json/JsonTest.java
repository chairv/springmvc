package json;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;

/**
 * Created by tancw on 2016/10/24.
 */
public class JsonTest {
    public static void main(String[] args) {
        String str = "{\n" +
                "\"api_version\":\"1.0\",\n" +
                "\"oid_partner\":\"201103171000000000\",\n" +
                "\"sign_type \":\"RSA\",\n" +
                "\"sign\":\"ZPZULntRpJwFmGNIVKwjLEF2Tze7bqs60rxQ22CqT5J1UlvGo575QK9z/\n" +
                "+p+7E9cOoRoWzqR6xHZ6WVv3dloyGKDR0btvrdqPgUAoeaX/YOWzTh00vwcQ+HBtXE+vP\n" +
                "TfAqjCTxiiSJEOY7ATCF1q7iP3sfQxhS0nDUug1LP3OLk=\"\n" +
                "}";

//        System.out.println(str);

        Map<String,String> result = JSON.parseObject(str, TreeMap.class);
        Map<String,String> res = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        res.putAll(result);
        System.out.println(res);

    }
}
