// 获得行数;
function getLines(param_height, textObj) {
	
	var pageObj = document;
	var rangeObj  = textObj.createTextRange();
	return Math.ceil(rangeObj.boundingHeight/param_height);
	
}	
			
// 
function checkLimits(obj, state, countChars, countLines, param_height) {
	
		var pageObj = document;
		var textObj = obj;
	
  //      alert("111111111111  " + textObj.value.length + " ------------- " + getLines(param_height, textObj));
		if ((textObj.value.length > countChars || getLines(param_height, textObj) > countLines) 
				&& (window.event.keyCode == 10 || window.event.keyCode == 13)) {
			
			while (getLines(param_height, textObj) > countLines) {
				textObj.value = textObj.value.replace(/\s+$/g, "");
				textObj.value = textObj.value.substr(0, textObj.value.length - 1); 
			}
		
			while (textObj.value.length > countChars) {
				textObj.value = textObj.value.replace(/\s+$/g, "");
				if (textObj.value.length > countChars && textObj.value.length != countChars)
				textObj.value = textObj.value.substr(0, textObj.value.length - 1); 
			}
			if (state == "false") { 
		      	alert("该文档超过最大行数 或着 超过最大字符数。");
		        checkLimits(textObj, "true", countChars, countLines, param_height);
	    	}
			
		} else if (textObj.value.length > countChars) {
			
			while (textObj.value.length > countChars) {
				textObj.value = textObj.value.replace(/\s+$/g, "");
				if (textObj.value.length > countChars && textObj.value.length != countChars)
				textObj.value = textObj.value.substr(0, textObj.value.length-1);
			}
			if (state == "false") { 
		      	alert("该文档超过最大行数 或着 超过最大字符数。");
		        checkLimits(textObj, "true", countChars, countLines, param_height);
	    	} 
		
		} else if (getLines(param_height, textObj) > countLines) {
	
			while(getLines(param_height, textObj) > countLines) {
				textObj.value = textObj.value.replace(/\s+$/g, "");
				textObj.value = textObj.value.substr(0, textObj.value.length-1);
			}
			if (state == "false") { 
		      	alert("该文档超过最大行数 或着 超过最大字符数。");
		        checkLimits(textObj, "true", countChars, countLines, param_height);
	    	}
    
		}
}