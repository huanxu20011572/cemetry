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
 * 用于校验金额，小数点后面允许为二位
 * oObject 为控件名称，一般为text控件
 * leng 为允许的最大数值
 * 校验通过返回true，否则出现警告信息并返回false
 */
function checkMoney(oObject,leng){
	var realLength = parseInt(leng);

	//如果为空，则通过校验
	if(oObject.value == "")
		return true;

	//校验是否是合法数字，只能输入数字和小数点.
	if(!(/^[\d|.|-]*$/g.test(oObject.value))){	
		oObject.select();
		return false;
	}

	var valueOfNum = parseFloat(oObject.value);	
	//校验钱币的格式
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
 * 用于校验金额，并生成提示信息
 * oObject 为控件名称，一般为text控件
 * alertIsEmpty 为空的提示信息
 * alertIsValid 不是钱币格式的提交信息
 * 校验通过返回提示信息的字符串
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
 * 是否为空
 * oObject 为控件名称，一般为text控件
 */
function isEmpty(oObject){
	return isEmptyByCondition(oObject," 　");
}

/**
 * 是否为空
 * oObject 为控件名称，一般为text控件
 * condition 为空的条件
 */
function isEmptyByCondition(oObject,condition){
	//是否有错误
	var isError=false;
	if (condition.search(oObject.value)!=-1) {
		isError=true;
	}
	return isError;
}


/**
 * 用于校验金额，并生成提示信息
 * oObject 为控件名称，一般为text控件
 * alertIsEmpty 为空的提示信息
 * alertIsValid 不是钱币格式的提交信息
 * 校验通过返回提示信息的字符串
 */
function parseMoney(oObject){
	var s=0;
	if(!isEmpty(oObject)&&checkMoney(oObject,999999999999)){		
		s=parseFloat(oObject.value);
	}
	return s;
}

//校验邮政编码
function isPostalCode(s)
{
    //var patrn=/^[a-zA-Z0-9]{3,12}$/;
    var patrn=/^[0-9 ]{6}$/;
    if (patrn.exec(s)) return true;
    return false;
}

//校验是否全由数字组成
function isDigit(s)
{
    var patrn=/^[0-9]{1,20}$/;
    if (!patrn.exec(s)) {
        return false;
    }
    return true;
}



//校验是否全由小数
function isFloat2(oObject){

	//如果为空，则通过校验
	if(oObject.value == "")
		return true;
	if(isDigit(oObject.value)){
		return true;
	}

	//校验是否是合法数字，只能输入数字和小数点.
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


//------多选项数为一个
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




/**判断是否已经选择对象
		适用对象：	checkbox/radio
		*objForm:	  'Form对象'
		*obj:  			'选择对象名称'
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
	//分支机构
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

//检验事数字
function isNumber(str){
	var realLength = 999999999999;

	//如果为空，则通过校验
	if(str == "")
		return false;

	//校验是否是合法数字，只能输入数字和小数点.
	if(!(/^[\d|.|-]*$/g.test(str))){		
		return false;
	}

	var valueOfNum = parseFloat(str);
	

	//校验钱币的格式
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
  
  

//检查输入框的输入是数字
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


	
// 多选值的拼凑
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

//多选至少选择一项
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
        alert("请至少选择一项" + msg +"!");
        obj_st[0].focus();
        return false;
    }else{
        return true;
    }
}



//格式化数字位数	
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

//验证是否是身份证
function isIDCard(cardNO){

    card=document.all(cardNO);
    if(card.value == ""){
        alert("请输入身份证号！");
        card.focus();
        return false;
    }
	var len = card.value.length, re; 
	if (len == 15){
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	}else if (len == 18){
	    re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})[\S]$/);
	}else {
	    alert("请输入正确身份证号位数！");
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
            alert("请输入正确身份证号！");
            card.focus();
			return false;
		}
	   return D;
	}
    alert("请输入正确身份证号！");
    card.focus();
	return false;
}

//验证是否是身份证与出生日期相符
function isIDCardCompareBirthday(cardNO,birthday){
    birth=document.all(birthday);
    card=document.all(cardNO);
    if(card.value == ""){
        alert("请输入身份证号！");
        card.focus();
        return false;
    }
	var len = card.value.length, re; 
	if (len == 15){
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	}else if (len == 18){
	    re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})[\S]$/);
	}else {
	    alert("请输入正确身份证号位数！");
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
            alert("请输入正确身份证号！");
            card.focus();
			return false;
		}else{
		    var D = isDate(birth.value);
			var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
			if(!B){
                alert("出生日期与身份证号不符！");
                card.focus();
    			return false;
			}
            return D;
		}
	}
    alert("请输入正确身份证号！");
    card.focus();
	return false;
}

/*  函数功能：判断传入参数是否为yyyy-mm-dd或
			  yyyy/mm/dd格式的正确日期
			  2001/01/2和2001-3-04也是允许的格式
			  如果是，则返回一个对应的日期对象
			  如果否，则返回false
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


//比较前一时间是否在后一时间前面
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
//比较同一页面里的俩个值相等才能提交
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