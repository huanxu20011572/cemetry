package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.entity.Region;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

public class BzhhRegionValueTag extends KeyValueTag {

	public Object getValue(Object arg0, Map arg1) {
		if (arg0 == null || "".equals(arg0.toString())) {
			return null;
		}
		try {
			Region region = Dicts.getRegionById(new Long(arg0.toString()));
			if (region != null)
				return region.getName();
		} catch (TSDBException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

}
