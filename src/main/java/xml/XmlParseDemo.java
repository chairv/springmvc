package xml;

import java.io.FileInputStream;
import java.util.Map;

/**
 * Created by tancw on 2017/6/16.
 */
public class XmlParseDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/weixin.msg.xml");
            Map rs = XmlUtils.streamToMap(fis);
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
