
/**
desc: ��̬�����¼�selectЧ��������Ч��[jz_dictionary:�ֵ��]
@prarm:   objId						��ǰ�����ѡ��ֵ
@prarm:   childSelectObj  ��Ҫ��������Ч�����¼�select����
@param:   clearSelectObj  �Զ����������select���� 
**/
function setSelectChildChange(objId, childSelectObj, clearSelectObj,dsrFlag){
   
	 var selv = "";
	 //����ͬ��   	
	 DWREngine.setAsync(false);
	 ServicePrvUitl.setServiceProjectType(objId,dsrFlag,function(data) {

	    	selv = data;	
	   		}
	   	);	

	childSelectObj.innerHTML = "";
	childSelectObj.options.add(new Option("---��ѡ��---","")); 

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
		clearSelectObj.options.add(new Option("---��ѡ��---","-1"));		
	}	
	
}
