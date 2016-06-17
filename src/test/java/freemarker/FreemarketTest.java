package freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.utility.XmlEscape;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * Created by tancw on 2016/2/2.
 */
public class FreemarketTest {

	private static Configuration configuration = new Configuration();

	static {
		configuration.setLocale(Locale.CHINA);
		configuration.setDefaultEncoding("utf-8");
		configuration.setEncoding(Locale.CHINA, "utf-8");
		configuration.setObjectWrapper(new DefaultObjectWrapper());
	}

	@Test
	public void base() throws IOException, TemplateException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("date", new Date());
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("classpath:temp");
		Properties p = new Properties();
		p.put("template_update_delay", 1800);
		p.put("default_encoding", "UTF-8");
		p.put("locale", "zh_CN");
		freeMarkerConfigurer.setFreemarkerSettings(p);
		XmlEscape xmlEscape = new XmlEscape();
		Map<String, Object> vas = new HashMap<String, Object>();
		vas.put("xml_escape", xmlEscape);
		freeMarkerConfigurer.setFreemarkerVariables(vas);
		freeMarkerConfigurer.setConfiguration(configuration);
		Template tp = freeMarkerConfigurer.getConfiguration().getTemplate("/src/main/resources/temp/test.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(tp, param);
		System.out.println(html);
	}

	@Test
	public void config() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("date", new Date());
		param.put("limit", new BigDecimal("100.00"));
		StringWriter out = new StringWriter();
		try {
			Template template = configuration.getTemplate("/src/main/resources/temp/test.ftl", "utf-8");
			template.process(param, out);
			out.flush();
			System.out.println(out.toString());
			System.out.println("over");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testConfig() throws IOException {
        String path = "D:\\Workspaces\\springmvc5\\src\\main\\resources\\temp\\test.ftl";
		File file = new File("D:\\Workspaces\\springmvc5\\src\\main\\resources\\temp\\test.ftl");
//		System.out.println(file.exists());
//		configuration.setDirectoryForTemplateLoading(file);
//        configuration.setObjectWrapper(new DefaultObjectWrapper());
        Template temp = configuration.getTemplate(path);
        System.out.println(temp.toString());
    }
}
