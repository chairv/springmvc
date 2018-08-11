package wx.menu;

import http.OkHttpUtils;

import java.io.IOException;

public class MenuStrTest {
    public static final String ACCESS_TOKEN = "9_dKk6FPX_SQw24EIebZ7BFV3PHIei5GO5fiL4D-RHSwKKxEClSRnj0miK8OLi7E84UEqUHgUtSuURsTtxFoBEN9VWrZGOkEjnB1p781DNNGP00nXWkuZ8zOos4bfO699SPnwojgkmxOqMeUgAOEXaADABRK";

    static String menu = "{\n" +
            "  \"button\": [\n" +
            "    {\n" +
            "      \"name\": \"微官网\",\n" +
            "      \"type\": \"view\",\n" +
            "      \"url\": \"http://www.hsxkjzz.com\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"学校简介\",\n" +
            "      \"sub_button\": [\n" +
            "        {\n" +
            "          \"name\": \"专业介绍\",\n" +
            "          \"type\": \"view\",\n" +
            "          \"url\": \"http://mp.weixin.qq.com/s?__biz=MzIzMTc3ODUxMA==&mid=2247483702&idx=2&sn=7f3b2cab928a25c8b16a849e582d1bd3&chksm=e89fb097dfe83981856383fc245ca4e0ebf590f6ba7c30320792726756fadc2daef4d8137d17&scene=18#wechat_redirect\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"政策解读\",\n" +
            "          \"type\": \"view\",\n" +
            "          \"url\": \"http://mp.weixin.qq.com/s?__biz=MzIzMTc3ODUxMA==&mid=2247483702&idx=3&sn=90eb010e273703830ab02570151eb2a0&chksm=e89fb097dfe839810caa8ea99bc211b31240e817d409a269b40d81059bea43391a083e320ada&scene=18#wechat_redirect\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"学校规划\",\n" +
            "          \"type\": \"view\",\n" +
            "          \"url\": \"http://mp.weixin.qq.com/s?__biz=MzIzMTc3ODUxMA==&mid=2247483702&idx=4&sn=41960911f268cdc3daaf96241ccebd8a&chksm=e89fb097dfe83981f3eecd093a3fd22078431e10aae127a13fafc38b6a517f090ccd1cd33c07&scene=18#wechat_redirect\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"学校简介\",\n" +
            "          \"type\": \"view\",\n" +
            "          \"url\": \"http://mp.weixin.qq.com/s?__biz=MzIzMTc3ODUxMA==&mid=2247483702&idx=1&sn=84289e694eff78ac82584edaacca190c&chksm=e89fb097dfe83981e30fb8ecc157f16f03adf952ab0a1a209c6add05f57a82057f72a4c90c60&scene=18#wechat_redirect\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"历史消息\",\n" +
            "          \"type\": \"view\",\n" +
            "          \"url\": \"https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzIzMTc3ODUxMA==#wechat_redirect\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"缴费系统\",\n" +
            "      \"sub_button\": [\n" +
            "        {\n" +
            "          \"name\": \"我要缴费\",\n" +
            "          \"type\": \"view\",\n" +
            "          \"url\": \"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2ad72eeb4bd954b2&redirect_uri=http://wx.hsxkjzz.com/base.do&response_type=code&scope=snsapi_base&state=usercent#wechat_redirect\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) throws IOException {
        System.out.println(menu);
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ACCESS_TOKEN;
        String result = OkHttpUtils.post(url, menu);
        System.out.println(result);
    }
}
