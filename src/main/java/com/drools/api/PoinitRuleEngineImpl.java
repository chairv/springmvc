package com.drools.api;

import java.util.ArrayList;
import java.util.List;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.compiler.PackageBuilder;

import com.drools.PointDomain;
import com.drools.PointRuleEngine;

/**
 * http://blog.csdn.net/quzishen/article/details/6163012
 * Created by tancw on 2016/11/23.
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
        List<String> drlFilePath = getTestDrlFile();
        return null;

    }

    private List<String> getTestDrlFile() {
        List<String> drlFilePath = new ArrayList<String>();
        return null;
    }

    @Override
	public void refreshEnginRule() {

	}

	@Override
	public void executeRuleEngin(PointDomain pointDomain) {

	}

   
}
