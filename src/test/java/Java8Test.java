import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tancw on 2015/12/1.
 */
public class Java8Test {

	@Test
	public void test() {
		List<String> rs = new ArrayList<String>();
		rs.add("s");
		String[] sary = (String[]) rs.toArray(new String[rs.size()]);
		System.out.printf("" + sary.length);
	}
}
