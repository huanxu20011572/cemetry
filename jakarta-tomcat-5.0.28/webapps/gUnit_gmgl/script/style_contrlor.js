function showOrHidde(objId,img1,img2){
	var obj = eval(objId);
	if(obj){
		if(obj.style.display==''){
			obj.style.display='none';
		}else{
			obj.style.display='';
		}
		var imgObj = this.event.srcElement;
		var temp = imgObj.src.split("/");
		var imgSrc = temp[temp.length-1];
		if(img1!=''&&img2!=''){
			if(img1.indexOf(imgSrc)!=-1){
				imgObj.src=img2;
			}else{
				imgObj.src=img1;
			}
		}
	}
}


function showOrHiddeOnTitle(objId,imgId){
	alert(imgId);
	var obj = eval(objId);
	var img = eval(imgId);
	if(obj){
		if(obj.style.display==''){
			obj.style.display='none';
			img.src='/images/bt_jia.gif'
		}else{
			obj.style.display='';
			img.src='/images/bt_jian.gif'
		}
	}
}

function showOrHiddeObj(objId,objForm,showObjName){
	var obj = eval(objId);
	var showObj = objForm[showObjName];
	//572：参加保险人员在字典表中的id ;2572:轻度残疾在字典表中的id; 2573:重度残疾在急电表中的id
	if(showObj.value == 572 || showObj.value == 2572 || showObj.value == 2573){
		obj.style.display='';
	}else{
		obj.style.display='none';
	}

}

function showOrHiddeObjects(objId1,objId2,objForm,showObjName,showObjName1){
	var obj1 = eval(objId1);
	var obj2 = eval(objId2);
	var showObj = objForm[showObjName];
	var showObj1 = objForm[showObjName1];
	
	//符合如下身份类别的可以填写就业信息
	if(showObj.value == 377 || showObj.value == 344 || showObj.value == 366 || 
	   showObj.value == 367 || showObj.value == 369 || showObj.value == 370 || 
	   showObj.value == 372 || showObj.value == 380 || showObj.value == 382 || 
	   showObj.value == 385 || showObj.value == 386 || showObj.value == 351 || 
	   showObj.value == 374 || showObj.value == 345 || showObj.value == 353 || 
	   showObj.value == 358 || showObj.value == 395 || showObj.value == 356 ||
	   showObj.value == 2262 || showObj.value == 368 || typeId.value == 2766)
	//	   showObj.value == 2262 || showObj.value == 2281 || showObj.value == 343 ||    
	//	   showObj.value == 393 || showObj.value == 392 || showObj.value == 368)
	{
		obj1.style.display='';
	}else if(showObj.value == 2281 || showObj.value == 393){
		if(showObj1.value == 189 || showObj1.value == 190){
			obj1.style.display='';
		}else{
			obj1.style.display='none';
		}
	}else{
		obj1.style.display='none';
	}
	//符合	如下身份类别的可以填写学校信息
	if(showObj.value == 387 || showObj.value == 354 || showObj.value == 2279 || showObj.value == 2285){
		obj2.style.display='';
	}else{
		obj2.style.display='none';
	}
}

function showOrHiddeObjectsForSbj(objId1,objId2,objId3,objForm,showObjName1,showObjName2,showObjName3,showObjName4,showObjName5,showObjName6){
	var obj1 = eval(objId1);
	var obj2 = eval(objId2);
	var obj3 = eval(objId3);
	var showObj1 = objForm[showObjName1];
	var showObj2 = objForm[showObjName2];
	var showObj3 = objForm[showObjName3];
	var showObj4 = objForm[showObjName4];
	var showObj5 = objForm[showObjName5];
	var showObj6 = objForm[showObjName6];
	
	if(showObj1.value == 4050 || showObj2.value == 4055){
		if(showObj3.value == 4059){
			obj2.style.display='';		
			obj3.style.display='none';
		}else if(showObj3.value == 4060){
			obj2.style.display='none';		
			obj3.style.display='';	
		}
	}else{
			obj2.style.display='none';		
			obj3.style.display='none';	
	}
	if(showObj2.value == 4055){
			obj1.style.display='none';
	}else{
		  if(showObj4.value >=5 && showObj4.value <= 30){
		  	if(showObj5.value == 1237 || showObj6.value == 92){
					obj1.style.display='none';	
		  	}else{
					obj1.style.display='';	
		  	}	
		  }else{
				obj1.style.display='none';	
		  }
	}	
}

function showOrHiddeObjectsForWubao(objId2,objForm,showObjName,showObjName1){
	var obj2 = eval(objId2);
	var showObj = objForm[showObjName];
	var showObj1 = objForm[showObjName1];	
	//符合	如下身份类别的可以填写学校信息
	if(showObj.value == 387 || showObj.value == 354 || showObj.value == 2279 || showObj.value == 2285){
		obj2.style.display='';
	}else{
		obj2.style.display='none';
	}
}
var status = 1;
function createIncomeItem(obj,itemId,itemValue,sum,defaultValue){
	var show_obj = document.getElementById('income_'+itemId);
	if(show_obj){
		show_obj.style.display='';
	}else{
		if(itemId!='419'&&itemId!='424'){
			var itemContent ='<table width="100%" id="income_'+itemId+'"><tr ><td width="20%"  class="table_td7"><B>'
				+itemValue+'</B></td><td width="50px" height="25" align="right"  class="table_td7">金额：'
				+'</td><td align="left" class="table_td7">'
				+'<input name="reckonFamilyIncome" style="width:50px" type="text" class="form_text1" size="10" value="'
				+sum+'" onblur="fullIncome(\'incomeValue_'+itemId+'\');';
			if(itemId=='410'){
				itemContent += "analysWage(this.value);";
			}
			itemContent += '"/>元</td><input name="incomeValue" id="incomeValue_'+itemId+'" type="hidden" value="'+defaultValue+'" />';
			if(itemId=='410'){
				itemContent+="<td id=\"wage_reckons\" class=\"table_td7\"></td>";
				itemContent+="<td id=\"wage_policys\" class=\"table_td7\"></td>";
				itemContent+="<td id=\"wage_employs\" class=\"table_td7\"></td>";
			}
			itemContent += '</tr></table>';
			obj.innerHTML+=itemContent;
			if(itemId=="410"){
				if(status == 1){
					var script = document.createElement("script");
					script.type = "text/javascript";
					script.src = "wage.js";
					document.body.appendChild(script);
					status = 2;
				}
			}
			
		}
	}
		if(itemId=='419'){
			document.all.incomeValue_419.disabled=false;
			document.all.incomeUnemploymentType.disabled=false;
			income_unemployment.style.display='';
			
		}
		if(itemId=='424'){
			document.all.incomeValue_424.disabled=false;
			document.all.wageIncome.value = sum;
			document.all.incomeValue_424.value = 424+','+sum;
			income_wage.style.display='';
		}
}

function createIncomeItemView(obj,itemId,itemValue,sum,defaultValue){
	var show_obj = document.getElementById('income_'+itemId);
	if(show_obj){
		show_obj.style.display='';
	}else{
		if(itemId!='419'&&itemId!='424'){
		var itemContent ='<table width="100%" id="income_'+itemId+'"><tr ><td width="20%" class="table_td7"><B>'
					+itemValue+'</B></td><td width="50px" height="25" align="right" class="table_td7">金额：'
					+'</td><td align="left" class="table_td7" >'
					+sum+'元</td>'
					+'<input name="incomeValue" id="incomeValue_'+itemId+'" type="hidden" value="'
					+defaultValue
					+'" />'
					+'</tr></table>'
			obj.innerHTML+=itemContent;
		}
	}
	
		if(itemId=='419'){
			document.all.incomeValue_419.disabled=false;
			document.all.incomeUnemploymentType.disabled=false;
			income_unemployment.style.display='';
			
		}
		if(itemId=='424'){
//			document.all.incomeValue_424.disabled=false;
//			document.all.wageIncome.value = sum;
//			document.all.incomeValue_424.value = 424+','+sum;
			wageIncome.innerHTML=sum+"元"
			income_wage.style.display='';
		}
	
}

function createIncomeItemShowView(obj,itemId,itemValue,sum,defaultValue){
	var show_obj = document.getElementById('income_'+itemId);
	if(show_obj){
		show_obj.style.display='';
	}else{
		if(itemId!='419'&&itemId!='424'){
		var itemContent ='<table width="100%" id="income_'+itemId+'"><tr ><td  width="20%"  class="table_td7"><B>'
					+itemValue+'</B></td><td width="50px" height="25" align="right">金额：'
					+'</td><td align="left" >'
					+sum+'元</td>'
					+'<input name="incomeValue" id="incomeValue_'+itemId+'" type="hidden" value="'
					+defaultValue
					+'" />'
					+'</tr></table>'
			obj.innerHTML+=itemContent;
		}
	}
	
		if(itemId=='419'){
			document.all.incomeValue_419.disabled=false;
			document.all.incomeUnemploymentType.disabled=false;
			income_unemployment.style.display='';
			
		}
		if(itemId=='424'){
//			document.all.incomeValue_424.disabled=false;
//			document.all.wageIncome.value = sum;
//			document.all.incomeValue_424.value = 424+','+sum;
			wageIncome.innerHTML=sum+"元"
			income_wage.style.display='';
		}
	
}

//function showIncomeItem(obj,itemId,itemValue,sum,defaultValue){
//	var show_obj = document.getElementById('income_'+itemId);
//	if(show_obj){
//		show_obj.style.display='';
//		if(itemId=='419'){
//			income_419.innerHTML += '<input name="incomeValue" id="incomeValue_419" type="text" value=""/>';
//			income_419.style.display='';
//		}
//	}else{
//		var itemContent ='<table id="income_'+itemId+'"><tr ><td width="50%"><B>'
//					+itemValue+'</B></td><td width="15%" height="25" align="right">金额：'
//					+'</td><td align="left">'
//					+'<input name="reckonFamilyIncome" style="width:200px" type="text" class="form_text1" size="10" readOnly value="'
//					+sum+'" onblur="fullIncome(\'incomeValue_'+itemId+'\')"/>元</td>'
//					+'<input name="incomeValue" id="incomeValue_'+itemId+'" type="hidden" value="'
//					+defaultValue
//					+'" />'
//					+'</tr></table>'
//		obj.innerHTML+=itemContent;
//	}
//}

function fullIncome(input_id){
	var value = event.srcElement.value;
	document.getElementById(input_id).value=input_id.replace('incomeValue_','')+','+value;
}

function deleteIncomeItem(itemId){
	var obj;
	if(itemId=='419'){
		obj = document.getElementById('income_unemployment');
	}else if(itemId=='424'){
		obj = document.getElementById('income_wage');
	}else{
		obj = document.getElementById('income_'+itemId);	
	}
	if(obj){
		if(itemId=='419'){
			obj.style.display='none';
			var valueObj = document.getElementById('incomeValue_'+itemId);
			var typeObj = document.all.incomeUnemploymentType;
			if(valueObj){
					valueObj.disabled=true;
					valueObj.value = '';
			}
			if(typeObj){
				typeObj.disabled=true;
				typeObj.value='';	
			}
		}else if(itemId=='424'){
			obj.style.display='none';
			var valueObj = document.getElementById('incomeValue_'+itemId);
			if(valueObj){
					valueObj.disabled=true;
					valueObj.value = '';
			}
			document.getElementById('wage_reckon').innerHTML='';
			document.getElementById('wage_policy').innerHTML='';
			document.getElementById('wage_employ').innerHTML='';
		}else{
			obj.parentElement.removeChild(obj);
		}
	}
}

function showOrHiddeIncomeObj(){
	var obj = event.srcElement;
	if(obj.checked){
		createIncomeItem(document.getElementById('income_infos'),obj.value,obj.strValue,'','');
	}else{
		deleteIncomeItem(obj.value);
	}
}

//---start--- add by antingting 2008-8-20
//低收入残疾等级页面效果实现脚本
function showOrHiddeDisabledObj(){
	var obj = event.srcElement;
	if(obj.checked){
		createDisabledItem(document.getElementById('disabled_infos'),obj.value,obj.strValue,'','');
	}else{
		deleteDisabledItem(obj.value);
	}
}

function createDisabledItem(obj,itemId,itemValue,disabledId,defaultValue){
	var show_obj = document.getElementById('disabled_'+itemId);
	if(show_obj){
		show_obj.style.display='';
	}else{	
		var addContent = '<option value="4222" >一级</option><option value="4223">二级</option><option value="4224">三级</option><option value="4225">四级</option>';
		if(disabledId == 4222){
			addContent = '<option value="4222" selected>一级</option><option value="4223">二级</option><option value="4224">三级</option><option value="4225">四级</option>';
		}else	if(disabledId == 4223){
			addContent = '<option value="4222" >一级</option><option value="4223" selected>二级</option><option value="4224">三级</option><option value="4225">四级</option>';
		}else	if(disabledId == 4224){
			addContent = '<option value="4222" >一级</option><option value="4223" >二级</option><option value="4224" selected>三级</option><option value="4225">四级</option>';
		}else	if(disabledId == 4225){
			addContent = '<option value="4222" >一级</option><option value="4223" >二级</option><option value="4224">三级</option><option value="4225" selected>四级</option>';
		}
		var itemContent ='<table width="100%" id="disabledTable_'+itemId+'"><tr ><td width="20%"  class="table_td7" align="right"></td><td width="20%"  class="table_td7" align="left"><B>'
			+itemValue+'</B></td><td width="15%" height="25" align="right"  class="table_td7">残疾等级：'
			+'</td><td align="left" class="table_td7">'
			+'<select name="disabledExtent" onchange="fullDisabled(\'disabled_'+itemId+'\');">'
			+'<option value="-1">--请选择残疾等级--</option>'
			+ addContent +'</select></td>'
			+'<input name="disabledExtentValue" id="disabled_'+itemId+'" type="hidden" value="'+defaultValue+'" /></tr></table>';

		obj.innerHTML+=itemContent;	
	}
}

function fullDisabled(input_id){
	var value = event.srcElement.value;
	document.getElementById(input_id).value=input_id.replace('disabled_','')+','+value;
}


function deleteDisabledItem(itemId){
	var obj;
		obj = document.getElementById('disabledTable_'+itemId);	
	if(obj){		
		obj.parentElement.removeChild(obj);
	}
}

function createDisabledItemForView(obj,itemId,itemValue,disabledId,defaultValue){
	var show_obj = document.getElementById('disabled_'+itemId);
	if(show_obj){
		show_obj.style.display='';
	}else{	
		if(disabledId == 4222){
			addContent = ' 一级';
		}else	if(disabledId == 4223){
			addContent = ' 二级';
		}else	if(disabledId == 4224){
			addContent = ' 三级';
		}else	if(disabledId == 4225){
			addContent = ' 四级';
		}
		var itemContent ='<table width="100%" id="disabledTable_'+itemId+'"><tr ><td width="21%"  class="table_td7" align="right"></td><td width="20%"  class="table_td7" align="left"><B>'
			+itemValue+'</B></td><td width="15%" height="25" align="right"  class="table_td7">残疾等级：'
			+'</td><td align="left" class="table_td7"> &nbsp;&nbsp;'
			+ addContent +'</td>'
			+'<input name="disabledExtentValue" id="disabled_'+itemId+'" type="hidden" value="'+defaultValue+'" /></tr></table>';

		obj.innerHTML+=itemContent;	
	}
}

function showOrHiddeObjForDisable(objId1,objId2,objForm,showObjName){
	var obj1 = eval(objId1);
	var obj2 = eval(objId2);
	var showObj = objForm[showObjName];
	//572：参加保险人员在字典表中的id ;2572:轻度残疾在字典表中的id; 2573:重度残疾在急电表中的id
	if(showObj.value == 2572 || showObj.value == 2573){
		obj1.style.display='';
		obj2.style.display='';
	}else{
		obj1.style.display='none';
		obj2.style.display='none';
	}

}
//---end--- 
