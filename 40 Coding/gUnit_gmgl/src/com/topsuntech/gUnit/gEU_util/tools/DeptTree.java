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
 * Ȩ�޹�����λѡ����
 * 
 * @��˾���廪�Ϲ�
 * @���ߣ�������
 * @�������ڣ�2007-4-9
 * @�汾��1.0
 * @�ӿڣ�
 */
public class DeptTree {

	private static DBWrapper db = DBRegistry.getDefaultDBWrapper();
	private long treecount = 1;
	/**
	 * Ĭ����ʽ��
	 */
	private final static String STYLE_CLASS = "form_text1";

	/**
	 * ��ʼ����֯������ѯҳ��
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @throws SQLException
	 */
	public void init(HttpServletRequest request) throws Exception {

		// ��SESSION��ȡ���û���Ϣ
		User user = UserSession.getUser(request);
		// �û�δ��¼
		if (user == null)
			return;

		AreaInfo area = Dicts.getAreaInfoByUserId(user.getId());
		// ȡ���û�����������Ϣ
		Long role = this.getRoleByUser(user.getId());

		// ���򼶱�
		long level = Tools.str2Long(request.getParameter("level")).longValue();
		// ����IDֵ
		Long objId = Tools.str2Long(request.getParameter("objId"));
		// ��������ֵ
		String objName = request.getParameter("objName");
		// ����
		StringBuffer sbMethod = new StringBuffer();
		// ��ʽCSS��
		String styleClass = request.getParameter("styleClass");
		if (Tools.isEmpty(styleClass)) {
			styleClass = STYLE_CLASS;
		}
		// ��û��ȡ����ť
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

		// �ж��Ƿ��г�ʼֵ
		if (!Tools.isEmptyId(objId)) {
			// ȡ��ʼNAME
			objName = request.getParameter("objName");
			if (Tools.isEmpty(objName)) {
				objName = this.getRegionNameById(objId);
			}
		} else {
			// ���ݶ��󼶱�ȡ����IDֵ�Ͷ�������ֵ
			if (level == Constants.AREA_LEVEL.CITY) {
				// ��
				objId = area.getProvinceId();
				objName = this.getRegionNameById(objId);
			} else if (level == Constants.AREA_LEVEL.COUNTRY) {
				// ����
				objId = area.getCountyId();
				objName = this.getRegionNameById(objId);
			} else if (level == Constants.AREA_LEVEL.STREET) {
				// �ֵ�
				objId = area.getStreetId();
				objName = this.getRegionNameById(objId);
			}
		}

		// ����
		String methods = request.getParameter("methods");
		if (!Tools.isEmpty(methods)) {
			String[] method = Tools.stringToKenizer(methods, ",");
			for (int i = 0; i < method.length; i++) {
				String[] arrTmp = Tools.stringToKenizer(method[i], "=");
				sbMethod.append(arrTmp[0] + "=\"javascript:" + arrTmp[1] + "();\" ");
			}
		}

		// ������Ϣ��HttpServletRequest��
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
	 * ��������IDȡ��������
	 * 
	 * @param areaId
	 *            ����ID
	 * @return String �ϼ�����ID
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
	 * ��ȡ�¼���λID�������б�
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @throws Exception
	 */
	public void childrenOffice(HttpServletRequest request) throws Exception {

		List offices = new ArrayList();

		// ��HttpServletRequestȡ������
		Long deptId = Tools.str2Long(request.getParameter("deptId"));
		String special = request.getParameter("special");

		// ��ѯ�¼���λSQL
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" SELECT ID, NAME FROM GOS_REGION A ");
		sbHql.append(" WHERE A.USE_FLAG = " + Constants.USE_FLAG.USE_FLAG_ON);

		if (deptId != null && deptId.longValue() > 0) {
			sbHql.append(" AND A.PARENTID =  ").append(deptId);
			// added by pengzuocong 2012-10-29
			// ����ϼ����м����������ų�����������ѯ�����������������������������
			Region region = (Region) db.load(Region.class, deptId);
			if (region.getLevel() == Constants.AREA_LEVEL.CITY) {
				// ������ת�����в�ѯ����Ҫ���˵�������Ϣ
				String excludeRegionId = queryExcludeRegionId();
				sbHql.append(" AND A.ID NOT IN(").append(excludeRegionId).append(")");
				String includeRegionId = queryIncludeRegionId();
				sbHql.append(" OR A.ID IN(").append(includeRegionId).append(")");
			}
			// ���ڴ������������¼ѡ������������Ϣ
			if (special != null && "1".equals(special.trim()))
				sbHql.append(" AND A.LEVELID =  ").append(Constants.AREA_LEVEL.COUNTRY);
		} else {
			sbHql.append(" AND A.LEVELID = " + Constants.AREA_LEVEL.CITY);
		}
		sbHql.append(" ORDER BY A.STANDARD_NO ");

		Logger.info("########### SQL:" + sbHql.toString());

		// ִ�в�ѯ
		RowSet rs = db.executeQuery(sbHql.toString());
		try {
			while (rs.next()) {
				// ���һ����֯����
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

		// ���õ�HttpServletRequest��
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
	 * ��ѯ��Ҫ������������Ϣ
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
	 * ��ѯ��Ҫ�ų���������Ϣ
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
	 * �����û�IDȡ��������Ϣ
	 * 
	 * @param userId
	 *            �û�ID
	 * @return Long ������Ϣ
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
	 * ��ȡ�¼���λID�������б�
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @throws Exception
	 */
	public void multiSelect(HttpServletRequest request) throws Exception {

		StringBuffer tree = new StringBuffer();
		String javascript = "\"javascript:void(0);\"";
		this.treecount = 1;

		// ��HttpServletRequestȡ������
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
		// ���õ�HttpServletRequest��
		request.setAttribute("tree", tree.toString());
	}

	/**
	 * �ݹ���
	 * 
	 * @param tree
	 *            ��
	 * @param deptId
	 *            ��λID
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
	 * �������һ�����
	 * 
	 * @param tree
	 *            ��
	 * @param treecount
	 *            �����
	 * @param nodeId
	 *            ���ID
	 * @param parentId
	 *            ����ϼ�ID
	 * @param nodeName
	 *            �������
	 * @param javascript
	 *            ����JS
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
		sbSql.append(" WHERE r.USE_FLAG = 1 AND r.NAME LIKE '%ɢ��' ");
		sbSql.append(" AND r.PARENTID IN (");
		sbSql.append(" SELECT t.ID FROM GOS_REGION t WHERE t.ID <> ").append(parentId);
		sbSql.append(" AND t.PARENTID = (");
		sbSql.append(" SELECT PARENTID FROM GOS_REGION WHERE ID = ").append(parentId);
		sbSql.append(" ) )");
		sbSql.append(" ORDER BY r.NUM ");

		// ִ��SQL����ѯ
		RowSet rs = db.executeQuery(sbSql.toString());
		while (rs.next()) {
			offices.add(new DictBean(rs.getString("ID"), rs.getString("NAME")));
		}

		// ���õ�HttpServletRequest��
		request.setAttribute("offices", offices);
		request.setAttribute("formName", request.getParameter("formName"));
		request.setAttribute("objId", request.getParameter("objId"));
		request.setAttribute("objName", request.getParameter("objName"));
		request.setAttribute("strClears", request.getParameter("strClears"));
		request.setAttribute("deptId", parentId);
		request.setAttribute("deptName", this.getRegionNameById(parentId));
	}
}
