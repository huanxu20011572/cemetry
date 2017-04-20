//******************************************
//ajax process function
//******************************************

var ajax=new Object();

ajax.READY_STATE_UNINITIALIZED=0;
ajax.READY_STATE_LOADING=1;
ajax.READY_STATE_LOADED=2;
ajax.READY_STATE_INTERACTIVE=3;
ajax.READY_STATE_COMPLETE=4;

ajax.ContentLoader=function(url,onload,onerror){
 this.url=url;
 this.req=null;
 this.onload=onload;
 this.onerror=(onerror) ? onerror : this.defaultError;
 this.loadXMLDoc(url);
}


ajax.ContentLoader.prototype={
 loadXMLDoc:function(url){
  if (window.XMLHttpRequest){
   this.req=new XMLHttpRequest();
  } else if (window.ActiveXObject){
   this.req=new ActiveXObject("Microsoft.XMLHTTP");
  }
  if (this.req){
   try{
    var loader=this;
    this.req.onreadystatechange=function(){
     loader.onReadyState.call(loader);
    }
    this.req.open('GET',url,true);
    this.req.send(null);
   }catch (err){
    this.onerror.call(this);
   }
  }
 },
 onReadyState:function(){
  var req=this.req;
  var ready=req.readyState;
  if (ready==ajax.READY_STATE_COMPLETE){
   var httpStatus=req.status;
   if (httpStatus==200 || httpStatus==0){
    this.onload.call(this);
   }else{
    this.onerror.call(this);
   }
  }
 },
 defaultError:function(){
  alert("error fetching data!"
  +"\n\nreadyState:"+this.req.readyState
  +"\nstatus: "+this.req.status
  +"\nheaders: "+this.req.getAllResponseHeaders());
 }
}


//*********************************************************************************
//using of ajax
//*********************************************************************************

//var g_SVGDoc;
//var g_fldLoad=0;
//var g_DATAELEMID = "dataFieldDataInfo";
//var g_FIELD="field";

//
//function ReqPageFields(bookId, pageNo) 
//{
// var mode = "formNo";//formNo:request for formNo, data: request for data
// updateCurPageInfo(pageNo);
// var url = contextPath + "/FieldManager.do?bookId=" + bookId + "&pageNo=" + pageNo + "&mode=" + mode;
// new ajax.ContentLoader(url,handleDynamicData);
//}

//handle fetched dynamic data
//function handleDynamicData() 
//{
//    g_SVGDoc = window.parent.frames["mainFrame"].SVGDoc;//SVGDoc defined in main.js
// var xml = this.req.responseXML;
// var fields = xml.getElementsByTagName(g_FIELD).item(0);
// replaceFields(fields);
//}

