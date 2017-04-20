package com.topsuntech.gUnit_gmgl.gEU_system.framework;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.MessageType;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.PageConfig;
import com.topsuntech.gUnit_gmgl.gEU_system.entity.Dict;
import com.topsuntech.gUnit_gmgl.gEU_system.service.DictService;

public class DictController extends AbstractMultiController {
	private DictService dictService;

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveDict(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		ModelAndView mv = new ModelAndView("dict_list.jsp");
		Page page = PageConfig.getPage(request);

		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		Dict para = new Dict();
		bindObject(request, para);

		dictService.saveDict(para, pid);
		List<Dict> list = dictService.getDictListByPID(page, pid);
		mv.addObject("list", list);
		mv.addObject("param", dictService.getDictById(pid));
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 校验代码的唯一性
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public void getDictByCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = ServletRequestUtils.getStringParameter(request, "dictCode");
		List<Dict> dicts = dictService.getDictByCode(code);
		String message = "success";
		if (dicts.size() > 0)
			message = "已经存在字典编码:" + code;
		super.ajaxMessage(response, message, MessageType.error);

	}

	/**
	 * 进入List页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getDictListByPID(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		ModelAndView mv = new ModelAndView("dict_list.jsp");
		Page page = PageConfig.getPage(request);

		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		List<Dict> list = dictService.getDictListByPID(page, pid);
		mv.addObject("list", list);
		mv.addObject("param", dictService.getDictById(pid));
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 进入新建页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getDictCreateData(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		ModelAndView mv = new ModelAndView("dict_create.jsp");
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		mv.addObject("dict", dictService.getDictById(pid));
		return mv;
	}

	/**
	 * 进入编辑页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getDictEditById(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		ModelAndView mv = new ModelAndView("dict_edit.jsp");
		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		mv.addObject("dict", dictService.getDictById(id));
		return mv;
	}

	/**
	 * 
	 * 进入新建页面
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteDictById(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		ModelAndView mv = new ModelAndView("dict_list.jsp");
		Page page = PageConfig.getPage(request);

		Long id = ServletRequestUtils.getLongParameter(request, "id", 0);
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		dictService.deleteDictById(id);
		List<Dict> list = dictService.getDictListByPID(page, pid);
		mv.addObject("list", list);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 加载根节点
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @throws Exception
	 */
	public ModelAndView getDictTree(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		super.ajaxResult(response, dictService.getDictById(pid));
		return null;
	}

	/**
	 * 树展开叶子
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getDictTreeByPID(HttpServletRequest request, HttpServletResponse response, Dict command) throws Exception {
		Long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);
		List<Dict> list = dictService.getDictTreeNodeByPid(pid);
		super.ajaxResult(response, list);
		return null;
	}

}
