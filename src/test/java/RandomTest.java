import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by tancw on 2016/8/18.
 */
public class RandomTest {

	@Test
	public void test() {
//		String str = "sdf?id=1";
//		System.out.println(str.substring(str.indexOf("?")));
		Random random = new Random();
		System.out.println(random.nextInt(3));
	}

	private JSONObject createRandReuslt() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("1", radStrAry(1));
		jsonObject.put("2", radStrAry(2));
		jsonObject.put("3", radStrAry(3));
		jsonObject.put("4", radStrAry(4));
		jsonObject.put("5", radStrAry(5));
		return jsonObject;
	}

	private String[] radStrAry(int len) {
		Set<String> set = new HashSet<String>();
		do {
			set.add(String.format("%02d", (int) (Math.random() * 11 + 1)));
		} while (set.size() < len);
		return set.toArray(new String[set.size()]);
	}

	public boolean getReuslt() {
		for (int i = 0; i < 10; i++) {
			if (i == 5) return false;
		}
		return true;
	}
}
