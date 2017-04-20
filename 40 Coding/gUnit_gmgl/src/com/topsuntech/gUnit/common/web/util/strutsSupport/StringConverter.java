package com.topsuntech.gUnit.common.web.util.strutsSupport;
import org.apache.commons.beanutils.Converter;

public final class StringConverter implements Converter {

	public StringConverter() {
	}

	public Object convert(Class type, Object value) {
		if (value == null || "".equals(value.toString())) {
			return null;
		} else {
				//��� ajax ��������
				//return java.net.URLDecoder.decode(value.toString(), "utf-8");
				return value.toString();			
		}
	}
}

