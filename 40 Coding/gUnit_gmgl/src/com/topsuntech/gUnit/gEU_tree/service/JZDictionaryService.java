package com.topsuntech.gUnit.gEU_tree.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.topsuntech.gUnit.gEU_tree.service.vo.treeBean;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit.gEU_util.tools.Constants;

public class JZDictionaryService extends SJBaseDAO {

	public List getDictNodeForTree(List treeList, long dictId, long treeType, String showCheckBox, String rootFlag) {

		ResultSet rs = null;

		treeList = (treeList != null) ? treeList : new ArrayList();

		String checkName = "ckg" + dictId;

		try {
			StringBuffer querySql = new StringBuffer();
			querySql.append("select * from jz_dictionary y ").append(" where  y.use_flag=1 ").append(" and y.parentid=").append(dictId);

			System.out.println("\n ---querySql : " + querySql.toString());

			rs = getDBWrapper().executeQuery(querySql.toString());
			while (rs.next()) {
				StringBuffer name = new StringBuffer();
				if (showCheckBox.equals(Constants.JUDGEMENT_FLAG.YES)) {
					name.append("<input type='checkbox' name='").append(checkName).append("'").append(" value=',").append(rs.getLong("id")).append(",|,").append(rs.getString("name")).append(",'").append(" onclick='javascript: changeSelectsDept(this)' ").append(">").append(rs.getString("name"));

				} else {
					name.append(rs.getString("name"));
				}

				String chidlNodeValue = rs.getLong("id") + ",0" + "," + treeType;
				String image = rootFlag.equals("Y") ? Constants.treeAttribute.IMAGE : Constants.treeAttribute.IMAGE_CHILD;

				treeList.add(new treeBean(rs.getLong("id"), name.toString(), rootFlag, chidlNodeValue, image, Constants.treeAttribute.URL));
			}
		} catch (Exception e) {
			;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}

		// System.out.println("\n ----treeList : " + treeList);

		return treeList;

	}
}
