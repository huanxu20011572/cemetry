/* ====================================================================
 * 
 * <http://www.topsuntech.org/>.
 */
package com.topsuntech.gUnit.gEU_util.tools;

/**
 * 定义常量类
 * 
 * <p>
 * <a href="Constants.java.html">View Source</a>
 * </p>
 * 
 * @see com.topsuntech.gUnit.gEU_util.tools.Constants
 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
 * @since 1.0
 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
 *          $Revision: 1.1 $
 * 
 */
public class Constants {

	/**
	 * 区域级别
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.AREA_LEVEL
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface AREA_LEVEL {
		final long CITY = 1;
		final long COUNTRY = 2;
		final long STREET = 3;
	}

	/**
	 * 组织机构级别
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.DEPT_LEVEL
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface DEPT_LEVEL {
		final long PROVINCE = 0;

		final long CITY = 1;

		final long COUNTRY = 2;

		final long STREET = 3;

		final long COMMUNITY = 4;
	}

	/**
	 * 删除标志
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.USE_FLAG
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface USE_FLAG {
		final Byte USE_FLAG_ON = Byte.valueOf("1");

		final Byte USE_FLAG_OFF = Byte.valueOf("0");
	}

	/**
	 * 判断标识：是，否
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.JUDGEMENT_FLAG
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface JUDGEMENT_FLAG {
		// 是
		final long YES = 2205;

		// 否
		final long NO = 2206;
	}

	// 平台角色
	public interface platFormRole {
		/**
		 * 市级管理人员[平台]
		 */
		final static long CITY_MANAGER_USER = 1;

		final static String CITY_MANAGER_USER_NAME = "市级管理人员[平台]";

		/**
		 * 区县管理人员[平台]
		 */
		final static long COUNTRY_MANAGER_USER = 2;

		final static String COUNTRY_MANAGER_USER_NAME = "区县管理人员[平台]";

		/**
		 * 区级领导
		 */
		final static long COUNTRY_LEAD_USER = 201;

		final static String COUNTRY_LEAD_USER_NAME = "区级领导";

		/**
		 * 街道管理人员[平台]
		 */
		final static long STREET_MANAGER_USER = 3;

		final static String STREET_MANAGER_USER_NAME = "街道管理人员[平台]";

		/**
		 * 一般工作人员
		 */
		final static long GENERAL_USER = 4;

	}

	// 查询区域
	public interface QueryRegion {
		// 区域
		static final String REGION = "reg";

		// 机构
		static final String DEPT = "org";
	}

	// 树类型
	public interface treeNodeType {
		// 区域
		static final long REGION = 101;

		// 机构
		static final long DEPT = 102;

		// 系统用户
		static final long USER = 103;

		// 本地
		static final long OWN = 105;

		// 机构下区域
		static final long DEPT_DN_REGION = 106;

		// 区域下机构
		static final long REGION_DN_DEPT = 107;

	}

	// 树属性
	public interface treeAttribute {
		static final String IMAGE = "folder.gif";

		static final String IMAGE_CHILD = "page.gif";

		static final String URL = "cxtjAction.do";

		static final String root_YES = "Y";

		static final String root_NO = "N";
	}

	// 树类型
	public interface treeType {
		/*
		 * FROM"数字字典"(递归)，显示下级字典
		 */
		static final long DICT = 101;

		/*
		 * FROM"数字字典"(不递归)，显示下级字典
		 */
		static final long DICT_DOWN = 102;

		/*
		 * FROM"数字字典"(递归)，显示下级字典：只限用于“社救申请”中的"成员身份类别"
		 */
		static final long DICT_APPLY_SFLB = 103;

		/*
		 * FROM"组织机构"(递归)
		 */
		static final long DEPT = 201;

		/*
		 * FROM"组织机构"(不递归)
		 */
		static final long DEPT_DOWN = 202;

		/*
		 * FROM"组织机构"，显示相关项目;
		 */
		static final long DEPT_PROJECT = 203;

		/*
		 * FROM"组织机构"(递归)， 不显示相关的项目，同时显示下级成员
		 */
		static final long DEPT_USER = 204;

		/*
		 * FROM"组织机构"(不递归)，不显示相关的项目，同时显示下级成员
		 */
		static final long DEPT_DOWN_USER = 205;

		/*
		 * FROM"组织机构ID"，显示下级成员
		 */
		static final long USER = 206;

		/*
		 * FROM"组织机构ID"，用于“受理”：适用于区县用户；
		 */
		static final long DEPT_BUSINESS_APPLY = 207;

		/*
		 * FROM"组织机构ID"，用于“项目维护”：适用于市级、区县管理人员用户；
		 */
		static final long DEPT_BUSINESS_PROJECT = 208;

		/*
		 * 209，FROM"组织机构ID"，用于“公文收发”：本级；
		 */
		static final long DEPT_DOCUMENT_CURRENT = 209;

		/*
		 * 210，FROM"组织机构ID"，用于“公文收发”：下级；
		 */
		static final long DEPT_DOCUMENT_CHILD = 210;

		/*
		 * 211，FROM"组织机构ID"，用于“公文收发”：本级和下级；
		 */
		static final long DEPT_DOCUMENT_CURRENT_CHILD = 211;

		/*
		 * 212，FROM"组织机构ID"，用于“爱心家园”；
		 */
		static final long DEPT_SUPERPARKET = 212;

		/*
		 * FROM"项目表",只显示项目树（通过机构ID）
		 */
		static final long PROJECT = 301;

		/*
		 * FROM"项目资源"，不显示项目，显示当前项目下所有的资源信息
		 */
		static final long RESOURCE = 401;

		/*
		 * FROM"角色信息"，显示当前节点下所有的角色
		 */
		static final long ROLE = 501;

		/*
		 * FROM"区域数据"，只显示下一级区域
		 */
		static final long REGION_DOWN = 601;

		/*
		 * FROM"区域数据"，用于“区域维护”
		 */
		static final long REGION_LIST_TREE = 600;

		/*
		 * 602, FROM"区域数据"，依次显示邮件组、机构、用户，用于“邮件发件箱”；
		 */
		static final long REGION_DEPT_USER = 602;

		/*
		 * 603, FROM"区域数据"，依次显示机构、用户，用于“邮件分组”；
		 */
		static final long REGION_DEPT_USER_GROUP = 603;

		/*
		 * 604, FROM"区域数据"，依次显示机构，用于“日常办公管理”：显示本级；
		 */
		static final long REGION_DEPT_NORMAL_WORK_BJ = 604;

		/*
		 * 604, FROM"区域数据"，依次显示机构，用于“日常办公管理”：显示下级；
		 */
		static final long REGION_DEPT_NORMAL_WORK_XJ = 605;

		/*
		 * 604, FROM"区域数据"，依次显示机构，用于“日常办公管理”：显示本级、下级；
		 */
		static final long REGION_DEPT_NORMAL_WORK_BJ_XJ = 606;

		/*
		 * 6001, FROM"区域数据"，依次显示区域、机构，用于“本级系统人员管理”；
		 */
		static final long REGION_DEPT = 6001;

		/*
		 * 6001, FROM"区域数据"，选择“区域树”；
		 */
		static final long REGION_SELECT_TREE = 607;

		/*
		 * FROM"机构数据"，用于“机构维护”
		 */
		static final long DEPT_LIST_TREE = 700;

		/*
		 * FROM"机构数据"，选择“机构树”
		 */
		static final long DEPT_SELECT_TREE = 701;

		/*
		 * FROM"机构数据"，选择“机构树”，用于“爱心超市”
		 */
		static final long DEPT_SELECT_AXCS_TREE = 702;

		/*
		 * FORM"机构数据"，选择“机构树”，通用； 能根据用户的机构级别，自动适应显示相应的机构信息
		 */
		static final long DEPT_GENERAL_SELECT_TREE = 703;

		/*
		 * FORM"机构数据"，选择“机构树”，不要按用户机构自适应
		 */
		static final long DEPT_STAT_SELECT_TREE = 704;

		/*
		 * FORM"数字字典"，选择“身份类别树”
		 */
		static final long SJ_STATUS_CANUM_SELECT_TREE = 1000;

	}

	// 是
	public final static String YES = "1";
	// 否
	public final static String NO = "0";

	public static interface BUSINESS_TYPE {
		/**
		 * 新申请
		 */
		final int NEW_APPLY = 452;

		/**
		 * 情况变更
		 */
		final int CHANGE_INFO = 444;

		/**
		 * 申请人变更
		 */
		final int CHANGE_HOLDER = 445;

		/**
		 * 撤消成员待遇
		 */
		final int CANCEL_DEAL_MEMBER = 2580;

		/**
		 * 困难企业变更
		 */
		final int DIF_CORP = 442;

		/**
		 * 撤消家庭待遇
		 */
		final int CANCEL_DEAL_FAMILY = 450;

		/**
		 * 迁入变更
		 */
		final int CHANGE_IN = 453;

		/**
		 * 迁出变更
		 */
		final int CHANGE_OUT = 446;

		/**
		 * 分户变更
		 */
		final int DIV_FAMILY = 2525;

		/**
		 * 合户变更
		 */
		final int UNION_FAMILY = 2526;

		/**
		 * 继续享受待遇
		 */
		final int REVIEW = 1;

		/**
		 * 撤销待遇
		 */
		final int CANCEL = 2;

		/**
		 * 机构调整
		 */
		final int ORGANIZ = 451;

		/**
		 * 复审
		 */
		final int REAUDIT = 2699;

		/**
		 * 调标
		 */
		final Long ADJUST_STANRDARD = new Long(447);

	}

	/**
	 * 系统名称
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface SYSTEM_FLAG {
		// 天津民政
		final static String TJMZ = "tjmz";
		// 天津殡葬
		final static String TJBZ = "tjbz";
		// 收入核查
		final static String SRHC = "srhc";
		// 天津养老
		final static String JGYL = "jgyl";
		// 天津低保
		final static String JBSH = "jbsh";
		// 老龄事务
		final static String LLSW = "llsw";
		// 专项救助
		final static String ZXJZ = "zxjz";
		// 临时救助
		final static String LSJZ = "lsjz";
		// 低收入认定
		final static String DSRRD = "dsrrd";
		// 居家养老
		final static String JJYL = "jjyl";
		// 社区养老
		final static String SQYL = "sqyl";
	}

	/**
	 * 数据源名称
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface DATA_SOURCE_DAME {
		// 天津民政
		final static String TJMZ = "tjmz";
		// 天津殡葬
		final static String TJBZ = "tjbz";
		// 收入核查
		final static String SRHC = "srhc";
		// 天津养老
		final static String JGYL = "jgyl";
		// 天津低保
		final static String JBSH = "jbsh";
		// 老龄事务
		final static String LLSW = "llsw";
		// 专项救助
		final static String ZXJZ = "zxjz";
		// 临时救助
		final static String LSJZ = "lsjz";
		// 低收入认定
		final static String DSRRD = "dsrrd";
		// 居家养老
		final static String JJYL = "jjyl";
		// 社区养老
		final static String SQYL = "sqyl";
		// 门户统计
		final static String STATIC = "static";
	}

	/**
	 * 多选查询类别
	 * 
	 * @author zcpeng
	 * 
	 */
	public static interface MULTIPLE_TYPE {
		// 查询字典
		final String DICT = "dict";
		// 查询自建表
		final String CUSTOM = "custom";
	}

	/**
	 * 转换类型
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface translateType {
		// 机构
		final static String TRANSLATE_DEPT = "translate_dept";
		// 区划
		final static String TRANSLATE_REGION = "translate_region";
		// 字典
		final static String TRANSLATE_DICT = "translate_dict";
		// 正常
		final static String UNNEED_TRANSLATE = "unneed_translate";
		// 自定义方式
		final static String TRANSLATE_CUSTOM = "translate_custom";
	}

	/**
	 * 平台统计名称
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface staticsName {
		final static String ETFL = "儿童福利数据";
		final static String JXTJ = "军休数据";
		final static String SYDJLTJ = "收养登记数据据";
		final static String JBSHJZTJ = "基本生活救助数据";
		final static String JHDJLTJ = "结婚登记数据";
		final static String SHZZZTQK = "社会组织数据";
	}

	/**
	 * 平台统计
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface statics {
		final static String ETFL = "etfl";
		final static String JXTJ = "jxtj";
		final static String SYDJLTJ = "sydjltj";
		final static String JBSHJZTJ = "jbshjztj";
		final static String JHDJLTJ = "jhdjltj";
		final static String SHZZZTQK = "shzzztqk";
	}

	/**
	 * 区划转换规则
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface regionConvert {
		// 滨海新区区划转换规则
		final static Long BINHAI = new Long(1);
	}
	
	
	/**
	 * @author wubb
	 * 菜单类型  1：补贴对象登记 2：登记列表 3：正在公示列表 4：公示期满列表 5：待办列表 6：审批通过列表 
	 * 7：审批不通过列表 8：资金领取 9：资金追回 10：资金退订 11：资金经办管理
	 */
	public static interface MENU_TYPE{
		/**
		 * 1：补贴对象登记
		 */
		final long MENU_1 = 1;
		
		/**
		 * 2：登记列表
		 */
		final long MENU_2 = 2;
		
		/**
		 * 3：正在公示列表
		 */
		final long MENU_3 = 3;
		/**
		 * 4：公示期满列表
		 */
		final long MENU_4 = 4;
		/**
		 * 5：待办列表
		 */
		final long MENU_5 = 5;
		
		/**
		 * 6：审批通过列表
		 */
		final long MENU_6 = 6;
		/**
		 * 7：审批不通过列表
		 */
		final long MENU_7 = 7;
		/**
		 * 8：资金领取
		 */
		final long MENU_8 = 8;
		/**
		 * 9：资金追回
		 */
		final long MENU_9 = 9;
		/**
		 * 10：资金退订
		 */
		final long MENU_10 = 10;
		
		/**
		 * 11:资金经办管理 
		 */
		final long MENU_11 = 11;
		
		/**
		 * 12:受助对象审批标准管理 
		 */
		final long MENU_12 = 12;
		
		/**
		 * 13:区补助资金标准管理 
		 */
		final long MENU_13 = 13;
		
		/**
		 * 14:市补助资金标准管理 
		 */
		final long MENU_14 = 14;
		
	}
	
	
	
}
