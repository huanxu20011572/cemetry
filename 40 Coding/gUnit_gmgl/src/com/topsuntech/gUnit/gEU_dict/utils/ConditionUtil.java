package com.topsuntech.gUnit.gEU_dict.utils;

import java.util.Vector;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.type.Type;

import com.topsuntech.gUnit.common.util.DateUtils;

/**
 * 查询条件生成
 *
 * @author ZhangWei
 * @version 1.0
 */
public class ConditionUtil {
	/**
	先进(存)先出,后(存)后出
	**/
    private Vector vcParameters = new Vector();
    private Vector vcTypes = new Vector();

    public ConditionUtil() {
    }

    /**
     * 添加条件
     *
     * @param para Object
     * @param type Type
     */
    public void addCondition(Object para, Type type) {
        if (para != null) {
            vcParameters.add(para);
            vcTypes.add(type);
        }
    }

    /**
     * 获取参数集合
     *
     * @return Object[]
     */
    public Object[] getParams() {
        int iCount = vcParameters.size();
        if (iCount == 0)
            return new Object[] {};
        Object[] object = new Object[iCount];
        for (int i = 0; i < iCount; i++) {
            object[i] = vcParameters.get(i);
        }
        return object;
    }

    /**
     * 获取类型集合
     *
     * @return Type[]
     */
    public Type[] getTypes() {
        int iCount = vcTypes.size();
        if (iCount == 0)
            return new Type[] {};
        Type[] types = new Type[iCount];
        for (int i = 0; i < iCount; i++) {
            types[i] = (Type) vcTypes.get(i);
        }
        return types;
    }

    /**
     * 添加String类型条件
     *
     * @param s String
     */
    public void addString(String s) {
        addCondition(s, Hibernate.STRING);
    }

    /**
     * 添加Integer类型条件
     *
     * @param s String
     */
    public void addInteger(String s) {
        addCondition(new Integer(s), Hibernate.INTEGER);
    }

    /**
     * 添加Long类型条件
     *
     * @param s String
     */
    public void addLong(String s) {
        addCondition(new Long(s), Hibernate.LONG);
    }

    /**
     * 添加Date类型条件
     *
     * @param s String
     */
    public void addDate(String s) {
        addCondition(DateUtils.parseDate(s), Hibernate.DATE);
    }

    /**
     * 添加Timestamp类型条件
     *
     * @param s String
     */
    public void addTimestamp(String s) {
        addCondition(DateUtils.parseTimestamp(s), Hibernate.TIMESTAMP);
    }

    /**
     * 添加Byte类型条件
     *
     * @param s String
     */
    public void addByte(String s) {
        addCondition(new Byte(s), Hibernate.BYTE);
    }

    /**
     * 添加Double类型条件
     *
     * @param s String
     */
    public void addDouble(String s) {
        addCondition(new Double(s), Hibernate.DOUBLE);
    }

    /**
     * 添加Float类型条件
     *
     * @param s String
     */
    public void addFloat(String s) {
        addCondition(new Float(s), Hibernate.FLOAT);
    }

}
