<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<header>
</header>
<body style="background-color: transparent">
	<form action="dictController.fj?method=saveDict" id="isform" method="post">
	 
	<input type="hidden" value="<c:out value='${dict.parent.id}'/>" name="pid" id="pid"/>  
	<input type="hidden" value="<c:out value='${dict.id}'/>" name="id" id="id"/>  
	  
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
			<td height="35" align="right" bgcolor="#D4E5F4">字典名称：</td>
	    	<td align="left" bgcolor="#FFFFFF"><input
				name="dictName" type="text" id="dictName" class="input-1"    value="<c:out value='${dict.dictName}'/>" />
				</td>
		  	<td align="right" bgcolor="#D4E5F4">字典编码：</td>
			<td align="left" bgcolor="#FFFFFF"><input
				name="dictCode" type="text" id="dictCode" class="input-1" disabled='disabled'     value="<c:out value='${dict.dictCode}'/>" />
			 
				</td>
		</tr>
		<tr>
			<td height="35" align="right" bgcolor="#D4E5F4">排序：</td>
			<td align="left" bgcolor="#FFFFFF"><input
				name="sort" type="text" id="sort" class="input-1"   value="<c:out value='${dict.sort}'/>"   />
				</td>
		  	<td align="right" bgcolor="#D4E5F4">是否有效：</td>
			<td align="left" bgcolor="#FFFFFF">
	<!-- 		<input name="isValidate" type="text" id="isValidate" class="input-1"/> -->
		    <select name="isValidate" class="input-1" style='height:22px'>
		       <option value='1' <c:if test="${dict.isValidate == '1'}">selected</c:if> >是</option>
		       <option value='0'   <c:if test="${dict.isValidate == '0'}">selected</c:if> >否</option>
		    </select>
		    </td>
		</tr>
		<tr>
			<td height="35" align="right" bgcolor="#D4E5F4">备注：</td>
	    	<td colspan="3" align="left" bgcolor="#FFFFFF">
	    	<textarea name="remark" id="remark" style='height:40px;width:90%' class="input-1">
	    	 <c:out value='${dict.remark}'/> 
	    	   </textarea>	    
	    </td>
	    </tr>
		<tr>
		 	<td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
			 	<input name="button" type="button" onclick="javascript:doSave();" class="button-z" id="button" value="保存" />
			 	<input name="button" type="button" onclick="location.href='dictController.fj?method=getDictListByPID&pid=0'" class="button-z" id="button" value="返回" />
			</td>  
	    </tr>
	</table>
	</form>
	<script type="text/javascript">
	 function doSave() {
		var pid=$("#pid").val();
		var name=$.trim($("#dictName").val());
		var code=$.trim($("#dictCode").val());
		var sort=$("#sort").val();
		var remark=$("#remark").val();
		//TODO:验证：
		if(name.length>20||name.length==0){
			alert("字典名称长度范围为1至20个字符");
			return ;
		}
		if(code.length>20){
			alert("字典代码长度不超过20个字符");
			return ;
		}
		if(remark.length>200){
			alert("备注长度不超过200个字符");
			return ;
		}
		if(!/^[0-9]+$/g.test(sort)){
			alert("排序字段为数字");
			return;
		}
		$("#dictCode").removeAttr("disabled");
		$("#isform").submit();
	} 
	 
	</script>
</body>
</html>