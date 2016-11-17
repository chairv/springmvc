package com.collections;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Created by tancw on 2016/10/25.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("12","123");
        String a;
        System.out.println(StringUtils.isBlank((a=map.remove("12"))));
        System.out.println(a);
    }
}
