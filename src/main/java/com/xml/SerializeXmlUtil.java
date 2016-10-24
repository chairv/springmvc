package com.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;

public class SerializeXmlUtil{


    public static XStream createXstream() {
        return new XStream((ReflectionProvider) new SerializeXmlUtil());
    }

    public static void main(String[] args) {
        createXstream();
    }

//    private static boolean needCDATA(Class<?> targetClass, String fieldAlias) {
//        boolean cdata = false;
//
//        cdata = existsCDATA(targetClass, fieldAlias);
//        if (cdata) {
//            return cdata;
//        }
//        Class superClass = targetClass.getSuperclass();
//        while (!superClass.equals(Object.class)) {
//            cdata = existsCDATA(superClass, fieldAlias);
//            if (cdata)
//                return cdata;
//            superClass = superClass.getClass().getSuperclass();
//        }
//        return false;
//    }

//    private static boolean existsCDATA(Class<?> clazz, String fieldAlias) {
//        if ("MediaId".equals(fieldAlias)) {
//            return true;
//        }
//
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.getAnnotation(XStreamCDATA.class) != null) {
//                XStreamAlias xStreamAlias = (XStreamAlias) field.getAnnotation(XStreamAlias.class);
//
//                if (xStreamAlias != null) {
//                    if (fieldAlias.equals(xStreamAlias.value()))
//                        return true;
//                } else if (fieldAlias.equals(field.getName())) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}

/* Location:           E:\微信\yy_wx.zip
 * Qualified Name:     yy_wx.WEB-INF.classes.com.framework.util.weixinUtils.SerializeXmlUtil
 * JD-Core Version:    0.6.0
 */