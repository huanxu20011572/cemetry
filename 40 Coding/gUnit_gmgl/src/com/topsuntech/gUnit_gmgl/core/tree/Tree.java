/**
 * @jdk版本:1.5
 * @编码时间:2008-11-6
 */
package com.topsuntech.gUnit_gmgl.core.tree;

import java.io.Serializable;
import java.util.List;

/**
 * @author baiweiming
 * @version 0.1
 * @description 树
 */
public interface Tree<T> extends Serializable {

	/**
	 * 是否为根节点
	 * 
	 * @return
	 */
	boolean isRoot();

	/**
	 * 是否为叶子节点
	 * 
	 * @return
	 */
	boolean isLeaf();

	/**
	 * @return 父节点
	 */
	T getParent();

	/**
	 * @param parent
	 *            : 父节点
	 */
	void setParent(T parent);

	/**
	 * @return 子节点集合
	 */
	List<T> getChildren();

	/**
	 * 
	 * @param children
	 *            : 子节点集合
	 */
	void setChildren(List<T> children);

	/**
	 * 节点之间是否造成环形死锁 不允许将外键关系设置成环状. <br>
	 * 
	 * @param parent
	 *            : 父节点
	 * @return boolean: 是否造成环形死锁
	 */
	boolean isDeadLock(T parent);

}
