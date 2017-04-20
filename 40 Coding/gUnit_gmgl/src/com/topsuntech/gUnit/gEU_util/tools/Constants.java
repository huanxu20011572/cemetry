/* ====================================================================
 * 
 * <http://www.topsuntech.org/>.
 */
package com.topsuntech.gUnit.gEU_util.tools;

/**
 * ���峣����
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
	 * ���򼶱�
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
	 * ��֯��������
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
	 * ɾ����־
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

	// ƽ̨��ɫ
	public interface platFormRole {
		/**
		 * �м�������Ա[ƽ̨]
		 */
		final static long CITY_MANAGER_USER = 1;

		final static String CITY_MANAGER_USER_NAME = "�м�������Ա[ƽ̨]";

		/**
		 * ���ع�����Ա[ƽ̨]
		 */
		final static long COUNTRY_MANAGER_USER = 2;

		final static String COUNTRY_MANAGER_USER_NAME = "���ع�����Ա[ƽ̨]";

		/**
		 * �����쵼
		 */
		final static long COUNTRY_LEAD_USER = 201;

		final static String COUNTRY_LEAD_USER_NAME = "�����쵼";

		/**
		 * �ֵ�������Ա[ƽ̨]
		 */
		final static long STREET_MANAGER_USER = 3;

		final static String STREET_MANAGER_USER_NAME = "�ֵ�������Ա[ƽ̨]";

		/**
		 * һ�㹤����Ա
		 */
		final static long GENERAL_USER = 4;

	}

	// ��ѯ����
	public interface QueryRegion {
		// ����
		static final String REGION = "reg";

		// ����
		static final String DEPT = "org";
	}

	// ������
	public interface treeNodeType {
		// ����
		static final long REGION = 101;

		// ����
		static final long DEPT = 102;

		// ϵͳ�û�
		static final long USER = 103;

		// ����
		static final long OWN = 105;

		// ����������
		static final long DEPT_DN_REGION = 106;

		// �����»���
		static final long REGION_DN_DEPT = 107;

	}

	// ������
	public interface treeAttribute {
		static final String IMAGE = "folder.gif";

		static final String IMAGE_CHILD = "page.gif";

		static final String URL = "cxtjAction.do";

		static final String root_YES = "Y";

		static final String root_NO = "N";
	}

	// ������
	public interface treeType {
		/*
		 * FROM"�����ֵ�"(�ݹ�)����ʾ�¼��ֵ�
		 */
		static final long DICT = 101;

		/*
		 * FROM"�����ֵ�"(���ݹ�)����ʾ�¼��ֵ�
		 */
		static final long DICT_DOWN = 102;

		/*
		 * FROM"�����ֵ�"(�ݹ�)����ʾ�¼��ֵ䣺ֻ�����ڡ�������롱�е�"��Ա������"
		 */
		static final long DICT_APPLY_SFLB = 103;

		/*
		 * FROM"��֯����"(�ݹ�)
		 */
		static final long DEPT = 201;

		/*
		 * FROM"��֯����"(���ݹ�)
		 */
		static final long DEPT_DOWN = 202;

		/*
		 * FROM"��֯����"����ʾ�����Ŀ;
		 */
		static final long DEPT_PROJECT = 203;

		/*
		 * FROM"��֯����"(�ݹ�)�� ����ʾ��ص���Ŀ��ͬʱ��ʾ�¼���Ա
		 */
		static final long DEPT_USER = 204;

		/*
		 * FROM"��֯����"(���ݹ�)������ʾ��ص���Ŀ��ͬʱ��ʾ�¼���Ա
		 */
		static final long DEPT_DOWN_USER = 205;

		/*
		 * FROM"��֯����ID"����ʾ�¼���Ա
		 */
		static final long USER = 206;

		/*
		 * FROM"��֯����ID"�����ڡ������������������û���
		 */
		static final long DEPT_BUSINESS_APPLY = 207;

		/*
		 * FROM"��֯����ID"�����ڡ���Ŀά�������������м������ع�����Ա�û���
		 */
		static final long DEPT_BUSINESS_PROJECT = 208;

		/*
		 * 209��FROM"��֯����ID"�����ڡ������շ�����������
		 */
		static final long DEPT_DOCUMENT_CURRENT = 209;

		/*
		 * 210��FROM"��֯����ID"�����ڡ������շ������¼���
		 */
		static final long DEPT_DOCUMENT_CHILD = 210;

		/*
		 * 211��FROM"��֯����ID"�����ڡ������շ������������¼���
		 */
		static final long DEPT_DOCUMENT_CURRENT_CHILD = 211;

		/*
		 * 212��FROM"��֯����ID"�����ڡ����ļ�԰����
		 */
		static final long DEPT_SUPERPARKET = 212;

		/*
		 * FROM"��Ŀ��",ֻ��ʾ��Ŀ����ͨ������ID��
		 */
		static final long PROJECT = 301;

		/*
		 * FROM"��Ŀ��Դ"������ʾ��Ŀ����ʾ��ǰ��Ŀ�����е���Դ��Ϣ
		 */
		static final long RESOURCE = 401;

		/*
		 * FROM"��ɫ��Ϣ"����ʾ��ǰ�ڵ������еĽ�ɫ
		 */
		static final long ROLE = 501;

		/*
		 * FROM"��������"��ֻ��ʾ��һ������
		 */
		static final long REGION_DOWN = 601;

		/*
		 * FROM"��������"�����ڡ�����ά����
		 */
		static final long REGION_LIST_TREE = 600;

		/*
		 * 602, FROM"��������"��������ʾ�ʼ��顢�������û������ڡ��ʼ������䡱��
		 */
		static final long REGION_DEPT_USER = 602;

		/*
		 * 603, FROM"��������"��������ʾ�������û������ڡ��ʼ����顱��
		 */
		static final long REGION_DEPT_USER_GROUP = 603;

		/*
		 * 604, FROM"��������"��������ʾ���������ڡ��ճ��칫��������ʾ������
		 */
		static final long REGION_DEPT_NORMAL_WORK_BJ = 604;

		/*
		 * 604, FROM"��������"��������ʾ���������ڡ��ճ��칫��������ʾ�¼���
		 */
		static final long REGION_DEPT_NORMAL_WORK_XJ = 605;

		/*
		 * 604, FROM"��������"��������ʾ���������ڡ��ճ��칫��������ʾ�������¼���
		 */
		static final long REGION_DEPT_NORMAL_WORK_BJ_XJ = 606;

		/*
		 * 6001, FROM"��������"��������ʾ���򡢻��������ڡ�����ϵͳ��Ա������
		 */
		static final long REGION_DEPT = 6001;

		/*
		 * 6001, FROM"��������"��ѡ������������
		 */
		static final long REGION_SELECT_TREE = 607;

		/*
		 * FROM"��������"�����ڡ�����ά����
		 */
		static final long DEPT_LIST_TREE = 700;

		/*
		 * FROM"��������"��ѡ�񡰻�������
		 */
		static final long DEPT_SELECT_TREE = 701;

		/*
		 * FROM"��������"��ѡ�񡰻������������ڡ����ĳ��С�
		 */
		static final long DEPT_SELECT_AXCS_TREE = 702;

		/*
		 * FORM"��������"��ѡ�񡰻���������ͨ�ã� �ܸ����û��Ļ��������Զ���Ӧ��ʾ��Ӧ�Ļ�����Ϣ
		 */
		static final long DEPT_GENERAL_SELECT_TREE = 703;

		/*
		 * FORM"��������"��ѡ�񡰻�����������Ҫ���û���������Ӧ
		 */
		static final long DEPT_STAT_SELECT_TREE = 704;

		/*
		 * FORM"�����ֵ�"��ѡ������������
		 */
		static final long SJ_STATUS_CANUM_SELECT_TREE = 1000;

	}

	// ��
	public final static String YES = "1";
	// ��
	public final static String NO = "0";

	public static interface BUSINESS_TYPE {
		/**
		 * ������
		 */
		final int NEW_APPLY = 452;

		/**
		 * ������
		 */
		final int CHANGE_INFO = 444;

		/**
		 * �����˱��
		 */
		final int CHANGE_HOLDER = 445;

		/**
		 * ������Ա����
		 */
		final int CANCEL_DEAL_MEMBER = 2580;

		/**
		 * ������ҵ���
		 */
		final int DIF_CORP = 442;

		/**
		 * ������ͥ����
		 */
		final int CANCEL_DEAL_FAMILY = 450;

		/**
		 * Ǩ����
		 */
		final int CHANGE_IN = 453;

		/**
		 * Ǩ�����
		 */
		final int CHANGE_OUT = 446;

		/**
		 * �ֻ����
		 */
		final int DIV_FAMILY = 2525;

		/**
		 * �ϻ����
		 */
		final int UNION_FAMILY = 2526;

		/**
		 * �������ܴ���
		 */
		final int REVIEW = 1;

		/**
		 * ��������
		 */
		final int CANCEL = 2;

		/**
		 * ��������
		 */
		final int ORGANIZ = 451;

		/**
		 * ����
		 */
		final int REAUDIT = 2699;

		/**
		 * ����
		 */
		final Long ADJUST_STANRDARD = new Long(447);

	}

	/**
	 * ϵͳ����
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface SYSTEM_FLAG {
		// �������
		final static String TJMZ = "tjmz";
		// �������
		final static String TJBZ = "tjbz";
		// ����˲�
		final static String SRHC = "srhc";
		// �������
		final static String JGYL = "jgyl";
		// ���ͱ�
		final static String JBSH = "jbsh";
		// ��������
		final static String LLSW = "llsw";
		// ר�����
		final static String ZXJZ = "zxjz";
		// ��ʱ����
		final static String LSJZ = "lsjz";
		// �������϶�
		final static String DSRRD = "dsrrd";
		// �Ӽ�����
		final static String JJYL = "jjyl";
		// ��������
		final static String SQYL = "sqyl";
	}

	/**
	 * ����Դ����
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface DATA_SOURCE_DAME {
		// �������
		final static String TJMZ = "tjmz";
		// �������
		final static String TJBZ = "tjbz";
		// ����˲�
		final static String SRHC = "srhc";
		// �������
		final static String JGYL = "jgyl";
		// ���ͱ�
		final static String JBSH = "jbsh";
		// ��������
		final static String LLSW = "llsw";
		// ר�����
		final static String ZXJZ = "zxjz";
		// ��ʱ����
		final static String LSJZ = "lsjz";
		// �������϶�
		final static String DSRRD = "dsrrd";
		// �Ӽ�����
		final static String JJYL = "jjyl";
		// ��������
		final static String SQYL = "sqyl";
		// �Ż�ͳ��
		final static String STATIC = "static";
	}

	/**
	 * ��ѡ��ѯ���
	 * 
	 * @author zcpeng
	 * 
	 */
	public static interface MULTIPLE_TYPE {
		// ��ѯ�ֵ�
		final String DICT = "dict";
		// ��ѯ�Խ���
		final String CUSTOM = "custom";
	}

	/**
	 * ת������
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface translateType {
		// ����
		final static String TRANSLATE_DEPT = "translate_dept";
		// ����
		final static String TRANSLATE_REGION = "translate_region";
		// �ֵ�
		final static String TRANSLATE_DICT = "translate_dict";
		// ����
		final static String UNNEED_TRANSLATE = "unneed_translate";
		// �Զ��巽ʽ
		final static String TRANSLATE_CUSTOM = "translate_custom";
	}

	/**
	 * ƽ̨ͳ������
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface staticsName {
		final static String ETFL = "��ͯ��������";
		final static String JXTJ = "��������";
		final static String SYDJLTJ = "�����Ǽ����ݾ�";
		final static String JBSHJZTJ = "���������������";
		final static String JHDJLTJ = "���Ǽ�����";
		final static String SHZZZTQK = "�����֯����";
	}

	/**
	 * ƽ̨ͳ��
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
	 * ����ת������
	 * 
	 * @author zcpeng
	 * 
	 */
	public interface regionConvert {
		// ������������ת������
		final static Long BINHAI = new Long(1);
	}
	
	
	/**
	 * @author wubb
	 * �˵�����  1����������Ǽ� 2���Ǽ��б� 3�����ڹ�ʾ�б� 4����ʾ�����б� 5�������б� 6������ͨ���б� 
	 * 7��������ͨ���б� 8���ʽ���ȡ 9���ʽ�׷�� 10���ʽ��˶� 11���ʽ𾭰����
	 */
	public static interface MENU_TYPE{
		/**
		 * 1����������Ǽ�
		 */
		final long MENU_1 = 1;
		
		/**
		 * 2���Ǽ��б�
		 */
		final long MENU_2 = 2;
		
		/**
		 * 3�����ڹ�ʾ�б�
		 */
		final long MENU_3 = 3;
		/**
		 * 4����ʾ�����б�
		 */
		final long MENU_4 = 4;
		/**
		 * 5�������б�
		 */
		final long MENU_5 = 5;
		
		/**
		 * 6������ͨ���б�
		 */
		final long MENU_6 = 6;
		/**
		 * 7��������ͨ���б�
		 */
		final long MENU_7 = 7;
		/**
		 * 8���ʽ���ȡ
		 */
		final long MENU_8 = 8;
		/**
		 * 9���ʽ�׷��
		 */
		final long MENU_9 = 9;
		/**
		 * 10���ʽ��˶�
		 */
		final long MENU_10 = 10;
		
		/**
		 * 11:�ʽ𾭰���� 
		 */
		final long MENU_11 = 11;
		
		/**
		 * 12:��������������׼���� 
		 */
		final long MENU_12 = 12;
		
		/**
		 * 13:�������ʽ��׼���� 
		 */
		final long MENU_13 = 13;
		
		/**
		 * 14:�в����ʽ��׼���� 
		 */
		final long MENU_14 = 14;
		
	}
	
	
	
}
