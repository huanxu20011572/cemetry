package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.entity.Dept;
import com.topsuntech.gUnit.gEU_util.entity.Region;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

public class BzhhRegionNameByDeptIdTag extends KeyValueTag {

	@Override
	public Object getValue(Object arg0, Map arg1) {
		if (arg0 == null || "".equals(arg0.toString())) {
			return null;
		}
		try {
			Dept dept = Dicts.getDeptById(Long.parseLong(arg0.toString()));
			if (dept != null && dept.getRegionid() != null && dept.getRegionid().longValue() > 0) {
				Region region = Dicts.getRegionById(dept.getRegionid());
				if (region != null)
					return region.getName();
			}

		} catch (TSDBException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

}
