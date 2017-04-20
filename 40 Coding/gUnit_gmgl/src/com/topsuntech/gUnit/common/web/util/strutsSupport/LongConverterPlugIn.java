package com.topsuntech.gUnit.common.web.util.strutsSupport;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class LongConverterPlugIn implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(ActionServlet arg0, ModuleConfig arg1)
			throws ServletException {
		// TODO Auto-generated method stub
		ConvertUtils.register(new LongConverter(), java.lang.Long.class );
	}
}
