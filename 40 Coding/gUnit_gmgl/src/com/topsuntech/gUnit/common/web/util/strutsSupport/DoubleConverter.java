package com.topsuntech.gUnit.common.web.util.strutsSupport;

import org.apache.commons.beanutils.Converter;

public class DoubleConverter implements Converter {

	public Object convert(Class type, Object value) {
		// for a null value, return null
		if (value instanceof java.lang.String) {
			if (value != null && value.toString().length() > 0) {
				return new Double((String) value);
			} else {
				return null;
			}
		} else if (value instanceof java.lang.Double) {
			return value;
		} else {
			return null;
		}
	}
}
