// �������;
function getLines(param_height) {
	
	var pageObj = document;
	var textObj = pageObj.getElementById("textarea");
	//var lineHight = parseInt(textObj.style.lineHeight.replace(/px/i,''));  
	// ��ò���CSS ����о࣬ �����д�̶��ˡ�
	//var lineHight = 43;
	var rangeObj  = textObj.createTextRange();
	return Math.ceil(rangeObj.boundingHeight/param_height);
	
}	
			
// 
function checkLimits(state, countChars, countLines, param_height) {
	
	var pageObj = document;
	var textObj = pageObj.getElementById("textarea");
	
	// �����ַ���
  // var countChars = 492;
	// ��������
  // var countLines = 12;

	if ((textObj.value.length > countChars || getLines(param_height) > countLines) 
			&& (window.event.keyCode == 10 || window.event.keyCode == 13)) {
		
		// �����ǰ������������������� ����ɾ���ַ���
		while (getLines(param_height) > countLines) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			textObj.value = textObj.value.substr(0, textObj.value.length - 1); 
		}
	
		// �����ǰ����ַ���������������ַ���  ����ɾ���ַ���
		while (textObj.value.length > countChars) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			if (textObj.value.length > countChars && textObj.value.length != countChars)
			textObj.value = textObj.value.substr(0, textObj.value.length - 1); 
		}
		if (state == "false") { 
      	alert("���ĵ������������ ���� ��������ַ�����");
        checkLimits("true", countChars, countLines);
    }
		
	} else if (textObj.value.length > countChars) {
		
		while (textObj.value.length > countChars) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			if (textObj.value.length > countChars && textObj.value.length != countChars)
			textObj.value = textObj.value.substr(0, textObj.value.length-1);
		}
		if (state == "false") { 
      	alert("���ĵ������������ ���� ��������ַ�����");
        checkLimits("true", countChars, countLines);
    } 
	
	} else if (getLines(param_height) > countLines) {

		while(getLines(param_height) > countLines) {
			textObj.value = textObj.value.replace(/\s+$/g, "");
			textObj.value = textObj.value.substr(0, textObj.value.length-1);
		}
		if (state == "false") { 
      	alert("���ĵ������������ ���� ��������ַ�����");
        checkLimits("true", countChars, countLines);
    }
    
	}
}