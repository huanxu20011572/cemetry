package com.topsuntech.gUnit.gEU_dict.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.type.Type;

import org.apache.struts.util.LabelValueBean;

import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.common.web.util.DAOBase;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;

public class DynamicSelectDao extends DAOBase{

	public DynamicSelectDao(String schema) {
		super(schema);
		// TODO �Զ����ɹ��캯�����
	}
	public DynamicSelectDao() {
		super("gos");
		// TODO �Զ����ɹ��캯�����
	}
	public List queryBasicInfo(String parentStandardNo) throws TSDBException{
		List listP = new ArrayList();
		List listT = new ArrayList();
		StringBuffer queryHql = new StringBuffer("");		
		queryHql.append(" From SjRegion t where t.useFlag=1 and t.parentId=(select m.id From SjRegion m where m.standardNo=?)");
		listP.add(parentStandardNo);
		listT.add(Hibernate.STRING);
		Type[] types=(Type[])listT.toArray(new Type[0]);
		queryHql.append(" order by t.createDate ");
		return  query(queryHql.toString(),listP.toArray(),types);	
	}
	
	
	
	/**
	 * �������и��ڵ�
	 * @return List ������Ϣ
	 * @throws TSDBException
	 */
	public  List getRegionByParentIdImp(Long parentId)
			throws TSDBException {
		List listP = new ArrayList();
		List listT = new ArrayList();	
		StringBuffer querySql = new StringBuffer();
		querySql.append("from SjRegion r where r.useFlag=1 ");
		
		if (parentId != null){
			querySql.append(" and r.parentId=?");
			listP.add(parentId);
			listT.add(Hibernate.LONG);
		}
		querySql.append(" order by r.createDate");		
		List options= new ArrayList();
		Type[] types=(Type[])listT.toArray(new Type[0]);		
		List list=query(querySql.toString(),listP.toArray(),types);
		System.out.println("����"+list.size());
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			SjRegion element = (SjRegion) iter.next();
			options.add(new LabelValueBean(element.getStandardNo(),element.getName()));
		}
		return options;
		
	}
	/**
	 * �ڵ�ֵ��ñ����ڵ������ӽڵ�
	 */
	public List queryChilerList(String standardNo) throws TSDBException{
		List listP = new ArrayList();
		List listT = new ArrayList();
		List options= new ArrayList();
		StringBuffer queryHql = new StringBuffer("");		
		queryHql.append(" From SjRegion t where t.useFlag=1 and t.parentId=(select m.parentId From SjRegion m where m.standardNo=?)");
		listP.add(standardNo);
		listT.add(Hibernate.STRING);
		Type[] types=(Type[])listT.toArray(new Type[0]);

		queryHql.append(" order by t.createDate ");

		
		List list= query(queryHql.toString(),listP.toArray(),types);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			SjRegion element = (SjRegion) iter.next();
			options.add(new LabelValueBean(element.getStandardNo(),element.getName()));
		}
		return options;
		
	}
	/**
	 * �������и��ڵ�
	 * @return List ������Ϣ
	 * @throws TSDBException
	 */
	public  List findRegionByList(String standardNo)
			throws TSDBException {
		StringBuffer querySql = new StringBuffer();
		querySql.append("From SjRegion t where t.useFlag=1 and t.parentId=(select m.parentId From SjRegion m where m.standardNo=?) ");
		querySql.append(" order by t.createDate  ");
		Object[] param =new Object[]{standardNo};
		Type[] types=new Type[]{Hibernate.STRING};;		
		List list=  query(querySql.toString(),param,types);
		List options= new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			SjRegion element = (SjRegion) iter.next();
			options.add(new LabelValueBean(element.getStandardNo(),element.getName()));
		}	
		return options;	
	}
	/**
	 * ���ݸ��ڵ��������ӽڵ�
	 * @param parentStandardNo
	 * @return
	 * @throws TSDBException
	 */
	
	public List queryBasicInfoChiler(String parentStandardNo) throws TSDBException{
		List listP = new ArrayList();
		List listT = new ArrayList();
		StringBuffer queryHql = new StringBuffer("");		
		queryHql.append(" From SjRegion t where t.useFlag=1 and t.parentId=(select m.id From SjRegion m where m.standardNo=?)");
		listP.add(parentStandardNo);
		listT.add(Hibernate.STRING);
		Type[] types=(Type[])listT.toArray(new Type[0]);
		queryHql.append(" order by t.createDate ");		
		List options= query(queryHql.toString(),listP.toArray(),types);	
		List labevalues=new ArrayList();
		for (Iterator iter = options.iterator(); iter.hasNext();) {
			SjRegion element = (SjRegion) iter.next();
			labevalues.add(new LabelValueBean(element.getStandardNo(),element.getName()));
		}
		return labevalues;
	}
	
	
	/**
	 * ���ݸ��ڵ�������ӽڵ�id
	 * @param parentStandardNo
	 * @return
	 * @throws TSDBException
	 */
	
	public List queryBasicInfoChilerByParent(String parentStandardNo) throws TSDBException{
		List listP = new ArrayList();
		List listT = new ArrayList();
		StringBuffer queryHql = new StringBuffer("");		
		queryHql.append(" From SjRegion t where t.useFlag=1 and t.parentId=(select m.id From SjRegion m where m.standardNo=?)");
		listP.add(parentStandardNo);
		listT.add(Hibernate.STRING);
		Type[] types=(Type[])listT.toArray(new Type[0]);
		queryHql.append(" order by t.createDate ");		
		List options= query(queryHql.toString(),listP.toArray(),types);	
		List labevalues=new ArrayList();
		for (Iterator iter = options.iterator(); iter.hasNext();) {
			SjRegion element = (SjRegion) iter.next();
			labevalues.add(new LabelValueBean(element.getId().toString(),element.getName()));
		}
		return labevalues;
	}
	
	public  SjRegion findByStandardNo(String standardNo)
	throws Exception {
		return (SjRegion)this.findByValue("standardNo",standardNo,SjRegion.class);

}

}
