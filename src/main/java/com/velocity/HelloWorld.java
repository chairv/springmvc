package com.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;

/**
 * Created by tancw on 2016/3/17.
 */
public class HelloWorld {
	public static void main(String[] args) {
		try {
			Velocity.init("src/main/resources/velocity.properties");
			VelocityContext context = new VelocityContext();
			context.put("name", "sea");
			Template template = Velocity.getTemplate("temp/hello.vm");
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
            System.out.println(writer.toString());
            System.out.println("game over");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
