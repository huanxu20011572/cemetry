
/**
 * ����Cookie   ���   
 * @param name
 * @param value
 * @return
 */
function SetCookie(name,value,days)
{
	var Days = 30;
	if(typeof(days)=="undefined"||isNaN(days))
		Days=parseInt(days.toString());
     //�� cookie �������� 30 �� -1Ϊ������رա���
	if(Days!=-1){
		var exp = new Date();    //new Date("December 31, 9998");
		exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	}else{
		document.cookie = name + "="+ escape (value) + ";expires=-1";
	}
}

/**
 * ����Cookie ��ȡ   ��̨������escape����
 * @param name
 * @return
 */
function getCookie(name)
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return unescape(arr[2]); return null;
}
/**
 * ����Cookie ɾ��
 * @param name
 * @return
 */
function delCookie(name)
{   
	var exp = new Date();
    exp.setTime(exp.getTime() - (86400 * 1000 * 1));
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie = name + "="+ escape (cval) + ";expires="+exp.toGMTString();
}

/**
 * ����ID��ȡ����
 * @param objName
 * @return
 */
function GetObj(objName){
	if(typeof(objName)=="undefined")
		return null;
	if(document.getElementById)
		return eval('document.getElementById("'+objName+'")');
	else
		return eval('document.all.'+objName);
	
}
/**
 * ��String ���trim����
 */
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 }
/**
 * ��String���isNullOrempty�ķ���
 */
String.prototype.isnullorempty=function(){
	if(this==null||typeof(this)=="undefined"||this.trim()=="")
		return true;
	return false;
	
}

