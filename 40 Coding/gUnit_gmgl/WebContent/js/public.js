function showOrHidden(name){
	$(name).style.display=($(name).style.display=='none'?'':'none')
	
}
function initFileList(){

  window.frames['fj'].initFileList();
}
/**���´���*****/
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
	
	if(spyj == '�ύ���쵼' || spyj == '�ύ����'|| spyj == '�ύ����' ){
	
		if(leaderName.value == ""){
			alert("������ѡ��Ҫ�ύ�Ķ�������ύ");
			return;
		}
		
		
		if(spyj == '�ύ����' || spyj == '�ύ����'){
			if(leaderName.value.indexOf(',') >= 0){
				alert("["+spyj+"]��һ��ֻ��ѡ��һ���ˣ�������ѡ��");
				return;
			}
		}
		
	}
	
	if(spyj == '�˻ش���') {
		if(leaderName.value == ""){
			alert("������ѡ��Ҫ�˻صĶ�������˻ص�����");
			return;
		}
	}

	if(form.actionId.value==11&&leaderName.value == "" && spyj != '�鵵'){
		alert("������ѡ��Ҫ�ύ�Ķ�������ύ");
			return;
	 }
	
	if(spyj != '�˻�') {
		if((form.officefirstId!=undefined && form.officefirstId.value == "") || (form.leaderName!=undefined && form.leaderName.value == "" )|| (form.officeworkableId!=undefined && form.officeworkableId.value == "")){
			if(form.actionId_hidden.value != "11"){
				alert("����ѡ��Ҫ�ύ�Ķ���");
				return;
			}
		}
	}
	if(form.opinionText!=undefined && form.opinionText.value == ""){
		if(!confirm("��û����д���������Ҫ�����ύ��")){
			return ;
		}
	} 
	
	if(spyj == 'sss�ύ���쵼'){
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
		 // TODO ��ʱ��roleIdһ������ֵ
		 roleId = document.getElementById('leaderId');
		 if(roleId == ""){
		 	alert("��ѡ����쵼");
			return;
		 }
		 
		 if(form.opinionText!=undefined && form.opinionText.value == ""){
			if(!confirm("��û����д���������Ҫ�����ύ��")){
				return ;
			}
		 } 
		 
		 if(!(confirm('�����Ҫ�ύ['+roleNames+']��'))){
			return ;
		 }
	
		 form.toRoleId.value=roleId;	
		 } else {
		 if(!(confirm('�Ƿ�ȷ��Ҫ['+spyj+']��'))){
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
	if(checkForm(form,spyj)){
		form.spyj.value=spyj;
		form.state.value="2";
		
		//if(form.opinionText!=undefined && form.opinionText.value == ""){
			//if(!confirm("��û����д���������Ҫ�����ύ��")){
			//	return ;
			//}
		//}
		
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
		} else{
			if(!(confirm('�����Ҫ['+spyj+']��'))){
				return ;
			}
		}
			
			//form.action="doTask.do?method=doTask";
			
		form.submit();
	}
	
}
function showOrHidden2(v1,v2){
		
		v1.innerHTML=(v1.innerHTML=="����"?"��ʾ":"����");
		$(v2).style.display=($(v2).style.display=='none'?'':'none')
	}

		//ȡ�þ���λ��
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