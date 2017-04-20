	
	
	/**	��¼���м��		
	**/
	function doOpenMid(formName){	
		
		var strForm = document[formName];
		var strUrl = "/shjzmid/tologin.jsp";				
		
		strForm.action = strUrl;
		strForm.target = "import_frame";
		strForm.submit();		
		
	}
	
	
	/**�����ͱ���ͥ��ʶ
		@param lowGuaranteeNumber		'�ͱ���'����
		@param obj									'��ʶ'����	
	**/
	function createLowFamilyFlag(lowGuaranteeNumber , obj){
		if(Jtrim(lowGuaranteeNumber.value).length > 0){
  		obj.value = "5659"; 
  	}else{
  		obj.value = "5660"; 
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
              sexId = 5989;   //Ů
          else
              sexId = 5988;   //��        
              
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
   
    
    
    //ˢ�µ�ǰ����
    function load(){
	    window.location.reload(true);	    
	}
	
	//������������
	function CreateWindow(url)
    {
        msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
    }
    //���µ�������
	function CreateBlankWindow(url)
    {
        msgWindow=window.open(url,"_blank","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
    }  
    
   //���µ�������
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars=no,resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
   }    
    //���µ�������
	function CreateBuildBlankWindow(strUrl,ctHeight,ctWidth,ctScrol)
  {
        var strBuild = "toolbar=no,width=" + ctWidth + ",height=" + ctHeight + ",directories=no,status=no,";
            strBuild += "scrollbars="+ ctScrol +",resize=no,menubar=no";
        
        msgWindow=window.open(strUrl,"_blank",strBuild)
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
 		��/����-->����
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
