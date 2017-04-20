/**
 * �������ϵͳ��ҵ����<br>
 */
package com.topsuntech.gUnit.gEU_bzhhUtil.tools;

/**
 * �½��ֵ�������������
 * 
 * @author zcpeng
 * 
 */
public class TjbzConstants {
	/**
	 * ����״̬
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
		// δ�ȼ�
		final long NO_SALVAGE_TYPE = 147;
	}

	/**
	 * �жϱ�ʶ���ǣ���
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
		// ��
		final long YES = 2205;

		// ��
		final long NO = 2206;
	}

	public static interface INSURANCE_FLAG {
		// �μӱ�����Ա
		final long INSURANCE = 572;
	}

	/**
	 * ����������������еĲ�ͬ���͵Ĳ���
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
		 * �ϱ�������
		 */
		final int SHENPI = 1;

		/**
		 * ��ˡ��а�
		 */
		final int CHENGBAN = 2;

		/**
		 * ����
		 */
		final int CACHE = 3;
	}

	public static interface FAMILY_WORK_CONFIGURATION {
		/**
		 * ����ְ
		 */
		final int NO_WORKER = 1167;

		/**
		 * ��ְ��
		 */
		final int ONE_WORKER = 1168;

		/**
		 * ˫ְ��
		 */
		final int TWO_WORKER = 1169;

		/**
		 * ������Ա
		 */
		final int DIMISSION = 1171;

		/**
		 * ������Ա
		 */
		final int RETIRE = 1172;
	}

	public static interface FAMILY_TYPE {
		/**
		 * ����ְ��Ա��ͥ
		 */
		final int HAVE_WORKER = 1174;

		/**
		 * ����ְ��Ա��ͥ
		 */
		final int NO_WORKER = 1175;
	}

	public static interface HOUSEHOLD_RELATION {
		/**
		 * ����
		 */
		final int HOUSEHOLD = 7;

		/**
		 * ĸ��
		 */
		final int MOTHER = 10;

		/**
		 * �游
		 */
		final int ZUFU = 13;

		/**
		 * ���游
		 */
		final int WAIZUFU = 14;

		/**
		 * ��ĸ
		 */
		final int ZUMU = 22;

		/**
		 * ����ĸ
		 */
		final int WAIZUMU = 21;

		/**
		 * ��Ů
		 */
		final int ZINV = 18;

		/**
		 * ����Ů
		 */
		final int SUNZINV = 15;

		/**
		 * ������Ů
		 */
		final int WAISUNZINV = 8;

		/**
		 * ��ż
		 */
		final int CONSORT = 17;

		/**
		 * �ֵ�
		 */
		final int BROTHER = 11;

		/**
		 * ����
		 */
		final int SISTER = 12;

		/**
		 * ����
		 */
		final int BROTHER_AND_SISTER = 19;

		/**
		 * ���
		 */
		final int SISTER_AND_BROTHER = 20;

		/**
		 * ����
		 */
		final int FATHER = 16;

		/**
		 * ������Ա
		 */
		final int OTHER_PEOPLE = 9;
	}

	public static interface MEMBER_STATUS {
		/**
		 * ����
		 */
		final int NATURAL = 1236;

		/**
		 * ����
		 */
		final int DIE = 1237;

		/**
		 * ʧ��
		 */
		final int DISAPPEARANCE = 1238;

		/**
		 * ���̼�������Ա
		 */
		final int SERVE_SENTENCE = 2606;

		/**
		 * ������
		 */
		final int JOIN_UP = 4063;
	}



	/**
	 * �ͱ���׼
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
		 * ũ���屣������׼ added by pengzuocong 2008-6-3
		 */
		final int COUNTY_WB_STANDARD = 4193;
		/**
		 * �������ϱ�׼
		 */
		final int LOWEST_ENSURE_STANDARD = 529;

		/**
		 * ��͹��ʱ�׼
		 */
		final int MINIMUM_WAGE_STANDARD = 530;

		/**
		 * �¸�ְ���������׼
		 */
		final int UNEMPLOYED_WAGE_STANDARD = 531;

		/**
		 * �����ݽ��׼
		 */
		final int RETIRE_WAGE_STANDARD = 532;

		/**
		 * ʧҵ���ս��׼
		 */
		final int UNEMPLOYED_INSURANCE_STANDARD = 533;

		/**
		 * ���Ͱ���������׼
		 */
		final int FOOD_OIL = 2559;
	}

	public static interface TRANSACT_INSTANCE {

		/**
		 * ����Ǩ����
		 */
		final byte START_MOVE_OUT = 1;

		/**
		 * ����Ǩ����
		 */
		final byte SEND_MOVE_OUT = 2;

		/**
		 * ����Ǩ��
		 */
		final byte ACCEPT_MOVE_IN = 3;
	}

	public static interface ENJOY_TYPE {
		/**
		 * ���еͱ���׼
		 */
		final int CITY_STANDARD = 186;

		/**
		 * ũ��ͱ���׼
		 */
		final int COUNTRY_STANDARD = 187;

		/**
		 * ���Ͱ�����׼
		 */
		final Long LY_STANDARD = new Long(2559);

		/**
		 * �������ñ�׼
		 */
		final Long OTHER_STANDARD = new Long(2779);

		/**
		 * ͳս��׼
		 */
		final Long TZ_STANDARD = new Long(2561);

		/**
		 * ���Ϸ��ñ�׼
		 */
		final Long CARE_STANDARD = new Long(2562);
	}

	/**
	 * �Ա�
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
		 * ����
		 */
		final int MALE = 119;

		/**
		 * Ů��
		 */
		final int FMALE = 120;
	}

	/**
	 * ��������
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
	 * �����ͥ�ṹ
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
		 * �ϲ�һ��
		 */
		final int LCYT = 2053;

		/**
		 * ��
		 */
		final int FOU = 2054;

		/**
		 * һ�����
		 */
		final int YHDC = 2055;
	}

	/**
	 * ��׼���÷�Χ
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
		 * �����б�׼
		 */
		final Long COUNTYS_CITY_STANDARD = new Long(564);

		/**
		 * ��ũ���׼
		 */
		final Long COUNTYS_COUNTRY_STANDARD = new Long(565);

		/**
		 * ��ͳһ��׼
		 */
		final Long CITYS_UNITE_STANDARD = new Long(566);

		/**
		 * �г��б�׼
		 */
		final Long CITYS_CITY_STANDARD = new Long(567);

		/**
		 * ��ũ���׼
		 */
		final Long CITYS_COUNTRY_STANDARD = new Long(568);

		/**
		 * ��ͳһ��׼
		 */
		final Long COUNTYS_UNITE_STANDARD = new Long(569);

	}

	public static interface MEMBER_REG_TYPE {

		/**
		 * ���з�ũҵ����
		 */
		final Long CITY_TYPE = new Long(194);

		/**
		 * ����ũҵ����
		 */
		final Long COUNTRY_TYPE = new Long(195);
	}

	/**
	 * �����ͱ�ԭ��
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
		 * �ͱ�������ͥ����ԭ��:����
		 */
		final Long MEMBER_DIE_LOW_FAMILY = new Long(2520);

		/**
		 * �屣������ͥ����ԭ��:����
		 */
		final Long MEMBER_DIE_WUBAO_FAMILY = new Long(4072);

		/**
		 * ������Ա����ԭ���У�����
		 */
		final Long MEMBER_DIE = new Long(2790);

		/**
		 * ������Ա����ԭ���У����̼�������Ա
		 */
		final Long SERVE_SENTENCE = new Long(2789);

		/**
		 * ������Ա����ԭ���У���Ա���鵱��
		 */
		final Long JOIN_UP = new Long(4062);

		/**
		 * ������Ա����ԭ���У�ʧ��
		 */
		final Long DISAPPEARANCE = new Long(2791);

		/**
		 * ������ͥ����ԭ���У���ϻ�������
		 */
		final Long UNION_CONCEL = new Long(2792);

		/**
		 * ������ͥ����ԭ���У���ҵ����
		 */
		final Long WORK_OUT = new Long(2522);
	}

	public static interface MEMBER_ENSURE_APPROVE_TYPE {

		/**
		 * �����ڱ�������
		 */
		final Long APPROVE = new Long(209);

		/**
		 * �������ڱ�������
		 */
		final Long NO_APPROVE = new Long(210);
	}

	/**
	 * ���ڱ��������ԭ��
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
		 * ��ǻ�ӣ���ũ��ͱ��������л��ڲ��ڱ�������
		 */
		final Long COUNTRY_ACCEPT = new Long(2314);

		/**
		 * ��ǻ�ӣ��Գ��еͱ�����ũ�廧�ڲ��ڱ�������
		 */
		final Long CITY_ACCEPT = new Long(2684);

		/**
		 * ��������
		 */
		final Long CANCEL_DEAL_MEMBER = new Long(2685);

		/**
		 * �������Ѳ�����ͥ
		 */
		final Long SHKN = new Long(2313);
	}

	public static interface FAMILY_DOMICILIARY_TYPE {
		/**
		 * ����
		 */
		final long CITY = 3;

		/**
		 * ũ��
		 */
		final long COUNTRY = 2;

		/**
		 * ��������
		 */
		final long CITY_COUNTRY = 4;

		/**
		 * ��ǻ����
		 */
		final long COUNTRY_CITY = 5;
	}

	public static interface HOUSEHOLD_REGISTER_NATURE {
		/**
		 * ���з�ũҵ����
		 */
		final Long CITY = new Long(194);

		/**
		 * ����ũҵ����
		 */
		final Long COUNTRY = new Long(195);

		/**
		 * С���򻧿�
		 */
		final Long XIAOCHENGZHEN = new Long(196);

		/**
		 * �޻���
		 */
		final Long WUHUKOU = new Long(197);

		/**
		 * �Ⲻ��ũҵ����
		 */
		final Long WAIHU_CITY = new Long(189);

		/**
		 * �Ⲻũҵ����
		 */
		final Long WAIHU_COUNTRY = new Long(190);

		/**
		 * ���й����յľ�����Ա
		 */
		final Long JINGWAIRENYUAN = new Long(2721);

		/**
		 * ����
		 */
		final Long HUAQIAO = new Long(193);
	}

	/**
	 * ��������
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
		 * ����
		 */
		final long WAGE = 424;

		/**
		 * ��������
		 */
		final long OTHER_INCOME = 2300;
	}

	/**
	 * Ԥ������
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
		 * ����ʧ��Ԥ��
		 */
		final Long ADJUST_ERROR_WARN = new Long(1);
		/**
		 * �ȴ�Ǩ���ȷ��
		 */
		final Long CHANGE_IN = new Long(200);

		/**
		 * ��ǻ�Ӹ���Ԥ��
		 */
		final Long NEW_APPLY = new Long(240);

		/**
		 * Ǩ�����ȷ��Ǩ��
		 */
		final Long CHANGE_IN_CONFIRM = new Long(2);

		/**
		 * Ǩ��ɹ�(����)
		 */
		final Long CHANGE_IN_SUCCESS = new Long(339);

		/**
		 * Ǩ��ɹ�(����)
		 */
		final Long CHANGE_IN_SUCCESS_DIFFERENT_COUNTY = new Long(1341);

		/**
		 * ����Ǩ��ȷ��
		 */
		final Long CHANGE_SAME_COUNTY = new Long(360);

		/**
		 * ��ǻ�ӳ�������Ԥ��
		 */
		final Long COUNTY_CITY_STOP = new Long(420);

		/**
		 * �屣ǩ��Э��Ԥ��
		 */
		final Long WUBAO = new Long(900);

		/**
		 * ��ʾ����Ԥ��
		 */
		final Long PUBLIC = new Long(1040);

		/**
		 * ���Ƴ�Աʧҵ���ս�
		 */
		final Long SHIYEBAOXIANJIN = new Long(1060);

		/**
		 * ���Ƴ�Աѧ����Ϣ
		 */
		final Long XUESHENGXINXI = new Long(1061);

		/**
		 * �淶�����֤����
		 */
		final Long GUIFANHUASHENFENZHENGHAO = new Long(1062);

		/**
		 * ���Ƽ�ͥס����Ϣ
		 */
		final Long ZHUFANGXINXI = new Long(1063);

		/**
		 * ��ϵͳ���ߵͱ���������
		 */
		final Long SHUJUWANSHAN = new Long(1080);

		/**
		 * 15��ǰǨ���δ��Ǩ��ȷ��
		 */
		final Long QIANRUDIWEIZUOQIANRUQUEREN = new Long(1121);

		/**
		 * �ʽ𷢷�Ԥ��
		 */
		final Long FUND_SEND_WARN = new Long(362);
	}

	/**
	 * �������˹�ϵ
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
		 * ����
		 */
		final Long BEN_REN = new Long(7);

		/**
		 * ��ż
		 */
		final Long SPOUSES = new Long(17);
	}

	/**
	 * ��Ŀ����
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
		 * �ͱ�
		 */
		final Long DIBAO = new Long(2302);
	}

	/**
	 * Ԥ����������
	 * 
	 * @author jiangtao
	 */
	public static interface WARN_LISTENER {

		// ����(1��������0���ر�)
		final int ON_OFF = 1;

		// Ԥ����ʱʱ��
		final String WARN_TIME = "23:00:00";
	}

	/**
	 * ������ʽ
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
		 * ������������
		 */
		final Long CITY_LIFE = new Long(1);

		/**
		 * ũ����������
		 */
		final Long COUNTRY_LIFE = new Long(2);

		/**
		 * �����������Ѳ���
		 */
		final Long CITY_DIF = new Long(3);

		/**
		 * ũ���������Ѳ���
		 */
		final Long COUNTRY_DIF = new Long(4);

		/**
		 * ũ���屣
		 */
		final Long COUNTY_WUBAO = new Long(5);

		/**
		 * ���Ͱ���
		 */
		final Long FOOD_OIL = new Long(6);

		/**
		 * ���Ϸ�
		 */
		final Long ZLF_WUBAO = new Long(10);

		/**
		 * ����
		 */
		final Long QT = new Long(-1);
	}

	/**
	 * ��������С�����������͡����������
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
		 * �ϱ�ID
		 */
		final String SHANGBAO_ID = "1";

		/**
		 * �ϱ�����
		 */
		final String SHANGBAO_NAME = "�ϱ�";

		/**
		 * ���ID
		 */
		final String BANJIE_ID = "2";

		/**
		 * �������
		 */
		final String BANJIE_NAME = "�а����";

		/**
		 * �˻�ID
		 */
		final String TUIHUI_ID = "3";

		/**
		 * �˻�����
		 */
		final String TUIHUI_NAME = "�˻�";

		/**
		 * ͬ��ID
		 */
		final String AGREE_ID = "1";

		/**
		 * ͬ������
		 */
		final String AGREE_NAME = "ͬ��";

		/**
		 * ��ͬ��ID
		 */
		final String UNAGREE_ID = "2";

		/**
		 * ��ͬ������
		 */
		final String UNAGREE_NAME = "��ͬ��";

		/**
		 * ��Դ����ID
		 */
		final String RESOURCE_ID = "3";

		/**
		 * ��Դ��������
		 */
		final String RESOURCE_NAME = "��Դ����";

		/**
		 * ��ʼʵʩID
		 */
		final String IMPL_ID = "4";

		/**
		 * ��ʼʵʩ
		 */
		final String BEGIN_IMPLEMENT = "��ʼʵʩ";

		/**
		 * ����ʵʩID
		 */
		final String END_IMPL_ID = "5";

		/**
		 * ����ʵʩ
		 */
		final String END_IMPLEMENT = "����ʵʩ";

		/**
		 * �˻���ԴID
		 */
		final String BACK_IMPL_ID = "6";

		/**
		 * �˻���Դ
		 */
		final String BACK_IMPLEMENT = "�˻���Դ";
	}

	/**
	 * ���������������
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
		 * ����Ǽ�
		 */
		final String SQDJ = "����Ǽ�";

		/**
		 * С������
		 */
		final String XZPY = "С������";

		/**
		 * ������ʾ
		 */
		final String SQGS = "������ʾ";

		/**
		 * �������
		 */
		final String SQYJ = "�������";

		/**
		 * �籣������
		 */
		final String SBSSL = "�籣��������";

		/**
		 * �ֵ�����ˣ�
		 */
		final String JDSH = "�ֵ�����ˣ�";

		/**
		 * ������������
		 */
		final String QXSP = "������������";

		/**
		 * ��Դ����
		 */
		final String ZYFP = "������ (��Դ����)";

		/**
		 * ��ʼʵʩ
		 */
		final String IMPL = "�ֵ� (��ʼʵʩ)";

		/**
		 * ����ʵʩ
		 */
		final String END_IMPL = "�ֵ� (ʵʩ���)";

		/**
		 * �˻���Դ
		 */
		final String BACK_IMPL = "�ֵ� (�˻���Դ)";
	}

	/**
	 * �ȼ�״̬
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
		 * ���뱣
		 */
		final Byte NEW_IN = new Byte(new Long(3).byteValue());

		/**
		 * ͣ�ȵ��ȼ�
		 */
		final Byte STOP_IN = new Byte(new Long(4).byteValue());

		/**
		 * ͣ��
		 */
		final Byte STOP = new Byte(new Long(5).byteValue());

		/**
		 * �����ȼ�
		 */
		final Byte GO_ON = new Byte(new Long(6).byteValue());

		/**
		 * ��δ�ȼ�
		 */
		final Byte NEVER_IN = Byte.valueOf("1");

		/**
		 * �������뵽�ȼ�
		 */
		final Byte RENEW_IN = Byte.valueOf("7");
	}

	/**
	 * �������Ȩ��
	 */
	public static interface RIGHTS {
		/**
		 * �������
		 */
		final String APPROVE = "101";

		/**
		 * ǩ�ָ���
		 */
		final String DECISION = "104";
	}

	/**
	 * �ʽ𷢷�ִ������
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
		 * ��Ȼ��
		 */
		final Byte NATURE_MONTH = Byte.valueOf("1");

		/**
		 * ������
		 */
		final Byte SPECIAL_MONTH = Byte.valueOf("2");

		/**
		 * ���㱾��ִ�У�����ִ�У�����
		 */
		final int DIV_DAY = 25;
	}

	/**
	 * ������Ԫ
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
		// ����
		final Long CITY = new Long(2740);
		// ũ��
		final Long COUNTRY = new Long(2741);
		// �屣
		final Long WUBAO = new Long(2748);
	}

	/**
	 * ��ѯ��Χ
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
		// ������ͥ
		final Long FAMILY = new Long(2761);

		// ������Ա
		final Long MEMBER = new Long(2762);
	}

	/**
	 * ����״̬
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
		// �������ܾ���
		final Long SALVAGE = new Long(2764);

		// ֹͣ����
		final Long STOP = new Long(2765);
	}

	/**
	 * �ʽ𷢷ŷ�ʽ
	 * 
	 * @author ll
	 * 
	 */
	public static interface MONEY_TYPE {
		/**
		 * ��ɢ����
		 */
		final long DECENTRALIZATION_BANK = 2506;

		/**
		 * ��ɢ�ֹ�
		 */
		final long DECENTRALIZATION_MAN = 2507;

		/**
		 * ��������
		 */
		final long CENTRALIZE_BANK = 2508;
	}

	/**
	 * ��������
	 * 
	 * @author ll
	 * 
	 */
	public static interface EMAIL_TYPE {
		/**
		 * �����׺
		 */
		final long DECENTRALIZATION_BANK = 2794;
	}

	/**
	 * �����ռ�����
	 * 
	 * @author ll
	 * 
	 */
	public static interface EMAIL_INBOX_TYPE {

		/**
		 * �����ռ�����
		 */
		final long ADDRESSER_TYPE = 2796;

		/**
		 * ���䳭������
		 */
		final long COPY_TYPE = 2977;

		/**
		 * ���䰵������
		 */
		final long MAKE_TYPE = 2978;
	}

	/**
	 * ����״̬
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
	 * ��������
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
		 * ������
		 */
		final String MZK = "3001";

		/**
		 * �籣��
		 */
		final String SBS = "3002";

		/**
		 * ��ȿ�
		 */
		final String SJK = "2001";
	}

	/**
	 * ��Ա���е������չ�
	 */
	public static interface LIFE_CARE {
		/**
		 * ���й���
		 */
		final Long COLLECT_SUPPORT = new Long(297);

		/**
		 * ��ɢ����
		 */
		final Long DETRACT_SUPPORT = new Long(298);
	}

	/**
	 * �屣������ʽ
	 */
	public static interface FEND_FASHION {
		/**
		 * ���й���
		 */
		final long COLLECT_SUPPORT = 2980;

		/**
		 * ��ɢ����
		 */
		final long DETRACT_SUPPORT = 2981;
	}

	/**
	 * ��ҵ״̬
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
		 * δ��ҵ
		 */
		final Long NOT_WORK = new Long(340);
	}

	/**
	 * �Ͷ�����
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
		 * ���Ͷ�����
		 */
		final Long NO_WORK_ABILITY = new Long(221);
	}


	/**
	 * ����״̬
	 * 
	 * @author zcpeng
	 * 
	 */
	public static interface SQZT {
		// ��������
		final Long APPLY = new Long(5821);
		// ���ڹ�ʾ
		final Long PUBLICITY = new Long(5822);
		// ��ʾ����
		final Long AFTER_PUBLICITY = new Long(5823);
		// �ֵ���˲�ͬ��
		final Long STREET_DISAGREE = new Long(5824);
		// ����״̬
		final Long APPROVAL = new Long(5825);
		// �ϱ��˻�
		final Long REPORT_BACK = new Long(5826);
		// �������
		final Long APPROVAL_END = new Long(5827);
		// �ֵ��˻ؽ���
		final Long STREET_BACK_END = new Long(5860);
	}

	/**
	 * �������״̬
	 * 
	 * @author zcpeng
	 * 
	 */
	public static interface SXBLZT {
		// ����״̬
		final Long ACCEPT = new Long(5834);
		// ����״̬
		final Long APPROVAL = new Long(5840);
		// ��������
		final Long DISTRICT_APPROVAL = new Long(5829);
		// �����˻�
		final Long DISTRICT_BACK = new Long(5830);
		// �ֵ��˻��ϱ�
		final Long STREET_BACK_REPORT = new Long(5831);
		// �ֵ���ͬ��
		final Long STREET_DISAGREE = new Long(5832);
		// �������
		final Long APPROVAL_END = new Long(5833);
	}

	/**
	 * �����������[�ͱ�ʹ��]
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
		 * �ֵ�����ˣ�
		 */
		static final String JDSH = "�ֵ�����ˣ�";

		/**
		 * ���أ�������
		 */
		static final String QXSP = "���أ�������";

		/**
		 * �����̵�����£�һ�����
		 */
		static final String ONE_STEP = "��ϸ���";
	}
	
	/**
	 * ��ʾ��ҳ���Ƿ�ɲ���<br>
	 * 
	 * @author pgc
	 *
	 */
	public interface PAGE_CAN_OPERATE {
		/** ���Բ��� */
		static final String yes="yes";
		/** ֻ�� */
		static final String no="no";
		/** �����Դ�*/
		static final String not="not";
		/** ����*/
		static final String yinCang="yinCang";
	}
	
	/**
	 * ��ʾ����<br>
	 * 
	 * @author pgc
	 *
	 */
	public interface PUBLIC_TIME {
		 
		/** 7��*/
		static final Long day7=new Long(6);
	}
	
	
	/**
	 * ��ʾ��ҳ���Ƿ�ɲ���<br>
	 * 
	 * @author pgc
	 *
	 */
	public interface VERIFY_DEAD_INFO {
		/** ���� */
		static final Long fuHe=new Long(5884);
		/** ������ */
		static final Long buFuHe=new Long(5885);
		/** ��֤��Ϣ������*/
		static final Long buCunZai=new Long(5886);
	}
	
}
