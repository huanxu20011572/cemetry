/*
 * Created on 2008-1-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_system.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.RowSet;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;
import com.topsuntech.gUnit.gEU_util.methods.PBMethod;

/**
 * @author Ibm
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class RegionService {
	static SJBaseDAO dao = new SJBaseDAO();
	private static DBWrapper db = DBRegistry.getDefaultDBWrapper();

	public static SjRegion getRegion(Long regionId) {
		SjRegion region = null;

		if (regionId != null && regionId.longValue() > 0) {
			try {
				region = (SjRegion) dao.getEntity(SjRegion.class, regionId);
			} catch (TSDBException e) {
				e.printStackTrace();
			}
		}

		return region;
	}

	public static void insertRegion(SjRegion region) throws TSDBException {
		dao.addEntity(region);
	}

	public static void updateRegion(SjRegion region) throws TSDBException {
		dao.updateEntity(region);
	}

	public static List queryRegionByUpCode(String quCode, Page page) throws TSDBException {
		List list = null;
		StringBuffer sql = new StringBuffer();
		if (quCode != null && !quCode.equals("")) {
			sql.append(" select * from gos_region r where r.parentid=(select t.id from gos_region t where  1=1");
			sql.append(" and t.STANDARD_NO=").append(quCode).append(") and r.levelid not in(0,1)");

		} else {
			sql.append(" select * from gos_region r where r.levelid not in(0,1) ");
		}
		sql.append(" and r.use_flag=1 order by r.id asc");
		RowSet rs;
		try {
			rs = PBMethod.queryForOracle(sql.toString(), page, dao.getDBWrapper());
			list = PBMethod.rs2MapListAndClose(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//
//	/**
//	 * 1根据ID 去查区域表第一个顺序号是多少 2如果要移的比最小的大 那进行上移 3否则 不进行上移 3.1 根据区县编码与排序字段
//	 * 查要进行上移的上一条记录的排序字段是多少； 3.2 根据3.1 查出这个记录 并把其它的排序字段SET 为接到的orderByItem 3.3
//	 * 根据ID 修改区域表的排序字段 值为3.1所定义序号
//	 * 
//	 * @throws SQLException
//	 */
//	public void toMoveUp(String id, String orderByItem, String country) throws TSDBException, SQLException {
//
//		// 1
//		SjRegion region = queryMinRegionByUpCode(country, null);
//		int minItem = region.getOrderByItem();// 得到该区域排序第一个的序号
//		int orderItem = Integer.parseInt(orderByItem);// 要进行上移操作的 当前的序号
//		// 2
//		SjRegion upRegion = new SjRegion();
//		SjRegion toUpRegion = new SjRegion();
//		if (orderItem == minItem) {
//		} else {
//			// 3
//			// 3.1
//			SjRegion maxRegion = queryMaxRegionByUpCode(country, orderByItem);
//			int temItem = maxRegion.getOrderByItem();// 目标序号
//			// 3.2
//			upRegion = queryRegionByUpItem(String.valueOf(temItem));
//			upRegion.setOrderByItem(orderItem);
//			dao.updateEntity(upRegion);
//			// 3.3
//			toUpRegion = getRegion(new Long(id));
//			toUpRegion.setOrderByItem(temItem);
//			dao.updateEntity(toUpRegion);
//		}
//
//	}
//
//	public void toMoveDown(String id, String orderByItem, String country) throws TSDBException, SQLException {
//
//		// 1
//		SjRegion region = queryMaxRegionByUpCode(country, null);
//		int maxItem = region.getOrderByItem();// 得到该区域排序最后一个的序号
//		int orderItem = Integer.parseInt(orderByItem);// 要进行下移操作的 当前的序号
//		// 2
//		SjRegion downRegion = new SjRegion();
//		SjRegion toDownRegion = new SjRegion();
//		if (orderItem == maxItem) {
//		} else {
//			// 3
//			// 3.1
//			SjRegion minRegion = queryMinRegionByUpCode(country, orderByItem);
//			int temItem = minRegion.getOrderByItem();// 目标序号
//			// 3.2
//			downRegion = queryRegionByUpItem(String.valueOf(temItem));
//			downRegion.setOrderByItem(orderItem);
//			dao.updateEntity(downRegion);
//			// 3.3
//			toDownRegion = getRegion(new Long(id));
//			toDownRegion.setOrderByItem(temItem);
//			dao.updateEntity(toDownRegion);
//		}
//
//	}
//
//	public SjRegion queryMinRegionByUpCode(String country, String item) throws TSDBException, SQLException {
//
//		List list = null;
//		SjRegion region = new SjRegion();
//		StringBuffer sql = new StringBuffer();
//		if (country != null && !country.equals("")) {
//			sql.append(" select min(r.orderby_item) as orderby_item from gos_region r where r.parentid=(select t.id from gos_region t where  1=1");
//			sql.append(" and t.region_code=").append(country).append(") and r.levelid not in(0,1)");
//			if (item != null && !item.equals(""))
//				sql.append(" and r.orderby_item>").append(item);
//			sql.append(" and r.use_flag=1 order by r.orderby_item asc");
//		}
//		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
//		// System.out.println(">>>>>>>>>>>>>>>sql>>>>>>>>>>>>>>>>"+sql);
//		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
//		//    	
//		if (sql != null && !sql.equals("")) {
//			ResultSet rs = dao.getDBWrapper().executeQuery(sql.toString());
//			while (rs.next()) {
//
//				region.setOrderByItem(rs.getInt("orderby_item"));
//			}
//		}
//
//		return region;
//	}
//
//	public SjRegion queryMaxRegionByUpCode(String country, String item) throws TSDBException, SQLException {
//
//		List list = null;
//		SjRegion region = new SjRegion();
//		StringBuffer sql = new StringBuffer();
//		if (country != null && !country.equals("")) {
//			sql.append(" select max(r.orderby_item) as orderby_item from gos_region r where r.parentid=(select t.id from gos_region t where  1=1");
//			sql.append(" and t.region_code=").append(country).append(") and r.levelid not in(0,1)");
//			if (item != null && !item.equals(""))
//				sql.append(" and r.orderby_item<").append(item);
//			sql.append(" and r.use_flag=1 order by r.orderby_item asc");
//		}
//		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
//		// System.out.println(">>>>>>>>>>>>>>>queryMaxRegionByUpCode>>>>>>>>>>>>>>>>"+sql);
//		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
//
//		if (sql != null && !sql.equals("")) {
//			ResultSet rs = dao.getDBWrapper().executeQuery(sql.toString());
//			while (rs.next()) {
//
//				region.setOrderByItem(rs.getInt("orderby_item"));
//			}
//		}
//
//		return region;
//	}
//
//	public SjRegion queryRegionByUpItem(String item) throws TSDBException, SQLException {
//
//		List list = null;
//		SjRegion region = new SjRegion();
//		StringBuffer sql = new StringBuffer();
//		if (item != null && !item.equals("")) {
//			sql.append("  from SjRegion r where   1=1 ");
//			sql.append(" and r.orderByItem=").append(item);
//			sql.append(" order by r.orderByItem asc");
//		}
//		if (sql != null && !sql.equals("")) {
//			list = dao.queryList(sql.toString());
//			if (list != null && list.size() > 0)
//				region = (SjRegion) list.get(0);
//		}
//
//		return region;
//	}
//
//	/**
//	 * 查询用户的最大的排序值
//	 * 
//	 * @param
//	 * @return
//	 */
//	public int getMaxOrderItem() {
//		int maxOrderItem = 0;
//		ResultSet rs = null;
//		StringBuffer sql = new StringBuffer();
//		sql.append(" select max(u.orderby_item) from gos_region u  ");
//		try {
//			rs = db.executeQuery(sql.toString());
//			if (rs.next()) {
//				maxOrderItem = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return maxOrderItem;
//	}

	/**
	 * 根据区域名称 查询数据库中是否存在
	 * 
	 * @param logid
	 * @return
	 */
	public static boolean checkRegionName(String regionName) {
		List list = null;
		StringBuffer hsql = new StringBuffer();
		hsql.append(" FROM SjRegion t WHERE t.useFlag=1 ");
		if (regionName != null && !regionName.equals(""))
			hsql.append(" AND t.name ='").append(regionName).append("'");
		try {
			list = db.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		if (list != null && list.size() >= 1) {// 如果存在 那么拒绝
			return false;
		}
		return true;
	}

	public static Long queryRegionidByCode(String code) throws TSDBException {
		List list = null;
		Long regionid = null;
		StringBuffer hsql = new StringBuffer();
		hsql.append(" FROM SjRegion t WHERE t.useFlag=1 ");
		if (code != null && !code.equals(""))
			hsql.append(" AND t.standardNo ='").append(code).append("'");
		try {
			list = db.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		if (list != null && list.size() != 0) {
			SjRegion region = (SjRegion) list.get(0);
			regionid = region.getId();
		}

		return regionid;
	}

}
