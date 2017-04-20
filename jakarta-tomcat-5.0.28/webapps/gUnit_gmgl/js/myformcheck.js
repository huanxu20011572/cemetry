//js验证v1.0  author tianbao  created 2007-04-13 Email:tianbaolc@163.com
//使用说时：input 对象的 checkInfo 的格式为: 标题;是否为空;正则选项
//checkForm用来验证表单
//可按规则进行扩展
function PatrnsArray(){
var patrns = new Array();
patrns['patrn1'] = /^\d*$/ //非负整数（正整数 + 0）
patrns['patrn2'] = /^[0-9]*[1-9][0-9]*$/   //正整数
patrns['patrn3'] = /^((-\d+)|(0+))$/   //非正整数（负整数 + 0）
patrns['patrn4'] = /^-[0-9]*[1-9][0-9]*$/  //负整数
patrns['patrn5'] = /^-?\d+$/   //正整数
patrns['patrn6'] = /^\d+(\.\d+)?$/   //非负浮点数（正浮点数 + 0)
patrns['patrn7'] = /^((-\d+(\.\d+)?)|(0+(\.0+)?))$/   //非正浮点数（负浮点数 + 0）
patrns['patrn8'] = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/   //负浮点数
patrns['patrn9'] = /^(-?\d+)(\.\d+)?$/  //浮点数
patrns['patrn10']= /^[A-Za-z]+$/   //26个英文字母
patrns['patrn11'] = /^[A-Z]+$/  //26个大写英文字母
patrns['patrn12'] = /^[a-z]+$/  //26个小写英文字母
patrns['patrn13'] = /^[A-Za-z0-9]+$/  //数字与字母组成
patrns['patrn14'] = /^\w+$/  //由数字、26个英文字母或者下划线组成的字符串
patrns['patrn15'] = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/  //email地址
patrns['patrn15'] = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/  //email地址
patrns['patrn16'] = /^\d{4}-[0-1][0-9]-[0-3][0-9]\s[0-2][0-9]:[0-6][0-9]$/  //日期验证，格度为 yyyy-MM-dd HH:mm
patrns['patrn17'] = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/   //正浮点数
patrns['patrn18'] = /^[A-Z|a-z]{4}[0-9]{7}$/  //数值必须为4个字母+7个数字
patrns['patrn19'] = /^.{2000}$/  //数值必须为4个字母+7个数字
return patrns;
}

//验证是否为空
function check_null(str)
{
 return str.replace(/<[^>]*>/g,"")=="";
}
String.prototype.trim=function(){  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}
/**//*
用途：检查输入字符串是否为空或者全部都是空格
输入：str
返回：
如果全是空返回true,否则返回false
*/
function isNull( str ){
	if ( str == "" ) return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

//验证是否为数字
function check_option(str,value){ 
   if(str.toUpperCase() == "NO")
   return;
   return ! (new PatrnsArray())[str].test(value);
  // return patrn.exec(value)==null; //返回查找到的数组
  // return value.match(patrn)==null; //返回查找到的数组
  
}

function checkInput(){

event.cancelBubble=true;//取消事件的冒泡对象
var eobj=event.srcElement;//获取触发事件的对象。
var checkInfo = eobj.checkInfo;//得到检验信息
var dispobj = eobj.parentNode.nextSibling.lastChild;//找到显示验证信息的对象

var c_title = "";//标题
var c_isnull = "";//是否为空
var c_option = "";//检查项
var c_value = "";//检查内容
//得取到相应的信息
var checks  = checkInfo.split(";");
c_title = checks[0];
c_isnull = checks[1].toUpperCase();
c_option = checks[2].toLowerCase();

c_value = eobj.value;

//非空校验
if(c_isnull == "NOTNULL"){

if(check_null(c_value.trim())){
   dispobj.innerHTML=c_title +"不能为空";
   dispobj.style.color="red";
   return false;
}else{
   //正则验证

if(check_option(c_option,c_value)){
   dispobj.innerHTML=c_title +"格式不正确";
   dispobj.style.color="red";
   return false;
}else{
   dispobj.innerHTML="";
   dispobj.style.color="green";
   return true;
}

}

}else{

 if(!check_null(c_value)){

//正则验证

if(check_option(c_option,c_value)){
   dispobj.innerHTML=c_title +"格式不正确";
   dispobj.style.color="red";
   return false;
}else{
   dispobj.innerHTML="";
   dispobj.style.color="green";
   return true;
  
}

}else{

   dispobj.innerHTML="";
   dispobj.style.color="green";
   return true;
}
}
}

//表单元素验证
function checkElment(eobj){
var checkInfo = eobj.getAttribute("checkInfo");//得到检验信息
//alert(checkInfo);
//return false;

if(checkInfo == undefined)
return new FormMessage('不进行验证','不进行验证',true);

if(eobj.getAttribute("notcheck")=="true"){
return new FormMessage('不进行验证','不进行验证',true);
}

//var dispobj = eobj.parentNode.nextSibling.lastChild;//找到显示验证信息的对象

var c_title = "";//标题
var c_isnull = "";//是否为空
var c_option = "";//检查项
var c_value = "";//检查内容
//得取到相应的信息
var checks  = checkInfo.split(";");
c_title = checks[0];
c_isnull = checks[1].toUpperCase();
c_option = checks[2].toLowerCase();

c_value = eobj.value;

//非空校验
if(c_isnull == "NOTNULL"){
if(check_null(c_value) && c_value.trim() ==""){
 //  dispobj.innerHTML=c_title +"不能为空";
 //  dispobj.style.color="red";
   return new FormMessage(c_title,'不能为空',false);
}else{
   //正则验证

if(check_option(c_option,c_value)){
  // dispobj.innerHTML=c_title +"格式不正确";
 //  dispobj.style.color="red";
   return new FormMessage(c_title,'格式不正确',false);
}else{
  // dispobj.innerHTML="验证信息通过";
  // dispobj.style.color="green";
   return new FormMessage(c_title,'验证通过',true);
}

}

}else{
 if(!check_null(c_value)){

//正则验证

if(check_option(c_option,c_value)){
   //dispobj.innerHTML=c_title +"格式不正确";
   //dispobj.style.color="red";
   return new FormMessage(c_title,'格式不正确',false);
}else{
 //  dispobj.innerHTML="验证信息通过";
//   dispobj.style.color="green";
   return new FormMessage(c_title,'验证通过',true);
}
}
   return new FormMessage(c_title,'验证通过',true);
}
}

function FormMessage(title,content,hasPass){
this.title = title;
this.content = content;
this.hasPass = hasPass;
this.toString=  function(){
  var message="验证信息：["+title+"]"+content;
  return message;
}
}

//表单验证
function checkForm(form,spyj){
 var els =  form.elements;
 for(var i=0 ; i<els.length; i++){
   var eobj = els[i];
   if(spyj!='归档'){
   var formMessage = checkElment(eobj);
   if(!(formMessage.hasPass)){
    alert(formMessage.toString());
    eobj.focus();
    return false;
   }
	}
  }
  return true;
 }

function resettask(){
  document.getElementById("title").value="";
  document.getElementById("content").value="";
  document.getElementById("recuserdesc").value="";
  document.getElementById("addtaskdate").value=""; 
  var imporlever=document.getElementsByName("imporlever");
  for(var i=0;i<imporlever.length;i++){
    if(imporlever[i].value=="2"){
       imporlever[i].checked=true;
    }
  }
  var tasktype=document.getElementsByName("tasktype");
  for(var i=0;i<tasktype.length;i++){
    if(tasktype[i].value=="1"){
       tasktype[i].checked=true;
    }
  }
}
//校验文本框中的字数多少 
// str 文本提示信息,mylen限制字数,elementName 标签
function checkFont(str,mylen,elementName){
   	var len=0;
    var elementNameStr=elementName.value;
   if(elementNameStr!=""){
   for (var i = 0; i < elementNameStr.length; i++)
	{
		ch = elementNameStr.charAt(i);
		if ((ch<0) || (ch>255)) len=len+2;
		else len++;
	}
	if(len>mylen){
	  elementName.focus();	 
	  alert(str+"不能大于"+mylen+",现长度为："+elementNameStr.length); 
	  return false;	 
	}
	}
	 return true;
 }
