package wx.menu;

import org.apache.commons.io.IOUtils;

import http.OkHttpUtils;

/**
 * Created by tancw on 2017/7/25.
 */
public class MenuTest {
    public static final String DEF_REGEX = "\\$\\{(.+?)\\}";
    public static final String ACCESS_TOKEN = "7n1CsA0cBwOBmGNc3TGezhpuGC7GWG0QrSCxDxG5c2z1Faz7cviNKEUuAaPmkIF9eMRJy4GER6olvDAWKacpYBR7AcJU4jt0Zjy_Rp-DGwDHrM2goT1b3sbkXUX38btvFBWiCHASOJ";

    public static void main(String[] args) throws Exception {
        String menuStr = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("menu.json"));
        String res = createMenu(menuStr, ACCESS_TOKEN);
        System.out.println(res);
    }

    public static String createMenu(String params, String accessToken) throws Exception {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
        return OkHttpUtils.post(url, params);
    }

//    private static String parse(String str) {
//        Pattern pattern = Pattern.compile(DEF_REGEX);
//        Matcher matcher = pattern.matcher(str);
//        while (matcher.find()) {
//            String name = matcher.group(1);// 键名
//            String realVal = SysConf.get(name);
//            str = StringUtils.replace(str, matcher.group(), realVal);
//        }
//        return str;
//    }
}
