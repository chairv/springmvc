import java.util.List;

import org.junit.Test;

import bean.TemSynCustomer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by tancw on 2017/2/23.
 */
public class JsonTest {


    @Test
    public void test() {
        String str = "{\n" +
                "\t\t  \"resultCode\": 1,\n" +
                "\t\t  \"message\": \"成功\",\n" +
                "\t\t  \"data\": [\n" +
                "\t\t    {\n" +
                "\t\t      \"idCard\": \"430682199309220019\",\n" +
                "\t\t      \"realName\": \"吴优\",\n" +
                "\t\t      \"mechanismCode\": \"86010001\",\n" +
                "\t\t      \"teamCode\": \"8601000101\",\n" +
                "\t\t      \"position\": null,\n" +
                "\t\t      \"entryState\": \"2\",\n" +
                "\t\t      \"superiorName\": \"XJ\",\n" +
                "\t\t      \"superiorIdCard\": \"420923198411150031\",\n" +
                "\t\t      \"recordId\": \"1\",\n" +
                "\t\t      \"createdDate\": \"2016-07-20 15:19:19\"\n" +
                "\t\t    },\n" +
                "\t\t    {\n" +
                "\t\t      \"idCard\": \"456523198612151413\",\n" +
                "\t\t      \"realName\": \"???\",\n" +
                "\t\t      \"mechanismCode\": \"86010402\",\n" +
                "\t\t      \"teamCode\": \"8601040201\",\n" +
                "\t\t      \"position\": null,\n" +
                "\t\t      \"entryState\": \"1\",\n" +
                "\t\t      \"superiorName\": null,\n" +
                "\t\t      \"superiorIdCard\": null,\n" +
                "\t\t      \"recordId\": \"2\",\n" +
                "\t\t      \"createdDate\": \"2016-07-20 16:09:14\"\n" +
                "\t\t    }\n" +
                "\t\t  ]\n" +
                "\t\t}";
        JSONObject obj = JSON.parseObject(str);
        String result = obj.getString("data");
        List<TemSynCustomer> rs = (List)JSON.parse(result);
        System.out.println(rs);
    }
}
