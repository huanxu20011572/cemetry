
/**
desc: 动态设置下级select效果，联动效果[jz_dictionary:字典表]
@prarm:   objId						当前对象的选中值
@prarm:   childSelectObj  需要发生联动效果的下级select对象
@param:   clearSelectObj  自动清除其它的select对象 
**/
function setSelectChildChange(objId, childSelectObj, clearSelectObj,dsrFlag){
   
	 var selv = "";
	 //设置同步   	
	 DWREngine.setAsync(false);
	 ServicePrvUitl.setServiceProjectType(objId,dsrFlag,function(data) {

	    	selv = data;	
	   		}
	   	);	

	childSelectObj.innerHTML = "";
	childSelectObj.options.add(new Option("---请选择---","")); 

	if(selv != null && Jtrim(selv).length  >0){				
		var s = selv.split("|");
	
		if(s.length >0){			
			for(var i=0; i<s.length; i++){	
				var ss = s[i];	
					var dicts = s[i].split(",");		
								
					if(dicts.length >0){						
						childSelectObj.options.add(new Option(dicts[1],dicts[0])); 
					}
			}
		}
	}	   

	if(clearSelectObj != null ){
		clearSelectObj.innerHTML = "";
		clearSelectObj.options.add(new Option("---请选择---","-1"));		
	}	
	
}
