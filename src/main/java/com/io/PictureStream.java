package com.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by tancw on 2016/4/20.
 */
public class PictureStream {
	public static void main(String[] args) throws Exception {
		File f = new File("D:\\Workspaces\\springmvc5\\src\\main\\webapp\\images\\askmark.png");
		FileInputStream fis = new FileInputStream(f);
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		fis.close();

		// 生成字符串
		String imgStr = byte2hex(bytes);
		System.out.println(imgStr);
	}

    public static String byte2hex(byte[] b) // 二进制转字符串
    {
        StringBuffer sb = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1){
                sb.append("0" + stmp);
            }else{
                sb.append(stmp);
            }
        }
        return sb.toString();
    }
}
