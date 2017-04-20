String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, '');
}
String.prototype.search2 = function(str)
{
    if(str.indexOf("(")!=-1||str.indexOf(")")!=-1){
    	return -1;
    }
    str=str.trim();
    return this.search(str);
}

/**
 * ����У���С�����������Ϊ��λ
 * oObject Ϊ�ؼ����ƣ�һ��Ϊtext�ؼ�
 * leng Ϊ����������ֵ
 * У��ͨ������true��������־�����Ϣ������false
 */
function checkMoney(oObject,leng){
	var realLength = parseInt(leng);

	//���Ϊ�գ���ͨ��У��
	if(oObject.value == "")
		return true;

	//У���Ƿ��ǺϷ����֣�ֻ���������ֺ�С����.
	if(!(/^[\d|.|-]*$/g.test(oObject.value))){	
		oObject.select();
		return false;
	}

	var valueOfNum = parseFloat(oObject.value);	
	//У��Ǯ�ҵĸ�ʽ
	if(/\.{1}/.test(oObject.value)) {
		if(/^(-?)(\d+)\.(\d{1,2})$/.test(oObject.value)) {
	
			if(valueOfNum <= realLength)
				return true;
			else{
				oObject.select();
				return false;
			}
		}
		else{
			oObject.select();
			return false;
		}
	}
	else{
		var valueOfIntNum = parseInt(oObject.value);
		if(valueOfIntNum <= realLength)
			return true;
		else{
			oObject.select();
			return false;
		}
	}
}


/**
 * ����У�����������ʾ��Ϣ
 * oObject Ϊ�ؼ����ƣ�һ��Ϊtext�ؼ�
 * alertIsEmpty Ϊ�յ���ʾ��Ϣ
 * alertIsValid ����Ǯ�Ҹ�ʽ���ύ��Ϣ
 * У��ͨ��������ʾ��Ϣ���ַ���
 */
function checkMoneyAlert(oObject,alertIsEmpty,alertIsValid){
	if(isEmpty(oObject)){
		return alertIsEmpty;
	}else if(!checkMoney(oObject,999999999999)){
		return alertIsValid;
	}

	return "";
}

/**
 * �Ƿ�Ϊ��
 * oObject Ϊ�ؼ����ƣ�һ��Ϊtext�ؼ�
 */
function isEmpty(oObject){
	return isEmptyByCondition(oObject," ��");
}

/**
 * �Ƿ�Ϊ��
 * oObject Ϊ�ؼ����ƣ�һ��Ϊtext�ؼ�
 * condition Ϊ�յ�����
 */
function isEmptyByCondition(oObject,condition){
	//�Ƿ��д���
	var isError=false;
	if (condition.search(oObject.value)!=-1) {
		isError=true;
	}
	return isError;
}


/**
 * ����У�����������ʾ��Ϣ
 * oObject Ϊ�ؼ����ƣ�һ��Ϊtext�ؼ�
 * alertIsEmpty Ϊ�յ���ʾ��Ϣ
 * alertIsValid ����Ǯ�Ҹ�ʽ���ύ��Ϣ
 * У��ͨ��������ʾ��Ϣ���ַ���
 */
function parseMoney(oObject){
	var s=0;
	if(!isEmpty(oObject)&&checkMoney(oObject,999999999999)){		
		s=parseFloat(oObject.value);
	}
	return s;
}

//У����������
function isPostalCode(s)
{
    //var patrn=/^[a-zA-Z0-9]{3,12}$/;
    var patrn=/^[0-9 ]{6}$/;
    if (patrn.exec(s)) return true;
    return false;
}

//У���Ƿ�ȫ���������
function isDigit(s)
{
    var patrn=/^[0-9]{1,20}$/;
    if (!patrn.exec(s)) {
        return false;
    }
    return true;
}



//У���Ƿ�ȫ��С��
function isFloat2(oObject){

	//���Ϊ�գ���ͨ��У��
	if(oObject.value == "")
		return true;
	if(isDigit(oObject.value)){
		return true;
	}

	//У���Ƿ��ǺϷ����֣�ֻ���������ֺ�С����.
	if(!(/^[\d|.|-]*$/g.test(oObject.value))){	
		oObject.select();
		return false;
	}

	var valueOfNum = parseFloat(oObject.value);
	if(valueOfNum+""!=oObject.value){	
		oObject.select();
		return false;
	}

	if(/^(-?)(\d+)\.(\d{1,8})$/.test(oObject.value)) {
		return true;
	}else {
		return false;
	}

}


//------��ѡ����Ϊһ��
function  setValue_single(ele, eleSec){
    
    boxName = document.all(ele);
    hiddenBox =  document.all(eleSec);    
    //alert(boxName.name);        
    
    var checkValue="";
   
    if(boxName.checked){
        checkValue+=boxName.value+",";
    }
    
    
    if(checkValue != null && checkValue.length > 0){
        checkValue = "," + checkValue;
    }
    
    hiddenBox.value = checkValue;
   // alert(hiddenBox.value);

}




/**�ж��Ƿ��Ѿ�ѡ�����
		���ö���	checkbox/radio
		*objForm:	  'Form����'
		*obj:  			'ѡ���������'
	**/
	function checkSelected(objForm,obj){
        var isCheck = false;
        var ids = objForm[obj];    
                
        if(ids == null){
        	isCheck = false;
        	return isCheck;
        }
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked==true){
                  isCheck=true;
                  break;  
                }            
            }            
            
        }else{
            if(ids.checked==true)
                isCheck=true;
        }            
        
        return isCheck;	 
              
	}



function onRadio(radioName){
	var radiotype = document.all(radioName);
	var strSize=radiotype.length;	
	var size=parseInt(strSize);
	for(i=0;i<size;i++){
		if (radiotype[i].checked){
			return true;
		}
	}	
	
	return false;
}

function radioNoneCheck(radioName){   
	var radiotype = document.all(radioName);
	var strSize=radiotype.length;	
	var size=parseInt(strSize);
	for(i=0;i<size;i++){
		radiotype[i].value='';
	}	
	
	return false;
}


function emptyAlert(eleName,emptyeAlertMsg,emptyCondition,isSelected){
	var alertMsg="";
	var ele=document.all(eleName);	
	if (emptyCondition.search2(ele.value)!=-1) {
		alertMsg=emptyeAlertMsg;
		if(isSelected){
			ele.select();
		}
	}
	return alertMsg;
}

function biangengmingcheng(isBiangeng,biangeng,biangengqian,biangnegEmptyAlert,biangengqianAlert,biangengzhangtai,biangengzhuangtaiAlert,empty){
	var allAlertMsg="";
	if(!onRadio(biangeng)){
		allAlertMsg+=biangnegEmptyAlert
	}else{
		ele=document.all(biangeng);
		if(ele[0].checked && !isBiangeng){		
			allAlertMsg+=emptyAlert(biangengqian,biangengqianAlert,empty,true);
			if(!onRadio(biangengzhangtai)){
				allAlertMsg+=biangengzhuangtaiAlert;
			}		
		}else {
			var ele=document.all(biangengqian);	
			ele.value="";			
			radioNoneCheck(biangengzhangtai);
		}
	}
	return allAlertMsg;
}

function fenzhijigou(fenzhi,fenzhiEmptyAlert,fenzhiAlert,xinFenzhi,xinFenzhiEmptyAlert,xinFenzhiAlert,xinBanli,xinBanliAlert,zhudiaoFenzhi,zhuxiaoFenzhiEmptyAlert,zhuxiaoFenzhiAlert,zhuxaoBanli,zhuxaoBanliAlert){
	//��֧����
	var fenzhiNum=0;
	var xinfenzhiNum=0;
	var zhuxiaofenzhiNum=0;
	var allAlertMsg="";


	ele=document.all(fenzhi);
	if(isEmpty(ele)){
		allAlertMsg+=fenzhiEmptyAlert;
	}else if(!isDigit(ele.value)){
		allAlertMsg+=fenzhiAlert;
		ele.select();
	}
	fenzhi=parseInt(ele.value);
	
	ele=document.all(xinFenzhi);
	if(isEmpty(ele)){
		allAlertMsg+=xinFenzhiEmptyAlert;
	}else if(!isDigit(ele.value)){
		allAlertMsg+=xinFenzhiAlert;
		ele.select();
	}else{
		xinfenzhi=parseInt(ele.value);
		if(!onRadio(xinBanli)&&xinfenzhi!=0){
			allAlertMsg+=xinBanliAlert;
		}else if(xinfenzhi==0){
			radioNoneCheck(xinBanli);
		}
	}
	ele=document.all(zhudiaoFenzhi);
	if(isEmpty(ele)){
		allAlertMsg+=zhuxiaoFenzhiEmptyAlert;
	}else if(!isDigit(ele.value)){
		allAlertMsg+=zhuxiaoFenzhiAlert;
		ele.select();
	}else{
		zhuxiaofenzhi=parseInt(ele.value);
		if(!onRadio(zhuxaoBanli)&&zhuxiaofenzhi!=0){
			allAlertMsg+=zhuxaoBanliAlert;
		}else if(zhuxiaofenzhi==0){
			radioNoneCheck(zhuxaoBanli);
		}
	}
	return allAlertMsg;
}

//����������
function isNumber(str){
	var realLength = 999999999999;

	//���Ϊ�գ���ͨ��У��
	if(str == "")
		return false;

	//У���Ƿ��ǺϷ����֣�ֻ���������ֺ�С����.
	if(!(/^[\d|.|-]*$/g.test(str))){		
		return false;
	}

	var valueOfNum = parseFloat(str);
	

	//У��Ǯ�ҵĸ�ʽ
	if(/\.{1}/.test(str)) {
		if(/^(-?)(\d+)\.(\d{1,2})$/.test(str)) {
	
			if(valueOfNum <= realLength)
				return true;
			else{
				
				return false;
			}
		}
		else{
			
			return false;
		}
	}
	else{
		var valueOfIntNum = parseInt(str);
		if(valueOfIntNum <= realLength)
			return true;
		else{			
			return false;
		}
	}
}
  
  

//�������������������
function checkNumber(inputElement){
		var str = inputElement.value;
		var inputCode = event.keyCode;
		//alert("code="+str);
		if(inputCode == 46){
			if(str.indexOf(".")>=0){
				event.returnValue=false;
			}
			return;
		}
		
		if(inputCode == 45){
			if(trim(str).length > 0 ){			    
				event.returnValue=false;
			}
			return;
		}
	
		
		if(!(inputCode>47 && inputCode<58)){
			event.returnValue=false;
		}else{
            if(str.indexOf(".")>=0){
            
               if(str.length-2>str.indexOf("."))
                    event.returnValue=false;
                
            }		
		}
		
	}


	
// ��ѡֵ��ƴ��
function  setValue(ele, eleSec){
    
    boxName = document.all(ele);
    hiddenBox =  document.all(eleSec);    
    
    var checkValue="";
    for(i = 0; i< boxName.length; i++){
        if(boxName[i].checked){
            checkValue+=boxName[i].value+",";
        }
    }
    
    if(checkValue != null && checkValue.length > 0){
        checkValue = "," + checkValue;
    }
    
    hiddenBox.value = checkValue;
    //alert(hiddenBox.value);

}

//��ѡ����ѡ��һ��
function atLeastChooseOne(name,msg){
    var obj_status = null;
    var obj_st = document.all(name);
    var blnChecked = false;
    for (i = 0; i < obj_st.length; i++){
        obj_status = obj_st[i];
        if (obj_status.checked){
            blnChecked = true;
            break;
        }      
    }
    if (!blnChecked){
        alert("������ѡ��һ��" + msg +"!");
        obj_st[0].focus();
        return false;
    }else{
        return true;
    }
}



//��ʽ������λ��	
function formatNumber(ctValue, formatNum){				
	var OrderIndex=ctValue.indexOf(".");
	var sv = "";
	
	if(OrderIndex >0 ){			
		var s = ctValue.split(".");
		sv = s[0] + ".";					
		if(s[1].length >= formatNum)							
		    sv += s[1].substring(0,formatNum);
		else{
				
		    sv += s[1].substring(0,s[1].length);
		    for(var i = s[1].length ; i < formatNum ; i++){
		        sv += "0"; 
		    }			    
		}
		
	}else{
	    sv = ctValue + ".";
	    for(var i = 0 ; i < formatNum ; i++){
	        sv += "0"; 
	    }
	}
	
	return sv;
}

//��֤�Ƿ������֤
function isIDCard(cardNO){

    card=document.all(cardNO);
    if(card.value == ""){
        alert("���������֤�ţ�");
        card.focus();
        return false;
    }
	var len = card.value.length, re; 
	if (len == 15){
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	}else if (len == 18){
	    re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})[\S]$/);
	}else {
	    alert("��������ȷ���֤��λ����");
        card.focus();
		return false;
	}
	var a = card.value.match(re);
	if (a != null){
		if (len==15){
			var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
			var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
		}else{
			var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);
			var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
		}
		if (!B) {
            alert("��������ȷ���֤�ţ�");
            card.focus();
			return false;
		}
	   return D;
	}
    alert("��������ȷ���֤�ţ�");
    card.focus();
	return false;
}

//��֤�Ƿ������֤������������
function isIDCardCompareBirthday(cardNO,birthday){
    birth=document.all(birthday);
    card=document.all(cardNO);
    if(card.value == ""){
        alert("���������֤�ţ�");
        card.focus();
        return false;
    }
	var len = card.value.length, re; 
	if (len == 15){
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	}else if (len == 18){
	    re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})[\S]$/);
	}else {
	    alert("��������ȷ���֤��λ����");
        card.focus();
		return false;
	}
	var a = card.value.match(re);
	if (a != null){
		if (len==15){
			var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
			var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
		}else{
			var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);
			var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
		}
		if (!B) {
            alert("��������ȷ���֤�ţ�");
            card.focus();
			return false;
		}else{
		    var D = isDate(birth.value);
			var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
			if(!B){
                alert("�������������֤�Ų�����");
                card.focus();
    			return false;
			}
            return D;
		}
	}
    alert("��������ȷ���֤�ţ�");
    card.focus();
	return false;
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
//�Ƚ�ͬһҳ���������ֵ��Ȳ����ύ
function isEquil(firstValue,secondlyValue){
    first=document.all(firstValue);
    second=document.all(secondlyValue);
    if(first.value != second.value){
    	second.focus();
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