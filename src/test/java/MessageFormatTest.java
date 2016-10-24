import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

import org.junit.Test;

/**
 * Created by tancw on 2016/9/1.
 */
public class MessageFormatTest {

    @Test
    public void test1(){
       String str = "今天{0},{1}去看海,下午{3 date}回来了,买了{4}条鱼";
        System.out.println(MessageFormat.format(str,"星期一","小明",new Date(),3));
    }

    @Test
    public void test2(){
        System.out.println(MessageFormat.format("{0}{1}",new BigDecimal("1000"),new BigDecimal("13323")));
    }


}
