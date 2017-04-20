package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.sql.SQLException;
import java.util.Map;
import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */

public class BzhhNodeValueTag extends KeyValueTag {

	/**
	 * 数据字典：通过'ID'获取相应的'VALUE'
	 * 
	 * @param param1
	 *            'ID'
	 * @param param2
	 */
	public Object getValue(Object param1, Map param2) {
		String ctValue = "";
		if (param1 == null) {
			return null;
		}

		return Dicts.getDictionaryValue(Long.parseLong(param1.toString()));
	}

}
