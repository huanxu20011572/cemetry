		
		function doClickMenu(menuName, flag ,formName, strUrl,strTarget){
			
			//alert(menuName);	
			var strForm = document[formName];
			var ctObj = document.getElementById(menuName);
			var sp = menuName.split("_");
			
			ctObj.className = "current_title";			
			
			for(var i = 0; i < 10 ; i++){
				if(sp[2] != i){
					var muName = "td_memu_" + i;
					var obj = document.getElementById(muName);
					
					if(obj == null)
						continue;
					
					obj.className = "uncurrent_title";						
				}				
				
			}			

				strForm.action = strUrl;
				strForm.target = strTarget;
				strForm.submit();															
			
		}
	
	
	function doExpandMenu(objValue){
		
		var obj1 = "sub"+objValue;
		var obj2 = "sub";
		var subCount = 20;
		
		if(objValue == -1)
			return ;
		
		var menuTotals = document.getElementById('menuTotals');
		
		for(var i = 1; i<=subCount ; i++){
			var objSub = document.getElementById("sub"+i);
			if(objSub != null){
				if(i != objValue){
					if(obj2 == "sub"){
						obj2 += i;
					}else{
						obj2 += "*sub"+i;	 
					}	 
				}				
			}
			
		}
					
		if(menuTotals.value != "0" && menuTotals.value != objValue){			
			var ctId = "td" + objValue;
			for(var i = 1 ; i <= subCount ; i++){
				var sId = ctId + "_" + i; 
				var td = document.getElementById(sId);
				if(td != null){
						td.style.backgroundImage = "url('images/BGGG.gif')";							
				}
			}				
		}
		
				
		clickMenu(obj1,obj2,subCount);		
		
	}
	
	/*
		单击菜单
	*/
	function clickMenu(obj,strObjs){	
		var s = strObjs.split("*");
		
		if(obj != null){			
			var isExp = isExpand(obj);
			var el = document.getElementById(obj);
			if(isExp == false){				
				el.style.display = "block";						
			}else{
				el.style.display = "none";						
			}
		}
		
		for(var i = 0 ;i< s.length; i++){
				var e2 = document.getElementById(s[i]);		
				
				if(e2 != null)		
					e2.style.display = "none";					
		}	

	}		

  /*
  	判断当前菜单是否已经展开
  */
	function isExpand(obj){
		var el = "";
		
		if(obj != null){			
				el = document.getElementById(obj);
				if(el.style.display == "block" )
					return true;
				else
					return false;	
			}
	}	
	
	/*
		点击子菜单，更换底色,并打开相应的链接
	*/
	function toMenus(strUrl,strTarget,strObj){				
		var tdId = strObj.id;
		var ids = tdId.split("_");
		var strForm = document.form1;
		var strLen = 0;
		var pNode = strObj;
		var menuTotals = document.getElementById('menuTotals');
		
		
		strObj.style.backgroundImage = "url('images/BGGG1.gif')";				
		//save id of current click menu	
		menuTotals.value = ids[0].substring(ids[0].length ,2);						
			
		for(var i = 1 ;i <=30; i++){
			var id = ids[0] + "_" + i;
			if(id != tdId){
				var td = document.getElementById(id);
				if(td != null){
					td.style.backgroundImage = "url('images/BGGG.gif')";											
				}
			} 
		}
		
		if(strUrl == '_blank'){
			strUrl = strObj.children[0].href;			
		}else{
			return ;
		}
			
		strForm.action = strUrl;
		strForm.target = strTarget;				
		strForm.submit();
				
	}
