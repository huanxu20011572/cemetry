package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCommodity;

public class CemeteryCommodityService extends HibernateBaseService {
	
	/**
	 * 获得商品列表
	 * @param page
	 * @param cemeteryCommodity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryCommodity> getCemeteryCommodityList(Page page, CemeteryCommodity cemeteryCommodity) {
		logger.debug("page list param:" + cemeteryCommodity);
		
		StringBuffer querySql = new StringBuffer(" FROM CemeteryCommodity bt WHERE 1=1 ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(cemeteryCommodity!=null && StringUtils.isNotEmpty(cemeteryCommodity.getCommodityName())){
			String msg = cemeteryCommodity.getCommodityName();
//			String commodityName="";
//			try {
//				if (msg!=null) {
//					commodityName = new String(msg.getBytes("GBK"),"UTF-8");
//					//System.out.println(msg+"==============GBK================="+commodityName);
//				}
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
			querySql.append(" and bt.commodityName like ? ");
			objlist.add("%" + msg + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(cemeteryCommodity.getCommodityType()) && !"-1".equals(cemeteryCommodity.getCommodityType())){
			querySql.append(" and bt.commodityType = ? ");
			objlist.add(cemeteryCommodity.getCommodityType());
			typelist.add(Hibernate.STRING);
		}
		if(cemeteryCommodity.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(cemeteryCommodity.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}

		querySql.append(" ORDER BY bt.createDate desc ");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		
		return (List<CemeteryCommodity>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
//	/**
//	 * 根据ID获取商品
//	 * @param pid
//	 * @return
//	 */
	public CemeteryCommodity getCemeteryCommodity(Long id) {
		CemeteryCommodity  cemeteryCommodity= load(CemeteryCommodity.class, id);
		if(cemeteryCommodity !=null){
			return cemeteryCommodity;
		}else{
			return null;
		}
	}

	/**
	 * 添加或修改
	 * @param command
	 */
	public void saveCemeteryCommodity(CemeteryCommodity command) {
		 CemeteryCommodity type = null;
		if(command.getId()!=null && command.getId().longValue()> 0){
			//id>0编辑
			type = load(CemeteryCommodity.class, command.getId());
		}else{
			//新增
			type = new CemeteryCommodity();
			type.setCreateUserId(command.getCreateUserId());
			type.setCreateDate(command.getCreateDate());
			type.setCreateOrgId(command.getCreateOrgId());
		}
		type.setCommodityName(command.getCommodityName());
		type.setCommodityType(command.getCommodityType());
		type.setOutPrice(command.getOutPrice());
		type.setInPrice(command.getInPrice());
		type.setCount(command.getCount());
		type.setSpecifications(command.getSpecifications());
		saveOrUpdate(type);
	}

	/**
	 * 根据ID删除商品
	 * @param id
	 */
	public void deleteCemeteryCommodity(Long id) {
		CemeteryCommodity cemeteryCommodity = load(CemeteryCommodity.class, id);
		delete(cemeteryCommodity);
	}
}
