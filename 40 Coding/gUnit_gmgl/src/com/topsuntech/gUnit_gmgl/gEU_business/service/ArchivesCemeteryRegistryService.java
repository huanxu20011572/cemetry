package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;
import org.springframework.util.CollectionUtils;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesDeparted;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.Departed;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCommodity;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeData;
import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;
import com.topsuntech.gUnit_gmgl.gEU_system.service.DictService;

public class ArchivesCemeteryRegistryService extends HibernateBaseService {
	private DictService dictService;

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	/**
	 * 获得商品列表
	 * 
	 * @param page
	 * @param cemeteryCommodity
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public List<ArchivesCemeteryRegistry> getCemeteryRegistryList(Page page, ArchivesCemeteryRegistry registry) throws ParseException {
		logger.debug("page list param:" + registry);

		StringBuffer querySql = new StringBuffer(" FROM ArchivesCemeteryRegistry bt WHERE 1=1 ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();

		// 业务编号：
		if (StringUtils.isNotEmpty(registry.getCemeteryRegistryCode())) {
			querySql.append(" and bt.cemeteryRegistryCode like ? ");
			objlist.add("%" + registry.getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 登承租人name
		if (StringUtils.isNotEmpty(registry.getName())) {
			querySql.append(" and bt.name like ? ");
			objlist.add("%" + registry.getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 联系电话
		if (StringUtils.isNotEmpty(registry.getMobilePhone())) {
			querySql.append(" and bt.mobilePhone like ? ");
			objlist.add("%" + registry.getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 逝者姓名
		if (StringUtils.isNotEmpty(registry.getDepartedName())) {
			querySql.append("  and (bt in (select bt from bt.archivesDeparteds cc  where cc.name like ? )) ");
			objlist.add("%" + registry.getDepartedName() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 墓位ID
		if (null != registry.getCemeteryLocationId()) {
			querySql.append(" and bt.cemeteryLocation.id = ? ");
			objlist.add(registry.getCemeteryLocationId());
			typelist.add(Hibernate.LONG);
		}

		if (null != registry.getBuydate()) {
			querySql.append(" and bt.buydate <= ? ");
			objlist.add(registry.getBuydate());
			typelist.add(Hibernate.DATE);

		}
		if (null != registry.getEnddate()) {
			querySql.append(" and bt.enddate >= ? ");
			objlist.add(registry.getEnddate());
			typelist.add(Hibernate.DATE);
		}
		if (null != registry.getCreateOrgId() && 0 != registry.getCreateOrgId()) {
			querySql.append(" and bt.createOrgId = ?");
			objlist.add(registry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		 
		querySql.append(" ORDER BY bt.createDate desc ");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<ArchivesCemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}

	public ArchivesCemeteryRegistry getArchivesCemeteryRegistryById(Long id) {
		return super.load(ArchivesCemeteryRegistry.class, id);
	}

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updateArchivesCemeteryRegistry(ArchivesCemeteryRegistry entity) {
		ArchivesCemeteryRegistry registry = load(ArchivesCemeteryRegistry.class, entity.getId());
		this.buildChangeContent(entity, registry);
	 
		registry.setNation(entity.getNation());
		registry.setNationality(entity.getNationality());
		
		registry.setProvince(entity.getProvince());
		registry.setCounty(entity.getCounty());
		
		registry.setFamliyAddress(entity.getFamliyAddress());
		registry.setFamliyZip(entity.getFamliyZip());
		
		registry.setCompanyAddress(entity.getCompanyAddress());
		registry.setCompanyZip(entity.getCompanyZip());

		registry.setFamliyTel(entity.getFamliyTel());
		
		registry.setCompanyTel(entity.getCompanyTel());
		registry.setEmail(entity.getEmail());
		
		super.update(registry);
	}

	private StringBuilder buildChangeContent(ArchivesCemeteryRegistry command, ArchivesCemeteryRegistry registry) {
		StringBuilder sb = new StringBuilder();
		if (!registry.getName().equals(command.getName())) {
			sb.append("承租人姓名变更:").append(registry.getName()).append("->").append(command.getName());
			registry.setName(command.getName());
		}
		if (!registry.getSex().equals(command.getSex())) {

			sb.append("承租人性别变更:").append(registry.getSex() == 1 ? "男" : "女").append("->").append(command.getSex() == 1 ? "男" : "女");
			registry.setSex(command.getSex());
		}
		if (command.getCardType() != null && !command.getCardType().equals(registry.getCardType())) {
			List<Dict> dicts1 = dictService.getDictByCode(registry.getCardType());
			List<Dict> dicts2 = dictService.getDictByCode(command.getCardType());
			String nameOld = dicts1.size() > 0 ? dicts1.get(0).getDictName() : "";
			String nameNew = dicts2.size() > 0 ? dicts2.get(0).getDictName() : "";
			sb.append("承租人证件类型变更:").append(nameOld).append("->").append(nameNew);
		}
		if (!command.getCardNum().equals(registry.getCardNum())) {

			sb.append("承租人证件号变更:").append(registry.getCardNum()).append("->").append(command.getCardNum());
			registry.setCardNum(command.getCardNum());
		}

		if (!command.getMobilePhone().equals(registry.getMobilePhone())) {

			sb.append("承租人移动电话变更:").append(registry.getMobilePhone()).append("->").append(command.getMobilePhone());
			registry.setMobilePhone(command.getMobilePhone());
		}

		if (sb.length() > 0)
			registry.setChangeContent(sb.toString());
		registry.setChangeResone(command.getChangeResone());
		registry.setChangeRemark(command.getChangeRemark());
		
		
		logger.debug("变更内容：" + sb.toString());
		return sb;
	}

	/**
	 * add baiweming 2014-11-10 对业务办理数据进行归档
	 * 
	 * @param ids
	 *            :归档业务id数组
	 * @param isSupply:是否补录，补录数据不变更墓位状态 
	 * @return
	 * @throws Exception
	 */
	public boolean saveArchives(long[] ids, Long isSupply) throws Exception {
		try {
			for (int i = 0; i < ids.length; i++) {
				Long id = ids[i];
				// 填充归档基本数据
				CemeteryRegistry registry = load(CemeteryRegistry.class, id);
				ArchivesCemeteryRegistry archivesCemeteryRegistry = new ArchivesCemeteryRegistry();
				BeanUtils.copyProperties(archivesCemeteryRegistry, registry);
				
				//填充墓位信息
				archivesCemeteryRegistry.setId(null);
				CemeteryLocation cemeteryLocation = registry.getCemeteryLocation();
				if(isSupply.longValue() == 0){
					if(registry.getCemeteryRegistryType().intValue() == Constant.REGEDIT_TYPE_REMOVAL || 
							registry.getCemeteryRegistryType().intValue() == Constant.REGEDIT_TYPE_BACK){
						cemeteryLocation.setStatus(Long.valueOf(Constant.CEMETERY_STATUS_FREE));
					}else{
						cemeteryLocation.setStatus(Long.valueOf(Constant.CEMETERY_STATUS_HOLD));
					}
				}
				archivesCemeteryRegistry.setCemeteryTypeId(registry.getCemeteryLocation().getCemeteryType().getId());
				archivesCemeteryRegistry.setCemeteryZoneId(registry.getCemeteryLocation().getCemeteryZone().getId());
				archivesCemeteryRegistry.setCemeteryLocation(registry.getCemeteryLocation());
				save(archivesCemeteryRegistry);
				// 填充归档费用数据
				for (CemeteryCharge cemeteryCharge : registry.getCemeteryCharges()) {
					ArchivesCemeteryCharge archivesCemeteryCharge = new ArchivesCemeteryCharge();
					BeanUtils.copyProperties(archivesCemeteryCharge, cemeteryCharge);
					archivesCemeteryCharge.setId(null);
					archivesCemeteryCharge.setArchivesCemeteryRegistry(archivesCemeteryRegistry);
					save(archivesCemeteryCharge);
				}
				// 填充归档逝者数据
				for (Departed departed : registry.getDeparteds()) {
					ArchivesDeparted archivesDeparted = new ArchivesDeparted();
					BeanUtils.copyProperties(archivesDeparted, departed);
					archivesDeparted.setId(null);
					archivesDeparted.getArchivesCemeteryRegistries().add(archivesCemeteryRegistry);
					save(archivesDeparted);
				}
				// 填充归档附件数据
				for (CemeteryFile cemeteryFile : registry.getCemeteryFiles()) {
					ArchivesCemeteryFile archivesCemeteryFile = new ArchivesCemeteryFile();
					BeanUtils.copyProperties(archivesCemeteryFile, cemeteryFile);
					archivesCemeteryFile.setId(null);
					archivesCemeteryFile.setArchivesCemeteryRegistry(archivesCemeteryRegistry);
					save(archivesCemeteryFile);
				}
				for (Departed departed: registry.getDeparteds()) {
					delete(departed);
				}
				delete(registry);
			}
			return true;
		} catch (Exception e) {
			logger.debug(e);
			return false;
		}
	}

	/**
	 * 获得补证列表
	 * @param page
	 * @param cemeteryType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ArchivesCemeteryRegistry> getArchivesCemeteryRegistryList(Page page, ArchivesCemeteryRegistry archivesCemeteryRegistry,Long level) {
		logger.debug("page list param:" + archivesCemeteryRegistry);
		
		StringBuffer querySql = new StringBuffer(" FROM ArchivesCemeteryRegistry bt where 1=1 ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getCemeteryRegistryCode())){
			querySql.append(" and bt.cemeteryRegistryCode like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getName())){
			querySql.append(" and bt.name like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getMobilePhone())){
			querySql.append(" and bt.mobilePhone like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(archivesCemeteryRegistry.getCemeteryLocationId()!=null && 
				archivesCemeteryRegistry.getCemeteryLocationId().longValue()!=0){
			querySql.append(" and bt.cemeteryLocation.id = ? ");
			objlist.add(archivesCemeteryRegistry.getCemeteryLocationId());
			typelist.add(Hibernate.LONG);
		}
		//市级用户查询所有机构信息
		if(level!=null && level.longValue() >1){
			if(archivesCemeteryRegistry.getCreateOrgId()!=null){
				querySql.append(" and bt.createOrgId = ? ");
				objlist.add(archivesCemeteryRegistry.getCreateOrgId());
				typelist.add(Hibernate.LONG);
			}
		}
		//已经做过补证的，不再重复做时添加下面代码，但是如果再次丢失，还需要补证，所以还是不加这段代码了
		/*if (archivesCemeteryRegistry.getCreateOrgId()!=null) {
			querySql.append("  and (bt not in (select bt from bt.cemeteryCertificates cc  where cc.createOrgId = ? )) ");
			objlist.add(archivesCemeteryRegistry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
			//System.out.println("++++++++++++++++++++++++++");
		} else {
			querySql.append("  and (bt not in (select bt from bt.cemeteryCertificates cc )) ");
			//System.out.println("==========================");
		}*/
		
		//逝者姓名
		if (StringUtils.isNotEmpty(archivesCemeteryRegistry.getDealName())) {
			querySql.append("  and (bt in (select bt from bt.archivesDeparteds ad  where ad.name like ? )) ");
			objlist.add("%" + archivesCemeteryRegistry.getDealName() + "%");
			typelist.add(Hibernate.STRING);
		}
		
		//租赁起止日期
		Date beginBuyDate =  archivesCemeteryRegistry.getBeginBuyDate();
		Date endBuyDate =  archivesCemeteryRegistry.getEndBuyDate();
		
		if(beginBuyDate!=null && endBuyDate!=null){
			querySql.append(" and bt.buydate >= ?");
			objlist.add(beginBuyDate);
			typelist.add(Hibernate.DATE); 
			
			querySql.append(" and bt.enddate <= ?");
			objlist.add(endBuyDate);
			typelist.add(Hibernate.DATE); 

		}else{
			if(beginBuyDate!=null){
				querySql.append(" and bt.buydate >= ?");
				objlist.add(beginBuyDate);
				typelist.add(Hibernate.DATE); 
			}
			if(endBuyDate!=null){
				querySql.append(" and bt.enddate <= ?");
				objlist.add(endBuyDate);
				typelist.add(Hibernate.DATE); 
			}
		}
		
		querySql.append(" ORDER BY bt.id desc ");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		
		return (List<ArchivesCemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
	/**
	 * 截取当前公募同一系列业务中最后一个办理业务
	 * 
	 * @param page
	 * @param cemeteryCommodity
	 * @return
	 * @throws ParseException
	 */
	public ArchivesCemeteryRegistry getArchivesCemeteryRegistryConfirm(String cemeteryRegistryCode,Long orgId) throws ParseException {
		
		logger.debug("getArchivesCemeteryRegistryConfirm param cemeteryRegistryCode:" + cemeteryRegistryCode);
		try {
			cemeteryRegistryCode = orgId + "_"+cemeteryRegistryCode.substring((orgId+"").length()+1,cemeteryRegistryCode.length()-2)+"__";
		} catch (Exception e) {
			logger.debug(e);
			cemeteryRegistryCode = null;
		}

		StringBuffer querySql = new StringBuffer(" FROM ArchivesCemeteryRegistry bt ");
		// 业务编号：
		if (StringUtils.isNotEmpty(cemeteryRegistryCode)) {
			querySql.append(" WHERE bt.cemeteryRegistryCode like '"+cemeteryRegistryCode+"'");
			querySql.append(" AND bt.createOrgId = "+ orgId);
			querySql.append(" ORDER BY bt.id desc ");
		}
		
		@SuppressWarnings("unchecked")
		List<ArchivesCemeteryRegistry> list = (List<ArchivesCemeteryRegistry>) find(querySql.toString());
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 截取当前公募同一系列业务所有信息
	 * 
	 * @param page
	 * @param cemeteryCommodity
	 * @return
	 * @throws ParseException
	 */
	public List<ArchivesCemeteryRegistry> getArchivesCemeteryRegistryList(String cemeteryRegistryCode,Long orgId) throws ParseException {
		
		logger.debug("getArchivesCemeteryRegistryList param cemeteryRegistryCode:" + cemeteryRegistryCode);
		if(StringUtils.isEmpty(cemeteryRegistryCode)){
			return null;
		}
		//模糊查询业务编号
		try {
			cemeteryRegistryCode = orgId + "_"+cemeteryRegistryCode.substring((orgId+"").length()+1,cemeteryRegistryCode.length()-2)+"__";
		} catch (Exception e) {
			logger.debug(e);
			return null;
		}

		StringBuffer querySql = new StringBuffer(" FROM ArchivesCemeteryRegistry bt ");
		// 业务编号：
		if (StringUtils.isNotEmpty(cemeteryRegistryCode)) {
			querySql.append(" WHERE bt.cemeteryRegistryCode like '"+cemeteryRegistryCode+"'");
			querySql.append(" AND bt.createOrgId = "+ orgId);
			querySql.append(" ORDER BY bt.id desc ");
		}
		
		@SuppressWarnings("unchecked")
		List<ArchivesCemeteryRegistry> list = (List<ArchivesCemeteryRegistry>) find(querySql.toString());
		return list;
	}
	
	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updateArchivesCemeteryRegistryEditInfo(ArchivesCemeteryRegistry entity) {
		ArchivesCemeteryRegistry registry = load(ArchivesCemeteryRegistry.class, entity.getId());
		//this.buildChangeContent1(entity, registry);
		CemeteryLocation cemeteryLocation = load(CemeteryLocation.class, entity.getCemeteryLocationId());
		registry.setCemeteryZoneId(cemeteryLocation.getCemeteryZone().getId());
		registry.setCemeteryTypeId(cemeteryLocation.getCemeteryType().getId());
		registry.setBusinessDataId(cemeteryLocation.getCemeteryType().getBusinessData().getId());
		registry.setCemeteryLocation(cemeteryLocation);
		registry.setCemeteryPrice(entity.getCemeteryPrice());
		registry.setOtherPrice(entity.getOtherPrice());
		registry.setTotalPrice(entity.getTotalPrice());
		registry.setDiscountPrice(entity.getDiscountPrice());
		registry.setFactPrice(entity.getFactPrice());
		registry.setBuydate(entity.getBuydate());
		registry.setEnddate(entity.getEnddate());
		registry.setName(entity.getName());
		registry.setSex(entity.getSex());
		registry.setMobilePhone(entity.getMobilePhone());
		registry.setCardType(entity.getCardType());
		registry.setCardNum(entity.getCardNum());
		registry.setNation(entity.getNation());
		registry.setNationality(entity.getNationality());
		registry.setProvince(entity.getProvince());
		registry.setCounty(entity.getCounty());
		registry.setFamliyAddress(entity.getFamliyAddress());
		registry.setFamliyZip(entity.getFamliyZip());
		registry.setCompanyAddress(entity.getCompanyAddress());
		registry.setCompanyZip(entity.getCompanyZip());
		registry.setFamliyTel(entity.getFamliyTel());
		registry.setPeriods(entity.getPeriods());
		registry.setCompanyTel(entity.getCompanyTel());
		registry.setEmail(entity.getEmail());
		registry.setRemark(entity.getRemark());
		registry.setTombBack(entity.getTombBack());
		registry.setTombFront(entity.getTombFront());
		registry.setTombRemark(entity.getTombRemark());
		super.update(registry);
	}
	
	private StringBuilder buildChangeContent1(ArchivesCemeteryRegistry command, ArchivesCemeteryRegistry registry) {
		StringBuilder sb = new StringBuilder();
		if (!registry.getName().equals(command.getName())) {
			sb.append("承租人姓名变更:").append(registry.getName()).append("->").append(command.getName());
			registry.setName(command.getName());
		}
		if (!registry.getSex().equals(command.getSex())) {

			sb.append("承租人性别变更:").append(registry.getSex() == 1 ? "男" : "女").append("->").append(command.getSex() == 1 ? "男" : "女");
			registry.setSex(command.getSex());
		}
		if (command.getCardType() != null && !command.getCardType().equals(registry.getCardType())) {
			List<Dict> dicts1 = dictService.getDictByCode(registry.getCardType());
			List<Dict> dicts2 = dictService.getDictByCode(command.getCardType());
			String nameOld = dicts1!=null && dicts1.size() > 0 ? dicts1.get(0).getDictName() : "";
			String nameNew = dicts2!=null && dicts2.size() > 0 ? dicts2.get(0).getDictName() : "";
			sb.append("承租人证件类型变更:").append(nameOld).append("->").append(nameNew);
		}
		if (!command.getCardNum().equals(registry.getCardNum())) {

			sb.append("承租人证件号变更:").append(registry.getCardNum()).append("->").append(command.getCardNum());
			registry.setCardNum(command.getCardNum());
		}

		if (!command.getMobilePhone().equals(registry.getMobilePhone())) {

			sb.append("承租人移动电话变更:").append(registry.getMobilePhone()).append("->").append(command.getMobilePhone());
			registry.setMobilePhone(command.getMobilePhone());
		}

		if (sb.length() > 0)
			registry.setChangeContent(sb.toString());
		registry.setChangeResone(command.getChangeResone());
		registry.setChangeRemark(command.getChangeRemark());
		
		
		logger.debug("变更内容：" + sb.toString());
		return sb;
	}
	
	/**
	 * 添加商品/费用信息
	 * 
	 * @param archivesCemeteryRegistryId
	 *            :档案办理id,可以为null
	 * @param outStorehouseType
	 *            :出库类型
	 * @param id
	 *            :费用id/商品id
	 * @param isChargeType
	 *            :商品0，费用1
	 * @param count
	 *            :数量
	 * @param receive
	 *            :商品价格
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void addCemeteryChargeList(Long archivesCemeteryRegistryId, long outStorehouseType, long[] id, long[] isChargeType, long[] count, float[] receive,
			User user) throws Exception {
		logger.debug("添加商品/费用信息archivesCemeteryRegistryId:" + archivesCemeteryRegistryId);
		ArchivesCemeteryRegistry cemeteryRegistry = null;
		if (archivesCemeteryRegistryId != null) {
			cemeteryRegistry = load(ArchivesCemeteryRegistry.class, archivesCemeteryRegistryId);
		}
		for (int i = 0; i < receive.length; i++) {
			ArchivesCemeteryCharge charge = new ArchivesCemeteryCharge();
			// 增加商品消费，减少商品库存
			if (isChargeType[i] == 0) {
				CemeteryCommodity commodity = load(CemeteryCommodity.class, id[i]);
				// 减少商品库存数据
				long s = commodity.getCount().longValue() - count[i];
				if (s < 0) {
					throw new Exception(commodity.getCommodityName() + "数量异常");
				} else {
					commodity.setCount(s);
					update(commodity);
				}
				//charge.setCemeteryCommodity(commodity);
				charge.setCemeteryCommodityId(commodity.getId());
				if (cemeteryRegistry!=null) {
					charge.setArchivesCemeteryRegistry(cemeteryRegistry);
				}
				charge.setCount(count[i]);
				charge.setCreateDate(new Date());
				charge.setCreateOrgId(user.getDeptid());
				charge.setCreateUserId(user.getId());
				charge.setIsChargeType(isChargeType[i]);
				charge.setOutStorehouseType(outStorehouseType);
				charge.setPrice(commodity.getOutPrice());
				charge.setProductName(commodity.getCommodityName());
				List<Dict> list = dictService.getDictByCode(commodity.getCommodityType());
				if (!CollectionUtils.isEmpty(list)) {
					charge.setProductType(((Dict) list.get(0)).getDictName());
				} else {
					charge.setProductType("-1");
				}
				charge.setReceive(receive[i]);
				save(charge);
			}
			// 增加费用
			if (isChargeType[i] == 1) {
				ChargeData chargeData = load(ChargeData.class, id[i]);
				if (cemeteryRegistry!=null) {
					charge.setArchivesCemeteryRegistry(cemeteryRegistry);
				}
				charge.setCount(count[i]);
				charge.setCreateDate(new Date());
				charge.setCreateOrgId(user.getDeptid());
				charge.setCreateUserId(user.getId());
				charge.setIsChargeType(isChargeType[i]);
				charge.setOutStorehouseType(outStorehouseType);
				charge.setPrice(chargeData.getChargeDataPrice());
				charge.setProductName(chargeData.getChargeDataName());
				charge.setProductType(chargeData.getChargeType().getChargeTypeName());
				charge.setReceive(receive[i]);
				save(charge);
			}
		}
	}
	
	/**
	 * 添加商品/费用信息,补录
	 * 
	 * @param archivesCemeteryRegistryId
	 *            :档案办理id,可以为null
	 * @param outStorehouseType
	 *            :出库类型
	 * @param id
	 *            :费用id/商品id
	 * @param isChargeType
	 *            :商品0，费用1
	 * @param count
	 *            :数量
	 * @param receive
	 *            :商品价格
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void addCemeteryChargeList(Long archivesCemeteryRegistryId, long[] id, long[] isChargeType, long[] count, float[] receive,
			User user) throws Exception {
		logger.debug("添加商品/费用信息archivesCemeteryRegistryId:" + archivesCemeteryRegistryId);
		ArchivesCemeteryRegistry cemeteryRegistry = null;
		if (archivesCemeteryRegistryId != null) {
			cemeteryRegistry = load(ArchivesCemeteryRegistry.class, archivesCemeteryRegistryId);
		}
		for (int i = 0; i < receive.length; i++) {
			ArchivesCemeteryCharge charge = new ArchivesCemeteryCharge();
			// 增加商品消费，减少商品库存
			if (isChargeType[i] == 0) {
				CemeteryCommodity commodity = load(CemeteryCommodity.class, id[i]);
				//charge.setCemeteryCommodity(commodity);
				charge.setCemeteryCommodityId(commodity.getId());
				if (cemeteryRegistry!=null) {
					charge.setArchivesCemeteryRegistry(cemeteryRegistry);
				}
				charge.setCount(count[i]);
				charge.setCreateDate(new Date());
				charge.setCreateOrgId(user.getDeptid());
				charge.setCreateUserId(user.getId());
				charge.setIsChargeType(isChargeType[i]);
				charge.setOutStorehouseType(Long.valueOf(Constant.OUT_STOREHOUSE_SELL));
				charge.setPrice(commodity.getOutPrice());
				charge.setProductName(commodity.getCommodityName());
				List<Dict> list = dictService.getDictByCode(commodity.getCommodityType());
				if (!CollectionUtils.isEmpty(list)) {
					charge.setProductType(((Dict) list.get(0)).getDictName());
				} else {
					charge.setProductType("-1");
				}
				charge.setReceive(receive[i]);
				save(charge);
			}
			// 增加费用
			if (isChargeType[i] == 1) {
				ChargeData chargeData = load(ChargeData.class, id[i]);
				if (cemeteryRegistry!=null) {
					charge.setArchivesCemeteryRegistry(cemeteryRegistry);
				}
				charge.setCount(count[i]);
				charge.setCreateDate(new Date());
				charge.setCreateOrgId(user.getDeptid());
				charge.setCreateUserId(user.getId());
				charge.setIsChargeType(isChargeType[i]);
				charge.setOutStorehouseType(Long.valueOf(Constant.OUT_STOREHOUSE_SELL));
				charge.setPrice(chargeData.getChargeDataPrice());
				charge.setProductName(chargeData.getChargeDataName());
				charge.setProductType(chargeData.getChargeType().getChargeTypeName());
				charge.setReceive(receive[i]);
				save(charge);
			}
		}
	}
	
	/**
	 * 根据ID删除商品,如果删除的是商品，把出货数量添加会回商品库存数量
	 * 
	 * @param id
	 */
	public void deleteCemeteryCharge(Long id) {
		ArchivesCemeteryCharge cemeteryCharge = load(ArchivesCemeteryCharge.class, id);
		if (cemeteryCharge!=null && cemeteryCharge.getIsChargeType()!=null) {
			if (Constant.NO == cemeteryCharge.getIsChargeType().intValue()) {
				//CemeteryCommodity cemeteryCommodity = cemeteryCharge.getCemeteryCommodity();
				CemeteryCommodity cemeteryCommodity = load(CemeteryCommodity.class,cemeteryCharge.getCemeteryCommodityId());
				cemeteryCommodity.setCount(cemeteryCommodity.getCount().longValue() + cemeteryCharge.getCount());
				update(cemeteryCommodity);
			}
		}
		delete(cemeteryCharge);
	}
	
	/**
	 * 添加档案文件
	 * 
	 * @param archivesCemeteryRegistryId
	 *            :档案id
	 * @param fileIds
	 *            :文件id字符串,分隔
	 * @param remark
	 *            :文件备注
	 */
	public void saveCemeteryFileList(Long archivesCemeteryRegistryId, String fileIds, String remark) {
		logger.debug("添加档案文件:" + archivesCemeteryRegistryId + "," + fileIds);
		ArchivesCemeteryRegistry cemeteryRegistry = load(ArchivesCemeteryRegistry.class, archivesCemeteryRegistryId);
		String[] file = fileIds.split(",");
		for (int i = 0; i < file.length; i++) {
			ArchivesCemeteryFile cemeteryFile = load(ArchivesCemeteryFile.class, Long.valueOf(file[i]));
			cemeteryFile.setArchivesCemeteryRegistry(cemeteryRegistry);
			cemeteryFile.setRemark(remark);
			update(cemeteryFile);
		}
	}

	public void deleteCemeteryFileById(Long id) {
		logger.debug("删除档案文件:" + id);
		delete(load(ArchivesCemeteryFile.class, id));
	}

	
	/**
	 * 查询等待办理续租，合葬，迁出的列表信息
	 * @param page
	 * @param cemeteryType
	 * @param level :用户机构级别
	 * 
	 * @return
	 */
	public List<ArchivesCemeteryRegistry> getArchivesCemeteryRegistryTypeList(Page page, ArchivesCemeteryRegistry archivesCemeteryRegistry,Long level) {
		logger.debug("page list param:" + archivesCemeteryRegistry);
		
		StringBuffer querySql = new StringBuffer(" FROM ArchivesCemeteryRegistry bt where ");
		
		//登记类型1租用，2续租，3合葬，墓位状态为占用，才可以办理续租，合葬，迁出业务
		querySql.append(" (bt.cemeteryRegistryType = " + Constant.REGEDIT_TYPE_RENT);
		querySql.append(" or bt.cemeteryRegistryType = " + Constant.REGEDIT_TYPE_RELET);
		querySql.append(" or bt.cemeteryRegistryType = " + Constant.REGEDIT_TYPE_MULTI +")");
		querySql.append(" and bt.cemeteryLocation.status = " + Constant.CEMETERY_STATUS_HOLD);
		
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getCemeteryRegistryCode())){
			querySql.append(" and bt.cemeteryRegistryCode like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getName())){
			querySql.append(" and bt.name like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getMobilePhone())){
			querySql.append(" and bt.mobilePhone like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(archivesCemeteryRegistry.getCemeteryLocationId()!=null && 
				archivesCemeteryRegistry.getCemeteryLocationId().longValue()!=0){
			querySql.append(" and bt.cemeteryLocation.id = ? ");
			objlist.add(archivesCemeteryRegistry.getCemeteryLocationId());
			typelist.add(Hibernate.LONG);
		}
		//市级用户查询所有机构信息,市级level=1
		if(level!=null && level.longValue() >1){
			if(archivesCemeteryRegistry.getCreateOrgId()!=null){
				querySql.append(" and bt.createOrgId = ? ");
				objlist.add(archivesCemeteryRegistry.getCreateOrgId());
				typelist.add(Hibernate.LONG);
			}
		}
		
		//逝者姓名
		if (StringUtils.isNotEmpty(archivesCemeteryRegistry.getDealName())) {
			querySql.append("  and (bt in (select bt from bt.archivesDeparteds ad  where ad.name like ? )) ");
			objlist.add("%" + archivesCemeteryRegistry.getDealName() + "%");
			typelist.add(Hibernate.STRING);
		}
		
		//租赁起止日期
		Date beginBuyDate =  archivesCemeteryRegistry.getBeginBuyDate();
		Date endBuyDate =  archivesCemeteryRegistry.getEndBuyDate();
		
		if(beginBuyDate!=null && endBuyDate!=null){
			querySql.append(" and bt.buydate >= ?");
			objlist.add(beginBuyDate);
			typelist.add(Hibernate.DATE); 
			
			querySql.append(" and bt.enddate <= ?");
			objlist.add(endBuyDate);
			typelist.add(Hibernate.DATE); 

		}else{
			if(beginBuyDate!=null){
				querySql.append(" and bt.buydate >= ?");
				objlist.add(beginBuyDate);
				typelist.add(Hibernate.DATE); 
			}
			if(endBuyDate!=null){
				querySql.append(" and bt.enddate <= ?");
				objlist.add(endBuyDate);
				typelist.add(Hibernate.DATE); 
			}
		}
		
		querySql.append(" ORDER BY bt.id desc ");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		
		return (List<ArchivesCemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}

	
	/**
	 * 查询等待补证登记的列表信息
	 * @param page
	 * @param cemeteryType
	 * @return
	 */
	public List<ArchivesCemeteryRegistry> getArchivesCemeteryRegistryCertificateList(Page page, ArchivesCemeteryRegistry archivesCemeteryRegistry,Long level) {
		logger.debug("page list param:" + archivesCemeteryRegistry);
		
		StringBuffer querySql = new StringBuffer(" FROM ArchivesCemeteryRegistry bt where ");
		
		//登记类型1租用 办理补证
		querySql.append(" bt.cemeteryRegistryType = " + Constant.REGEDIT_TYPE_RENT);
		
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getCemeteryRegistryCode())){
			querySql.append(" and bt.cemeteryRegistryCode like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getName())){
			querySql.append(" and bt.name like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(archivesCemeteryRegistry.getMobilePhone())){
			querySql.append(" and bt.mobilePhone like ? ");
			objlist.add("%" + archivesCemeteryRegistry.getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(archivesCemeteryRegistry.getCemeteryLocationId()!=null && 
				archivesCemeteryRegistry.getCemeteryLocationId().longValue()!=0){
			querySql.append(" and bt.cemeteryLocation.id = ? ");
			objlist.add(archivesCemeteryRegistry.getCemeteryLocationId());
			typelist.add(Hibernate.LONG);
		}
		//市级用户查询所有机构信息
		if(level!=null && level.longValue() >1){
			if(archivesCemeteryRegistry.getCreateOrgId()!=null){
				querySql.append(" and bt.createOrgId = ? ");
				objlist.add(archivesCemeteryRegistry.getCreateOrgId());
				typelist.add(Hibernate.LONG);
			}
		}
		
		//逝者姓名
		if (StringUtils.isNotEmpty(archivesCemeteryRegistry.getDealName())) {
			querySql.append("  and (bt in (select bt from bt.archivesDeparteds ad  where ad.name like ? )) ");
			objlist.add("%" + archivesCemeteryRegistry.getDealName() + "%");
			typelist.add(Hibernate.STRING);
		}
		
		//租赁起止日期
		Date beginBuyDate =  archivesCemeteryRegistry.getBeginBuyDate();
		Date endBuyDate =  archivesCemeteryRegistry.getEndBuyDate();
		
		if(beginBuyDate!=null && endBuyDate!=null){
			querySql.append(" and bt.buydate >= ?");
			objlist.add(beginBuyDate);
			typelist.add(Hibernate.DATE); 
			
			querySql.append(" and bt.enddate <= ?");
			objlist.add(endBuyDate);
			typelist.add(Hibernate.DATE); 

		}else{
			if(beginBuyDate!=null){
				querySql.append(" and bt.buydate >= ?");
				objlist.add(beginBuyDate);
				typelist.add(Hibernate.DATE); 
			}
			if(endBuyDate!=null){
				querySql.append(" and bt.enddate <= ?");
				objlist.add(endBuyDate);
				typelist.add(Hibernate.DATE); 
			}
		}
		
		querySql.append(" ORDER BY bt.id desc ");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		
		return (List<ArchivesCemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
}
