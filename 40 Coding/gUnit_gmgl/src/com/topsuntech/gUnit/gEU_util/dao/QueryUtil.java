package com.topsuntech.gUnit.gEU_util.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class QueryUtil {

	private static final String defaultDic = "src/com/topsuntech/gUnit/gEU_util/dao/";

	private static final String defaultPropertiesFile = "";

	private static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

	private static Map propertiesMap = new HashMap();

	private Properties properties;

	public QueryUtil() throws IOException {
		this(null);
	}

	public QueryUtil(String config) {
		if (config == null)
			config = defaultPropertiesFile;

		if (propertiesMap.get(config) != null) {
			properties = (Properties) propertiesMap.get(config);
		} else {
			properties = new Properties();
			try {
				FileInputStream in = new FileInputStream(defaultDic + config);
				properties.load(in);
				propertiesMap.put(config, properties);
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		QueryUtil util = new QueryUtil("properties/SqMemberWorksDAO.properties");
		System.out.println(util.getProperty("countBySalvageInfoId"));
	}

	public static String getDateHql(Date date) {
		// return "to_date('" + formater.format(date) + "','yyyy-MM-dd')";
		return "'"+formater.format(date)+"'";
	}

	public static String getDateHql(String dateStr) {
		// return "to_date('" + dateStr + "','yyyy-MM-dd')";
		return "'"+dateStr+"'";
	}

	public static String formatDateComparer(String property) {
		return "to_char(" + property + ",'yyyy-MM-dd')";
	}

	/**
	 * 取得日期类型中，只到月份
	 * 
	 * @param field
	 * @return
	 */
	public static String getCharMonth(String field) {
		return "substr(to_char(" + field + ",'yyyy-mm-dd'),1,7)";
	}

}
