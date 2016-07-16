import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tancw on 2015/12/8.
 */
@ContextConfiguration("classpath:spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

	@Test
	public void test() {
		System.out.println("show");
	}
}
