/**
 * 
 */
package com.topsuntech.gUnit.gEU_util.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.topsuntech.gUnit.gEU_util.holder.DynamicDataSourceHolder;
import com.topsuntech.gUnit.gEU_util.tools.Constants;

/**
 * @author zcpeng
 * 
 */
public class BeanListener implements ServletContextListener {
	private static WebApplicationContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @seejavax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}
}
