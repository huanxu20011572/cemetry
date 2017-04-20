<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color:transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 售前管理 &gt; 墓区信息快速查询</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>

	 <div class="easyui-layout" style="width:100%;height:450px;">
	    <div data-options="region:'west',title:'墓区信息快速查询',split:true" style="width:200px;">
			<ul id="lefttree"></ul>
		</div>
	    <div id="mainPanle" region="center"  style="padding:10px 0 10px 10px;">
			<iframe frameborder="0"  width="100%" src="cemeteryLocationController.fj?method=getCemeteryLocationFastListByPID" height="100%" scrolling="auto" id="treelist" name="treelist" allowtransparency="true"  ></iframe>
	    </div>
					
	 </div>
	 </td>
  </tr>
</table>

<script type="text/javascript">
$(function(){
	  $('#lefttree').tree({
		    url:'cemeteryLocationController.fj?method=getCemeteryZoneTree',
		    animate:true,
			onClick: function(node){
				if(node.state == undefined){
					var value = "cemeteryLocationController.fj?method=getCemeteryLocationFastListByPID";
					//是否弹出页面
					<c:if test="${param.select == 'select'}">value = value+"&select=select"</c:if>
					$('#treelist').attr("src", value +"&pid="+ node.id);
				}else{
					var value = "cemeteryLocationController.fj?method=getCemeteryLocationFastListByPID";
					//是否弹出页面
					<c:if test="${param.select == 'select'}">value = value+"&select=select"</c:if>
					$('#treelist').attr("src", value );
				}
			},
			onBeforeExpand : function(node, param) {
				var value = "cemeteryLocationController.fj?method=getCemeteryZoneTreeByPID&pid=";
				$('#lefttree').tree('options').url = value + node.id;
			}
		    
	  });
	  $('#p').panel('close');
 });
</script>

</body>
</html>
