package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesDeparted;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.Departed;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCommodity;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

/**
 * 
 * @author jerry
 * 
 */
public class CemeteryRegistryService extends HibernateBaseService {

	/**
	 * modify baiweiming 获取逝者，业务分页查询
	 * 
	 * @param page
	 * @param registry
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryRegistry> getCemeteryRegistryPageList(Page page, CemeteryRegistry registry) {
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		StringBuilder querySql = new StringBuilder(" from CemeteryRegistry cr WHERE 1=1 ");
		// 登陆人机构id
		if (registry.getCreateOrgId() !=null && registry.getCreateOrgId().longValue() > 0 ) {
			querySql.append(" and cr.createOrgId = ? ");
			objlist.add(registry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		// 是否补录
		if (registry.getIsSupply() != null) {
			querySql.append(" and cr.isSupply = ? ");
			objlist.add(registry.getIsSupply());
			typelist.add(Hibernate.LONG);
		}
		// 登承租人name
		if (StringUtils.isNotEmpty(registry.getName())) {
			querySql.append(" and cr.name like ? ");
			objlist.add("%" + registry.getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 逝者姓名
		if (StringUtils.isNotEmpty(registry.getDepartedName())) {
			querySql.append("  and cr in (select cr from cr.departeds cc  where cc.name like ? ) ");
			objlist.add("%" + registry.getDepartedName() + "%");
			typelist.add(Hibernate.STRING);
		}
		// mobilePhone联系电话
		if (StringUtils.isNotEmpty(registry.getMobilePhone())) {
			querySql.append(" and cr.mobilePhone like ? ");
			objlist.add("%" + registry.getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		// cemeteryRegistryCode业务编号：
		if (StringUtils.isNotEmpty(registry.getCemeteryRegistryCode())) {
			querySql.append(" and cr.cemeteryRegistryCode like ? ");
			objlist.add("%" + registry.getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 业务类型
		if (registry.getCemeteryRegistryType()!=null) {
			//租用,退墓业务同时查询
			if(registry.getCemeteryRegistryType().intValue() == Constant.REGEDIT_TYPE_RENT || registry.getCemeteryRegistryType().intValue() == Constant.REGEDIT_TYPE_BACK){
				querySql.append(" and (cr.cemeteryRegistryType = " + Constant.REGEDIT_TYPE_RENT); 
				querySql.append(" or cr.cemeteryRegistryType = " + Constant.REGEDIT_TYPE_BACK+ ")");
			}else{
				querySql.append(" and cr.cemeteryRegistryType = ? ");
				objlist.add(registry.getCemeteryRegistryType());
				typelist.add(Hibernate.INTEGER);
			}
		}
		querySql.append(" order by createDate DESC");
		StringBuilder countSql = new StringBuilder("select count(*)  ");
		countSql.append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		return (List<CemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);

	}

	/**
	 * modify baiweiming 2014-10-31 保存登记信息
	 * 
	 * @param cemeteryRegistry
	 */
	public CemeteryRegistry saveCemeteryRegistry(CemeteryRegistry cemeteryRegistry) {
		CemeteryLocation cemeteryLocation = load(CemeteryLocation.class, cemeteryRegistry.getCemeteryLocationId());
		// 设置保留状态
		cemeteryLocation.setStatus((long) Constant.CEMETERY_STATUS_RETAIN);
		cemeteryRegistry.setCemeteryLocation(cemeteryLocation);
		cemeteryRegistry.setBusinessDataId(cemeteryLocation.getCemeteryType().getBusinessData().getId());
		save(cemeteryRegistry);
		return cemeteryRegistry;
	}

	/**
	 * modify baiweiming 2014-10-31 保存登记信息
	 * 
	 * @param cemeteryRegistry
	 */
	public CemeteryRegistry saveCemeteryRegistrySupply(CemeteryRegistry cemeteryRegistry) {
		CemeteryLocation cemeteryLocation = load(CemeteryLocation.class, cemeteryRegistry.getCemeteryLocationId());
		// 设置墓位
		cemeteryRegistry.setCemeteryLocation(cemeteryLocation);
		cemeteryRegistry.setBusinessDataId(cemeteryLocation.getCemeteryType().getBusinessData().getId());
		save(cemeteryRegistry);
		return cemeteryRegistry;
	}

	/**
	 * 删除业务信息，销售信息，文件附件，逝者信息，复原墓位状态
	 * 
	 * @param id
	 * @param cemeteryRegistryType 
	 */
	public void deleteCemeteryRegistry(Long id, Long cemeteryRegistryType) {
		CemeteryRegistry cemeteryRegistry = load(CemeteryRegistry.class, id);
		//删除费用信息
		List<CemeteryCharge> charges = cemeteryRegistry.getCemeteryCharges();
		for (Iterator<CemeteryCharge> iterator = charges.iterator(); iterator.hasNext();) {
			CemeteryCharge cemeteryCharge = (CemeteryCharge) iterator.next();
			if (cemeteryCharge.getIsChargeType().longValue() == 0) {
				// 恢复商品出库数量
				CemeteryCommodity cemeteryCommodity = cemeteryCharge.getCemeteryCommodity();
				cemeteryCommodity.setCount(cemeteryCommodity.getCount().longValue() + cemeteryCharge.getCount().longValue());
				update(cemeteryCommodity);
			}
			delete(cemeteryCharge);
		}

		List<CemeteryFile> files = cemeteryRegistry.getCemeteryFiles();
		for (Iterator<CemeteryFile> iterator = files.iterator(); iterator.hasNext();) {
			CemeteryFile cemeteryFile = (CemeteryFile) iterator.next();
			delete(cemeteryFile);
		}
		List<Departed> departeds = cemeteryRegistry.getDeparteds();
		for (Iterator<Departed> iterator = departeds.iterator(); iterator.hasNext();) {
			Departed departed = (Departed) iterator.next();
			delete(departed);
		}
		if(cemeteryRegistry.getCemeteryRegistryType().longValue() == Constant.REGEDIT_TYPE_RENT){
			//租用业务变更墓位状态为空闲
			CemeteryLocation location = cemeteryRegistry.getCemeteryLocation();
			location.setStatus((long) Constant.CEMETERY_STATUS_FREE);
			update(location);
		}else{
			//删除续租，合葬，迁出的信息时，恢复墓位占有状态
			CemeteryLocation location = cemeteryRegistry.getCemeteryLocation();
			location.setStatus((long) Constant.CEMETERY_STATUS_HOLD);
			update(location);
		}
		this.delete(cemeteryRegistry);
	}

	/**
	 * modify baiweimig 2014-10-31 更新登记信息
	 * 
	 * @param cemeteryRegistry
	 */
	public CemeteryRegistry updateCemeteryRegistry(CemeteryRegistry cemeteryRegistry) {
		CemeteryRegistry l_CemeteryRegistry = load(CemeteryRegistry.class, cemeteryRegistry.getId());
		// 设置本次更新不可修改的数据项
		cemeteryRegistry.setCemeteryRegistryType(l_CemeteryRegistry.getCemeteryRegistryType());
		cemeteryRegistry.setCemeteryRegistryCode(l_CemeteryRegistry.getCemeteryRegistryCode());
		cemeteryRegistry.setCreateDate(l_CemeteryRegistry.getCreateDate());
		cemeteryRegistry.setCreateOrgId(l_CemeteryRegistry.getCreateOrgId());
		cemeteryRegistry.setCreateUserId(l_CemeteryRegistry.getCreateUserId());
		// 设置本次更新不可修改的关联关系
		CemeteryLocation cemeteryLocation = load(CemeteryLocation.class, cemeteryRegistry.getCemeteryLocationId());
		cemeteryRegistry.setCemeteryLocation(cemeteryLocation);
		cemeteryRegistry.setBusinessDataId(cemeteryLocation.getCemeteryType().getBusinessData().getId());
		cemeteryRegistry.setCemeteryCharges(l_CemeteryRegistry.getCemeteryCharges());
		cemeteryRegistry.setCemeteryFiles(l_CemeteryRegistry.getCemeteryFiles());
		//迁出，续租，合葬不能更改承租人信息
		if(l_CemeteryRegistry.getCemeteryRegistryType().intValue() != Constant.REGEDIT_TYPE_RENT){
			cemeteryRegistry.setName(l_CemeteryRegistry.getName());
			cemeteryRegistry.setCardNum(l_CemeteryRegistry.getCardNum());
			cemeteryRegistry.setSex(l_CemeteryRegistry.getSex());
			cemeteryRegistry.setMobilePhone(l_CemeteryRegistry.getMobilePhone());

		}

		merge(cemeteryRegistry);
		return load(CemeteryRegistry.class, cemeteryRegistry.getId());

	}

	/**
	 * modify baiweiming 2014-11-01 生成租用务流水
	 * 序列规则：公募ID+业务类型+办理年+办理月+序列(4位)+00(为合葬、续租、迁出业务保留)
	 * @return
	 */
	public String getCemeteryRegistrySerial(Long orgId) {
		BigDecimal serial = executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery("select  REGISTRY_RENT_SERIAL.nextval from dual ");

				return query.uniqueResult();
			}
		});

		String cemeteryRegistryCode = String.format("%04d", serial.longValue());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		String formattedDate = formatter.format(new Date());

		return orgId +""+ Constant.REGEDIT_TYPE_RENT + formattedDate + cemeteryRegistryCode+"00";
	}

	/**
	 * add baiweiming 2014-11-17 根据租用编号生成续租、合葬、迁出务流水
	 * 
	 * @param orgId:机构ID
	 * @param cemeteryRegistryCode:源序列编号
	 * @param type:业务类型
	 * @return
	 */
	public synchronized String getCemeteryRegistryOtherSerial(Long orgId,String cemeteryRegistryCode,int type) {

		//生成业务编号后缀
		try {
			if(StringUtils.isNotEmpty(cemeteryRegistryCode)){
				//获取租用编号时间
				String formattedDate = cemeteryRegistryCode.substring((orgId+"").length()+1,(orgId+"").length()+7);
				//获取租用编号序列
				String serial = cemeteryRegistryCode.substring((orgId+"").length()+8,cemeteryRegistryCode.length());
				//重组业务编号
				String nextSerial = String.format("%06d", Long.parseLong(serial)+1);
				return orgId +""+ type + formattedDate + nextSerial;
			}
		} catch (Exception e) {
			logger.debug(e);
			cemeteryRegistryCode = null;
		}
		return cemeteryRegistryCode;
	}

	/**
	 * 更新墓位状态
	 * 
	 * @param id
	 * @param status
	 */
	public void updateCemeteryLocationStatus(Long id, int status) {
		if (1 <= status && status <= 7) {
			CemeteryLocation cemeteryLocation = load(CemeteryLocation.class, id);
			cemeteryLocation.setStatus((long) status);
			update(cemeteryLocation);
		}
	}

	/**
	 * 退墓
	 * 
	 * @param command
	 */
	public void updateBackCemeteryRegistry(CemeteryRegistry command) {
		
		CemeteryRegistry cemeteryRegistry = load(CemeteryRegistry.class, command.getId());
		cemeteryRegistry.setIsOneself(command.getIsOneself());
		cemeteryRegistry.setAgentProve(command.getAgentProve());
		cemeteryRegistry.setAgentName(command.getAgentName());
		cemeteryRegistry.setAgentTel(command.getAgentTel());
		cemeteryRegistry.setAgentReason(command.getAgentReason());
		cemeteryRegistry.setBackPrice(command.getBackPrice());
		cemeteryRegistry.setBackReason(command.getBackReason());
		cemeteryRegistry.setCreateDate(new Date());
		cemeteryRegistry.setCreateUserId(command.getCreateUserId());
		cemeteryRegistry.setCemeteryRegistryType(Constant.REGEDIT_TYPE_BACK);
		//修改墓位状态
		CemeteryLocation cemeteryLocation = cemeteryRegistry.getCemeteryLocation();
		cemeteryLocation.setStatus((long) Constant.CEMETERY_STATUS_FREE);
		
		update(cemeteryRegistry);

	}
	
	/**
	 * 却认业务办理,设置业务数据,复制归档数据到业务办理,
	 * @param entity
	 * @param archivesRegistryId
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public CemeteryRegistry saveCemeteryRegistryConfirm(CemeteryRegistry entity ,Long archivesRegistryId) throws IllegalAccessException, InvocationTargetException{
		ArchivesCemeteryRegistry registry = load(ArchivesCemeteryRegistry.class, archivesRegistryId);
		String cemeteryRegistryCode  = getCemeteryRegistryOtherSerial(entity.getCreateOrgId(), registry.getCemeteryRegistryCode(), entity.getCemeteryRegistryType().intValue());
		CemeteryRegistry oldentity = getCemeteryRegistryByCode(cemeteryRegistryCode);
		//查询是否之前有过续租.合葬.迁出登记的业务编号，如果有则返回数据库数据，如果没有，则新增数据
		if(oldentity!=null){
			return oldentity;
		}
		CemeteryLocation cemeteryLocation = registry.getCemeteryLocation();
		//设置墓位状态
		cemeteryLocation.setStatus((long) Constant.CEMETERY_STATUS_RETAIN);
		entity.setCemeteryLocation(cemeteryLocation);
		//续租.合葬.迁出登记业务编号
		entity.setCemeteryRegistryCode(cemeteryRegistryCode);
		//设置承租人信息
		entity.setIsOneself(Long.valueOf(Constant.YES));
		entity.setName(registry.getName());
		entity.setCardNum(registry.getCardNum());
		entity.setSex(registry.getSex());
		entity.setMobilePhone(registry.getMobilePhone());
		entity.setIsSupply(Long.valueOf(Constant.NO));
		save(entity);
		
		//设置逝者信息
		for (ArchivesDeparted archivesDeparted : registry.getArchivesDeparteds()) {
			Departed departed = new Departed();
			BeanUtils.copyProperties(departed,archivesDeparted);
			departed.setId(null);
			departed.getCemeteryRegistries().add(entity);
			save(departed);
		}
		return entity;
	}

	/**
	 * 删除补录信息
	 * @param id
	 * @param cemeteryRegistryType
	 */
	public void deleteCemeteryRegistrySupply(Long id) {
		CemeteryRegistry cemeteryRegistry = load(CemeteryRegistry.class, id);
		//删除费用信息
		List<CemeteryCharge> charges = cemeteryRegistry.getCemeteryCharges();
		for (Iterator<CemeteryCharge> iterator = charges.iterator(); iterator.hasNext();) {
			CemeteryCharge cemeteryCharge = (CemeteryCharge) iterator.next();
			delete(cemeteryCharge);
		}

		List<CemeteryFile> files = cemeteryRegistry.getCemeteryFiles();
		for (Iterator<CemeteryFile> iterator = files.iterator(); iterator.hasNext();) {
			CemeteryFile cemeteryFile = (CemeteryFile) iterator.next();
			delete(cemeteryFile);
		}
		List<Departed> departeds = cemeteryRegistry.getDeparteds();
		for (Iterator<Departed> iterator = departeds.iterator(); iterator.hasNext();) {
			Departed departed = (Departed) iterator.next();
			delete(departed);
		}
		this.delete(cemeteryRegistry);
	}
	
	/**
	 * 根据业务编号获取公募登记信息
	 * @param cemeteryRegistryCode
	 * @return
	 */
	public CemeteryRegistry getCemeteryRegistryByCode(String cemeteryRegistryCode){
		List<CemeteryRegistry> list = (List<CemeteryRegistry>) find("FROM CemeteryRegistry WHERE cemeteryRegistryCode = '"+cemeteryRegistryCode+"'");
		if (list != null && list.size() > 0 ){
			return list.get(0);
		}
		return null;
	}


}
