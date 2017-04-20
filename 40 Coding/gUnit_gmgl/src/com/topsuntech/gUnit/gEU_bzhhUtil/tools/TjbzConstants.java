/**
 * 天津殡葬系统用业务常量<br>
 */
package com.topsuntech.gUnit.gEU_bzhhUtil.tools;

/**
 * 新建字典等往此类里面加
 * 
 * @author zcpeng
 * 
 */
public class TjbzConstants {
	/**
	 * 救助状态
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.SALVAGE_TYPE
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface SALVAGE_TYPE {
		// 未救济
		final long NO_SALVAGE_TYPE = 147;
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

	public static interface INSURANCE_FLAG {
		// 参加保险人员
		final long INSURANCE = 572;
	}

	/**
	 * 事项审核审批过程中的不同类型的操作
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.APPROVE_TYPE
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface APPROVE_TYPE {
		/**
		 * 上报、审批
		 */
		final int SHENPI = 1;

		/**
		 * 审核、承办
		 */
		final int CHENGBAN = 2;

		/**
		 * 保存
		 */
		final int CACHE = 3;
	}

	public static interface FAMILY_WORK_CONFIGURATION {
		/**
		 * 无在职
		 */
		final int NO_WORKER = 1167;

		/**
		 * 单职工
		 */
		final int ONE_WORKER = 1168;

		/**
		 * 双职工
		 */
		final int TWO_WORKER = 1169;

		/**
		 * 离休人员
		 */
		final int DIMISSION = 1171;

		/**
		 * 退休人员
		 */
		final int RETIRE = 1172;
	}

	public static interface FAMILY_TYPE {
		/**
		 * 有在职人员家庭
		 */
		final int HAVE_WORKER = 1174;

		/**
		 * 无在职人员家庭
		 */
		final int NO_WORKER = 1175;
	}

	public static interface HOUSEHOLD_RELATION {
		/**
		 * 本人
		 */
		final int HOUSEHOLD = 7;

		/**
		 * 母亲
		 */
		final int MOTHER = 10;

		/**
		 * 祖父
		 */
		final int ZUFU = 13;

		/**
		 * 外祖父
		 */
		final int WAIZUFU = 14;

		/**
		 * 祖母
		 */
		final int ZUMU = 22;

		/**
		 * 外祖母
		 */
		final int WAIZUMU = 21;

		/**
		 * 子女
		 */
		final int ZINV = 18;

		/**
		 * 孙子女
		 */
		final int SUNZINV = 15;

		/**
		 * 外孙子女
		 */
		final int WAISUNZINV = 8;

		/**
		 * 配偶
		 */
		final int CONSORT = 17;

		/**
		 * 兄弟
		 */
		final int BROTHER = 11;

		/**
		 * 姐妹
		 */
		final int SISTER = 12;

		/**
		 * 兄妹
		 */
		final int BROTHER_AND_SISTER = 19;

		/**
		 * 姐弟
		 */
		final int SISTER_AND_BROTHER = 20;

		/**
		 * 父亲
		 */
		final int FATHER = 16;

		/**
		 * 其他成员
		 */
		final int OTHER_PEOPLE = 9;
	}

	public static interface MEMBER_STATUS {
		/**
		 * 正常
		 */
		final int NATURAL = 1236;

		/**
		 * 死亡
		 */
		final int DIE = 1237;

		/**
		 * 失踪
		 */
		final int DISAPPEARANCE = 1238;

		/**
		 * 服刑及两劳人员
		 */
		final int SERVE_SENTENCE = 2606;

		/**
		 * 服兵役
		 */
		final int JOIN_UP = 4063;
	}



	/**
	 * 低保标准
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.STANDARD_TYPE
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface STANDARD_TYPE {

		/**
		 * 农村五保供养标准 added by pengzuocong 2008-6-3
		 */
		final int COUNTY_WB_STANDARD = 4193;
		/**
		 * 最低生活保障标准
		 */
		final int LOWEST_ENSURE_STANDARD = 529;

		/**
		 * 最低工资标准
		 */
		final int MINIMUM_WAGE_STANDARD = 530;

		/**
		 * 下岗职工生活补助标准
		 */
		final int UNEMPLOYED_WAGE_STANDARD = 531;

		/**
		 * 离退休金标准
		 */
		final int RETIRE_WAGE_STANDARD = 532;

		/**
		 * 失业保险金标准
		 */
		final int UNEMPLOYED_INSURANCE_STANDARD = 533;

		/**
		 * 粮油帮困补贴标准
		 */
		final int FOOD_OIL = 2559;
	}

	public static interface TRANSACT_INSTANCE {

		/**
		 * 生成迁出函
		 */
		final byte START_MOVE_OUT = 1;

		/**
		 * 发送迁出函
		 */
		final byte SEND_MOVE_OUT = 2;

		/**
		 * 接受迁入
		 */
		final byte ACCEPT_MOVE_IN = 3;
	}

	public static interface ENJOY_TYPE {
		/**
		 * 城市低保标准
		 */
		final int CITY_STANDARD = 186;

		/**
		 * 农村低保标准
		 */
		final int COUNTRY_STANDARD = 187;

		/**
		 * 粮油帮困标准
		 */
		final Long LY_STANDARD = new Long(2559);

		/**
		 * 其他费用标准
		 */
		final Long OTHER_STANDARD = new Long(2779);

		/**
		 * 统战标准
		 */
		final Long TZ_STANDARD = new Long(2561);

		/**
		 * 照料费用标准
		 */
		final Long CARE_STANDARD = new Long(2562);
	}

	/**
	 * 性别
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.SEX
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface SEX {

		/**
		 * 男性
		 */
		final int MALE = 119;

		/**
		 * 女性
		 */
		final int FMALE = 120;
	}

	/**
	 * 退休年龄
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.RETIRE_AGE
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface RETIRE_AGE {

		final int MALE_AGE = 60;

		final int FMALE_AGE = 50;
	}

	/**
	 * 特殊家庭结构
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.SP_FAMILY_CONFIGURATION
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface SP_FAMILY_CONFIGURATION {
		/**
		 * 老残一体
		 */
		final int LCYT = 2053;

		/**
		 * 否
		 */
		final int FOU = 2054;

		/**
		 * 一户多残
		 */
		final int YHDC = 2055;
	}

	/**
	 * 标准适用范围
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.STANDARD_SCOPE_TYPE
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface STANDARD_SCOPE_TYPE {

		/**
		 * 区城市标准
		 */
		final Long COUNTYS_CITY_STANDARD = new Long(564);

		/**
		 * 区农村标准
		 */
		final Long COUNTYS_COUNTRY_STANDARD = new Long(565);

		/**
		 * 市统一标准
		 */
		final Long CITYS_UNITE_STANDARD = new Long(566);

		/**
		 * 市城市标准
		 */
		final Long CITYS_CITY_STANDARD = new Long(567);

		/**
		 * 市农村标准
		 */
		final Long CITYS_COUNTRY_STANDARD = new Long(568);

		/**
		 * 区统一标准
		 */
		final Long COUNTYS_UNITE_STANDARD = new Long(569);

	}

	public static interface MEMBER_REG_TYPE {

		/**
		 * 本市非农业户口
		 */
		final Long CITY_TYPE = new Long(194);

		/**
		 * 本市农业户口
		 */
		final Long COUNTRY_TYPE = new Long(195);
	}

	/**
	 * 撤消低保原因
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.STOP_SALVAGE_REASON
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface STOP_SALVAGE_REASON {
		/**
		 * 低保撤消家庭待遇原因:死亡
		 */
		final Long MEMBER_DIE_LOW_FAMILY = new Long(2520);

		/**
		 * 五保撤消家庭待遇原因:死亡
		 */
		final Long MEMBER_DIE_WUBAO_FAMILY = new Long(4072);

		/**
		 * 撤消成员待遇原因中：死亡
		 */
		final Long MEMBER_DIE = new Long(2790);

		/**
		 * 撤消成员待遇原因中：服刑及两劳人员
		 */
		final Long SERVE_SENTENCE = new Long(2789);

		/**
		 * 撤消成员待遇原因中：成员入伍当兵
		 */
		final Long JOIN_UP = new Long(4062);

		/**
		 * 撤消成员待遇原因中：失踪
		 */
		final Long DISAPPEARANCE = new Long(2791);

		/**
		 * 撤消家庭待遇原因中：因合户而撤消
		 */
		final Long UNION_CONCEL = new Long(2792);

		/**
		 * 撤消家庭待遇原因中：就业渐退
		 */
		final Long WORK_OUT = new Long(2522);
	}

	public static interface MEMBER_ENSURE_APPROVE_TYPE {

		/**
		 * 待遇在本次审批
		 */
		final Long APPROVE = new Long(209);

		/**
		 * 待遇不在本次审批
		 */
		final Long NO_APPROVE = new Long(210);
	}

	/**
	 * 不在本次受理的原因
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.NOT_ENSURE_APPROVE_REASON
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface NOT_ENSURE_APPROVE_REASON {
		/**
		 * 乡城混居，对农村低保受理，城市户口不在本次受理
		 */
		final Long COUNTRY_ACCEPT = new Long(2314);

		/**
		 * 乡城混居，对城市低保受理，农村户口不在本次受理
		 */
		final Long CITY_ACCEPT = new Long(2684);

		/**
		 * 撤消待遇
		 */
		final Long CANCEL_DEAL_MEMBER = new Long(2685);

		/**
		 * 生活困难补助家庭
		 */
		final Long SHKN = new Long(2313);
	}

	public static interface FAMILY_DOMICILIARY_TYPE {
		/**
		 * 城市
		 */
		final long CITY = 3;

		/**
		 * 农村
		 */
		final long COUNTRY = 2;

		/**
		 * 城乡混居型
		 */
		final long CITY_COUNTRY = 4;

		/**
		 * 乡城混居型
		 */
		final long COUNTRY_CITY = 5;
	}

	public static interface HOUSEHOLD_REGISTER_NATURE {
		/**
		 * 本市非农业户口
		 */
		final Long CITY = new Long(194);

		/**
		 * 本市农业户口
		 */
		final Long COUNTRY = new Long(195);

		/**
		 * 小城镇户口
		 */
		final Long XIAOCHENGZHEN = new Long(196);

		/**
		 * 无户口
		 */
		final Long WUHUKOU = new Long(197);

		/**
		 * 外埠非农业户口
		 */
		final Long WAIHU_CITY = new Long(189);

		/**
		 * 外埠农业户口
		 */
		final Long WAIHU_COUNTRY = new Long(190);

		/**
		 * 持中国护照的境外人员
		 */
		final Long JINGWAIRENYUAN = new Long(2721);

		/**
		 * 华侨
		 */
		final Long HUAQIAO = new Long(193);
	}

	/**
	 * 收入类型
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.INCOME
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface INCOME {

		/**
		 * 工资
		 */
		final long WAGE = 424;

		/**
		 * 其他收入
		 */
		final long OTHER_INCOME = 2300;
	}

	/**
	 * 预警种类
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.WARN_TYPE
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface WARN_TYPE {

		/**
		 * 调标失败预警
		 */
		final Long ADJUST_ERROR_WARN = new Long(1);
		/**
		 * 等待迁入地确认
		 */
		final Long CHANGE_IN = new Long(200);

		/**
		 * 乡城混居复审预警
		 */
		final Long NEW_APPLY = new Long(240);

		/**
		 * 迁入地已确认迁入
		 */
		final Long CHANGE_IN_CONFIRM = new Long(2);

		/**
		 * 迁入成功(本区)
		 */
		final Long CHANGE_IN_SUCCESS = new Long(339);

		/**
		 * 迁入成功(跨区)
		 */
		final Long CHANGE_IN_SUCCESS_DIFFERENT_COUNTY = new Long(1341);

		/**
		 * 本区迁出确认
		 */
		final Long CHANGE_SAME_COUNTY = new Long(360);

		/**
		 * 乡城混居撤消待遇预警
		 */
		final Long COUNTY_CITY_STOP = new Long(420);

		/**
		 * 五保签订协议预警
		 */
		final Long WUBAO = new Long(900);

		/**
		 * 公示期满预警
		 */
		final Long PUBLIC = new Long(1040);

		/**
		 * 完善成员失业保险金
		 */
		final Long SHIYEBAOXIANJIN = new Long(1060);

		/**
		 * 完善成员学生信息
		 */
		final Long XUESHENGXINXI = new Long(1061);

		/**
		 * 规范化身份证号码
		 */
		final Long GUIFANHUASHENFENZHENGHAO = new Long(1062);

		/**
		 * 完善家庭住房信息
		 */
		final Long ZHUFANGXINXI = new Long(1063);

		/**
		 * 新系统上线低保数据完善
		 */
		final Long SHUJUWANSHAN = new Long(1080);

		/**
		 * 15号前迁入地未做迁入确认
		 */
		final Long QIANRUDIWEIZUOQIANRUQUEREN = new Long(1121);

		/**
		 * 资金发放预警
		 */
		final Long FUND_SEND_WARN = new Long(362);
	}

	/**
	 * 与申请人关系
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.MEMBER_RELATIONS
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface MEMBER_RELATIONS {

		/**
		 * 本人
		 */
		final Long BEN_REN = new Long(7);

		/**
		 * 配偶
		 */
		final Long SPOUSES = new Long(17);
	}

	/**
	 * 项目分类
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.PROJECT_SORT
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface PROJECT_SORT {

		/**
		 * 低保
		 */
		final Long DIBAO = new Long(2302);
	}

	/**
	 * 预警监听开关
	 * 
	 * @author jiangtao
	 */
	public static interface WARN_LISTENER {

		// 开关(1：开启；0：关闭)
		final int ON_OFF = 1;

		// 预警定时时间
		final String WARN_TIME = "23:00:00";
	}

	/**
	 * 求助方式
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.SALVATION_TYPE
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface SALVATION_TYPE {
		/**
		 * 城市最低生活保障
		 */
		final Long CITY_LIFE = new Long(1);

		/**
		 * 农村最低生活保障
		 */
		final Long COUNTRY_LIFE = new Long(2);

		/**
		 * 城市生活困难补助
		 */
		final Long CITY_DIF = new Long(3);

		/**
		 * 农村生活困难补助
		 */
		final Long COUNTRY_DIF = new Long(4);

		/**
		 * 农村五保
		 */
		final Long COUNTY_WUBAO = new Long(5);

		/**
		 * 粮油帮困
		 */
		final Long FOOD_OIL = new Long(6);

		/**
		 * 照料费
		 */
		final Long ZLF_WUBAO = new Long(10);

		/**
		 * 其他
		 */
		final Long QT = new Long(-1);
	}

	/**
	 * 审核审批中“操作意见”和“操作结果”
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.OPERATE
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface OPERATE {
		/**
		 * 上报ID
		 */
		final String SHANGBAO_ID = "1";

		/**
		 * 上报名称
		 */
		final String SHANGBAO_NAME = "上报";

		/**
		 * 办结ID
		 */
		final String BANJIE_ID = "2";

		/**
		 * 办结名称
		 */
		final String BANJIE_NAME = "承办结束";

		/**
		 * 退回ID
		 */
		final String TUIHUI_ID = "3";

		/**
		 * 退回名称
		 */
		final String TUIHUI_NAME = "退回";

		/**
		 * 同意ID
		 */
		final String AGREE_ID = "1";

		/**
		 * 同意名称
		 */
		final String AGREE_NAME = "同意";

		/**
		 * 不同意ID
		 */
		final String UNAGREE_ID = "2";

		/**
		 * 不同意名称
		 */
		final String UNAGREE_NAME = "不同意";

		/**
		 * 资源分配ID
		 */
		final String RESOURCE_ID = "3";

		/**
		 * 资源分配名称
		 */
		final String RESOURCE_NAME = "资源分配";

		/**
		 * 开始实施ID
		 */
		final String IMPL_ID = "4";

		/**
		 * 开始实施
		 */
		final String BEGIN_IMPLEMENT = "开始实施";

		/**
		 * 结束实施ID
		 */
		final String END_IMPL_ID = "5";

		/**
		 * 结束实施
		 */
		final String END_IMPLEMENT = "结束实施";

		/**
		 * 退回资源ID
		 */
		final String BACK_IMPL_ID = "6";

		/**
		 * 退回资源
		 */
		final String BACK_IMPLEMENT = "退回资源";
	}

	/**
	 * 各级操作意见类型
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.OPERATE_EVENT
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface OPERATE_EVENT {
		/**
		 * 申请登记
		 */
		final String SQDJ = "申请登记";

		/**
		 * 小组评议
		 */
		final String XZPY = "小组评议";

		/**
		 * 社区公示
		 */
		final String SQGS = "社区公示";

		/**
		 * 申请意见
		 */
		final String SQYJ = "申请意见";

		/**
		 * 社保所受理
		 */
		final String SBSSL = "社保所（受理）";

		/**
		 * 街道（审核）
		 */
		final String JDSH = "街道（审核）";

		/**
		 * 区级（审批）
		 */
		final String QXSP = "区级（审批）";

		/**
		 * 资源分配
		 */
		final String ZYFP = "市民政 (资源分配)";

		/**
		 * 开始实施
		 */
		final String IMPL = "街道 (开始实施)";

		/**
		 * 结束实施
		 */
		final String END_IMPL = "街道 (实施完成)";

		/**
		 * 退回资源
		 */
		final String BACK_IMPL = "街道 (退回资源)";
	}

	/**
	 * 救济状态
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.FAMILY_STATE
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface FAMILY_STATE {
		/**
		 * 新入保
		 */
		final Byte NEW_IN = new Byte(new Long(3).byteValue());

		/**
		 * 停救到救济
		 */
		final Byte STOP_IN = new Byte(new Long(4).byteValue());

		/**
		 * 停保
		 */
		final Byte STOP = new Byte(new Long(5).byteValue());

		/**
		 * 持续救济
		 */
		final Byte GO_ON = new Byte(new Long(6).byteValue());

		/**
		 * 从未救济
		 */
		final Byte NEVER_IN = Byte.valueOf("1");

		/**
		 * 二次申请到救济
		 */
		final Byte RENEW_IN = Byte.valueOf("7");
	}

	/**
	 * 审核审批权限
	 */
	public static interface RIGHTS {
		/**
		 * 审核审批
		 */
		final String APPROVE = "101";

		/**
		 * 签字盖章
		 */
		final String DECISION = "104";
	}

	/**
	 * 资金发放执行日期
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.EXECUTE_DATE
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.120 2008/03/17 08:36:23 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface EXECUTE_DATE {
		/**
		 * 自然月
		 */
		final Byte NATURE_MONTH = Byte.valueOf("1");

		/**
		 * 特殊月
		 */
		final Byte SPECIAL_MONTH = Byte.valueOf("2");

		/**
		 * 计算本月执行（下月执行）日期
		 */
		final int DIV_DAY = 25;
	}

	/**
	 * 审批单元
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.MEMBER_STATUS_CATEGORY
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface CELL_TYPE {
		// 城市
		final Long CITY = new Long(2740);
		// 农村
		final Long COUNTRY = new Long(2741);
		// 五保
		final Long WUBAO = new Long(2748);
	}

	/**
	 * 查询范围
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.MEMBER_STATUS_CATEGORY
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface SEARCH_TYPE {
		// 救助家庭
		final Long FAMILY = new Long(2761);

		// 救助成员
		final Long MEMBER = new Long(2762);
	}

	/**
	 * 享受状态
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.MEMBER_STATUS_CATEGORY
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface SALVAGE_STATUS {
		// 正在享受救助
		final Long SALVAGE = new Long(2764);

		// 停止救助
		final Long STOP = new Long(2765);
	}

	/**
	 * 资金发放方式
	 * 
	 * @author ll
	 * 
	 */
	public static interface MONEY_TYPE {
		/**
		 * 分散银行
		 */
		final long DECENTRALIZATION_BANK = 2506;

		/**
		 * 分散手工
		 */
		final long DECENTRALIZATION_MAN = 2507;

		/**
		 * 集中银行
		 */
		final long CENTRALIZE_BANK = 2508;
	}

	/**
	 * 邮箱类型
	 * 
	 * @author ll
	 * 
	 */
	public static interface EMAIL_TYPE {
		/**
		 * 邮箱后缀
		 */
		final long DECENTRALIZATION_BANK = 2794;
	}

	/**
	 * 邮箱收件类型
	 * 
	 * @author ll
	 * 
	 */
	public static interface EMAIL_INBOX_TYPE {

		/**
		 * 邮箱收件类型
		 */
		final long ADDRESSER_TYPE = 2796;

		/**
		 * 邮箱抄送类型
		 */
		final long COPY_TYPE = 2977;

		/**
		 * 邮箱暗送类型
		 */
		final long MAKE_TYPE = 2978;
	}

	/**
	 * 身体状态
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.BODY_STATE
	 * @author <a href="mailto:liuyan@topsuntech.com">LiuYan</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface BODY_STATE {
		final Long HEALTHINESS = new Long(2571);

		final Long LOW_GRADE_DEFORMITY = new Long(2572);

		final Long HIGH_GRADE_DEFORMITY = new Long(2573);
	}

	/**
	 * 机构类型
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.DEPT_TYPE
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.102 2007/12/22 05:59:35 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface DEPT_TYPE {
		/**
		 * 民政科
		 */
		final String MZK = "3001";

		/**
		 * 社保所
		 */
		final String SBS = "3002";

		/**
		 * 社救科
		 */
		final String SJK = "2001";
	}

	/**
	 * 成员表中的生活照顾
	 */
	public static interface LIFE_CARE {
		/**
		 * 集中供养
		 */
		final Long COLLECT_SUPPORT = new Long(297);

		/**
		 * 分散供养
		 */
		final Long DETRACT_SUPPORT = new Long(298);
	}

	/**
	 * 五保供养方式
	 */
	public static interface FEND_FASHION {
		/**
		 * 集中供养
		 */
		final long COLLECT_SUPPORT = 2980;

		/**
		 * 分散供养
		 */
		final long DETRACT_SUPPORT = 2981;
	}

	/**
	 * 就业状态
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.MEMBER_WORK_STATE
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.120 2008/03/17 08:36:23 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface MEMBER_WORK_STATE {
		/**
		 * 未就业
		 */
		final Long NOT_WORK = new Long(340);
	}

	/**
	 * 劳动能力
	 * 
	 * <p>
	 * <a href="Constants.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.MEMBER_WORK_ABILITY
	 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
	 * @since 1.0
	 * @version $Id: Constants.java,v 1.120 2008/03/17 08:36:23 antingting Exp
	 *          $Revision: 1.1 $
	 * 
	 */
	public static interface MEMBER_WORK_ABILITY {
		/**
		 * 无劳动能力
		 */
		final Long NO_WORK_ABILITY = new Long(221);
	}


	/**
	 * 申请状态
	 * 
	 * @author zcpeng
	 * 
	 */
	public static interface SQZT {
		// 正在申请
		final Long APPLY = new Long(5821);
		// 正在公示
		final Long PUBLICITY = new Long(5822);
		// 公示期满
		final Long AFTER_PUBLICITY = new Long(5823);
		// 街道审核不同意
		final Long STREET_DISAGREE = new Long(5824);
		// 审批状态
		final Long APPROVAL = new Long(5825);
		// 上报退回
		final Long REPORT_BACK = new Long(5826);
		// 办理结束
		final Long APPROVAL_END = new Long(5827);
		// 街道退回结束
		final Long STREET_BACK_END = new Long(5860);
	}

	/**
	 * 事项办理状态
	 * 
	 * @author zcpeng
	 * 
	 */
	public static interface SXBLZT {
		// 受理状态
		final Long ACCEPT = new Long(5834);
		// 审批状态
		final Long APPROVAL = new Long(5840);
		// 区级审批
		final Long DISTRICT_APPROVAL = new Long(5829);
		// 区级退回
		final Long DISTRICT_BACK = new Long(5830);
		// 街道退回上报
		final Long STREET_BACK_REPORT = new Long(5831);
		// 街道不同意
		final Long STREET_DISAGREE = new Long(5832);
		// 办理结束
		final Long APPROVAL_END = new Long(5833);
	}

	/**
	 * 审核审批步骤[低保使用]
	 * 
	 * <p>
	 * <a href="ConstantsDsr.java.html">View Source</a>
	 * </p>
	 * 
	 * @see com.topsuntech.gUnit.gEU_util.tools.OPERATE_STEP
	 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
	 * @since 1.0
	 * @version $Id: ConstantsDsr.java,v 1.7 2009/04/14 09:00:44 pengzuocong Exp
	 *          $Revision: 1.7 $
	 * 
	 */
	public interface OPERATE_STEP {

		/**
		 * 街道（审核）
		 */
		static final String JDSH = "街道（审核）";

		/**
		 * 区县（审批）
		 */
		static final String QXSP = "区县（审批）";

		/**
		 * 无流程的情况下，一步完成
		 */
		static final String ONE_STEP = "详细意见";
	}
	
	/**
	 * 显示的页面是否可操作<br>
	 * 
	 * @author pgc
	 *
	 */
	public interface PAGE_CAN_OPERATE {
		/** 可以操作 */
		static final String yes="yes";
		/** 只读 */
		static final String no="no";
		/** 不可以打开*/
		static final String not="not";
		/** 隐藏*/
		static final String yinCang="yinCang";
	}
	
	/**
	 * 公示天数<br>
	 * 
	 * @author pgc
	 *
	 */
	public interface PUBLIC_TIME {
		 
		/** 7天*/
		static final Long day7=new Long(6);
	}
	
	
	/**
	 * 显示的页面是否可操作<br>
	 * 
	 * @author pgc
	 *
	 */
	public interface VERIFY_DEAD_INFO {
		/** 符合 */
		static final Long fuHe=new Long(5884);
		/** 不符合 */
		static final Long buFuHe=new Long(5885);
		/** 验证信息不存在*/
		static final Long buCunZai=new Long(5886);
	}
	
}
