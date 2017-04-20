/*�绰����������ֻ�
����(1)�绰���������֡�"("��")"��"-"����
����(2)�绰����Ϊ3��8λ
����(3)����绰�����а��������ţ���ô����Ϊ��λ����λ
����(4)������"("��")"��"-"���������ָ���
����(5)�ƶ��绰����Ϊ11��12λ�����Ϊ12λ,��ô��һλΪ0
����(6)11λ�ƶ��绰����ĵ�һλ�͵ڶ�λΪ"13"
����(7)12λ�ƶ��绰����ĵڶ�λ�͵���λΪ"13"
*/
function isPhoneCheck(s) {
	var str=s;
	var reg=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/
	return reg.test(str);
}

function isPhone(s) {
	var str=s;
	var reg=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/
	return reg.test(str);
}

//�绰������,�������ֻ�
function phoneCheck(s) {
	var str=s;
	var reg=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)/
	return reg.test(str);
}

//�ֻ�������
function checkMobilePhone(phone){
	var str=phone;
	var reg=/(^0{0,1}13[0-9]{9}$)/
	return reg.test(str);
}

//���֤���
function isIdCardNo(num){
	if (isNaN(num)) {
		return false;
	}
	var len = num.length, re; 
	if (len == 15)
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
		re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
	else {
		return false;
	}
	var a = num.match(re);
	if (a != null){
		if (len==15){
			var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
			var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
		}
		else{
			var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);
			var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
		}
		if (!B) {
			return false;
		}
	}
	return true;
}

//IP��ַ��֤
function isip(s){
	var check=function(v){try{return (v != "" && v<=255 && v>=0)}catch(x){return false}};
	var re=s.split(".")
	return (re.length==4)?(check(re[0]) && check(re[1]) && check(re[2]) && check(re[3])):false
}

/*
	�������ƣ�trim
	��������: ȥ���ַ���ͷ����β���Ŀո�
	����������ַ�������
	����������������Ӵ�
*/
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

//����Ƿ��пո�
function checkSpace(str){
	if(str.indexOf(" ") != -1 ){
		return true;
	}
}

//��֤����ʱ���Ƿ��ڵ�ǰʱ����ǰ.
function isBeforeNow(oldDate){
    if(oldDate == null){
        return false;
    }
    var startDate = new Date();
    var endDate = new Date(getFormatDate(oldDate));
    if ((endDate - startDate) < 0){
        return true;
    }
    return false;
}

//�Ƚ�ǰһʱ���Ƿ��ں�һʱ��ǰ��
function isBeforeDate(start, end){
    if(start == null || end == null){
        return true;
    }
    var startDate = new Date(getFormatDate(start));
    var endDate = new Date(getFormatDate(end));
    if ((endDate - startDate) < 0){
        return false;
    }
    return true;
}

function getFormatDate(strDate){
    var linkStr = "";
    if(strDate.indexOf("-") != -1){
        linkStr = "-";
    }
    if(strDate.indexOf("/") != -1){
        linkStr = "/";
    }
    var arrDate = strDate.split(linkStr);
    return arrDate[1]*1 + "-" + arrDate[2]*1 + "-" + arrDate[0]*1;
}

function formatDate(date){
    if (date == null)
        return null;
    var ret = date.getYear() + "-";
    var month = date.getMonth() + 1;
    if (month < 10)
        ret += "0" + month;
    else
        ret += month;
    
    ret += "-";
    
    var day = date.getDate();
    if (day < 10)
        ret += "0" + day;
    else
        ret += day;

    return ret;
}

//�Ƿ�����ȷ�����ڸ�ʽ.
function isValidDate(day, month, year) {
	if (month < 1 || month > 12) {
		return false;
	}
	if (day < 1 || day > 31) {
		return false;
	}
	if ((month == 4 || month == 6 || month == 9 || month == 11) &&
		(day == 31)) {
		return false;
	}
	if (month == 2) {
		var leap = (year % 4 == 0 &&
				   (year % 100 != 0 || year % 400 == 0));
		if (day>29 || (day == 29 && !leap)) {
			return false;
		}
	}
	return true;
}


/*  �������ܣ��жϴ�������Ƿ�Ϊyyyy-mm-dd��
			  yyyy/mm/dd��ʽ����ȷ����
			  2001/01/2��2001-3-04Ҳ������ĸ�ʽ
			  ����ǣ��򷵻�һ����Ӧ�����ڶ���
			  ������򷵻�false
*/
function isDate(strDate){
	var regYear = /\d{4}[-/]/g;	//year pattern
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
	if (chrSeperator == "-")
		regMonth = /\d{1,2}[-]/g;
	else
		regMonth = /\d{1,2}[/]/g;
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

//�Ƿ���ʱ���ʽ
function isTime(strTime){
    if (strTime == null || strTime == "")
        return false;
    var pos = strTime.indexOf(":");
    if (pos == -1)
        return false;
    var h = strTime.substr(0, pos);
    if (h.length > 2 || !isInt(h))
        return false;
    if (h * 1 < 0 || h * 1 >= 24)
        return false;
    var m = strTime.substr(pos + 1);
    if (m.length > 2 || !isInt(m))
        return false;
    if (m < 0 || m >=60)
        return false; 
    
    return true;
}

//��֤��������
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

//�Ƿ����������
function isAllDigits(argvalue) {
	argvalue = argvalue.toString();
	var validChars = "0123456789";
	var startFrom = 0;
	if (argvalue.substring(0, 2) == "0x") {
	   validChars = "0123456789abcdefABCDEF";
	   startFrom = 2;
	} else if (argvalue.charAt(0) == "0") {
	   validChars = "01234567";
	   startFrom = 1;
	} else if (argvalue.charAt(0) == "-") {
		startFrom = 1;
	}
	
	for (var n = startFrom; n < argvalue.length; n++) {
		if (validChars.indexOf(argvalue.substring(n, n+1)) == -1) return false;
	}
	return true;
}

//�Ƿ����������
function isInt(n) {
	var ch=n.charAt(0);
	if(ch == "0") return false;

	var i = parseInt(n*1);

	if (i == NaN) {
		return false;
	}
	if (i != n){
		return false;
	}
	return true;
}

//�Ƿ�����ȷ���ʼ���ַ
function isEmail(emailStr) {
   if (emailStr.length == 0) {
	   return true;
   }
   var emailPat=/^(.+)@(.+)$/;
   var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
   var validChars="\[^\\s" + specialChars + "\]";
   var quotedUser="(\"[^\"]*\")";
   var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
   var atom=validChars + '+';
   var word="(" + atom + "|" + quotedUser + ")";
   var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
   var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
   var matchArray=emailStr.match(emailPat);
   if (matchArray == null) {
	   return false;
   }
   var user=matchArray[1];
   var domain=matchArray[2];
   if (user.match(userPat) == null) {
	   return false;
   }
   var IPArray = domain.match(ipDomainPat);
   if (IPArray != null) {
	   for (var i = 1; i <= 4; i++) {
		  if (IPArray[i] > 255) {
			 return false;
		  }
	   }
	   return true;
   }
   var domainArray=domain.match(domainPat);
   if (domainArray == null) {
	   return false;
   }
   var atomPat=new RegExp(atom,"g");
   var domArr=domain.match(atomPat);
   var len=domArr.length;
   if ((domArr[domArr.length-1].length < 2) ||
	   (domArr[domArr.length-1].length > 3)) {
	   return false;
   }
   if (len < 2) {
	   return false;
   }
   return true;
}

/*
	�������ƣ�checkString()
	��������: ���ܰ���&����������<��>��:��;�������ַ�;
		�Ϸ��ַ���32���ո񣩡�48~57�����֣���65~90����д�ַ�����95���»��ߣ���97~122��Сд�ַ�����>127�����֣���
	����ʱ�䣺2001/06/14
	����������ַ�������
	����������������Ӵ�
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


//��֤�Ƿ�Ϊ��ȷ��ID����.
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
	�������ƣ�selectToString(selectObject)
	��������: ��select�е�������ַ������Զ��ŷָ�
	���������select����
	����������ַ���
	����ʱ�䣺2001/08/30
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
	�������ƣ�CheckPostCode(str)
	��������: ����й��ʱ�ĺϷ���
	���������str���������ַ�
	���������true or false
	�޸�:�δ�(2003/12/25)
	����ʱ�䣺2001/10/10
*/
function CheckPostCode(str){
	if (trim(str) == ""){
		return false;
	}
	if(str.length != 6) return false;
	for (var i=0; i < str.length; i++){
		var ch=str.charAt(i);
		if ((ch != '0') && (ch != '1') && (ch != '2') && (ch != '3') && (ch != '4') && (ch != '5') && (ch != '6') && (ch != '7') && (ch != '8') && (ch != '9'))
			return false;
	}
	return true;
}

//�б�ҳ���ж�ѡ����Ŀ�ĸ���
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


//�������������������
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
//�������������������
function checkInt(inputElement){
	var str = inputElement.value;
	var inputCode = event.keyCode;
	if(!(inputCode>47 && inputCode<58)){
		event.returnValue=false;
	}
}

