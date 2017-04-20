//js��֤v1.0  author tianbao  created 2007-04-13 Email:tianbaolc@163.com
//ʹ��˵ʱ��input ����� checkInfo �ĸ�ʽΪ: ����;�Ƿ�Ϊ��;����ѡ��
//checkForm������֤��
//�ɰ����������չ
function PatrnsArray(){
var patrns = new Array();
patrns['patrn1'] = /^\d*$/ //�Ǹ������������� + 0��
patrns['patrn2'] = /^[0-9]*[1-9][0-9]*$/   //������
patrns['patrn3'] = /^((-\d+)|(0+))$/   //���������������� + 0��
patrns['patrn4'] = /^-[0-9]*[1-9][0-9]*$/  //������
patrns['patrn5'] = /^-?\d+$/   //������
patrns['patrn6'] = /^\d+(\.\d+)?$/   //�Ǹ����������������� + 0)
patrns['patrn7'] = /^((-\d+(\.\d+)?)|(0+(\.0+)?))$/   //�������������������� + 0��
patrns['patrn8'] = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/   //��������
patrns['patrn9'] = /^(-?\d+)(\.\d+)?$/  //������
patrns['patrn10']= /^[A-Za-z]+$/   //26��Ӣ����ĸ
patrns['patrn11'] = /^[A-Z]+$/  //26����дӢ����ĸ
patrns['patrn12'] = /^[a-z]+$/  //26��СдӢ����ĸ
patrns['patrn13'] = /^[A-Za-z0-9]+$/  //��������ĸ���
patrns['patrn14'] = /^\w+$/  //�����֡�26��Ӣ����ĸ�����»�����ɵ��ַ���
patrns['patrn15'] = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/  //email��ַ
patrns['patrn15'] = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/  //email��ַ
patrns['patrn16'] = /^\d{4}-[0-1][0-9]-[0-3][0-9]\s[0-2][0-9]:[0-6][0-9]$/  //������֤�����Ϊ yyyy-MM-dd HH:mm
patrns['patrn17'] = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/   //��������
patrns['patrn18'] = /^[A-Z|a-z]{4}[0-9]{7}$/  //��ֵ����Ϊ4����ĸ+7������
patrns['patrn19'] = /^.{2000}$/  //��ֵ����Ϊ4����ĸ+7������
return patrns;
}

//��֤�Ƿ�Ϊ��
function check_null(str)
{
 return str.replace(/<[^>]*>/g,"")=="";
}
String.prototype.trim=function(){  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}
/**//*
��;����������ַ����Ƿ�Ϊ�ջ���ȫ�����ǿո�
���룺str
���أ�
���ȫ�ǿշ���true,���򷵻�false
*/
function isNull( str ){
	if ( str == "" ) return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

//��֤�Ƿ�Ϊ����
function check_option(str,value){ 
   if(str.toUpperCase() == "NO")
   return;
   return ! (new PatrnsArray())[str].test(value);
  // return patrn.exec(value)==null; //���ز��ҵ�������
  // return value.match(patrn)==null; //���ز��ҵ�������
  
}

function checkInput(){

event.cancelBubble=true;//ȡ���¼���ð�ݶ���
var eobj=event.srcElement;//��ȡ�����¼��Ķ���
var checkInfo = eobj.checkInfo;//�õ�������Ϣ
var dispobj = eobj.parentNode.nextSibling.lastChild;//�ҵ���ʾ��֤��Ϣ�Ķ���

var c_title = "";//����
var c_isnull = "";//�Ƿ�Ϊ��
var c_option = "";//�����
var c_value = "";//�������
//��ȡ����Ӧ����Ϣ
var checks  = checkInfo.split(";");
c_title = checks[0];
c_isnull = checks[1].toUpperCase();
c_option = checks[2].toLowerCase();

c_value = eobj.value;

//�ǿ�У��
if(c_isnull == "NOTNULL"){

if(check_null(c_value.trim())){
   dispobj.innerHTML=c_title +"����Ϊ��";
   dispobj.style.color="red";
   return false;
}else{
   //������֤

if(check_option(c_option,c_value)){
   dispobj.innerHTML=c_title +"��ʽ����ȷ";
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

//������֤

if(check_option(c_option,c_value)){
   dispobj.innerHTML=c_title +"��ʽ����ȷ";
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

//��Ԫ����֤
function checkElment(eobj){
var checkInfo = eobj.getAttribute("checkInfo");//�õ�������Ϣ
//alert(checkInfo);
//return false;

if(checkInfo == undefined)
return new FormMessage('��������֤','��������֤',true);

if(eobj.getAttribute("notcheck")=="true"){
return new FormMessage('��������֤','��������֤',true);
}

//var dispobj = eobj.parentNode.nextSibling.lastChild;//�ҵ���ʾ��֤��Ϣ�Ķ���

var c_title = "";//����
var c_isnull = "";//�Ƿ�Ϊ��
var c_option = "";//�����
var c_value = "";//�������
//��ȡ����Ӧ����Ϣ
var checks  = checkInfo.split(";");
c_title = checks[0];
c_isnull = checks[1].toUpperCase();
c_option = checks[2].toLowerCase();

c_value = eobj.value;

//�ǿ�У��
if(c_isnull == "NOTNULL"){
if(check_null(c_value) && c_value.trim() ==""){
 //  dispobj.innerHTML=c_title +"����Ϊ��";
 //  dispobj.style.color="red";
   return new FormMessage(c_title,'����Ϊ��',false);
}else{
   //������֤

if(check_option(c_option,c_value)){
  // dispobj.innerHTML=c_title +"��ʽ����ȷ";
 //  dispobj.style.color="red";
   return new FormMessage(c_title,'��ʽ����ȷ',false);
}else{
  // dispobj.innerHTML="��֤��Ϣͨ��";
  // dispobj.style.color="green";
   return new FormMessage(c_title,'��֤ͨ��',true);
}

}

}else{
 if(!check_null(c_value)){

//������֤

if(check_option(c_option,c_value)){
   //dispobj.innerHTML=c_title +"��ʽ����ȷ";
   //dispobj.style.color="red";
   return new FormMessage(c_title,'��ʽ����ȷ',false);
}else{
 //  dispobj.innerHTML="��֤��Ϣͨ��";
//   dispobj.style.color="green";
   return new FormMessage(c_title,'��֤ͨ��',true);
}
}
   return new FormMessage(c_title,'��֤ͨ��',true);
}
}

function FormMessage(title,content,hasPass){
this.title = title;
this.content = content;
this.hasPass = hasPass;
this.toString=  function(){
  var message="��֤��Ϣ��["+title+"]"+content;
  return message;
}
}

//����֤
function checkForm(form,spyj){
 var els =  form.elements;
 for(var i=0 ; i<els.length; i++){
   var eobj = els[i];
   if(spyj!='�鵵'){
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
//У���ı����е��������� 
// str �ı���ʾ��Ϣ,mylen��������,elementName ��ǩ
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
	  alert(str+"���ܴ���"+mylen+",�ֳ���Ϊ��"+elementNameStr.length); 
	  return false;	 
	}
	}
	 return true;
 }
