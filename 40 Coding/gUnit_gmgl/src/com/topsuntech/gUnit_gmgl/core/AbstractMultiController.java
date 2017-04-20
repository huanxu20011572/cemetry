package com.topsuntech.gUnit_gmgl.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.topsuntech.gUnit_gmgl.core.tree.TreeNode;

public abstract class AbstractMultiController extends MultiActionController {

	/**
	 * 图片服务器路径
	 * 
	 * @return
	 */
	public String getPicServerPath() {
		return getServletContext().getRealPath("/") + "upload/pic";
	}

	/**
	 * 文件服务器路径
	 * 
	 * @return
	 */
	public String getFileServerPath() {
		return getServletContext().getRealPath("/") + "upload/file";
	}
	/**
	 * POJO绑定参数 按JPS的Name属性值绑定
	 * 
	 * @param request
	 * @param command
	 * @return
	 * @throws Exception
	 */
	protected BindingResult bindObject(HttpServletRequest request, Object command) throws Exception {
		ServletRequestDataBinder binder = createBinder(request, command);
		preBind(request, command, binder);
		binder.bind(request);
		Validator validators[] = getValidators();
		if (validators != null) {
			Validator validator = null;
			for (int i = 0; i < validators.length; i++) {
				validator = validators[i];
				if (validator.supports(command.getClass()))
					ValidationUtils.invokeValidator(validator, command, binder.getBindingResult());
			}

		}
		return binder.getBindingResult();
	}

	protected abstract void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder);

	/**
	 * 返回有消息的结果
	 * 
	 * @param response
	 * @param bizData
	 */
	public void ajaxResult(HttpServletResponse response, Object bizData, String messageContent, MessageType messageType) {
		setResponseHeader(response);
		PrintWriter printWriter = null;
		try {
			ResponseResult out = new ResponseResult();
			out.setBizData(bizData);
			out.setMessage(messageContent);
			out.setMessageType(messageType.toString());

			String json = JSON.toJSONString(out, true);
			printWriter = response.getWriter();
			printWriter.write(json);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null)
				printWriter.flush();
			printWriter.close();
		}
	}
	
	
	
	/**
	 * 返回无消息的结果
	 * 
	 * @param response
	 * @param bizData
	 */
	public void ajaxResult(HttpServletResponse response, Object bizData) {
		setResponseHeader(response);
		PrintWriter printWriter = null;
		try {
			// 将JavaBean序列化为带格式的JSON文本 
			String json = JSON.toJSONString(bizData, true);
			logger.debug("json info:"+json);
			printWriter = response.getWriter();
			printWriter.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	/**
	 * 返回页面json格式
	 * @param response
	 * @param object:返回实体
	 * @param filter:过滤器
	 */
	public void ajaxResult(HttpServletResponse response, Object object,SerializeFilter filter) {
		setResponseHeader(response);
		PrintWriter printWriter = null;
		try {
			String json;
			json = JSON.toJSONString(object, filter);
			logger.debug("json info:"+json);
			printWriter = response.getWriter();
			printWriter.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	/**
	 * List<TreeNode>返回json树结构
	 * 
	 * @param response
	 * @param tree
	 */
	@SuppressWarnings("rawtypes")
	public void ajaxResult(HttpServletResponse response, List<? extends TreeNode> tree) {
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(tree.get(0).getClass(), "id", "state", "text");
		ajaxResult(response, tree, filter);
	}

	/**
	 * TreeNode返回json树结构
	 * 
	 * @param response
	 * @param tree
	 */
	@SuppressWarnings("rawtypes")
	public void ajaxResult(HttpServletResponse response, TreeNode tree) {
		setResponseHeader(response);
		PrintWriter printWriter = null;
		try {
			String json;
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter(tree.getClass(), "id", "state", "text");
			json = "[" + JSON.toJSONString(tree, filter) + "]";
			logger.debug("json info:"+json);
			printWriter = response.getWriter();
			printWriter.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	/**
	 * 返回服务端消息
	 * 
	 * @param response
	 * @param bizData
	 */
	public void ajaxMessage(HttpServletResponse response, String messageContent, MessageType messageType) {
		setResponseHeader(response);
		PrintWriter printWriter = null;
		try {
			ResponseResult out = new ResponseResult();
			out.setMessage(messageContent);
			out.setMessageType(messageType.toString());
			String json = JSON.toJSONString(out, true);
			printWriter = response.getWriter();
			printWriter.write(json);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null)
				printWriter.flush();
			printWriter.close();
		}
	}
	
	/**
	 * 设置Response Header
	 * @param response
	 */
	private void setResponseHeader(final HttpServletResponse response){
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-store, max-age=0, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
	}
}
