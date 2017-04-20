var aindex = 1;
var annex=new Array();
	annex[0]="tid";
	annex[1]="rid";
	annex[2]="filedata";

function add_row(obj){
  if(aindex >= 6){
	alert("最多可上传6个附件！");
	return;
  }
  aindex++;
  var newRow;	
  for(var i=0;i<obj.length;i++){
    if(i==0){
		newRow = document.all(obj[0]).insertRow();
	    continue;
    }
    if(i==1){
		newRow.insertCell().innerHTML = '';
		continue;
    }
	if(i==2){
		newRow.insertCell().innerHTML = '<input name="'+ obj[2] + aindex + '" type="file" class="form_text2" size="45">';
		continue;
	}
  }
}

function del_row(tabId,objId){
  var c = document.getElementsByName(objId);
  var drow=new Array();
  for(var i=0; i<c.length; i++){
	if(c[i].checked){
	  document.all(tabId).deleteRow(i+1);
	  aindex--;
	  break;
	}
  }
}
