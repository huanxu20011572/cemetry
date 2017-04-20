/**
 * @jdk版本:1.5
 * @编码时间:2008-11-7
 */
package com.topsuntech.gUnit_gmgl.core.tree;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;

/**
 * @author baiweiming
 * @version 0.1
 * @description:无级树,节点递归包含
 */
@SuppressWarnings("rawtypes")
public abstract class TreeNode<T extends TreeNode> implements Tree<T> {

	private static final long serialVersionUID = -2516884728661071080L;

	protected static final Log logger = LogFactory.getLog(TreeNode.class);
	
	// 父节点
	protected T parent;

	// 子节点集合
	protected List<T> children;
	

	abstract public Long getId();

	abstract public void setId(Long id);

	@SuppressWarnings("unchecked")
	public boolean isDeadLock(T parent) {
		return isDeadLock(this, parent);
	}

	/*
	 * 是否为叶子节点
	 * 
	 * @see com.bwm.core.tree.Tree#isLeaf()
	 */
	public boolean isLeaf() {
		return CollectionUtils.isEmpty(children);
	}

	/*
	 * 是否是父节点
	 * 
	 * @see com.bwm.core.tree.Tree#isRoot()
	 */
	public boolean isRoot() {
		return getParent() == null;
	}

	/**
	 * @return the children
	 */
	abstract public List<T> getChildren();

	/**
	 * @param children
	 *            the children to set
	 */
	abstract public void setChildren(List<T> children);

	/**
	 * @return the parent
	 */
	abstract public T getParent();

	/**
	 * @param parent
	 *            the parent to set
	 */
	abstract public void setParent(T parent);

	/**
	 * 节点之间是否造成环形死锁 不允许将外键关系设置成环状. <br>
	 * 就是说，节点A下有一个子节点B,节点不能是A的父节点.
	 * 
	 * @param <T>
	 * @param current
	 * @param parent
	 * @return boolean: 是否造成环形死锁
	 */
	@SuppressWarnings({ "unchecked", "hiding"})
	private <T extends Tree> boolean isDeadLock(Tree<T> current, Tree<T> parent) {
		if ((current == null) || (parent == null) || current.equals(parent)) {
			return true;
		} else {
			for (T child : current.getChildren()) {
				boolean isDeadLock = isDeadLock(child, parent);

				if (isDeadLock) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 显示节点打开或关闭的样式
	 * @return
	 */
	
	abstract public String getState();

	/**
	 * 获取节点显示的内容
	 * @return
	 */
	abstract public String getText();

}
