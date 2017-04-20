/*
+----------------------------------------------------------
+ 定义公共函数 
+   add by zonghua,zhang at 2005-12-06
+----------------------------------------------------------
*/

/*
+----------------------------------------------------------
+ changeTitleBarStyle 当点击titlebar时改变样式
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
+ btnTitleBarClick 在titlelbar中点击系统设置执行函数
+  mid  模块id
+  tid  当前模块的类型  0----list 1-----tree
+----------------------------------------------------------
*/

 function btnTitleBarClick(mid,tid){
  changeTitleBarStyle();
  document.all.registerTR.style.display = "none";
  mainFrame.location=servletPath+"/main/comm_frame.jsp?mId="+mid+"&tId="+tid;
}


var exeFun=null;    //页面关闭函数
var exeFun2 = null; //时间更改函数
var step=10;        //页面停留秒数

/*
+------------------------------------------------------------------------- 
+ 弹出提示对话框
+-------------------------------------------------------------------------
*/
var param = "title:no;help:no;unadorned:yes;center:yes;resizable:no;scroll:no;status:no;dialogWidth:350px;dialogHeight:170px";

function openDialog(url){
  var returnval = window.showModalDialog(url,window,param);
}
/*
+-------------------------------------------------------------------------
+  openErrMsgDlg 错误信息提示 msg 需要提示的信息
+-------------------------------------------------------------------------
*/
function openErrorDlg(msg){
  var url =servletPath+"/admin/showerror.jsp?msg="+msg;
  var returnval = window.showModalDialog(url,null,param);
}
/*
+-------------------------------------------------------------------------
+  openCnfDlg  选择信息提示 msg 需要提示的信息
+-------------------------------------------------------------------------
*/
function openConfirmDlg(msg){
  var url =servletPath+"/admin/showcnf.jsp?msg="+msg;
  var returnValue = window.showModalDialog(url,window,param);
  return returnValue;
}
/*
+-------------------------------------------------------------------------
+  openOkDlg   操作成功显示
+-------------------------------------------------------------------------
*/
function openOkDlg(msg){
  var url =servletPath+"/admin/showok.jsp?msg="+msg;
  var returnValue = window.showModalDialog(url,window,param);
}
/*
+-------------------------------------------------------------------------
+  openOkDlg   操作成功显示
+-------------------------------------------------------------------------
*/
function openWarningDlg(msg){
  var url =servletPath+"/admin/showwarring.jsp?msg="+msg;
  var returnValue = window.showModalDialog(url,window,param);
}

/*
+------------------------------------------------------------------------- 
+ 窗口刷新函数 根据设置的函数进行控制自动关闭
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
 if(openCnfDlg("是否执行删除操作?")=="true"){
   
 }
}

/*
+------------------------------------------------------------------------- 
+点击编辑按钮时候，显示能编辑的输入框
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
    openErrorDlg("请选择要编辑的记录")
	return false;
  }
}


/*
+------------------------------------------------------------------------- 
+ 点击查询按钮 显示出查询条件框
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
    obj.title = "显示查询"
    showSearch();
  }else{
    obj.title = "显示主表信息"
    switchInfo(flag);
  }
 }

function setTableVisible(obj,flag){ 
  obj.src = servletPath+"/images/up.gif"; 
  obj.removeAttribute("onclick");
  obj.setAttribute("onclick",function(){setTableHidden(obj,flag);});
  if(flag=="search"){
    obj.title = "隐藏查询"
    showSearch();
  }else{
    obj.title = "隐藏主表信息"
    switchInfo(flag);
  }
}
/*
+------------------------------------------------------------------------- 
+ 隐藏主表信息执行操作
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
+ 对主从表调整frame大小的时候执行函数
+ 调整主表中的Div的大小
+------------------------------------------------------------------------- 
*/
function frameResize(obj){
   topFrame.document.all.masterdiv.style.height = (obj.height - 50) >=0 ? (obj.height - 50) : 0;
}

/*
+------------------------------------------------------------------------- 
+ 页面翻页处理 pageJump 页面调转 btnKeyGo输入调转
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
+  selectNormal 物资选择统一函数
+    type 传人的类型 根据该只来确定跳向的连接
      "1" 为物资选择
	  "2" 为人员等选择
+    funcName 选择后执行的函数  用户自定义函数 必须
+    condition 传人条件 格式p1#ss&p2#kk.
      由于在参数传递时'='号不能直接传递 因此用'#'号代替
+    width    选择框的宽度  可不传
+    height   选择框的高度  可不传 
+  若在调用时不传入 则 为 onclick = selectNormal("youfunc('')")
+   否则                  onclick = selectNormal("youfunc('')",,100,100)
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
+  parseXML 解析返回XML的函数 prop 为要查询的属性 主要用于单一记录情况
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
	    openErrorDlg("参数传人错误");
	    return "";
	  }else{
	    return tmpObjs[0].getAttribute(prop);
	  }
    }else{
      return "";
    }
  }catch(e){
    openErrorDlg("没有取得属性【"+prop+"】的值")
	return "";
  }
}
/*
+------------------------------------------------------------------------- 
+ 解析多调记录情况
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
    openErrorDlg("没有取得属性【"+prop+"】的值")
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
    openErrorDlg("请选择要保存的值");
	return;
  }
  hiddenFormEdit.document.all(inpname).value=tmpVal;
  hiddenFormEdit.submit();

}