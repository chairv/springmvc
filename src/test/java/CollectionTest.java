import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import com.sun.deploy.util.StringUtils;

/**
 * Created by tancw on 2016/10/8.
 */
public class CollectionTest {
	@Test
	public void test1() {
		// System.out.println("begin");
		List<String> s = new ArrayList<>();
		s.add("s");
		s.add("s2");
		s.add("s3");
		ListIterator<String> it = s.listIterator(1);
		// while (it.hasPrevious()){
		// System.out.println(it.previous().toString());
		// }
		// System.out.println(s);
		// while (it.hasNext()) {
		// System.out.println(it.nextIndex());
		// System.out.println(it.next());
		// }
		for (int i = it.nextIndex(); it.hasNext();i=it.nextIndex()) {
			System.out.printf("index: %d 值:%s \n", i, it.next());
//			it.add("sd");
			it.remove();
		}
		 System.out.println(s);
	}

	@Test
	public void test2(){
		List<String> s = new ArrayList<>();
		s.add("s");
		s.add("s2");
		s.add("s3");
		System.out.println(StringUtils.join(s,"&"));
	}

}
