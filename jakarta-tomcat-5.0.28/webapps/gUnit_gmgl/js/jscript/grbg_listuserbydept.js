/**********���ݲ��Ŷ�̬�г��û�
***********autor:luocan created:20080325
************/
//�������νṹ��ʾ��ͼƬ
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
 	deptDiv.innerHTML="<img src='"+image_plus+"' style='cursor:pointer' align='absbottom'  onclick='listUser("+root.getAttribute("id")+")'><img src='"+image_folder+"' align='absbottom' onclick='listUser("+root.getAttribute("id")+")' style='cursor:pointer'>���쵼";
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
 //��һ����׵Ĳ���
 $("depts").appendChild(document.createElement("DIV"));
 depts = null;
 root = null;
}
//��̬�г��û�
function listUser(id){
if($("dept_"+id).nextSibling.id.match(/^users/)==null){
//����û���û���г�������ô�Ͱ�ͨ��Ajax�û��г���
var userDivs = document.createElement("DIV");
userDivs.setAttribute("id","users");
userDivs.innerHTML="���ڼ����û�...";
$("depts").insertBefore(userDivs,$("dept_"+id).nextSibling);
//��̬��ȡ����
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
alert("��ѯ��Աʧ�ܣ�������ϵ����Ա��");
}
});

//����ͼƬ��ʾ
$("dept_"+id).firstChild.src=image_minusbottom;
$("dept_"+id).firstChild.nextSibling.src=image_folderopen;

}else{
 //����Ͱ�����û�������ʾ�����ز���

 if($("dept_"+id).firstChild.src.match(image_minusbottom) != null){
 	//����
 	$("dept_"+id).nextSibling.style.display='none';
 	$("dept_"+id).firstChild.src=image_plus;
 	$("dept_"+id).firstChild.nextSibling.src=image_folder;
 	
 	
 }else{
 	//�ر�
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
//����û���û���г�������ô�Ͱ�ͨ��Ajax�û��г���
var userDivs = document.createElement("DIV");
userDivs.innerHTML="���ڼ����û�...";
userDivs.setAttribute("id","users");
$("depts").insertBefore(userDivs,$("dept_"+id).nextSibling);
//��̬��ȡ����
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
alert("��ѯ��Աʧ�ܣ�������ϵ����Ա��");
}
});
//����ͼƬ��ʾ
$("dept_"+id).firstChild.src=image_minusbottom;
$("dept_"+id).firstChild.nextSibling.src=image_folderopen;
}

}
/******
��ֵ���� ������ͺŸɲ���JS����
********/
//�����û�
function setValue(){
var checkboxs = document.getElementsByName("userId");
//�û�ID
var user_ids = "";
//�û�����
var user_names ="";
//�û�����
var user_num=0;
//����
var user_desc="";
//��ѡ�е��û����������
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
user_desc+="��";
user_desc+=user_num+"��";
var param = window.location.href.parseQuery()["param"];

if(param == "")
return;

param=param.split(",");

//���ý���������
window.opener.document.getElementById(param[0]).value=user_desc;
//���ý�����ID����
window.opener.document.getElementById(param[1]).value=user_ids;
//���ý�������������
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