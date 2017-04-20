/**
 * @jdk版本:1.6
 * @编码时间:2012-2-20
 */
package com.topsuntech.gUnit_gmgl.core;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author baiweiming
 * @version 1.1
 * @description
 */
public abstract class BaseBean implements Serializable {


	private static final long serialVersionUID = 8754246550166986404L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
