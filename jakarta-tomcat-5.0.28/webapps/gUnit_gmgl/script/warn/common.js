var condition=new Array();
	condition[0]="tid";
	condition[1]="rid";
	condition[2]="rulefiled";
	condition[3]="rulecompare";
	condition[4]="temptype";
	condition[5]="rulevalue";
	condition[6]="nexus";

function add_row(obj){
  var newRow;	
  for(var i=0;i<obj.length;i++){
    if(i==0){
		newRow = document.all(obj[0]).insertRow();
	    continue;
    }
    if(i==1){
		newRow.insertCell().innerHTML = '<center><input name="'+ obj[1] +'" type="radio"></center>';
		continue;
    }
	if(i==2){
		newRow.insertCell().innerHTML = document.all.rulefieldlist.innerHTML;
		continue;
	}
	if(i==3){
		newRow.insertCell().innerHTML = document.all.rulecomparelist.innerHTML;
		continue;
	}
	if(i==4){
		newRow.insertCell().innerHTML = '<center><input type="hidden" name="'+ obj[i] +'" value="text"></center>';
		continue;
	}
	if(i==5){
		newRow.insertCell().innerHTML = '<center><input name="'+ obj[i] +'" class="form_text1" type="text"></center>';
		continue;
	}
	if(i==6){
		newRow.insertCell().innerHTML = '<center><select name="'+ obj[i] +'"><option value=""></option><option value="or">ªÚ’ﬂ</option><option value="and">≤¢«“</option></select></center>';
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
	  break;
	}
  }
}
