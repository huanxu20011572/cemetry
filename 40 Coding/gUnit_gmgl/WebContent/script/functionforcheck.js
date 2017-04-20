//电话号码检查
function isPhone(phone)
{
	if(phone!=""&&phone.length<3)
	{
		alert("电话号码至少为3位!");
		return false;
	}
	hasNumericChar=true;  
	for (i = 0; i <  phone.length ; i++)
	{
		if( (phone.charAt(i)<'0' || phone.charAt(i)>'9') && phone.charAt(i)!='-'
		&& phone.charAt(i)!=')'
		&& phone.charAt(i)!='(')
		{
			alert("电话号码只能由数字和'-,(,)'构成!");
			return false;
		}
		if(hasNumericChar&&phone.charAt(i)>'0' && phone.charAt(i)<'9')
	  		hasNumericChar=false;
		if(hasNumericChar&&(i>=phone.length-1))
		{
	 		alert("电话号码只能由数字和'-,(,)'构成!");
	  		return false;
		}
	}
	return true;
}

//////////////////////////////////////
//手机号码检查
function checkMobilePhone(phone)
{
	if(phone!=""&&phone.length<11)
	{
		alert("对不起，手机号码至少为11位，请重新输入!");
		return false;
	}
	hasNumericChar=true;  
	for (i = 0; i <  phone.length ; i++)
	{
		if( phone.charAt(i)<'0' || phone.charAt(i)>'9')
		{
			alert("对不起，电话号码只能由数字组成，请重新输入!");
			return false;
		}
		if(hasNumericChar&&phone.charAt(i)>'0' && phone.charAt(i)<'9')
	  		hasNumericChar=false;
		if(hasNumericChar&&(i>=phone.length-1))
		{
	 		alert("对不起，电话号码只能由数字组成，请重新输入!");
	  		return false;
		}
	}
	return true;
}

//////////////////////////////////////
//身份证检查 add by liner
function checkIdcard(idcard)
{
	BirthYear  =  document.FORM.year.value ;
 BirthMonth =  document.FORM.month.value ;
 BirthDay   =  document.FORM.day.value ;
	IDCardLenth = idcard.length;
//先判断身份证号的位数是否则正确。
 if  (!((IDCardLenth==15) ||  (IDCardLenth==18)))
   {
     window.alert("您所输入的身份证号码位数不对，应该为15位或18位！");
	 document.FORM.idcard.focus();
	 return false;
   }
 //如果身份证号是15位，则判断是否全是数字，且与出生日期相符
 if (IDCardLenth==15)
  {
    if (isNaN(idcard))
	  {
	  window.alert("身份证号为15位，应该全部为数字")
	  document.FORM.idcard.focus();
	  return false;	  
	  }
	else  //把出生年月日与身份证号比较！
	  {  
	  IDBirth=BirthYear.substr(2,2) + BirthMonth + BirthDay;
	  if (IDBirth!=idcard.substr(6,6))
         {
		   window.alert("身份证号为15位，与出生日期不符")
		   document.FORM.idcard.focus();
	       return false;	  
		 }  
      }
  }
 if  (IDCardLenth==18)
  {
   if (isNaN(idcard.substr(0,17)))
      {
	   window.alert("身份证号为18位，前17应该全部为数字")
	   document.FORM.idcard.focus();
	   return false;	  
	  }
    else
	  {
	  	IDBirth=BirthYear + BirthMonth + BirthDay;  
		if (IDBirth!=idcard.substr(6,8))
         {
		   window.alert("身份证号为18位，与出生日期不符")
		   document.FORM.idcard.focus();
	       return false;	  
		 }  
 
      }  
  }
  return true;
}
//身份证检查 add by SHAOJINGZE 
function checkIdcardNobirth(idcard)
{
 var IDCardLenth = idcard.length;
//先判断身份证号的位数是否则正确。
 if  (!((IDCardLenth==15) ||  (IDCardLenth==18)))
   {
     window.alert("您所输入的身份证号码位数不对，应该为15位或18位！");	 
	 return false;
   }
 //如果身份证号是15位，则判断是否全是数字，且与出生日期相符
 if (IDCardLenth==15)
  {
    if (isNaN(idcard)) {
	  window.alert("身份证号为15位，应该全部为数字");	  
	  return false;	  
	  }
  }
 if  (IDCardLenth==18)
  {
   if (isNaN(idcard.substr(0,17)))
      {
	   window.alert("身份证号为18位，前17应该全部为数字");	  
	   return false;	  
	  }
  }
  return true;
}

/*
	函数名称：trim
	函数功能: 去除字符串头部和尾部的空格
	传入参数：字符串变量
	传出结果：处理后的子串
*/
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function isEmpty(str) {
	return str.length==0;
}

function checkLength(str, minLen, maxLen) {
	return (str.length>=minLen)&&(str.length<=maxLen);
}

function isChn(d) {
 actlen=d.length;
 for(i=0;i<d.length;i++)
 if (d.substr(i,1)>"~")
    actlen+=1;
 if( actlen>d.length )
   return true;
 return false;
}

/*  函数功能：判断传入参数是否为yyyy-mm-dd或
			  yyyy/mm/dd格式的正确日期
			  2001/01/2和2001-3-04也是允许的格式
			  如果是，则返回一个对应的日期对象
			  如果否，则返回false
*/
function isDate(strDate){
	if(strDate.length==0)
		return true;
	//var regYear = /\d{4}[-/]/g;	//year pattern
	var regYear = /\d{4}[-]/g;	//year pattern
	var regMonth;
	var regDay =  /\d{1,2}/g;;
	var chrSeperator;
	var arr,str;
	if ((arr = regYear.exec(strDate)) == null)
		return false;
	var intYearlen = arr.lastIndex - arr.index - 1;
	if (arr.index != 0 || (intYearlen != 4 && intYearlen != 2))
		return false;
	str = arr[0];
	chrSeperator = str.charAt(str.length - 1);  // get the seperator ('-' or '/')
	intYear = parseInt(str.substr(0, str.length - 1));	// get the year
	if (intYear < 1900 || intYear > 2099)  //Error Year
		return false;

	strDate = strDate.substr(arr.lastIndex);
	//if (chrSeperator == "-")
		regMonth = /\d{1,2}[-]/g;
	//else
	//	regMonth = /\d{1,2}[/]/g;
	if ((arr = regMonth.exec(strDate)) == null)
		return false;
	if (arr.index != 0)
		return false;
	str = arr[0];
	if (str.charAt(0) == '0') {
		intMonth = parseInt(str.substr(1, str.length - 2)); // get the month
	} else {
		intMonth = parseInt(str.substr(0, str.length - 1)); // get the month
	}
	if (intMonth < 1 || intMonth > 12) //Error Month
		return false;

	strDate = strDate.substr(arr.lastIndex);

	if ((arr = regDay.exec(strDate)) == null)
		return false;
	if (arr.index != 0 || arr.lastIndex != strDate.length)
		return false;
	str = arr[0];
	if (str.charAt(0) == '0') {
		intDay = parseInt(str.substr(1, str.length - 1)); // get the day
	} else {
		intDay = parseInt(str); // get the day
	}
	if (intDay < 1 || intDay > 31)  //Error Day
		return false;

	datDate = new Date(intYear, intMonth - 1, intDay); //Test the Date
	if (isNaN(datDate))  //Error Date Format
		return false;
	if (datDate.getMonth() != intMonth - 1 || datDate.getDate() != intDay)  //invalid date such as '1999/02/29' and '1999/04/31'
		return false;
	return datDate;  //Return the Date in parsed format
}

function isBirthDate(d) {
	var first,second,yy,mm,dd;
	var today = new Date();
	if(d.indexOf("/")!=-1)
	{
		first=d.indexOf("/");
		second=d.lastIndexOf("/");
		if(second==first) return false;
		yy=parseInt(d.substring(0,first));
		if ( d.substr(first + 1, 1) == '0' )
			mm=parseInt(d.substring(first+2,second));
		else
			mm=parseInt(d.substring(first+1,second));
		if ( d.substr(second + 1, 1) == '0' )
			dd=parseInt(d.substring(second+2,d.length));
		else
			dd=parseInt(d.substring(second+1,d.length));
		if (isNaN(yy)) { //Error Year Format
			return false;
		}
		if (yy<30)
			yy += 2000;
		else if (yy <100 && yy >= 30)
			yy += 1900;
		if( yy < 1900 || yy>2069) return false;
		if (isNaN(mm) || mm < 1 || mm > 12) { //Error Month Format
			return false;
		}
		if (isNaN(dd) || dd < 1 || dd > 31) { //Error Month Format
			return false;
		}
		d = new Date(yy, mm - 1, dd); //Test the Date
		if (isNaN(d)) { //Error Date Format
			return false;
		}
		if (d.getMonth() != mm - 1 || d.getDate() != dd) { //invalid date such as '1999/02/29' and '1999/04/31'
			return false;
		}
		if ( yy + 16 > today.getFullYear() ) return false;
		return d.toLocaleString();  //Return the Date in parsed format
	}
	else if(d.indexOf("-")!=-1)
	{
		first=d.indexOf("-");
		second=d.lastIndexOf("-");
		if(second==first) return false;
		yy=parseInt(d.substring(0,first));
		if ( d.substr(first + 1, 1) == '0' )
			mm=parseInt(d.substring(first+2,second));
		else
			mm=parseInt(d.substring(first+1,second));
		if ( d.substr(second + 1, 1) == '0' )
			dd=parseInt(d.substring(second+2,d.length));
		else
			dd=parseInt(d.substring(second+1,d.length));
		if (isNaN(yy)) { //Error Year Format
			return false;
		}
		if (yy<30)
			yy += 2000;
		else if (yy <100 && yy >= 30)
			yy += 1900;
		if( yy < 1950 || yy>2069) return false;
		if (isNaN(mm) || mm < 1 || mm > 12) { //Error Month Format
			return false;
		}
		if (isNaN(dd) || dd < 1 || dd > 31) { //Error Month Format
			return false;
		}
		d = new Date(yy, mm - 1, dd); //Test the Date
		if (isNaN(d)) { //Error Date Format
			return false;
		}
		if (d.getMonth() != mm - 1 || d.getDate() != dd) { //invalid date such as '1999/02/29' and '1999/04/31'
			return false;
		}
		if ( yy + 16 > today.getFullYear() ) return false;
		return d.toLocaleString();  //Return the Date in parsed format
	}
	else
		return false;
}

function isInt(n) {
	var i = parseInt(n*1);
	if (i == NaN) {
		return false;
	}
	if (i != n){
		return false;
	}
	return true;
}

function isDecimal(str,f,n) {
    var p=str.indexOf(".");
    var int,flt;

    if(str=="") return true;
    if (p<0) { p=str.length ;}
    int=str.substr(0,p);
    flt=str.substr(p+1);
    if (isInt(int)==false) {
       return false;
    }
    if (flt!='') {
       if (isInt(flt)==false) {
          return false;
       }
    }
    if ((int.length > f-n) || (flt.length > n)) {
       return false;
    }
    return true;
}

function isMail(str) {
	if (trim(str) == ""){
		return true;
	}
    var a=str.indexOf("@")+1;
    var p=str.indexOf(".")+1;
    if(str.indexOf("'") > 0)
		return false;
	if(str.indexOf('"') > 0)
		return false;
    if (a<2)
       return false;
    if (p<1)
       return false;
    if (p<a+2)
       return false;
    if (str.length==p)
       return false;
    return true;
}

function isFloat(str) {
	var ch=str.charAt(0);
	if( ch == "." ) return false;
    for (var i=0; i < str.length; i++)
	{	ch=str.charAt(i);
		if ((ch != ".") && (ch != "0") && (ch != "1") && (ch != "2") && (ch != "3") && (ch != "4") && (ch != "5") && (ch != "6") && (ch != "7") && (ch != "8") && (ch != "9"))
			return false;
	}
    return true;
}

function isNumber(str) {    
    for (var i=0; i < str.length; i++)
	{	var ch=str.charAt(i);
		if ((ch != "0") && (ch != "1") && (ch != "2") && (ch != "3") && (ch != "4") && (ch != "5") && (ch != "6") && (ch != "7") && (ch != "8") && (ch != "9"))
			return false;
	}
    return true;
}

function CheckUserInput(vstrInput) {
	var intIndex;
	var intCharCount;
	for(intIndex = 0; intIndex < vstrInput.length; intIndex++){
		if (vstrInput.charCodeAt(intIndex) < 48)
			return false;
		if ((vstrInput.charCodeAt(intIndex) > 57) && (vstrInput.charCodeAt(intIndex) < 64))
			return false;
		if ((vstrInput.charCodeAt(intIndex) > 90) && (vstrInput.charCodeAt(intIndex) < 97))
			return false;
		if (vstrInput.charCodeAt(intIndex) > 122)
			return false;
	}
	return true;
}
function isPhone(str){
	var intIndex;
	var intCharCount;
	for(intIndex = 0; intIndex < str.length; intIndex++){
		if(str.charCodeAt(intIndex) < 32)
			return false;
		if(str.charCodeAt(intIndex) == 34)
			return false;
		if(str.charCodeAt(intIndex) == 39)
			return false;
		if(str.charCodeAt(intIndex) > 126)
			return false;
	}
	return true;
}

/*
	函数名称：checkString()
	函数功能: 不能包含&、’、”、<、>、:、;等特殊字符;
		合法字符：32（空格）、48~57（数字）、65~90（大写字符）、95（下划线）、97~122（小写字符）、>127（汉字）。
	作		者：蒲林
	创建时间：2001/06/14
	传入参数：字符串变量
	传出结果：处理后的子串
*/
function checkString(str){
	var strChar = str;
	var isValid = true;
	for (var i = 0; i < str.length; i++){
		if ( (str.charCodeAt(i) == 32) || ((str.charCodeAt(i) >= 48) && (str.charCodeAt(i) <= 57)) || ((str.charCodeAt(i) >= 65) && (str.charCodeAt(i) <= 90)) || (str.charCodeAt(i) == 95) || ((str.charCodeAt(i) >= 97) && (str.charCodeAt(i) <= 122)) || (str.charCodeAt(i) > 127) ) {
			// do nothing
		} else {
			isValid = false;
			break;
		}
	}
	return isValid;
}
function checkLoginid(str){
	if(str.length==0)
	return false;
	var strChar = str;	
	var isValid = true;
	for (var i = 0; i < str.length; i++){
		if ( (str.charCodeAt(i) == 32) || ((str.charCodeAt(i) >= 48) && (str.charCodeAt(i) <= 57)) || ((str.charCodeAt(i) >= 65) && (str.charCodeAt(i) <= 90)) || (str.charCodeAt(i) == 95) || ((str.charCodeAt(i) >= 97) && (str.charCodeAt(i) <= 122)) || (str.charCodeAt(i) > 127) ) {
			// do nothing
		} else {
			isValid = false;
			break;
		}
	}
	return isValid;
}
/*
	函数名称：selectToString(selectObject)
	函数功能: 将select中的项组成字符串，以逗号分隔
	传入参数：select对象
	传出结果：字符串
	作	  者：吕锴
	创建时间：2001/08/30
*/
function selectToString(selectObject){
	var str = "";
	for(var i = 0; i < selectObject.length; i++){
		str = str + selectObject(i).value + ",";
	}
	if(str.substr(str.length - 1, 1) == ",")
		str = str.substr(0, str.length - 1);
	return str;
}
/*
	函数名称：CheckPostCode(str)
	函数功能: 检查邮编的合法性
	传入参数：str——输入字符
	传出结果：true or false
	作	  者：蒲林
	创建时间：2001/10/10
*/
function CheckPostCode(str){
	if (trim(str) == ""){
		return true;
	}
	for (var i=0; i < str.length; i++){
		var ch=str.charAt(i);
		if ((ch != "0") && (ch != "1") && (ch != "2") && (ch != "3") && (ch != "4") && (ch != "5") && (ch != "6") && (ch != "7") && (ch != "8") && (ch != "9"))
			return false;
		else
			return true;
	}
}

//列表页中页面尺寸修改后做出的变化
	function chngSize(){
		document.all("mainSpan").style.height=document.body.clientHeight-28;
	}
//列表页中判断选择项目的个数
	function selCount(){
		if(document.all("chkItem")==null){
			return -1;
		}
		if(typeof(document.all("chkItem").length)=="undefined"){
			if(document.all("chkItem").checked){
				return 1;
			}
			return 0;
		}else{
			var j=0;
			for(var i=0;i<document.all("chkItem").length;i++){
				if(document.all("chkItem")(i).checked){
					j++;
				}
			}
			return j;
		}
	}
//列表页中判断选择项目的字符串
	function selItem(){
        var strItem = "";
		if(document.all("chkItem")==null){
			return strItem;
		}
		if(typeof(document.all("chkItem").length)=="undefined"){
			if(document.all("chkItem").checked){
				strItem = document.all("chkItem").value;
                return strItem;
			}
			return 0;
		}else{
			var j=0;
			for(var i=0;i<document.all("chkItem").length;i++){
				if(document.all("chkItem")(i).checked){
					strItem += "," + document.all("chkItem")(i).value;
				}
			}
            if(strItem!=""){
                strItem=strItem.substring(1,strItem.length);
            }
			return strItem;
		}
	}
	//列表页中选择框操作
	function chksel(){
		if(event.srcElement.name=="chkItem"){
			if(document.all("chkItem")==null){
				return;
			}
			if(typeof(document.all("chkItem").length)=="undefined"){
				if(document.all("chkItem").checked){
					document.all("chkAll").checked=true;
					return;
				}
				document.all("chkAll").checked=false;
			}else{
				for(var i=0;i<document.all("chkItem").length;i++){
					if(!document.all("chkItem")(i).checked){
						document.all("chkAll").checked=false;
						return;
					}
				}
				document.all("chkAll").checked=true;
			}
		}
		if(event.srcElement.name=="chkAll"){
			if(document.all("chkItem")==null){
				return;
			}
			if(document.all("chkAll").checked){
				if(typeof(document.all("chkItem").length)=="undefined"){
					document.all("chkItem").checked=true;
				}else{
					for(var i=0;i<document.all("chkItem").length;i++){
						document.all("chkItem")(i).checked=true;
					}
				}
			}else{
				if(typeof(document.all("chkItem").length)=="undefined"){
					document.all("chkItem").checked=false;
				}else{
					for(var i=0;i<document.all("chkItem").length;i++){
						document.all("chkItem")(i).checked=false;
					}
				}
			}
		}
	}
	//检查输入框的输入是数字
	function checkNumber(inputElement){
		var str = inputElement.value;
		var inputCode = event.keyCode;
		if(inputCode == 46){
			if(str.indexOf(".")>=0){
				event.returnValue=false;
			}
			return;
		}
		if(!(inputCode>47 && inputCode<58)){
			event.returnValue=false;
		}
	}
	//检查输入框的输入是整数
	function checkInt(inputElement){
		var str = inputElement.value;
		var inputCode = event.keyCode;
		if(!(inputCode>47 && inputCode<58)){
			event.returnValue=false;
		}
	}
	//选择客户
	function selCustom(curElement,filePath){
		var selCustomFilePath;
		if(filePath==null || filePath == ''){
			selCustomFilePath = "selCustom.jsp"
		}else{
			selCustomFilePath = filePath;
		}
        try{
            if (curElement.tagName == "INPUT"){
		        strCustomName = curElement.value;
            }
            else{
                strCustomName = "";
            }
        }catch (e){
            strCustomName = "";
        }
		window.showModalDialog(selCustomFilePath + "?token=" + strCustomName + "&rdm=" + Math.round(Math.random() * 100000000),curElement,"dialogHeight: 360px; dialogWidth: 500px; center: Yes; help: No; resizable: No; status: no;");
	}
	//查询页选择产品
	function selProduct(curElement,filePath){
		var selProductFilePath;
		if(filePath==null || filePath == ''){
			selProductFilePath = "productList.jsp"
		}else{
			selProductFilePath = filePath;
		}
        try{
            if (curElement.tagName == "INPUT"){
		        strProductName = curElement.value;
            }
            else{
                strProductName = "";
            }
        }catch (e){
            strProductName = "";
        }
		window.showModalDialog(selProductFilePath + "?token=" + strProductName + "&rdm=" + Math.round(Math.random() * 100000000),curElement,"dialogHeight: 360px; dialogWidth: 500px; center: Yes; help: No; resizable: No; status: no;");
	}
	function popUp(text,refElement,height,width,offTop,offLeft)
	{
	    var oPopup = window.createPopup();
	    var oPopBody = oPopup.document.body;
		if(offTop == null){offTop = 20}
		if(offLeft == null){offLeft = 0}
		if(height == null){height = 20}
		if(width == null){width = 160}
		oPopBody.style.backgroundColor = "lightyellow";
		oPopBody.style.border = "black 1px solid";
	    oPopBody.innerHTML = "<font style='font-size:12px'>" + text + "</font>";
	    refElement.focus();
	    oPopup.show(offLeft, offTop, width, height, refElement);
	}
	
	/*
	函数名称：checkEnglish()
	函数功能: 不能包含&、’、”、<、>、:、;等特殊字符;
		合法字符：48~57（数字）、65~90（大写字符）、95（下划线）、97~122（小写字符）。
	作		者：吕志兴
	创建时间：2004/04/06
	传入参数：字符串变量
	传出结果：处理后的子串
*/
function checkEnglish(str){
	var strChar = str;
	var isValid = true;
	for (var i = 0; i < str.length; i++){
		if ( ((str.charCodeAt(i) >= 48) && (str.charCodeAt(i) <= 57)) || ((str.charCodeAt(i) >= 65) && (str.charCodeAt(i) <= 90)) || (str.charCodeAt(i) == 95) || ((str.charCodeAt(i) >= 97) && (str.charCodeAt(i) <= 122))) {
			// do nothing
		} else {
			isValid = false;
			break;
		}
	}
	return isValid;
}