function addTable(fileName,size,id,tableId,fillType){
  var t = document.getElementById(tableId);
  var row = t.insertRow();
  row.id = tableId+size;
  row.className = "td-01";
  row.align = "center";
  var ce_1 = row.insertCell();
      ce_1.innerHTML = fillType;
  var ce_1 = row.insertCell();
      ce_1.innerHTML = fileName;
  var ce_2 = row.insertCell();
      ce_2.innerHTML = size;
  var ce_3 = row.insertCell();
      ce_3.innerHTML = "<a href='javascript: if(confirm(\"ȷ��ɾ����\")) location.href=\"uploadFileDelete.do?method=uploadFileDelete&id="+id+"&rowId="+row.id+"&tableId="+tableId+"\";' target='hidden_frame'>ɾ��</a>";
}

function operateFail(msg){
  alert(msg);
}

function delSuc(rowId,tableId){
  var t = document.getElementById(tableId);
  var row = document.getElementById(rowId);
  t.deleteRow(row.rowIndex);
}

function fileClear(obj){ 
  obj.outerHTML=obj.outerHTML;
  alert('�����ֹ����룬��ѡ��');
  return;
}

function uploadFormCheck(formId){
  var fm = document.getElementById(formId);
  if(fm.file.value == null || fm.file.value == "" ){
    alert("��ѡ���ϴ�������");
    return false;
  }
  if(fm.type2.value == null || fm.type2.value == "" ){
    alert("��ѡ���ϴ��������ͣ�");
    return false;
  }
  fm.submit();
}