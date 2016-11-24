package com.drools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

import com.drools.api.PoinitRuleEngineImpl;

/**
 * Created by tancw on 2016/11/24.
 */
public class App {
	public static void main(String[] args) throws IOException {
		PointRuleEngine pointRuleEngine = new PoinitRuleEngineImpl();
		while (true) {
			InputStream is = System.in;
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String input = br.readLine();
			if (StringUtils.equals("s", input)) {
				System.out.println("初始化规则引擎");
				pointRuleEngine.initEngine();
				System.out.println("初始化规则引擎结束");
			} else if (StringUtils.equals("e", input)) {
				final PointDomain pointDomain = new PointDomain();
				pointDomain.setUsername("hello kity");
				pointDomain.setBackMondy(100d);
				pointDomain.setBuyMoney(500d);
				pointDomain.setBackNums(1);
				pointDomain.setBuyNums(5);
				pointDomain.setBirthDay(true);
				pointDomain.setPoint(01);
				pointRuleEngine.executeRuleEngin(pointDomain);
				System.out.println(pointDomain);
			} else if (StringUtils.equals("r", input)) {
				System.out.println("刷新规则文件....");
				pointRuleEngine.refreshEnginRule();
				System.out.println("刷新规则文件结束");
			}
		}
	}
}
