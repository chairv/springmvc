package com.drools.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.StatefulSession;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;
import org.drools.spi.Activation;
import org.drools.spi.AgendaFilter;

import com.drools.PointDomain;
import com.drools.PointRuleEngine;

/**
 * http://blog.csdn.net/quzishen/article/details/6163012 Created by tancw on 2016/11/23.
 */
public class PoinitRuleEngineImpl implements PointRuleEngine {

	private RuleBase ruleBase;

	@Override
	public void initEngine() {
		System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
		ruleBase = RuleBaseFactory.newRuleBase();
		try {
			PackageBuilder backageBuilder = getPackageBuilderFromDrlFile();
			ruleBase.addPackages(backageBuilder.getPackages());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private PackageBuilder getPackageBuilderFromDrlFile() throws Exception {
		// 获取测试脚本文件
		List<String> drlFilePath = getTestDrlFile();

		List<Reader> readers = readRuleFromDrlFile(drlFilePath);
		PackageBuilder backageBuilder = new PackageBuilder();
		for (Reader r : readers) {
			backageBuilder.addPackageFromDrl(r);
		}
		if (backageBuilder.hasErrors()) {
			throw new Exception(backageBuilder.getErrors().toString());
		}
		return backageBuilder;

	}

	private List<Reader> readRuleFromDrlFile(List<String> drlFilePath) throws FileNotFoundException {
		if (CollectionUtils.isNotEmpty(drlFilePath)) {
			List<Reader> readers = new ArrayList<>();
			for (String ruleFilePath : drlFilePath) {
				readers.add(new FileReader(new File(ruleFilePath)));
			}
		}
		return null;
	}

	private List<String> getTestDrlFile() {
		List<String> drlFilePath = new ArrayList<String>();
		drlFilePath.add("D:\\Workspaces\\springmvc5\\src\\main\\java\\com\\drools\\addpoint.drl");
		drlFilePath.add("D:\\Workspaces\\springmvc5\\src\\main\\java\\com\\drools\\subpoint.drl");
		return drlFilePath;
	}

	@Override
	public void refreshEnginRule() {
		ruleBase = RuleBaseFactory.newRuleBase();
		Package[] packages = ruleBase.getPackages();
		for (Package pg : packages) {
			ruleBase.removePackage(pg.getName());
		}
	}

	@Override
	public void executeRuleEngin(final PointDomain pointDomain) {
		if (null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {
			return;
		}
		StatefulSession statefulSession = ruleBase.newStatefulSession();
		statefulSession.insert(pointDomain);
		statefulSession.fireAllRules(new AgendaFilter() {
			@Override
			public boolean accept(Activation activation) {
				return !activation.getRule().getName().contains("_test");
			}
		});
	}

}
