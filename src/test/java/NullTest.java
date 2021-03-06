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

	@Test
	public void test() {
		Integer a = null;
		Integer b = a;
		System.out.println(b);
	}

	@Test
	public void test2() {
		Sub sub = new Sub();
		create(sub);
        System.out.println(sub.value);
    }

	public void create(Sub sub) {
	 sub.value += 1;
    }

	class Sub {
		public int value = 1;
	}

}
