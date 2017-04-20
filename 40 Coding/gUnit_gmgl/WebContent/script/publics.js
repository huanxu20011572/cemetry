	
	/**
		��ԭurl
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
	
	/**�����ͱ���ͥ��ʶ
		@param lowGuaranteeNumber		'�ͱ���'����
		@param obj									'��ʶ'����	
	**/
	function createLowFamilyFlag(lowGuaranteeNumber , obj){
		if(Jtrim(lowGuaranteeNumber.value).length > 0){
  		obj.value = "2204"; 
  	}else{
  		obj.value = "2205"; 
  	}

	}
	
	/*
 		��/����-->����
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


	/**purpose: ��ȡ'�Ա�'
		*obj:			''	
		*@param:	stNum-> '���֤����'
	**/			
	function createSex(stNum){	
		var sexId = "";
				
		if(stNum != null){          
          var s = parseInt(stNum.substring(16,17));
          if(s % 2 == 0)   
              sexId = 120;   //Ů
          else
              sexId = 119;   //��        
              
      }		      
      
      return sexId;
	}	
	
	/**purpose: ��ȡ'����'
		*obj:			''	
		*@param:	stNum-> '���֤����'
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
	
	/**purpose: ��ȡ'��������'
		*obj:			''	
		*@param:	stNum-> '���֤����'
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
	
	/**purpose: ��ȡ'����'
		*obj:			''	
		*@param:	stNum-> '���֤����'
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
		��ȡ��ǰϵͳ������
		��ʽ��yyyy-mm-dd
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
		��ȡ��ǰϵͳ�����
		��ʽ��yyyy
	**/	
	function getCurrentYear(){	
   var d = new Date();
   var s = "";
   var y = d.getYear();
      
   return y;	
		
	}	
	
	/**
		��ȡ��ǰϵͳ���·�
		��ʽ��mm
	**/	
	function getCurrentMonth(){	
   var d = new Date();
   var s = "";
   var m = d.getMonth() + 1;
      
   return m;	
		
	}
	
	/**
		��ȡ��ǰϵͳ������
		��ʽ��dd
	**/	
	function getCurrentDay(){	
   var d = new Date();
   var s = "";
   var day = d.getDate();
      
   return day;	
		
	}			
	
	/**purpose: ����'��ѡ'
		*obj:			'checkbox/radio'	
		*@param:	objForm-> '����Form'
		*@param:  showObjName->'��ѡ��������'
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
	  *��;����ʾ������Ϣ����
	  *��������ʾ��Ϣ
	  *��������������  
	  *��������ʾ���<0,����д����1����ѡ��>
	**/
	function checkEmpty(message, obj, showFlag){
	   var msg = ""; 	   
	   if(Jtrim(obj.value).length == 0 || obj.value == '-1'){
    	   if(showFlag == 0){
    	        msg = "����д��Ӧ��";
    	   }else{
    	        msg = "��ѡ����Ӧ��";
    	   }    	    
    	   alert(msg + "<"+ message + ">��");
    	   obj.focus;    	   
    	   return true; 	    
	    }	    
	}	
	
	
	/**
	  *У����������
	  *����������
	**/
	function checkZip(obj){	 
			
    	if(Jtrim(obj.value).length >0 ){
    		if(Jtrim(obj.value).length < 6 ||	! isZip(obj) ) {		
    			alert("��������ȷ����������<�����ʽ������>!");
    			obj.focus();
    			return true;
    		}    					
    	}		   	    
	}
	
    /*purpose:	�������������������
      *@�������������
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
	
	/*purpose:	�������������������
      *@�������������
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
     * purpose: ��ʽ������λ��	
     * @param strValue		��ֵ
     * @param formatNum		С��λ��
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
	
	
	
	/*purpose:	ȫ��ѡ�����������	
		*@param:		CheckAll->		  '����ȫѡ����'
		*@param:		CheckRecords->  '����������'
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
		*��ȡ'ѡ��'��ֵ
		*����:		  'select'
		*strObj:	  '����'
		*strValue:  '��ǰ�±�'
		*flag:			'0������Ϊvalue��1��ѡ���±�'
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



  //��ȡ��ǰ'select'��ѡ�е�Value
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

	
	/**�ж��Ƿ��Ѿ�ѡ�����
		���ö���	checkbox/radio
		*objForm:	  'Form����'
		*obj:  			'ѡ���������'
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
	
	

	/*��ȡ��ǰ��ѡ�е�index
		*����select
		*������strForm -> '����Form'
		*������obj -> 		'ѡ�����'
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
	
	/*��ȡ��ǰ��ѡ�е�index
		*����checkbox
		*������strForm -> '����Form'
		*������obj -> 		'ѡ�����'
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
	
	
    //���ѡ�е�ֵ[����]
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
    
    
     //���ѡ�е�ֵ[���]
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

   
     //���ѡ�е�ֵ[���]
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
  
    //�жϵ�ǰ���Ѿ���ѡ
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
    
  /**	��ȡ����ĳ���
  	@param 	strForm -->'Form����'
  	@param 	objName -->'��������'
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
    //ˢ�µ�ǰ����
    function load(){
	    window.location.reload(true);	    
	}
	
	//������������
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
	//������������
	function CreateWindow(url)
    {
        msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
        msgWindow.focus();
    }
    //���µ�������
	function CreateBlankWindow(url)
    {
        msgWindow=window.open(url,"_blank","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
        msgWindow.focus();
    }  
    //���µ�������
	function CreateContractBlankWindow(url){
        msgWindow=window.open(url,"_blank","toolbar=no,width=900,height=670,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
        msgWindow.focus();
   }     
   //���µ�������
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars=no,resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
        msgWindow.focus();
   }    
    //���µ�������
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth,ctScrol)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars="+ ctScrol +",resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
        msgWindow.focus();
   }
    
    
 	//���µ�������
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
  
  //���window���ڵĹرհ�Ŧ���ڹر�ǰ��ˢ�¸�����  
  function onBeforeUnload(){
  	//window.opener.location.reload();  	  
  }    
	
	//�رյ�ǰ����
	function doCloseCurrent(){
		window.close();
	}
	
	//�ر�ǰˢ�¸�����
	function doclose()
    {
    	window.opener.location.reload();
    	window.close();
    }

	//�ر�ǰˢ�¸�->������
	function doParentClose()
    {    	
    	window.parent.opener.location.reload();
    	window.parent.close();
    }
    
    //ȡ��table�ĵ�ǰ����
   function getTabelRowIndex(){
        var e=event.srcElement;
				if(e==this){return;}
				while(e.tagName!="TR"){e=e.parentElement;}
        
        return e.rowIndex-1;
    
    }
    /*�������ڵĺ���*/
    /*�÷��������������������ڵ����֣�����·����*/
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
      �����������ֵ  
      strObj    '�������'
      strValue  '���ֵ'
   */
  function setPutValue(strObj ,strValue){
     var strForm = opener.document.forms[0];
                    
     if(strForm[strObj] != null)
       strForm[strObj].value = strValue;
  }
	
/*
	�жϵ�ǰѡ��������ڼ��Ƿ�����Ч����֮��
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
	
  
  //ˢ��frame
  function doFrameRefresh(obj){
  	  	
  	parent.frames[obj].location.reload();
   	
  }			
   
 
 //����  
 function doGo(strKey){
 	  if(strKey == 'pre')
			window.history.go(-1); 	
 	
 }	  

	//�����صĴ����д򿪡����صĽ��桱
 function doDownFile(strFile){	
	
		var strForm = document.myform;
		
		strForm.target = "hide_iframe";
		strForm.action = strFile;
		strForm.submit();		
	
 }
 	

	/*
		��������[��ʾ��һ��]
	*/
	function doShowOneObj(obj1,obj2){
	    var el = document.getElementById(obj1);
	    var e2 = document.getElementById(obj2);	

	    el.style.display = "block";
	    
			e2.style.display = "none";
			e2.style.Height ="0";
	    			    
	}		
 	

 	/*
 		�Ƿ����ʽ�����
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
 		�Ƿ��ǰ���������
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
        "���֤����λ������!",
        "���֤����������ڳ�����Χ���зǷ��ַ�!",
        "���֤����У�����!",
        "���֤�����Ƿ�!"
    );
    var area={11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����"} 
    var Y,JYM;
    var S,M;
	  var idcard = obj.value.toUpperCase();
	  if(idcard!=obj.value){
	  	obj.value = idcard;	
	  }
	//λ�����
	if(idcard == null || idcard == "" || (idcard.length != 15 && idcard.length != 18)) {
		alert(Errors[0]);
		return false;
	}

    var idcard_array = new Array();
    idcard_array = idcard.split("");

    //��������
    if(area[parseInt(idcard.substr(0,2))] == null) {
		alert(Errors[3]);
		return false;
	}

    //��ݺ���λ������ʽ����
    if(idcard.length == 15) {
		if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
			ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//���Գ������ڵĺϷ���
		} else {
			ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//���Գ������ڵĺϷ���
		}
		if(ereg.test(idcard)){
			return true;
		}else{
			alert("1"+Errors[1]);
			return false;
		}
		return true;
	} else if(idcard.length == 18) {
		//18λ��ݺ�����
		//�������ڵĺϷ��Լ��
		//��������:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
		//ƽ������:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
		if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
			ereg=/^[1-9][0-9]{5}[0-9]{4}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9XxZz]$/;//����������ڵĺϷ���������ʽ
		} else {
			ereg=/^[1-9][0-9]{5}[0-9]{4}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9XxZz]$/;//ƽ��������ڵĺϷ���������ʽ
		}
		if(idcard_array[17]!='Z'&&idcard_array[17]!='z'){
			if(ereg.test(idcard)){//���Գ������ڵĺϷ���
				//����У��λ
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
				M = JYM.substr(Y,1);//�ж�У��λ
				if(M == idcard_array[17].toUpperCase()){
					return true; //���ID��У��λ
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
*��������,oriΪ����ֵ,numΪ������С��λ��
*��:��11.115,��������,������λС��,rounding(11.115,2)
*/
function rounding(ori,num){
	var m = Math.pow(10,num);
	return Math.round(parseFloat(ori*m))/m
}

/**
 * ȫѡ��ȫ��ѡCheckBox
 * strObj������CheckBox������
 * status��״̬��true��false��
 */
function checkAllByName(strObj, status) {
	var boxes = document.getElementsByName(strObj);
	for(var i = 0; i < boxes.length; i++) {
		boxes[i].checked = status;
	}
}

/**
 * ����Ƿ��ǺϷ����û�����ֻ����Ӣ�ģ����֣���-�����͡�.��
 * s���ַ���
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

//�����ַ������ȣ�����Ϊ2������
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

//ȥ���ַ���ǰ��ո�
function strim(tstValue)
{
   return (srtrim(sltrim(tstValue)));
}


//ȥ���ַ���ǰ�ո�
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

//ȥ���ַ��к�ո�
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
 		��/����-->һ������
 		@param: imgBN   -> '���ض�������Ӧ��ͼ���ǰ׺��' 		
 		@param: objBN   -> '���ض����ǰ׺��' 		
 		@param: ctObj   -> '��ǰ�����Name'
 		@param: ctImage -> '��ǰ��������Ӧ��ͼ���Name'
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
* �Ƚ�����
* beginDate:��ʼ����
* beginDateName:��ʼ���ڵ�����:����:���뿪ʼ����
* endDate����������
* endDateName:�������ڵ����ƣ����磺�����������
* return: false:��֤����
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
			var msg = "'" + beginDateName + "'���ܴ���'" + endDateName + "'!";
			alert(msg);
			return false;
		}
	}
	return true;
}