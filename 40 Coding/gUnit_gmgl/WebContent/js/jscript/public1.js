function showOrHidden(name){
	$(name).style.display=($(name).style.display=='none'?'':'none')
}

	 /**打开新窗口*****/
function showWindow(url,width,height){
		var w_left = screen.width/2-(width/2);
        var w_height = screen.height/2-(height/2)-30;
        var changeWindow = window.open(url, '_blank', 'top=0,left=0,location=no,status=no,scrollbars=yes,menubar=no,toolbar=no,directories=no,resizable=no,width=' + width + ',height=' + height);
        	changeWindow.moveTo(w_left,w_height);
        	changeWindow = null;
		
}

function doTask(spyj,form){
	form.spyj.value=spyj;
	
	if(form.opinionText!=undefined && form.opinionText.value == ""){
	if(!confirm("您没有填写意见，您还要进行提交吗？")){
		return ;
	}
	}
	
		if(spyj == '提交局领导'){
			//if(form.lead.value == ''){
			//	alert("请选择局领导");
			//	return;
			//}
			 var inputs = document.getElementsByName("leadBox");
			 var roleId = "";
			 var roleNames = "";
			 for(var i=0;i<inputs.length;i++){
				  if(inputs[i].checked){
					 if(roleId != ""){
						 roleId+=",";
						 roleNames+=",";
						 }
						 roleId+=inputs[i].value;
						 roleNames+=inputs[i].nextSibling.nodeValue;
				  }
			 }
			 if(roleId == ""){
			 	alert("请选择局领导");
				return;
			 }
			 
			 if(!(confirm('您真的要提交['+roleNames+']吗？'))){
				return ;
			}
		
		form.toRoleId.value=roleId;	
		}else{
			if(!(confirm('您真的要['+spyj+']吗？'))){
				return ;
			}
		}
		
		form.action="doTask.do?method=doTask";
		form.submit();
	
	
}

function saveSW(spyj,form){
	if(checkForm(form)){
		form.spyj.value=spyj;
		form.state.value="2";
		if(form.options.value==""){
		 alert("请填写拟办意见");
		 form.options.focus();
		 return;
		}
		if(form.opinionText!=undefined && form.opinionText.value == ""){
		if(!confirm("您没有填写意见，您还要进行提交吗？")){
			return ;
		}
		}
		
		if(spyj == '提交处长'){
		
		if(form.deptId.value == ""){
			alert("请选择处室！");
			return ;
			}
			if(!(confirm('您真的要['+form.deptId.options[form.deptId.selectedIndex].text+']处长办理吗？'))){
					return ;
				}
		}else if(spyj == '办理'){
			if(form.toContactman.value == ""){
				alert("请选择拟稿人员");
				return ;
			}
			
			if(!(confirm('您真的要['+form.toContactman.options[form.toContactman.selectedIndex].text+']办理吗？'))){
					return ;
				}
		}else if(spyj == '提交局领导'){
				//if(form.lead.value == ''){
				//	alert("请选择局领导");
				//	return;
				//}
				 var inputs = document.getElementsByName("leadBox");
				 var roleId = "";
				 var roleNames = "";
				 for(var i=0;i<inputs.length;i++){
					  if(inputs[i].checked){
						 if(roleId != ""){
							 roleId+=",";
							 roleNames+=",";
							 }
							 roleId+=inputs[i].value;
							 roleNames+=inputs[i].nextSibling.nodeValue;
					  }
				 }
				 if(roleId == ""){
				 	alert("请选择局领导");
					return;
				 }
				 
				 if(!(confirm('您真的要提交['+roleNames+']吗？'))){
					return ;
				}
			
			form.toRoleId.value=roleId;	
			}else{
				if(!(confirm('您真的要['+spyj+']吗？'))){
					return ;
				}
			}
			
			//form.action="doTask.do?method=doTask";
			
			form.submit();
	}
	
}

function saveFileChuanyeSwgl(spyj,form){
	if(checkForm(form)){
		form.spyj.value=spyj;
		form.state.value="2";
		if(form.opinionText!=undefined && form.opinionText.value == ""){
		if(!confirm("您没有填写意见，您还要进行提交吗？")){
			return ;
		}
		}
		
		if(spyj == '提交处长'){
		
		if(form.deptId.value == ""){
			alert("请选择处室！");
			return ;
			}
			if(!(confirm('您真的要['+form.deptId.options[form.deptId.selectedIndex].text+']处长办理吗？'))){
					return ;
				}
		}else if(spyj == '办理'){
			if(form.toContactman.value == ""){
				alert("请选择拟稿人员");
				return ;
			}
			
			if(!(confirm('您真的要['+form.toContactman.options[form.toContactman.selectedIndex].text+']办理吗？'))){
					return ;
				}
		}else if(spyj == '提交局领导'){
				//if(form.lead.value == ''){
				//	alert("请选择局领导");
				//	return;
				//}
				 var inputs = document.getElementsByName("leadBox");
				 var roleId = "";
				 var roleNames = "";
				 for(var i=0;i<inputs.length;i++){
					  if(inputs[i].checked){
						 if(roleId != ""){
							 roleId+=",";
							 roleNames+=",";
							 }
							 roleId+=inputs[i].value;
							 roleNames+=inputs[i].nextSibling.nodeValue;
					  }
				 }
				 if(roleId == ""){
				 	alert("请选择局领导");
					return;
				 }
				 
				 if(!(confirm('您真的要提交['+roleNames+']吗？'))){
					return ;
				}
			
			form.toRoleId.value=roleId;	
			}else{
				if(!(confirm('您真的要['+spyj+']吗？'))){
					return ;
				}
			}
			
			//form.action="doTask.do?method=doTask";
			
			form.submit();
	}
	
}