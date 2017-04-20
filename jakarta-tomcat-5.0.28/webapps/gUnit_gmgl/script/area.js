/**
 * ѡ������
 * ������path��·��
 *		formName��FORM����
 *		role����ǰ�û�����������
 *		level�����򼶱�
 *		objId������ID����
 *		objName����������
 *		parentIdName���ϼ�����ID������
 *		strClears����Ҫ���ֵ�Ķ������ֵ��ַ���
 */
function selectArea(path, formName, role, level, objId, objName, parentIdName, strClears) {
	var parentId = "";

	//�ж�Ȩ��
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//�鿴�ϼ������Ƿ�Ϊ��
	if(parentIdName != null && parentIdName != "") {
		parentId = document[formName][parentIdName].value;
		//����ϼ�����IDΪ�գ�����ʾ
		if(parentId == null || parentId == "" || parentId == "0") {
			if(level == 1) alert("����ѡ������ʡ����");
			if(level == 2) alert("����ѡ�������С���");
			if(level == 3) alert("����ѡ�����ڣ��أ�������");
			if(level == 4) alert("����ѡ�����ڽֵ������򣩡���");
			if(level > 1) return;
		}	
	}
	
	//�򿪵�ַ�����ò���
	var strUrl = path + "tree.jsp?level=" + level + "&formName=" + formName + "&deptId=" + parentId;
	
	strUrl = strUrl + "&objId=" + objId + "&objName=" + objName + "&strClears=" + strClears;

	//��������
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
}
/**
 * ��ѡѡ������
 * ������path��·��
 *		formName��FORM����
 *		role����ǰ�û�����������
 *		level�����򼶱�
 *		objId������ID����
 *		objName����������
 *		parentIdName���ϼ�����ID������
 *		strClears����Ҫ���ֵ�Ķ������ֵ��ַ���
 */
function selectAreaMany(path, formName, role, level, objId, objName, parentIdName, strClears) {
	var parentId = "";

	//�ж�Ȩ��
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//�鿴�ϼ������Ƿ�Ϊ��
	if(parentIdName != null && parentIdName != "") {
		parentId = document[formName][parentIdName].value;
		//����ϼ�����IDΪ�գ�����ʾ
		if(parentId == null || parentId == "" || parentId == "0") {
			if(level == 1) alert("����ѡ������ʡ����");
			if(level == 2) alert("����ѡ�������С���");
			if(level == 3) alert("����ѡ�����ڣ��أ�������");
			if(level == 4) alert("����ѡ�����ڽֵ������򣩡���");
			if(level > 1) return;
		}	
	}
	
	//�򿪵�ַ�����ò���
	var strUrl = path + "tree_many.jsp?level=" + level + "&formName=" + formName + "&deptId=" + parentId;
	
	strUrl = strUrl + "&objId=" + objId + "&objName=" + objName + "&strClears=" + strClears;

	//��������
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
}


/**
 * ��ѡ�������
 * ������path��·��
 *		formName��FORM����
 *		role����ǰ�û�����������
 *		level�����򼶱�
 */
function clearAreaMany(role, level, formName, arrayObj) {

	//�ж�Ȩ��
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//���û�У�����
	if(arrayObj == null || arrayObj == "") return;

	//�������ֵ
	if(level == 2) {
		doDelSelectCounty();
	}else if(level == 3) {
		doDelSelectStreet();
	}else if(level == 4) {
		doDelSelectCommunity();
	}
}
/**
 * �������
 * ������path��·��
 *		formName��FORM����
 *		role����ǰ�û�����������
 *		level�����򼶱�
 */
function clearArea(role, level, formName, arrayObj) {
	
	//�ж�Ȩ��
	if(role != null && level != null) {
		if(role >= level) return;
	}
	
	//���û�У�����
	if(arrayObj == null || arrayObj == "") return;

	//�������ֵ
	var objects = arrayObj.split(",");
	for(var i = 0; i < objects.length; i++) {
		document[formName][objects[i]].value = "";
	}
}

/**
 * ѡ������ɢ�ӣ�
 * ������path��·��
 *		formName��FORM����
 *		role����ǰ�û�����������
 *		level�����򼶱�
 *		objId������ID����
 *		objName����������
 *		parentIdName���ϼ�����ID������
 *		strClears����Ҫ���ֵ�Ķ������ֵ��ַ���
 */
function selectAreaSj(path, formName, objId, objName, parentIdName, strClears) {
	
	var parentId = "";
	
	//�鿴�ϼ������Ƿ�Ϊ��
	if(parentIdName != null && parentIdName != "") {
		parentId = document[formName][parentIdName].value;
		//����ϼ�����IDΪ�գ�����ʾ
		if(parentId == null || parentId == "" || parentId == "0") {
			alert("����ѡ�����ڣ��أ�������");
			return;
		}	
	}
	
	//�򿪵�ַ�����ò���
	var strUrl = path + "tree_sj.jsp?formName=" + formName + "&parentId=" + parentId;
	strUrl = strUrl + "&objId=" + objId + "&objName=" + objName + "&strClears=" + strClears;

	//��������
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
}