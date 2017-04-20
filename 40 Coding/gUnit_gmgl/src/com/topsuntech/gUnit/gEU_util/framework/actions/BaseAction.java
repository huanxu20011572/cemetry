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
 * 基础Action
 * 
 * @作者：antingting
 * @创建日期：2007-8-7
 * @版本：1.0
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
		// 根据系统切换数据源
		// 默认为天津民政
		String systemFlag = Constants.SYSTEM_FLAG.TJMZ;
		String dataSource = Constants.DATA_SOURCE_DAME.TJMZ;
		// session存在系统标识，则从默认切换到session中的系统标识
		HttpSession session = request.getSession();
		if (session.getAttribute("systemFlag") != null)
			systemFlag = (String) session.getAttribute("systemFlag");

		if (systemFlag != null && !"".equals(systemFlag.trim())) {
			if (systemFlag.equals(Constants.SYSTEM_FLAG.TJMZ))
				dataSource = Constants.DATA_SOURCE_DAME.TJMZ;// 天津民政
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.TJBZ))
				dataSource = Constants.DATA_SOURCE_DAME.TJBZ; // 天津殡葬
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.SRHC))
				dataSource = Constants.DATA_SOURCE_DAME.SRHC; // 收入核查
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.JGYL))
				dataSource = Constants.DATA_SOURCE_DAME.JGYL; // 天津养老
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.JBSH))
				dataSource = Constants.DATA_SOURCE_DAME.JBSH; // 天津低保
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.LLSW))
				dataSource = Constants.DATA_SOURCE_DAME.LLSW; // 老龄事务
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.ZXJZ))
				dataSource = Constants.DATA_SOURCE_DAME.ZXJZ; // 专项救助
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.LSJZ))
				dataSource = Constants.DATA_SOURCE_DAME.LSJZ; // 临时救助
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.DSRRD))
				dataSource = Constants.DATA_SOURCE_DAME.DSRRD; // 低收入认定
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.JJYL))
				dataSource = Constants.DATA_SOURCE_DAME.JJYL; // 居家养老
			else if (systemFlag.equals(Constants.SYSTEM_FLAG.SQYL))
				dataSource = Constants.DATA_SOURCE_DAME.SQYL;
		}

		DynamicDataSourceHolder.setDataSourceName(dataSource);

		return super.execute(mapping, form, request, response);
	}
}
