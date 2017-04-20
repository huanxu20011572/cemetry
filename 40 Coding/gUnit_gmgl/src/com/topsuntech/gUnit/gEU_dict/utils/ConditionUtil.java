package com.topsuntech.gUnit.gEU_dict.utils;

import java.util.Vector;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.type.Type;

import com.topsuntech.gUnit.common.util.DateUtils;

/**
 * ��ѯ��������
 *
 * @author ZhangWei
 * @version 1.0
 */
public class ConditionUtil {
	/**
	�Ƚ�(��)�ȳ�,��(��)���
	**/
    private Vector vcParameters = new Vector();
    private Vector vcTypes = new Vector();

    public ConditionUtil() {
    }

    /**
     * �������
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
     * ��ȡ��������
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
     * ��ȡ���ͼ���
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
     * ���String��������
     *
     * @param s String
     */
    public void addString(String s) {
        addCondition(s, Hibernate.STRING);
    }

    /**
     * ���Integer��������
     *
     * @param s String
     */
    public void addInteger(String s) {
        addCondition(new Integer(s), Hibernate.INTEGER);
    }

    /**
     * ���Long��������
     *
     * @param s String
     */
    public void addLong(String s) {
        addCondition(new Long(s), Hibernate.LONG);
    }

    /**
     * ���Date��������
     *
     * @param s String
     */
    public void addDate(String s) {
        addCondition(DateUtils.parseDate(s), Hibernate.DATE);
    }

    /**
     * ���Timestamp��������
     *
     * @param s String
     */
    public void addTimestamp(String s) {
        addCondition(DateUtils.parseTimestamp(s), Hibernate.TIMESTAMP);
    }

    /**
     * ���Byte��������
     *
     * @param s String
     */
    public void addByte(String s) {
        addCondition(new Byte(s), Hibernate.BYTE);
    }

    /**
     * ���Double��������
     *
     * @param s String
     */
    public void addDouble(String s) {
        addCondition(new Double(s), Hibernate.DOUBLE);
    }

    /**
     * ���Float��������
     *
     * @param s String
     */
    public void addFloat(String s) {
        addCondition(new Float(s), Hibernate.FLOAT);
    }

}
