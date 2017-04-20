/**
 * 选择区域
 * 参数：path：路径
 *		formName：FORM名字
 *		role：当前用户所属区级别
 *		level：区域级别
 *		objId：对象ID名字
 *		objName：对象名字
 *		parentIdName：上级区域ID的名字
 *		strClears：需要清除值的对象名字的字符串
 */
function selectArea(path, formName, role, level, objId, objName, parentIdName, strClears) {
	var parentId = "";

	//判断权限
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//查看上级区域是否为空
	if(parentIdName != null && parentIdName != "") {
		parentId = document[formName][parentIdName].value;
		//如果上级区域ID为空，则提示
		if(parentId == null || parentId == "" || parentId == "0") {
			if(level == 1) alert("请先选择“所在省”！");
			if(level == 2) alert("请先选择“所在市”！");
			if(level == 3) alert("请先选择“所在（县）区”！");
			if(level == 4) alert("请先选择“所在街道（乡镇）”！");
			if(level > 1) return;
		}	
	}
	
	//打开地址，设置参数
	var strUrl = path + "tree.jsp?level=" + level + "&formName=" + formName + "&deptId=" + parentId;
	
	strUrl = strUrl + "&objId=" + objId + "&objName=" + objName + "&strClears=" + strClears;

	//弹出窗口
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
}
/**
 * 多选选择区域
 * 参数：path：路径
 *		formName：FORM名字
 *		role：当前用户所属区级别
 *		level：区域级别
 *		objId：对象ID名字
 *		objName：对象名字
 *		parentIdName：上级区域ID的名字
 *		strClears：需要清除值的对象名字的字符串
 */
function selectAreaMany(path, formName, role, level, objId, objName, parentIdName, strClears) {
	var parentId = "";

	//判断权限
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//查看上级区域是否为空
	if(parentIdName != null && parentIdName != "") {
		parentId = document[formName][parentIdName].value;
		//如果上级区域ID为空，则提示
		if(parentId == null || parentId == "" || parentId == "0") {
			if(level == 1) alert("请先选择“所在省”！");
			if(level == 2) alert("请先选择“所在市”！");
			if(level == 3) alert("请先选择“所在（县）区”！");
			if(level == 4) alert("请先选择“所在街道（乡镇）”！");
			if(level > 1) return;
		}	
	}
	
	//打开地址，设置参数
	var strUrl = path + "tree_many.jsp?level=" + level + "&formName=" + formName + "&deptId=" + parentId;
	
	strUrl = strUrl + "&objId=" + objId + "&objName=" + objName + "&strClears=" + strClears;

	//弹出窗口
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
}


/**
 * 多选清除区域
 * 参数：path：路径
 *		formName：FORM名字
 *		role：当前用户所属区级别
 *		level：区域级别
 */
function clearAreaMany(role, level, formName, arrayObj) {

	//判断权限
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//如果没有，返回
	if(arrayObj == null || arrayObj == "") return;

	//清除对象值
	if(level == 2) {
		doDelSelectCounty();
	}else if(level == 3) {
		doDelSelectStreet();
	}else if(level == 4) {
		doDelSelectCommunity();
	}
}
/**
 * 清除区域
 * 参数：path：路径
 *		formName：FORM名字
 *		role：当前用户所属区级别
 *		level：区域级别
 */
function clearArea(role, level, formName, arrayObj) {
	
	//判断权限
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//如果没有，返回
	if(arrayObj == null || arrayObj == "") return;

	//清除对象值
	var objects = arrayObj.split(",");
	for(var i = 0; i < objects.length; i++) {
		document[formName][objects[i]].value = "";
	}
}

/**
 * 选择区域（散居）
 * 参数：path：路径
 *		formName：FORM名字
 *		role：当前用户所属区级别
 *		level：区域级别
 *		objId：对象ID名字
 *		objName：对象名字
 *		parentIdName：上级区域ID的名字
 *		strClears：需要清除值的对象名字的字符串
 */
function selectAreaSj(path, formName, objId, objName, parentIdName, strClears) {
	
	var parentId = "";
	
	//查看上级区域是否为空
	if(parentIdName != null && parentIdName != "") {
		parentId = document[formName][parentIdName].value;
		//如果上级区域ID为空，则提示
		if(parentId == null || parentId == "" || parentId == "0") {
			alert("请先选择“所在（县）区”！");
			return;
		}	
	}
	
	//打开地址，设置参数
	var strUrl = path + "tree_sj.jsp?formName=" + formName + "&parentId=" + parentId;
	strUrl = strUrl + "&objId=" + objId + "&objName=" + objName + "&strClears=" + strClears;

	//弹出窗口
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
}