package com.topsuntech.gUnit.common.web.util.strutsSupport;

import org.apache.commons.beanutils.Converter;

public class LongConverter implements Converter {

	public Object convert(Class type, Object value) {
		// for a null value, return null
		if (value instanceof java.lang.String) {
			if (value != null && value.toString().length() > 0) {
				return new Long((String) value);
			} else {
				return null;
			}
		} else if (value instanceof java.lang.Long) {
			return value;
		} else {
			return null;
		}
	}
}
