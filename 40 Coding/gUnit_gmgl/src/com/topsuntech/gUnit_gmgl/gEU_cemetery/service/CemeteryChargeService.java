package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;
import org.springframework.util.CollectionUtils;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCommodity;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeData;
import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;
import com.topsuntech.gUnit_gmgl.gEU_system.service.DictService;

public class CemeteryChargeService extends HibernateBaseService {

	private DictService dictService;

	/**
	 * 获得商品列表
	 * 
	 * @param page
	 * @param cemeteryCommodity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryCharge> getCemeteryChargeList(Page page, CemeteryCharge cemeteryCharge) {
		logger.debug("page list param:" + cemeteryCharge);

		StringBuffer querySql = new StringBuffer(" FROM CemeteryCharge bt WHERE 1=1 ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();

		if (StringUtils.isNotEmpty(cemeteryCharge.getProductName())) {
			querySql.append(" and bt.productName like ? ");
			objlist.add("%" + cemeteryCharge.getProductName() + "%");
			typelist.add(Hibernate.STRING);
		}
		List<Dict> list = dictService.getDictByCode(cemeteryCharge.getProductType());
		if (StringUtils.isNotEmpty(cemeteryCharge.getProductType())  && !"-1".equals(cemeteryCharge.getProductType())) {
			if (!CollectionUtils.isEmpty(list)) {
				querySql.append(" and bt.productType like ? ");
				objlist.add("%" + ((Dict) list.get(0)).getDictName() + "%");
				typelist.add(Hibernate.STRING);
			}
		}
		if(cemeteryCharge.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(cemeteryCharge.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		querySql.append(" ORDER BY bt.createDate desc ");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<CemeteryCharge>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}

	// /**
	// * 根据ID获取商品
	// * @param pid
	// * @return
	// */
	public CemeteryCharge getCemeteryCharge(Long id) {
		CemeteryCharge cemeteryCharge = load(CemeteryCharge.class, id);
		if (cemeteryCharge != null) {
			return cemeteryCharge;
		} else {
			return null;
		}
	}

	/**
	 * 添加或修改
	 * 
	 * @param command
	 */
	public void saveCemeteryCharge(CemeteryCharge command) {
		CemeteryCharge type = null;
		if (command.getId() != null && command.getId().longValue() > 0) {
			// id>0编辑
			type = load(CemeteryCharge.class, command.getId());
		} else {
			// 新增
			type = new CemeteryCharge();
		}
		// type.setCommodityName(command.getCommodityName());
		// type.setCommodityType(command.getCommodityType());
		// type.setOutPrice(command.getOutPrice());
		// type.setInPrice(command.getInPrice());
		// type.setCreateDate(command.getCreateDate());
		// type.setCount(command.getCount());
		// type.setSpecifications(command.getSpecifications());
		type.setCreateUserId(command.getCreateUserId());
		saveOrUpdate(type);
	}

	/**
	 * 根据ID删除商品,如果删除的是商品，把出货数量添加会回商品库存数量
	 * 
	 * @param id
	 */
	public void deleteCemeteryCharge(Long id) {
		CemeteryCharge cemeteryCharge = load(CemeteryCharge.class, id);
		if (cemeteryCharge!=null && cemeteryCharge.getIsChargeType()!=null) {
			if (Constant.NO == cemeteryCharge.getIsChargeType().intValue()) {
				CemeteryCommodity cemeteryCommodity = cemeteryCharge.getCemeteryCommodity();
				cemeteryCommodity.setCount(cemeteryCommodity.getCount().longValue() + cemeteryCharge.getCount());
				update(cemeteryCommodity);
			}
		}
		delete(cemeteryCharge);
	}

	/**
	 * 添加商品/费用信息
	 * 
	 * @param cemeteryRegistryId
	 *            :业务办理id,可以为null
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
	public void addCemeteryChargeList(Long cemeteryRegistryId, long outStorehouseType, long[] id, long[] isChargeType, long[] count, float[] receive,
			User user) throws Exception {
		logger.debug("添加商品/费用信息cemeteryRegistryId:" + cemeteryRegistryId);
		CemeteryRegistry cemeteryRegistry = null;
		if (cemeteryRegistryId != null) {
			cemeteryRegistry = load(CemeteryRegistry.class, cemeteryRegistryId);
		}
		for (int i = 0; i < receive.length; i++) {
			CemeteryCharge charge = new CemeteryCharge();
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
				charge.setCemeteryCommodity(commodity);
				if (cemeteryRegistry!=null) {
					charge.setCemeteryRegistry(cemeteryRegistry);
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
					charge.setCemeteryRegistry(cemeteryRegistry);
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
	 * @param cemeteryRegistryId
	 *            :业务办理id,可以为null
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
	public void addCemeteryChargeList(Long cemeteryRegistryId, long[] id, long[] isChargeType, long[] count, float[] receive,
			User user) throws Exception {
		logger.debug("添加商品/费用信息cemeteryRegistryId:" + cemeteryRegistryId);
		CemeteryRegistry cemeteryRegistry = null;
		if (cemeteryRegistryId != null) {
			cemeteryRegistry = load(CemeteryRegistry.class, cemeteryRegistryId);
		}
		for (int i = 0; i < receive.length; i++) {
			CemeteryCharge charge = new CemeteryCharge();
			// 增加商品消费，减少商品库存
			if (isChargeType[i] == 0) {
				CemeteryCommodity commodity = load(CemeteryCommodity.class, id[i]);
				charge.setCemeteryCommodity(commodity);
				if (cemeteryRegistry!=null) {
					charge.setCemeteryRegistry(cemeteryRegistry);
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
					charge.setCemeteryRegistry(cemeteryRegistry);
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

	public DictService getDictService() {
		return dictService;
	}

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	public void deleteCemeteryChargeSupply(Long id) {
		CemeteryCharge cemeteryCharge = load(CemeteryCharge.class, id);
		delete(cemeteryCharge);
	}

}
