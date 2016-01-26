import org.junit.Test;

/**
 * Created by tancw on 2016/1/26.
 */
public class BaseTest {

	@Test
	public void test() {
		String a = "${no}dd";
		String b = a.replace("${no}", "12");
		String c = a.replace("${no}", "122");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
