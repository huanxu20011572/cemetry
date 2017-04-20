/**********根据部门动态列出用户
***********autor:luocan created:20080325
************/
//定义树形结构显示的图片
var image_plus = "../xxzx/img/plus.gif";
var image_folder = "../xxzx/img/folder.gif";
var image_line = "../xxzx/img/line.gif";
var image_join = "../xxzx/img/join.gif";
var image_page = "../xxzx/img/page.gif";
var image_minusbottom = "../xxzx/img/minusbottom.gif"
var image_folderopen = "../xxzx/img/folderopen.gif";

function listDept(response){
  var root = response.responseXML.documentElement;
 /*
   	var deptDiv = document.createElement("DIV");
 	deptDiv.setAttribute("id","dept_"+root.getAttribute("id"));
 	deptDiv.setAttribute("deptId",+root.getAttribute("deptId"));
 	deptDiv.innerHTML="<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onclick='listUser("+root.getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+root.getAttribute("id")+")' style='cursor:pointer'>局领导";
 	$("depts").appendChild(deptDiv);
 	*/
  var depts = root.childNodes;
 for(var i=0;i<depts.length;i++){
 	deptDiv = document.createElement("DIV");
 	deptDiv.setAttribute("id","dept_"+depts[i].getAttribute("id"));
 	deptDiv.setAttribute("deptId",+depts[i].getAttribute("deptId"));
 	deptDiv.innerHTML="<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onclick='listUser("+depts[i].getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+depts[i].getAttribute("id")+")' style='cursor:pointer'><a href='#' onclick='listotherflowDept("+depts[i].getAttribute("deptId")+")'>"+depts[i].getAttribute("name")+"</a>";
 	$("depts").appendChild(deptDiv);
 }
 //加一个垫底的部门
 $("depts").appendChild(document.createElement("DIV"));
 depts = null;
 root = null;
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
new Ajax.Request('../xxzx/address.do', {
method:  'post',
parameters:"method=createUserXmlByTreeId&id="+id,
onSuccess: function(response){

userDivs.innerHTML="";
var root = response.responseXML.documentElement;
var users = root.childNodes;

 for(var i=0;i<users.length;i++){
    var userDiv = document.createElement("DIV");
    userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' onclick='listUser("+users[i].getAttribute("id")+")' align='absbottom'><img src='"+image_page+"' align='absbottom'><a href='#' onclick='listotherflow("+users[i].getAttribute("userId")+")'>"+users[i].getAttribute("name")+"</a>";
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
new Ajax.Request('../xxzx/address.do', {
method:  'post',
parameters:"method=createUserXmlByTreeId&id="+id,
onSuccess: function(response){
var root = response.responseXML.documentElement;
var users = root.childNodes;
userDivs.innerHTML="";
 for(var i=0;i<users.length;i++){
    var userDiv = document.createElement("DIV");
    userDiv.innerHTML="<img src='"+image_line+"' align='absbottom' ><img src='"+image_join+"' onclick='listUser("+users[i].getAttribute("id")+")' align='absbottom'><img src='"+image_page+"' align='absbottom'><a href='#' onclick='listotherflow("+users[i].getAttribute("userId")+")'>"+users[i].getAttribute("name")+"</a>";
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
/******
赋值操作 针对于型号干部的JS操作
********/
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
if(user_ids == "")
return ;
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
window.close();
//alert(user_ids);
//alert(user_desc);
};
function listotherflow(userId){
  var url = "otherFlowListByDay.do?method=otherListByDay" + "&userId="+userId;
  parent.main.location.href = url;
}
function listotherflowDept(deptId){
  var url = "otherFlowListByDayDept.do?method=otherListByDayDept" + "&deptId="+deptId;
  parent.main.location.href = url;
}