/**
 * @jdk版本:1.5
 * @编码时间:2008-10-13
 * @模块名称:core
 */
package com.topsuntech.gUnit_gmgl.core.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author baiweiming
 * @version 0.1
 * @description date工具
 */
public class DateUtils {
	

	protected static final Log logger = LogFactory.getLog(DateUtils.class);

	public static final String yyyy_MM_dd = "yyyy-MM-dd";

	public static final String yyyyMMdd = "yyyyMMdd";

	public static final String HH_mm = "HH:mm";

	public static final String yyyy_MM_dd_E = "yyyy-MM-dd E";

	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

	private static SimpleDateFormat dateFormat;

	/**
	 * 把日期转换成字符串,默认格式yyyyMMdd
	 * 
	 * @param date
	 * @param pattern
	 *            如果参数为 null,使用CUSTOMER_STYLE
	 * @return
	 */
	public static String dateToStr(Date date, String pattern) {
		dateFormat = new SimpleDateFormat(yyyy_MM_dd);
		try {
			if (pattern != null) {
				dateFormat.applyPattern(pattern);
			}
			return dateFormat.format(date);
		} catch (Exception ex) {
			logger.debug("["+pattern+"]转换错误", ex);
			return "";
		}
	}

	/**
	 * 把字符转成日期型
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDate(String str, String pattern) {
		dateFormat = new SimpleDateFormat(yyyy_MM_dd);
		try {
			if (pattern != null) {
				dateFormat.applyPattern(pattern);
			}
			return dateFormat.parse(str);
		} catch (Exception ex) {
			logger.debug("["+pattern+"]转换错误", ex);
			return null;
		}
	}

	/**
	 * 获取上个月最后一天
	 * 
	 * @return
	 */
	public static Date getLastMonthLastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, max);

		return calendar.getTime();
	}

	/**
	 * 获取当前周的周一日期
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized Calendar getMonday(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}

		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		// 设置星期一为每星期第一天
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return calendar;
	}

	/**
	 * 获取指定时间段内的星期一的日期，（不包含开始日期当前周的周一，包含结束日期当前周的周一]
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized List<Calendar> getMondays(Date startDate) {
		Calendar startCalendar = getMonday(startDate);
		Calendar endCalendar = getMonday(null);
		List<Calendar> calendars = new ArrayList<Calendar>();
		while (startCalendar.compareTo(endCalendar) != 0) {
			startCalendar.add(Calendar.WEEK_OF_MONTH, 1);
			calendars.add((Calendar) startCalendar.clone());
		}
		return calendars;
	}

	/**
	 * 把字符串转成Calendar
	 * 
	 * @param str
	 * @return
	 */
	public static synchronized Calendar strToCalendar(String str) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtils.strToDate(str,null));
		return calendar;
	}

	/**
	 * 添加时分秒
	 * 
	 * @param calendar
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static synchronized Calendar addHms(Calendar calendar, int hour, int minute, int second) {
		calendar.add(Calendar.HOUR, hour);
		calendar.add(Calendar.MINUTE, minute);
		calendar.add(Calendar.SECOND, second);
		return calendar;
	}

	/**
	 * 把字符串转换成int数组
	 * 
	 * @param str
	 * @return
	 */
	public static synchronized int[] splitStringToIntArray(String str, char regex) {
		String[] strs = str.split("" + regex);
		int[] ints = new int[strs.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.parseInt(strs[i]);
		}
		return ints;
	}
}
