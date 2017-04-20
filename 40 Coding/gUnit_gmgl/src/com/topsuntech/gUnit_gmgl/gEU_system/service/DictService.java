package com.topsuntech.gUnit_gmgl.gEU_system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;

public class DictService extends HibernateBaseService {
	/**
	 * 
	 * @param command
	 * @param pid
	 */
	public void saveDict(Dict command, Long pid) {
		Dict type = null;
		if (command.getId() != null && command.getId().longValue() > 0) {
			// id>0编辑
			type = load(Dict.class, command.getId());
		} else if (pid != null && pid.longValue() >= 0) {
			// 新增
			type = new Dict();
			type.setParent(load(Dict.class, pid));
		}
		type.setDictName(command.getDictName());
		type.setDictCode(command.getDictCode());
		type.setIsValidate(command.getIsValidate());
		type.setRemark(command.getRemark());
		type.setSort(command.getSort());
		saveOrUpdate(type);
	}

	/**
	 * 根据PID获取业务分类树
	 * 
	 * @param pid
	 * @return
	 */
	public List<Dict> getDictListByPID(Page page, Long pid) {
		StringBuffer querySql = new StringBuffer(" FROM Dict cd WHERE    cd.parent.id= " + pid + " order by sort");
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(cd.id) ").append(querySql);
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		List<Dict> rs = (List<Dict>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
		return rs;
	}

	public List<Dict> getDictTreeNodeByPid(Long pid) {
		List<Dict> result = (List<Dict>) find("from Dict cd where cd.parent.id=?", pid);
		return result;
	}

	public Dict getDictById(Long id) {
		return load(Dict.class, id);
	}

	public void deleteDictById(Long id) {
		delete(load(Dict.class, id));
	}

	@SuppressWarnings("unchecked")
	public List<Dict> getDictByCode(String code) {
		if (StringUtils.isNotEmpty(code)) {
			List<Dict> result = new ArrayList<Dict>();
			result = (List<Dict>) find("from Dict d where  d.dictCode=? order by sort", code);
			return result;
		} else {
			return null;
		}
	}

}
