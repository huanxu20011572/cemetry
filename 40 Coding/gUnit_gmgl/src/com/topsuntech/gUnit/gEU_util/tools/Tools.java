/* ====================================================================
 * 
 * <http://www.topsuntech.org/>.
 */
package com.topsuntech.gUnit.gEU_util.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.CopyUtils;

/**
 * ���õĹ�����
 * 
 * <p>
 * <a href="Tools.java.html">View Source</a>
 * </p>
 * 
 * @see com.topsuntech.gUnit.gEU_util.tools.Tools
 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
 * @since 1.0
 * @version $Id: Tools.java,v 1.2 2009/11/18 06:18:48 yaojianwei Exp $Revision:
 *          1.2 $
 * 
 */
public class Tools {

	public static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	public static final String NUMBER_PATTERN = "0.00";

	/**
	 * ���ֶ�Ӧ�ĺ���
	 */
	private static final String[] chinese = { "��", "һ", "��", "��", "��", "��",
			"��", "��", "��", "��", "ʮ", "ʮһ", "ʮ��", "ʮ��", "ʮ��", "ʮ��", "ʮ��", "ʮ��",
			"ʮ��", "ʮ��", "��ʮ", "��ʮһ", "��ʮ��", "��ʮ��", "��ʮ��", "��ʮ��", "��ʮ��", "��ʮ��",
			"��ʮ��", "��ʮ��", "��ʮ", "��ʮһ" };

	/**
	 * ����ת��ģʽ
	 */
	public static final int WHOLE = 1;

	/**
	 * ����ת��ģʽ
	 */
	public static final int SEPARATE = 2;

	/**
	 * �õ�ϵͳʱ���String����
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getSysteDateStr(String pattern) {
		return getDateStr(null, pattern);
	}

	/**
	 * ��DATE����ת��String����,patternĬ��Ϊyyyy-MM-dd
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateStr(Date date, String pattern) {
		if (date == null)
			date = new Date();
		if (pattern == null)
			pattern = DEFAULT_PATTERN;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(date);
	}

	public static Date getDateByStr(String dateStr, String pattern)
			throws ParseException {
		if (dateStr == null || dateStr.equals(""))
			return new Date();
		if (pattern == null)
			pattern = DEFAULT_PATTERN;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.parse(dateStr);
	}

	/**
	 * ���ַ���ת�����������ͣ�����ַ���Ϊ�ջ��߲������ڸ�ʽ���򷵻�NULL
	 * 
	 * @param dateStr
	 *            �����ַ���
	 * @param pattern
	 *            ���ڸ�ʽ
	 * @return Date
	 * @throws ParseException
	 */
	//	
	public static Date str2Date(String dateStr, String pattern)
			throws ParseException {
		Date date = null;
		if (isEmpty(dateStr))
			return date;
		try {
			// patternΪ�գ���Ϊһ������
			if (isEmpty(pattern))
				pattern = DEFAULT_PATTERN;
			// SimpleDateFormat ������Ϊ����-ʱ���ʽ��ѡ���κ��û�ָ���ķ�ʽ�����ľ�����
			SimpleDateFormat formater = new SimpleDateFormat(pattern);
			date = formater.parse(dateStr);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + dateStr + "�����ַ���ת��Date��ʧ�ܣ�");
		}
		return date;
	}

	/**
	 * �����������ж϶����Ƿ�Ϊ�ջ�մ������Ϊ���򷵻ء�true������Ϊ�շ��ء�false��<br>
	 * 
	 * @param object
	 *            Ҫ�жϵĶ���
	 * @return boolean
	 */
	public static boolean isEmpty(String object) {
		// ���Ϊ�ջ���ַ���
		if (object == null || object.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * �����������ж϶����Ƿ�Ϊ�ջ�մ������Ϊ���򷵻ء�true������Ϊ�շ��ء�false��<br>
	 * 
	 * @param object
	 *            Ҫ�жϵĶ���
	 * @return boolean
	 */
	public static boolean isEmpty(Number object) {
		// ���Ϊ�ջ���ַ���
		if (object == null || object.toString().length() == 0)
			return true;
		return false;
	}

	/**
	 * �ж϶����Ƿ�Ϊ�ջ�0�����Ϊ���򷵻ء�true������Ϊ�շ��ء�false��<br>
	 * 
	 * @param object
	 *            Ҫ�жϵĶ���
	 * @return boolean
	 */
	public static boolean isEmptyId(Number object) {
		if (object == null || object.longValue() <= 0)
			return true;
		return false;
	}

	/**
	 * �����������ж϶����Ƿ�Ϊ�ջ�մ������Ϊ���򷵻ء�true������Ϊ�շ��ء�false��<br>
	 * 
	 * @param object
	 *            Ҫ�жϵĶ���
	 * @return boolean
	 */
	public static boolean isEmpty(Collection object) {
		// ���ΪNULL������СΪ0
		if (object == null || object.size() == 0)
			return true;
		return false;
	}

	/**
	 * ȡ�÷ָ���ֵ
	 * 
	 * @param string
	 *            ֵ
	 * @param flag
	 *            ���
	 * @return String[] ֵ����
	 */
	public static String[] stringToKenizer(String string, String flag) {
		StringTokenizer token = new StringTokenizer(string, flag);
		int len = token.countTokens();
		String[] result = new String[len];
		for (int k = 0; k < len; k++) {
			result[k] = token.nextToken();
		}
		return result;
	}

	/**
	 * �жϵ�ǰ�����У��Ƿ����ĳ����ֵ
	 * 
	 * @param array
	 *            ����
	 * @param value
	 *            ����ֵ
	 * @return boolean ����ΪTRUE������ΪFALSE
	 */
	public static boolean judgeExist(String[] array, String value) {
		boolean bExist = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				bExist = true;
				break;
			}
		}
		return bExist;
	}

	/**
	 * �õ�ָ�������������,���ʱ��Ϊ��,�򷵻ص�ǰϵͳʱ���ָ������������
	 * 
	 * @param ori
	 * @param dayNum
	 * @return
	 */
	public static Date addDays(Date ori, Long dayNum) {
		ori = ori == null ? new Date() : ori;
		return new Date(ori.getTime() + TIME_OF_ONE_DAY * (dayNum.longValue()));
	}

	public static Date aa(Date ori, int monthNum) {
		Long dayNum = new Long(0);
		while (monthNum != 0) {
			if (ori.getMonth() == 2) {
				if (ori.getYear() % 4 == 0 || ori.getYear() % 400 == 0) {//����
					dayNum+=29;
				}else{
					dayNum+=28;
				}
			} else if (ori.getMonth() == 1 || ori.getMonth() == 3
					 || ori.getMonth() == 5
					|| ori.getMonth() == 7 || ori.getMonth() == 8
					|| ori.getMonth() == 10 || ori.getMonth() == 12) {
				dayNum+=31;
			} else {
				dayNum+=30;
			}
			--monthNum;
		}
		return subDays(ori, dayNum);
	}

	public static Date subDays(Date ori, Long dayNum) {
		ori = ori == null ? new Date() : ori;
		return new Date(ori.getTime() - TIME_OF_ONE_DAY * (dayNum.longValue()));
	}

	public static long getDaysBetweenTwoDate(Date start, Date end) {
		return ((end.getTime() - start.getTime()) / TIME_OF_ONE_DAY);
	}

	/**
	 * һ��ĺ�����
	 */
	public static long TIME_OF_ONE_DAY = 24 * 60 * 60 * 1000;

	/**
	 * ȡ��һ��ȫ��������ɵ�����ַ���
	 * 
	 * @return String
	 */
	public static String getRandomStrNum() {
		String now = getSysteDateStr("yyyyMMddHHmmss");
		int random = (int) (Math.random() * 1000);
		return now + random;
	}

	/**
	 * ���ļ����浽Ӳ����<br>
	 * ���ָ��·�������ڣ�����Զ�����·��<br>
	 * ����ļ����ڣ���Ḳ��ԭ�����ļ�<br>
	 * 
	 * @param input
	 *            InputStream
	 * @param path
	 *            ����·��
	 * @param fileName
	 *            �ļ�����
	 * @throws IOException
	 */
	public static void saveFileToDisk(InputStream input, String path,
			String fileName) throws IOException {
		File file = new File(path);
		if (!file.isDirectory())
			file.mkdirs();
		OutputStream output = new FileOutputStream(path + fileName);
		CopyUtils.copy(input, output);
		output.close();
		input.close();
	}

	/**
	 * ���ַ���ת��Long
	 * 
	 * @param val
	 * @return Long
	 */
	public static Long str2Long(String val) {
		Long value = null;
		try {
			value = Long.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "�����ַ���ת��Long��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * ���ַ���ת��Double
	 * 
	 * @param val
	 * @return Double
	 */
	public static Double str2Double(String val) {
		Double value = null;
		try {
			value = Double.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "�����ַ���ת��Long��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * �Ѷ���ת��String
	 * 
	 * @param val
	 * @return String
	 */
	public static String obj2Str(Object val) {
		String value = null;
		try {
			value = val.toString();
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "���Ӷ���ת��String��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * ���ַ���ת��Integer
	 * 
	 * @param val
	 * @return Integer
	 */
	public static Integer str2Integer(String val) {
		Integer value = null;
		try {
			value = Integer.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "�����ַ���ת��Integer��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * ���ַ���ת��Short
	 * 
	 * @param val
	 * @return Short
	 */
	public static Short str2Short(String val) {
		Short value = null;
		try {
			value = Short.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "�����ַ���ת��Long��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * ���ַ���ת��Float
	 * 
	 * @param val
	 * @return Float
	 */
	public static Float str2Float(String val) {
		Float value = null;
		try {
			value = Float.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "�����ַ���ת��Long��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * ���ַ���ת��Byte
	 * 
	 * @param val
	 * @return Byte
	 */
	public static Byte str2Byte(String val) {
		Byte value = null;
		try {
			value = Byte.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("�ѡ�" + val + "�����ַ���ת��Long��ʧ�ܣ�");
		}
		return value;
	}

	/**
	 * ��Double������������
	 * 
	 * @param value
	 * @param num
	 *            ������λС��
	 * @return
	 */
	public static Double rounding(Double value, int num) {
		double temp = Math.pow(10, num);
		if (value != null) {
			return new Double((Math.round(temp * value.doubleValue())) / temp);
		}
		return null;
	}

	public static double discard(double value, int num) {
		String r = Double.toString(value);
		int p = -1;
		if ((p = r.indexOf(".")) != -1 && r.length() > p + num + 1) {
			r = r.substring(0, p + num + 1);
		}
		return Double.parseDouble(r);
	}

	public static void main(String[] args) {
	}

	/**
	 * ȡ���
	 * 
	 * @param date
	 * @return int
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * ȡ�·�
	 * 
	 * @param date
	 * @return int
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * ȡ��
	 * 
	 * @param date
	 * @return int
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��ʽ����ֵ
	 * 
	 * @param number
	 *            ��ֵ
	 * @param pattern
	 *            ��ʽ
	 * @return String
	 */
	public static String formatNumber(Number number, String pattern) {

		if (number == null)
			return null;

		// �жϸ�ʽ�Ƿ�Ϊ��
		if (isEmpty(pattern)) {
			pattern = NUMBER_PATTERN;
		}

		// ��ʽ������
		DecimalFormat formater = new DecimalFormat(pattern);
		return formater.format(number);
	}

	/**
	 * ��ʽ����ѯSQL�ֶ�ֵ
	 * 
	 * @param fieldValue
	 *            �ֶ�ֵ
	 * @return String ����ֵ
	 */
	public static String formatSQLValue(String fieldValue) {
		if (isEmpty(fieldValue))
			return fieldValue;
		return fieldValue.replaceAll("'", "''");
	}

	/**
	 * ����������ʽ�滻�ַ��� ����ַ�����������ʽΪ�գ������滻 ���Ҫ�滻�ɵ��ַ���ΪNULL����ת�ɿ��ַ���
	 * 
	 * @param string
	 *            �ַ���
	 * @param regEx
	 *            ������ʽ
	 * @param substr
	 *            Ҫ�滻�ɵ��ַ���
	 * @param caseFlg
	 *            �Ƿ����ִ�Сд
	 * @return String ���
	 */
	public static String replaceAllByExp(String string, String regEx,
			String substr, boolean caseFlg) {

		// ����ַ�����������ʽΪ�գ������滻
		if (Tools.isEmpty(string) || Tools.isEmpty(regEx)) {
			return string;
		}

		// ���Ҫ�滻�ɵ��ַ���ΪNULL����ת�ɿ��ַ���
		if (Tools.isEmpty(substr)) {
			substr = "";
		}

		Pattern pattern = null;
		if (caseFlg) {
			pattern = Pattern.compile(regEx);
		} else {
			// ���óɲ����ִ�Сд
			pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		}

		// �ñ��ʽ��ƥ���ַ���
		Matcher matcher = pattern.matcher(string);

		// ִ��ȫ���滻
		return matcher.replaceAll(substr);
	}

	/**
	 * �Ѱ���������ת������������
	 * 
	 * @param number
	 *            �����ַ���
	 * @param mode
	 *            ת��ģʽ
	 * @return String
	 */
	public static String number2Chinese(String number, int mode) {
		int index = Integer.parseInt(number);
		if (mode == WHOLE && index < chinese.length) {
			return chinese[index];
		} else if (mode == SEPARATE) {
			StringBuffer sbNum = new StringBuffer();
			for (int i = 0; i < number.length(); i++) {
				index = Integer.parseInt(String.valueOf(number.charAt(i)));
				sbNum.append(chinese[index]);
			}
			return sbNum.toString();
		}
		return null;
	}

	/**
	 * ת������Ϊ���ָ�ʽ����
	 * 
	 * @param yearFrom
	 *            ��ʼ���
	 * @param monthFrom
	 *            ��ʼ�·�
	 * @param yearTo
	 *            �������
	 * @param monthTo
	 *            �����·�
	 * @return String �����ַ���
	 */
	public static String toChineseDate(String yearFrom, String monthFrom,
			String yearTo, String monthTo) {

		int yearF = Integer.parseInt(yearFrom);
		int monthF = Integer.parseInt(monthFrom);
		int yearT = Integer.parseInt(yearTo);
		int monthT = Integer.parseInt(monthTo);
		StringBuffer sbDate = new StringBuffer();

		if (yearF == yearT) {
			sbDate.append(number2Chinese(yearFrom, SEPARATE)).append("��");
			if (monthF == 1 && monthT == 3) {
				sbDate.append("��һ����");
			} else if (monthF == 4 && monthT == 6) {
				sbDate.append("�ڶ�����");
			} else if (monthF == 7 && monthT == 9) {
				sbDate.append("��������");
			} else if (monthF == 10 && monthT == 12) {
				sbDate.append("���ļ���");
			} else if (monthF == 1 && monthT == 6) {
				sbDate.append("�ϰ���");
			} else if (monthF == 7 && monthT == 12) {
				sbDate.append("�°���");
			} else if (monthF == 1 && monthT == 12) {
				sbDate.append("��");
			} else if (monthF == monthT) {
				sbDate.append(number2Chinese(monthFrom, WHOLE)).append("��");
			} else {
				sbDate.append(number2Chinese(monthFrom, WHOLE)).append("����");
				sbDate.append(number2Chinese(monthTo, WHOLE)).append("��");
			}
		} else {
			sbDate.append(number2Chinese(yearFrom, SEPARATE)).append("��");
			sbDate.append(number2Chinese(monthFrom, WHOLE)).append("����");
			sbDate.append(number2Chinese(yearTo, SEPARATE)).append("��");
			sbDate.append(number2Chinese(monthTo, WHOLE)).append("��");
		}
		return sbDate.toString();
	}

	public static Double subDouble(Double d, int index) {
		if (d != null) {
			String tmp = d.toString();
			int pointIndex = tmp.indexOf(".");
			if (tmp.substring(pointIndex).length() > index) {
				return new Double(tmp.substring(0, pointIndex + index + 1));
			} else {
				return d;
			}
		}
		return null;
	}

	public static String formatDateComparer(String property) {
		return "to_char(" + property + ",'yyyy-MM-dd')";
	}

	/**
	 * ���ַ��������к���
	 * 
	 * @param strs
	 *            �ַ���
	 * @param character
	 *            ����: ',' ��'|'��
	 * @return ȥ��ǰ��ķ���
	 */
	public static String afterString(String strs, String character) {
		if (strs.substring(0, 1).equals(character))
			strs = strs.substring(1, strs.length());
		if (strs.substring(strs.length() - 1, strs.length()).equals(character))
			strs = strs.substring(0, strs.length() - 1);

		return strs;
	}

	/**
	 * �ӽ��������VO
	 * 
	 * @param rs
	 * @param visualObject
	 * @throws SQLException
	 * @throws SQLException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static void buildVisualObjectFromResultSet(ResultSet rs,
			Object visualObject) throws SQLException, SQLException,
			InvocationTargetException, IllegalAccessException {
		ResultSetMetaData metaData = rs.getMetaData();
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			buildVisualObject(visualObject, rs, metaData.getColumnName(i),
					metaData.getColumnTypeName(i));
		}
	}

	/**
	 * ����ʵ������
	 * 
	 * @param visualObject
	 * @param rs
	 * @param columnName
	 * @param columnTypeName
	 * @throws SQLException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private static void buildVisualObject(Object visualObject, ResultSet rs,
			String columnName, String columnTypeName) throws SQLException,
			InvocationTargetException, IllegalAccessException {
		if (visualObject == null)
			return;
		if (columnName == null || "".equals(columnName.trim()))
			return;

		// ����reflect��ʼ����vo
		setProperty(visualObject, rs, columnName, columnTypeName);
	}

	/**
	 * ��������
	 * 
	 * @param visualObject
	 * @param rs
	 * @param columnName
	 * @param columnTypeName
	 * @throws SQLException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private static void setProperty(Object visualObject, ResultSet rs,
			String columnName, String columnTypeName) throws SQLException,
			InvocationTargetException, IllegalAccessException {
		Class<?> cls = visualObject.getClass();
		String setPropertyNameMethod = setPropertyNameMethod(columnName);
		Method method = getMethodByName(cls, setPropertyNameMethod);
		// ���vo�к���set�����������ִ��
		if (method != null) {
			// ��ȡ����������
			String parameterType = method.getParameterTypes()[0]
					.getSimpleName();

			// ������
			if ("NUMBER".equalsIgnoreCase(columnTypeName)) {
				if ("Long".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Long(rs
								.getLong(columnName)) });
				}

				if ("Short".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Short(rs
								.getShort(columnName)) });
				}

				if ("Double".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Double(
								rs.getDouble(columnName)) });
				}

				if ("Float".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Double(
								rs.getFloat(columnName)) });
				}

				if ("Byte".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Byte(rs
								.getByte(columnName)) });
				}

				if ("Boolean".equals(parameterType)) {
					if (rs.getObject(columnName) != null) {
						if (new Integer(rs.getInt(columnName)).intValue() > 0)
							method.invoke(visualObject,
									new Object[] { new Boolean(true) });
						else
							method.invoke(visualObject,
									new Object[] { new Boolean(false) });
					}
				}
			}

			// �ַ���
			if ("VARCHAR2".equalsIgnoreCase(columnTypeName)) {
				if ("String".equals(parameterType)) {
					if (rs.getString(columnName) != null)
						method.invoke(visualObject, new Object[] { rs
								.getString(columnName) });
				}

				if ("Boolean".equals(parameterType)) {
					if (rs.getString(columnName) != null
							&& !"".equals(rs.getString(columnName).trim())) {
						if ("true".equalsIgnoreCase(rs.getString(columnName)))
							method.invoke(visualObject,
									new Object[] { new Boolean(true) });
						else if ("false".equalsIgnoreCase(rs
								.getString(columnName)))
							method.invoke(visualObject,
									new Object[] { new Boolean(false) });
					}
				}
			}

			// ������
			if ("DATE".equalsIgnoreCase(columnTypeName)) {
				if ("Date".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { rs
								.getDate(columnName) });
				}
			}
		}
	}

	/**
	 * �ж�vo���Ƿ��ж�Ӧ�ķ���
	 * 
	 * @param cls
	 * @param setPropertyNameMethod
	 * @return
	 */
	private static Method getMethodByName(Class<?> cls,
			String setPropertyNameMethod) {
		if (setPropertyNameMethod == null
				|| "".equals(setPropertyNameMethod.trim()))
			return null;
		Method[] methods = cls.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals(setPropertyNameMethod))
				return methods[i];
		}
		return null;
	}

	/**
	 * ��ȡset����
	 * 
	 * @param columnName
	 * @return
	 */
	private static String setPropertyNameMethod(String columnName) {
		if (columnName.indexOf("_") == -1) {
			return "set"
					+ getFirstLetter(columnName).toUpperCase()
					+ columnName.substring(1, columnName.length())
							.toLowerCase();
		}

		String[] columnNames = columnName.split("_");
		String property = "";
		for (int i = 0; i < columnNames.length; i++) {
			property += getFirstLetter(columnNames[i]).toUpperCase()
					+ columnNames[i].substring(1, columnNames[i].length())
							.toLowerCase();
		}
		return "set" + property;
	}

	/**
	 * ��ȡ��һ����ĸ
	 * 
	 * @param str
	 * @return
	 */
	private static String getFirstLetter(String str) {
		if (str == null || "".equals(str.trim()))
			return null;
		return str.substring(0, 1);
	}
}