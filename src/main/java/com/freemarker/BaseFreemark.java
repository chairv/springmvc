package com.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiao on 2016/3/14.
 */
public class BaseFreemark {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/temp/"));
        Template tempate = cfg.getTemplate("test.ftl");
        Map<String,Object> root= new HashMap<String,Object>();
        root.put("date",new Date());
        Writer out = new OutputStreamWriter(System.out);
        System.out.println(out.toString());
        tempate.process(root,out);
        out.flush();
    }
}
