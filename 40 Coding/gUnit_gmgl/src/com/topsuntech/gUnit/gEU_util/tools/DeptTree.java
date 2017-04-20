package com.topsuntech.gUnit.gEU_util.tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.RowSet;

import com.runqian.base4.util.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.en.region.Region;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_util.forms.DictBean;
import com.topsuntech.gUnit.gEU_util.vo.AreaInfo;

/**
 * 权限管理、单位选择类
 * 
 * @公司：清华紫光
 * @作者：杨庆祥
 * @创建日期：2007-4-9
 * @版本：1.0
 * @接口：
 */
public class DeptTree {

	private static DBWrapper db = DBRegistry.getDefaultDBWrapper();
	private long treecount = 1;
	/**
	 * 默认样式类
	 */
	private final static String STYLE_CLASS = "form_text1";

	/**
	 * 初始化组织机构查询页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @throws SQLException
	 */
	public void init(HttpServletRequest request) throws Exception {

		// 从SESSION中取得用户信息
		User user = UserSession.getUser(request);
		// 用户未登录
		if (user == null)
			return;

		AreaInfo area = Dicts.getAreaInfoByUserId(user.getId());
		// 取得用户所属区域信息
		Long role = this.getRoleByUser(user.getId());

		// 区域级别
		long level = Tools.str2Long(request.getParameter("level")).longValue();
		// 对象ID值
		Long objId = Tools.str2Long(request.getParameter("objId"));
		// 对象名称值
		String objName = request.getParameter("objName");
		// 方法
		StringBuffer sbMethod = new StringBuffer();
		// 样式CSS类
		String styleClass = request.getParameter("styleClass");
		if (Tools.isEmpty(styleClass)) {
			styleClass = STYLE_CLASS;
		}
		// 有没有取消按钮
		String canClear = request.getParameter("canClear");
		if (!"yes".equalsIgnoreCase(canClear)) {
			canClear = "no";
		} else {
			canClear = "yes";
		}

		// added by pengzuocong 2012-10-31
		String hiddenSelect = request.getParameter("hiddenSelect");
		if (!"yes".equalsIgnoreCase(hiddenSelect))
			hiddenSelect = "no";
		else
			hiddenSelect = "yes";

		// 判断是否有初始值
		if (!Tools.isEmptyId(objId)) {
			// 取初始NAME
			objName = request.getParameter("objName");
			if (Tools.isEmpty(objName)) {
				objName = this.getRegionNameById(objId);
			}
		} else {
			// 根据对象级别取对象ID值和对象名称值
			if (level == Constants.AREA_LEVEL.CITY) {
				// 市
				objId = area.getProvinceId();
				objName = this.getRegionNameById(objId);
			} else if (level == Constants.AREA_LEVEL.COUNTRY) {
				// 区县
				objId = area.getCountyId();
				objName = this.getRegionNameById(objId);
			} else if (level == Constants.AREA_LEVEL.STREET) {
				// 街道
				objId = area.getStreetId();
				objName = this.getRegionNameById(objId);
			}
		}

		// 方法
		String methods = request.getParameter("methods");
		if (!Tools.isEmpty(methods)) {
			String[] method = Tools.stringToKenizer(methods, ",");
			for (int i = 0; i < method.length; i++) {
				String[] arrTmp = Tools.stringToKenizer(method[i], "=");
				sbMethod.append(arrTmp[0] + "=\"javascript:" + arrTmp[1] + "();\" ");
			}
		}

		// 保存信息到HttpServletRequest中
		request.setAttribute("formName", request.getParameter("formName"));
		request.setAttribute("path", request.getParameter("path"));
		request.setAttribute("strParentId", request.getParameter("strParentId"));
		request.setAttribute("strObjId", request.getParameter("strObjId"));
		request.setAttribute("strObjName", request.getParameter("strObjName"));
		request.setAttribute("strParentId", request.getParameter("strParentId"));
		request.setAttribute("objId", objId);
		request.setAttribute("objName", objName);
		request.setAttribute("level", new Long(level));
		request.setAttribute("role", role);
		request.setAttribute("strClears", request.getParameter("strClears"));
		request.setAttribute("methods", sbMethod.toString());
		request.setAttribute("styleClass", styleClass);
		request.setAttribute("canClear", canClear);
		request.setAttribute("hiddenSelect", hiddenSelect);
	}

	/**
	 * 根据区域ID取区域名称
	 * 
	 * @param areaId
	 *            区域ID
	 * @return String 上级区域ID
	 * @throws Exception
	 */
	private String getRegionNameById(Long areaId) throws Exception {
		if (areaId == null || areaId.longValue() == 0)
			return null;
		String areaname = null;
		String strSql = "SELECT A.NAME FROM GOS_REGION A WHERE A.ID = " + areaId;
		RowSet rs = db.executeQuery(strSql);
		try {
			if (rs.next()) {
				areaname = rs.getString("NAME");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			rs = null;
		}

		return areaname;
	}

	/**
	 * 获取下级单位ID和名称列表
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @throws Exception
	 */
	public void childrenOffice(HttpServletRequest request) throws Exception {

		List offices = new ArrayList();

		// 从HttpServletRequest取出参数
		Long deptId = Tools.str2Long(request.getParameter("deptId"));
		String special = request.getParameter("special");

		// 查询下级单位SQL
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" SELECT ID, NAME FROM GOS_REGION A ");
		sbHql.append(" WHERE A.USE_FLAG = " + Constants.USE_FLAG.USE_FLAG_ON);

		if (deptId != null && deptId.longValue() > 0) {
			sbHql.append(" AND A.PARENTID =  ").append(deptId);
			// added by pengzuocong 2012-10-29
			// 如果上级是市级，则区县排除滨海区，查询塘沽区，汉沽区，大港区，开发区
			Region region = (Region) db.load(Region.class, deptId);
			if (region.getLevel() == Constants.AREA_LEVEL.CITY) {
				// 在区划转换表中查询出需要过滤的区划信息
				String excludeRegionId = queryExcludeRegionId();
				sbHql.append(" AND A.ID NOT IN(").append(excludeRegionId).append(")");
				String includeRegionId = queryIncludeRegionId();
				sbHql.append(" OR A.ID IN(").append(includeRegionId).append(")");
			}
			// 用于处理滨海新区登录选择下属区划信息
			if (special != null && "1".equals(special.trim()))
				sbHql.append(" AND A.LEVELID =  ").append(Constants.AREA_LEVEL.COUNTRY);
		} else {
			sbHql.append(" AND A.LEVELID = " + Constants.AREA_LEVEL.CITY);
		}
		sbHql.append(" ORDER BY A.STANDARD_NO ");

		Logger.info("########### SQL:" + sbHql.toString());

		// 执行查询
		RowSet rs = db.executeQuery(sbHql.toString());
		try {
			while (rs.next()) {
				// 添加一个组织机构
				offices.add(new DictBean(rs.getString("ID"), rs.getString("NAME")));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			rs = null;
		}

		if (deptId == null) {
			deptId = new Long(1);
		}

		// 设置到HttpServletRequest中
		request.setAttribute("offices", offices);
		request.setAttribute("formName", request.getParameter("formName"));
		request.setAttribute("objId", request.getParameter("objId"));
		request.setAttribute("objName", request.getParameter("objName"));
		request.setAttribute("level", request.getParameter("level"));
		request.setAttribute("strClears", request.getParameter("strClears"));
		request.setAttribute("deptId", deptId);
		request.setAttribute("deptName", this.getRegionNameById(deptId));
	}

	/**
	 * 查询需要包含的区划信息
	 * 
	 * @return
	 */
	private String queryIncludeRegionId() {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct c.region_id from gos_region_convert c");
		sql.append(" where c.use_flag = ").append(Constants.USE_FLAG.USE_FLAG_ON);
		sql.append(" and c.rule_id = ").append(Constants.regionConvert.BINHAI);
		RowSet rs = null;
		try {
			String excludeRegionId = "";
			rs = db.executeQuery(sql.toString());
			while (rs.next()) {
				excludeRegionId += rs.getLong("region_id") + ",";
			}
			if (excludeRegionId.endsWith(","))
				return excludeRegionId.substring(0, excludeRegionId.length() - 1);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 查询需要排除的区划信息
	 * 
	 * @return
	 */
	private String queryExcludeRegionId() {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct c.parent_id from gos_region_convert c");
		sql.append(" where c.use_flag = ").append(Constants.USE_FLAG.USE_FLAG_ON);
		sql.append(" and c.rule_id = ").append(Constants.regionConvert.BINHAI);
		RowSet rs = null;
		try {
			String excludeRegionId = "";
			rs = db.executeQuery(sql.toString());
			while (rs.next()) {
				excludeRegionId += rs.getLong("parent_id") + ",";
			}
			if (excludeRegionId.endsWith(","))
				return excludeRegionId.substring(0, excludeRegionId.length() - 1);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 根据用户ID取得区域信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return Long 区域信息
	 * @throws TSDBException
	 */
	private Long getRoleByUser(Long userId) throws Exception {

		Long levelId = null;

		// SQL
		StringBuffer sbSql = new StringBuffer("SELECT A.LEVELID ");
		sbSql.append(" FROM GOS_REGION A, GOS_USER B, GOS_DEPT C ");
		sbSql.append(" WHERE A.ID = C.REGIONID AND C.ID = B.DEPTID ");
		sbSql.append(" AND B.ID = " + userId);

		RowSet rs = db.executeQuery(sbSql.toString());
		try {
			if (rs.next()) {
				levelId = new Long(rs.getLong("LEVELID"));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			rs = null;
		}

		return levelId;
	}

	/**
	 * 获取下级单位ID和名称列表
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @throws Exception
	 */
	public void multiSelect(HttpServletRequest request) throws Exception {

		StringBuffer tree = new StringBuffer();
		String javascript = "\"javascript:void(0);\"";
		this.treecount = 1;

		// 从HttpServletRequest取出参数
		Long deptId = Tools.str2Long(request.getParameter("deptId"));
		if (Tools.isEmptyId(deptId)) {
			deptId = UserSession.getUser(request).getWorkdeptid();
		}
		String orgmame = Dicts.getOrgNameById(deptId.longValue(), null);

		tree.append("var treeitem = new Array();\n");
		tree.append("var root = new WebFXTree(\"" + orgmame + "\");\n");
		tree.append("treeitem[0] =  new WebFXTreeItem(" + deptId + ",-1,\" " + orgmame + "\", " + javascript + ");\n");
		tree.append("root.add(treeitem[0]);\n");

		this.addTreeNodes(tree, deptId);

		tree.append("getTree_new();\n");
		tree.append("document.write(root);\n");
		// 设置到HttpServletRequest中
		request.setAttribute("tree", tree.toString());
	}

	/**
	 * 递归树
	 * 
	 * @param tree
	 *            树
	 * @param deptId
	 *            单位ID
	 */
	private void addTreeNodes(StringBuffer tree, Long deptId) {
		List list = Dicts.getOrgChildList(deptId.longValue(), 0);
		for (int i = 1; i < list.size(); i++) {
			Office office = (Office) list.get(i);
			String javascript = "\"javascript:void(0);\"";
			this.addTreeNode(tree, this.treecount, office.getId(), deptId, office.getName(), javascript);
			this.treecount++;
			// this.addTreeNodes(tree, office.getId());
		}
	}

	/**
	 * 给树添加一个结点
	 * 
	 * @param tree
	 *            树
	 * @param treecount
	 *            结点数
	 * @param nodeId
	 *            结点ID
	 * @param parentId
	 *            结点上级ID
	 * @param nodeName
	 *            结点名称
	 * @param javascript
	 *            调用JS
	 */
	private void addTreeNode(StringBuffer tree, long treecount, Long nodeId, Long parentId, String nodeName, String javascript) {
		tree.append("treeitem[" + treecount + "] =  new WebFXTreeItem(" + nodeId + ", " + parentId + ", \"" + nodeName + "\", " + javascript + ");\n");
	}

	public void separateRegion(HttpServletRequest request) throws Exception {

		List offices = new ArrayList();
		Long parentId = Tools.str2Long(request.getParameter("parentId"));
		if (Tools.isEmptyId(parentId)) {
			parentId = new Long(9100);
		}

		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" SELECT r.ID, r.NAME FROM GOS_REGION r ");
		sbSql.append(" WHERE r.USE_FLAG = 1 AND r.NAME LIKE '%散居' ");
		sbSql.append(" AND r.PARENTID IN (");
		sbSql.append(" SELECT t.ID FROM GOS_REGION t WHERE t.ID <> ").append(parentId);
		sbSql.append(" AND t.PARENTID = (");
		sbSql.append(" SELECT PARENTID FROM GOS_REGION WHERE ID = ").append(parentId);
		sbSql.append(" ) )");
		sbSql.append(" ORDER BY r.NUM ");

		// 执行SQL语句查询
		RowSet rs = db.executeQuery(sbSql.toString());
		while (rs.next()) {
			offices.add(new DictBean(rs.getString("ID"), rs.getString("NAME")));
		}

		// 设置到HttpServletRequest中
		request.setAttribute("offices", offices);
		request.setAttribute("formName", request.getParameter("formName"));
		request.setAttribute("objId", request.getParameter("objId"));
		request.setAttribute("objName", request.getParameter("objName"));
		request.setAttribute("strClears", request.getParameter("strClears"));
		request.setAttribute("deptId", parentId);
		request.setAttribute("deptName", this.getRegionNameById(parentId));
	}
}
