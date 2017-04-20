	
	
	/**	登录到中间库		
	**/
	function doOpenMid(formName){	
		
		var strForm = document[formName];
		var strUrl = "/shjzmid/tologin.jsp";				
		
		strForm.action = strUrl;
		strForm.target = "import_frame";
		strForm.submit();		
		
	}
	
	
	/**建立低保家庭标识
		@param lowGuaranteeNumber		'低保号'对象
		@param obj									'标识'对象	
	**/
	function createLowFamilyFlag(lowGuaranteeNumber , obj){
		if(Jtrim(lowGuaranteeNumber.value).length > 0){
  		obj.value = "5659"; 
  	}else{
  		obj.value = "5660"; 
  	}

	}
	
	/**purpose: 获取'性别'
		*obj:			''	
		*@param:	stNum-> '身份证号码'
	**/			
	function createSex(stNum){	
		var sexId = "";
				
		if(stNum != null){          
          var s = parseInt(stNum.substring(16,17));
          if(s % 2 == 0)   
              sexId = 5989;   //女
          else
              sexId = 5988;   //男        
              
      }		      
      
      return sexId;
	}	
	
	/**purpose: 获取'年龄'
		*obj:			''	
		*@param:	stNum-> '身份证号码'
	**/			
	function createAge(stNum){	
		var age = "";
			
		if(stNum != null && Jtrim(stNum).length > 0 ){      
			    
					var birth = stNum.substring(6,14);					
          var ctDate = getCurrentDate();
          
          age = parseInt(ctDate.substring(0,4)) - parseInt(birth.substring(0,4));
          
          var b1 = birth.substring(4,6);
          var b2 = birth.substring(6,8);            
          var b = b1 + "-" + b2;
                    
          var i = ctDate.indexOf("-");
          var c = ctDate.substring(5,ctDate.length);
        	
          if(b > c )
              age = age -1 ;                
      }		      
      
      return age;
	}		
		
	/**
		获取当前系统的日期
		格式：yyyy-mm-dd
	**/	
	function getCurrentDate(){	
   var d = new Date();
   var s = "";
   var y = d.getYear();
   var m = Jtrim((d.getMonth() + 1) + "");
   var d = Jtrim(d.getDate() + "");
   
   m = m.length < 2 ? "0" + m : m;
   d = d.length < 2 ? "0" + d : d;
  	  	 
   s = y + "-" + m + "-" + d;
      
   return(s);	
		
	}	
		
		
	/**
		获取当前系统的年份
		格式：yyyy
	**/	
	function getCurrentYear(){	
   var d = new Date();
   var s = "";
   var y = d.getYear();
      
   return y;	
		
	}			
	
	/**purpose: 用于'多选'
		*obj:			'checkbox/radio'	
		*@param:	objForm-> '对象Form'
		*@param:  showObjName->'多选对象名称'
	**/	
	function setManyChooseObjValue(objForm, showObjName){
		var showObj = objForm[showObjName];
		var s = showObjName.split("_");				
		var objName = s[1];
	  var obj = objForm[objName];
				
		if(showObj.length != null){
		   		obj.value = "";
		   		
		   		for(var i = 0; i< showObj.length ; i++){
		   			if(showObj[i].checked == true){
			   			if(Jtrim(obj.value).length == 0){
			   				obj.value = "," + showObj[i].value +  ",";
			   			}else{
			   				obj.value += showObj[i].value + ",";
			   			}   				
		   			}
		   		}		   		
		  }
	}
	
	
	/**
	  *用途：提示必填信息窗口
	  *参数：提示信息
	  *参数：操作对象  
	  *参数：显示类别<0,‘填写’；1，‘选择’>
	**/
	function checkEmpty(message, obj, showFlag){
	   var msg = ""; 	   
	   if(Jtrim(obj.value).length == 0 || obj.value == '-1'){
    	   if(showFlag == 0){
    	        msg = "请填写相应的";
    	   }else{
    	        msg = "请选择相应的";
    	   }    	    
    	   alert(msg + "<"+ message + ">！");
    	   obj.focus;    	   
    	   return true; 	    
	    }	    
	}	
	
	
	/**
	  *校验邮政编码
	  *参数：对象
	**/
	function checkZip(obj){	 
			
    	if(Jtrim(obj.value).length >0 ){
    		if(Jtrim(obj.value).length < 6 ||	! isZip(obj) ) {		
    			alert("请输入正确的邮政编码<半届形式的数字>!");
    			obj.focus();
    			return true;
    		}    					
    	}		   	    
	}
	
    /*purpose:	检查输入框的输入是数字
      *@参数：输入对象
    */
    function checkNumber(inputElement){
		var str = inputElement.value;
		var inputCode = event.keyCode;
		//alert("code="+str);
		if(inputCode == 46){
			if(str.indexOf(".")>=0){
				event.returnValue=false;
			}
			return;
		}
		
		if(inputCode == 45){
			if(trim(str).length > 0 ){			    
				event.returnValue=false;
			}
			return;
		}
			
		if(!(inputCode>47 && inputCode<58)){
			event.returnValue=false;
		}else{
      if(str.indexOf(".")>=0){      
         if(str.length-2>str.indexOf("."))
              event.returnValue=false;          
      }		
		}
		
	}	
	
	
    /**
     * purpose: 格式化数字位数	
     * @param strValue		数值
     * @param formatNum		小数位数
     * @return
     */
    function formatNumber(ctValue, formatNum){				
				var OrderIndex=ctValue.indexOf(".");
				var sv = "";
				
				if(OrderIndex >0 ){			
					var s = ctValue.split(".");
					sv = s[0] + ".";					
					if(s[1].length >= formatNum)							
					    sv += s[1].substring(0,formatNum);
					else{
							
					    sv += s[1].substring(0,s[1].length);
					    for(var i = s[1].length ; i < formatNum ; i++){
					        sv += "0"; 
					    }			    
					}
					
				}else{
				    sv = ctValue + ".";
				    for(var i = 0 ; i < formatNum ; i++){
				        sv += "0"; 
				    }
				}
				
				return sv;
	}
	
	
	
	/*purpose:	全部选择操作，或反向	
		*@param:		CheckAll->		  '操作全选对象'
		*@param:		CheckRecords->  '被操作对象'
	*/
	function checkAll(CheckAll, CheckRecords){
		
	 if( CheckRecords == null ) return;
	 if (CheckRecords.length>0){
		 if (CheckAll.checked){
			for (i=0;i<CheckRecords.length;i++){
				if(!CheckRecords[i].disabled)
				{
					 CheckRecords[i].checked=true;
				}
			 }
		 }else{
		 for (i=0;i<CheckRecords.length;i++){
			CheckRecords[i].checked=false;
		}
		}
	}else{	 
		
		if (CheckAll.checked){

			 CheckRecords.checked=true;

		 }else{
		    CheckRecords.checked=false;
		    
		}
	}
		window.event.cancelBubble = true;
		return false; 
 }
	
 function setValue(strObj1 ,strValue ,strObj2){
		
		var ctValue = getSelectText(strObj1 ,strValue, 0);
		setObjValue(ctValue,strObj2);
		
	}

	function setObjValue(ctValue,strObj){	
		strObj.value = ctValue;
	}

	
	
	/**
		*获取'选择'的值
		*用于:		  'select'
		*strObj:	  '对象'
		*strValue:  '当前下标'
		*flag:			'0，条件为value；1，选择下标'
	**/	
	function getSelectText(strObj,strValue, flag){
		var ctText = "";
						
		for(var i=0 ;i < strObj.length; i++){			
			if(flag == 0){
				if(strObj[i].value == strValue){					
					ctText = strObj[i].text;
					break;
				}							
			}else{
				if(i == strValue){
					ctText = strObj[i].text;
					break;
				}							
			}
		}
		
		return ctText;
	
	}	



  //获取当前'select'中选中的Value
  function getSelectedValue(strForm,obj) {
        var ids=strForm[obj];
        var returnvalue = "";        
        
        if(ids == null){
        	return returnvalue;
        }
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].selected==true){              
                  returnvalue=ids[i].value;
                  break;  
                }            
            }                                
        }else{
          returnvalue =ids.value; 
            
        }
        return returnvalue;
  }	

	
	/**判断是否已经选择对象
		适用对象：	checkbox/radio
		*objForm:	  'Form对象'
		*obj:  			'选择对象名称'
	**/
	function checkSelected(objForm,obj){
        var isCheck = false;
        var ids = objForm[obj];  
        
        if(ids == null){
        	isCheck = false;
        	return isCheck;
        }
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked==true){
                  isCheck=true;
                  break;  
                }            
            }            
            
        }else{
            if(ids.checked==true)
                isCheck=true;
        }            
        
        return isCheck;	 
              
	}
	

	/*获取当前的选中的index
		*对象：select
		*参数：strForm -> '对象Form'
		*参数：obj -> 		'选择对象'
	*/
	function getSelectIndex(strForm,obj){
        var index = 0;
        var ids = strForm[obj];    
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].selected==true){
                  index=i;
                  break;  
                }            
            }            
            
        }else{
            if(ids.checked==true)
                index=0;
        }                           
        return index;	               
	}
	
	/*获取当前的选中的index
		*对象：checkbox
		*参数：strForm -> '对象Form'
		*参数：obj -> 		'选择对象'
	*/
	function getCheckIndex(strForm,obj){
        var index = -1;
        var ids = strForm[obj];    
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked==true){
                  index=i;
                  break;  
                }            
            }            
            
        }else{
            if(ids.checked==true)
                index=0;
        }                           
        return index;	 
              
	}	
	
	
    //获得选中的值[单个]
    function getCheckedValue(objForm,obj) {
        var ids = objForm[obj];
        var returnvalue = "";        
        
        if(ids == null){
        	return returnvalue;
        }
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked==true){              
                  returnvalue=ids[i].value;
                  break;  
                }            
            }                                
        }else{
          returnvalue =ids.value; 
            
        }
        return returnvalue;
    }	
    
    
     //获得选中的值[多个]
    function getAllCheckedValue(strForm,obj) {
        var form=document[strForm];
        var ids=form[obj];
        var returnValue ="";        
        
        if(ids ==null )
           return 0;
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked==true){  
                   
                  if(returnValue=="")              
                    returnValue=ids[i].value;               
                  else
                    returnValue=returnValue+","+ids[i].value;                
                }            
            }                    
        }else{
          returnValue =ids.value; 
        }
        return returnValue;
    }	

   
     //获得选中的值[多个]
    function getAllCheckedIndexValue(strForm,obj) {
        var form=document[strForm];
        var ids=form[obj];
        var returnValue ="";        
        
        if(ids ==null )
           return 0;
        
        if(ids.length!=null){
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked==true){  
                   
                  if(returnValue=="")              
                    returnValue= i + ",";               
                  else
                    returnValue +=i + ",";                
                }            
            }                    
        }else{
          returnValue =-1; 
        }
        return returnValue;
    }	
  
    //判断当前是已经多选
    function checkSelectedNum(objForm,obj) {        
        var ids = objForm[obj];        
        var isCheck = 0;        
        
        if(ids  == null)                        
            return 0;
        
        if(ids.length != null){
	        for(var i=0;i<ids.length;i++){
	            if(ids[i].checked==true){                              
	              isCheck++;
	              if(isCheck>1)              
	                 break;
	            }            
		       }    
        }else{
        	if(ids.checked == true)
        		isCheck = true;
        }
        
        return isCheck;
    }    	
    
  /**	获取对象的长度
  	@param 	strForm -->'Form对象'
  	@param 	objName -->'对象名称'
  **/  
  function getObjectLength(strForm, objName){
  	var obj = strForm[objName];
  	
  	if(obj == null)
  		return 0;
  	else if (obj.length != null){
  		return obj.length;
  	}else {
  		return 1;
  	}
  	
  }  
   
    
    
    //刷新当前窗体
    function load(){
	    window.location.reload(true);	    
	}
	
	//创建弹出窗体
	function CreateWindow(url)
    {
        msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
    }
    //重新弹出窗体
	function CreateBlankWindow(url)
    {
        msgWindow=window.open(url,"_blank","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
    }  
    
   //重新弹出窗体
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars=no,resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
   }    
    //重新弹出窗体
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth,ctScrol)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars="+ ctScrol +",resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
   }
  
  //点击window窗口的关闭按纽后，在关闭前先刷新父窗体  
  function onBeforeUnload(){
  	//window.opener.location.reload();  	  
  }    
	
	//关闭当前窗体
	function doCloseCurrent(){
		window.close();
	}
	
	//关闭前刷新父窗体
	function doclose()
    {
    	window.opener.location.reload();
    	window.close();
    }

	//关闭前刷新父->父窗体
	function doParentClose()
    {    	
    	window.parent.opener.location.reload();
    	window.parent.close();
    }
    
    //取得table的当前行数
   function getTabelRowIndex(){
        var e=event.srcElement;
				if(e==this){return;}
				while(e.tagName!="TR"){e=e.parentElement;}
        
        return e.rowIndex-1;
    
    }
    
    /*设置日期的函数*/
    /*用法：函数名：（输入日期的名字，日历路径）*/
    function setDate(dateBody,pathname){
    	 showx = event.screenX - event.offsetX - 200 ; 
    	 showy = event.screenY - event.offsetY - 100 ; 
    	 var return_Value =window.showModalDialog(pathname,"Calendar","dialogTop:"+showy+";dialogLeft:"+showx+";dialogWidth:280px;dialogHeight:260px;status:no;resizable:no;help:no;scrollbars:no");
    	 if (return_Value!=null){
           if (return_Value.length!=0){
        			dateBody.value = return_Value;
           } 
    	 }
     }
    
  /*
      给对象组件赋值  
      strObj    '组件名称'
      strValue  '组件值'
   */
  function setPutValue(strObj ,strValue){
     var strForm = opener.document.forms[0];
                    
     if(strForm[strObj] != null)
       strForm[strObj].value = strValue;
  }
	
/*
	判断当前选择的帐务期间是否在有效日期之内
	ctDate  'currentDate'
	obj     'tableName'
	objIds  'ids'
*/
function judgeAccountStatus(ctDate ,obj ,objIds){		
	
	var rowCount = 0;
	var bg = false;
				
		rowCount = obj.rows.length;
					
		if(rowCount == null || rowCount <= 1){
			return false;
		}else	if(rowCount == 2){
		 		if(objIds.checked == true){
		 			
				 		var beginDate = obj.rows[1].cells[1].innerText;
				 		var endDate = obj.rows[1].cells[2].innerText;						 		
				 		if(ctDate > endDate){
				 				bg = true;	
				 				return bg;				 										 			  
				 		}		
			 								 					 			
		 		}
		}else{		
				for(var i =1; i<rowCount ; i++){
					 if(objIds[i-1].checked == true){
					 	
					 		var beginDate = obj.rows[i].cells[1].innerText;
					 		var endDate = obj.rows[i].cells[2].innerText;
					 		if(ctDate >endDate)	{
					 				bg = true;					 				
					 			  break;
					 		}
					 		
					 }										 	
				}							
		}
		
		return bg ;
	
}
	
  
  //刷新frame
  function doFrameRefresh(obj){
  	  	
  	parent.frames[obj].location.reload();
   	
  }			
   
 
 //返回  
 function doGo(strKey){
 	  if(strKey == 'pre')
			window.history.go(-1); 	
 	
 }	  

	//在隐藏的窗体中打开“下载的届面”
 function doDownFile(strFile){	
	
		var strForm = document.myform;
		
		strForm.target = "hide_iframe";
		strForm.action = strFile;
		strForm.submit();		
	
 }
 	

	/*
		单个隐藏[显示第一个]
	*/
	function doShowOneObj(obj1,obj2){
	    var el = document.getElementById(obj1);
	    var e2 = document.getElementById(obj2);	

	    el.style.display = "block";
	    
			e2.style.display = "none";
			e2.style.Height ="0";
	    			    
	}		
 	
 	/*
 		打开/隐藏-->对象
 	*/
 	function showObject(obj,obj1){
	    var el = document.getElementById(obj);
	    	
	    if(el.style.display == "none"){ 
	        el.style.display = "block";
	        obj1.src="/shjz/main/images/hy.gif";	        
			
	    }else{
	        el.style.display = "none";
	        obj1.src="/shjz/main/images/gd.gif";
	    }
	    
	}		

	
 	/*
 		是否是资金类型
 	*/
	function ismoney(obj){
		slen=obj.value.length;
		for (i=0; i<slen; i++){
			cc = obj.value.charAt(i);
			if ((cc <"0" || cc > "9") && cc != ".")	{
				return false;
			}
		}
		return true;
	}

 	/*
 		是否是阿拉伯数字
 	*/
	function isdigit(obj){
		slen=obj.value.length;
		for (i=0; i<slen; i++){
			cc = obj.value.charAt(i);
			if (cc <"0" || cc >"9"){
				return false;
			}
		}
		return true;
	}
