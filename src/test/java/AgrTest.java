import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Created by tancw on 2016/7/16. 　第一：java方法基本数据类型是传值，对象类型传引用，这是千真万确的。 　　第二：当参数是对象时，无论方法体内进行了何种操作，都不会改变实参对象的引用。
 * 　　第三：当参数是对象时，只有在方法内部改变了对象的内容时，才会改变实参对象内容。
 */
public class AgrTest {

	static void changVlaue(Integer a) {
		a = 4;
	}

	static void changeMapValue(Map map) {
		map.put("a", "b");
	}

	@Test
	public void test01() {
		Integer a = 0;
		System.out.println(a.hashCode());
		changVlaue(a);
		System.out.println(a.hashCode());
	}

	@Test
	public void test02() {
		Map map = new HashMap<String, String>();
		changeMapValue(map);
		System.out.println(map);
	}
}
