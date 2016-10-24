import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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

	@Test
	public void test2(){
		int a =0,b=0;
		System.out.println(a);
	}
}
