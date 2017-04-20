/*
 * Created on 2004-5-12
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.topsuntech.gUnit.gEU_dict.service;


import junit.framework.TestCase;

import com.topsuntech.gUnit.gEU_dict.en.MetaData;

/**
 * @author lixl
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class DictionaryServiceTest extends TestCase {
	
	private DictionaryService sev ;
	
	
	
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		sev = new DictionaryService();
	}
	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		sev = null;
	}
	public final void testAddNode() {
		//TODO Implement addNode().
		MetaData bean = new MetaData();
		bean.setParentid(new Long(2));
		bean.setNode_name("张三");
		bean.setNode_value("34343");
		bean.setInstitutionid(new Long(2));
		
		int re = sev.addNode(bean);
		System.out.println("操作结果:" + re);
		assertEquals("成功?",0,re);
		
	}
}



