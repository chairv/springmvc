import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * Created by tancw on 2016/10/24.
 */
public class GuavaTest {

	@Test
    public void bimap(){
//        BiMap<String,String> biMap = HashBiMap.create();
//        biMap.put("1","12");
//        biMap.put("2","23");
//        System.out.println(biMap.inverse().get("12"));
        Date now = new Date();
        System.out.println(DateUtils.addMonths(now,18));

        FormattingTuple ft   =  MessageFormatter.format("{}", "a");
        System.out.println(ft.getMessage());


    }
}
