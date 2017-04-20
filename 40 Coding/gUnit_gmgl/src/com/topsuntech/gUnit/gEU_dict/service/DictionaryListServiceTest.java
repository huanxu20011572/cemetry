/*
 * Created on 2004-5-12
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.topsuntech.gUnit.gEU_dict.service;

import net.sf.hibernate.HibernateException;
import junit.framework.TestCase;

/**
 * @author lixl
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class DictionaryListServiceTest extends TestCase {
	
	private DictionaryListService sev;
	
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		sev = new DictionaryListService();
	}
	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		sev = null;
	}
	/*
	 * Class to test for List findNode(String, String)
	 */
	public final void _testFindNodeStringString() {
		//TODO Implement findNode().
	}
	public final void testGetIdByCode() {
		try {
			//TODO Implement getIdByCode().
			Long re = sev.getIdByCode("6666");
			System.out.println("==================" + re);
			
			assertEquals("9999?",new Long(9999),re);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
