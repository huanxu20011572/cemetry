function showOrHidden(name){
	$(name).style.display=($(name).style.display=='none'?'':'none')
}

	 /**���´���*****/
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
	if(!confirm("��û����д���������Ҫ�����ύ��")){
		return ;
	}
	}
	
		if(spyj == '�ύ���쵼'){
			//if(form.lead.value == ''){
			//	alert("��ѡ����쵼");
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
			 	alert("��ѡ����쵼");
				return;
			 }
			 
			 if(!(confirm('�����Ҫ�ύ['+roleNames+']��'))){
				return ;
			}
		
		form.toRoleId.value=roleId;	
		}else{
			if(!(confirm('�����Ҫ['+spyj+']��'))){
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
		 alert("����д������");
		 form.options.focus();
		 return;
		}
		if(form.opinionText!=undefined && form.opinionText.value == ""){
		if(!confirm("��û����д���������Ҫ�����ύ��")){
			return ;
		}
		}
		
		if(spyj == '�ύ����'){
		
		if(form.deptId.value == ""){
			alert("��ѡ���ң�");
			return ;
			}
			if(!(confirm('�����Ҫ['+form.deptId.options[form.deptId.selectedIndex].text+']����������'))){
					return ;
				}
		}else if(spyj == '����'){
			if(form.toContactman.value == ""){
				alert("��ѡ�������Ա");
				return ;
			}
			
			if(!(confirm('�����Ҫ['+form.toContactman.options[form.toContactman.selectedIndex].text+']������'))){
					return ;
				}
		}else if(spyj == '�ύ���쵼'){
				//if(form.lead.value == ''){
				//	alert("��ѡ����쵼");
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
				 	alert("��ѡ����쵼");
					return;
				 }
				 
				 if(!(confirm('�����Ҫ�ύ['+roleNames+']��'))){
					return ;
				}
			
			form.toRoleId.value=roleId;	
			}else{
				if(!(confirm('�����Ҫ['+spyj+']��'))){
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
		if(!confirm("��û����д���������Ҫ�����ύ��")){
			return ;
		}
		}
		
		if(spyj == '�ύ����'){
		
		if(form.deptId.value == ""){
			alert("��ѡ���ң�");
			return ;
			}
			if(!(confirm('�����Ҫ['+form.deptId.options[form.deptId.selectedIndex].text+']����������'))){
					return ;
				}
		}else if(spyj == '����'){
			if(form.toContactman.value == ""){
				alert("��ѡ�������Ա");
				return ;
			}
			
			if(!(confirm('�����Ҫ['+form.toContactman.options[form.toContactman.selectedIndex].text+']������'))){
					return ;
				}
		}else if(spyj == '�ύ���쵼'){
				//if(form.lead.value == ''){
				//	alert("��ѡ����쵼");
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
				 	alert("��ѡ����쵼");
					return;
				 }
				 
				 if(!(confirm('�����Ҫ�ύ['+roleNames+']��'))){
					return ;
				}
			
			form.toRoleId.value=roleId;	
			}else{
				if(!(confirm('�����Ҫ['+spyj+']��'))){
					return ;
				}
			}
			
			//form.action="doTask.do?method=doTask";
			
			form.submit();
	}
	
}