//�绰������
function isPhone(phone)
{
	if(phone!=""&&phone.length<3)
	{
		alert("�绰��������Ϊ3λ!");
		return false;
	}
	hasNumericChar=true;  
	for (i = 0; i <  phone.length ; i++)
	{
		if( (phone.charAt(i)<'0' || phone.charAt(i)>'9') && phone.charAt(i)!='-'
		&& phone.charAt(i)!=')'
		&& phone.charAt(i)!='(')
		{
			alert("�绰����ֻ�������ֺ�'-,(,)'����!");
			return false;
		}
		if(hasNumericChar&&phone.charAt(i)>'0' && phone.charAt(i)<'9')
	  		hasNumericChar=false;
		if(hasNumericChar&&(i>=phone.length-1))
		{
	 		alert("�绰����ֻ�������ֺ�'-,(,)'����!");
	  		return false;
		}
	}
	return true;
}

//////////////////////////////////////
//�ֻ�������
function checkMobilePhone(phone)
{
	if(phone!=""&&phone.length<11)
	{
		alert("�Բ����ֻ���������Ϊ11λ������������!");
		return false;
	}
	hasNumericChar=true;  
	for (i = 0; i <  phone.length ; i++)
	{
		if( phone.charAt(i)<'0' || phone.charAt(i)>'9')
		{
			alert("�Բ��𣬵绰����ֻ����������ɣ�����������!");
			return false;
		}
		if(hasNumericChar&&phone.charAt(i)>'0' && phone.charAt(i)<'9')
	  		hasNumericChar=false;
		if(hasNumericChar&&(i>=phone.length-1))
		{
	 		alert("�Բ��𣬵绰����ֻ����������ɣ�����������!");
	  		return false;
		}
	}
	return true;
}

//////////////////////////////////////
//���֤��� add by liner
function checkIdcard(idcard)
{
	BirthYear  =  document.FORM.year.value ;
 BirthMonth =  document.FORM.month.value ;
 BirthDay   =  document.FORM.day.value ;
	IDCardLenth = idcard.length;
//���ж����֤�ŵ�λ���Ƿ�����ȷ��
 if  (!((IDCardLenth==15) ||  (IDCardLenth==18)))
   {
     window.alert("������������֤����λ�����ԣ�Ӧ��Ϊ15λ��18λ��");
	 document.FORM.idcard.focus();
	 return false;
   }
 //������֤����15λ�����ж��Ƿ�ȫ�����֣���������������
 if (IDCardLenth==15)
  {
    if (isNaN(idcard))
	  {
	  window.alert("���֤��Ϊ15λ��Ӧ��ȫ��Ϊ����")
	  document.FORM.idcard.focus();
	  return false;	  
	  }
	else  //�ѳ��������������֤�űȽϣ�
	  {  
	  IDBirth=BirthYear.substr(2,2) + BirthMonth + BirthDay;
	  if (IDBirth!=idcard.substr(6,6))
         {
		   window.alert("���֤��Ϊ15λ����������ڲ���")
		   document.FORM.idcard.focus();
	       return false;	  
		 }  
      }
  }
 if  (IDCardLenth==18)
  {
   if (isNaN(idcard.substr(0,17)))
      {
	   window.alert("���֤��Ϊ18λ��ǰ17Ӧ��ȫ��Ϊ����")
	   document.FORM.idcard.focus();
	   return false;	  
	  }
    else
	  {
	  	IDBirth=BirthYear + BirthMonth + BirthDay;  
		if (IDBirth!=idcard.substr(6,8))
         {
		   window.alert("���֤��Ϊ18λ����������ڲ���")
		   document.FORM.idcard.focus();
	       return false;	  
		 }  
 
      }  
  }
  return true;
}
//���֤��� add by SHAOJINGZE 
function checkIdcardNobirth(idcard)
{
 var IDCardLenth = idcard.length;
//���ж����֤�ŵ�λ���Ƿ�����ȷ��
 if  (!((IDCardLenth==15) ||  (IDCardLenth==18)))
   {
     window.alert("������������֤����λ�����ԣ�Ӧ��Ϊ15λ��18λ��");	 
	 return false;
   }
 //������֤����15λ�����ж��Ƿ�ȫ�����֣���������������
 if (IDCardLenth==15)
  {
    if (isNaN(idcard)) {
	  window.alert("���֤��Ϊ15λ��Ӧ��ȫ��Ϊ����");	  
	  return false;	  
	  }
  }
 if  (IDCardLenth==18)
  {
   if (isNaN(idcard.substr(0,17)))
      {
	   window.alert("���֤��Ϊ18λ��ǰ17Ӧ��ȫ��Ϊ����");	  
	   return false;	  
	  }
  }
  return true;
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

/*  �������ܣ��жϴ�������Ƿ�Ϊyyyy-mm-dd��
			  yyyy/mm/dd��ʽ����ȷ����
			  2001/01/2��2001-3-04Ҳ������ĸ�ʽ
			  ����ǣ��򷵻�һ����Ӧ�����ڶ���
			  ������򷵻�false
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
	�������ƣ�checkString()
	��������: ���ܰ���&����������<��>��:��;�������ַ�;
		�Ϸ��ַ���32���ո񣩡�48~57�����֣���65~90����д�ַ�����95���»��ߣ���97~122��Сд�ַ�����>127�����֣���
	��		�ߣ�����
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
	��	  �ߣ�����
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
	��������: ����ʱ�ĺϷ���
	���������str���������ַ�
	���������true or false
	��	  �ߣ�����
	����ʱ�䣺2001/10/10
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

//�б�ҳ��ҳ��ߴ��޸ĺ������ı仯
	function chngSize(){
		document.all("mainSpan").style.height=document.body.clientHeight-28;
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
//�б�ҳ���ж�ѡ����Ŀ���ַ���
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
	//�б�ҳ��ѡ������
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
	//ѡ��ͻ�
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
	//��ѯҳѡ���Ʒ
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
	�������ƣ�checkEnglish()
	��������: ���ܰ���&����������<��>��:��;�������ַ�;
		�Ϸ��ַ���48~57�����֣���65~90����д�ַ�����95���»��ߣ���97~122��Сд�ַ�����
	��		�ߣ���־��
	����ʱ�䣺2004/04/06
	����������ַ�������
	����������������Ӵ�
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