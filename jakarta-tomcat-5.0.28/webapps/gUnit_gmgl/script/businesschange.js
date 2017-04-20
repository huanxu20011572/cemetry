/**
 * 业务类型变化时，提交页面，重新查询
 */
function changeBusinessType(obj){
	
	document.form1.action="approveAction.do?method=list&businessType=" + obj.value;
	document.form1.submit();
}

/**
 * 页面LOAD的时候，保持选择的值
 */
function loadBusinessType() {
	var form = document.form1;
	var businessType = form.businessType.value;
	if(businessType == "452" || businessType == "442" || businessType == "1" || businessType == "2") {
		form.businessType1.value = businessType;
		if(businessType == "1") {
			document.getElementById("aa").style.display = "";
  		document.getElementById("bb").style.display = "";
		}else if(businessType == "2"){
			document.getElementById("aa").style.display = "";
  		document.getElementById("cc").style.display = "";			
		}
	} else if(businessType == "444" || businessType == "445" || businessType == "446" || businessType == "2525" || businessType == "2526") {
		form.businessType1.value = "1";
		form.businessType2.value = businessType;
		document.getElementById("aa").style.display = "";
  	document.getElementById("bb").style.display = "";	
	}else if (businessType == "450" || businessType == "2580"){
		form.businessType1.value = "2";
		form.businessType3.value = businessType;
		document.getElementById("aa").style.display = "";
  	document.getElementById("cc").style.display = "";	
	}
}