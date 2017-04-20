package com.topsuntech.gUnit_gmgl.core.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;



@ContextConfiguration(locations={"classpath:spring/applicationContext*.xml"})
//设置事务不回滚
@TransactionConfiguration(defaultRollback = false)
public class AbstractTestCase extends AbstractTransactionalJUnit38SpringContextTests{
	
}
