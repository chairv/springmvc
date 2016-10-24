import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by tancw on 2016/10/24.
 */
public class GuavaTest {

    @Test
    public void bimap(){
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","12");
        biMap.put("2","23");
        System.out.println(biMap.inverse().get("12"));
    }
}
