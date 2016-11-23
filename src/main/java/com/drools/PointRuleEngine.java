package com.drools;

/**
 * Created by tancw on 2016/11/23.
 */
public interface PointRuleEngine {
	/* 初始化规则引擎 */
	public void initEngine();

	/* 刷新规则引擎中的规则 */
	public void refreshEnginRule();

	/* 执行规则引擎 */
	public void executeRuleEngin(final PointDomain pointDomain);
}
