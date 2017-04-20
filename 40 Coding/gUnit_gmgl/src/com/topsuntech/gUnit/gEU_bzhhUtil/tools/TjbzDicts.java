package com.topsuntech.gUnit.gEU_bzhhUtil.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.dao.StaticBaseDAO;
import com.topsuntech.gUnit_tjbz.gEU_system.entity.UserOpRole;
import com.topsuntech.gUnit_tjbz.gEU_system.service.vo.UserOpRoleQueryBean;

/**
 * 天津殡葬专用
 * 
 * @author zcpeng
 * 
 */
public class TjbzDicts extends TjbzConstants {
	
	private static Logger logger = Logger.getLogger(TjbzDicts.class);
	
	
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
	
	public static Hashtable<Long, UserOpRole> getUserOpRoleByUserId(UserOpRoleQueryBean userOpRoleQueryBean) throws TSDBException {
		Hashtable<Long, UserOpRole> table = new Hashtable<Long, UserOpRole>(); 
		StringBuffer hql = new StringBuffer();
		hql.append("select t.* from user_op_role t where 1 = 1");
		if(userOpRoleQueryBean != null){
			if(userOpRoleQueryBean.getId() != null && userOpRoleQueryBean.getId().longValue() != 0)
				hql.append(" and t.id = ").append(userOpRoleQueryBean.getId());
			//用户UserId
			if(userOpRoleQueryBean.getUserid() != null && userOpRoleQueryBean.getUserid().longValue() != 0)
				hql.append(" and t.userid = ").append(userOpRoleQueryBean.getUserid());	
			if(userOpRoleQueryBean.getMenu_type() != null && userOpRoleQueryBean.getMenu_type().longValue() != 0)
				hql.append(" and t.menu_type = ").append(userOpRoleQueryBean.getMenu_type());	
			if(userOpRoleQueryBean.getUse_flag() != null)
				hql.append(" and t.use_flag = ").append(userOpRoleQueryBean.getUse_flag());
		}
		hql.append(" order by id desc ");
		ResultSet set = null;
		set = dao.executeQuery(hql.toString());
		try{
			if(set != null){
				while(set.next()){
					UserOpRole role = new UserOpRole();
					role.setId(set.getLong(1));
					role.setUname(set.getString(2));
					role.setUloginid(set.getString(3));
					role.setPosition(set.getString(4));
					role.setSysflag(set.getString(5));
					role.setSys_name(set.getString(6));
					role.setMenu_type(set.getLong(7));
					role.setIsadd(set.getLong(8));
					role.setIsedit(set.getLong(9));
					role.setIsdelete(set.getLong(10));
					role.setCreate_user_id(set.getLong(11));
					role.setCreate_date(set.getDate(12));
					role.setModify_user_id(set.getLong(13));
					role.setModify_date(set.getDate(14));
					role.setUse_flag(set.getLong(15));
					role.setUserid(set.getLong(16));
					role.setIs_modify_submit(set.getLong(17));
					role.setIs_delete_submit(set.getLong(18));
					
					table.put(role.getMenu_type(), role);
					System.out.println("查询登陆人权限2:"+role.getUname()+"，菜单："+role.getMenu_type());
					logger.info("查询登陆人权限3:"+role.getUname()+"，菜单："+role.getMenu_type());
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(set != null){
					set.close();
				}
			}catch(SQLException s){
				s.printStackTrace();
			}
		}
		return table;
	}
}
