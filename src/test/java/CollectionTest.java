import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

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
		for (int i = it.nextIndex(); it.hasNext(); i = it.nextIndex()) {
			System.out.printf("index: %d 值:%s \n", i, it.next());
			// it.add("sd");
			it.remove();
		}
		System.out.println(s);
	}

	@Test
	public void test2() {
		List<String> s = new ArrayList<>();
		s.add("0");
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		s.add("5");
		s.add("6");
		s.add("7");
		// System.out.println(StringUtils.join(s,"&"));
		for (Iterator<String> iterator = s.iterator(); iterator.hasNext();) {
			String next = iterator.next();
			if (next.equals("2")) {
				iterator.remove();
			} else if (next.equals("3")) {
				iterator.remove();
			}
		}
		System.out.println(s.size());
	}

}
