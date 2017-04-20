package com.topsuntech.gUnit.gEU_util.tools;

import java.util.HashMap;
import java.util.Map;

public class SJConstants {
	//报销
	public static final long PROJECT_BAOXIAO = 704;
	
	//垫付
	public static final long PROJECT_DIANFU = 2385;

	// 项目分类
	public static final long PROJECT_SORT = 2301;

	// 项目流程
	public static final long PROJECT_PROCESS = 2592;

	// 项目类型
	public static final long PROJECT_TYPE = 2588;

	// 资源类型根节点
	public static final long RESOURCE_TYPE_ROOT_ID = 2324;

	// 社区根节点
	public static final long COMMUNITY_ROOT_ID = 5081;

	// 资源使用标准节点
	public static final long RESOURCE_USE_STANDARD = 3020;

	// 专项救助的救助分类根节点
	public static final long ZX_SALVAGE_TYPE_ID = 4095;
	
	// 临时救助的救助分类根节点
	public static final long LS_SALVAGE_TYPE_ID = 4160;

	/**
	 * added by pengzuocong
	 */
	// 资助城市无医疗保障特困老人参加城市居民基本医疗保险
	public static final long GRANTS_CITY_DIFF_SECURITY = 741;

	// 资助城市无医疗保障特困学生儿童参加城市居民基本医疗保险
	public static final long GRANTS_CITY_DIFF_OLD_CHILD = 743;

	// 资助城市就业年龄段内无医疗保障特困人员参加城市居民基本医疗保险
	public static final long GRANTS_CITY_DIFF_OLD = 744;

	// 资助城市特困人员参加医疗保险(全部)
	// public static final long GRANTS_CITY_DIFF_ALL = 761;
	//
	// // 资助农村特困人员参加医疗保险(年龄段内无生活保障)
	// public static final long GRANTS_RURAL_DIFF_SECURITY = 742;
	//
	// // 资助农村特困人员参加医疗保险(一老一小)
	// public static final long GRANTS_RURAL_DIFF_OLD_CHILD = 764;
	//
	// // 资助农村特困人员参加医疗保险(老人)
	// public static final long GRANTS_RURAL_DIFF_OLD = 763;

	// 资助农村特困人员参加新型农村合作医疗
	public static final long GRANTS_RURAL_DIFF_ALL = 762;

	// 民政局"医疗救助"项目
	public static final long MEDICAL_AID = 4096;

	// 民政局"教育救助"项目
	public static final long EDUCATION_AID = 4097;

	// 民政局项目标识
	public static final long DEPT_MINZHENG = 28838;

	// 申请发放
	public static final long APPLY_FOR = 4127;

	// 批量发放
	public static final long BATCH_FOR = 4128;

	// 一次公示
	public static final long PUBLICITY_ONCE = 4104;

	// 二次公示
	public static final long PUBLICITY_TWICE = 4105;

	// 不公示
	public static final long PUBLICITY_NO = 4106;

	/**
	 * 救助项目ID
	 */
	// 城市特困人员门诊(慢性病)医疗救助
	public final static long CITY_POVERTY_OUT_PATIENT = 705;
	
	public final static long CITY_POVERTY_OUT_PATIENT_DF = 2386;

	// 城市特困人员住院(危重病)医疗救助
	public final static long CITY_POVERTY_HOSPITAL = 706;
	
	public final static long CITY_POVERTY_HOSPITAL_DF = 2387;

	// 农村特困人员门诊(慢性病)医疗救助
	public final static long RURAL_POVERTY_OUT_PATINENT = 721;
	
	public final static long RURAL_POVERTY_OUT_PATINENT_DF = 2388;

	// 农村特困人员住院(危重病)医疗救助
	public final static long RURAL_POVERTY_HOSPITAL = 723;
	
	public final static long RURAL_POVERTY_HOSPITAL_DF = 2405;

	// 贫困孕产妇孕期检查救助
	public final static long POVERTY_PREGNANT_WOMEN_INSPECTION = 724;
	
	public final static long POVERTY_PREGNANT_WOMEN_INSPECTION_DF = 2406;

	// 贫困孕产妇住院分娩救助
	public final static long POVERTY_PREGNANT_WOMEN_HOSPITAL = 725;
	
	public final static long POVERTY_PREGNANT_WOMEN_HOSPITAL_DF = 2407;

	// 申请标识
	public final static long APPLICATIONS_FLAG = 0;

	// 审批标识
	public final static long PERMISSION_FLAG = 1;

	/**
	 * 常量名称
	 */

	// 资金
	public final static String MONEY_NAME = "资金";

	// 实物
	public final static String MATTER_NAME = "实物";

	// 救助服务
	public final static String SALVAGE_SERVICE_NAME = "救助服务";

	// 救助服务单位:元
	public final static long DOLLAR_ID = 2503;

	public final static String DOLLAR_NAME = "元";

	// 救助服务单位:次
	public final static long DIMENSION_ID = 6475;

	public final static String DIMENSION_NAME = "次";

	// //项目树
	// public final static long PROJECT_NODE = 10000;
	// 是
	public final static String YES = "1";

	// 否
	public final static String NO = "0";

	// 数据采集
	public final static long SALVAGE_STATE_ACQUISITION = 0;

	// 正在公示
	public final static long SALVAGE_STATE_SHOWING = 1;

	// 公示期满
	public final static long SALVAGE_STATE_OVER = 2;

	// 公示不通过
	public final static long SALVAGE_STATE_FAIL = 3;

	// 公示通过
	public final static long SALVAGE_STATE_PASS = 4;

	// 填写意见
	public final static long SALVAGE_STATE_INTRO = 5;

	// 上报退回
	public final static long SALVAGE_STATE_BACK = 6;

	// 签字盖章
	public final static long SALVAGE_STATE_WRITE = 7;
	
	//正在申请
	public final static long SALVAGE_STATE_APPLYING = 8;
	
	//正在审核
	public final static long SALVAGE_STATE_AUDITING = 9;

	// test 1显示<输入意见>，0不显示<输入意见>
	public final static String APPLY_SHOW = "0";

	/**
	 * 数据字典对应值
	 */

	// 使用标准
	public final static long USE_STANDARD = 3020;

	// 资源分类
	public final static long SOURCE_TYPE = 2324;

	// 单位
	public final static long SOURCE_UNIT = 2476;

	// 资金
	public final static long MONEY = 2325;

	// 实物
	public final static long MATTER = 2326;

	// 救助服务
	public final static long SALVAGE_SERVICE = 2327;

	// 救助类别
	public final static long SALVAGE_CATEGORY = 2588;

	// 身份类别
	public final static long STATUS_CATEGORY = 2985;

	// 户主关系
	public final static long HOUSEHOLD_HEAD_RELATION = 6;

	// 与户主关系为本人
	public final static long HOUSEHOLD_HEAD_VALUE = 7;

	// 审批流程
	public final static long APPROVES_FLOW = 5207;

	// 家庭户籍类型
	public final static long HOUSEHOLD_REGISTER_TYPE = 635;

	// 户籍性质
	public final static long HOUSEHOLD_REGISTER_NATURE = 3309;

	// 人员性质
	public final static long PEOPLE_NATURE = 3244;

	// 身体状况
	public final static long BODY_CONDITION = 2570;

	// 数据委托：下放
	public final static long DOWN_RIGHT = 6573;

	// 数据委托：收回
	public final static long CALLBACK_RIGHT = 6574;

	// 其它
	public final static long OTHER = 2825;

	// 发放依据:连续性
	public interface sendAccrdance {
		// 一般性
		final static long GENERAL = 6715;

		// 连续性
		final static long CONTINUE = 6716;
	}

	/**
	 * 组织机构对应值
	 */

	// 领导小组
	public final static long NODE_GUIDANCE = 2474;

	// 委办局
	public final static long ENTRUST_BUREAU = 2331;

	// 街道
	public final static long STREET = 2333;

	// 饼图
	public static final String PIE_DIAGRAM = "pie";

	// 柱图
	public static final String BAR_DIAGRAM = "bar";

	// 性别：男
	public static final long SEX_MAN = 119;

	// 性别：女
	public static final long SEX_WOMAN = 120;

	// 是
	public static final long Dict_YES = 2205;

	// 否
	public static final long Dict_NO = 2206;

	// 救助类别
	public interface SalvageType {
		/**
		 * 法定救助
		 */
		static final long LAW = 2589;

		/**
		 * 非法定救助(财政拨款)
		 */
		static final long NOTLOW_FINANCE = 2590;

		/**
		 * 非法定救助(社会互助)
		 */
		static final long NOTLOW_SOCIAL = 2591;
	}

	// 救助定义
	public interface SalvageDefine {
		/**
		 * 救助项目
		 */
		static final long PROJECT = 3407;

		/**
		 * 救助活动
		 */
		static final long ACTIVITY = 3408;
	}

	// 救助活动
	public interface salvageActivity {
		static final long ID = 100000;

		static final String NAME = "走访活动";
	}

	// 启用:救助原则
	public static final long RULE = 1;

	// 启用：原则一（按家庭：0；按个人：1）
	public static final long RULE_ONE = 0;

	// 启用：原则二（已经在享受的项目，在本年度，不能再申请）
	public static final long RULE_TWO = 1;

	// 启用：原则三（法定与非法定，两者只能选一）
	public static final long RULE_THREE = 0;

	// 启用：原则四（按'项目的资源'的多少，优先排序）
	public static final long RULE_FOUR = 1;

	// 启用：原则五（优先排序'市级项目'）
	public static final long RULE_FIVE = 1;

	// 启用：原则六（过滤正在办理的项目）
	public static final long RULE_SIX = 1;

	// 数据锁定状态
	public interface dataLock {
		// 家庭变更: 正常
		static final long NORMAL = 3394;

		// 家庭变更: 修改锁定
		static final long UPDATE = 3395;

		// 家庭变更: 申请锁定
		static final long APPLY = 3396;

		// 家庭变更: 初审上报
		static final long FIRST = 3397;

		// 家庭变更: 复审结束
		static final long END = 3398;
	}

	// 家庭：选择方式:户籍家庭
	public static final long FAMILY = 3406;

	// 家庭：选择方式:实际家庭
	public static final long FACT_FAMILY = 3407;

	// 统计方式：6727 全区
	public static final long STAT_CONDITION_FULL = 6727;

	// 统计方式：6728 单位
	public static final long STAT_CONDITION_UNIT = 6728;

	// 统计方式：1 单位
	public static final long STAT_CONDITION_PROJ = 6729;

	// 定期定量：救助状态
	public interface RegularSalvageStatus {
		// 救助
		static final long SALVAGE = 6734;

		// 停救
		static final long STOP = 6735;

		// 续期
		static final long CONTINUE = 6736;
	}

	// 定期定量：事项执行状态
	public interface RegularCaseDoStatus {
		// 待上报
		static final long WAIT_SEND = 6742;

		// 待审核
		static final long WAIT_CHECK = 6743;

		// 待实施
		static final long WAIT_APPLY = 6744;

		// 正在实施
		static final long NOW_APPLY = 6745;

		// 已完成
		static final long CASE_END = 6764;
	}

	// 定期定量：事项结果状态
	public interface RegularCaseResultStatus {
		// 上报
		static final long SEND = 6758;

		// 救助
		static final long SALVAGE = 6759;

		// 停救
		static final long STOP_SALVAGE = 6760;

		// 开始实施
		static final long BEGIN_APPLY = 6761;

		// 发放退回
		static final long SALVAGE_CANCLE = 6762;

		// 实施完成
		static final long END_APPLY = 6763;
	}

	// 发放方式
	public interface SendType {
		// 按月发放
		static final long MONTH = 6711;

		// 按季发放
		static final long QUARTER = 6712;
	}

	// 停保
	public static final long STOP_FAMILY_FLAG = 5;

	// *****选择家庭
	// 低保家庭
	public static final long CHOOSE_LOW_FAMILY = 3400;

	// 非低保家庭
	public static final long CHOOSE_NOT_LOW_FAMILY = 3401;

	// *****选择范围
	// 本单位创建
	public static final long CHOOSE_BOUND_OWN = 3403;

	// 外单位创建
	public static final long CHOOSE_BOUND_OUT = 3404;

	// 身份类别：低保对象
	public static final long statusType = 5185;

	// 查询区域
	public interface QueryRegion {
		// 区域
		static final String REGION = "reg";

		// 机构
		static final String DEPT = "org";
	}

	/*
	 * 区域与机构映射关系：通过区域ID返回对应的机构ID
	 */
	public static Map RegDptRelation() {
		Map m = new HashMap();

		m.put("475", "38391");
		m.put("4", "38376");
		m.put("463", "38376");
		m.put("468", "38380");
		m.put("461", "38384");
		m.put("469", "38378");
		m.put("468", "38385");
		m.put("301", "38377");
		m.put("8", "38375");
		m.put("473", "38389");
		m.put("470", "38386");
		m.put("472", "38388");
		m.put("471", "38387");
		m.put("467", "38383");
		m.put("476", "38392");
		m.put("466", "38382");
		m.put("462", "38379");
		m.put("464", "38381");
		m.put("474", "38390");

		return m;
	}

	// 委办局区县节点值
	public interface WbjNode {
		// 委办局
		static final long WBJ = 38373;

		// 市委办局
		static final long SJ_WBJ = 37333;

		// 区委办局
		static final long QJ_WBJ = 38374;
		
		//街道
		static final long STREECT = 37337;
		

		// 海淀区
		static final long HD = 38375;

		// 朝阳区
		static final long QY = 38376;

		// 丰台区
		static final long FW = 38377;

		// 东城区
		static final long DC = 38378;

		// 西城区
		static final long XC = 38379;

		// 崇文区
		static final long CW = 38380;

		// 门头沟区
		static final long WT = 38386;

		// 房山区
		static final long FS = 38385;

		// 大兴区
		static final long DX = 38384;

		// 石景山区
		static final long ST = 38383;

		// 通州区
		static final long TZ = 38382;

		// 宣武区
		static final long XW = 38381;

		// 顺义区
		static final long SY = 38392;

		// 昌平区
		static final long CP = 38391;

		// 延庆区
		static final long YQ = 38390;

		// 怀柔区
		static final long HR = 38389;

		// 密云区
		static final long MY = 38388;

		// 平谷区
		static final long PG = 38387;
	}

	// 信息状态：1，可用；0，停用
	public interface userFlag {
		// 可用
		final static long CANBEUSE = 6790;

		// 停用
		final static long CANNOTBEUSE = 6791;
	}

	// 树节点
	public interface treeNode {
		static long root = -1;
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

	// 本人
	public static final long SELF = 7;

	// 资金管理类型
	public interface moneyexecutetype {
		// 批复资金录入
		final static String pfzj = "4150";

		// 救助资金追加
		final static String zjzj = "4151";

		// 市级资金拨付
		final static String sjbf = "4154";

		// 区县捐助资金 +
		final static String qxjz = "4152";

		// 市级捐助资金 +
		final static String sjjz = "4158";

		// 彩票公益金

		final static String cpgyz = "5025";

		// 调集转移
		final static String tjzy = "4153";

		// 资金调剂接收
		final static String tjjs = "4175";

		// 临时救助资金
		final static String lsjzzj = "4159";

		// 医疗救助
		final static String yljz = "4096";

		// 教育救助
		final static String jyjz = "4097";

		// 生活补助
		final static String shjz = "4098";

		// 住房救助
		final static String zfjz = "4099";

		// 就业救助
		final static String jobjz = "4100";

		// 司法援助
		final static String sfjz = "4101";

		// 交通救助
		final static String jtjz = "4102";

		// 区县民政局
		final static String qsmz = "4143";

	}

	// 库存操作类型
	public interface stockOperateType {
		// 金额增加
		final static long jezj = 1;

		// 金额减少
		final static long jejs = 2;

	}

	// 资金种类
	public interface stockShowType {
		// 实列资金
		final static long show_sjzj = 1;

		// 捐赠资金
		final static long show_jzzj = 2;

		// 调剂资金
		final static long show_tjzj = 3;

	}
    
    //字典类型
    public interface dictType{
        //基本生活
        final static long jbsh = 1;
        //农村五保
        final static long lcwb = 2;
        //市本级
        final static long sbj = 3;
        //北京社救
        final static long bjsj = 4;
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
    
   

}