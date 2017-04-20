package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */

public class BzhhDictValueTag extends KeyValueTag {
	private String typeName;

	private String resourceFlag;

	public void setResourceFlag(String resourceFlag) {
		this.resourceFlag = resourceFlag;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Object getValue(Object param1, Map param2) {

		String ctValue = "";
		if (param1 == null) {
			return null;
		}

		try {
			if (resourceFlag == null)
				ctValue = Dicts.getDictionaryCode(param1.toString(), typeName);
			else
				ctValue = Dicts.getDictByCode(param1.toString(), typeName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ctValue;

	}

}
