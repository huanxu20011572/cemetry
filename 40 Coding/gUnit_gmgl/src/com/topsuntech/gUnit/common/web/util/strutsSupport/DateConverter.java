package com.topsuntech.gUnit.common.web.util.strutsSupport;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;

import com.topsuntech.gUnit.common.web.util.DateUtil;

/**
 * 简易DateConverter. 供Apache BeanUtils 做转换,默认时间格式为yyyy-MM-dd,可由DateUtil改变.
 * 
 * @author 刘树华
 * @see
 */
public class DateConverter implements Converter {

	private SimpleDateFormat format = new SimpleDateFormat(DateUtil.getDatePattern());

	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (type == Timestamp.class) {
			return convertToDate(type, value, DateUtil.getDateTimePattern());
		} else if (type == Date.class) {
			return convertToDate(type, value, DateUtil.getDatePattern());
		} else if (type == String.class) {
			return convertToString(type, value);
		}

		throw new ConversionException("Could not convert " + value.getClass().getName() + " to " + type.getName());
	}

	protected Object convertToDate(Class type, Object value, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		if (value instanceof String) {
			try {
				if (StringUtils.isEmpty(value.toString())) {
					return null;
				}

				Date date = df.parse((String) value);
				if (type.equals(Timestamp.class)) {
					return new Timestamp(date.getTime());
				}
				return date;
			} catch (Exception pe) {
				pe.printStackTrace();
				throw new ConversionException("Error converting String to Date");
			}
		}

		throw new ConversionException("Could not convert " + value.getClass().getName() + " to " + type.getName());
	}

	protected Object convertToString(Class type, Object value) {

		if (value instanceof Date) {
			DateFormat df = new SimpleDateFormat(DateUtil.getDatePattern());
			if (value instanceof Timestamp) {
				df = new SimpleDateFormat(DateUtil.getDateTimePattern());
			}

			try {
				return df.format(value);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ConversionException("Error converting Date to String");
			}
		} else {
			// 默认时间格式为yyyy-MM-dd,可由构造函数改变
			String dateStr = (String) value;
			if (StringUtils.isNotBlank(dateStr)) {
				return format.format(dateStr);
			}
			return value.toString();
		}
	}
}
