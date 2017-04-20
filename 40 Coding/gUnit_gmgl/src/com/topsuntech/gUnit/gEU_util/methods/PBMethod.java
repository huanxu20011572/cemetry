/*
 * Created on 2006-1-11
 *	@author lixirong
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.methods;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.RowSet;

import net.sf.hibernate.HibernateException;
import sun.jdbc.rowset.CachedRowSet;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gUnit.common.util.DateUtils;
import com.topsuntech.gUnit.common.util.ListSorter;
import com.topsuntech.gUnit.gEU_util.forms.DictBean;
import com.topsuntech.gUnit.gEU_util.forms.ListObject;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class PBMethod {

	/**
	 * ��ʽ���ַ�λ����������ǰ��0
	 * 
	 * @param ctValue
	 *            'ֵ'
	 * @param formatNume
	 *            'λ��'
	 * @return
	 */
	public static String formatValue(String ctValue, long formatNume) {
		String strValue = "";

		for (int i = ctValue.length(); i < formatNume; i++) {
			ctValue = "0" + ctValue;
		}

		return ctValue;

	}

	public static String levelSourceCode(String sourceId, String typeName) throws SQLException {
		String levelStr = "";

		List list = Dicts.getDictsListByCode(typeName);
		if (list != null) {
			String[] strs = getDictsStr(list, 0);

			if (strs != null) {
				String[] lev = new String[strs.length];
				String[] s = sourceId.split(",");

				for (int i = 0; i < s.length; i++) {
					if (s[i] == null || s[i].trim().length() == 0)
						continue;

					int ctIndex = getCurrentIndex(strs, s[i]);
					int flag = -1;
					if (ctIndex != -1)
						lev[ctIndex] = "1";
				}

				for (int i = 0; i < lev.length; i++) {
					if (lev[i] == null)
						lev[i] = "0";

					if (levelStr.trim().length() == 0)
						levelStr = lev[i];
					else
						levelStr += "" + lev[i];

				}

			}
		}

		return levelStr;
	}

	public static String[] getDictsStr(List dictList, long flag) {
		String[] strs = null;

		if (dictList != null) {
			strs = new String[dictList.size() + 1];
			for (int i = 0; i < dictList.size(); i++) {
				DictBean bean = (DictBean) dictList.get(i);
				if (flag == 0) {
					strs[i] = bean.getKey();
				} else {
					strs[i] = bean.getValue();
				}
			}
		}

		return strs;
	}

	/**
	 * ��ȡ'��ǰֵ'����'��ǰ���鼯��'�е��±�
	 * 
	 * @param strs
	 *            '��ǰ���鼯��'
	 * @param ctValue
	 *            '��ǰֵ'
	 * @return
	 */
	public static int getCurrentIndex(String[] strs, String ctValue) {
		int ctIndex = -1;

		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == null && strs[i].trim().length() == 0)
				continue;

			if (strs[i].trim().equals(ctValue.trim())) {
				ctIndex = i;
				break;
			}
		}
		return ctIndex;
	}

	/**
	 * ��ʽ������λ��
	 * 
	 * @param strValue
	 *            ��ֵ
	 * @param formatNum
	 *            С��λ��
	 * @return
	 */
	public static double formatNumber(double ctValue, int formatNum) {
		String str = formatNumberStr(ctValue, formatNum);
		return Double.parseDouble(str);
	}

	/**
	 * ��ʽ������λ��
	 * 
	 * @param strValue
	 *            ��ֵ
	 * @param formatNum
	 *            С��λ��
	 * @return String
	 */
	public static String formatNumberStr(double ctValue, int formatNum) {
		String value = Double.toString(ctValue);
		String[] s = stringToKenizer(value.trim(), ".");
		String sv = "";

		if (s.length > 0) {
			if (formatNum > 0)
				sv = s[0] + ".";
			else
				sv = s[0];

			if (s[1].length() >= formatNum)
				sv += s[1].substring(0, formatNum);
			else {
				sv += s[1].substring(0, s[1].length());
				for (int i = s[1].length(); i < formatNum; i++) {
					sv += "0";
				}
			}
		} else {
			if (formatNum > 0)
				sv = value + ".";
			else
				sv = value;

			for (int i = 1; i < formatNum; i++) {
				sv += "0";
			}
		}
		return sv;
	}

	/**
	 * �ϲ������ַ���
	 * 
	 * @param str1
	 *            ',aa,bb,cc,'
	 * @param f1
	 *            ','
	 * @param str2
	 *            ',ff,gg,'
	 * @param f2
	 *            ','
	 * @return ',aa,bb,cc,ff,gg,'
	 */
	public static String mergerStr(String str1, String f1, String str2, String f2) {
		String v = str1;

		StringTokenizer st = new StringTokenizer(str2, f2);

		int len = st.countTokens();
		for (int k = 0; k < len; k++) {
			String s = st.nextToken();
			if (s != null && s.trim().length() > 0) {
				boolean b = judgeExistArray(str1, s);
				if (b == false) {
					String end = str1.substring(str1.length() - 1, str1.length());
					if (end.equals(",")) {
						str1 += s + ",";
					} else {
						str1 += "," + s + ",";
					}
				}
			}
		}

		return str1;
	}

	/**
	 * �жϵ�ǰ�ַ������Ƿ����'value'
	 * 
	 * @param strVals
	 * @param value
	 * @return
	 */
	public static boolean judgeExistArray(String strVals, String value) {
		boolean be = false;

		StringTokenizer st = new StringTokenizer(strVals, ",");
		int len = st.countTokens();
		for (int k = 0; k < len; k++) {
			String s = st.nextToken();
			if (s != null && s.trim().length() > 0) {
				if (s.equals(value)) {
					be = true;
					break;
				}
			}

		}

		return be;
	}

	/**
	 * ȡ�÷ָ���ֵ
	 * 
	 * @param strVaue
	 *            ֵ
	 * @param flag
	 *            ���
	 * @return ֵ����
	 */
	public static String[] stringToKenizer(String strVaue, String flag) {
		StringTokenizer st = new StringTokenizer(strVaue, flag);

		int len = st.countTokens();
		String[] strs = new String[len];

		for (int k = 0; k < len; k++) {
			strs[k] = st.nextToken();
		}

		return strs;
	}

	/**
	 * ȡ�÷ָ�����������ֵ
	 * 
	 * @param strVaue
	 *            ֵ
	 * @param flag
	 *            ���
	 * @return ֵ����
	 */
	public static long[] getArrayId(String strVaue, String flag) {
		StringTokenizer st = new StringTokenizer(strVaue, flag);

		int len = st.countTokens();
		long[] ids = new long[len];

		for (int k = 0; k < len; k++) {
			ids[k] = Long.parseLong(st.nextToken());
		}

		return ids;
	}

	/**
	 * �жϵ�ǰ�����У��Ƿ����ĳ����ֵ
	 * 
	 * @param strs
	 *            ����
	 * @param ctValue
	 *            ����ֵ
	 * @return
	 */
	public static boolean judgeIsExist(String[] strs, String ctValue) {
		boolean bExist = false;

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].trim().length() == 0)
				continue;

			if (strs[i].trim().equals(ctValue.trim())) {
				bExist = true;
				break;
			}
		}

		return bExist;
	}

	/**
	 * ͨ��'���֤����'����ȡ'��������'
	 * 
	 * @param statusCardsNumber
	 * @return
	 */
	public static Date createBirthday(String statusCardsNumber) {
		Date d = null;
		try {
			StringBuffer strDate = new StringBuffer(statusCardsNumber.substring(6, 10));
			strDate.append("-");
			strDate.append(statusCardsNumber.substring(10, 12));
			strDate.append("-");
			strDate.append(statusCardsNumber.substring(12, 14));

			d = DateUtils.parseDate(strDate.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	/**
	 * ͨ��'���֤����'����ȡ'����'
	 * 
	 * @param statusCardsNumber
	 * @return
	 */
	public static long createAge(String statusCardsNumber) {
		long age = 0;

		try {
			if (statusCardsNumber != null) {
				String birth = statusCardsNumber.substring(6, 14);
				String ctDate = DateUtils.formatDate(new Date());

				age = Long.parseLong(ctDate.substring(0, 4)) - Long.parseLong(birth.substring(0, 4));

				String b1 = birth.substring(4, 6);
				String b2 = birth.substring(6, 8);
				String b = b1 + "-" + b2;

				long i = ctDate.indexOf("-");
				String c = ctDate.substring(5, ctDate.length());

				if (c.compareToIgnoreCase(b) < 0)
					age--;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			Logger.debug("\n age is error formate !");
		}

		return age;
	}

	/**
	 * ��ȡ��ǰ��ѯ�Ľ����
	 * 
	 * @param page
	 * @param db
	 * @param countSql
	 * @param sSql
	 * @return
	 * @throws HibernateException
	 */
	public static List getPageList(Page page, DBWrapper db, String sSql, String countSql) throws HibernateException {

		int count = 0;
		count = db.count(countSql);
		page.setTotalCount(count);

		if (count == 0)
			return new ArrayList();

		int pageSize = page.getPageSize();
		int pageNumber = page.getCurrentPage();
		if (page.getPageCount() <= page.getCurrentPage()) {
			pageNumber = page.getPageCount();
		}

		List ptList = null;
		try {

			ptList = db.query(sSql, pageSize, pageNumber - 1);
			if (ptList.size() == 0)
				ptList = null;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ptList;

	}

	/**
	 * ORACLE���ݿ��£�֧�ַ�ҳ�Ĳ�ѯ
	 * 
	 * @param strSql
	 *            ��ѯSQL
	 * @param page
	 *            ��ҳ����
	 * @param db
	 *            DBWrapper
	 * @return RowSet
	 * @throws SQLException
	 */
	public static RowSet queryForOracle(String strSql, Page page, DBWrapper db) throws SQLException {

		RowSet rs = null;
		CachedRowSet cachedrowset = null;

		try {
			// ��ѯ��¼����
			StringBuffer cntSql = new StringBuffer();
			cntSql.append(" SELECT COUNT(*) CNT FROM (").append(strSql).append(") temp ");
			rs = db.executeQuery(cntSql.toString());
			if (rs.next()) {
				page.setTotalCount(rs.getInt("CNT"));
				rs.close();
			}

			// ���㵱ҳ��ʼ������¼λ��
			int end = page.getCurrentPage() * page.getPageSize();
			int begin = end - page.getPageSize();

			// ��ѯ��¼��
			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" SELECT tt.* FROM ( ");
			sbSql.append(" SELECT ROWNUM AS ORDERID, t.* FROM ( ");
			sbSql.append(strSql).append(" ) t ) tt ");
			sbSql.append(" WHERE tt.ORDERID > ").append(begin);
			sbSql.append(" AND tt.ORDERID <= ").append(end);

			// ���ü�¼���Ŀ�ʼ����λ�ã��õ���¼
			rs = db.executeQuery(sbSql.toString());
			cachedrowset = new CachedRowSet();
			cachedrowset.populate(rs);

		} catch (SQLException e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
		}

		return cachedrowset;
	}

	/**
	 * �Ѽ�¼��ת��Map���б�
	 * 
	 * @param rs
	 *            RowSet
	 * @return List
	 * @throws SQLException
	 */
	public static List rs2MapList(RowSet rs) throws SQLException {

		// ȡ��¼�������ֶ������б�
		List columns = new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			columns.add(rsmd.getColumnName(i));
		}

		// �Ѽ�¼����Map���б�
		List result = new ArrayList();
		while (rs.next()) {
			Map map = new HashMap();
			for (int i = 0; i < columns.size(); i++) {
				String name = columns.get(i).toString().toUpperCase();
				map.put(name, rs.getObject(name));
			}
			result.add(map);
		}

		return result;
	}

	/**
	 * �Ѽ�¼��ת��Map���б�,���رռ�¼��
	 * 
	 * @param rs
	 *            RowSet
	 * @return List
	 * @throws SQLException
	 */
	public static List rs2MapListAndClose(RowSet rs) throws SQLException {
		List result = rs2MapList(rs);
		if (rs != null)
			rs.close();
		return result;
	}

	/**
	 * ��ȡ��ǰ 'sql'�ķ�ҳ�����
	 * 
	 * @param page
	 * @param db
	 * @param sSql
	 * @param countSql
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	public static ResultSet getPageResult(Page page, DBWrapper db, String sSql, String countSql) throws HibernateException, SQLException {

		ResultSet rs = null;
		int count = 0;

		try {
			rs = db.executeQuery(countSql);
			if (rs != null) {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			count = 0;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException sqle) {
				;
			}

		}

		page.setTotalCount(count);

		CachedRowSet cachedrowset = null;
		ResultSet rs1 = null;

		try {
			// int pageSize = page.getPageSize();
			// int pageNumber = page.getCurrentPage();
			// if (page.getPageCount() <= page.getCurrentPage()) {
			// pageNumber = page.getPageCount();
			// }

			int end = page.getCurrentPage() * page.getPageSize();
			int start = end - page.getPageSize();

			// String sql ="select * from (" +sSql + " ) tt where rownum<="
			// +end;

			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" SELECT tt.* FROM ( ");
			sbSql.append(" SELECT ROWNUM AS ORDERID, t.* FROM ( ");
			sbSql.append(sSql).append(" ) t ) tt ");
			sbSql.append(" WHERE tt.ORDERID > ").append(start);
			sbSql.append(" AND tt.ORDERID <= ").append(end);

			rs1 = db.executeQuery(sbSql.toString());
			//	        
			// if(start >0)
			// rs1.absolute(start);
			//	        
			cachedrowset = new CachedRowSet();
			cachedrowset.populate(rs1);

		} catch (Exception e) {
			cachedrowset = null;
		} finally {
			if (rs1 != null)
				rs1.close();
		}

		return cachedrowset;
	}

	public static long getCurrentValue(Long[] ids, long ctId) {
		long id = 0;

		for (int i = 0; i < ids.length; i++) {
			if (ids[i].longValue() > 0 && ids[i].longValue() >= ctId) {
				id = ids[i].longValue();
				break;
			}
		}

		return id;
	}

	/**
	 * 
	 * @param request
	 * @param strObjectName
	 * @param obj
	 * @param deptId
	 */
	public static void buildContextSalvageTotal(HttpServletRequest request, String strObjectName, Object obj) {
		// HttpSession sn = request.getSession();
		// Set st=new HashSet();
		//	    
		// long role = Dicts.judgeRoleById(deptId);
		// request.setAttribute("role", Long.toString(role));
		// String[] totalsInfo = new String[2];
		//		
		// if(role ==2){
		// Object[] ob = null;
		// try {
		// ob = ProjectReportService.getProjectStatisticsInfo(deptId, null, 0);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// totalsInfo = (String[]) ob[1];
		// totalsInfo[0] = totalsInfo[1];
		// totalsInfo[1] = totalsInfo[2];
		//			
		// }else{
		// Object[] obTotal = null;
		// try {
		// obTotal = ReportService.getCommnuityStatisticalList(deptId);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		//            
		// List view2 = (List) obTotal[0];
		// totalsInfo = (String[]) obTotal[1];
		//				    
		// }
		//		
		// st.add(new
		// ListBean(Integer.parseInt(Long.toString(deptId)),totalsInfo[0].toString()));
		// sn.setAttribute("salvageTotalInfo", st);

	}

	/**
	 * ͨ����������ȡ��һ��'session'
	 * 
	 * @param strObjectName
	 * @return
	 * @throws SQLException
	 * @throws SQLException
	 */
	// public static Object getContextObject(HttpServletRequest request,String
	// strObjectName ,long deptId) throws SQLException {
	// // HttpSession sn = request.getSession();
	// // return sn.getAttribute(strObjectName);
	//	    
	// long role = Dicts.judgeRoleById(deptId);
	// request.setAttribute("role", Long.toString(role));
	// if(role ==2){
	// Object[] ob = null;
	// try {
	// ob = ProjectReportService.getProjectStatisticsInfo(deptId, null, 0);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// String[] totalsInfo = (String[]) ob[1];
	// totalsInfo[0] = totalsInfo[1];
	// totalsInfo[1] = totalsInfo[2];
	//			
	// return totalsInfo[0];
	//			
	//			
	// }else{
	// Object[] obTotal = null;
	// try {
	// obTotal = ReportService.getCommnuityStatisticalList(deptId);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//            
	// List view2 = (List) obTotal[0];
	// String[] totalsInfo = (String[]) obTotal[1];
	//				    
	// return totalsInfo[0];
	// }
	// }
	/**
	 * ͨ�����������Ƴ�һ��'session'
	 * 
	 * @param strObjectName
	 */
	public static void deleteContextObject(HttpServletRequest request, String strObjectName) {
		HttpSession sn = request.getSession();
		sn.removeAttribute(strObjectName);
	}

	/**
	 * ����
	 * 
	 * @param list
	 *            '����'
	 * @param sortElement
	 *            'Ԫ������'
	 * @param sort
	 *            '����ֵ:true/false'
	 * @return
	 */
	public static List sort(List list, String sortElement, boolean sort) {
		List sortList = null;

		ListSorter.sort(list, ListObject.class, sortElement, sort);
		sortList = new ArrayList(list);

		return sortList;
	}

	/**
	 * ��ȡ�����ַ���
	 * 
	 * @param objs
	 * @return
	 */
	public static String getArrayStr(Object[] objs) {
		String str = "";

		for (int i = 0; i < objs.length; i++) {
			if (str.trim().length() == 0)
				str = objs[i].toString();
			else
				str += "," + objs[i].toString();
		}

		return str;
	}

}
