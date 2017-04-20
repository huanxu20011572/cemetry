package com.topsuntech.gUnit.gEU_util.framework.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit.gEU_util.holder.DynamicDataSourceHolder;
import com.topsuntech.gUnit.gEU_util.tools.Constants;

/**
 * ����Action
 * 
 * @���ߣ�antingting
 * @�������ڣ�2007-8-7
 * @�汾��1.0
 */
/**
 * 
 * 
 * <p>
 * <a href="BaseAction.java.html">View Source</a>
 * </p>
 * 
 * @see com.topsuntech.gUnit.gEU_util.framework.actions.BaseAction
 * @author <a href="mailto:antingting@topsuntech.com">Antingting</a>
 * @since 1.0
 * @version $Id$Revision$
 * 
 */
public class BaseAction extends AbstractAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		if (user == null) {
			response.sendRedirect(request.getContextPath());
			return null;
		}

		// added by pengzuocong 2012-5-30
		// ����ϵͳ�л�����Դ
		// Ĭ��Ϊ�������
		String systemFlag = Constants.SYSTEM_FLAG.TJMZ;
		String dataSource = Constants.DATA_SOURCE_DAME.TJMZ;
		// session����ϵͳ��ʶ�����Ĭ���л���session�е�ϵͳ��ʶ
		HttpSession session = request.getSession();
		if (session.getAttribute("systemFlag") != null)
			systemFlag = (String) session.getAttribute("systemFlag");

		if (systemFlag != null && !"".equals(systemFlag.trim())) {
			if (systemFlag.equals(Constants.SYSTEM_FLAG.TJMZ))
				dataSource = Constants.DATA_SOURCE_DAME.TJMZ;// �������
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.TJBZ))
				dataSource = Constants.DATA_SOURCE_DAME.TJBZ; // �������
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.SRHC))
				dataSource = Constants.DATA_SOURCE_DAME.SRHC; // ����˲�
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.JGYL))
				dataSource = Constants.DATA_SOURCE_DAME.JGYL; // �������
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.JBSH))
				dataSource = Constants.DATA_SOURCE_DAME.JBSH; // ���ͱ�
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.LLSW))
				dataSource = Constants.DATA_SOURCE_DAME.LLSW; // ��������
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.ZXJZ))
				dataSource = Constants.DATA_SOURCE_DAME.ZXJZ; // ר�����
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.LSJZ))
				dataSource = Constants.DATA_SOURCE_DAME.LSJZ; // ��ʱ����
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.DSRRD))
				dataSource = Constants.DATA_SOURCE_DAME.DSRRD; // �������϶�
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.JJYL))
				dataSource = Constants.DATA_SOURCE_DAME.JJYL; // �Ӽ�����
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.SQYL))
				dataSource = Constants.DATA_SOURCE_DAME.SQYL;
		}

		DynamicDataSourceHolder.setDataSourceName(dataSource);

		return super.execute(mapping, form, request, response);
	}
}
