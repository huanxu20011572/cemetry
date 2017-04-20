// 获得行数;
function getLines(param_height) {
	
	var pageObj = document;
	var textObj = pageObj.getElementById("textarea");
	//var lineHight = parseInt(textObj.style.lineHeight.replace(/px/i,''));  
	// 获得不到CSS 里的行距， 这里就写固定了。
	//var lineHight = 43;
	var rangeObj  = textObj.createTextRange();
	return Math.ceil(rangeObj.boundingHeight/param_height);
	
}	
			
// 
function checkLimits(state, countChars, countLines, param_height) {
	
	var pageObj = document;
	var textObj = pageObj.getElementById("textarea");
	
	// 上限字符数
  // var countChars = 492;
	// 上限行数
  // var countLines = 12;

	if ((textObj.value.length > countChars || getLines(param_height) > countLines) 
			&& (window.event.keyCode == 10 || window.event.keyCode == 13)) {
		
		// 如果当前行数大于最大上限行数 迭代删除字符。
		while (getLines(param_height) > countLines) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			textObj.value = textObj.value.substr(0, textObj.value.length - 1); 
		}
	
		// 如果最前最大字符数大于最大上限字符数  迭代删除字符。
		while (textObj.value.length > countChars) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			if (textObj.value.length > countChars && textObj.value.length != countChars)
			textObj.value = textObj.value.substr(0, textObj.value.length - 1); 
		}
		if (state == "false") { 
      	alert("该文档超过最大行数 或着 超过最大字符数。");
        checkLimits("true", countChars, countLines);
    }
		
	} else if (textObj.value.length > countChars) {
		
		while (textObj.value.length > countChars) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			if (textObj.value.length > countChars && textObj.value.length != countChars)
			textObj.value = textObj.value.substr(0, textObj.value.length-1);
		}
		if (state == "false") { 
      	alert("该文档超过最大行数 或着 超过最大字符数。");
        checkLimits("true", countChars, countLines);
    } 
	
	} else if (getLines(param_height) > countLines) {

		while(getLines(param_height) > countLines) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			textObj.value = textObj.value.substr(0, textObj.value.length-1);
		}
		if (state == "false") { 
      	alert("该文档超过最大行数 或着 超过最大字符数。");
        checkLimits("true", countChars, countLines);
    }
    
	}
}