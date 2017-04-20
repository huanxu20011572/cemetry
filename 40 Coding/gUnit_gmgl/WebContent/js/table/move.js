
/*
+------------------------------------------------------------------------
+  表格拖动控制 
+    add by zonghua,zhang at 20051221
+------------------------------------------------------------------------
*/
var blnAdjust = false
var sWidth1 = 0
var AdjustRow = 0,AdjustCol = 0
var lngFixRows = 1 
var lngFixCols = 1 
var blnFixRowDrap = true 
var mbCell = true;
var blnRunMode = true;
/*
+------------------------------------------------------------------------
+  对数据列表绑定事件
+------------------------------------------------------------------------
*/

function getParentTable(selObj){
  var obj =selObj

  if (typeof(obj)=="undefined") return null ;
  for (;;){
    obj =obj.parentElement ;
    if (obj.name =="listTable") {
      return obj ;
    }
    if (obj.tagName =="BODY") {
      return null ;
    }
  }
 return obj ;
}


function getParentTD(selObj){
  var obj =selObj
  try{
  if (typeof(obj)=="undefined") return null ;
  for (;;){
    obj =obj.parentElement ;
    if (obj.tagName =="TD") {
      return obj ;
    }
    if (obj.tagName =="DIV") {
      return null ;
    }
  }
  }catch(e){
    
  }
 return obj ;
}

function pageInitMouseEvent(){
  var htmlInit = "<TABLE id=\"line\"  bgColor=black  cellPadding=0 cellSpacing=0  style=\"DISPLAY: none; HEIGHT: 28px; LEFT: 27px; POSITION: absolute; TOP: 352px; WIDTH: 1px\" onmousemove=\"line_onmousemove()\"><TR><TD></TD></TR></TABLE> ";
  tableContainer.insertAdjacentHTML("beforeEnd",htmlInit);
   var col = document.createElement("col");
   col.width = lastColWidth;
   listTable.childNodes(0).appendChild(col);
   /*
   for(var i=0;i< listTable.rows.length;i++){
     var tdObj = listTable.rows(i).insertCell();
     tdObj.className = "list_title";
     tdObj.onclick = function mm(){ //event.cancelBubble=true;
	                               }
	 if(i!=0){
       tdObj.innerHTML = i;
	 }
   }
   */
  listTable.document.attachEvent("onmouseup",mainDiv_onmouseup)
  listTable.document.attachEvent("onmousedown",mainDiv_onmousedown)
  listTable.document.attachEvent("onmousemove",mainDiv_onmousemove)
  listTable.document.attachEvent("onmouseover",mainDiv_onmouseover)
   //document.body.attachEvent("onmousedown",initEvent);
}

function mainDiv_onmouseover(){
  event.cancelBubble = true;
  var curObj = listTable.document.elementFromPoint(event.x,event.y);
  if(curObj==null)return;
  if(curObj.tagName!="TD")return;
  if(getParentTable(curObj)==null)return;
  var trObj = curObj.parentElement;
  var curRow = trObj.rowIndex;
  if(curRow!=0){
	var tmpObj = curObj.getElementsByTagName("SELECT");
	if(tmpObj.length==0){
      curObj.title = curObj.innerText;
	}else{
	  var selObj = tmpObj[0];
	  curObj.title = selObj.options[selObj.selectedIndex].text
	}
  }

}

/*
+------------------------------------------------------------------------
+  数据列表鼠标移动事件
+------------------------------------------------------------------------
*/

/*
+------------------------------------------------------------------------
+  调整边距
+------------------------------------------------------------------------
*/
function LeftToCol(lngLeft,obj){
  var lngWidth=0
  for(var i=0;i<obj.childNodes(0).childNodes.length;i++){
    lngWidth=lngWidth+obj.childNodes(0).childNodes(i).style.pixelWidth
	if(lngWidth>=lngLeft){
	  break
	}
  }
  return i
}

function mainDiv_onmousedown(){
 event.cancelBubble = true;
 if (event.button !=1) return
   var curObj=listTable.document.elementFromPoint(event.x,event.y)
   if(curObj==null)return
   var tdObj = getParentTD(curObj)
   if(tdObj==null)return
   var curCol=tdObj.cellIndex
   var trObj=tdObj.parentNode
   var curRow=trObj.rowIndex

	 if(curCol>=listTable.childNodes(0).childNodes.length)
	 curCol=listTable.childNodes(0).childNodes.length-1
	 if (listTable.rows(curRow).style.cursor =="move"){
	   line.style.display ="block"
	   tableContainer.setCapture()
	   sWidth1=event.x +listTable.document.body.scrollLeft 
	   line.style.left =sWidth1
	   line.style.top=parseInt(listTable.offsetTop)+parseInt(tableContainer.offsetTop)
	   line.style.height = tableContainer.offsetHeight
	   blnAdjust=true
	   return
	}else{
	   line.style.display ="none"
	   blnAdjust=false
	}
}
function mainDiv_onmouseup(){
  //destoryEvent();
  event.cancelBubble = true;
  if (line.style.display=="block" ){
    var lngRange=parseInt(line.style.left) - parseInt(sWidth1)
	var afterWidth=listTable.children[0].children[AdjustCol].style.pixelWidth+ lngRange
	if(afterWidth<=0){
	  listTable.children[0].children[AdjustCol].style.width=0 
	}else{
	  listTable.children[0].children[AdjustCol].style.width=afterWidth
    }
	AdjustCol=0	
	sWidth1=0
	listTable.style.cursor="default"
	line.style.display ="none"
	tableContainer.releaseCapture ()
	blnAdjust=false	
    //calLastWidth(listTable)
	return
  }
}

function destoryEvent(){
  tableContainer.document.detachEvent("onmouseup",mainDiv_onmouseup)
  tableContainer.document.detachEvent("onmousedown",mainDiv_onmousedown)
  tableContainer.document.detachEvent("onmousemove",mainDiv_onmousemove)
}
function initEvent(){
  if(event.button!=1) return;
  var objSrc = event.srcElement;
  if(objSrc.tagName!="TD")return;
  tableContainer.document.attachEvent("onmouseup",mainDiv_onmouseup)
  tableContainer.document.attachEvent("onmousedown",mainDiv_onmousedown)
  tableContainer.document.attachEvent("onmousemove",mainDiv_onmousemove)

}
function line_onmousemove() {
	line.style.left =parseInt(line.style.left)+1
}

 /*
+------------------------------------------------------------------------
+  取得控件的绝对位置
+------------------------------------------------------------------------
*/
function getIE(e){ 
  var t=e.offsetTop; 
  var l=e.offsetLeft; 
  var offset = new Array();
  while(e=e.offsetParent){ 
   t+=e.offsetTop; 
   l+=e.offsetLeft; 
  } 
  offset[0]=t;
  offset[1]=l;
  return offset;
} 

