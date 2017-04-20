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
      ce_3.innerHTML = "<a href='javascript: if(confirm(\"确认删除？\")) location.href=\"uploadFileDelete.do?method=uploadFileDelete&id="+id+"&rowId="+row.id+"&tableId="+tableId+"\";' target='hidden_frame'>删除</a>";
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
  alert('不能手工输入，请选择！');
  return;
}

function uploadFormCheck(formId){
  var fm = document.getElementById(formId);
  if(fm.file.value == null || fm.file.value == "" ){
    alert("请选择上传附件！");
    return false;
  }
  if(fm.type2.value == null || fm.type2.value == "" ){
    alert("请选择上传附件类型！");
    return false;
  }
  fm.submit();
}