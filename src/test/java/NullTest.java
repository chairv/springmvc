import org.junit.Test;

/**
 * Created by tancw on 2015/11/25.
 */
public class NullTest {

	@Test
	public void baseNull() {
		Integer a = null;
		if (null != a && a == 1) {
			System.out.println("no error");
		}

		System.out.println("ok");

		// if(1 != a){
		// System.out.println("i am not null");
		// }

		if (null == a || a == 1) {
			System.out.println("null == a || a == 1");
		}

		if (null != a || a == 1) {
			System.out.println("null != a || a==1");
		}
	}
}
