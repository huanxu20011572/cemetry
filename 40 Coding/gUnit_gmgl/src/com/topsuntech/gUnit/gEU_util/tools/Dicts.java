package com.topsuntech.gUnit.gEU_util.tools;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.RowSet;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.core.DBTreeOffice;
import com.topsuntech.gOS.user.core.DBTreeOfficeRecursive;
import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.user.utility.UserSearchUtility;
import com.topsuntech.gUnit.common.util.DateUtils;
import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;
import com.topsuntech.gUnit.gEU_util.dao.StaticBaseDAO;
import com.topsuntech.gUnit.gEU_util.entity.ApMultipickContent;
import com.topsuntech.gUnit.gEU_util.entity.Dept;
import com.topsuntech.gUnit.gEU_util.entity.Dictionary;
import com.topsuntech.gUnit.gEU_util.entity.GosRegionConvert;
import com.topsuntech.gUnit.gEU_util.entity.Region;
import com.topsuntech.gUnit.gEU_util.entity.User;
import com.topsuntech.gUnit.gEU_util.forms.DictBean;
import com.topsuntech.gUnit.gEU_util.forms.ListBean;
import com.topsuntech.gUnit.gEU_util.tools.Constants.QueryRegion;
import com.topsuntech.gUnit.gEU_util.vo.AreaInfo;
import com.topsuntech.gUnit.gEU_util.vo.OfficeVO;

/**
 * @author Lixirong
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class Dicts {
	private StaticBaseDAO staticBaseDAO;

	/**
	 * @param staticBaseDAO
	 *            the staticBaseDAO to set
	 */
	public void setStaticBaseDAO(StaticBaseDAO staticBaseDAO) {
		this.staticBaseDAO = staticBaseDAO;
	}

	private static StaticBaseDAO dao;

	/**
	 * 初始化，用于静态方法是用dao
	 */
	public void init() {
		dao = this.staticBaseDAO;
	}

	// private static DBWrapper db = DBRegistry.getDBWrapper("query");

	// private static DBWrapper defaultDb = DBRegistry.getDefaultDBWrapper();

	private static final String APPROVE_UNIT_CODE = "approveUnitCode";

	private static final String DEPT_LEVEL = "deptLevel";

	// private static StaticTreeService staticTreeService = new
	// StaticTreeServiceImpl();

	/**
	 * 获取区划信息
	 * 
	 * @param regionId
	 * @return
	 * @throws TSDBException
	 */
	private static Region getRegion(Long regionId) throws TSDBException {
		if (regionId != null)
			return (Region) dao.get(Region.class, regionId.longValue());
		return null;
	}

	/**
	 * 数据字典：获取相应的'VALUE'
	 * 
	 * @param dictCode
	 *            '编码'
	 * @param typeName
	 *            '类型名称'
	 * @return
	 * @throws SQLException
	 */
	public static String getDictByCode(String dictCode, String typeName) throws SQLException {
		ResultSet rs = null;
		String name = "";

		if (dictCode == null || dictCode.trim().length() == 0) {
			return name;
		}

		if (typeName == null || typeName.trim().length() == 0) {
			return name;
		}

		String sSql = "SELECT dt.name FROM jz_dictionary dt WHERE dt.val=" + Long.parseLong(dictCode);
		String typeSql = sSql + " AND dt.typename='" + typeName + "' order by dt.ind";

		try {
			rs = dao.executeQuery(typeSql);
			if (rs != null) {
				if (rs.next()) {
					name = rs.getString(1);
				} else {
					rs = dao.executeQuery(sSql);
					if (rs.next()) {
						name = rs.getString(1);
					}
				}
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return name;
	}

	/**
	 * 数据字典：通过'Value'，获取相应的'ID'
	 * 
	 * @param dictId
	 * @return
	 * @throws SQLException
	 */
	public static long getDictionaryKey(String dictName) throws SQLException {
		ResultSet rs = null;
		long dictionaryKey = 0;
		String sSql = "";

		try {
			sSql = "SELECT dt.id FROM jz_dictionary dt WHERE dt.name='" + dictName + "'";
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				if (rs.next())
					dictionaryKey = rs.getLong(1);
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return dictionaryKey;
	}

	/**
	 * 数据字典：获取相应的'Code'
	 * 
	 * @param dictID
	 *            'Id'
	 * @return
	 * @throws SQLException
	 */
	public static String getDictCodeById(long dictId) throws SQLException {
		ResultSet rs = null;
		String code = "";

		try {
			String sSql = "SELECT dt.val FROM jz_dictionary dt WHERE dt.id=" + dictId;
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				if (rs.next()) {
					code = rs.getString(1);
				}
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return code;
	}

	/**
	 * 去掉分隔符
	 * 
	 * @param dictIdStr
	 * @return
	 */
	public static String clearSplit(String dictIdStr) {
		int startIndex = dictIdStr.indexOf(",");
		dictIdStr = startIndex == 0 ? dictIdStr.substring(1, dictIdStr.length()) : dictIdStr;
		int endIndex = dictIdStr.lastIndexOf(",");
		dictIdStr = endIndex == dictIdStr.length() - 1 ? dictIdStr.substring(0, dictIdStr.length() - 1) : dictIdStr;

		return dictIdStr;
	}

	/**
	 * 数据字典：通过'ID'，获取相应的'VALUE'
	 * 
	 * @param dictId
	 * @return
	 * @throws SQLException
	 */
	public static String getDictionaryValueByIdStr(String dictIdStr) throws SQLException {
		ResultSet rs = null;
		String dictionaryValue = "";
		String sSql = "";

		if (dictIdStr == null || dictIdStr.trim().length() == 0)
			return dictionaryValue;
		if (dictIdStr.trim().equals("-1"))
			return dictionaryValue;

		dictIdStr = clearSplit(dictIdStr);

		try {
			sSql = "SELECT dt.name FROM jz_dictionary dt WHERE dt.id in (" + dictIdStr + " ) order by dt.ind";
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				if (rs.next())
					dictionaryValue = rs.getString(1);
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return dictionaryValue;
	}

	/**
	 * 数据字典：通过'ID'，获取相应的'VALUE'
	 * 
	 * @param dictId
	 * @return
	 * @throws SQLException
	 */
	public static String getDictionaryValue(long dictId) {
		try {
			return getDictionaryValueByIdStr(Long.toString(dictId));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 组织机构：通过'ID'，获取相应的'区域名称'
	 * 
	 * @param Id
	 * @param flag
	 *            :null,查询对象为“机构”；rg，查询对象为“区域”
	 * @return
	 * @throws SQLException
	 */
	public static String getOrgNameById(long id, String flag) throws SQLException {
		ResultSet rs = null;
		String orgName = "";
		String sSql = "";

		if (id < 0)
			return orgName;

		try {

			if (flag != null && flag.trim().equals(QueryRegion.REGION))
				sSql = "SELECT dt.name FROM gos_region dt WHERE dt.id=" + id;
			else
				sSql = "SELECT dt.name FROM gos_dept dt WHERE dt.id=" + id;

			rs = dao.executeQuery(sSql);
			if (rs != null) {
				if (rs.next())
					orgName = rs.getString(1);
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return orgName;
	}

	/**
	 * 组织机构：通过'ID'，获取相应的'机构编码'
	 * 
	 * @param dictId
	 * @return
	 * @throws SQLException
	 */
	public static String getUnitNumById(long deptId) throws SQLException {
		ResultSet rs = null;
		String unitNum = "";
		String sSql = "";

		try {
			sSql = "SELECT dt.num FROM gos_dept dt WHERE dt.id=" + deptId;
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				if (rs.next())
					unitNum = rs.getString(1);
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return unitNum;
	}

	/**
	 * 获取‘组织机构节点’下的'成员ID'串
	 * 
	 * @param deptId
	 *            '组织机构ID'
	 * @return
	 * @throws SQLException
	 */
	public static String getUnitNodeDownMemberStr(long deptId) throws SQLException {
		ResultSet rs = null;
		String idStr = "";

		try {
			String sSql = "SELECT u.id FROM gos_user u WHERE u.deptid=" + deptId;
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				while (rs.next()) {
					if (idStr.trim().length() == 0)
						idStr = Long.toString(rs.getLong(1));
					else
						idStr += "," + Long.toString(rs.getLong(1));
				}
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}
		return idStr;
	}

	/**
	 * 判断当前的节点，是否存在子节点
	 * 
	 * @param dictId
	 * @return
	 * @throws SQLException
	 */
	public static boolean getJudgeChildNod(long dictId) throws SQLException {
		boolean bExist = false;
		ResultSet rs = null;

		String sSql = " SELECT count(*) FROM jz_dictionary d WHERE d.use_flag =1 and d.parentid= " + dictId + " order by d.ind";
		try {
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				if (rs.next()) {
					if (rs.getLong(1) > 0)
						bExist = true;
				} else {
					bExist = false;
				}
			}

		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return bExist;
	}

	/**
	 * 数据字典: 通过节点'ID'，获取'下一级子节点'
	 * 
	 * @param dictId
	 *            '字典ID'
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List getDictionaryList(long dictId) throws SQLException {
		ResultSet rs = null;
		List list = new ArrayList();
		String sSql = "";

		try {
			sSql = " SELECT d.id,d.name FROM jz_dictionary d WHERE d.use_flag =1 and d.parentid IN (";
			sSql += "SELECT dt.id FROM jz_dictionary dt WHERE dt.id=" + dictId + " )order by d.ind";

			rs = dao.executeQuery(sSql);
			if (rs != null) {
				while (rs.next()) {
					list.add(new ListBean(rs.getInt(1), rs.getString(2)));
				}
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}

	/**
	 * 数据字典: 通过节点'ID'，获取'下一级子节点'
	 * 
	 * @param code
	 *            '字典编码'
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List getDictsListByCode(String typeName) throws SQLException {
		ResultSet rs = null;
		List list = new ArrayList();
		String sSql = "";

		try {
			sSql = " SELECT d.id,d.name,d.corresponding_id FROM jz_dictionary d WHERE d.use_flag =1 and d.parentid IN (";
			sSql += "SELECT dt.id FROM jz_dictionary dt WHERE dt.typename='" + typeName + "' ) order by d.ind asc ";
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				while (rs.next()) {
					list.add(new DictBean(rs.getString(1), rs.getString(2), new Long(rs.getLong(3))));
				}
			}
		} catch (SQLException e) {
			Logger.error("load dict error", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * 数据字典: 通过节点'ID'，获取'下一级子节点'
	 * 
	 * @param code
	 *            '字典编码'
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List getDictCodeListByTypeName(String typeName) throws SQLException {
		ResultSet rs = null;
		List list = new ArrayList();
		String sSql = "";

		try {
			sSql = " SELECT d.val,d.name FROM jz_dictionary d WHERE d.status =1 and d.parentid IN (";
			sSql += "SELECT dt.id FROM jz_dictionary dt WHERE dt.typename='" + typeName + "' ) order by d.ind asc ";

			rs = dao.executeQuery(sSql);
			if (rs != null) {
				while (rs.next()) {
					list.add(new DictBean(rs.getString(1), rs.getString(2)));
				}
			}
		} catch (SQLException e) {
			Logger.error("load dict error", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * 获取'多选'值对象字符串
	 * 
	 * @param obj
	 *            '对象：checkbox,radio'
	 * @param name
	 *            '对象名称'
	 * @param typeName
	 *            '分类名称'
	 * @param selected
	 *            '选中的值'
	 * @param rowNum
	 *            '行显示的个数'
	 * @param valueType
	 *            '数据类型'：0，返回“字典ID”; 1，返回“字典对应值”; 0，返回“字典ID和字典对应值”;
	 * @param showType
	 *            '显示类型：0，全部；1，筛选掉已有的;2,只显示已有的值，不带选择框'
	 * @return
	 * @throws SQLException
	 */
	public static String getChoosesStr(String obj, String name, String typeName, String selected, long rowNum, long showType, String valueType, String showPercentage, String onclick, String percentNum) throws SQLException {
		try {
			StringBuffer sb = new StringBuffer();
			String[] s = name.split("_");
			long ctIndex = -1;
			sb.append("<table border='0' >");
			if (s.length > 0)
				sb.append("<input type='hidden' name='").append(s[1]).append("'  value='' >");
			sb.append("<tr>");
			if (typeName != null && typeName.trim().length() > 0) {
				List dictList = getDictsListByCode(typeName);
				String[] percentNums = null;
				String percentNumsStr = "";
				int len = 0;
				// update for pengzuochong 20080318
				if (percentNum != null && !percentNum.equals("")) {
					percentNums = percentNum.split(",");
					len = percentNums.length;
					for (int j = 0; j < len; j++) {
						if (percentNums[j] != null && percentNums[j].length() != 0) {
							percentNumsStr += percentNums[j] + ",";
						}
					}
					percentNums = percentNumsStr.split(",");
				}
				if (dictList != null) {
					if (showType == 2) {
						int precentFlag = 0;
						for (int i = 0; i < dictList.size(); i++) {
							DictBean bean = (DictBean) dictList.get(i);

							boolean bExist = false;
							if (selected.trim().length() > 0) {
								bExist = Tools.judgeExist(Tools.stringToKenizer(selected, ","), bean.getKey());
							}

							if (bExist == true) {
								sb.append("<td >");
								sb.append(bean.getValue());
								// update for pengzuochong 20080318
								if (percentNums != null) {
									sb.append(percentNums[precentFlag++]);
									sb.append("%");
								}
								sb.append("</td>");

								long k = ctIndex + 1;
								if (k % rowNum == 0) {
									sb.append("</tr>");
									sb.append("<tr>");
								}

								ctIndex++;
							}

						}
					} else {
						int precentFlag = 0;
						for (int i = 0; i < dictList.size(); i++) {
							DictBean bean = (DictBean) dictList.get(i);

							boolean bExist = false;
							if (selected.trim().length() > 0) {
								if (selected.trim().equals("0"))
									bExist = true;
								else {
									bExist = Tools.judgeExist(Tools.stringToKenizer(selected, ","), bean.getKey());
								}
							}

							if (showType == 1 && bExist == true) {
								continue;
							}

							sb.append("<td class=\"sq-tr-03\">");
							sb.append("<input type='").append(obj).append("'");
							sb.append(" name='").append(name).append("'");

							if (valueType == null) {
								sb.append(" value='").append(bean.getKey());
							} else if (valueType.trim().equals("0")) {
								sb.append(" value='").append(bean.getKey());
							} else if (valueType.trim().equals("1")) {
								sb.append(" value='").append(bean.getCorrespondenValue());
							} else {
								sb.append(" value='").append(bean.getKey()).append(",").append(bean.getCorrespondenValue());
							}

							sb.append("'");

							if (bExist == true) {
								sb.append(" checked ");
							}
							if (onclick != null) {
								sb.append(" onclick='").append(onclick).append("'");
							}

							sb.append(" strValue='").append(bean.getValue()).append("'");

							sb.append(" >");
							sb.append("<span id=\"mi_" + "_" + name + "_" + i + "\">");
							sb.append(bean.getValue());
							sb.append("</span>");
							// update lxr 20080226
							if (showPercentage != null && showPercentage.trim().equals("1")) {
								if (bExist == true) {
									sb.append("<td><input type='text' class=\"input_txt\" name='percentNum' value='");
									// update by jiangyi
									if (percentNums != null) {
										sb.append(percentNums[precentFlag++]);
									}
									sb.append("' size='4' >%</td>");
									// if (i < len) {
									// if (percentNums[i] != null
									// && !percentNums[i].equals("")) {
									// sb
									// .append(
									// "<td><input type='text'
									// class=\"input_txt\" name='percentNum'
									// value='")
									// .append(percentNums[i])
									// .append(
									// "' size='4' >%</td>");
									// }
									// } else {
									// sb
									// .append("<td><input type='text'
									// class=\"input_txt\" name='percentNum'
									// value='' size='4' >%</td>");
									// }
								} else {
									sb.append("<td><input type='text' class=\"input_txt\" name='percentNum' value='' size='4' >%</td>");
								}
							}
							sb.append("</td>");

							long k = i + 1;
							if (k % rowNum == 0) {
								sb.append("</tr>");
								sb.append("<tr>");
							}

						}
					}

				}
			}

			sb.append("</tr>");
			sb.append("</table>");
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取当前节点下的所有的子类（treeBean）
	 * 
	 * @param nodeId
	 *            '节点Id'
	 * @return
	 * @throws SQLException
	 * @throws TSDBException
	 */
	public static List getMatterList(long nodeId) throws TSDBException, SQLException {
		List list = getDictionaryList(nodeId);
		List matterList = new ArrayList();

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				ListBean bean = (ListBean) list.get(i);

				boolean b = getJudgeChildNod(bean.getKey());
				if (b == true) {
					List childList = getDictionaryList(bean.getKey());
					List childMatter = new ArrayList();

					if (childList != null) {
						for (int k = 0; k < childList.size(); k++) {
							ListBean mBean = (ListBean) childList.get(k);
							childMatter.add(new ListBean(mBean.getKey(), mBean.getValue()));
						}
					}
					matterList.add(new ListBean(bean.getKey(), bean.getValue(), childMatter));
				}

			}
		}

		return matterList;
	}

	/**
	 * 判断当前的'组织机构'是否存在下级
	 * 
	 * @param deptId
	 *            '组织机构Id'
	 * @return
	 */
	public static boolean judgeExistOrgChild(long deptId) {
		DBTreeOffice dbTree = null;
		List offTree = new ArrayList();

		dbTree = DBTreeOffice.getInstance();
		offTree = dbTree.getChildrenWithItself(deptId);

		if (offTree != null && offTree.size() > 1)
			return true;
		else
			return false;

	}

	/**
	 * 获取当前'组织机构'的上级Id
	 * 
	 * @param deptId
	 *            '组织机构Id'
	 * @return
	 */
	public static long getParentOrgId(long deptId) {
		long parentId = -1;
		try {
			parentId = UserSearchUtility.getParentOfficeId(new Long(deptId)).longValue();
		} catch (Exception e) {
			Logger.debug("get parentId error for " + deptId);
		}

		return parentId;
	}

	/**
	 * 组织机构：获取当前节点下的所有子节点[递归]
	 * 
	 * @param deptId
	 * @return
	 */
	public static List getOrgAllChildList(long deptId) {
		List list = new ArrayList();
		DBTreeOffice dbTree = DBTreeOffice.getInstance();
		list = dbTree.getChildrenWithItself(deptId);
		return list;
	}

	/**
	 * 组织机构：获取当前节点下的所有子节点[不递归] 区县层次：具有审批标识 街道层次：具有审批标识 社区层次：所有社区
	 * 
	 * @param deptId
	 * @param flag
	 *            : 0 过滤>审批标识；1，不过滤；
	 * @return
	 */
	// public static List getOrgChildList(long deptId, long flag) {
	// ResultSet rs = null;
	// List list = new ArrayList();
	// long reginId = getReginIdByDeptId(deptId);
	// if (reginId > 0) {
	// long lev = judgeRegionLevel(new Long(reginId));
	//
	// try {
	// StringBuffer querySql = new StringBuffer();
	// querySql.append("select * from gos_dept dt where dt.regionid in (");
	// querySql.append(" select t.id from gos_region t where t.use_flag=1 and
	// t.parentid=").append(reginId);
	// querySql.append(") and dt.use_flag=1");
	// // 区县
	// if (flag == 0 && lev == Constants.AREA_LEVEL.COUNTRY) {
	// querySql.append(" and dt.approve_unit_code is not null");
	// }
	//
	// querySql.append(" order by dt.disporder asc ");
	//
	// rs = dao.executeQuery(querySql.toString());
	// while (rs.next()) {
	// OfficeVO office = new OfficeVO();
	// office.setName(rs.getString("name"));
	// office.setId(new Long(rs.getLong("id")));
	// office.setRegionid(rs.getLong("regionid"));
	// office.setLevelid(rs.getLong("levelid"));
	// office.setParentId(new Long(rs.getLong("parent_id")));
	// office.setTreeNode(rs.getLong("tree_node"));
	//
	// list.add(office);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (rs != null)
	// try {
	// rs.close();
	// } catch (SQLException e1) {
	// e1.printStackTrace();
	// }
	// }
	//
	// }
	//
	// return list;
	//
	// }
	/**
	 * 将区域id按照编码排列
	 * 
	 * @author jiangyi
	 * @param toList
	 * @return fmtList
	 */
	public static List getOrgOrderByNoList(List toList) {
		List fmtList = new ArrayList();
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(" ");
		if (toList != null && toList.size() != 0) {
			int tolistSize = toList.size();
			for (int i = 0; i < tolistSize; i++) {
				sql.append("," + toList.get(i));
			}
		} else {
			return null;
		}
		try {
			StringBuffer querySql = new StringBuffer();
			querySql.append("select ID from GOS_REGION dt where dt.id in (0");
			querySql.append(sql + ") ");
			querySql.append(" order by dt.STANDARD_NO asc ");

			rs = dao.executeQuery(querySql.toString());
			while (rs.next()) {
				fmtList.add(rs.getString("ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return fmtList;
	}

	/**
	 * 获取 当前的'组织机构节点'下的所有的'子节点编码串'
	 * 
	 * @param deptId
	 *            '组织机构节点ID'
	 * @return
	 */
	public static String getOrgDownAllNodeStr(long deptId) {
		String str = "";
		DBTreeOffice dbTree = DBTreeOfficeRecursive.getInstance();
		List offTree = dbTree.getChildrenWithItself(deptId);

		if (offTree != null) {
			for (int i = 1; i < offTree.size(); i++) {

				Office off = (Office) offTree.get(i);
				// if (off.getNum() == null)
				// Logger.debug("\n----------- off.getNum() :" + off.getNum());

				if (str.trim().equals("")) {
					str = off.getNum().toString();
				} else {
					str += "," + off.getNum().toString();
				}
			}
		}

		return str;

	}

	/**
	 * 获取 当前的'组织机构节点'下的所有的'子节点ID串'
	 * 
	 * @param deptId
	 *            '组织机构节点ID'
	 * @return
	 */
	public static String getOrgDownAllNodeIdStr(long deptId) {
		String str = "";
		DBTreeOffice dbTree = DBTreeOfficeRecursive.getInstance();
		List offTree = dbTree.getChildrenWithItself(deptId);

		if (offTree != null) {
			for (int i = 1; i < offTree.size(); i++) {
				Office off = (Office) offTree.get(i);
				if (str.trim().equals("")) {
					str = off.getId().toString();
				} else {
					str += "," + off.getId().toString();
				}
			}
		}

		return str;

	}

	/**
	 * 判断当前机构的级别
	 * 
	 * @param deptId
	 * @return
	 */
	public static long judgeRoleById(long deptId) throws SQLException {
		long role = 0;
		StringBuffer sSql = new StringBuffer();
		ResultSet rs = null;

		if (deptId == 0) {
			// Logger.debug("\n---------current deptId : " + deptId);
			return role;
		}

		try {
			sSql.append("SELECT t.levelid FROM gos_dept t WHERE t.id=").append(deptId);
			rs = dao.executeQuery(sSql.toString());
			if (rs != null) {
				if (rs.next())
					role = rs.getLong(1);
			}

		} catch (SQLException sqle) {
			throw new SQLException("\n  judgeRoleById.deptId  is error:" + sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return role;
	}

	/**
	 * 根据ID取得机构
	 * 
	 * @param deptId
	 * @return Office
	 * @throws TSDBException
	 */
	public static Dept getDeptById(long deptId) throws TSDBException {
		return (Dept) dao.get(Dept.class, deptId);
	}

	/**
	 * 根据ID取得用户
	 * 
	 * @param userId
	 * @return User
	 * @throws TSDBException
	 */
	public static User getUserById(long userId) throws TSDBException {

		return (User) dao.get(User.class, userId);
	}

	/**
	 * 返回'用户'的'姓名'
	 * 
	 * @param userId
	 *            '用户ID'
	 * @return
	 */
	public static String getUserNameById(long userId) {
		String userName = "";

		User user = getUserInfo(userId);
		if (user != null)
			userName = user.getName();

		return userName;
	}

	/**
	 * 获取‘操作用户’信息
	 * 
	 * @param userId
	 *            '用户Id'
	 * @return
	 */
	public static User getUserInfo(long userId) {
		User user = null;
		StringBuffer sSql = new StringBuffer();
		ResultSet rs = null;

		try {
			sSql.append("SELECT *  FROM gos_user u WHERE u.id = ").append(userId);

			rs = dao.executeQuery(sSql.toString());

			if (rs != null && rs.next()) {
				user = new User();
				user.setLoginid(rs.getString("loginid"));
				user.setId(new Long(rs.getLong("id")));
				user.setName(rs.getString("name"));
				user.setDeptid(rs.getLong("deptid"));
				user.setWorkdeptid(rs.getLong("workdeptid"));
				// user.setDeptname(getOrgNameById(rs.getLong("deptid"), null));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return user;
	}

	/**
	 * 获取'机构ID'-->用于角色
	 * 
	 * @param userId
	 *            '用户ID'
	 * @return
	 * @throws SQLException
	 * @throws TSDBException
	 */
	public static long getRoleDeptIdByUserId(long userId) throws SQLException, TSDBException {
		long roleDeptId = -1;
		ResultSet rs = null;

		User user = null;
		try {
			user = getUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null) {

			long role = judgeRoleById(user.getDeptid());
			if (role == 1) {
				try {
					StringBuffer sSql = new StringBuffer();
					sSql.append(" SELECT t.deptid FROM gos_user t WHERE t.id=").append(userId);

					rs = dao.executeQuery(sSql.toString());
					if (rs != null) {
						if (rs.next())
							roleDeptId = rs.getLong(1);
						else
							roleDeptId = user.getDeptid();
					}
				} catch (SQLException sqle) {
					throw new SQLException("method getRoleDeptIdByDeptId append error : " + sqle.getMessage());
				} finally {
					if (rs != null)
						rs.close();
				}
			} else {
				roleDeptId = user.getDeptid();
			}
		}

		return roleDeptId;

	}

	/**
	 * 获取组织机构ID串
	 * 
	 * @param role
	 *            '角色级别'
	 * @return
	 * @throws Exception
	 */
	public static String getOrgIdStrByRole(long role) throws Exception {
		String str = "";
		ResultSet rs = null;
		StringBuffer sSql = new StringBuffer();

		try {
			sSql.append(" SELECT t.id FROM gos_dept t WHERE t.levelid=").append(role);
			rs = dao.executeQuery(sSql.toString());
			if (rs != null) {
				while (rs.next()) {
					if (str.trim().length() == 0)
						str = Long.toString(rs.getLong(1));
					else
						str += "," + Long.toString(rs.getLong(1));
				}
			}

		} catch (Exception e) {
			throw new Exception("\n  getDeptIdStrByRole is error : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return str;

	}

	/**
	 * 获取'用户Id串'
	 * 
	 * @param deptId
	 *            '机构ID'
	 * @return
	 */
	public static String getUserIdStrByDeptId(long deptId) {
		String idStr = "";

		List list = getUserListByDeptId(deptId);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				User user = (User) list.get(i);
				if (idStr.trim().length() == 0)
					idStr = user.getId().toString();
				else
					idStr += "," + user.getId().toString();
			}
		}

		return idStr;

	}

	/**
	 * 获取'用户信息集合'
	 * 
	 * @param deptId
	 *            '机构ID'
	 * @return
	 */
	public static List getUserListByDeptId(long deptId) {
		DBTreeOffice dbTree = null;
		List userTree = new ArrayList();

		dbTree = DBTreeOffice.getInstance();
		userTree = dbTree.getOfficeUsers(deptId);

		return userTree;
	}

	/**
	 * 获取两日期之间的天数
	 * 
	 * @param beginDate
	 *            '开始日期'
	 * @param endDate
	 *            '结束日期'
	 * @return
	 */
	public static long getBetweenDay(String beginDate, String endDate) {
		int i = DateUtils.getDateYearDay(DateUtils.parseDate(beginDate));
		int j = DateUtils.getDateYearDay(DateUtils.parseDate(endDate));
		return (j - i);
	}

	/**
	 * 获取'当前用户'是否拥用'当前权限'
	 * 
	 * @param user
	 * @param memuId
	 * @return
	 */
	public static int judgeUserRight(User user, int memuId) {
		int e = user.getPriority().indexOf(Integer.toString(memuId));
		return e;
	}

	// public static AreaInfo getAreaInfoByDeptId(Long deptId) throws
	// TSDBException {
	// String hql =
	// "select r from Dept d,Region r where d.regionid = r.id and d.id=" +
	// deptId;
	// List list = dao.queryList(hql);
	// if (list != null && !list.isEmpty()) {
	// AreaInfo info = new AreaInfo();
	// Region region = (Region) list.get(0);
	// while (region.getLevel().intValue() >= Constants.AREA_LEVEL.PROVINCE) {
	// switch (region.getLevel().intValue()) {
	// case (int) Constants.AREA_LEVEL.PROVINCE:// 省
	// info.setProvinceId(region.getId());
	// break;
	// case (int) Constants.AREA_LEVEL.CITY:// 市
	// info.setCityId(region.getId());
	// break;
	// case (int) Constants.AREA_LEVEL.COUNTRY:// 区
	// info.setCountyId(region.getId());
	// break;
	// case (int) Constants.AREA_LEVEL.STREET:// 街
	// info.setStreetId(region.getId());
	// break;
	// case (int) Constants.AREA_LEVEL.COMMUNITY:// 社区
	// info.setCommunityId(region.getId());
	// break;
	// }
	// region = getRegion(region.getParentid());
	// }
	// return info;
	// }
	// return null;
	// }

	// public static AreaInfo getAreaInfoByUserId(Long userId) throws
	// TSDBException {
	// User user = getUserInfo(userId.longValue());
	// if (user != null) {
	// return getAreaInfoByDeptId(new Long(user.getDeptid()));
	// }
	// return null;
	// }

	/**
	 * 根据用户ID查询用户所在区域信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return Region 区域信息
	 * @throws TSDBException
	 */
	public static Region getRegionByUserId(Long userId) throws TSDBException {

		// SQL语句
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" SELECT r FROM User u, Dept d, Region r ");
		sbHql.append(" WHERE u.deptid = d.id AND d.regionid = r.id ");
		sbHql.append(" AND u.id= " + userId);

		// 执行查询
		List list = dao.queryList(sbHql.toString());

		// 如果有数据，则返回第一条
		if (!Tools.isEmpty(list))
			return (Region) list.get(0);
		return null;
	}

	/**
	 * 根据用户ID查询用户所在区域信息
	 * 
	 * @param parentId
	 *            用户ID
	 * @return List 区域信息
	 * @throws TSDBException
	 */
	public static List getRegionByParentId(Long parentId) throws TSDBException {
		return getRegionByParentIdImp(parentId, null);
	}

	/**
	 * 根据用户ID查询用户所在区域信息
	 * 
	 * @param parentId
	 *            用户ID
	 * @return List 区域信息
	 * @throws TSDBException
	 */
	public static List getRegionByParentIdImp(Long parentId, Long treeLev) throws TSDBException {
		List regionList = new ArrayList();

		StringBuffer querySql = new StringBuffer();
		ResultSet rs = null;

		querySql.append("select * from gos_region r where r.use_flag=1 ").append(" and r.parentid=").append(parentId);
		if (treeLev != null)
			querySql.append(" and r.levelid<=").append(treeLev);
		querySql.append(" order by r.CREATEDATE asc ");

		System.out.println("\n -----querySql : " + querySql.toString());

		try {
			rs = dao.executeQuery(querySql.toString());

			if (rs != null) {
				while (rs.next()) {
					com.topsuntech.gOS.user.en.region.Region region = new com.topsuntech.gOS.user.en.region.Region();
					region.setId(new Long(rs.getLong("id")));
					region.setName(rs.getString("name"));
					region.setLevel(new Long(rs.getLong("levelid")));
					region.setDescription(rs.getString("description"));
					region.setCreatedate(rs.getDate("createdate"));
					region.setCreatorid(new Long(rs.getLong("creatorid")));
					region.setParentid(new Long(rs.getLong("parentid")));
					region.setNum(rs.getString("num"));
					region.setShortname(rs.getString("shortname"));
					region.setOrder(rs.getString("disporder"));
					regionList.add(region);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}

		return regionList;
	}

	/**
	 * 根据用户ID查询用户所在区域信息
	 * 
	 * @param level
	 *            区域级别
	 * @return List 区域信息
	 * @throws TSDBException
	 */
	public static List getRegionByLevel(Long level) throws TSDBException {

		// SQL语句
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" SELECT r FROM Region r WHERE r.levelid = " + level).append(" and r.useFlag = 1");

		// 执行查询
		return dao.queryList(sbHql.toString());
	}

	/**
	 * 根据用户ID取得用户的工作单位信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return AreaInfo
	 * @throws TSDBException
	 */
	// public static AreaInfo getOfficeInfoByUserId(Long userId) throws
	// TSDBException {
	//
	// AreaInfo area = new AreaInfo();
	//
	// try {
	// User user = UserDBUtility.getUserById(userId.longValue());
	// setOfficeInfo(area, user.getWorkdeptid());
	// long parentId = getParentOrgId(user.getWorkdeptid().longValue());
	// while (parentId > 0) {
	// setOfficeInfo(area, new Long(parentId));
	// parentId = getParentOrgId(parentId);
	// }
	// } catch (Throwable e) {
	// e.printStackTrace();
	// }
	//
	// return area;
	// }
	/**
	 * 设置机构信息
	 * 
	 * @param area
	 *            AreaInfo
	 * @param deptId
	 *            单位ID
	 * @throws SQLException
	 */
	public static void setOfficeInfo(AreaInfo area, Long deptId) throws SQLException {

		// 判断机构级别
		long role = judgeRoleById(deptId.longValue());
		// 社区
		if (role == Constants.DEPT_LEVEL.COMMUNITY) {
			area.setCommunityId(deptId);
		} else if (role == Constants.DEPT_LEVEL.STREET) {
			// 街道
			area.setStreetId(deptId);
		} else if (role == Constants.DEPT_LEVEL.COUNTRY) {
			// 区县
			area.setCountyId(deptId);
		} else if (role == Constants.DEPT_LEVEL.CITY) {
			// 城市
			area.setCityId(deptId);
		} else if (role == Constants.DEPT_LEVEL.PROVINCE) {
			// 省
			area.setProvinceId(deptId);
		}
	}

	/**
	 * 根据机构ID取得上级单位信息
	 * 
	 * @param deptId
	 *            机构ID
	 * @return AreaInfo
	 * @throws TSDBException
	 */
	public static AreaInfo getOfficeInfoByDeptId(Long deptId) throws TSDBException {

		AreaInfo area = new AreaInfo();

		try {
			setOfficeInfo(area, deptId);
			long parentId = getParentOrgId(deptId.longValue());
			while (parentId > 0) {
				setOfficeInfo(area, new Long(parentId));
				parentId = getParentOrgId(parentId);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return area;
	}

	/**
	 * 数据字典: 通过'区域ID'，获取'机构id'和'机构名称'
	 * 
	 * @param regionId
	 *            '区域ID'
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List getGosDeptList(long regionId) throws SQLException {
		ResultSet rs = null;
		List list = new ArrayList();
		String sSql = "";

		try {
			sSql = " SELECT d.id,d.name,d.parent_id,d.tree_node FROM gos_dept d WHERE d.use_flag =1 and d.regionId =" + regionId;
			sSql += " order by d.orderby_item asc";

			// System.out.println("\n ---sSql : " + sSql);

			rs = dao.executeQuery(sSql);
			if (rs != null) {
				while (rs.next()) {
					list.add(new ListBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getObject(4)));
				}
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}

	/**
	 * 数据字典: 通过'区域ID'和机构类型，获取'机构id'和'机构名称'
	 * 
	 * @param regionId
	 *            '区域ID'
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List getGosDeptList(long regionId, String deptType) throws SQLException {
		ResultSet rs = null;
		List list = new ArrayList();
		String sSql = "";

		try {
			sSql = " SELECT d.id,d.name FROM gos_dept d WHERE d.use_flag =1 and d.regionId =" + regionId;
			if (!Tools.isEmpty(deptType)) {
				sSql = sSql + " AND d.APPROVE_UNIT_CODE = '" + deptType + "'";
			}
			rs = dao.executeQuery(sSql);
			if (rs != null) {
				while (rs.next()) {
					list.add(new ListBean(rs.getInt(1), rs.getString(2)));
				}
			}
		} catch (SQLException sqle) {
			throw new SQLException(sqle.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}

	/**
	 * 取机构的“审批单元表示”的值
	 * 
	 * @param deptId
	 *            机构ID
	 * @return Long
	 * @throws SQLException
	 */
	public static String getDeptApproveUnitCode(Long deptId) throws Exception {

		ResultSet rs = null;
		String approveUnitCode = null;

		try {
			String selectSql = "SELECT APPROVE_UNIT_CODE FROM GOS_DEPT ";
			selectSql = selectSql + "WHERE USE_FLAG = 1 AND ID = " + deptId;
			rs = dao.executeQuery(selectSql);
			if (rs.next()) {
				approveUnitCode = rs.getString("APPROVE_UNIT_CODE");
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			if (rs != null)
				rs.close();
		}

		return approveUnitCode;
	}

	/**
	 * 根据区域ID和审批单元表示查询单位ID
	 * 
	 * @param regionId
	 *            区域ID
	 * @param jgmx
	 *            审批单元表示
	 * @return Long
	 * @throws SQLException
	 */
	public static Long getDeptIdByType(Long regionId, Long jgmx) throws Exception {

		ResultSet rs = null;
		Long deptId = null;

		try {
			String selectSql = "SELECT ID FROM GOS_DEPT ";
			selectSql = selectSql + "WHERE USE_FLAG = 1 AND REGIONID = " + regionId;
			if (!Tools.isEmptyId(jgmx)) {
				selectSql = selectSql + " AND JGMX = " + jgmx;
			}
			rs = dao.executeQuery(selectSql);
			if (rs.next()) {
				deptId = new Long(rs.getLong("ID"));
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			if (rs != null)
				rs.close();
		}

		return deptId;
	}

	/**
	 * 返回区域ID串
	 * 
	 * @param regionList
	 *            区域List
	 * @return
	 */
	public static String getRegionIdStr(List regionList) {
		String regionIdStr = "";

		for (int i = 0; i < regionList.size(); i++) {
			Region region = (Region) regionList.get(i);
			if (regionIdStr.trim().length() == 0) {
				regionIdStr = "," + region.getId() + ",";
			} else {
				regionIdStr = regionIdStr + region.getId() + ",";
			}
		}
		return regionIdStr;

	}

	/**
	 * 动态树：获取当前区域节点的下级区域节点
	 * 
	 * @param treeList
	 * @param regionId
	 *            区域ID
	 * @return
	 */
	public static List getRegionNodeForTree(List treeList, long regionId, long treeType, Long treeLev) {
		treeList = (treeList != null) ? treeList : new ArrayList();
		try {
			List list = getRegionByParentIdImp(new Long(regionId), treeLev);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Region region = (Region) list.get(i);
					String name = region.getName();

					String rootFlag = "Y";
					String chidlNodeValue = region.getId().toString() + "," + Constants.treeNodeType.REGION + "," + treeType;
					String image = rootFlag.equals("Y") ? Constants.treeAttribute.IMAGE : Constants.treeAttribute.IMAGE_CHILD;

					treeList.add(new treeBean(region.getId().longValue(), name, rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));
				}
			}
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		return treeList;
	}

	/**
	 * 根据机构ID，返回区域ID
	 * 
	 * @param deptId
	 * @return
	 */
	public static long getReginIdByDeptId(long deptId) {
		long reginId = -1;
		ResultSet rs = null;
		try {
			StringBuffer querySql = new StringBuffer();
			querySql.append("select * from gos_dept  t where t.id=").append(deptId);
			rs = dao.executeQuery(querySql.toString());
			while (rs.next()) {
				reginId = rs.getLong("regionid");
			}
		} catch (Exception e) {
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
		return reginId;
	}

	/**
	 * 获取机构表中，同一区域下的树节点值
	 * 
	 * @param regionId
	 *            区域ID
	 * 
	 * @param regionId
	 * @return
	 */
	public static long gettreeNodeByDeptTable(long regionId) {
		long reginId = -1;
		ResultSet rs = null;
		try {
			StringBuffer querySql = new StringBuffer();
			querySql.append("select * from gos_dept t where t.tree_node=-1 and t.regionid=").append(regionId);
			rs = dao.executeQuery(querySql.toString());
			while (rs.next()) {
				reginId = rs.getLong("id");
			}
		} catch (Exception e) {
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

		return reginId;
	}

	/**
	 * 根据区域ID判断区域级别
	 * 
	 * @param regionId
	 *            区域ID
	 * @return long
	 */
	// public static long judgeRegionLevel(Long regionId) {
	// long level = -1;
	// try {
	// Region region = getRegion(regionId);
	// level = region.getLevel().longValue();
	// } catch (Throwable e) {
	// e.printStackTrace();
	// }
	// return level;
	// }
	/**
	 * 获取seq
	 * 
	 * @param seqName
	 *            'seq'名称
	 * @return
	 */
	public static long getIdSeq(String seqName) {
		long id = -1;
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("select ").append(seqName).append(".Nextval from dual");
		ResultSet rs = null;
		try {
			rs = dao.executeQuery(queryHql.toString());
			try {
				if (rs != null && rs.next())
					id = rs.getLong(1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return id;
	}

	/**
	 * 获取机构ID串[审批标识不为null]
	 * 
	 * @param regionId
	 *            区域ID
	 * @return
	 */
	public static String getDeptIdStrByRegionId(long regionId) {
		StringBuffer deptStr = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;

		sql.append(" select t.id from gos_dept t ").append(" where t.use_flag=1 ").append(" and t.regionid=").append(regionId);

		try {
			rs = dao.executeQuery(sql.toString());
			while (rs.next()) {
				if (deptStr.toString().trim().length() == 0)
					deptStr.append(rs.getLong("id"));
				else
					deptStr.append(",").append(rs.getLong("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return deptStr.toString();

	}

	public static ListBean convertListBean(long flag, Object obj) {
		ListBean bean = null;
		if (flag == 1)
			bean = (ListBean) obj;
		else {
			OfficeVO office = (OfficeVO) obj;
			bean = new ListBean(Integer.parseInt(office.getId().toString()), office.getName(), office.getParentId().intValue(), Long.toString(office.getTreeNode()));

		}

		return bean;
	}

	public static Region getRegionById(Long id) throws TSDBException {
		return getRegion(id);
	}

	/**
	 * 数据字典：获取相应的'VALUE'
	 * 
	 * @param dictCode
	 *            'Id'
	 * @param typeName
	 *            '类型名称'
	 * @return
	 * @throws NumberFormatException
	 * @throws TSDBException
	 */
	public static String getDictionaryCode(String dictId, String typeName) throws TSDBException {

		if (dictId == null || dictId.trim().length() == 0) {
			return "";
		}

		Dictionary dict = getDictionary(new Long(dictId));
		if (dict != null)
			return dict.getName();
		else
			return null;
	}

	public static Dictionary getDictionary(Long dictId) {
		if (dictId != null && dictId.longValue() > 0) {
			return (Dictionary) dao.get(Dictionary.class, dictId.longValue());
		}
		return null;
	}

	/**
	 * 根据typeName查询字典表
	 * 
	 * @param typeName
	 * @return
	 * @throws TSDBException
	 */
	public static List getDictListByTypeName(String typeName) throws TSDBException {
		if (typeName == null || "".equals(typeName.trim()))
			return null;
		DetachedCriteria subCriteria = DetachedCriteria.forClass(Dictionary.class);
		subCriteria.add(Restrictions.eq("typename", typeName));
		subCriteria.add(Restrictions.eq("useFlag", new Long(Constants.USE_FLAG.USE_FLAG_ON)));
		List<Dictionary> parentDictList = (List<Dictionary>) dao.query(subCriteria);
		if (parentDictList != null && !parentDictList.isEmpty()) {
			List<Long> parentIdList = new ArrayList<Long>();
			for (Dictionary dictionary : parentDictList) {
				parentIdList.add(dictionary.getId());
			}
			DetachedCriteria criteria = DetachedCriteria.forClass(Dictionary.class);
			criteria.add(Restrictions.eq("useFlag", new Long(Constants.USE_FLAG.USE_FLAG_ON)));
			criteria.add(Restrictions.in("parentid", parentIdList));
			criteria.addOrder(Order.asc("ind"));
			return dao.query(criteria);
		}
		return null;
	}

	/**
	 * 获取已选中的选项
	 * 
	 * @param chooseList
	 * @return
	 * @throws TSDBException
	 */
	public static List queryChooseDictListForMultipleChoise(List<Long> chooseList) throws TSDBException {
		if (chooseList == null || chooseList.isEmpty())
			return null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Dictionary.class);
		criteria.add(Restrictions.in("id", chooseList));
		return dao.query(criteria);
	}

	/**
	 * 获取已选中的自建表
	 * 
	 * @param customId
	 * @param chooseList
	 * @return
	 * @throws TSDBException
	 */
	public static List<Map<String, Object>> queryChooseCustomMultipleChoiseList(Object customId, List<Long> chooseList) throws TSDBException {
		if (customId == null || "".equals(customId.toString().trim()))
			return null;
		Dictionary dictionary = getDictionary(new Long(customId.toString()));
		if (dictionary == null)
			return null;
		if (chooseList == null || chooseList.isEmpty())
			return null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(dictionary.getName());
		sql.append(" where use_flag = 1");
		StringBuffer buf = new StringBuffer();
		for (Long id : chooseList) {
			buf.append(id).append(",");
		}
		sql.append(" and id in(").append(buf.substring(0, buf.length() - 1)).append(")");
		sql.append(" order by id asc");
		ResultSet rs = null;
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		try {
			rs = dao.executeQuery(sql.toString());
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", rs.getObject("id"));
				map.put("standardContent", rs.getString("STANDARD_CONTENT"));
				resultList.add(map);
			}
			return resultList;
		} catch (Exception e) {
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
	 * 查询自建表
	 * 
	 * @param customId
	 * @return
	 * @throws TSDBException
	 */
	public static List<Map<String, Object>> queryCustomMultipleChoiseList(Object customId) throws TSDBException {
		if (customId == null || "".equals(customId.toString().trim()))
			return null;
		Dictionary dictionary = getDictionary(new Long(customId.toString()));
		if (dictionary == null)
			return null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(dictionary.getName());
		sql.append(" where use_flag = 1");
		sql.append(" order by id asc");
		ResultSet rs = null;
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		try {
			rs = dao.executeQuery(sql.toString());
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", rs.getObject("id"));
				map.put("standardContent", rs.getString("STANDARD_CONTENT"));
				resultList.add(map);
			}
			return resultList;
		} catch (Exception e) {
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
	 * 查询已选中的列表
	 * 
	 * @param mainTableId
	 * @return
	 * @throws TSDBException
	 */
	public static List queryApMultipickContentListByMainTableId(Object mainTableId, String partitionFlag) throws TSDBException {
		if (mainTableId == null || "".equals(mainTableId.toString().trim()))
			return null;
		DetachedCriteria criteria = DetachedCriteria.forClass(ApMultipickContent.class);
		criteria.add(Restrictions.eq("mainTableId", new Long(mainTableId.toString())));
		criteria.add(Restrictions.eq("useFlag", new Long(Constants.USE_FLAG.USE_FLAG_ON)));
		criteria.add(Restrictions.eq("partitionFlag", partitionFlag));
		return dao.query(criteria);
	}

	/**
	 * 根据ID取得机构
	 * 
	 * @param deptId
	 * @return Dept
	 * @throws TSDBException
	 */
	public static Dept getDeptById(Long deptId) throws TSDBException {
		return (Dept) dao.get(Dept.class, deptId);
	}

	/**
	 * 根据区域ID判断区域级别
	 * 
	 * @param regionId
	 *            区域ID
	 * @return long
	 */
	public static long judgeRegionLevel(Long regionId) {
		long level = -1;
		try {
			Region region = getRegion(regionId);
			level = region.getLevelid().longValue();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return level;
	}

	// 20120331 add
	/**
	 * 组织机构：获取当前节点下的所有子节点[不递归] 区县层次：具有审批标识 街道层次：具有审批标识 社区层次：所有社区
	 * 
	 * @param deptId
	 * @param flag
	 *            : 0 过滤>审批标识；1，不过滤；
	 * @return
	 */
	public static List getOrgChildList(long deptId, long flag) {
		ResultSet rs = null;
		List list = new ArrayList();
		long reginId = getReginIdByDeptId(deptId);
		if (reginId > 0) {
			long lev = judgeRegionLevel(new Long(reginId));
			try {
				StringBuffer querySql = new StringBuffer();
				querySql.append("select * from gos_dept dt where dt.regionid in (");
				querySql.append(" select t.id from gos_region t where t.use_flag=1 and  t.parentid=").append(reginId);
				querySql.append(") and dt.use_flag=1");
				// 区县
				if (flag == 0 && lev == Constants.AREA_LEVEL.COUNTRY) {
					querySql.append(" and dt.approve_unit_code is not null");
				}

				querySql.append(" order by dt.disporder asc ");

				rs = dao.executeQuery(querySql.toString());
				while (rs.next()) {
					OfficeVO office = new OfficeVO();
					office.setName(rs.getString("name"));
					office.setId(new Long(rs.getLong("id")));
					office.setRegionid(rs.getLong("regionid"));
					office.setLevelid(rs.getLong("levelid"));
					office.setParentId(new Long(rs.getLong("parent_id")));
					office.setTreeNode(rs.getLong("tree_node"));

					list.add(office);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		}
		return list;
	}

	public static AreaInfo getAreaInfoByUserId(Long userId) throws TSDBException {
		User user = getUserInfo(userId.longValue());
		if (user != null) {
			return getAreaInfoByDeptId(new Long(user.getDeptid()));
		}
		return null;
	}

	public static AreaInfo getAreaInfoByDeptId(Long deptId) throws TSDBException {
		String hql = "select r from Dept d,Region r where d.regionid = r.id and d.id=" + deptId;
		List list = dao.queryList(hql);
		if (list != null && !list.isEmpty()) {
			AreaInfo info = new AreaInfo();
			Region region = (Region) list.get(0);
			// added by pengzuocong 2012-10-26
			// 特殊区划是否已经处理
			boolean dealedSpecial = false;
			while (region.getLevelid().intValue() >= Constants.AREA_LEVEL.CITY) {
				switch (region.getLevelid().intValue()) {
				case (int) Constants.AREA_LEVEL.CITY:// 市
					info.setCityId(region.getId());
					break;
				case (int) Constants.AREA_LEVEL.COUNTRY:// 区
					// added by pengzuocong 2012-10-26
					if (!dealedSpecial) {
						// 特殊情况处理
						GosRegionConvert gosRegionConvert = getGosRegionConvertByRegionId(region.getId());
						if (gosRegionConvert == null)
							info.setCountyId(region.getId());
						else {
							// 判断是否已经处理了特殊区划，处理完后将处理标识设置为是，下一次则不处理
							info.setCountyId(region.getId());
							dealedSpecial = true;
						}
					}
					break;
				case (int) Constants.AREA_LEVEL.STREET:// 街
					info.setStreetId(region.getId());
					break;
				}
				region = getRegionById(region.getParentid());
				if (region == null) {
					break;
				}

			}
			return info;
		}
		return null;
	}

	/**
	 * 数据字典: 通过节点'ID'，获取'下一级子节点'
	 * 
	 * @param code
	 *            '字典编码'
	 * @param SysFlag
	 *            '系统标识':救助生活救助>默认、农村五保>lcwb;、市本级>sbj、社会救助>bjsj;
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List getDictsListByCodeToSystemFlag(String typeName, String SysFlag, String spiltStr) throws SQLException {
		RowSet rs = null;
		List list = new ArrayList();
		StringBuffer sSql = new StringBuffer();

		try {
			sSql.append(" SELECT d.id,d.name,d.corresponding_id FROM jz_dictionary d ").append(" WHERE d.use_flag =1 and d.parentid IN (").append(" SELECT dt.id FROM jz_dictionary dt WHERE dt.typename='").append(typeName).append("' ) ");
			if (spiltStr != null && spiltStr.trim().length() > 0)
				sSql.append(" and d.id not in (").append(spiltStr).append(")");
			if (SysFlag == null || SysFlag.trim().length() == 0) {
				sSql.append(" and d.is_show =1 ");
			} else if (SysFlag != null && SysFlag.trim().length() > 0) {
				if ("tjdbSend".equals(SysFlag.trim())) {
					sSql.append(" and d.is_tjdb =1 ");
				}
			}
			sSql.append(" order by d.ind asc ");

			// System.out.println("\n ---- sSql : " + sSql.toString());

			rs = dao.executeQuery(sSql.toString());
			if (rs != null) {
				while (rs.next()) {
					list.add(new DictBean(rs.getString(1), rs.getString(2), new Long(rs.getLong(3))));
				}
			}
		} catch (SQLException e) {
			Logger.error("load dict error", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 根据用户ID查询用户所在区域信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return Region 区域信息
	 * @throws TSDBException
	 */
	public static Dept getDeptByUserId(Long userId) throws TSDBException {

		// SQL语句
		StringBuffer sbHql = new StringBuffer();
		sbHql.append(" SELECT d FROM User u, Dept d ");
		sbHql.append(" WHERE u.deptid = d.id  ");
		sbHql.append(" AND u.id= " + userId);

		// 执行查询
		List list = dao.queryList(sbHql.toString());

		// 如果有数据，则返回第一条
		if (!Tools.isEmpty(list))
			return (Dept) list.get(0);
		return null;
	}

	/**
	 * 分页查询
	 * 
	 * @param criteria
	 * @param projection
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public static List query(DetachedCriteria criteria, Projection projection, Page page) throws TSDBException {
		return dao.query(criteria, projection, page);
	}

	/**
	 * 分页查询 (hql)
	 * 
	 * @param queryHql
	 * @param countHql
	 * @param page
	 * @return
	 * @throws TSDBException
	 */
	public static List query(String queryHql, String countHql, Page page) throws TSDBException {
		return dao.query(queryHql, countHql, page);
	}

	/**
	 * 根据id获取实体对象
	 * 
	 * @param entiryClass
	 * @param id
	 * @return
	 * @throws TSDBException
	 */
	public static Object get(Class entityClass, Serializable id) throws TSDBException {
		return dao.get(entityClass, id);
	}

	/**
	 * 原声sql分页查询，用于导出excel
	 * 
	 * @param page
	 * @param querySql
	 * @param countSql
	 * @return
	 * @throws TSDBException
	 */
	public static List getPageResult(Page page, String querySql, String countSql) throws TSDBException {
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			rs = dao.getPageResult(page, querySql, countSql);
			while (rs.next()) {
				int len = rs.getMetaData().getColumnCount() - 1;
				Object[] o = new Object[len];
				for (int i = 0; i < len; i++) {
					o[i] = rs.getObject(i + 2);
				}
				list.add(o);
			}
			return list;
		} catch (Exception e) {
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
	 * 查询区划转换信息
	 * 
	 * @param regionId
	 * @return
	 * @throws TSDBException
	 */
	private static GosRegionConvert getGosRegionConvertByRegionId(Long regionId) throws TSDBException {
		DetachedCriteria criteria = DetachedCriteria.forClass(GosRegionConvert.class, "t");
		if (regionId != null)
			criteria.add(Restrictions.eq("t.regionId", regionId));
		criteria.add(Restrictions.eq("t.useFlag", new Long(Constants.USE_FLAG.USE_FLAG_ON)));
		criteria.add(Restrictions.eq("t.ruleId", Constants.regionConvert.BINHAI));
		List list = dao.findByCriteria(criteria);
		if (list == null || list.isEmpty())
			return null;
		return (GosRegionConvert) list.get(0);
	}

	/**
	 * 查询需要转换区划的下级信息
	 * 
	 * @param parentId
	 * @param concat
	 * @return
	 * @throws TSDBException
	 */
	public static String getSpecialAreasByParentId(Long parentId, boolean concat) throws TSDBException {
		if (parentId == null)
			return null;
		DetachedCriteria criteria = DetachedCriteria.forClass(GosRegionConvert.class, "t");
		if (parentId != null)
			criteria.add(Restrictions.eq("t.parentId", parentId));
		criteria.add(Restrictions.eq("t.useFlag", new Long(Constants.USE_FLAG.USE_FLAG_ON)));
		criteria.add(Restrictions.eq("t.ruleId", Constants.regionConvert.BINHAI));
		List list = dao.findByCriteria(criteria);
		if (list == null || list.isEmpty())
			return null;
		String areas = "";
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			GosRegionConvert gosRegionConvert = (GosRegionConvert) iter.next();
			areas += gosRegionConvert.getRegionId() + ",";
		}
		if (areas.endsWith(","))
			areas = areas.substring(0, areas.length() - 1);
		if (concat)
			areas = parentId + "," + areas;
		return areas;
	}

	/**
	 * 查询需要转换区划的下级信息(list)
	 * 
	 * @param parentId
	 * @param concat
	 * @return
	 * @throws TSDBException
	 */
	public static List getSpecialAreaListByParentId(Long parentId, boolean concat) throws TSDBException {
		if (parentId == null)
			return null;
		DetachedCriteria criteria = DetachedCriteria.forClass(GosRegionConvert.class, "t");
		if (parentId != null)
			criteria.add(Restrictions.eq("t.parentId", parentId));
		criteria.add(Restrictions.eq("t.useFlag", new Long(Constants.USE_FLAG.USE_FLAG_ON)));
		criteria.add(Restrictions.eq("t.ruleId", Constants.regionConvert.BINHAI));
		List list = dao.findByCriteria(criteria);
		if (list == null || list.isEmpty())
			return null;
		List areaList = new ArrayList();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			GosRegionConvert gosRegionConvert = (GosRegionConvert) iter.next();
			areaList.add(gosRegionConvert.getRegionId());
		}
		if (concat)
			areaList.add(parentId);
		return areaList;
	}
}
