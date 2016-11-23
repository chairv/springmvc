package com.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Created by qiao on 2016/3/14.
 */
public class BaseFreemark {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/temp/"));
        Template tempate = cfg.getTemplate("test.ftl");

        Map<String,Object> map1 = new HashedMap();
        map1.put("test","2");
        List<Map> items = new ArrayList<>();
        items.add(map1);

        Map<String,Object> root= new HashMap<String,Object>();
        root.put("items",items);
        Writer out = new OutputStreamWriter(System.out);
        System.out.println(out.toString());
        tempate.process(root,out);
        out.flush();
    }
}
