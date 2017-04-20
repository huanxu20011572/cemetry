package com.topsuntech.gUnit_tjbz.gEU_system.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.topsuntech.gOS.dynamicform.DBWrapperFactory;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.dao.BaseDAO;
import com.topsuntech.gUnit_tjbz.gEU_system.entity.UserOpRole;
import com.topsuntech.gUnit_tjbz.gEU_system.service.vo.UserOpRoleQueryBean;

/**
 * @author cuixb
 *
 */
@Repository
public class UserOpRoleDAO extends BaseDAO{

	/**
	 * 查询操作权限
	 * @param id
	 * @return
	 * @throws TSDBException
	 */
	public Hashtable<Long, UserOpRole> getUserOpRoleByUserId_(UserOpRoleQueryBean userOpRoleQueryBean) throws TSDBException {
		Hashtable<Long, UserOpRole> table = new Hashtable<Long, UserOpRole>(); 
		StringBuffer hql = new StringBuffer();
		hql.append(" from UserOpRole t where 1 = 1");
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
		List<?> list = queryList(hql.toString());
		if(list != null && list.size() >0){
			for (Object  object : list) {
				UserOpRole role = (UserOpRole)object;
				System.out.println(role.getMenu_type());
				table.put(role.getMenu_type(), role);
			}
			return table;
		}
		return null;
	}

	public Hashtable<Long, UserOpRole> getUserOpRoleByUserId(UserOpRoleQueryBean userOpRoleQueryBean) throws TSDBException {
		DBWrapper db = DBWrapperFactory.getWrapper("tjbz");
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
		set = db.executeQuery(hql.toString());
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
//		
//		if(list != null && list.size() >0){
//			for (Object  object : list) {
//				UserOpRole role = (UserOpRole)object;
//				System.out.println(role.getMenu_type());
//				table.put(role.getMenu_type(), role);
//			}
//			return table;
//		}
		return table;
	}
}
