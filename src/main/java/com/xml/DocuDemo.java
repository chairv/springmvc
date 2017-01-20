package com.xml;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by tancw on 2016/12/12.
 */
public class DocuDemo {
    public static void main(String[] args) {
       String str ="{\n" +
               "    \"bank_code\": \"CMBC\",\n" +
               "    \"customer_no\": \"360080004000838766\",\n" +
               "    \"out_trade_no\": \"20161213092301Colf18f8\",\n" +
               "    \"pay_tool\": \"TRAN\",\n" +
               "    \"response_code\": \"0000\",\n" +
               "    \"response_datetime\": \"20161214T111143\",\n" +
               "    \"response_message\": \"成功\",\n" +
               "    \"sign_data\": \"8F34D07D4450F99F6E07AE08A340B48E54EABD644D89549FD6D8AE7ABC17602D\",\n" +
               "    \"sign_type\": \"SHA-256\",\n" +
               "    \"trade_amount\": \"50388\",\n" +
               "    \"trade_class\": \"DEFY\",\n" +
               "    \"trade_currency\": \"CNY\",\n" +
               "    \"trade_no\": \"20161213100042000041950348\",\n" +
               "    \"trade_pay_time\": \"2016-12-13 09:30:48\",\n" +
               "    \"trade_respcode\": \"BAC2000006\",\n" +
               "    \"trade_respmsg\": \"交易失败被银行退回/账号不存在\",\n" +
               "    \"trade_status\": \"CLOS\",\n" +
               "    \"trade_subject\": \"猪猪钱罐busiId:68577\"\n" +
               "}";
        JSONObject object = (JSONObject) JSONObject.parse(str);

    }
}
