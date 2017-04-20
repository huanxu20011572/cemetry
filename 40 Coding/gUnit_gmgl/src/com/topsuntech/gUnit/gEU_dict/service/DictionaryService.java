package com.topsuntech.gUnit.gEU_dict.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.type.Type;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_dict.en.MetaData;
import com.topsuntech.gUnit.gEU_dict.utils.ResultRef;

/**
 * 节点管理Service
 * 
 * @author ZhangWei
 * @version 1.0
 */
public class DictionaryService extends DictionaryManager {
	private final static int OPER_SUCCESS = ResultRef.OPER_SUCCESS;

	private final static int OPER_FAILD = ResultRef.OPER_FAILD;

	private final static int OPER_HASRECORD = ResultRef.OPER_HASRECORD;

	// public DictionaryService() {}

	/**
	 * 添加节点
	 * 
	 * @param bean
	 *            Node
	 * @return int :0 成功;1 操作失败;2 含有同名节点，操作失败
	 */
	public int addNode(MetaData bean) {
		long parentID = 0;
		String nodeName = bean.getNode_name();
		if (bean.getParentid() != null)
			parentID = bean.getParentid().longValue();
		else
			bean.setParentid(new Long(0));

		if (bean.getNode_name() == null)
			return OPER_FAILD;

		// 当含有同名节点时返回错误
		if (getNodeByName(parentID, nodeName) != null) {
			System.out.println("----已有相同的名字:" + nodeName);
			return OPER_HASRECORD;
		}

		if (getNodeByValue(0, parentID, bean.getNode_value()) != null) {
			System.out.println("----已有相同的code:" + bean.getNode_value());
			return OPER_HASRECORD;
		}

		// 如果为根节点，设置节点名称为总类别名称
		if (parentID == 0 && bean.getNode_typename() == null) {
			System.out.println("-----插入根节点");
			bean.setNode_typename(bean.getNode_value());
			bean.setNode_level(new Integer(0));

			try {
				beginTrans();
				insertBean(bean);
				// 更新节点value
				// bean.setNode_value(String.valueOf(bean.getId().longValue()));
				// updateBean(bean);
				commit();
				return OPER_SUCCESS;
			} catch (Exception ex) {
				rollback();
				return OPER_FAILD;
			} finally {
				endTrans();
			}
		} else { // 插入子节点时
			System.out.println("-----插入子节点");
			try {
				MetaData parentBean = (MetaData) getBean(MetaData.class,
						parentID);
				// 设置节点层数
				bean.setNode_level(new Integer(parentBean.getNode_level()
						.intValue() + 1));
				// 设置所属类别名称
				bean.setNode_typename(parentBean.getNode_value());
				parentBean.addDetail(bean);
				beginTrans();
				updateBean(parentBean);
				// 更新节点value
				// bean.setNode_value(String.valueOf(bean.getId().longValue()));
				// updateBean(bean);
				commit();
				return OPER_SUCCESS;
			} catch (Exception ex) {
				rollback();
				return OPER_FAILD;
			} finally {
				endTrans();
			}
		}
	}

	/**
	 * 上移节点
	 * 
	 * @param parentID
	 *            long
	 * @param index
	 *            long
	 */
	public void moveUpNode(long parentID, long index) {
		if (parentID != 0) {
			// 当不为第一个节点时，上移节点
			if (index != 0) {
				try {
					beginTrans();
					long pre_index = index - 1;
					MetaData bean = getNodeByIndex(parentID, index);
					MetaData pre_bean = getNodeByIndex(parentID, pre_index);
					// 交换index
					bean.setNode_index(new Long(pre_index));
					pre_bean.setNode_index(new Long(index));
					// 更新节点信息
					updateBean(bean);
					updateBean(pre_bean);
					commit();
				} catch (Exception ex) {
					rollback();
				} finally {
					endTrans();
				}
			}
		}
	}

	/**
	 * 下移节点
	 * 
	 * @param parentID
	 *            long
	 * @param index
	 *            long
	 */
	public void moveDownNode(long parentID, long index) {
		if (parentID != 0) {
			long next_index = index + 1;
			MetaData bean = getNodeByIndex(parentID, index);
			MetaData next_bean = getNodeByIndex(parentID, next_index);
			// 当不为最后节点时，下移节点
			if (next_bean != null) {
				try {
					beginTrans();
					// 交换index
					bean.setNode_index(new Long(next_index));
					next_bean.setNode_index(new Long(index));
					// 更新节点信息
					updateBean(bean);
					updateBean(next_bean);
					commit();
				} catch (Exception ex) {
					rollback();
				} finally {
					endTrans();
				}
			}
		}
	}

	/**
	 * 更新节点
	 * 
	 * @param bean
	 *            Common
	 * @return int :0 成功;1 操作失败;2 含有同名节点，操作失败
	 */
	public int updateNode(MetaData bean) {
		long id = bean.getId().longValue();
		long parentID = bean.getParentid().longValue();
		String newNodeName = bean.getNode_name();
		String newNodeValue = bean.getNode_value();
		if (bean.getNode_name() == null) {
			System.out.println("----已有相同的名字:" + bean.getNode_name());
			return OPER_FAILD;
		}

		if (getNodeByValue(id, parentID, bean.getNode_value()) != null) {
			System.out.println("----已有相同的code:" + bean.getNode_value());
			return OPER_HASRECORD;
		}

		// 当不含有同名节点时添加记录
		if (getNodeByName(id, parentID, newNodeName) == null) {
			// 含有相同属性值的时候返回错误
			if (getNodeByValue(id, parentID, newNodeValue) != null) {
				return OPER_HASRECORD;
			} else {
				try {
					updateBean(bean);
					return OPER_SUCCESS;
				} catch (Exception ex) {
					return OPER_FAILD;
				}
			}
		} else {
			return OPER_HASRECORD;
		}
	}

	/**
	 * 删除节点
	 * 
	 * @param bean
	 *            Node
	 * @throws TSDBException
	 * @throws HibernateException
	 */
	public void deleteNode(MetaData bean) throws TSDBException,
			HibernateException {
		deleteBean(bean);
	}

	/**
	 * 根据ID获取节点信息
	 * 
	 * @param id
	 *            long
	 * @throws HibernateException
	 * @return Common
	 */
	public MetaData getNode(long id) throws HibernateException {
		String query = "select o from MetaData o where o.id = '" + id + "'";
		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据节点种类获取子节点List
	 * 
	 * @param node_typename
	 *            String
	 * @return List
	 */
	public List getNodeListByName(String node_typename) {
		String query = "select o.id from MetaData o where o.node_typename = '"
				+ node_typename + "'" + " and o.node_typename = o.node_name ";
		List list = getListByQuery(query);
		if (list.size() == 0)
			return new ArrayList();
		// 获取根节点ID
		long parentID = ((Long) list.get(0)).longValue();
		return getNodeListByID(parentID);
	}

	/**
	 * 根据节点种类名称获取子节点List
	 * 
	 * @param node_typename
	 *            String
	 * @return List
	 */
	public List getNodeListByTypeName(String node_typename) {
		String query = "select o.id from MetaData o where o.node_typename = '"
				+ node_typename + "'";
		List list = getListByQuery(query);
		if (list.size() == 0)
			return new ArrayList();
		// 获取根节点ID
		long parentID = ((Long) list.get(0)).longValue();

		return getNodeListByID(parentID);
	}

	/**
	 * 根据节点种类名称获取子节点List
	 * 
	 * @param node_typename
	 *            String
	 * @return List
	 */
	public List getNodeListByCp(String node_typename) {
		String query = "select o.parentid from MetaData o where o.node_typename = '"
				+ node_typename + "'";
		List list = getListByQuery(query);
		if (list.size() == 0)
			return new ArrayList();
		// 获取根节点ID
		long parentID = ((Long) list.get(0)).longValue();
		// System.out.println(parentID);
		return getNodeListByID(parentID);
	}

	/**
	 * 根据ID获取子节点List
	 * 
	 * @param id
	 *            long
	 * @return List
	 */
	public List getNodeListByID(long id) {
		String query = "select o from MetaData o where o.parentid = '" + id
				+ "'" + " and o.state = 2 order by o.node_index";
		List list = getListByQuery(query);
		return list;
	}
	
	public List getNodeListByIDforzf(long id) {
		String query = "select o from MetaData o where o.parentid = '" + id
				+ "'" + " and o.state = 2  and o.id != 13156 order by o.node_index";
		List list = getListByQuery(query);
		return list;
	}
	public List getNodeListByPid(String id) {
		String query = "select o from MetaData o where o.parentid = '" + id
				+ "'" + " order by o.node_index";
		List list = getListByQuery(query);
		return list;
	}

	/**
	 * 根据VALUE获取NAME
	 * 
	 * @param id
	 *            long
	 * @return List
	 */
	public String getNameByValue(String value) {
		String node_name = "";
		MetaData md = null;
		
		String query = "select o from MetaData o where o.node_value = '" + value
				+ "'" + " order by o.node_index";
		 //and o.state = 2
		List list = getListByQuery(query);
		if (list.size() == 1) {
			md = (MetaData) list.get(0);
			node_name = md.getNode_name();
		}
		return node_name;
	}
	
	/**
	 * 根据VALUE获取NAME
	 * 
	 * @param id
	 *            long
	 * @return List
	 */
	public String getNameByValueAndType(String value) {
		String node_name = "";
		MetaData md = null;
		
		String query = "select o from MetaData o where o.node_value = '" + value
				+ "'" + " and o.node_typename = '"+value+"' order by o.node_index";
		 //and o.state = 2
		List list = getListByQuery(query);
		if (list.size() == 1) {
			md = (MetaData) list.get(0);
			node_name = md.getNode_name();
		}
		return node_name;
	}
	
	
	/**
	 * 根据节点值查找子节点
	 * 
	 * @param id
	 *   institutionid 已经存入其他字段20091222修改
	 * @return List
	 * @throws TSDBException
	 */
	public List findChilderByNodeValue(String parentNodeTypeName,
			String childerNodeTypeName) throws TSDBException {
		String query = "select new MetaData(o.id,o.node_name,o.node_value) from MetaData o where o.node_typename in ( select m.node_value "
				+ "from MetaData m where m.node_typename = ?  and m.parentid != 0)   and o.state = 2 and  o.parentid != 0 and o.node_typename=? order by o.node_index ";
		Type[] types = new Type[] { Hibernate.STRING, Hibernate.STRING
				};
		Object[] objs = new Object[] { parentNodeTypeName, childerNodeTypeName
				};

		return dbwrapper.query(query, objs, types);

	}

	/**
	 * 根据节点值查找子节点
	 * 
	 * @param id
	 *   institutionid 已经存入其他字段20091222修改
	 * @return List
	 * @throws TSDBException
	 */
	public List findChilderByNodeValueHangye(String parentNodeTypeName,
			String childerNodeTypeName) throws TSDBException {
		String query = "select new MetaData(o.id,o.node_name,o.node_value) from MetaData o where o.node_typename in ( select m.node_value "
				+ "from MetaData m where m.node_typename = ?  and m.parentid != 0)   and o.state = 2 and  o.parentid != 0 and o.node_typename=? and o.institutionid=? order by o.node_index ";
		Type[] types = new Type[] { Hibernate.STRING, Hibernate.STRING,Hibernate.LONG
				};
		Object[] objs = new Object[] { parentNodeTypeName, childerNodeTypeName,getInstanceId(childerNodeTypeName)
				};

		return dbwrapper.query(query, objs, types);

	}

	public Long getInstanceId(String childerNodeTypeName) {
		Long instanceid = Long.parseLong("0");

		switch (childerNodeTypeName.charAt(0)) {
		case 'B':
			instanceid = Long.parseLong("1");
			break;
		case 'C':
			instanceid = Long.parseLong("2");
			break;
		case 'D':
			instanceid = Long.parseLong("3");
			break;
		case 'E':
			instanceid = Long.parseLong("4");
			break;
		case 'F':
			instanceid = Long.parseLong("5");
			break;
		case 'H':
			instanceid = Long.parseLong("6");
			break;
		case 'I':
			instanceid = Long.parseLong("7");
			break;
		case 'R':
			instanceid = Long.parseLong("8");
			break;
		case 'K':
			instanceid = Long.parseLong("9");
			break;
		case 'N':
			instanceid = Long.parseLong("10");break;
		case 'O':
			instanceid = Long.parseLong("11");break;
		case 'A':
			instanceid = Long.parseLong("12");break;
		case 'G':
			instanceid = Long.parseLong("13");break;
		case 'J':
			instanceid = Long.parseLong("14");break;
		case 'L':
			instanceid = Long.parseLong("15");break;
		case 'M':
			instanceid = Long.parseLong("16");break;
		case 'P':
			instanceid = Long.parseLong("17");break;
		case 'Q':
			instanceid = Long.parseLong("18");break;
		case 'S':
			instanceid = Long.parseLong("19");break;
		case 'T':
			instanceid = Long.parseLong("20");break;
		}
		return instanceid;

	}

	/**
	 * 根据父节点的typename 与子节点的parentid才查找子节点
	 * 
	 * @param id
	 *            long
	 * @return List
	 * @throws TSDBException
	 */
	public List findChilderByParentIdAndNodeValue(String parentNodeTypeName,
			String parentid) throws TSDBException {
		MetaData d = new MetaData();
		String query = "select new MetaData(o.id,o.node_name,o.node_value) from MetaData o where  o.node_typename=? and o.parentid=?  ";
		Type[] types = new Type[] { Hibernate.STRING, Hibernate.STRING };
		Object[] objs = new Object[] { parentNodeTypeName, parentid };
		return dbwrapper.query(query, objs, types);

	}
	
	/**
	 * 根据父节点的typename 与子节点的parentid才查找子节点
	 * 
	 * @param id
	 *            long
	 * @return List
	 * @throws TSDBException
	 */
	public List findChilderByNodeValueAndTypeName(String parentNodeValue,String parentTypeName) throws TSDBException {
		MetaData d = new MetaData();
		String query = "select new MetaData(o.id,o.node_name,o.node_value) from MetaData o where o.parentid =(select v.id from MetaData v where v.node_value=? and v.node_typename=? ) order by o.node_index ";
		Type[] types = new Type[] { Hibernate.STRING, Hibernate.STRING };
		Object[] objs = new Object[] { parentNodeValue,parentTypeName };
		return dbwrapper.query(query, objs, types);
	}

	/**
	 * 根据节点名称、节点值查找子节点
	 * 
	 * @param id
	 *            long
	 * @return List
	 * @throws TSDBException
	 */
	public List findChilderByName(String parentNodeTypeName,
			String childerNodeTypeName, String nodeName, Page page)
			throws TSDBException {
		List listP = new ArrayList();
		List listT = new ArrayList();
		StringBuffer queryHql = new StringBuffer("");
		StringBuffer countHql = new StringBuffer("");

		queryHql
				.append(" from MetaData o where o.node_typename in ( select m.node_value from MetaData m where m.node_typename = ?  and m.parentid != 0)   and o.state = 2 and  o.parentid != 0 and o.node_typename=? ");
		listP.add(parentNodeTypeName);
		listT.add(Hibernate.STRING);
		listP.add(childerNodeTypeName);
		listT.add(Hibernate.STRING);
		if (nodeName != null && nodeName.length() > 0) {
			queryHql.append(" and o.node_name like ?");
			listP.add("%" + nodeName + "%");
			listT.add(Hibernate.STRING);
		}

		queryHql.append(" order by o.node_index ");
		Type[] types = (Type[]) listT.toArray(new Type[0]);
		countHql.append("select count(*) ");
		countHql.append(queryHql);
		// List list = getListByQuery(query);

		return query(queryHql.toString(), countHql.toString(), listP.toArray(),
				types, page);

	}

	public List query(String queryHql, String countHql, Object[] params,
			Type[] types, Page page) throws TSDBException {
		int count = 0;
		if (page.getTotalCount() < 0) {
			count = queryListSize(countHql, params, types);
			page.setTotalCount(count);
		} else {
			count = page.getTotalCount();
		}
		if (count == 0) {
			return new ArrayList();
		}
		int pageSize = page.getPageSize();
		int pageNumber = page.getPageCount() < page.getCurrentPage() ? page
				.getPageCount() : page.getCurrentPage();
		return dbwrapper.query(queryHql, params, types, pageSize,
				(pageNumber - 1));
	}

	/**
	 * queryListSize
	 * 
	 * @param sql
	 *            Serializable
	 * @param objs
	 *            Serializable[]
	 * @param types
	 *            Serializable[]
	 * @return int
	 */
	public int queryListSize(String sql, Object[] objs, Type[] types)
			throws TSDBException {
		int count = dbwrapper.count(sql, types, objs);
		return count;
	}

	/**
	 * 根据名称获取节点记录
	 * 
	 * @param parentID
	 *            long
	 * @param name
	 *            String
	 * @return Common
	 */
	private MetaData getNodeByName(long parentID, String name) {
		String query = "select o from MetaData o where o.parentid = '"
				+ parentID + "'" + " and o.node_name = '" + name + "'";
		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据REGION,CATALOG得到记录实体
	 * 
	 * @param String
	 *            region
	 * @param String
	 *            catalog
	 * @return Common
	 */
	public MetaData getNodeByRegionAndCatalog(String region, String catalog) {
		String query = "select o from MetaData o where o.node_typename = '"
				+ region + "'" + " and o.node_value = '" + catalog + "'"
				+ " and o.institutionid = 1 and o.state = 2";

		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 获取不为指定ID的同名记录
	 * 
	 * @param id
	 *            long
	 * @param parentID
	 *            long
	 * @param name
	 *            String
	 * @return Common
	 */
	private MetaData getNodeByName(long id, long parentID, String name) {
		String query = "select o from MetaData o where o.parentid = '"
				+ parentID + "'" + " and o.id != '" + id + "'"
				+ " and o.node_name = '" + name + "'";
		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据Value获取节点记录
	 * 
	 * @param parentID
	 *            long
	 * @param value
	 *            String
	 * @return Common
	 */
	private MetaData getNodeByValue(long id, long parentID, String value) {
		String query = "select o from MetaData o where o.parentid = '"
				+ parentID + "'";
		if (id != 0) {
			query += " and o.id != '" + id + "'";
		}
		query += " and o.node_value = '" + value + "'";
		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据Value获取节点记录
	 * 
	 * @param parentID
	 *            long
	 * @param value
	 *            String
	 * @return Common
	 */
	public MetaData getNodeByParentIDAndValue(String nodeTypeName,
			String nodeValue) {
		String query = "select o from MetaData o where o.node_typename = '"
				+ nodeTypeName + "'";

		query += " and o.node_value = '" + nodeValue + "'";
		query += " and o.state = " + 2 + "";
		Logger.debug("\n\n=============================query============"
				+ query);
		List list = getListByQuery(query);

		System.out.println(">>>>sql>>>>>>>>>" + query.toString());
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据序列编号获取节点
	 * 
	 * @param parentID
	 *            long
	 * @param index
	 *            long
	 * @return Common
	 */
	private MetaData getNodeByIndex(long parentID, long index) {
		String query = "select o from MetaData o where o.parentid = '"
				+ parentID + "'" + " and o.node_index = '" + index + "'";
		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据数据字典和节点值获得节点名称
	 * 
	 * @param nodeValue
	 *            数据字典类别编码
	 * @param nodeName
	 *            分类编码
	 * @param state
	 *            状态 默认可用
	 */
	public MetaData getNodeByTypeName(String nodeValue, String nodeName,
			boolean state) {

		String query = "select o from MetaData o where o.parentid =(select v.id from MetaData v where v.node_value='"
				+ nodeValue + "') and o.node_value='" + nodeName + "'";
		if (state) {
			query += " and o.state=2";
		} else {
			query += " and o.state=3";
		}
		List list = getListByQuery(query);
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;

	}

	/**
	 * 给出子节点值查找所本父点的有子节点列表
	 * 
	 * @throws TSDBException
	 * @throws TSDBException
	 */

	public List findNode11Value(String nodeValue) throws TSDBException {
		List options = new ArrayList();

		String query = "select o from MetaData o where o.parentid =(select v.parentid from MetaData v where v.node_value=? and o.state=2) order by o.node_index";
		Type[] type = new Type[] { Hibernate.STRING };
		Object[] valus = new Object[] { nodeValue };

		List list = dbwrapper.query(query, valus, type);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			MetaData element = (MetaData) iter.next();
			options.add(new LabelValueBean(element.getNode_value(), element
					.getNode_name()));
		}
		return options;

	}

	
	public List findNodeValueByZN(String nodeValue,String nodeTypeName) throws TSDBException {
		List options = new ArrayList();

		String query = "select o from MetaData o where o.parentid in(select v.id from MetaData v where v.node_value=? and v.node_typename=?) order by o.node_index";
		Type[] type = new Type[] { Hibernate.STRING ,Hibernate.STRING};
		Object[] valus = new Object[] { nodeValue,nodeTypeName };
		
		List list = dbwrapper.query(query, valus, type);
		
		return list;

	}
	/**
	 * 给出子节点值查找所本父点的有子节点列表
	 * 
	 * @throws TSDBException
	 * @throws TSDBException
	 */

	public List findNodeValue(String nodeValue) throws TSDBException {
		List options = new ArrayList();
		MetaData d ;
		String query = "select o from MetaData o where o.parentid =(select v.parentid from MetaData v where v.node_value=?) order by o.node_index";
		Type[] type = new Type[] { Hibernate.STRING };
		Object[] valus = new Object[] { nodeValue };

		List list = dbwrapper.query(query, valus, type);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			MetaData element = (MetaData) iter.next();
			options.add(new LabelValueBean(element.getNode_value(), element
					.getNode_name()));
		}
		return options;

	}
	
	/**
	 * 给出子节点值查找同级列表
	 * 
	 * @throws TSDBException
	 * @throws TSDBException
	 */

	@SuppressWarnings("unchecked")
	public List findNodeValueByHangYe(String nodeValue) throws TSDBException {
		List options = new ArrayList();
		MetaData d ;
		String query = "select o from MetaData o where  ";
		 query+= "   o.parentid =(select v.parentid from MetaData v where  v.institutionid is not null and v.node_value=?) order by o.node_index ";
		Type[] type = new Type[] { Hibernate.STRING };
		Object[] valus = new Object[] { nodeValue };
		System.out.println("|||||||||||"+query);
		List list = dbwrapper.query(query, valus, type);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			MetaData element = (MetaData) iter.next();
			options.add(new LabelValueBean(element.getNode_value(), element
					.getNode_name()));
		}
		return options;

	}

	/**
	 * 给出子节点值查找所本父点的有子节点列表
	 * 
	 * @throws TSDBException
	 * @throws TSDBException
	 */

	public MetaData getNodeValue(String nodeValue, String nodeTypename)
			throws TSDBException {
		// List listP = new ArrayList();
		// List listT = new ArrayList();
		MetaData d;
		StringBuffer queryHql = new StringBuffer(
				"select v from MetaData v where  v.state=2 ");
		if (StringUtils.isNotBlank(nodeValue)) {
			queryHql.append(" and v.node_value='").append(nodeValue)
					.append("'");

		}
		if (StringUtils.isNotBlank(nodeTypename)) {
			queryHql.append(" and v.node_typename='").append(nodeTypename)
					.append("'");

		}
		List list = dbwrapper.query(queryHql.toString());
		if (!list.isEmpty()) {
			return (MetaData) list.get(0);
		}
		return new MetaData();

	}

	// public static void main(String args[]){
	// MetaData meta = new
	// DictionaryService().getNodeByParentIDAndValue(null,"F22","1000001");
	// Logger.debug("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%meta%%%%%%%%%%%%" +
	// meta.getNode_name());
	//    	
	// }

	public List parentNodeList() throws TSDBException {
		StringBuffer queryHql = new StringBuffer(
				"select v from MetaData v where  v.parentid=221");
		System.out.println(queryHql.toString());
		return dbwrapper.query(queryHql.toString());
	}

	/**
	 * 根据nodeTypename和node_name获取节点记录
	 * 
	 * @param parentID
	 *            long
	 * @param value
	 *            String
	 * @return Common
	 */
	public MetaData getSjzdNodeByParentIDAndValue(String nodeTypename,
			String nodeName) {
		String query = " from MetaData o where o.node_typename = '"
				+ nodeTypename + "'";

		query += " and o.node_name like '%" + nodeName + "%'";
		query += " and o.state = " + 2 + "";
		Logger.debug("\n\n=============================query============"
				+ query);
		List list = getListByQuery(query);

		// System.out.println(">>>>sql>>>>>>>>>"+query.toString());
		if (list.size() != 0)
			return (MetaData) list.get(0);
		return null;
	}

	/**
	 * 根据父节点ID获取，它之下的子节点List信息
	 * 
	 * @param id
	 *            long
	 * @throws HibernateException
	 * @return Common
	 */
	
	public List getNodeList(long id) throws HibernateException {
		
		String query = "select o from MetaData o where  o.state = 2 and o.parentid = '"
				+ id + "'";
		List list = getListByQuery(query);
		System.out.println(">>>>sql>>>>>>>>>" + query.toString());
		return list;
	}
}
