package com.topsuntech.gUnit.gEU_system.service;

import java.sql.SQLException;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.type.Type;

import com.topsuntech.gOS.identity.office.service.OfficeFinderImpl;
import com.topsuntech.gOS.identity.util.DBWrapperCallback;
import com.topsuntech.gOS.identity.util.HqlHelper;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;

public class AjDeptFinder extends OfficeFinderImpl {

	public List findOfficesByIds(final Long[] ids) {

		return (List) getOfficeDao().executeInDBWrapper(
				new DBWrapperCallback() {

					public Object doInDBWrapper(DBWrapper dbWrapper)
							throws TSDBException, SQLException {
						Type type[] = new Type[ids.length];
						for (int i = 0; i < type.length; i++) {
							type[i] = Hibernate.LONG;
						}
						return dbWrapper.query("from AjDept t where t.useFlag = 1 and t.id in "
								+ HqlHelper.buildMultiValueExpression(ids.length) + " order by t.disporder", ids, type);
					}

				});
	}
	
	public List findOfficesByParentIds(final Long[] parentIds) {
		return (List) getOfficeDao().executeInDBWrapper(new DBWrapperCallback() {
			public Object doInDBWrapper(DBWrapper dbWrapper) throws TSDBException, SQLException {
				Type[] type = new Type[parentIds.length];
				for (int i = 0; i < type.length; i++) {
					type[i] = Hibernate.LONG;
				}
				return dbWrapper.query("from AjDept t where t.useFlag = 1 and t.parentId in " + HqlHelper.buildMultiValueExpression(parentIds.length) + " order by t.disporder",
						parentIds, type);
			}
		});
	}

}
