	
	/**
		还原url
	**/
	function reductionUrl(toStrUrl){		
		var begin = toStrUrl.indexOf("/");		
		var end = toStrUrl.lastIndexOf("'");
		
		toStrUrl = toStrUrl.substring(begin, end);		
		
		var num = toStrUrl.indexOf("*");	
		for(var i = 0; i < num; i ++){
			toStrUrl = toStrUrl.replace("*", "&");	
		}
						
		return toStrUrl;
	} 
	
	/**建立低保家庭标识
		@param lowGuaranteeNumber		'低保号'对象
		@param obj									'标识'对象	
	**/
	function createLowFamilyFlag(lowGuaranteeNumber , obj){
		if(Jtrim(lowGuaranteeNumber.value).length > 0){
  		obj.value = "2204"; 
  	}else{
  		obj.value = "2205"; 
  	}

	}
	
	/*
 		打开/隐藏-->对象
 	*/
 	function showObject(obj,obj1){
	    var el = document.getElementById(obj);
	    	
	    if(el.style.display == "none"){ 
	        el.style.display = "block";
	        obj1.src="../../images/hy.gif";	        
			
	    }else{
	        el.style.display = "none";
	        obj1.src="../../images/gd.gif";
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
              sexId = 120;   //女
          else
              sexId = 119;   //男        
              
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
	
	/**purpose: 获取'出生日期'
		*obj:			''	
		*@param:	stNum-> '身份证号码'
	**/			
	function createBirth(stNum){	
		var birthStr = "";
			
		if(stNum != null && Jtrim(stNum).length > 0 ){      
			    
					var birth = stNum.substring(6,14);	
					var b1 = birth.substring(0,4);
          var b2 = birth.substring(4,6);
          var b3 = birth.substring(6,8);
          
          var birthStr = b1 + "-" + b2 + "-" + b3;   
      }		      
      
      return birthStr;
	}	
	
	/**purpose: 获取'年龄'
		*obj:			''	
		*@param:	stNum-> '身份证号码'
	**/			
	function createAgeNew(stNum){	
		var age = "";
			
		if(stNum != null && Jtrim(stNum).length > 0 ){      
		    if(Jtrim(stNum).length == 18){
    			    
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
            if(Jtrim(stNum).length == 15){
    			    
    		  var birth = stNum.substring(6,12);					
              var ctDate = getCurrentDate();
              
              age = parseInt(ctDate.substring(0,4)) - 1900 - parseInt(birth.substring(0,2));
              
              var b1 = birth.substring(2,4);
              var b2 = birth.substring(4,6);            
              var b = b1 + "-" + b2;
                        
              var i = ctDate.indexOf("-");
              var c = ctDate.substring(5,ctDate.length);
            	
              if(b > c )
                  age = age -1 ;   
            }  
            if(Jtrim(stNum).length == 8){
    			    
    		  var birth = stNum.substring(0,8);					
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
	
	/**
		获取当前系统的月份
		格式：mm
	**/	
	function getCurrentMonth(){	
   var d = new Date();
   var s = "";
   var m = d.getMonth() + 1;
      
   return m;	
		
	}
	
	/**
		获取当前系统的日期
		格式：dd
	**/	
	function getCurrentDay(){	
   var d = new Date();
   var s = "";
   var day = d.getDate();
      
   return day;	
		
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
    			alert("请输入正确的邮政编码<半角形式的数字>!");
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
	
	/*purpose:	检查输入框的输入是整数
      *@参数：输入对象
    */
	function checkNumbers(inputElement){
		var str = inputElement.value;
		var inputCode = event.keyCode;
		//alert("code="+str);
		
		if(!(inputCode>47 && inputCode<58)){
			event.returnValue=false;
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
				if(!CheckRecords[i].disabled){					 
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
			 if(!CheckRecords.disabled)
			 		CheckRecords.checked=true;

		 }else{
		 		if(!CheckRecords.disabled)
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
	function openUrl(url) {
		window.open(url, "newWin", "top=0,left=0,toolbar=no,width=960,height=680,directories=no,status=no,scrollbars=yes,resize=no,menubar=no");
	}
    //刷新当前窗体
    function load(){
	    window.location.reload(true);	    
	}
	
	//创建弹出窗体
	function openwin(url,left,top)
    {
    	var config = "toolbar=no,width=1000,height=500,directories=no,status=no,scrollbars=no,resize=no,menubar=no";
    	if(left){
    		config += ",left="+left;	
    	}
    	if(top){
    		config += ",top="+top;	
    	}
        msgWindow=window.open(url,"protypeWindow",config);
        msgWindow.focus();
    }
	//创建弹出窗体
	function CreateWindow(url)
    {
        msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
        msgWindow.focus();
    }
    //重新弹出窗体
	function CreateBlankWindow(url)
    {
        msgWindow=window.open(url,"_blank","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
        msgWindow.focus();
    }  
    //重新弹出窗体
	function CreateContractBlankWindow(url){
        msgWindow=window.open(url,"_blank","toolbar=no,width=900,height=670,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
        msgWindow.focus();
   }     
   //重新弹出窗体
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars=no,resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
        msgWindow.focus();
   }    
    //重新弹出窗体
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth,ctScrol)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars="+ ctScrol +",resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
        msgWindow.focus();
   }
    
    
 	//重新弹出窗体
	function CreateWindow(strUrl,strName,config)
  {
  	var win = window;
  	while(win.opener){
  			win = win.opener;
  	}
  	var width = win.screen.availWidth;
  	var b = /.*width=([0-9])/;
  	var selfWidth = 200;
  	if(config.indexOf('width')!=-1){
  		selfWidth = parseInt(config.replace(b,'$1'));
  	}
    if(config.indexOf('left')==-1){
    	config +=",left="+((width-selfWidth)/2);
    }
    if(config.indexOf('top')==-1){
    	config +=',top=0';
    }
    msgWindow=window.open(strUrl,strName,config);
    msgWindow.focus();
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

	//在隐藏的窗体中打开“下载的界面”
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
	
	
	function Jtrim(str){
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}


function isIdCard(obj) {
	var Errors=new Array(
        "身份证号码位数不对!",
        "身份证号码出生日期超出范围或含有非法字符!",
        "身份证号码校验错误!",
        "身份证地区非法!"
    );
    var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"} 
    var Y,JYM;
    var S,M;
	  var idcard = obj.value.toUpperCase();
	  if(idcard!=obj.value){
	  	obj.value = idcard;	
	  }
	//位数检测
	if(idcard == null || idcard == "" || (idcard.length != 15 && idcard.length != 18)) {
		alert(Errors[0]);
		return false;
	}

    var idcard_array = new Array();
    idcard_array = idcard.split("");

    //地区检验
    if(area[parseInt(idcard.substr(0,2))] == null) {
		alert(Errors[3]);
		return false;
	}

    //身份号码位数及格式检验
    if(idcard.length == 15) {
		if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
			ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性
		} else {
			ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性
		}
		if(ereg.test(idcard)){
			return true;
		}else{
			alert("1"+Errors[1]);
			return false;
		}
		return true;
	} else if(idcard.length == 18) {
		//18位身份号码检测
		//出生日期的合法性检查
		//闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
		//平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
		if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
			ereg=/^[1-9][0-9]{5}[0-9]{4}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9XxZz]$/;//闰年出生日期的合法性正则表达式
		} else {
			ereg=/^[1-9][0-9]{5}[0-9]{4}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9XxZz]$/;//平年出生日期的合法性正则表达式
		}
		if(idcard_array[17]!='Z'&&idcard_array[17]!='z'){
			if(ereg.test(idcard)){//测试出生日期的合法性
				//计算校验位
				S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
				+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
				+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
				+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
				+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
				+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
				+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
				+ parseInt(idcard_array[7]) * 1
				+ parseInt(idcard_array[8]) * 6
				+ parseInt(idcard_array[9]) * 3 ;
				Y = S % 11;
				M = "F";
				JYM = "10X98765432";
				M = JYM.substr(Y,1);//判断校验位
				if(M == idcard_array[17].toUpperCase()){
					return true; //检测ID的校验位
				}else{
					alert(Errors[2]);
					return false;
				}
			}else{
				alert(Errors[1]);
				return false;
			}
		}
		return true;
  }
}


/**
*四舍五入,ori为输入值,num为保留的小数位数
*如:对11.115,四舍五入,保留两位小数,rounding(11.115,2)
*/
function rounding(ori,num){
	var m = Math.pow(10,num);
	return Math.round(parseFloat(ori*m))/m
}

/**
 * 全选或全不选CheckBox
 * strObj：对象CheckBox的名字
 * status：状态（true，false）
 */
function checkAllByName(strObj, status) {
	var boxes = document.getElementsByName(strObj);
	for(var i = 0; i < boxes.length; i++) {
		boxes[i].checked = status;
	}
}

/**
 * 检查是否是合法的用户名，只允许英文，数字，“-”，和“.”
 * s：字符串
 */
function isUsername(s) {
	var regu = "^([a-zA-Z]+[_0-9a-zA-Z.-]*)$"
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
	   return true;
	} else {
	   return false;
	}
}

//返回字符串长度：汉字为2个长度
function mGetLength(tstValue)
{
   var i=0;
   var str="";
   tstValue=strim(tstValue);
   var l=tstValue.length;
   var t=l;
   while (i<l) {
      if(tstValue.charAt(i)>'\xFF')
      {
         t++;
      }
      i++;
   }
   return (t);
}

//去掉字符中前后空格
function strim(tstValue)
{
   return (srtrim(sltrim(tstValue)));
}


//去掉字符中前空格
function sltrim(tstValue)
{
   var i=0;
   var str=""+tstValue;
   var l=str.length;
   var c=str.charAt(i++);
   while ((c==' ') && (i<l)) {
      c=str.charAt(i++);
   }
   return (str.substring(i-1,l));
}

//去掉字符中后空格
function srtrim(tstValue)
{
   var i=0;
   var str=""+tstValue;
   var l=str.length;
   i=l
   var c=str.charAt(--i);
   while ((c==' ') && (i>=0)) {
      c=str.charAt(--i);
   }
   return (str.substring(0,i+1));
}

/*
window.alert = function(msg){
	window.showModalDialog(getRoot()+'/common/alert.jsp?msg='+msg,'','status:no;scroll:no;help:no;dialogHeight:279px;dialogWidth:396px;unadorned:yes');	
}

window.confirm = function(msg){
	return window.showModalDialog(getRoot()+'/common/confirm.jsp?msg='+msg,'','status:no;scroll:no;help:no;dialogHeight:279px;dialogWidth:396px;unadorned:yes');
}
*/
function getRoot(){
	var root = window.location.pathname;
	if(root.substring(0,1)=='/'){
			root = root.substring(1)
	}
	root = '/'+root.substring(0,root.indexOf('/'));
	return root;
}


 	/*
 		打开/隐藏-->一个对象
 		@param: imgBN   -> '隐藏对象所对应的图像的前缀名' 		
 		@param: objBN   -> '隐藏对象的前缀名' 		
 		@param: ctObj   -> '当前对象的Name'
 		@param: ctImage -> '当前对象所对应的图像的Name'
 	*/
 	function showImages(imgBN, objBN ,ctImage, ctObj){
			var ctObj = document.getElementById(ctObj);
			
			if(imgBN != null){
		 			for(var i = 0; i < 20 ; i ++){ 				
		 				var allObj = objBN + i;
		 				var alllImages = imgBN + i;
		 				var allEl = document.getElementById(allObj);
		 				var allImgs = document.getElementById(alllImages);
		 				
		 				if(allEl != null && allEl.id != ctObj.id){ 					 
		 					 allEl.style.display = "none";
			         allImgs.src="/shjz/main_hdsj/images/n-up.gif";	      
		 				} 				
		 			}				
			}
 		  	    	
	    if(ctObj.style.display == "none"){ 
	        ctObj.style.display = "block";
	        ctImage.src="/shjz/main_hdsj/images/n-down.gif";	        
			
	    }else{
	        ctObj.style.display = "none";
	        ctImage.src="/shjz/main_hdsj/images/n-up.gif";
	    }	
	    
	     
	}

function f_change_pageSize(form,pageSize){

		if(pageSize&&parseInt(pageSize)){
				form.page_size.value = pageSize;
				form.submit();
		}
	}

/**
* 比较日期
* beginDate:开始日期
* beginDateName:开始日期的名称:例如:申请开始日期
* endDate：结束日期
* endDateName:结束如期的名称：例如：申请结束日期
* return: false:验证错误
*/
function compareDate(beginDate,beginDateName,endDate,endDateName){
	var beginDateFlag = 0;
	var endDateFlag = 0;
	if(beginDate != null && beginDate != ""){
		beginDateFlag = 1;
	}
	if(endDate != null && endDate != ""){
		endDateFlag = 1;
	}
	if((beginDateFlag & endDateFlag) == true){
		if(beginDate > endDate){
			var msg = "'" + beginDateName + "'不能大于'" + endDateName + "'!";
			alert(msg);
			return false;
		}
	}
	return true;
}