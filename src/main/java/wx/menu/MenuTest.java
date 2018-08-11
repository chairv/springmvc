package wx.menu;

import http.OkHttpUtils;

import org.apache.commons.io.IOUtils;

/**
 * Created by tancw on 2017/7/25.
 */
public class MenuTest {
    public static final String DEF_REGEX = "\\$\\{(.+?)\\}";
    public static final String ACCESS_TOKEN = "9_dKk6FPX_SQw24EIebZ7BFV3PHIei5GO5fiL4D-RHSwKKxEClSRnj0miK8OLi7E84UEqUHgUtSuURsTtxFoBEN9VWrZGOkEjnB1p781DNNGP00nXWkuZ8zOos4bfO699SPnwojgkmxOqMeUgAOEXaADABRK";

    public static void main(String[] args) throws Exception {
        String menuStr = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("menu-kjzz.json"),"UTF-8");
//        String res = createMenu(menuStr, ACCESS_TOKEN);
        System.out.println(menuStr);
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
