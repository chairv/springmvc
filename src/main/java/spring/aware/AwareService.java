package spring.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Created by tancw on 2016/11/17.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
	private String beanName;
	private ResourceLoader loader;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}

	public void outputResult() {
		System.out.println("Bean名称为:" + beanName);
		Resource resource = loader.getResource("test.txt");
		try {
			System.out.println("ResourceLoader加载文件内容为: " + IOUtils.toString(resource.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
