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
//	 * 1����ID ȥ��������һ��˳����Ƕ��� 2���Ҫ�Ƶı���С�Ĵ� �ǽ������� 3���� ���������� 3.1 �������ر����������ֶ�
//	 * ��Ҫ�������Ƶ���һ����¼�������ֶ��Ƕ��٣� 3.2 ����3.1 ��������¼ ���������������ֶ�SET Ϊ�ӵ���orderByItem 3.3
//	 * ����ID �޸������������ֶ� ֵΪ3.1���������
//	 * 
//	 * @throws SQLException
//	 */
//	public void toMoveUp(String id, String orderByItem, String country) throws TSDBException, SQLException {
//
//		// 1
//		SjRegion region = queryMinRegionByUpCode(country, null);
//		int minItem = region.getOrderByItem();// �õ������������һ�������
//		int orderItem = Integer.parseInt(orderByItem);// Ҫ�������Ʋ����� ��ǰ�����
//		// 2
//		SjRegion upRegion = new SjRegion();
//		SjRegion toUpRegion = new SjRegion();
//		if (orderItem == minItem) {
//		} else {
//			// 3
//			// 3.1
//			SjRegion maxRegion = queryMaxRegionByUpCode(country, orderByItem);
//			int temItem = maxRegion.getOrderByItem();// Ŀ�����
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
//		int maxItem = region.getOrderByItem();// �õ��������������һ�������
//		int orderItem = Integer.parseInt(orderByItem);// Ҫ�������Ʋ����� ��ǰ�����
//		// 2
//		SjRegion downRegion = new SjRegion();
//		SjRegion toDownRegion = new SjRegion();
//		if (orderItem == maxItem) {
//		} else {
//			// 3
//			// 3.1
//			SjRegion minRegion = queryMinRegionByUpCode(country, orderByItem);
//			int temItem = minRegion.getOrderByItem();// Ŀ�����
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
//	 * ��ѯ�û�����������ֵ
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
	 * ������������ ��ѯ���ݿ����Ƿ����
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
		if (list != null && list.size() >= 1) {// ������� ��ô�ܾ�
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
