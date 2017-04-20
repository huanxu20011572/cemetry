/*
+----------------------------------------------------------
+ ���幫������ 
+   add by zonghua,zhang at 2005-12-06
+----------------------------------------------------------
*/

/*
+----------------------------------------------------------
+ changeTitleBarStyle �����titlebarʱ�ı���ʽ
+----------------------------------------------------------
*/
function changeTitleBarStyle(){
  var clkObj = event.srcElement;
  var trObj  = clkObj.parentElement;
  if(trObj.tagName!="TR")trObj  = trObj.parentElement;
  for(var i=0;i<trObj.cells.length;i++){
    var tdObj = trObj.cells[i]
	if(clkObj==tdObj){
	  tdObj.className = "h_current"
	}else{
	  tdObj.className = "h_uncurrent"
	}
  }
}

/*
+----------------------------------------------------------
+ btnTitleBarClick ��titlelbar�е��ϵͳ����ִ�к���
+  mid  ģ��id
+  tid  ��ǰģ�������  0----list 1-----tree
+----------------------------------------------------------
*/

 function btnTitleBarClick(mid,tid){
  changeTitleBarStyle();
  document.all.registerTR.style.display = "none";
  mainFrame.location=servletPath+"/main/comm_frame.jsp?mId="+mid+"&tId="+tid;
}


var exeFun=null;    //ҳ��رպ���
var exeFun2 = null; //ʱ����ĺ���
var step=10;        //ҳ��ͣ������

/*
+------------------------------------------------------------------------- 
+ ������ʾ�Ի���
+-------------------------------------------------------------------------
*/
var param = "title:no;help:no;unadorned:yes;center:yes;resizable:no;scroll:no;status:no;dialogWidth:350px;dialogHeight:170px";

function openDialog(url){
  var returnval = window.showModalDialog(url,window,param);
}
/*
+-------------------------------------------------------------------------
+  openErrMsgDlg ������Ϣ��ʾ msg ��Ҫ��ʾ����Ϣ
+-------------------------------------------------------------------------
*/
function openErrorDlg(msg){
  var url =servletPath+"/admin/showerror.jsp?msg="+msg;
  var returnval = window.showModalDialog(url,null,param);
}
/*
+-------------------------------------------------------------------------
+  openCnfDlg  ѡ����Ϣ��ʾ msg ��Ҫ��ʾ����Ϣ
+-------------------------------------------------------------------------
*/
function openConfirmDlg(msg){
  var url =servletPath+"/admin/showcnf.jsp?msg="+msg;
  var returnValue = window.showModalDialog(url,window,param);
  return returnValue;
}
/*
+-------------------------------------------------------------------------
+  openOkDlg   �����ɹ���ʾ
+-------------------------------------------------------------------------
*/
function openOkDlg(msg){
  var url =servletPath+"/admin/showok.jsp?msg="+msg;
  var returnValue = window.showModalDialog(url,window,param);
}
/*
+-------------------------------------------------------------------------
+  openOkDlg   �����ɹ���ʾ
+-------------------------------------------------------------------------
*/
function openWarningDlg(msg){
  var url =servletPath+"/admin/showwarring.jsp?msg="+msg;
  var returnValue = window.showModalDialog(url,window,param);
}

/*
+------------------------------------------------------------------------- 
+ ����ˢ�º��� �������õĺ������п����Զ��ر�
+------------------------------------------------------------------------- 
*/
  function changeTime(){
	var tmpHtml = (--step);
    document.getElementById("tiemDiv").innerHTML=tmpHtml;
  }
  function winClose(){
    if(exeFun!=null){
      window.clearInterval(exeFun);
      window.clearInterval(exeFun2);
	}
	self.close();
  }


function testConfirmDialog(){
 if(openCnfDlg("�Ƿ�ִ��ɾ������?")=="true"){
   
 }
}

/*
+------------------------------------------------------------------------- 
+����༭��ťʱ����ʾ�ܱ༭�������
+------------------------------------------------------------------------- 
*/
function btnShowEdit(){
  var checkObjs = document.getElementsByName("deletecontext");
  var mask ="0";
  for(var i=0;i<checkObjs.length;i++){
    var tr = checkObjs[i].parentElement.parentElement;
    if(tr.opertype=='add')continue;
    if(checkObjs[i].checked){
	  for(var j=0;j<tr.cells.length;j++){
		if(tr.cells[j].childNodes[0].tagName=="DIV"){
		   try{
		     var tmpHTML = tr.cells[j].childNodes[0].outerHTML;
		     tr.cells[j].innerHTML = tmpHTML;	  
             tr.cells[j].childNodes[0].style.display = "";
		   }catch(e){
		   }
		}
	  }
	  mask = "1";
	}
  }
  if(mask=="0"){
    openErrorDlg("��ѡ��Ҫ�༭�ļ�¼")
	return false;
  }
}


/*
+------------------------------------------------------------------------- 
+ �����ѯ��ť ��ʾ����ѯ������
+------------------------------------------------------------------------- 
*/

function showSearch(){
  var searchTable = document.getElementById("schTable");
  if(searchTable.style.display=="none"){
    searchTable.style.display = "";
  }else{
    searchTable.style.display = "none";
  }
}
function setTableHidden(obj,flag){
  obj.src = servletPath+"/images/down.gif"; 
  obj.removeAttribute("onclick"); 
  obj.setAttribute("onclick",function(){setTableVisible(obj,flag);});
  if(flag=="search"){
    obj.title = "��ʾ��ѯ"
    showSearch();
  }else{
    obj.title = "��ʾ������Ϣ"
    switchInfo(flag);
  }
 }

function setTableVisible(obj,flag){ 
  obj.src = servletPath+"/images/up.gif"; 
  obj.removeAttribute("onclick");
  obj.setAttribute("onclick",function(){setTableHidden(obj,flag);});
  if(flag=="search"){
    obj.title = "���ز�ѯ"
    showSearch();
  }else{
    obj.title = "����������Ϣ"
    switchInfo(flag);
  }
}
/*
+------------------------------------------------------------------------- 
+ ����������Ϣִ�в���
+------------------------------------------------------------------------- 
*/
function switchInfo(height){
  var mainFrame = parent.mainFrame;
  var masterdiv = document.getElementById("masterdiv");
  if(masterdiv.style.display == ""){
    masterdiv.style.display = "none";
    mainFrame.rows = "20,*";
  }else{
	masterdiv.style.display = "";
	mainFrame.rows = ""+height+",*";
  } 
}

/*
+------------------------------------------------------------------------- 
+ �����ӱ����frame��С��ʱ��ִ�к���
+ ���������е�Div�Ĵ�С
+------------------------------------------------------------------------- 
*/
function frameResize(obj){
   topFrame.document.all.masterdiv.style.height = (obj.height - 50) >=0 ? (obj.height - 50) : 0;
}

/*
+------------------------------------------------------------------------- 
+ ҳ�淭ҳ���� pageJump ҳ���ת btnKeyGo�����ת
+------------------------------------------------------------------------- 
*/
function pageJump(pageNo){
  document.all.currentPage.value = pageNo;
  listForm.submit();
}

function btnKeyGo(obj,count){
  if(event.keyCode == 13){
	var objVal = obj.value;
	if(objVal=="0") objVal="1";
	if(parseInt(objVal)>count) objVal = count;
  	listForm.currentPage.value = objVal;
	listForm.submit();
  }
}
 /*
+------------------------------------------------------------------------- 
+  selectNormal ����ѡ��ͳһ����
+    type ���˵����� ���ݸ�ֻ��ȷ�����������
      "1" Ϊ����ѡ��
	  "2" Ϊ��Ա��ѡ��
+    funcName ѡ���ִ�еĺ���  �û��Զ��庯�� ����
+    condition �������� ��ʽp1#ss&p2#kk.
      �����ڲ�������ʱ'='�Ų���ֱ�Ӵ��� �����'#'�Ŵ���
+    width    ѡ���Ŀ��  �ɲ���
+    height   ѡ���ĸ߶�  �ɲ��� 
+  ���ڵ���ʱ������ �� Ϊ onclick = selectNormal("youfunc('')")
+   ����                  onclick = selectNormal("youfunc('')",,100,100)
+------------------------------------------------------------------------- 
*/
 var retXML;
 function selectNormal(type,funcName,condition,width,height){
   retXML = "";
   winWidth  = 700
   winHeight = 600
   if(typeof(width)!="undefined"&&typeof(height)!="undefined"){
     winWidth  = width
     winHeight = height
   }
   switch(type){
     case "1":
		url = "/AoepmRoot/main/choose_material/choose.jsp?1=1";
	    break;
	 case "2":
		url = "/AoepmRoot/main/choose/choose.jsp?1=1";
	    break;
   }
    if(typeof(condition)!="undefined"&&condition!=""){
       var  re = /#/g;
	   condition = condition.replace(re,"=");
	   url +="&"+condition;
   }
   var setWin="dialogHeight:"+winHeight+"px;dialogWidth:"+winWidth+"px;dialogTop:70px;dialogLeft:200px;status:no"
   retXML=window.showModalDialog(url,window,setWin);
   if(typeof(retXML)!="undefined"&&retXML!=""){
	  eval(funcName);
   }
 }

 /*
+------------------------------------------------------------------------- 
+  parseXML ��������XML�ĺ��� prop ΪҪ��ѯ������ ��Ҫ���ڵ�һ��¼���
+------------------------------------------------------------------------- 
*/

function parseSingleXML(prop){
  try{
    if(typeof(retXML)=="undefined"&&retXML=="")return "";
    var oXML2=new ActiveXObject("Microsoft.XMLDOM")
    oXML2.async = false
    oXML2.loadXML (retXML);
    var root = oXML2.documentElement;
    if(root==null) return "";
    prop = prop.toLowerCase();
    var tmpObjs = root.selectNodes("//data[@"+prop+"]");
    if(tmpObjs!=null&&typeof(tmpObjs)!="undefined"){
	  if(tmpObjs.length>1){
	    openErrorDlg("�������˴���");
	    return "";
	  }else{
	    return tmpObjs[0].getAttribute(prop);
	  }
    }else{
      return "";
    }
  }catch(e){
    openErrorDlg("û��ȡ�����ԡ�"+prop+"����ֵ")
	return "";
  }
}
/*
+------------------------------------------------------------------------- 
+ ���������¼���
+------------------------------------------------------------------------- 
*/
function paserMutiXML(prop){
  try{
    var retVal = "";
    if(typeof(retXML)=="undefined"&&retXML=="")return "";
    var oXML2=new ActiveXObject("Microsoft.XMLDOM")
    oXML2.async = false
    oXML2.loadXML (retXML);
    var root = oXML2.documentElement;
    if(root==null) return "";
    prop = prop.toLowerCase();
    var tmpObjs = root.selectNodes("//data[@"+prop+"]");
    if(tmpObjs!=null&&typeof(tmpObjs)!="undefined"){
      for(var i=0;i<tmpObjs.length;i++){
	    if(i!=(tmpObjs.length-1)){
	      retVal += tmpObjs[i].getAttribute("id")+","
	    }else{
	      retVal += tmpObjs[i].getAttribute("id")
	    }
	  }
	  return retVal;
    }else{
      return "";
    }
  }catch(e){
    openErrorDlg("û��ȡ�����ԡ�"+prop+"����ֵ")
	return "";
  }
}

function getXMLNodes(){
  var retVal = "";
  if(typeof(retXML)=="undefined"&&retXML=="")return "";
  var oXML2=new ActiveXObject("Microsoft.XMLDOM")
  oXML2.async = false
  oXML2.loadXML (retXML);
  var root = oXML2.documentElement;
  if(root==null) return "";
  var tmpObjs = root.selectNodes("//data");
  return tmpObjs;
}
/*
+------------------------------------------------------------------------- 
+------------------------------------------------------------------------- 
*/
function retAutoSave(action,inpname){
  var tmpHTML  = "<form name=\"hiddenFormEdit\" method=\"POST\">"
      tmpHTML += " <input type=\"hidden\" name=\""+inpname+"\">"
      tmpHTML += "</form>" 
  document.body.insertAdjacentHTML("beforeEnd",tmpHTML);
  hiddenFormEdit.action=action;
  var tmpVal = paserMutiXML("id");
  if(tmpVal==""){
    openErrorDlg("��ѡ��Ҫ�����ֵ");
	return;
  }
  hiddenFormEdit.document.all(inpname).value=tmpVal;
  hiddenFormEdit.submit();

}