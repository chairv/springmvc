package wx.menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by tancw on 2017/7/25.
 */
public class MenuTest {
    public static final String DEF_REGEX = "\\$\\{(.+?)\\}";
    public static final String ACCESS_TOKEN = "7n1CsA0cBwOBmGNc3TGezhpuGC7GWG0QrSCxDxG5c2z1Faz7cviNKEUuAaPmkIF9eMRJy4GER6olvDAWKacpYBR7AcJU4jt0Zjy_Rp-DGwDHrM2goT1b3sbkXUX38btvFBWiCHASOJ";

    public static void main(String[] args) throws Exception {
        String str = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("menu.json"));
        String menuStr = parse(str);
        String mode = SysConf.get("env.mode");
        if (StringUtils.equals("develop", mode)) {
            String res = createMenu(menuStr, ACCESS_TOKEN);
            System.out.println(res);
        }
    }

    public static String createMenu(String params, String accessToken) throws Exception {
        HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);
        httpost.setEntity(new StringEntity(params, "UTF-8"));
        HttpResponse response = httpclient.execute(httpost);
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(jsonStr);
        JSONObject object = JSON.parseObject(jsonStr);
        return object.getString("errmsg");
    }

    private static String parse(String str) {
        Pattern pattern = Pattern.compile(DEF_REGEX);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String name = matcher.group(1);// 键名
            String realVal = SysConf.get(name);
            str = StringUtils.replace(str, matcher.group(), realVal);
        }
        return str;
    }
}
