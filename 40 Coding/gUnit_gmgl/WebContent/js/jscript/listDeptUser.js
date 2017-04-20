/**********根据部门动态列出用户
***********autor:luocan created:20080325
************/
//定义树形结构显示的图片
var image_plus = "img/plus.gif";
var image_folder = "img/folder.gif";
var image_line = "img/line.gif";
var image_join = "img/join.gif";
var image_page = "img/page.gif";
var image_minusbottom = "img/minusbottom.gif"
var image_folderopen = "img/folderopen.gif";

function listDept(response){
  var root = response.responseXML.documentElement;
  
   	var deptDiv = document.createElement("DIV");
 	deptDiv.setAttribute("id","dept_"+root.getAttribute("id"));
 	deptDiv.setAttribute("deptId",+root.getAttribute("deptId"));
 	//deptDiv.innerHTML="<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onclick='listUser("+root.getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+root.getAttribute("id")+")' style='cursor:pointer'>"+"<input type='checkbox' name='deptId' border='0' style='height:18' value='"+root.getAttribute("name")+"' onclick='selectAllUser(event,"+root.getAttribute("id")+")'>外部通讯录";
 	generateTree(root);
	$("depts").appendChild(deptDiv);

}
function generateTree(root){

 var depts = root.childNodes;
 for(var i=0;i<depts.length;i++){

	 var child = depts[i];

 	deptDiv = document.createElement("DIV");
 	deptDiv.setAttribute("id","dept_"+depts[i].getAttribute("id"));
 	deptDiv.setAttribute("deptId",+depts[i].getAttribute("deptId"));
	if(depts[i].getAttribute("pid")!=25){
		deptDiv.style.dispaly='none'
	}else{
 		//deptDiv.innerHTML="<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onClick='listUser("+depts[i].getAttribute("id")+");listDeptChild("+depts[i].getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+depts[i].getAttribute("id")+")' style='cursor:pointer'>"+"<input type='checkbox' name='deptId' border='0' style='height:18' value='"+depts[i].getAttribute("name")+"' onclick='selectAllUser(event,"+depts[i].getAttribute("id")+")'>"+depts[i].getAttribute("name");
 	deptDiv.innerHTML="<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onClick='listDeptUser("+depts[i].getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+depts[i].getAttribute("id")+")' style='cursor:pointer'>"+"<input type='checkbox' name='deptId' border='0' style='height:18' value='"+depts[i].getAttribute("name")+"' onclick='selectAllUser(event,"+depts[i].getAttribute("id")+")'>"+depts[i].getAttribute("name");
	}
	$("depts").appendChild(deptDiv);
	if(child.childNodes.length>0){
			generateTree(child);
	}
 }
}

function listDeptUser(id){

	//alert("部门"+$("dept_"+id).nextSibling.nextSibling.id.match(/^depts/));
	//alert("人员"+$("dept_"+id).nextSibling.id.match(/^users/));
	if($("dept_"+id).nextSibling.nextSibling.id.match(/^depts/)==null && $("dept_"+id).nextSibling.id.match(/^users/)==null){
		var deptDivs = document.createElement("DIV");
		deptDivs.setAttribute("id","depts");
		
		$("depts").insertBefore(deptDivs,$("dept_"+id).nextSibling);
		new Ajax.Request('address.do', {
			method:  'post',
			parameters:"method=findChildDept&id="+id,
			onSuccess: function(response){

				var root = response.responseXML.documentElement;
				var depts = root.childNodes;
				var space = "&nbsp;&nbsp;";

				for(var i=0;i<depts.length;i++){
					var deptDiv = document.createElement("DIV");
					deptDiv.setAttribute("id","dept_"+depts[i].getAttribute("id"));
					deptDiv.setAttribute("deptId",+depts[i].getAttribute("deptId"));
					deptDiv.setAttribute("name",+depts[i].getAttribute("name"));
					
					deptDiv.innerHTML="&nbsp;&nbsp;<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onClick='listDeptUsers("+depts[i].getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+depts[i].getAttribute("id")+")' style='cursor:pointer'>"+"<input type='checkbox' name='deptId' border='0' style='height:18' value='"+depts[i].getAttribute("name")+"' onclick='selectAllUser(event,"+depts[i].getAttribute("id")+")'>"+depts[i].getAttribute("name");
					deptDivs.appendChild(deptDiv);
				};
			},
			onFailure:function(response){
			alert("查询部门失败，请您联系管理员！");
			}
		});

		var userDivs = document.createElement("DIV");
		userDivs.setAttribute("id","users");
		userDivs.innerHTML="正在加载用户...";
		$("depts").insertBefore(userDivs,$("dept_"+id).nextSibling);
		new Ajax.Request('address.do', {
		method:  'post',
		parameters:"method=createUserXmlByTreeIdWs&id="+id,
		onSuccess: function(response){

		userDivs.innerHTML="";
		var root = response.responseXML.documentElement;
		var users = root.childNodes;

		for(var i=0;i<users.length;i++){
			var userDiv = document.createElement("DIV");
			userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' onclick='listDeptUsers("+users[i].getAttribute("id")+")' align='absbottom'><img src='"+image_page+"' align='absbottom'><input type='checkbox' name='userId' border='0' style='height:18' value='"+users[i].getAttribute("id")+"|"+users[i].getAttribute("name")+"|"+users[i].getAttribute("positionId")+"'>"+users[i].getAttribute("name");
			userDivs.appendChild(userDiv);
		};
		},
			onFailure:function(response){
			alert("查询人员失败，请您联系管理员！");
			}
		});
		$("dept_"+id).firstChild.src=image_minusbottom;
		$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
	}else{
		 if($("dept_"+id).firstChild.src.match(image_minusbottom) != null){
			$("dept_"+id).nextSibling.nextSibling.style.display='none';//单位
			$("dept_"+id).nextSibling.style.display='none';//人员
 			$("dept_"+id).firstChild.src=image_plus;
 			$("dept_"+id).firstChild.nextSibling.src=image_folder;
		 }else{
			$("dept_"+id).nextSibling.nextSibling.style.display='';//单位
			$("dept_"+id).nextSibling.style.display='';//人员
 			$("dept_"+id).firstChild.src=image_minusbottom;
 			$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
		 }
	}
}

function listDeptUsers(id){

	//alert("部门"+$("dept_"+id).firstChild.nextSibling.id.match(/^depts/));
	//alert("人员"+$("dept_"+id).nextSibling.id.match(/^users/));
	if($("dept_"+id).nextSibling.id.match(/^users/)==null){
	/*
	if($("dept_"+id).firstChild.nextSibling.id.match(/^depts/)==null && $("dept_"+id).nextSibling.id.match(/^users/)==null){
		var deptDivs = document.createElement("DIV");
		deptDivs.setAttribute("id","depts");
		
		$("depts").insertBefore(deptDivs,$("dept_"+id).nextSibling);
		new Ajax.Request('address.do', {
			method:  'post',
			parameters:"method=findChildDept&id="+id,
			onSuccess: function(response){

				var root = response.responseXML.documentElement;
				var depts = root.childNodes;
				var space = "&nbsp;&nbsp;";

				for(var i=0;i<depts.length;i++){
					var deptDiv = document.createElement("DIV");
					deptDiv.setAttribute("id","dept_"+depts[i].getAttribute("id"));
					deptDiv.setAttribute("deptId",+depts[i].getAttribute("deptId"));
					deptDiv.setAttribute("name",+depts[i].getAttribute("name"));
					
					deptDiv.innerHTML="&nbsp;&nbsp;<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onClick='listDeptUser("+depts[i].getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+depts[i].getAttribute("id")+")' style='cursor:pointer'>"+"<input type='checkbox' name='deptId' border='0' style='height:18' value='"+depts[i].getAttribute("name")+"' onclick='selectAllUser(event,"+depts[i].getAttribute("id")+")'>"+depts[i].getAttribute("name");
					deptDivs.appendChild(deptDiv);
				};
			},
			onFailure:function(response){
			alert("查询部门失败，请您联系管理员！");
			}
		});
*/
		var userDivs = document.createElement("DIV");
		userDivs.setAttribute("id","users");
		userDivs.innerHTML="正在加载用户...";
		$("depts").insertBefore(userDivs,$("dept_"+id).nextSibling);
		new Ajax.Request('address.do', {
		method:  'post',
		parameters:"method=createUserXmlByTreeIdWs&id="+id,
		onSuccess: function(response){

		userDivs.innerHTML="";
		var root = response.responseXML.documentElement;
		var users = root.childNodes;

		for(var i=0;i<users.length;i++){
			var userDiv = document.createElement("DIV");
			userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' onclick='listUser("+users[i].getAttribute("id")+")' align='absbottom'><img src='"+image_page+"' align='absbottom'><input type='checkbox' name='userId' border='0' style='height:18' value='"+users[i].getAttribute("id")+"|"+users[i].getAttribute("name")+"|"+users[i].getAttribute("positionId")+"'>"+users[i].getAttribute("name");
			userDivs.appendChild(userDiv);
		};
		},
			onFailure:function(response){
			alert("查询人员失败，请您联系管理员！");
			}
		});
		$("dept_"+id).firstChild.src=image_minusbottom;
		$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
	}else{
		 if($("dept_"+id).firstChild.src.match(image_minusbottom) != null){
			$("dept_"+id).nextSibling.nextSibling.style.display='none';//单位
			$("dept_"+id).nextSibling.style.display='none';//人员
 			$("dept_"+id).firstChild.src=image_plus;
 			$("dept_"+id).firstChild.nextSibling.src=image_folder;
		 }else{
			$("dept_"+id).nextSibling.nextSibling.style.display='';//单位
			$("dept_"+id).nextSibling.style.display='';//人员
 			$("dept_"+id).firstChild.src=image_minusbottom;
 			$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
		 }
	}
}


//动态列出用户
function listUser(id){
if($("dept_"+id).nextSibling.id.match(/^users/)==null){
//如果用户还没有列出来，那么就把通过Ajax用户列出来
var userDivs = document.createElement("DIV");
userDivs.setAttribute("id","users");
userDivs.innerHTML="正在加载用户...";
$("depts").insertBefore(userDivs,$("dept_"+id).nextSibling);
//动态读取数据
new Ajax.Request('address.do', {
method:  'post',
parameters:"method=createUserXmlByTreeIdWs&id="+id,
onSuccess: function(response){

userDivs.innerHTML="";
var root = response.responseXML.documentElement;
var users = root.childNodes;


if(users.length==0){
	var userDiv = document.createElement("DIV");
	//userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"'  align='absbottom'><img src='"+image_page+"' align='absbottom'>无人员...";
	//userDivs.appendChild(userDiv);
	userDiv.style.dispaly='none'
}


 for(var i=0;i<users.length;i++){
    var userDiv = document.createElement("DIV");
	userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' onclick='listUser("+users[i].getAttribute("id")+")' align='absbottom'><img src='"+image_page+"' align='absbottom'><input type='checkbox' name='userId' border='0' style='height:18' value='"+users[i].getAttribute("id")+"|"+users[i].getAttribute("name")+"|"+users[i].getAttribute("positionId")+"'>"+users[i].getAttribute("name");
	userDivs.appendChild(userDiv);
 };

},
onFailure:function(response){
alert("查询人员失败，请您联系管理员！");
}
});

//更改图片显示
$("dept_"+id).firstChild.src=image_minusbottom;
$("dept_"+id).firstChild.nextSibling.src=image_folderopen;

}else{
 //否则就把针对用户进行显示与隐藏操作

 if($("dept_"+id).firstChild.src.match(image_minusbottom) != null){
 	//隐藏
 	$("dept_"+id).nextSibling.style.display='none';
 	$("dept_"+id).firstChild.src=image_plus;
 	$("dept_"+id).firstChild.nextSibling.src=image_folder;
 	
 	
 }else{
 	//关闭
 	$("dept_"+id).nextSibling.style.display='';
 	$("dept_"+id).firstChild.src=image_minusbottom;
 	$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
 }
 }
}

function selectAllUser(event,id){
var obj = event.srcElement;
if($("dept_"+id).nextSibling.id.match(/^users/)!=null){
var inputs = $("dept_"+id).nextSibling.getElementsByTagName("input");
for(var i=0;i<inputs.length;i++){
	inputs[i].checked = obj.checked;
}

}else{
//如果用户还没有列出来，那么就把通过Ajax用户列出来
var userDivs = document.createElement("DIV");
userDivs.innerHTML="正在加载用户...";
userDivs.setAttribute("id","users");
$("depts").insertBefore(userDivs,$("dept_"+id).nextSibling);
//动态读取数据
new Ajax.Request('address.do', {
method:  'post',
parameters:"method=createUserXmlByTreeIdWs&id="+id,
onSuccess: function(response){
var root = response.responseXML.documentElement;
var users = root.childNodes;
userDivs.innerHTML="";
if(users.length==0){
	var userDiv = document.createElement("DIV");
	userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"'  align='absbottom'><img src='"+image_page+"' align='absbottom'>无人员...";
	userDivs.appendChild(userDiv);
}
 for(var i=0;i<users.length;i++){
    var userDiv = document.createElement("DIV");
    userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' onclick='listUser("+users[i].getAttribute("id")+")' align='absbottom'><img src='"+image_page+"' align='absbottom'><input type='checkbox' name='userId' border='0' style='height:18' value='"+users[i].getAttribute("id")+"|"+users[i].getAttribute("name")+"'>"+users[i].getAttribute("name");
    userDivs.appendChild(userDiv);
 };
var inputs = userDivs.getElementsByTagName("input");
for(var i=0;i<inputs.length;i++){
	inputs[i].checked = obj.checked;
}
},
onFailure:function(response){
alert("查询人员失败，请您联系管理员！");
}
});
//更改图片显示
$("dept_"+id).firstChild.src=image_minusbottom;
$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
}

}

//赋值操作 针对于型号干部的JS操作

//设置用户
function setValue(){ 

var checkboxs = document.getElementsByName("userId");
//用户ID
var user_ids = "";
//用户名字
var user_names ="";
//用户个数
var user_num=0;
//描述
var user_desc="";
//将选中的用户名进行添加
for(var i=0;i<checkboxs.length;i++){

	if(checkboxs[i].checked){
	var temps = checkboxs[i].value.split("|");
			if(user_ids.length>1){
				user_ids+=",";
				user_names+=",";
				}
			user_ids += "["+temps[0]+"]";
			user_names+="["+temps[1]+"]";
			user_num++;
			if(user_desc.length<6){
			if(user_desc.length>1)
			 user_desc+=",";
			  user_desc+=temps[1];
			  }
	}
}
if(user_ids == ""){
		alert("请选择人员！");
		return ;
	}
if(user_num>2)
user_desc+="等";
user_desc+=user_num+"人";
var param = window.location.href.parseQuery()["param"];

if(param == "")
return;

param=param.split(",");

//设置接收人描述
window.opener.document.getElementById(param[0]).value=user_desc;
//设置接收人ID集合
window.opener.document.getElementById(param[1]).value=user_ids;
//设置接收人姓名集合
window.opener.document.getElementById(param[2]).value=user_names;
window.opener.document.getElementById(param[0]).title=user_names;
window.opener.document.getElementById("receiveNo").value="1";
window.close();
//alert(user_ids);
//alert(user_desc);
}
/*
function allJZ(){
var parameters = "method=createAllUserXml";
//加载部门
new Ajax.Request('address.do', {
method:  'post',
parameters:parameters,
onSuccess:  function(response){
 var root = response.responseXML.documentElement;
 
  var depts = root.childNodes;
 for(var i=0;i<depts.length;i++){
 	deptDiv = document.createElement("DIV");
 	deptDiv.setAttribute("id","dept_"+depts[i].getAttribute("id"));
 	deptDiv.setAttribute("positionId",+depts[i].getAttribute("positionId"));
 	deptDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' align='absbottom'><img src='"+image_page+"' align='absbottom'><input type='checkbox' name='allId' border='0' style='height:18' value='"+depts[i].getAttribute("positionId")+"'>"+depts[i].getAttribute("name");
 	$("depts").appendChild(deptDiv);
 }

 var checkboxs = document.getElementsByName("allId");
 for(var i=0;i<checkboxs.length;i++){
	
	 var temps = checkboxs[i].value;
	 if(temps==1||temps==2||temps==3||temps==4||temps==5||temps==6){
	     checkboxs[i].checked=true;
	 }
 }
},
onFailure:function(response){
alert("查询部门失败，请您联系管理员！");
}
});
}
function allCZ(){
var parameters = "method=createAllUserXml";
//加载部门
new Ajax.Request('address.do', {
method:  'post',
parameters:parameters,
onSuccess:  function(response){
 var root = response.responseXML.documentElement;
 
  var depts = root.childNodes;
 for(var i=0;i<depts.length;i++){
 	deptDiv = document.createElement("DIV");
 	deptDiv.setAttribute("id","dept_"+depts[i].getAttribute("id"));
 	deptDiv.setAttribute("positionId",+depts[i].getAttribute("positionId"));
 	deptDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' align='absbottom'><img src='"+image_page+"' align='absbottom'><input type='checkbox' name='allId' border='0' style='height:18' value='"+depts[i].getAttribute("positionId")+"'>"+depts[i].getAttribute("name");
 	$("depts").appendChild(deptDiv);
 }

 var checkboxs = document.getElementsByName("allId");
 for(var i=0;i<checkboxs.length;i++){
	
	 var temps = checkboxs[i].value;
	 if(temps==8){
	     checkboxs[i].checked=true;
	 }
 }
},
onFailure:function(response){
alert("查询部门失败，请您联系管理员！");
}
});
}
*/