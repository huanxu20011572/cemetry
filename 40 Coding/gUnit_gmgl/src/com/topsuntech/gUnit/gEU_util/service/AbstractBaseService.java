package com.topsuntech.gUnit.gEU_util.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.topsuntech.gOS.user.en.user.User;

public abstract class AbstractBaseService {

	/**
	 * yes与数据字典对应
	 */
	public static final Long FLAG_YES = new Long(1);

	/**
	 * no与数据字典对应
	 */
	public static final Long FLAG_NO = new Long(0);

	/**
	 * 保存创建信息
	 * 
	 * @param object
	 * @param user
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void setCreateInfo(Object object, User user) {
		if (user == null)
			return;
		try {
			Method setCreateUserId = object.getClass().getMethod(
					"setCreateUserId", new Class[] { Long.class });
			Method setCreateDate = object.getClass().getMethod("setCreateDate",
					new Class[] { Date.class });
			setCreateUserId.invoke(object, new Object[] { user.getId() });
			setCreateDate.invoke(object, new Object[] { new Date() });
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}

	}

}
