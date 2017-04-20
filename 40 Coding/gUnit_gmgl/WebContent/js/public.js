function showOrHidden(name){
	$(name).style.display=($(name).style.display=='none'?'':'none')
	
}
function initFileList(){

  window.frames['fj'].initFileList();
}
/**打开新窗口*****/
function showWindow(url,width,height){
		var w_left = screen.width/2-(width/2);
        var w_height = screen.height/2-(height/2)-30;
        var changeWindow = window.open(url, '_blank', 'top=0,left=0,location=no,status=yes,scrollbars=yes,menubar=no,toolbar=no,directories=no,resizable=no,width=' + width + ',height=' + height);
        	changeWindow.moveTo(w_left,w_height);
        	changeWindow = null;
		
}

function doTask(spyj,form){ 
	
	form.spyj.value=spyj;
	var leaderName = form.leaderName;
	
	if(spyj == '提交局领导' || spyj == '提交主任'|| spyj == '提交盖章' ){
	
		if(leaderName.value == ""){
			alert("请您先选择要提交的对象后再提交");
			return;
		}
		
		
		if(spyj == '提交主任' || spyj == '提交盖章'){
			if(leaderName.value.indexOf(',') >= 0){
				alert("["+spyj+"]这一项只能选择一个人，请重新选择");
				return;
			}
		}
		
	}
	
	if(spyj == '退回处室') {
		if(leaderName.value == ""){
			alert("请您先选择要退回的对象后再退回到处室");
			return;
		}
	}

	if(form.actionId.value==11&&leaderName.value == "" && spyj != '归档'){
		alert("请您先选择要提交的对象后再提交");
			return;
	 }
	
	if(spyj != '退回') {
		if((form.officefirstId!=undefined && form.officefirstId.value == "") || (form.leaderName!=undefined && form.leaderName.value == "" )|| (form.officeworkableId!=undefined && form.officeworkableId.value == "")){
			if(form.actionId_hidden.value != "11"){
				alert("请先选择要提交的对象");
				return;
			}
		}
	}
	if(form.opinionText!=undefined && form.opinionText.value == ""){
		if(!confirm("您没有填写意见，您还要进行提交吗？")){
			return ;
		}
	} 
	
	if(spyj == 'sss提交局领导'){
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
		 // TODO 暂时给roleId一个测试值
		 roleId = document.getElementById('leaderId');
		 if(roleId == ""){
		 	alert("请选择局领导");
			return;
		 }
		 
		 if(form.opinionText!=undefined && form.opinionText.value == ""){
			if(!confirm("您没有填写意见，您还要进行提交吗？")){
				return ;
			}
		 } 
		 
		 if(!(confirm('您真的要提交['+roleNames+']吗？'))){
			return ;
		 }
	
		 form.toRoleId.value=roleId;	
		 } else {
		 if(!(confirm('是否确认要['+spyj+']？'))){
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
	if(checkForm(form,spyj)){
		form.spyj.value=spyj;
		form.state.value="2";
		
		//if(form.opinionText!=undefined && form.opinionText.value == ""){
			//if(!confirm("您没有填写意见，您还要进行提交吗？")){
			//	return ;
			//}
		//}
		
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
		} else{
			if(!(confirm('您真的要['+spyj+']吗？'))){
				return ;
			}
		}
			
			//form.action="doTask.do?method=doTask";
			
		form.submit();
	}
	
}
function showOrHidden2(v1,v2){
		
		v1.innerHTML=(v1.innerHTML=="隐藏"?"显示":"隐藏");
		$(v2).style.display=($(v2).style.display=='none'?'':'none')
	}

		//取得绝对位置
function getOffset(e) 
{  
 var t=e.offsetTop;  
 var l=e.offsetLeft;  
 while(e=e.offsetParent) 
 {  
  t+=e.offsetTop;  
  l+=e.offsetLeft;  
 }  
 var rec = new Array(1); 
 rec[0]  = t; 
 rec[1] = l; 
 return rec 
}  

function receiveManager(t,b,index){
	
var ts = document.getElementsByName(t);
var bs = document.getElementsByName(b);

for(var i=0;i<ts.length;i++){
	ts[i].background="../images_oa/lab_04_bg.jpg";
	bs[i].style.display='none';
}

ts[index].background="../images_oa/lab_03_bg.jpg";
bs[index].style.display='';
}