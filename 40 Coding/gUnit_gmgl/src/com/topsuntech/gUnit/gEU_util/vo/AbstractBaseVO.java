package com.topsuntech.gUnit.gEU_util.vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.topsuntech.gUnit.gEU_util.dao.QueryUtil;

public abstract class AbstractBaseVO {

	private static final int SIGN_EQUAL = 0;

	private static final int SIGN_MORE = 1;

	private static final int SIGN_LESS = 2;

	private static final int SIGN_LIKE = 3;

	public String getEqualPropertyHql(String property, String objectAlies) {
		return getHql(property, objectAlies, SIGN_EQUAL);
	}

	public String getMoreThanPropertyHql(String property, String objectAlies) {
		return getHql(property, objectAlies, SIGN_MORE);
	}

	public String getLessThanPropertyHql(String property, String objectAlies) {
		return getHql(property, objectAlies, SIGN_LESS);
	}

	public String getLikePropertyHql(String property, String objectAlies) {
		return getHql(property, objectAlies, SIGN_LIKE);
	}

	private String getHql(String property, String objectAlies, int sign) {
		Object value = getMethodValue(getMethodByProperty(property, null));
		if (value != null) {
			StringBuffer str = new StringBuffer(" and ");
			if (objectAlies != null && !objectAlies.equals(""))
				str.append(objectAlies).append(".").append(property);
			else
				str.append(property);
			switch (sign) {
			case SIGN_EQUAL:
				str.append(getEqualHql(value));
				break;
			case SIGN_MORE:
				str.append(getMoreThan(value));
				break;
			case SIGN_LESS:
				str.append(getLessThan(value));
				break;
			case SIGN_LIKE:
				str.append(getLikeHql(value));
				break;
			}

			return str.toString();
		}
		return null;
	}

	private String getEqualHql(Object value) {
		return "=" + getHqlValue(value);
	}

	private String getMoreThan(Object value) {
		return ">" + getHqlValue(value);
	}

	private String getLessThan(Object value) {
		return "<" + getHqlValue(value);
	}

	private String getLikeHql(Object value) {
		if (value instanceof String)
			return " like " + getHqlValue(value);
		return null;
	}

	private Object getHqlValue(Object value) {
		if (value instanceof Integer || value instanceof Long
				|| value instanceof Double)
			return value;
		if (value instanceof String)
			return "'" + value + "'";
		if (value instanceof Date)
			return QueryUtil.getDateHql((Date) value);
		return null;
	}

	private Method getMethodByProperty(String property, Class[] params) {
		try {
			return getClass().getMethod(
					getMethodStrByProperty(property, "get"), params);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object getMethodValue(Method method) {
		try {
			return method.invoke(this, null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getMethodStrByProperty(String property, String method) {
		if (property != null && !property.equals(""))
			return method + upCaseFirstCharacter(property);
		return null;
	}

	private static String upCaseFirstCharacter(String property) {
		return property.substring(0, 1).toUpperCase()
				+ property.substring(1, property.length());
	}
}
