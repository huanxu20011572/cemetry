package com.topsuntech.gUnit.gEU_system.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.type.Type;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.identity.user.dao.UserDao;
import com.topsuntech.gOS.identity.util.StringUtils;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gOS.user.actions.AESUtil;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit.gEU_system.service.vo.UserQueryBean;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit.gEU_util.entity.AjUser;
import com.topsuntech.gUnit.gEU_util.entity.SjRegion;

public class UserService {
	private static DBWrapper dao = DBRegistry.getDefaultDBWrapper();

	private static UserService instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}

		return instance;
	}

	/**
	 * �����û�������
	 * 
	 * @param id
	 * @param password
	 */
	public static User updateUserInfo(long id, String loginId, String password) {
		try {
			User userInfo = (User) dao.load(User.class, id);
			if (userInfo != null) {
				if (loginId != null && !"".equals(loginId))
					userInfo.setLoginid(loginId);
				if (password != null && !"".equals(password))
					userInfo.setPassword(password);
				dao.update(userInfo);
			}
			return userInfo;
		} catch (TSDBException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean checkLoginIdExsit(String loginId)
			throws TSDBException {
		List l = dao.query("FROM AjUser t where t.loginid = ?",
				new Object[] { loginId }, new Type[] { Hibernate.STRING });
		if (l != null && !l.isEmpty()) {
			return l.size() == 0;
		}
		return false;
	}

	/**
	 *�����û�CANUMBER��ѯ�û�
	 *
	 *
	 */
	 public static User getUserByCanumber(String number){
		 List<User> list=null;
		 User user=null;
		 StringBuffer hsql = new StringBuffer();
		 if(number!=null&&!"".equals(number.trim())){
			 hsql.append(" FROM AjUser u where u.canumber ='"+number+"'");
		 }
		 if(hsql.length()>0){
			 try {
					list = dao.query(hsql.toString());
				} catch (TSDBException e) {
					e.printStackTrace();
				}
				if(list!=null&&list.size()>0){
					user=list.get(0);
				}
		 }
		 
		 return user;
	 }
	
	/**
	 * �û�������ѯ��ѯ�б�
	 * 
	 * @param bean
	 * @return
	 */
	public static List getUserList(UserQueryBean bean) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM AjUser t WHERE 1=1 ");
		if (bean.getLoginId() != null && bean.getLoginId().trim().length() > 0)
			hsql.append(" AND t.loginid like'%").append(bean.getLoginId())
					.append("%'");
		if (bean.getName() != null && bean.getName().trim().length() > 0)
			hsql.append(" AND t.name like '%").append(bean.getName()).append(
					"%'");
		if (bean.getDeptId() != null && bean.getDeptId().longValue() > 0)
			hsql.append(" AND t.deptid =").append(bean.getDeptId());
		if (bean.getWorkDeptId() != null
				&& bean.getWorkDeptId().longValue() > 0)
			hsql.append(" AND t.workdeptid =").append(bean.getWorkDeptId());
		if (bean.getDeleteReason() != null
				&& bean.getDeleteReason().trim().length() > 0)
			hsql.append(" AND t.deletereason ss='").append(
					bean.getDeleteReason()).append("'");
		else
			hsql.append(" AND t.deletereason is null ");

		hsql.append(" ORDER BY t.deptid asc  ");

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	/**
	 * ����loginid ��ѯ���ݿ����Ƿ����
	 * 
	 * @param logid
	 * @return
	 */
	public static boolean checkUserLogid(String logid) {
		List list = null;
		StringBuffer hsql = new StringBuffer();
		hsql.append(" FROM AjUser t WHERE t.deleted=0 ");
		if (logid != null && !logid.equals(""))
			hsql.append(" AND t.loginid ='").append(logid).append("'");
		try {
			list = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		if (list != null && list.size() >= 1) {// ������� ��ô�ܾ�
			return false;
		}
		return true;
	}

	public static User getUserById(Long id) throws TSDBException {
		return (User) dao.load(User.class, id.longValue());
	}

	public static AjUser getAjUserById(Long id) throws TSDBException {
		return (AjUser) dao.load(AjUser.class, id.longValue());
	}

	/**
	 * �û�������ȡ�û��ġ�ϵͳ��ɫ����Ϣ
	 * 
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public static List getUserSystemRole(Long userId) {
		List list = new ArrayList();
		String sysRoleStr = "";
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u.system_role FROM gos_user u ").append(
				" WHERE u.id=").append(userId);

		try {
			rs = dao.executeQuery(sql.toString());
			if (rs.next()) {
				sysRoleStr = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (sysRoleStr != null && sysRoleStr.trim().length() > 0) {
			String[] str = sysRoleStr.split(",");
			for (int i = 0; i < str.length; i++) {
				list.add(str[i]);
			}

		}

		return list;
	}

	/**
	 * �û����������û��Ĺ�������ID�õ����û����ڽֵ���������
	 * 
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public static String getDeptName(Long userId) {
		String deptName = "";
		ResultSet rs = null;
//		StringBuffer sql = new StringBuffer();
//		sql
//				.append(" select r.name from gos_region r where r.id in(  select d.regionid from gos_user t ,gos_dept d where t.workdeptid=d.id ");
//		sql.append(" and t.workdeptid= ").append(userId);
//		sql.append(")");
		
		StringBuffer sql2 = new StringBuffer();
		sql2
		.append(" select r.name from gos_dept v, gos_region r where v.regionid = r.id   ");
		sql2.append(" and v.id =   ").append(userId);
		
		try {
			rs = dao.executeQuery(sql2.toString());
			if (rs.next()) {
				deptName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deptName;
	}

	/**
	 * �����û�ID�õ����û����ڽֵ���������ID
	 * 
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public static String getDeptId(Long userId) {
		String deptName = "";
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql
				.append(" select  r.id from gos_region r where r.id in(  select d.regionid from gos_user t ,gos_dept d where t.workdeptid=d.id ");
		sql.append(" and t.id= ").append(userId);
		sql.append(") ");
		try {
			rs = dao.executeQuery(sql.toString());
			if (rs.next()) {
				deptName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deptName;
	}

	/**
	 * �ֵ��û��õ�������ID
	 * 
	 * @param userId
	 * @return
	 */
	public static String getUpDeptId(Long userId) {
		String deptName = "";
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql
				.append(" select  r.parentid from gos_region r where r.id in(  select d.regionid from gos_user t ,gos_dept d where t.workdeptid=d.id ");
		sql.append(" and t.id= ").append(userId);
		sql.append(") ");
		try {
			rs = dao.executeQuery(sql.toString());
			if (rs.next()) {
				deptName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deptName;
	}

	public static void updateUserInfo(User user) {
		try {
			dao.update(user);
		} catch (TSDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] str) {
		// GUnitDBUtility gUnitDBUtility = new GUnitDBUtility();
		// long[] ids = new long[2];
		// ids[0]= 101;
		// ids[1]= 102;
		// // List list = gUnitDBUtility.getPriorityByIds(ids);
		//        
		// GUnit gunit = gUnitDBUtility.getGTUnit("gTU_jbshjz");
		// List list = gunit.getChildren();
		//        
		// // GUnit gunit
		// System.out.println("\n ---list : " + list);

	}

	public static List getUserAllList(UserQueryBean bean, Page page) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM AjUser t WHERE 1=1 ");
		if (bean.getLoginId() != null && !bean.getLoginId().equals("")) {
			hsql.append(" and t.loginid like '%").append(bean.getLoginId())
					.append("%'");
		}
		if (bean.getName() != null && !bean.getName().equals("")) {
			hsql.append(" and t.name like '%").append(bean.getName()).append(
					"%'");
		}
		if (bean.getQuId() != null && !bean.getQuId().equals("")
				&& bean.getStreetId() != null && !bean.getStreetId().equals("")) {
			hsql.append(" and t.num like '").append(bean.getStreetId()).append(
					"%'");
		}
		if (bean.getRoleId() != null && !bean.getRoleId().equals("")
				&& !bean.getRoleId().equals("-1")) {
			hsql.append(" and t.systemRole like '%").append(bean.getRoleId())
					.append("%'");
		}
		if (bean.getQuanxianid() != null && !bean.getQuanxianid().equals("")) {
			hsql.append(" and t.priority like '%").append(bean.getQuanxianid())
					.append("%'");
		}
		if (bean.getStreetId() == null || bean.getStreetId().equals("")) {
			if (bean.getQuId() != null && !bean.getQuId().equals("")) {
				hsql.append(" and t.num like '").append(bean.getQuId()).append(
						"%'");
			}
		}
		if (bean.getDeptId() != null && !bean.getDeptId().equals("")) {
			hsql.append(" and (t.deptid = ").append(bean.getDeptId());
			hsql.append(" or t.workdeptid = ").append(bean.getDeptId()).append(
					")");
		}
		hsql.append(" AND t.deleted=0 ");

		hsql.append(" ORDER BY t.deptid asc,t.id asc  ");

		StringBuffer count = new StringBuffer();
		count.append(" select count(*) ").append(hsql);
		SJBaseDAO daoa = new SJBaseDAO();
		try {

			userList = daoa.query(hsql.toString(), count.toString(), page);
		} catch (TSDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public static List getAjUserAllList(UserQueryBean bean, Page page) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM AjUser t WHERE 1=1 ");
		if (bean.getDeptId() != null && !bean.getDeptId().equals("")) {
			hsql.append(" and t.deptid =").append(bean.getDeptId());
		}

		hsql.append(" AND t.deleted=0 ");

		hsql.append(" ORDER BY t.id asc  ");

		StringBuffer count = new StringBuffer();
		count.append(" select count(*) ").append(hsql);		
		SJBaseDAO daoa = new SJBaseDAO();
		try {

			userList = daoa.query(hsql.toString(), count.toString(), page);
		} catch (TSDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

//	/**
//	 * 1�о� 2���� 3�ֵ� 4�м���ҵ 5 6������ҵ
//	 * 
//	 * @param user
//	 * @return
//	 * @throws Exception
//	 */
//	public static String getUseLevel(User user) throws Exception {
//		// �����û���Ϣ
//
//		// ȡ���û�����
//		String userCode = user.getNum();
//		String forwardStr = "";
//		if (userCode.length() > 0) {
//			String afterStringShi = userCode.substring(3, 6);// ȡ��456λ
//			String afterStringQu = userCode.substring(6, 9);// ȡ��789λ
//			String afterStringhang = userCode.substring(11, 12);// ȡ��12λ
//			if (afterStringShi != null && !afterStringShi.equals("")) {
//				int j = Integer.parseInt(afterStringShi);// ��ȡ��456λ���ַ�ת�������͵�
//				int j2 = Integer.parseInt(afterStringQu);// ��ȡ��789λ���ַ�ת�������͵�
//				int j3 = Integer.parseInt(afterStringhang);// ��ȡ����12λ���ַ���ת�������ε�
//				forwardStr = "5";
//				if (j3 == 3) {// ����û�����ĵ�12λ��3����ô����ҵ�Ż�
//					if (j > 0) {
//						if (j2 == 0) {// ���456λ����0����789λ����0,��ô��������ҵ�Ż�
//							forwardStr = "6";
//						}
//					} else if (j == 0) {// �����������λ��000,��ô���м���ҵ�Ż�
//						forwardStr = "4";
//					}
//				} else {
//					if (j > 0) {// ���789λ>0,��ô�ǽֵ��Ż�
//						forwardStr = "3";
//						if (j2 == 0) {// ���456λ����0����789λ����0,��ô�������Ż�
//							forwardStr = "2";
//						}
//					} else if (j == 0) {// �����������λ��000,��ô���м��Ż�
//						forwardStr = "1";
//					}
//				}
//			}
//		}
//		return forwardStr;
//	}

	/**
	 * �õ���λ���� ��λ���� 1 ����֡�2 ú��� 3 ������ί���Ա��λ
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getUnitNature(User user) throws Exception {
		// ȡ���û�����
		String userCode = user.getNum();
		String forwardStr = "";
		if (userCode.length() > 0) {
			String afterStringhang = userCode.substring(11, 12);// ȡ��12λ
			int j3 = Integer.parseInt(afterStringhang);// ��ȡ����12λ���ַ���ת�������ε�
			if (j3 == 1) {// ����û�����ĵ�12λ��1����ô�ǰ����
				forwardStr = "1";
			}
			if (j3 == 2) {// ����û�����ĵ�12λ��3����ô��ú���
				forwardStr = "2";
			}
			if (j3 == 3) {// ����û�����ĵ�12λ��3����ô��������ί���Ա��λ
				forwardStr = "3";
			}
		}
		return forwardStr;
	}

	/**
	 * �õ� �о� ���� �ֵ� �������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getUseRegoinCode(User user) throws Exception {
		// ȡ���û�����
		String userCode = user.getNum();
		String forwardStr = "";
		if (userCode.length() > 0) {
			String shijiCode = "11000000000";// �����м����������
			String quXianCode = userCode.substring(0, 6);// ȡ��ǰ6λ������
			String QuXianCodeFinal = quXianCode + "00000";// ���ص����ձ���
			String jiDaoCode = userCode.substring(0, 9);// ȡ��ǰ9λ���ֵ�
			String jiDaoCodeFinal = jiDaoCode + "00";// ȡ��ǰ9λ���ֵ�
			String jiDaoBossCode = QuXianCodeFinal;// �ֵ����ϼ�������
			String afterStringShi = userCode.substring(3, 6);// ȡ��456λ
			String afterStringQu = userCode.substring(6, 9);// ȡ��789λ
			String afterStringhang = userCode.substring(11, 12);// ȡ��12λ
			if (afterStringShi != null && !afterStringShi.equals("")) {
				int j = Integer.parseInt(afterStringShi);// ��ȡ��456λ���ַ�ת�������͵�
				int j2 = Integer.parseInt(afterStringQu);// ��ȡ��789λ���ַ�ת�������͵�
				int j3 = Integer.parseInt(afterStringhang);// ��ȡ����12λ���ַ���ת�������ε�

				// if(j3==3){//����û�����ĵ�12λ��3����ô����ҵ�Ż�
				// forwardStr=shijiCode;
				// }else{
				if (j == 0) {// �����������λ��000,��ô���м��Ż�
					forwardStr = shijiCode;
				}

				if (j > 0) {// ���789λ>0,��ô�ǽֵ��Ż�
					forwardStr = jiDaoCodeFinal;
					if (j2 == 0) {// ���456λ����0����789λ����0,��ô�������Ż�
						forwardStr = QuXianCodeFinal;
					}
				}
				// }
			}
		}
		return forwardStr;
	}

	/**
	 * �õ���������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getDeptCode(User user) throws Exception {
		// ȡ���û�����
		String userCode = user.getNum();
		String deptCode = "";
		if (userCode.length() > 0) {
			deptCode = userCode.substring(0, 17);// ��������
		}
		return deptCode;
	}

	/**
	 * �õ���������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getDeptCodea(User user) throws Exception {
		// ȡ���û�����
		String userCode = user.getNum();
		String deptCode = "";
		if (userCode.length() > 0) {
			deptCode = userCode.substring(0, 18);// ��������
		}
		return deptCode;
	}

	/**
	 * ������������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getQuCode(User user) throws Exception {
		// ȡ���û�����
		String userCode = user.getNum();
		String deptCode = "";
		if (userCode.length() > 0) {
			deptCode = userCode.substring(0, 11);// ������������
		}
		return deptCode;
	}

	/**
	 * �õ���һ���������
	 * 
	 * @param user
	 * @return
	 */
	public static String getUpCode(User user) {
		// ȡ���û�����
		String userCode = user.getNum();
		String forwardStr = "";
		if (userCode.length() > 0) {
			String shijiCode = "11000000000";// �����м����������
			String quXianCode = userCode.substring(0, 6);// ȡ��ǰ6λ������
			String QuXianCodeFinal = quXianCode + "00000";// ���ص����ձ���
			String jiDaoCode = userCode.substring(0, 9);// ȡ��ǰ9λ���ֵ�
			String jiDaoCodeFinal = jiDaoCode + "00";// ȡ��ǰ9λ���ֵ�
			String jiDaoBossCode = QuXianCodeFinal;// �ֵ����ϼ�������
			String afterStringShi = userCode.substring(3, 6);// ȡ��456λ
			String afterStringQu = userCode.substring(6, 9);// ȡ��789λ
			String afterStringhang = userCode.substring(11, 12);// ȡ��12λ
			if (afterStringShi != null && !afterStringShi.equals("")) {
				int j = Integer.parseInt(afterStringShi);// ��ȡ��456λ���ַ�ת�������͵�
				int j2 = Integer.parseInt(afterStringQu);// ��ȡ��789λ���ַ�ת�������͵�
				int j3 = Integer.parseInt(afterStringhang);// ��ȡ����12λ���ַ���ת�������ε�

				// if(j3==3){//����û�����ĵ�12λ��3����ô����ҵ�Ż�
				// forwardStr=shijiCode;
				// }else{
				if (j == 0) {// �����������λ��000,��ô���м��Ż� �������м������м�
					forwardStr = shijiCode;
				}

				if (j > 0) {// ���789λ>0,��ô�ǽֵ��Ż�,�ֵ����ϼ�������
					forwardStr = QuXianCodeFinal;
					if (j2 == 0) {// ���456λ����0����789λ����0,��ô�������Ż�,�������ϼ����м�
						forwardStr = shijiCode;
					}
				}
				// }
			}
		}
		return forwardStr;
	}

	public SjRegion getRegionCode(Long id) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM SjRegion t WHERE 1=1 ");

		if (id != null) {
			hsql.append(" and t.id=").append(id);
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		SjRegion region = new SjRegion();
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				region = (SjRegion) userList.get(0);
			}
		}
		return region;
	}

	/**
	 * ��ýֵ��û��������ؼ��
	 * 
	 * @param id
	 * @return
	 */
	public static String getQxShortName(Long id) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM SjRegion t WHERE 1=1 ");

		if (id != null) {
			hsql.append(" and t.id=").append(id);
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		SjRegion region = new SjRegion();
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				Object obj = (Object) userList.get(0);
				region = (SjRegion) obj;
			}
		}
		String shortName = "";
		if (region != null)
			shortName = region.getShortName();
		return shortName;
	}

	/**
	 * �����û����ڲ���ID�õ�������
	 * 
	 * @param id
	 * @return
	 */
	public static String getRegionShortName(Long id) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM SjRegion t,AjDept d WHERE t.id=d.regionId ");

		if (id != null) {
			hsql.append(" and d.id=").append(id);
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		SjRegion region = new SjRegion();
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				Object[] obj = (Object[]) userList.get(0);
				region = (SjRegion) obj[0];
			}
		}
		String shortName = "";
		if (region != null)
			shortName = region.getShortName();
		return shortName;
	}

	public static String getRegionName(Long code) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM SjRegion t WHERE 1=1 ");

		if (code != null) {
			hsql.append(" and t.regionCode=").append(code);
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		SjRegion region = new SjRegion();
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				region = (SjRegion) userList.get(0);
			}
		}
		String regionName = "";
		if (region != null)
			regionName = region.getName();
		return regionName;
	}

	public int getUserCodeSize(String codea) throws HibernateException {
		int codesize = 0;
		StringBuffer hsql = new StringBuffer();
		hsql.append(" FROM AjUser d WHERE 1=1 ");
		if (codea != null && !codea.equals("")) {
			hsql.append(" AND d.num like '").append(codea).append("%'");
		} else {
			hsql.append(" AND d.num like '11000000000101000002%'");
		}
		List list = dao.query(hsql.toString());
		if (list != null && list.size() > 0) {
			codesize = list.size();
		}
		return codesize;
	}

	/**
	 * �����û��Ĺ�������ID �ϼ���������
	 * 
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public static String getUpDeptName(Long deptId) {
		String deptName = "";
		ResultSet rs = null;
//		StringBuffer sql = new StringBuffer();
//		sql
//				.append("  select w.name from gos_region w where w.id=( select r.parentid from gos_region r where r.id in(");
//		sql.append(" select d.regionid  from gos_dept d where d.id= ").append(
//				deptId);
//		sql.append(") )");
		
		StringBuffer sql2 = new StringBuffer();
		sql2
		.append(" select p.name from gos_dept v, gos_region r, gos_region p where v.regionid = r.id   and r.parentid = p.id   ");
		sql2.append("  and v.id =   ").append(deptId);
		
		try {
			rs = dao.executeQuery(sql2.toString());
			if (rs.next()) {
				deptName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deptName;
	}
//
//	/**
//	 * 1����ID ȥ��������һ��˳����Ƕ��� 2���Ҫ�Ƶı���С�Ĵ� �ǽ������� 3���� ���������� 3.1 �������ر����������ֶ�
//	 * ��Ҫ�������Ƶ���һ����¼�������ֶ��Ƕ��٣� 3.2 ����3.1 ��������¼ ���������������ֶ�SET Ϊ�ӵ���orderByItem 3.3
//	 * ����ID �޸������������ֶ� ֵΪ3.1���������
//	 * 
//	 * @throws SQLException
//	 */
//	public void toMoveUp(String id, String orderByItem, String deptid,
//			String userCode) throws TSDBException, SQLException {
//
//		AjUser upAjUser = new AjUser();
//		AjUser toUpAjUser = new AjUser();
//		toUpAjUser = getAjUserById(new Long(id));
//		// 1
//		AjUser ajuser = queryMinUserByUserCode(deptid, null);
//		int minItem = ajuser.getOrderByItem();// �õ������������һ�������
//		int orderItem = Integer.parseInt(orderByItem);// Ҫ�������Ʋ����� ��ǰ�����
//		// 2
//
//		if (orderItem == minItem) {
//		} else {
//			// 3
//			// 3.1
//			AjUser maxAjUser = queryMaxUserByUserCode(deptid, orderByItem);
//			int temItem = maxAjUser.getOrderByItem();// Ŀ�����
//			// 3.2
//			upAjUser = queryAjUserByUpItem(deptid,String.valueOf(temItem));
//			upAjUser.setOrderByItem(orderItem);
//			dao.update(upAjUser);
//			// 3.3
//
//			toUpAjUser.setOrderByItem(temItem);
//			dao.update(toUpAjUser);
//		}
//
//	}
//
//	public void toMoveDown(String id, String orderByItem, String deptid,
//			String userCode) throws TSDBException, SQLException {
//
//		AjUser downAjUser = new AjUser();
//		AjUser todownAjUser = new AjUser();
//		todownAjUser = getAjUserById(new Long(id));
//		// 1
//		AjUser ajuser = queryMinUserByUserCode(deptid, orderByItem);
//		int minItem = ajuser.getOrderByItem();// �õ������������һ�������
//		int orderItem = Integer.parseInt(orderByItem);// Ҫ�������Ʋ����� ��ǰ�����
//		// 2
//		if (minItem != 0) {
//			if (orderItem == minItem) {
//			} else {
//				// 3
//				// 3.1
//				AjUser maxAjUser = queryMinUserByUserCode(deptid, orderByItem);
//				int temItem = maxAjUser.getOrderByItem();// Ŀ�����
//				// 3.2
//				downAjUser = queryAjUserByUpItem(deptid,String.valueOf(temItem));
//				downAjUser.setOrderByItem(orderItem);
//				dao.update(downAjUser);
//				// 3.3
//				todownAjUser.setOrderByItem(temItem);
//				dao.update(todownAjUser);
//			}
//		}
//
//	}
//
//	public AjUser queryMinUserByUserCode(String deptid, String orderByItem)
//			throws TSDBException, SQLException {
//
//		AjUser ajUser = new AjUser();
//		StringBuffer sql = new StringBuffer();
//		if (deptid != null && !deptid.equals("")) {
//			sql
//					.append("  select min(a.orderby_item) as orderby_item, min(a.user_code) as user_code from gos_user  a where a.deleted=0 ");
//			sql.append(" and a.deptid =").append(deptid);
//			if (orderByItem != null && !orderByItem.equals(""))
//				sql.append(" and a.orderby_item >").append(orderByItem);
//			sql.append(" order by a.orderby_item asc");
//		}
//	
//
//		if (sql != null && !sql.equals("")) {
//			ResultSet rs = dao.executeQuery(sql.toString());
//			while (rs.next()) {
//
////				ajUser.setOrderByItem(rs.getInt("orderby_item"));
//				ajUser.setNum(rs.getString("user_code"));
//			}
//		}
//
//		return ajUser;
//	}
//
//	public AjUser queryMaxUserByUserCode(String deptid, String orderByItem)
//			throws TSDBException, SQLException {
//
//		AjUser ajUser = new AjUser();
//		StringBuffer sql = new StringBuffer();
//		if (deptid != null && !deptid.equals("")) {
//			sql
//					.append("  select max(a.orderby_item) as orderby_item, min(a.user_code) as user_code from gos_user  a where a.deleted=0 ");
//			sql.append(" and a.deptid =").append(deptid);
//			if (orderByItem != null && !orderByItem.equals(""))
//				sql.append(" and a.orderby_item <").append(orderByItem);
//			sql.append(" order by a.orderby_item asc");
//		}
//		
//
//		if (sql != null && !sql.equals("")) {
//			ResultSet rs = dao.executeQuery(sql.toString());
//			while (rs.next()) {
//
////				ajUser.setOrderByItem(rs.getInt("orderby_item"));
//				ajUser.setNum(rs.getString("user_code"));
//			}
//		}
//
//		return ajUser;
//	}
//
//	public AjUser queryAjUserByUpItem(String deptid,String item) throws TSDBException,
//			SQLException {
//
//		List list = null;
//		AjUser ajUser = new AjUser();
//		StringBuffer sql = new StringBuffer();
//		if (item != null && !item.equals("")) {
//			sql.append("  from AjUser r where   1=1 ");
//			sql.append(" and r.orderByItem=").append(item);
//			sql.append(" and r.deptid=").append(deptid);
//			sql.append(" order by r.orderByItem asc");
//		}
//		if (sql != null && !sql.equals("")) {
//			list = dao.query(sql.toString());
//			if (list != null && list.size() > 0)
//				ajUser = (AjUser) list.get(0);
//		}
//
//		return ajUser;
//	}
//
//	/**
//	 * ��ѯִ����Ա��Ϣ
//	 * 
//	 * @param bean
//	 * @param page
//	 * @return
//	 */
//	public List getzfUserList(UserQueryBean bean, Page page) {
//		List userList = null;List listP = new ArrayList();
//		List listT = new ArrayList();
//		StringBuffer queryHql = new StringBuffer("");
//		StringBuffer countHql = new StringBuffer("");
//		AjUser d;
//		queryHql.append(" FROM AjUser t WHERE  1=1");
//
//		/** ���sfzfΪ1���ǲ�ѯִ����Ա �����ѯ������ִ����Ա * */
//		if (bean.getSfzf() != null && bean.getSfzf().intValue() == 1) {
//			queryHql.append(" and t.sfzf=1 ");
//			
//		} else {
//			queryHql.append(" and t.sfzf is null ");
//		}
//		
//		if(bean.getDeptId()!=null){
//			queryHql.append(" and t.deptid = ?");
//			listP.add(bean.getDeptId());
//			listT.add(Hibernate.LONG);
//		}
//
//		if (bean.getQuId() != null && !bean.getQuId().equals("")
//				&& bean.getStreetId() != null && !bean.getStreetId().equals("")) {
//			queryHql.append(" and t.num like ?");
//			listP.add("%"+bean.getStreetId()+"%");
//			listT.add(Hibernate.STRING);
//		}
//		
//		if (bean.getDeptId() != null ) {
//			queryHql.append(" and t.deptid like ?");
//			listP.add(bean.getDeptId());
//			listT.add(Hibernate.LONG);
//		}
//		
//		if (bean.getStreetId() == null || bean.getStreetId().equals("")) {
//			if (bean.getQuId() != null && !bean.getQuId().equals("")
//					&& !bean.getQuId().equals("-1")) {
//				queryHql.append(" and t.num like ?");
//				listP.add("%"+bean.getQuId()+"%");
//				listT.add(Hibernate.STRING);
//			}
//		}
//
//		if (bean.getRegoin() != null && !bean.getRegoin().equals("")) {
//			queryHql.append(" and t.num like ?");
//			listP.add("%"+bean.getRegoin()+"%");
//			listT.add(Hibernate.STRING);
//		}
//
//		if (bean.getName() != null && !bean.getName().equals("")) {
//			queryHql.append(" and t.name like ?");
//			listP.add("%"+bean.getName()+"%");
//			listT.add(Hibernate.STRING);
//		}
//
//		queryHql.append(" AND t.deleted=0 ");
//
//		queryHql.append(" ORDER BY t.deptid asc,t.id asc ");
//		
//		Type[] types = (Type[]) listT.toArray(new Type[0]);
//		countHql.append(" select count(*) ").append(queryHql);
//		
//		try {
//			int count = 0;
//			if (page.getTotalCount() < 0) {
//				count = dao.count(countHql.toString(),types,listP.toArray());
//				page.setTotalCount(count);
//			} else {
//				count = page.getTotalCount();
//			}
//			if (count == 0) {
//				return new ArrayList();
//			}
//			int pageSize = count;//page.getPageSize();
//			int pageNumber = page.getPageCount() < page.getCurrentPage() ? page
//					.getPageCount() : page.getCurrentPage();
//			
//			userList = dao.query(queryHql.toString(), listP.toArray(), types, pageSize,
//					(pageNumber - 1));
//			
//		} catch (TSDBException e) {
//
//			e.printStackTrace();
//		}
//
//		return userList;
//	}

	/**
	 * �����û�ID������ �жϾ������Ƿ���ȷ
	 * 
	 * @param pwd
	 * @return
	 * @throws TSDBException
	 */
	public static boolean queryAjUserPwd(String id, String pwd)
			throws TSDBException, SQLException {

		List list = null;
		AjUser ajUser = new AjUser();
		StringBuffer sql = new StringBuffer();
		if (id != null && !id.equals("")) {
			sql.append("  from AjUser r where   1=1 ");
			sql.append(" and r.id=").append(id);

		}
		if (sql != null && !sql.equals("")) {
			list = dao.query(sql.toString());
			if (list != null && list.size() > 0)
				ajUser = (AjUser) list.get(0);
		}
        //�Ѵ�������������м��ܺ��ܲ���Ľ��бȽ� 		
		if (ajUser.getPassword().equals(AESUtil.encrypt(pwd)))
			return true;
		return false;
	}

	public boolean updateUserPwd(User user, String pwd, UserDao dao) {

		user = (User) dao.getEntityById(user.getId());
		user.setPassword(pwd);
		dao.updateEntity(user);
		return true;
	}

	public AjUser queryAjUserById(String id) throws TSDBException, SQLException {

		List list = null;
		AjUser ajUser = new AjUser();
		StringBuffer sql = new StringBuffer();
		if (id != null && !id.equals("")) {
			sql.append("  from AjUser r where   1=1 ");
			sql.append(" and r.id=").append(id);
			sql.append(" order by r.id asc");
		}
		if (sql != null && !sql.equals("")) {
			list = dao.query(sql.toString());
			if (list != null && list.size() > 0)
				ajUser = (AjUser) list.get(0);
		}

		return ajUser;
	}

	/**
	 * �����û�ID�����û�Ȩ�޺ͽ�ɫ
	 * @param userId
	 * @param systemRole
	 * @param priority
	 * @throws TSDBException
	 */
	public void updateSystemRoleAndPriority(Long userId, String systemRole,
			String priority) throws TSDBException {
		AjUser ajUser = (AjUser) dao.load(AjUser.class, userId.longValue());
		ajUser.setPriority(priority);
		ajUser.setSystemRole(systemRole);

		System.out.println("\n priority:" + priority);
		System.out.println("\n systemRole :" + systemRole);
		System.out.println("\n ajUser :" + ajUser);

		StringBuffer sql = new StringBuffer();
		sql.append(" update gos_user u ").append(" set u.priority='")
				.append(priority).append("'").append(" ,u.system_role='")
				.append(systemRole).append("'").append("  where u.id=").append(
						userId);

		try {
			dao.executeUpdate(sql.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

	} 
			 

	public void mergeAndUpdateSystemRoleAndPriority(Long userId,
			String systemRole, String priority) throws TSDBException {
		AjUser ajUser = (AjUser) dao.load(AjUser.class, userId.longValue());
		systemRole = StringUtils
				.mergeCsvStr(systemRole, ajUser.getSystemRole());
		priority = StringUtils.mergeCsvStr(priority, ajUser.getPriority());
		if (priority.length() != 0) {
			priority = "," + priority + ",";
		}
		ajUser.setPriority(priority);
		ajUser.setSystemRole(systemRole);
		dao.update(ajUser);
	}

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
//		sql.append(" select max(u.orderby_item) from gos_user u  ");
//		try {
//			rs = dao.executeQuery(sql.toString());
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
	 * �����û����� �õ��û�ID
	 * 
	 * @param name
	 * @return
	 */
	public static Long getUserIdByName(String name) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM AjUser t WHERE 1=1 ");

		if (name != null) {
			hsql.append(" and t.name='").append(name).append("'");
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		AjUser user = new AjUser();
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				user = (AjUser) userList.get(0);
			}
		}
		Long userId = null;
		if (user != null)
			userId = user.getId();
		return userId;
	}

	/**
	 * �����������õ�����ID
	 * 
	 * @param code
	 * @return
	 */
	public static Long getRegionIdByCode(Long code) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM SjRegion t WHERE 1=1 ");

		if (code != null) {
			hsql.append(" and t.regionCode=").append(code);
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			e.printStackTrace();
		}
		SjRegion region = new SjRegion();
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				region = (SjRegion) userList.get(0);
			}
		}
		Long regionid = null;
		if (region != null)
			regionid = region.getId();
		return regionid;
	}

	

	/**
	 * �õ�AjUser
	 * 
	 * @param id
	 * @param password
	 */
	public static AjUser getAjUser(Long id) {
		try {
			return (AjUser) dao.load(AjUser.class, id);

		} catch (TSDBException e) {
			e.printStackTrace();
			return null;
		}
	}	
//	
//	/**
//	 * �����û�ID�õ���λ����
//	 * @param userid
//	 * @return
//	 */
//	public String getDeptCodeByUserId(Long userid){
//		String deptCode="";
//		ResultSet rs = null;
//		StringBuffer sql = new StringBuffer();
//		sql.append(" select d.dept_code from gos_user u,gos_dept d where u.workdeptid=d.id and u.deleted=0 and d.use_flag=1  ");
//		if(userid!=null)
//			sql.append(" and u.id=").append(userid);
//		try {
//			rs = dao.executeQuery(sql.toString());
//			if (rs.next()) {
//				deptCode = rs.getString(1);
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
//		return deptCode;
//	}
// /**
//  * �����û�ID �ı��û�����
// * @param userid
// * @param orderitem
// */
//public static void updateUserOrderItem(String userid, String orderitem) {	
//	if(orderitem!=null&&!orderitem.equals("")&&userid!=null&&!userid.equals("")){
//		StringBuffer updateSql = new StringBuffer(
//		" update gos_user u set u.orderby_item=").append(orderitem);
//		updateSql.append(" where u.id='").append(userid).append("'");
//		Logger.debug("\n\n updateSql.toString() " + updateSql.toString());
//		dao.execute(updateSql.toString());
//	}		
//  }
//
/**
 * ����ʹ�ø����û�ID�õ������������
 * @param userId
 * @return
 */
public static String getRegionCodeforQu(Long userId) {
	String regionCode = "";
	ResultSet rs = null;
	StringBuffer sql = new StringBuffer();
	sql
			.append(" select  r.region_code from gos_region r where r.id in(  select d.regionid from gos_user t ,gos_dept d where t.workdeptid=d.id ");
	sql.append(" and t.id= ").append(userId);
	sql.append(") ");
	try {
		rs = dao.executeQuery(sql.toString());
		if (rs.next()) {
			regionCode = rs.getString(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return regionCode;
}
/**
 * �ֵ��û�ʹ�ø����û�ID�õ� �����������
 * 
 * @param userId
 * @return
 */
public static String getUpRegionCodeforJie(Long userId) {
	String regionCode = "";
	ResultSet rs = null;
	StringBuffer sql = new StringBuffer();
	sql
			.append(" select r.region_code from gos_region r  where r.id in(select re.parentid from gos_user u ,gos_dept d,gos_region re where u.workdeptid=d.id and d.regionid=re.id ");
	sql.append(" and u.id= ").append(userId);
	sql.append(") ");
	try {
		rs = dao.executeQuery(sql.toString());
		if (rs.next()) {
			regionCode = rs.getString(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return regionCode;
}


	public static void updateUserPwdfor(String userid, String pwd) {	
		if(pwd!=null&&!pwd.equals("")&&userid!=null&&!userid.equals("")){
			StringBuffer updateSql = new StringBuffer(
			" update gos_user u set u.password='").append(pwd).append("'");
			updateSql.append(" where u.id=").append(userid).append("");
			Logger.debug("\n\n updateSql.toString() " + updateSql.toString());
			dao.execute(updateSql.toString());
		}		
	  }
	public static List getUserListfor(String loginid,String name) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM AjUser t WHERE 1=1 ");
		if(loginid!=null&&!loginid.equals("")){
			hsql.append(" and t.loginid like '%").append(loginid).append("%'");
		}
		if(name!=null&&!name.equals("")){
			hsql.append(" and t.name like '%").append(name).append("%'");
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}
	
	public static List getPorpertyForSys(Long userId) {
		List list = new ArrayList();
		String sysRoleStr = "";
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u.system_role FROM gos_user u ").append(
				" WHERE u.id=").append(userId);

		try {
			rs = dao.executeQuery(sql.toString());
			if (rs.next()) {
				sysRoleStr = rs.getString(1);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}

		if (sysRoleStr != null && sysRoleStr.trim().length() > 0) {
			String[] str = sysRoleStr.split(",");
			for (int i = 0; i < str.length; i++) {
				list.add(str[i]);
			}

		}

		return list;
	}
	
	/**
	 * �����û�IDȥ���û���ĳ��Ȩ��
	 * update gos_user set priority=replace(priority,',1600001','')
	 * @param userid
	 * @param porpertyid
	 */
	public static void deUserPorperty(String userid, String porpertyid) {	
		if(porpertyid!=null&&!porpertyid.equals("")&&userid!=null&&!userid.equals("")){
			StringBuffer updateSql = new StringBuffer(
			" update gos_user set priority=replace(priority,',").append(porpertyid.trim()).append("','')");
			updateSql.append(" where id=").append(userid).append("");
			Logger.debug("\n\n updateSql.toString() " + updateSql.toString());
			dao.execute(updateSql.toString());
		}		
	  }

	/**
	 * �����û�ID�����û�����һ��Ȩ��
	 * update gos.gos_user u set u.priority=u.priority||'xxx,' where u.id=xx
	 * @param userid
	 * @param porpertyid
	 */
	public static void addUserPorperty(String userid, String porpertyid) {	
		if(porpertyid!=null&&!porpertyid.equals("")&&userid!=null&&!userid.equals("")){
			StringBuffer updateSql = new StringBuffer(
			" update gos_user u set u.priority=u.priority||'").append(porpertyid.trim()).append(",'");
			updateSql.append(" where u.id=").append(userid).append("");
			Logger.debug("\n\n updateSql.toString() " + updateSql.toString());
			dao.execute(updateSql.toString());
		}		
	  }
	public static List getUserListByDeptid(String deptid) {
		List userList = null;
		StringBuffer hsql = new StringBuffer();

		hsql.append(" FROM AjUser t WHERE 1=1 ");
		if(deptid!=null&&!deptid.equals("")){
			hsql.append(" and t.deptid=").append(deptid).append(" and t.positionid is not null");
		}

		try {
			userList = dao.query(hsql.toString());
		} catch (TSDBException e) {		
			e.printStackTrace();
		}
		return userList;
	}
	
	/**
	 *�����û�num��ѯ�û�
	 *
	 *
	 */
	 public static User getUserByNum(String num){
		 List<User> list=null;
		 User user=null;
		 StringBuffer hsql = new StringBuffer();
		 if(num!=null&&!"".equals(num.trim())){
			 hsql.append(" FROM AjUser u where u.num ='"+num+"'");
		 }
		 if(hsql.length()>0){
			 try {
					list = dao.query(hsql.toString());
				} catch (TSDBException e) {
					e.printStackTrace();
				}
				if(list!=null&&list.size()>0){
					user=list.get(0);
				}
		 }
		 
		 return user;
	 }
}
