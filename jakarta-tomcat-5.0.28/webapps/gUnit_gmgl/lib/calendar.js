var _visSelElement = new Array();
function _hidAllSelElement(){
	var _showSelElement = document.all.tags("SELECT");
	if(_showSelElement.length>0){
		for(var i=0;i<_showSelElement.length;i++){
			if(_showSelElement(i).style.visibility=="" || _showSelElement(i).style.visibility=="visible"){
				var str = "";
				for(var j=0;j<_arrCalName.length;j++){
					str += " _showSelElement(i).id!='_selectMonth" + _arrCalName[j] + "' && _showSelElement(i).id!='_selectYear"  + _arrCalName[j] + "' &&";
				}
				if(str.length>1){
					str = str.substring(0,str.length-2);
				}else{
					str = "true";
				}
				if(eval(str)){
					_showSelElement(i).style.visibility="hidden"
					_visSelElement[_visSelElement.length] = i;
				}
			}
		}
	}
}
function _showAllSelElement(){
	var _hidSelElement = document.all.tags("SELECT");
	if(_visSelElement.length>0){
		for(var i=0;i<_visSelElement.length;i++){
			_hidSelElement(_visSelElement[i]).style.visibility="visible";
		}
	}
	_visSelElement.length=0;
}
document.onmousedown=_myclick;
document.onkeydown=_myclick;
//得到指定月份的天数
var _arrCalName=new Array();
var _compCount=0;
function getMaxDay(FormatDate){
	var maxDay;
	var intMonth = FormatDate.getMonth()+1;
	var intYear = FormatDate.getYear();
	switch(intMonth){
		case 1: maxDay = 31;break;
		case 3: maxDay = 31;break;
		case 5: maxDay = 31;break;
		case 7: maxDay = 31;break;
		case 8: maxDay = 31;break;
		case 10: maxDay = 31;break;
		case 12: maxDay = 31;break;
		case 4: maxDay = 30;break;
		case 6: maxDay = 30;break;
		case 9: maxDay = 30;break;
		case 11: maxDay = 30;break;
		case 2:maxDay = 28; 
			if(intYear % 4 == 0){
				maxDay = 29;
				if(intYear%100 ==0){
					if(intYear % 400!=0){maxDay = 28;}
				}
			}
			break;
	}
	return maxDay;
}
//得到星期的整数表达
function getWeek(FormatDate){
	var intWeek;
	var intMonth = FormatDate.getMonth()+1;
	var intYear = FormatDate.getYear();
	var strDate = new Date(intMonth + "-1-" + intYear);
	var strDate = strDate.toString();
	var strWeek = strDate.substring(0,3);
	if(strWeek == "Sun"){intWeek = 0;}
	if(strWeek == "Mon"){intWeek = 1;}
	if(strWeek == "Tue"){intWeek = 2;}
	if(strWeek == "Wed"){intWeek = 3;}
	if(strWeek == "Thu"){intWeek = 4;}
	if(strWeek == "Fri"){intWeek = 5;}
	if(strWeek == "Sat"){intWeek = 6;}
	return intWeek;
}
function getFormatDate(strDate){
	var arrDate = strDate.split("-");
	return arrDate[1]*1 + "-" + arrDate[2]*1 + "-" + arrDate[0]*1;
}
function showCal(name){
	event.cancelBubble = true;
	if(document.all("_DivOptionList" + name).style.visibility == "visible"){
		_myclick();
		document.all("_DivOptionList" + name).style.visibility = "hidden";
		_showAllSelElement();
	}else{
		_myclick();
		document.all("_spanMain" + name).style.zIndex = 10000;
		document.all("_DivOptionList" + name).style.visibility = "visible";
		_hidAllSelElement();		
	}
}
function chngDate(name){
	setDate(document.all("_selectMonth" + name).value + "-1-" + document.all("_selectYear" + name).value,name);
}
function setDate(strFormatDate,name){
	var FormatDate = new Date(strFormatDate);
	var nowDate = new Date();
	var intWeek = getWeek(FormatDate);
	var intYear = FormatDate.getYear();
	if(intYear<2000){intYear = ("19" + intYear)*1;}
	var intMonth = FormatDate.getMonth()+1;
	document.all("_selectMonth" + name).selectedIndex = intMonth-1;
	for(var i = 0;i<document.all("_selectYear" + name).length;i++){
		if(document.all("_selectYear" + name).item(i).text*1 == intYear){
			document.all("_selectYear" + name).selectedIndex = i;
			i=document.all("_selectYear" + name).length;
			break;
		}
	}
	//设置日期
	var thisMaxDay = getMaxDay(FormatDate)
	var html = '';	
	for(var i=1;i<=thisMaxDay;i++){	    
	    html = '<button style="width:30px;height:16px;border:0;';
	    if (nowDate.getYear() == intYear && nowDate.getMonth() == (intMonth - 1) && nowDate.getDate() == i){	        
	        html += 'background-color:white;color:red;font-weight:bolder;';
	    }
	    else{
	        html += 'background-color:white;';
	    }
	    html += 'style="cursor:hand" onclick = putDate(this,"' + name + '")>' + i + '</button>';
		document.all("_TdDate" + name)(i+intWeek-1).innerHTML = html;
	}
	//得到上个月的月份
	var preMonth;
	var preYear;
	if(intMonth == 1){
		preMonth = 12;
		preYear = intYear - 1;
	}else{
		preMonth = intMonth - 1;
		preYear = intYear;
	}
	//得到上个月的最大天数
	var preMonthMaxDay = getMaxDay(new Date(preMonth + "-1-" + preYear));
	//显示上个月多余的天数	
	for(var i = intWeek;i>0;i--){
	    html = '<button style="width:30px;height:16px;border:0;background-color:white" onclick="toPreMonth(\''+name+'\')" style="color:';
	    if (nowDate.getYear() == intYear && nowDate.getMonth() == (intMonth - 2) && nowDate.getDate() == preMonthMaxDay){
	        html += 'red;font-weight:bolder';
	    }
	    else{
	        html += 'gray';
	    }
	    html += ';cursor:hand">' + preMonthMaxDay + '</button>';
		document.all("_TdDate" + name)(i-1).innerHTML = html;
		preMonthMaxDay --;
	}
	var j = 1;
	for(var i = thisMaxDay+intWeek;i<42;i++){
	    html = '<button style="width:30px;height:16px;border:0;background-color:white" onclick="toNextMonth(\''+name+'\')" style="color:';
	    if (nowDate.getYear() == intYear && nowDate.getMonth() == (intMonth - 2) && nowDate.getDate() == preMonthMaxDay){	        
	        html += 'red;font-weight:bolder';
	    }
	    else{
	        html += 'gray';
	    }
	    html += ';cursor:hand">' + j + '</button>';
		document.all("_TdDate" + name)(i).innerHTML = html;
		j ++;
	}
}
function toPreMonth(name){
	if(document.all("_selectMonth" + name).selectedIndex!=0){
		document.all("_selectMonth" + name).selectedIndex --;
		chngDate(name)
	}else{
		if(document.all("_selectYear" + name).selectedIndex>0){
			document.all("_selectMonth" + name).selectedIndex = 11;
			document.all("_selectYear" + name).selectedIndex --;
			chngDate(name)
		}
	}
}
function toNextMonth(name){
	if(document.all("_selectMonth" + name).selectedIndex!=11){
		document.all("_selectMonth" + name).selectedIndex ++;
		chngDate(name)
	}else{
		if(document.all("_selectYear" + name).selectedIndex<document.all("_selectYear" + name).length-1){
			document.all("_selectMonth" + name).selectedIndex = 0;
			document.all("_selectYear" + name).selectedIndex++;
			chngDate(name)
		}
	}
}
function _myclick(){
		_showAllSelElement();
		try{
			for(var i=0;i<_arrCalName.length;i++){
				document.all("_DivOptionList" + _arrCalName[i]).style.visibility="hidden";
				document.all("_spanMain" + _arrCalName[i]).style.zIndex = 1000;
			}
		}catch(e){}
		try{
			for(var i=0;i<_arrSelName.length;i++){
				document.all("_spanMain" + _arrSelName[i]).style.zIndex = 1000;
				document.all("_DivOptionList" + _arrSelName[i]).style.visibility="hidden";
			}
		}catch(e){}
}
function _cleanclick(name){
    var oInp = document.all(name);
    oInp.value = '';
    _myclick();
}
function putDate(curTd,name){
	var strDate;
	strDate = document.all("_selectYear" + name).value + "-" + document.all("_selectMonth" + name).value + "-" + curTd.innerText;
	document.all("_Text" + name).value = strDate;
	_myclick();
}
function showCalList(){
	var str = "";
	str += "<table><tr>";
	str += "<td></td>";
	str += "<tr>";
	str += "<td width='15%'>日</td>";
	str += "<td width='14%'>一</td>";
	str += "<td width='14%'>二</td>";
	str += "<td width='14%'>三</td>";
	str += "<td width='14%'>四</td>";
	str += "<td width='14%'>五</td>";
	str += "<td width='15%'>六</td>";
	str += "</tr>";
}
function setMonthList(name){
	var monthItem;
	for(var i=1;i<=12;i++){
		monthItem = window.Option.create(i,i);
		document.all("_selectMonth" + name).add(monthItem);
	}
}
function setYearList(starYear, endYear,name){
	var yearItem;
	for(var i=starYear;i<=endYear;i++){
		yearItem = window.Option.create(i,i);
		document.all("_selectYear" + name).add(yearItem);
	}
}
function Calendar(name, refDate, starYear, endYear, width, height, border, defaultDay, clean, dayOffset){
    //
	_arrCalName[_compCount] = name;
	_compCount ++;
	//this.name = name;
	this.refDate = refDate;
	this.starYear = starYear;
	this.endYear = endYear;
	this.width = width;
	this.height = height;
	this.border = border;	
	this.clean = clean;
	var inputValue = "";
	if(name==null || name==""){return;}
	//if(this.refDate==null || this.refDate==""){return;}
	if(this.refDate == null || this.refDate == ""){
		var nowDate;
		if(defaultDay == null || defaultDay == ""){
	    	nowDate = new Date();
	    	this.dayOffset = dayOffset;
	    	if (dayOffset != null && dayOffset != ""){
	    	    nowDate.setTime(nowDate.getTime() + 86400000 * parseInt(dayOffset));
	    	}
	    	this.refDate = nowDate.getYear() + "-" + (nowDate.getMonth() + 1) + "-" + nowDate.getDate();
	    	if (defaultDay == null){
	    	    inputValue = this.refDate;
	    	}
    	    else{
    	        inputValue = this.refDate;
    	    }
	    }else{
	    	this.refDate = defaultDay;
	    	inputValue = this.refDate;
	    }
	}
	if(this.border==null || this.border==""){this.border="buttonhighlight 2px inset;"}
	if(this.starYear==null || this.starYear==""){
		this.starYear = this.refDate.substring(0,4)*1;
		if(this.starYear>=2000){
			this.starYear = 2000;
		}
	}
	if(this.endYear==null || this.endYear==""){
		this.endYear=this.starYear+20;
	}
	if(this.width==null || this.width==""){this.width=110;}
	if(this.height==null || this.height==""){this.height=18;}
	this.backgroundColor = "white";
	var str="";
	str += '<span id="_spanMain' + name + '" style="text-align:right;position:Relative;background-color:white;width:' + this.width + 'px;border:' + this.border + ';height:20px" onselectstart="return false">\n';
	str += '<input readonly id="_Text' + name + '" name="' + name + '" style="background-color:' + this.backgroundColor + ';width:' + (this.width-35) + 'px;height:' + this.height + ';border:0px" value="' + inputValue + '">\n';
	str += '<button accesskey="D" class="button1" style="width:30px;height:' + this.height + ';font-size:12px;background-color:buttonhighdark" onclick="showCal(\''+name+'\')"; onmousedown="event.cancelBubble=true" title="点击选择日期">日期</button>';
	str += '<div onkeydown="event.cancelBubble=true" id="_DivOptionList' + name + '" style="position:absolute;height:130px;width:230px;border:black 1px double;background-color:white;visibility:hidden;top:21px;left:-2px;cursor:default;font-size:10pt" onmousedown="event.cancelBubble = true">\n';
	str += '<table border="0" cellpadding="0" cellspacing="0" style="font-size:12px" width="100%" id="_tb' + name + '">\n<tr bgcolor="#deebff" height="26">';
	str += '<td colspan=7 style="border-bottom:black 1px double;font-size:14px" align="right"><select onkeydown="event.cancelBubble=true" onchange="chngDate(\''+name+'\')" id="_selectYear' + name + '"></select>&nbsp;年\n';
	str += '&nbsp;&nbsp;<select onkeydown="event.cancelBubble=true" onchange="chngDate(\''+name+'\')" id="_selectMonth' + name + '"></select>&nbsp;月\n';
	if (this.clean){
	    str += '<span style="cursor:hand" onclick="_cleanclick(\'' + name + '\')">清空</span>';
	}
    else{
        str += '&nbsp;&nbsp;';
    }
	str += '&nbsp;<span style="cursor:hand;font-family:webdings;font-size:13px" onclick="_myclick()">r</span></td>\n';
	str += '<tr height="24" align="center">\n';
	str += '<td>日</td>\n';
	str += '<td>一</td>\n';
	str += '<td>二</td>\n';
	str += '<td>三</td>\n';
	str += '<td>四</td>\n';
	str += '<td>五</td>\n';
	str += '<td>六</td>\n';
	str += '<tr><td colspan="7" align="center">\n';
	str += '<table style="font-size:12px" width="98%" height="90px" border="0" cellpadding="0" cellspacing="0" id="_tbDateSpace' + name + '">';
	for(var i=0;i<6;i++){
		str += '<tr>\n';
		for(var j=0;j<7;j++){
			str += '<td align="center" id="_TdDate' + name + '">&nbsp;</td>\n';
		}
		str += '</tr>\n';
	}
	str += '</table></td></tr>\n';
	str += '</table></div>\n';
	str += '</span>\n';
	document.write(str);
	setMonthList(name);
	setYearList(this.starYear,this.endYear,name);
	setDate(getFormatDate(this.refDate),name);
}
