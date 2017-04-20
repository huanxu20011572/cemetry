
/**
�ⲿ�������˵����
	
	@param :[String]treeRootName 			  //���ڵ�����--->��������
---------------------------------------------------------------------------------------------------------	
	@param :[String]strFormName 				//form����-->��������strFormName
---------------------------------------------------------------------------------------------------------	
	@param :[String]rootObjName 				//���ڵ�ID-->��������
---------------------------------------------------------------------------------------------------------	
	@param :[long]treeType 	  //101��FROM"�����ֵ�"(�ݹ�)����ʾ�¼��ֵ�
	                            102��FROM"�����ֵ�"(���ݹ�)����ʾ�¼��ֵ�
	                            
														  201��FROM"��֯����"(�ݹ�)��
														  202, FROM"��֯����"(���ݹ�)�� 														  
														  203��FROM"��֯����"����ʾ�����Ŀ;
														  204��FROM"��֯����"(�ݹ�)�� ����ʾ��ص���Ŀ��ͬʱ��ʾ�¼���Ա��
														  205��FROM"��֯����"(���ݹ�)������ʾ��ص���Ŀ��ͬʱ��ʾ�¼���Ա��
														  206, FROM"��֯����ID"����ʾ�¼���Ա��
														  207��FROM"��֯����ID"�����ڡ�����������������ʵʩ���������������û���
														  208��FROM"��֯����ID"�����ڡ���Ŀά�������������м������ع�����Ա�û���
														  209��FROM"��֯����ID"�����ڡ������շ�����������
														  210��FROM"��֯����ID"�����ڡ������շ������¼���
														  211��FROM"��֯����ID"�����ڡ������շ������������¼���
														  
															301, FROM"��Ŀ��",ֻ��ʾ��Ŀ����ͨ������ID��
															
															401��FROM"��Ŀ��Դ"������ʾ��Ŀ����ʾ��ǰ��Ŀ�����е���Դ��Ϣ
															
															501, FROM"��ɫ��Ϣ"����ʾ��ǰ�ڵ������еĽ�ɫ
															
															601, FROM"��������"��ֻ��ʾ��һ���������ڡ����롱������������ά������
																														
---------------------------------------------------------------------------------------------------------															
	@param :[long]   chargeType				 //0��ֻ�����ӽڵ㣻1�����нڵ㶼����ѡ��
---------------------------------------------------------------------------------------------------------	
	@param :[String] strObjName      		//�ڵ㷵������-->��������
---------------------------------------------------------------------------------------------------------	
	@param :[String] strObjId   				//�ڵ㷵��ID-->��������		
---------------------------------------------------------------------------------------------------------	
	@param :[String] clearObjStr       //������󷽷���������Ӧ�����������ϴ���	
---------------------------------------------------------------------------------------------------------															
--------------------------------------**************ѡ����***************--------------------------------------															
---------------------------------------------------------------------------------------------------------															

�ڲ����������
  
	String strFormObj 				//forms -->��������
	String strObjNum 					//�ڵ㷵��NUM-->��������
	long 	 resourceDeptId			//��Դ����Id 	
	String treeRoot 					//���ڵ�ID-->��������  													
	
	String resourceName				//��ǰ�ڵ���Դ����[ֻ����Ŀ��Դ����Ч]
	String canUseNum				  //�ɷ�����Ŀ����λ[ֻ����Ŀ��Դ����Ч]
	String projectStatus	    //-1����ʾ������Ŀ��1��ֻ��ʾ��Ч��Ŀ[ֻ����Ŀ��Դ����Ч]
	String projectType	      //-1����ʾ������Ŀ��������Ŀ(0��ֻ��ʾ������Ŀ��1��ֻ��ʾ�Ƿ�����Ŀ;)
															 2����ʾ��������Ϊ->�������3,��ʾ���еġ�������Ŀ���͡��������[ֻ����Ŀ��Դ����Ч]
  String salvageTypeId      //��Ŀ���ࣺҽ�ƾ��������������ȣ���Ϊnull���򲻹��ˣ���ʾ���У�															 
	
	long 	 showType						//0,����ʾ��1����ʾ'checkbox'����;
	String showObj						//����ѡ���Idֵ���ݴ�[ֻ���showType���������Ч]
	String showObjValue       //����ѡ���ֵ���ݴ�[ֻ���showType���������Ч]
	String callObjName 				//1����������
		
	String projectName 			 //����Ԥ����������Ŀ����	
	String resourceNameStr 	 //����Ԥ����������Դ���ƴ�
	String strNum 					 //����Ԥ�������ر��봮
	
	String sysFlag						//���ڴ�ҳ�洫���ϵͳ����
**/


function onSelectTree( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          clearObjStr
          ){		
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

 
	onSelectTreeByObjStr( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, null, returnObjStr,
	          clearObjStr,null
	          )
        	
}

/**������ר���ڡ���ʾ��Ŀ������
**/
function onSelectProjectTree( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          salvageTypeId,
          clearObjStr          
          ){	
          	
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

	onSelectTreeByObjStr( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, salvageTypeId, returnObjStr,
	          clearObjStr,null
	          )
}


/**���������ڷ�db,zx,ls,hz��Ŀ��ʾ��  added by jiangyi
**/
function onSelectProjectTreeByXT( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          salvageTypeIdObj,
          clearObjStr,
          sysflagobj         
          ){	
          	
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

	var sysflag = document.all[sysflagobj].value;
	var salvageTypeId  =document.all[salvageTypeIdObj].value;

	onSelectTreeByObjStr( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, salvageTypeId, returnObjStr,
	          clearObjStr,sysflag
	          )
}

/**���������ڸ�����Ŀ���࣬�������࣬������ʽ��Ŀ��ʾ��  added by jiangyi
**/
function onSelectProjectTreeByJZFS( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          salvageTypeIdObj,
          sendMoney,
          sysflagobj,
          sendType         
          ){	
          	
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

	var sysflag = document.all[sysflagobj].value;
	var salvageTypeId  =document.all[salvageTypeIdObj].value;
	var sendMoney =  document.all[sendMoney].value;
	var sendType =  document.all[sendType].value;
	onSelectTreeByJZFS( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, salvageTypeId, returnObjStr,
	          sendMoney,sysflag,sendType
	          )
}
/**���������ڸ�����Ŀ���࣬�������࣬������ʽ��Ŀ��ʾ��  added by jiangyi
**/
function onSelectTreeByJZFS( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          salvageTypeId,
          returnObjStr,
          sendMoney,
          sysFlag,
          sendType
          ){	
              	
		var strForm = document[strFormName];
		var treeRoot  = strForm[rootObjName].value;
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + strFormName;
		
		if(Jtrim(returnObjStr).length == 0){
			 alert('������ʾ���봫����Ӧ���ض���ֵ');
			 return ;
		}
		
		var spStr = returnObjStr.split(",");
		if(spStr.length == 1){
			strUrl += returnObjStr;
		}else{
			var sp = returnObjStr.split(",");
			for(var k=0; k < sp.length; k++){
				if(sp[3] == 1){
					if(k == 1)
					strUrl += "&showObj=" + sp[k] ;	
				  if(k == 2)			
				   strUrl += "&showObjValue=" + sp[k] ;					   
 					if(k == 3)			
			   		strUrl += "&showType=" + sp[k] ;		
			   					   
				}else{
					if(k == 1)
						strUrl += "&strObjId=" + sp[k] ;	
				  if(k == 2)			
				    strUrl += "&strObjName=" + sp[k] ;				
				}				
			}
		}

		if(Jtrim(treeRoot).length ==0 ){
			alert("��ѡ����Ӧ���ϼ��ڵ�ֵ");
			return ; 
		}
		
		strUrl += "&treeRoot=" + treeRoot +"&treeRootName=" + treeRootName +"&treeType="+ treeType;
		strUrl += "&chargeType=" + chargeType ;
		
	
		if(salvageTypeId != null && Jtrim(salvageTypeId).length  > 0){
			strUrl += "&salvageTypeId=" + salvageTypeId ;
		}
		
		if(sysFlag != null && Jtrim(sysFlag).length  > 0){
			strUrl += "&sysFlag=" + sysFlag ;
		}		
		
		if(sendMoney != null)		
		  strUrl += "&sendMoney=" + sendMoney;
		  
		 if(sendType != null)		
		  strUrl += "&sendType=" + sendType;
		  
    //window.open(strUrl, '','');
		CreateBuildBlankWindow(strUrl,'600','300');		
}

//ͨ����ʾ��Ŀ��
function onSelectTreeByObjStr( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          salvageTypeId,
          returnObjStr,
          clearObjStr,
          sysFlag
          ){	
              	
		var strForm = document[strFormName];
		var treeRoot  = strForm[rootObjName].value;
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + strFormName;
		
		if(Jtrim(returnObjStr).length == 0){
			 alert('������ʾ���봫����Ӧ���ض���ֵ');
			 return ;
		}
		
		var spStr = returnObjStr.split(",");
		if(spStr.length == 1){
			strUrl += returnObjStr;
		}else{
			var sp = returnObjStr.split(",");
			for(var k=0; k < sp.length; k++){
				if(sp[3] == 1){
					if(k == 1)
					strUrl += "&showObj=" + sp[k] ;	
				  if(k == 2)			
				   strUrl += "&showObjValue=" + sp[k] ;					   
 					if(k == 3)			
			   		strUrl += "&showType=" + sp[k] ;		
			   					   
				}else{
					if(k == 1)
						strUrl += "&strObjId=" + sp[k] ;	
				  if(k == 2)			
				    strUrl += "&strObjName=" + sp[k] ;				
				}				
			}
		}

		if(Jtrim(treeRoot).length ==0 ){
			alert("��ѡ����Ӧ���ϼ��ڵ�ֵ");
			return ; 
		}
		
		strUrl += "&treeRoot=" + treeRoot +"&treeRootName=" + treeRootName +"&treeType="+ treeType;
		strUrl += "&chargeType=" + chargeType ;
		
	
		if(salvageTypeId != null && Jtrim(salvageTypeId).length  > 0){
			strUrl += "&salvageTypeId=" + salvageTypeId ;
		}
		
		if(sysFlag != null && Jtrim(sysFlag).length  > 0){
			strUrl += "&sysFlag=" + sysFlag ;
		}		
		
		if(clearObjStr != null)		
		  strUrl += "&clearObjStr=" + clearObjStr;
		  		   		
    //window.open(strUrl, '','');
		CreateBuildBlankWindow(strUrl,'600','300');		
}
	
//ѡ����ʱ�����������Ӧ��ֵ��	
function clearOtherSelect(strFormObj, clearObjStr){
	   var strForm  = document[strFormObj];
	   var objs = clearObjStr.split(",");
	   
	   for(var i =0; i <objs.length; i++)
	     strForm[objs[i]].value='';	   
}





//ѡ����������
function selectCategorys(objForm,categoryIds,categoryName){

		
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + objForm;
		var treeRoot = "2985";
		var treeRootName = "������";		
			
		strUrl += "&treeRoot=" + treeRoot;
		strUrl += "&treeRootName="+treeRootName;
   	strUrl += "&showType=1" ;	
		strUrl += "&treeType=101";
		strUrl += "&chargeType=1" ;
		strUrl += "&showObj=" + categoryIds;	
	  strUrl += "&showObjValue=" + categoryName;		
				  		   		
    CreateBuildBlankWindow(strUrl,'600','300');		
		
}

//ѡ������������ֻ�����ڡ����롱�򡰶���ά�����еĳ�Ա��Ϣ�޸�
function selectCategorysForApply(objForm,categoryIds,categoryName){		
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + objForm;
		var treeRoot = "2985";
		var treeRootName = "������";		
		
			
		strUrl += "&treeRoot=" + treeRoot;
		strUrl += "&treeRootName="+treeRootName;
   	strUrl += "&showType=1" ;	
		strUrl += "&treeType=103";
		strUrl += "&chargeType=1" ;
		strUrl += "&showObj=" + categoryIds;	
	  strUrl += "&showObjValue=" + categoryName;		
	  strUrl += "&selectObjIdValue=" + document[objForm][categoryIds].value;		
				  		   		
    CreateBuildBlankWindow(strUrl,'600','300');		
		
}