function emulateEventHandlers(eventNames) {
   for (var i = 0; i < eventNames.length; i++) {        
      document.addEventListener(eventNames[i], function (e) {
         window.event = e;
      }, true); // using capture
   }
}

ua = navigator.userAgent;
if ( ua.indexOf("Netscape") > 0 || ua.indexOf("Gecko") > 0 )
{
   emulateEventHandlers(["click", "mousemove", "mouseover"]);
}

function URLEncode( plaintext )
{
  // The Javascript escape and unescape functions do not correspond
  // with what browsers actually do...
  var SAFECHARS = "0123456789" +                                  // Numeric
                                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +  // Alphabetic
                                        "abcdefghijklmnopqrstuvwxyz" +
                                        "-_.!~*'()";                                    // RFC2396 Mark characters
  var HEX = "0123456789ABCDEF";
  var encoded = "";
  for (var i = 0; i < plaintext.length; i++ )
  {
    var ch = plaintext.charAt(i);
    if (ch == " ") {
                    encoded += "+";                             // x-www-urlencoded, rather than %20
    } else if (SAFECHARS.indexOf(ch) != -1) {
                    encoded += ch;
    } else {
                    var charCode = ch.charCodeAt(0);
                        if (charCode > 255) {
                            alert( "Unicode Character '" + ch + "' cannot be encoded using standard URL encoding.\n" +
                                        "(URL encoding only supports 8-bit characters.)\n" +
                                                "A space (+) will be substituted." );
                                encoded += "+";
                        } else {
                                encoded += "%";
                                encoded += HEX.charAt((charCode >> 4) & 0xF);
                                encoded += HEX.charAt(charCode & 0xF);
                        }
    }
  } // for

  return encoded;
};

function URLDecode( encoded )
{
   // Replace %xx with equivalent character
   var plaintext = "";
   var i = 0;
   while (i < (encoded.length-2))
   {
     var ch = encoded.charAt(i);
     if (ch == "+") {
               plaintext += " ";
                   i++;
     }
     else if (ch == "%" && encoded.charAt(i+1) != "%") {
       plaintext += unescape( encoded.substr(i,3) );
       i += 3;
     }
     else if (ch == "&" && encoded.charAt(i+1) == "#" && encoded.charAt(i+2) == "3" && encoded.charAt(i+3) == "4" && encoded.charAt(i+4) == ";")
     {
       plaintext += unescape( "%22" );
       i += 5;
     }
     else if (ch == "&" && encoded.charAt(i+1) == "#" && encoded.charAt(i+2) == "3" && encoded.charAt(i+3) == "9" && encoded.charAt(i+4) == ";")
     {
       plaintext += unescape( "%27" );
       i += 5;
     }
     else if (ch == "&" && encoded.charAt(i+1) == "#" && encoded.charAt(i+2) == "6" && encoded.charAt(i+3) == "0" && encoded.charAt(i+4) == ";")
     {
       plaintext += unescape( "%3C" );
       i += 5;
     }
     else if (ch == "&" && encoded.charAt(i+1) == "#" && encoded.charAt(i+2) == "1" && encoded.charAt(i+3) == "0" && encoded.charAt(i+4) == ";")
     {
       plaintext += unescape( "%0A" );
       i += 5;
     }
     else if (ch == "&" && encoded.charAt(i+1) == "#" && encoded.charAt(i+2) == "1" && encoded.charAt(i+3) == "3" && encoded.charAt(i+4) == ";")
     {
       plaintext += unescape( "%0D" );
       i += 5;
     }
     else {
       plaintext += ch;
       i++;
     }
   } // while
   if (i < encoded.length) {
            plaintext += encoded.substr(i,encoded.length-i);
   }
   return unescape(plaintext);
};

function floor(number)
{
  return Math.floor(number*Math.pow(10,2))/Math.pow(10,2);
} 
    
function markDirty(frm, elm, val)
{
  document.forms[frm].elements[elm].value=val;
}

function MM_goToURL() { //v3.0
    var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
    for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  var popWin = window.open(theURL,winName,features);
  popWin.opener = self;
  popWin.focus();
}

function ozPopupTiny(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=100,top=60,width=400,height=300,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function ozPopup(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=100,top=60,width=700,height=540,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function OZ_openBrWindow(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=100,top=60,width=700,height=540,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function OZ_openBrWin2(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=100,top=60,width=900,height=720,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function OZ_openBrWin2WMenu(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=100,top=60,width=900,height=720,scrollbars=yes,menubar=yes');
  popWin.opener = self;
  popWin.focus();
}

function OZ_openBrWin3(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=10,top=10,width=960,height=700,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function OZ_openBrWin4(theURL,winName) { //v2.0
  var popWin = window.open(theURL,winName,'left=100,top=60,width=880,height=540,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function OZ_openBrWin5(theURL,winName) { // full screen
  var w = window.screen.availWidth;
  var h = window.screen.availHeight;
  var popWin = window.open(theURL,winName,' screenX=0,screenY=0,left=0,top=0,width='+w+',height='+h+',resizable=1,scrollbars=yes');
  popWin.opener = self;
  popWin.focus();
}

function MM_jumpMenu(targ,selObj,restore)
{
    eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
    if (restore) selObj.selectedIndex=0;
}

function MM_jumpMenu2(targ,selObj,restore)
{
  var s = selObj.options[selObj.selectedIndex].value;
  if ( s.substring(0,1) != '_' )
  {
    eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  }
  else
  {
    s = s.substring(1, s.length);
    eval( s );
  }
}

function MM_setSelObj( selObj, tgtVal )
{
  for (i=0; i<selObj.options.length; i++)
  {
    if ( selObj.options[i].value == tgtVal )
      selObj.selectedIndex = i;
  }
}

function handleKeyPressReturnUnfocus( e, obj )
{
  var key=e.keyCode || e.which;
  if (key==13) { obj.blur(); return false; }
}

function openLovPopup(fileName, lovName, formName, elmtName)
{
  var paramVal = document.forms[formName].elements[elmtName].value;
  var param = "?paramValue=" + paramVal;

  var lovWin = window.open( fileName + param, lovName, 'width=720,height=500,scrollbars=yes');
    lovWin.opener = self;
    lovWin.focus();
}

function openLovPopupWParam(fileName, lovName, formName, elmtName)
{
  var paramVal = document.forms[formName].elements[elmtName].value;
  var param = "&paramValue=" + paramVal;

  var lovWin = window.open( fileName + param, lovName, 'width=720,height=500,scrollbars=yes');
    lovWin.opener = self;
    lovWin.focus();
}

var openCalV2FieldID;
var openCalV2FormID;
var _openCalV = 2;
function openCalV2( formname, fieldid )
{
  openCalV2FormID  = formname;
  openCalV2FieldID = fieldid;
  _openCalV = 2;
  opencal2( document.forms[openCalV2FormID].elements[openCalV2FieldID].value );
}
function acceptDateV2(dayStr)
{
  if ( _openCalV == 2 )
    document.forms[openCalV2FormID].elements[openCalV2FieldID].value = dayStr;
  if ( _openCalV == 3 )
    $(openCalV3FieldID).value = dayStr;
}

var openCalV3FieldID;
function openCalV3( fieldid )
{
  openCalV3FieldID = fieldid;
  _openCalV = 3;
  opencal2( $(fieldid).value );
}


function getBrowserSizeX() {
  var myWidth = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    //Non-IE
    myWidth = window.innerWidth;
  }
  else
  {
    if( document.documentElement &&
        ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      //IE 6+ in 'standards compliant mode'
      myWidth = document.documentElement.clientWidth;
    }
    else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        //IE 4 compatible
      myWidth = document.body.clientWidth;
    }
  }
  return myWidth;
}

function getBrowserSizeY() {
  var myHeight = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    //Non-IE
    myHeight = window.innerHeight;
  }
  else
  {
    if( document.documentElement &&
        ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      //IE 6+ in 'standards compliant mode'
      myHeight = document.documentElement.clientHeight;
    } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        //IE 4 compatible
      myHeight = document.body.clientHeight;
    }
  }
  return myHeight;
}

function Toggle(item) {
   //added by janet 2005.11.7 ---begin
   var max=item+"_max";
   var min=item+"_min";
   objMax=document.getElementById(max);
   objMin=document.getElementById(min);
   //added by janet 2005.11.7 ---end
   obj=document.getElementById(item);

   visible=(obj.style.display!="none")  
   if (visible) {
     obj.style.display="none";
     //added by janet 2005.11.7 ---begin
     if ( objMax != null ) objMax.style.display="block";
     if ( objMin != null ) objMin.style.display="none";
     //added by janet 2005.11.7 ---end
   } else {
     obj.style.display="block";
     //added by janet 2005.11.7 ---begin
     if ( objMax != null ) objMax.style.display="none";
     if ( objMin != null ) objMin.style.display="block";
     //added by janet 2005.11.7 ---end
   }
}
function ToggleSet(item,val) {
   obj=document.getElementById(item);
   obj.style.display=val;
}

var IFrameObj; // our IFrame object
var _backgroundURL;
function jsCallToServer(backgroundURL)
{
  if (!document.createElement)
  {
    return true;
  }
  
  var IFrameDoc;
  _backgroundURL =  backgroundURL;
  if (!IFrameObj && document.createElement)
  {
    // create the IFrame and assign a reference to the object to our global variable IFrameObj.
    // this will only happen the first time callToServer() is called
    try
    {
               var tempIFrame=document.createElement('iframe');
               tempIFrame.setAttribute('id','RSIFrame');
               tempIFrame.src='z0.jsp';
               tempIFrame.style.border='0px';
               tempIFrame.style.width='0px';
               tempIFrame.style.height='0px';
               IFrameObj = document.body.appendChild(tempIFrame);
               
               if (document.frames)
               {// this is for IE5 Mac, because it will only allow access to the document object
               // of the IFrame if we access it through the document.frames array
                    IFrameObj = document.frames['RSIFrame'];
               }
    }
    catch(exception)
    {
        // This is for IE5 PC, which doesn't allow dynamic creation/manipulation of iframe object.
               // Instead, we'll fake it up by creating our own objects.
               iframeHTML='\<iframe id="RSIFrame" src="z0.jsp" style="';
               iframeHTML+='border:0px;';
               iframeHTML+='width:0px;';
               iframeHTML+='height:0px;';
               iframeHTML+='"><\/iframe>';
               document.body.innerHTML+=iframeHTML;
               IFrameObj = new Object();
               IFrameObj.document = new Object();
               IFrameObj.document.location = new Object();
               IFrameObj.document.location.iframe = document.getElementById('RSIFrame');
               IFrameObj.document.location.replace = function(location) {this.iframe.src = location;}
    }
  }          


  if (navigator.userAgent.indexOf('Gecko') !=-1 && !IFrameObj.contentDocument)
  {
    // we have to give NS6 a fraction of a second
    // to recognize the new IFrame
    setTimeout('jsCallToServer()',10);
    return false;
  }
 
  if (IFrameObj.contentDocument)
  {     // For NS6
          IFrameDoc = IFrameObj.contentDocument;
  }
  else if (IFrameObj.contentWindow)
  {     // For IE5.5 and IE6
          IFrameDoc = IFrameObj.contentWindow.document;
  }
  else if (IFrameObj.document)
  {     // For IE5
           IFrameDoc = IFrameObj.document;
  }
  else
  {
          return true;
  }
 
  IFrameDoc.location.replace(_backgroundURL);
  return false;
}

function ToggleAndSubmit(item, divid) {
   obj=document.getElementById(item);
   visible=(obj.style.display!="none")  
   if (visible)
   {
     obj.style.display="none";
     backgroundURL = 'ozCmnHideShow.jsp?id='+divid+'&action=none';
   }
   else
   {
     obj.style.display="block";
     backgroundURL = 'ozCmnHideShow.jsp?id='+divid+'&action=block';
   }
   
   jsCallToServer( backgroundURL );
}

function submitQuickAmountNonInventory( oppId )
{
    var oppQuickAmountNonInventory = document.getElementById( 'oppQuickAmountNonInventory' ).value;
    if( oppQuickAmountNonInventory <= 0.0 )
      alert ( 'You have to put in a positive numeric value.' );
    else
      document.location = 'ozSlsOppPln.jsp?id='+oppId+'&ac=submitQuickAmountNonInventory&quickAmountNonInventory='+oppQuickAmountNonInventory;
}

function limit2dec(val)
{
    if (val == 0) return ("0");
    if (val == "") return ("");
    var inputVal = ("" + val);
    if (inputVal.indexOf(".") == -1) inputVal+=".000000";
    else                             inputVal+="000000";
    var decPart = inputVal.substring(0,inputVal.indexOf("."));
    var fracPart = inputVal.substring(inputVal.indexOf(".")+1,inputVal.indexOf(".")+3);
    var dec3Part=parseInt(inputVal.substring(inputVal.indexOf(".")+3,inputVal.indexOf(".")+4));
    if ((dec3Part >= 5))
    {
      if(parseFloat(fracPart)== 99)
      {
        fracPart = "00";
        if(parseFloat(decPart)>=0) decPart  =  ""+ (parseFloat(decPart) + 1);
        else decPart  =  ""+ (parseFloat(decPart) - 1);
      }
      else
      {
        var tmp = parseFloat( fracPart ) + 1;
        if ( tmp < 10 )        fracPart = "0"+tmp;
        else                   fracPart = ""+tmp;
      }
    }
    return ("" + decPart + "." + fracPart);
}

function insertAtCursor(myField, myValue)
{
  //IE support
  if (browser.isIE)
  {
    myField.focus();
    var sel = document.selection.createRange();
    sel.text = myValue;
    var dummy=myField.createTextRange();
    dummy.findText( myValue );
    dummy.select();
  }
  //MOZILLA/NETSCAPE support
  else if ( browser.isNS )
  {
    myField.focus();
    var startPos = myField.selectionStart;
    var oldLength = myField.value.length;
    if ( oldLength > 0 )
      myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring( startPos, oldLength );
    else
      myField.value = myValue;
    myField.setSelectionRange(startPos, startPos + myValue.length );
  }
  else {
    myField.value += myValue;
  }
}

function insertAtCursor2(myField, myValue)
{
  //IE support
  if (browser.isIE)
  {
    myField.focus();
    var sel = document.selection.createRange();
    sel.text = myValue;
  }
  //MOZILLA/NETSCAPE support
  else if ( browser.isNS )
  {
    myField.focus();
    var startPos = myField.selectionStart;
    var oldLength = myField.value.length;
    if ( oldLength > 0 )
      myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring( startPos, oldLength );
    else
      myField.value = myValue;
  }
  else {
    myField.value += myValue;
  }
}

function getAbsElementYById(elmtId)
{
  var element = document.getElementById( elmtId );
  if ( element!=null ) return getAbsElementY( element );
  else                 return 0;
}
function getAbsElementXById(elmtId)
{
  var element = document.getElementById( elmtId );
  if ( element!=null ) return getAbsElementX( element );
  else                 return 0;
}
function getAbsElementY(element){
  var targetTop = 0;
  if (element.offsetParent) {
    while (element.offsetParent) {
      targetTop += element.offsetTop;
      element = element.offsetParent;
    }
  } else if (element.y) {
    targetTop += element.y;
  }
  return targetTop;
}
function getAbsElementX(element){
  var targetLeft = 0;
  if (element.offsetParent) {
    while (element.offsetParent) {
      targetLeft += element.offsetLeft;
      element = element.offsetParent;
    }
  } else if (element.x) {
    targetLeft += element.yx;
  }
  return targetLeft;
}

function getPositionYRelativeToDiv(element){
  var targetTop = 0;
  if (element.offsetParent) {
    while (element.offsetParent)
    {
      elementOffsetParent = element.offsetParent;
      if ( elementOffsetParent.tagName != null && ( elementOffsetParent.tagName == "DIV" || elementOffsetParent.tagName == "div" ) )
      {
        targetTop += element.offsetTop;
        break;
      }
      targetTop += element.offsetTop;
      element = elementOffsetParent;
    }
  } else if (element.y) {
    targetTop += element.y;
  }
  return targetTop;
}

function getPositionXRelativeToDiv(element){
  var targetLeft = 0;
  if (element.offsetParent) {
    while (element.offsetParent)
    {
      elementOffsetParent = element.offsetParent;
      if ( elementOffsetParent.tagName != null && ( elementOffsetParent.tagName == "DIV" || elementOffsetParent.tagName == "div" ) )
      {
        targetLeft += element.offsetLeft;
        break;
      }
      targetLeft += element.offsetLeft;
      element = elementOffsetParent;
    }
  } else if (element.x) {
    targetLeft += element.x;
  }
  return targetLeft;
}


// 10/2006: we do AJAX Queues now.
var __ajaxJobQueue = [];    // MAIN QUEUE: only one per page.
function ajaxJob() {
  this._submitUrl    = "";
  this._callbackFunc = null;
}
function postXmlHttp( submitUrl, callbackFunc )
{
  var newJob = new ajaxJob();
  newJob._submitUrl    = submitUrl;
  newJob._callbackFunc = callbackFunc;
  __ajaxJobQueue.push( newJob );
  
  postXmlHttpRun();
}

var _postXmlHttpProcessPostChangeCallBack;
var _xmlHttpRequestObj;
var __ajaxJobQueueRunning = 0;
function postXmlHttpRun()
{
  if ( __ajaxJobQueueRunning == 1 )
    return;

  if ( __ajaxJobQueue.length == 0 ) 
    return;

  __ajaxJobQueueRunning = 1;
  var ajaxJob = __ajaxJobQueue.shift();  // get the first job in the queue
  submitUrl    = ajaxJob._submitUrl;
  callbackFunc = ajaxJob._callbackFunc;

  _postXmlHttpProcessPostChangeCallBack = callbackFunc;
  if(window.createRequest)
  {
    try{
      _xmlHttpRequestObj=window.createRequest();
      _xmlHttpRequestObj.open('POST',submitUrl,true);
      _xmlHttpRequestObj.onreadystatechange=postXmlHttpProcessPostChange;
      _xmlHttpRequestObj.send();
    }
    catch(ee){}
  }
  else if(window.XMLHttpRequest)
  {
    _xmlHttpRequestObj=new XMLHttpRequest();
//    _xmlHttpRequestObj.overrideMimeType('text/xml');
    _xmlHttpRequestObj.open('POST',submitUrl,true);
    _xmlHttpRequestObj.onreadystatechange=postXmlHttpProcessPostChange;
    _xmlHttpRequestObj.send("");
  }
  else if(window.ActiveXObject)
  {
    _xmlHttpRequestObj=new ActiveXObject("Microsoft.XMLHTTP");
    _xmlHttpRequestObj.open('POST',submitUrl,true);
    _xmlHttpRequestObj.onreadystatechange=postXmlHttpProcessPostChange;
    _xmlHttpRequestObj.send();
  }
};

function postXmlHttpProcessPostChange( )
{
  if( _xmlHttpRequestObj.readyState==4 && _xmlHttpRequestObj.status==200 )
  {
    setTimeout( _postXmlHttpProcessPostChangeCallBack, 20 );
    __ajaxJobQueueRunning = 0;
    setTimeout( postXmlHttpRun, 100 );
  }
}

function ebjs_debug( txt )
{
  document.getElementById( 'jsdebugpanel' ).innerHTML = document.getElementById( 'jsdebugpanel' ).innerHTML + ' ' + txt;
}

function ajax_getFormValues(fobj,valFunc)  // valFunc should pass in 'validate'
{
  var str = "";
  var valueArr = null;
  var val = "";
  var cmd = "";

  for(var i = 0;i < fobj.elements.length;i++)
  {
    switch(fobj.elements[i].type)
    {
      case "text":
        if(valFunc)
        {
          //use single quotes for argument so that the value of
          //fobj.elements[i].value is treated as a string not a literal
          cmd = valFunc + "(" + 'fobj.elements[i].value' + ")";
          val = eval(cmd)
        }

        str += fobj.elements[i].name + "=" + escape(fobj.elements[i].value) + "&";
        break;

      case "select-one":
        str += fobj.elements[i].name + "=" + fobj.elements[i].options[fobj.elements[i].selectedIndex].value + "&";
        break;
      
      default:
        str += fobj.elements[i].name + "=" + escape(fobj.elements[i].value) + "&";
        break;
    }
  }
  str = str.substr(0,(str.length - 1));
  return str;
}

function sidebar_postit_addnote( submitUrl, formName )
{
  submitUrl = submitUrl + '&note=' + escape( document.forms[formName].elements['sidebar_postit_content'].value );
  postXmlHttp( submitUrl, 'refreshSidebarPostit()' );
  document.forms[formName].elements['sidebar_postit_content'].value = '';
}
function sidebar_compass_prev( submitUrl )
{
  submitUrl = submitUrl + '&nav=PREV&day=' + escape( document.forms['sidebar_fc_compass_form'].elements['daykey'].value );
  postXmlHttp( submitUrl, 'refreshCompassContent()' );
}
function sidebar_compass_next( submitUrl )
{
  submitUrl = submitUrl + '&nav=NEXT&day=' + escape( document.forms['sidebar_fc_compass_form'].elements['daykey'].value );
  postXmlHttp( submitUrl, 'refreshCompassContent()' );
}
function sidebar_compass_reload( submitUrl )
{
  submitUrl = submitUrl + '&nav=RELOAD&day=' + escape( document.forms['sidebar_fc_compass_form'].elements['daykey'].value );
  postXmlHttp( submitUrl, 'refreshCompassContent()' );
}
function sidebar_goal_reload( submitUrl )
{
  submitUrl = submitUrl + '&nav=RELOAD';
  postXmlHttp( submitUrl, 'refreshGoalContent()' );
}
function fc_compass_dragdrop( submitUrl )
{
  postXmlHttp( submitUrl, 'ozReload()' );
}
function hotlist_add_entry( submitUrl )
{
  postXmlHttp( submitUrl, 'refreshHotList()' );
}
function salesteam_user_add( submitUrl, userIds )
{
  postXmlHttp( submitUrl+'&uids='+userIds, 'refreshSalesTeam()' );
}
function salesteam_group_add( submitUrl, ugid )
{
  postXmlHttp( submitUrl+'&ugid='+ugid, 'refreshSalesTeam()' );
}
function fc_new_appointment( submitUrl, daystr, apptName, timeSlotId )
{
  fcCalRefreshInProgress = 1;
  postXmlHttp( submitUrl+'&daystr='+daystr+'&tsid='+timeSlotId+'&apptname='+escape(apptName), 'refreshFcApptList()' );
}

function ppolRefreshDailyNotes()
{
  var refreshDiv = document.getElementById('fcDailyNotes');
  if ( refreshDiv != null && _xmlHttpRequestObj.responseText.length>100 )
    refreshDiv.innerHTML = _xmlHttpRequestObj.responseText; 
  fcCalRefreshInProgress = 0;
}

function refreshHotList()
{
  var hotlist_content = document.getElementById('sidebar_hotlist_content');
  if ( hotlist_content != null )
    hotlist_content.innerHTML = _xmlHttpRequestObj.responseText; 
  hotlist_content = document.getElementById('topbar_hotlist_content');
  if ( hotlist_content != null )
    hotlist_content.innerHTML = _xmlHttpRequestObj.responseText; 
}

function refreshSidebarPostit()
{
  var postit_content = document.getElementById('sidebar_postit_today_content');
  if ( postit_content != null )
    postit_content.innerHTML = _xmlHttpRequestObj.responseText; 
  postit_content = document.getElementById('topbar_postit_today_content');
  if ( postit_content != null )
    postit_content.innerHTML = _xmlHttpRequestObj.responseText; 
}

function refreshSalesTeam()
{
  var sales_team_content = document.getElementById('sales_team_content');
  if ( sales_team_content != null )
    sales_team_content.innerHTML = _xmlHttpRequestObj.responseText; 
}


function refreshFcApptList()
{
  var refreshDiv = document.getElementById('fcApptDaily');
  if ( refreshDiv != null && _xmlHttpRequestObj.responseText.length>100 )
    refreshDiv.innerHTML = _xmlHttpRequestObj.responseText; 
  adjustApptsPositions();
  fcCalRefreshInProgress = 0;
}

function toggleCfMvFrame( cfMvFrameId, inputObjId )
{
  var cfMvFrame = document.getElementById(cfMvFrameId);
  var inputObj  = document.getElementById(inputObjId);
  if ( cfMvFrame.style.visibility == 'visible' ) hideCfMvFrame( cfMvFrame, inputObj, cfMvFrameId );
  else                                           showCfMvFrame( cfMvFrame, inputObj );
}
function hideCfMvFrame( cfMvFrame, inputObj, cfMvFrameId )
{
  closeFrameById( cfMvFrameId );

  var elList =  document.getElementsByTagName("INPUT");
  var newValue='';
  for (var i = 0; i < elList.length; i++)
  {
    if ( elList[i].name.substr(0,12+cfMvFrameId.length)== 'cfmvoption_'+cfMvFrameId+'_' 
          && elList[i].checked
        )
      newValue += '['+elList[i].name.substr(12+cfMvFrameId.length)+'],';
  }

  if ( newValue.length>2 ) newValue = newValue.substr( 0, newValue.length-1 );
  inputObj.value = newValue;
}

function toggleUserMvFrame( cfMvFrameId1, cfMvFrameId2, inputObjId, hiddenUserIds )
{
  var cfMvFrame1 = document.getElementById(cfMvFrameId1);
  var cfMvFrame2 = null;
  if ( cfMvFrameId2 != null )
    cfMvFrame2 = document.getElementById(cfMvFrameId2);
  var inputObj  = document.getElementById(inputObjId);
  var hiddenUidObj  = document.getElementById(hiddenUserIds);

  if ( cfMvFrame1.style.visibility == 'visible' )
  {
    closeUserMvFrame( cfMvFrameId1, inputObj, hiddenUidObj );
  }
  else
  {
    if ( cfMvFrame2 != null )
    {
      closeFrameById( cfMvFrameId2 );
    }
    showCfMvFrameScroll( cfMvFrame1, inputObj, 0 );  // 0 =adjustWidth
  }
}
function closeUserMvFrame( cfMvFrameId, inputObj, hiddenUidObj )
{
  closeFrameById( cfMvFrameId );

  var elList =  document.getElementsByTagName("INPUT");
  var newValue='';
  var newIds='';
  for (var i = 0; i < elList.length; i++)
  {
    if ( elList[i].name.substr(0,10+cfMvFrameId.length)== 'mvoption_'+cfMvFrameId+'_' 
          && elList[i].checked
        )
    {
      newValue += '['+elList[i].name.substr(10+cfMvFrameId.length)+'],';
      newIds   += document.getElementById( 'mvuserid_'+cfMvFrameId+'_'+elList[i].name.substr(10+cfMvFrameId.length) ).value + ',';
    }
  }
  if ( newValue.length>2 ) newValue = newValue.substr( 0, newValue.length-1 );
  inputObj.value = newValue;
  hiddenUidObj.value = newIds;
}
function submitUserMvFrame( cfMvFrameId1, cfMvFrameId2, inputObjId, hiddenUserIds )
{
  var cfMvFrame1 = document.getElementById(cfMvFrameId1);
  var cfMvFrame2 = document.getElementById(cfMvFrameId2);
  var inputObj  = document.getElementById(inputObjId);
  var hiddenUidObj  = document.getElementById(hiddenUserIds);

  if ( cfMvFrame1 != null && cfMvFrame1.style.visibility == 'visible' )
  {
    closeUserMvFrame( cfMvFrameId1, inputObj, hiddenUidObj );
  }
  if ( cfMvFrame2 != null && cfMvFrame2.style.visibility == 'visible' )
  {
    closeUserMvFrame( cfMvFrameId2, inputObj, hiddenUidObj );
  }
}

function toggleFtWhFrame( cfMvFrameId, inputObjId )  // FtWh = FreeTextWithHint
{
  var cfMvFrame = document.getElementById(cfMvFrameId);
  var inputObj  = document.getElementById(inputObjId);
  if ( cfMvFrame.style.visibility == 'visible' ) closeFrameById( cfMvFrameId );
  else                                           showCfMvFrame( cfMvFrame, inputObj );
}
function closeFrameById( cfMvFrameId )  // FtWh = FreeTextWithHint
{
  var cfMvFrame = $(cfMvFrameId);
  cfMvFrame.style.visibility = 'hidden'; 
  cfMvFrame.style.display = 'none';
  adjustiFrame( cfMvFrame );
}
function selectFtWhFrame( cfMvFrameId, inputObjId, newValue )  // FtWh = FreeTextWithHint
{
  $( inputObjId ).value = newValue;
  closeFrameById( cfMvFrameId );
}
function toggleCfCcFrame( cfMvFrameId, displayObjId )  // CfCc = CustomFieldColorCode
{
  if ( $(cfMvFrameId).style.visibility == 'visible' ) closeFrameById( cfMvFrameId );
  else                                                showCfMvFrame( $(cfMvFrameId), $(displayObjId) );
}
function selectCfCcFrame( cfMvFrameId, displayObjId, valueObjId, newValue )  // CfCc = CustomFieldColorCode
{
  $( displayObjId ).innerHTML = newValue;
  $( valueObjId ).value = newValue;

  closeFrameById( cfMvFrameId );
}
function togglePhoneFrame( cfMvFrameId, inputObjId, formName )
{
  var cfMvFrame = document.getElementById(cfMvFrameId);
  var inputObj  = document.getElementById(inputObjId);
  if ( cfMvFrame.style.visibility == 'visible' ) hidePhoneFrame( cfMvFrameId, inputObjId, formName );
  else                                           showCfMvFrameScroll( cfMvFrame, inputObj, 100 );
}
function hidePhoneFrame( cfMvFrameId, inputObjId, formName )
{
  closeFrameById( cfMvFrameId );

  var elList =  document.getElementsByTagName("INPUT");
  var rowNum = '0';
  for (var i = 0; i < elList.length; i++)
  {
    if ( elList[i].name == 'ahsPhbk_'+inputObjId+'_IDENTIFYING_ROW' )
      rowNum = elList[i].value;
  }

  var nb  = document.forms[formName].elements['ahsPhbk_'+inputObjId+'_'+rowNum+'_NB'].value;
  var ex  = document.forms[formName].elements['ahsPhbk_'+inputObjId+'_'+rowNum+'_EX'].value;
  var formatPhone = "";
  formatPhone = formatPhone + nb;
  if ( ex != '' ) formatPhone = formatPhone + ' x' + ex;
  $(inputObjId).value=formatPhone;
}

function toggleEmailFrame( cfMvFrameId, inputObjId, formName )
{
  var cfMvFrame = document.getElementById(cfMvFrameId);
  var inputObj  = document.getElementById(inputObjId);
  if ( cfMvFrame.style.visibility == 'visible' ) hideEmailFrame( cfMvFrameId, inputObjId, formName );
  else                                           showCfMvFrameScroll( cfMvFrame, inputObj, 100 );
}
function hideEmailFrame( cfMvFrameId, inputObjId, formName )
{
  closeFrameById( cfMvFrameId );

  var elList =  document.getElementsByTagName("INPUT");
  var rowNum = '0';
  for (var i = 0; i < elList.length; i++)
  {
    if ( elList[i].name == 'ahsEmbk_'+inputObjId+'_IDENTIFYING_ROW' )
      rowNum = elList[i].value;
  }

  $(inputObjId).value=document.forms[formName].elements['ahsEmbk_'+inputObjId+'_'+rowNum+'_EMAIL'].value;
}

function showCfMvFrame( cfMvFrame, inputObj )
{
  var maxHeight = 200;
  if (cfMvFrame.offsetHeight < maxHeight)
  {
    cfMvFrame.style.overflow = 'hidden';
  }
  else if (browser.isNS)
  {
    cfMvFrame.style.maxHeight = '200px';
    cfMvFrame.style.overflow = '-moz-scrollbars-vertical';
  }
  else
  {
    cfMvFrame.style.height = '200px';
    cfMvFrame.style.overflowY = 'auto';
  }

  cfMvFrame.scrollTop = 0;

  if ( browser.isIE )
  {
    var divParent = getDivContainer( cfMvFrame );
    if ( divParent != null && ( divParent.style.overflow == 'auto' || divParent.style.overflow == 'scroll' ) )
    {
      cfMvFrame.style.top   = (getAbsElementY(inputObj)+inputObj.offsetHeight-getAbsElementY(divParent)) + "px";
      cfMvFrame.style.left  = (getAbsElementX(inputObj)                      -getAbsElementX(divParent)) + "px";
    }
    else
    {
      cfMvFrame.style.top   = (getAbsElementY(inputObj)+inputObj.offsetHeight) + "px";
      cfMvFrame.style.left  = (getAbsElementX(inputObj)                      ) + "px";
    }
  }
  else
  {
    try {
      var inputObjId = inputObj.getAttribute('id');
      if ( inputObjId.substring(0,4) == 'ajax' )
      {
        var divParent = getDivContainer( cfMvFrame );
        cfMvFrame.style.top   = (getAbsElementY(inputObj)+inputObj.offsetHeight-getAbsElementY(divParent)) + "px";
        cfMvFrame.style.left  = (getAbsElementX(inputObj)                      -getAbsElementX(divParent)) + "px";
      }
      else
      {
        cfMvFrame.style.top   = (getAbsElementY(inputObj)+inputObj.offsetHeight) + "px";
        cfMvFrame.style.left  = (getAbsElementX(inputObj)                      ) + "px";
      }
    }
    catch (Exception)
    {
      cfMvFrame.style.top   = (getAbsElementY(inputObj)+inputObj.offsetHeight) + "px";
      cfMvFrame.style.left  = (getAbsElementX(inputObj)                      ) + "px";
    };
  }

  if ( inputObj.offsetWidth < 80 ) cfMvFrame.style.width = "100px";
  else                             cfMvFrame.style.width = (inputObj.offsetWidth+17) + "px";

  cfMvFrame.style.visibility = 'visible';
  cfMvFrame.style.display = 'block';
  adjustiFrame( cfMvFrame );
}

function showCfMvFrameScroll( cfMvFrame, inputObj, adjustWidth )
{
  var maxHeight = 200;
  cfMvFrame.scrollTop = 0;

  // Start playing
  cfMvFrame.style.top   = (getAbsElementY(inputObj)+inputObj.offsetHeight+1) + "px";
  cfMvFrame.style.left  = getAbsElementX(inputObj) + "px";
  cfMvFrame.style.width = (inputObj.offsetWidth+67+adjustWidth) + "px";

  cfMvFrame.style.visibility = 'visible';
  cfMvFrame.style.display = 'block';
  adjustiFrame( cfMvFrame );
}


                
var tipwidth='240px'; //default tooltip width
var tipbgcolor='#DDEEFF';  //tooltip bgcolor
var disappeardelay=250;  //tooltip disappear speed onMouseout (in miliseconds)
var vertical_offset="0px"; //horizontal offset of tooltip from anchor link
var horizontal_offset="-3px"; //horizontal offset of tooltip from anchor link

/////No further editting needed

var ie4=document.all;
var ns6=document.getElementById&&!document.all;

function getposOffset(what, offsettype)
{
  var totaloffset=(offsettype=="left")? what.offsetLeft : what.offsetTop;
  var parentEl=what.offsetParent;
  while (parentEl!=null){
    totaloffset=(offsettype=="left")? totaloffset+parentEl.offsetLeft : totaloffset+parentEl.offsetTop;
    parentEl=parentEl.offsetParent;
  }
  return totaloffset;
}


  function showhide(obj, e, visible, hidden, tipwidth)
  {
    if (ie4||ns6)
      dropmenuobj.style.left=dropmenuobj.style.top=-500
    if (tipwidth!=""){
      dropmenuobj.widthobj=dropmenuobj.style
      dropmenuobj.widthobj.width=tipwidth
    }
    if (e.type=="click" && obj.visibility==hidden || e.type=="mouseover")
      obj.visibility=visible
    else if (e.type=="click")
      obj.visibility=hidden
  }

  function iecompattest(){
    return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
  }

  function clearbrowseredge(obj, whichedge){
    var edgeoffset=(whichedge=="rightedge")? parseInt(horizontal_offset)*-1 : parseInt(vertical_offset)*-1
    if (whichedge=="rightedge"){
      var windowedge=ie4 && !window.opera? iecompattest().scrollLeft+iecompattest().clientWidth-15 : window.pageXOffset+window.innerWidth-15
      dropmenuobj.contentmeasure=dropmenuobj.offsetWidth
      if (windowedge-dropmenuobj.x < dropmenuobj.contentmeasure)
        edgeoffset=dropmenuobj.contentmeasure-obj.offsetWidth
    }
    else{
      var windowedge=ie4 && !window.opera? iecompattest().scrollTop+iecompattest().clientHeight-15 : window.pageYOffset+window.innerHeight-18
      dropmenuobj.contentmeasure=dropmenuobj.offsetHeight
      if (windowedge-dropmenuobj.y < dropmenuobj.contentmeasure)
        edgeoffset=dropmenuobj.contentmeasure+obj.offsetHeight
    }
    return edgeoffset
  }

  function fixedtooltip(menucontents, obj, e, tipwidth){
    if (window.event) event.cancelBubble=true
    else if (e.stopPropagation) e.stopPropagation()
      clearhidetip()
    dropmenuobj=document.getElementById? document.getElementById("fixedtipdiv") : fixedtipdiv
    dropmenuobj.innerHTML=unescape(menucontents);

    if (ie4||ns6){
      showhide(dropmenuobj.style, e, "visible", "hidden", tipwidth)
      dropmenuobj.x=getposOffset(obj, "left")
      dropmenuobj.y=getposOffset(obj, "top")
      dropmenuobj.style.left=dropmenuobj.x-clearbrowseredge(obj, "rightedge")+"px"
      dropmenuobj.style.top=dropmenuobj.y-clearbrowseredge(obj, "bottomedge")+obj.offsetHeight+"px"
    }
  }
  function fixedtooltipAdjust(menucontents, obj, e, tipwidth){
    if (window.event) event.cancelBubble=true
    else if (e.stopPropagation) e.stopPropagation()
      clearhidetip()
    dropmenuobj=document.getElementById? document.getElementById("fixedtipdiv") : fixedtipdiv
    dropmenuobj.innerHTML=unescape(menucontents);

    if (ie4||ns6){
      showhide(dropmenuobj.style, e, "visible", "hidden", tipwidth)
      dropmenuobj.x=getposOffset(obj, "left")
      dropmenuobj.y=getposOffset(obj, "top")

      // 06/22/2006
      {
        var objparent = getDivContainer( obj );
        if ( objparent != null )
        {
          dropmenuobj.x = dropmenuobj.x - objparent.scrollLeft;
          dropmenuobj.y = dropmenuobj.y - objparent.scrollTop;
        }
      }

      dropmenuobj.style.left=dropmenuobj.x-clearbrowseredge(obj, "rightedge")+"px"
      dropmenuobj.style.top=dropmenuobj.y-clearbrowseredge(obj, "bottomedge")+obj.offsetHeight+"px"
    }
  }

  function hidetip(e){
    if (typeof dropmenuobj!="undefined"){
      if (ie4||ns6)
        dropmenuobj.style.visibility="hidden"
    }
  }

  function delayhidetip(){
    if (ie4||ns6)
      delayhide=setTimeout("hidetip()",disappeardelay)
  }

  function longdelayhidetip(){
    if (ie4||ns6)
      delayhide=setTimeout("hidetip()",2000)
  }

  function clearhidetip(){
    if (typeof delayhide!="undefined")
    clearTimeout(delayhide)
  }

  function overlay(curobj, subobj)
  {
    if (document.getElementById)
    {
      var subobj=document.getElementById(subobj)
      subobj.style.left=getposOffset(curobj, "left")+"px";
      subobj.style.top=(getposOffset(curobj, "top")+16)+"px";
      var visible=(subobj.style.display!="none");
      if (visible) subobj.style.display="none";
      else         subobj.style.display="block";
      return false;
    }
    else
      return true;
  }

  function overlayAdjust(curobj, subobj)
  {
    if (document.getElementById)
    {
      var subobj=document.getElementById(subobj)
      subobj.style.left=getAbsElementX(curobj)+"px";
      subobj.style.top=(getAbsElementY(curobj)+16)+"px";
      var visible=(subobj.style.display!="none");
      if (visible) subobj.style.display="none";
      else         subobj.style.display="block";
      return false;
    }
    else
      return true;
  }

  function overlayclose(subobj){
    var o = document.getElementById(subobj);
    if ( o!=null )
      o.style.display="none"
  }


//added by janet 2005.12.9--begin
function jumpChart(submitUrl,portId,obj)
{ 
  submitUrl = submitUrl+'&param='+obj.options[obj.selectedIndex].value+"&portId="+portId;
  postXmlHttp( submitUrl, 'refreshChart('+portId+')');;
}
function refreshChart(portId)
{
  var div="chart_"+portId;
  var chart = document.getElementById(div);
  if ( chart != null )
     chart.innerHTML = _xmlHttpRequestObj.responseText; 
}
function jumpChart2(submitUrl,portId,param)
{ 
  var all=document.getElementById("portlet_"+portId+"_all");
  var open=document.getElementById("portlet_"+portId+"_open");
  if(param=="ALL"){
    open.removeAttribute("bgColor");
    all.setAttribute("bgColor","#ccccdd");
  }else{
    all.removeAttribute("bgColor");
    open.setAttribute("bgColor","#ccccdd");
  }
  
  submitUrl = submitUrl+'&param='+param+"&portId="+portId
  postXmlHttp( submitUrl, 'refreshChart('+portId+')');;
}
//added by janet 2005.12.9--end



// Mouse Over Script Start
ajax_mouseover_timerid = -1;
ajax_mouseover_objtype = '';
ajax_mouseover_objid   = '';
ajax_mouseover_inprogress = 0;
currMouseX = 0;
currMouseY = 0;
var ajaxCurrMouseX = 0;
var ajaxCurrMouseY = 0;
function ajax_mouseover( ajaxMouseOverObjType, ajaxMouseOverObjId )
{
  if ( ajax_mouseover_snapshot_yesno == 'N' )
    return;

  ajaxCurrMouseX = window.event.clientX+document.body.scrollLeft;
  ajaxCurrMouseY = window.event.clientY+document.body.scrollTop;
  if ( ajax_mouseover_timerid != -1 )
  {
    clearTimeout(ajax_mouseover_timerid);
    ajax_mouseover_timerid = -1;
  }
  
  if ( ajax_mouseover_inprogress == 0 )
  {
    ajax_mouseover_objtype = ajaxMouseOverObjType;
    ajax_mouseover_objid   = ajaxMouseOverObjId;
    ajax_mouseover_timerid = setTimeout( 'ajax_mouseover_action()', 1000 );
  }
}












//if (ie4||ns6)
//  document.write('<div id="fixedtipdiv" style="visibility:hidden;width:'+tipwidth+';background-color:'+tipbgcolor+'" ></div>')

function ajax_mouseout( ajaxMouseOverObjType, ajaxMouseOverObjId )
{
  if ( ajax_mouseover_timerid != -1 )
  {
    clearTimeout(ajax_mouseover_timerid);
    ajax_mouseover_timerid = -1;
  }
  
  if ( ajax_mouseover_snapshot_hide != 'NEVER' )
    setTimeout( 'ajax_mouseover_hidenapshot()', ajax_mouseover_snapshot_hide*1.0 );
}

function ajax_mouseover_action()
{
  ajax_mouseover_inprogress = 1;
  submitUrl = ajax_mouseover_submiturl + '&objtype=' + ajax_mouseover_objtype + '&objid=' + escape(ajax_mouseover_objid) ;
  try {
    if ( ajax_mouseover_email_contactid > 0 )
      submitUrl = submitUrl + '&eml_contactid=' + ajax_mouseover_email_contactid;
  }
  catch ( e ) {};
  postXmlHttp( submitUrl, 'ajax_mouseover_showsnapshot()' );
}

function ajax_mouseover_showsnapshot()
{
  var snapshot_div = document.getElementById('ajax_mouseover_snapshot_div');
  if ( snapshot_div != null )
  {
    snapshot_div.innerHTML = _xmlHttpRequestObj.responseText; 

    snapshot_div.style.position = "absolute";
    snapshot_div.style.width = "360px";
    
    if ( ajaxCurrMouseX + 365 > getBrowserSizeX() )
      snapshot_div.style.left  = ( getBrowserSizeX()-380 ) + "px";
    else
      snapshot_div.style.left  = (ajaxCurrMouseX+5) + "px";

    snapshot_div.style.top   = (ajaxCurrMouseY+1) + "px";
    snapshot_div.style.visibility = 'visible';
    snapshot_div.style.display = "block";
    adjustiFrame( snapshot_div );
    ajax_mouseover_inprogress = 0;
  }
}
function ajax_mouseover_hidenapshot()
{
  if ( ajax_mouseover_inprogress == 1 )
    return;
  var snapshot_div = document.getElementById('ajax_mouseover_snapshot_div');
  if ( snapshot_div != null )
  {
    snapshot_div.style.display = "none";
    snapshot_div.style.visibility = "hidden";
    adjustiFrame( snapshot_div );
    ajax_mouseover_inprogress = 0;
  }
}
// Mouse Over Script End

//this fuctions is added by Janet 2006.2.22

function set_radio_value ( formName, elemName, selectedValue)
{
  var inputs = document.getElementsByTagName ('input');
  if (inputs)
  {
    for (var i = 0; i < inputs.length; ++i)
    {
      if (inputs[i].type == 'radio' && inputs[i].name == elemName && inputs[i].value == selectedValue )
      {
        inputs[i].checked = true;
        break;
      }
    }
  }
}

function set_select_value ( formName, elemName, selectedValue)
{
 var elem= document.forms[formName].elements[elemName].options;
 for ( var i=0; i< elem.length; i++)
 {
   if ( elem[i].value == selectedValue )
   {
     elem[i].selected = true ;
     break;
   }
 }
}

function cf_hour_min_onchange( formName, fieldName )
{
  var s1 = $( formName + '_' + fieldName + '_HH' ).value;
  var s2 = $( formName + '_' + fieldName + '_MM' ).value;
  var s3 = $( formName + '_' + fieldName + '_AP' ).value;
  if ( s1 == 'NA' || s2 == 'NA' || s3 == 'NA' )
    $( formName + '_' + fieldName ).value = '';
  else
    $( formName + '_' + fieldName ).value = s1 + ':' + s2 + ' ' + s3;
}

function search_select_all_all( formName, fieldPrefix )
{
  if ( document.forms[formName].select_all_all_flag.value=='N' )
  {
    document.forms[formName].select_all_all_flag.value = 'Y';
    ToggleSet('select_all_all_msg','block');
    var elList =  document.getElementsByTagName("INPUT");
    for (var i = 0; i < elList.length; i++)
    {
      if ( elList[i].name.substr(0,fieldPrefix.length)==fieldPrefix )
      {
        elList[i].checked = true;
        elList[i].disabled = true;
      }
    }
  }
  else
  {
    document.forms[formName].select_all_all_flag.value = 'N';
    ToggleSet('select_all_all_msg','none');
    var elList =  document.getElementsByTagName("INPUT");
    for (var i = 0; i < elList.length; i++)
    {
      if ( elList[i].name.substr(0,fieldPrefix.length)==fieldPrefix )
      {
        elList[i].checked = false;
        elList[i].disabled = false;
      }
    }
  }
  return false;
}



function LTrim(VALUE)
{
  var v_length = VALUE.length;
  if(v_length < 1)
    return"";

  var strTemp = "";

  var iTemp = 0;
  while(iTemp < v_length)
  {
    //if(VALUE.charAt(iTemp) == w_space || VALUE.charAt(iTemp)==w_enter || VALUE.charAt(iTemp)==w_back || VALUE.charAt(iTemp)==w_newline)
    if(VALUE.charCodeAt(iTemp)==32 || VALUE.charCodeAt(iTemp)==13 || VALUE.charCodeAt(iTemp)==10)
    {
    }
    else
    {
      strTemp = VALUE.substring(iTemp,v_length);
      break;
    }
    iTemp = iTemp + 1;
  } //End While
  return strTemp;
}

function RTrim(VALUE)
{
  var v_length = VALUE.length;
  if(v_length < 1)
    return"";

  var strTemp = "";
  var iTemp = v_length -1;
  while(iTemp > -1)
  {
    //if(VALUE.charAt(iTemp) == w_space || VALUE.charAt(iTemp)==w_enter || VALUE.charAt(iTemp)==w_back || VALUE.charAt(iTemp)==w_newline)
    if(VALUE.charCodeAt(iTemp)==32 || VALUE.charCodeAt(iTemp)==13 || VALUE.charCodeAt(iTemp)==10)
    {
    }
    else
    {
      strTemp = VALUE.substring(0,iTemp +1);
      break;
    }
    iTemp = iTemp-1;
  } //End While
  return strTemp;
} //End Function

function ALLTrim(VALUE)
{
  return RTrim(LTrim(VALUE));
}

/**
  * Function Name: tbl_TRMouseOver
  * Function: It updates the backgroud-color of '<tr>' tag when mouse overing.
  *           So it can be different from others. 
  *
  * @param    id       ID of <tr> tag
  *           oldId    ID of Clicked <tr> tag
  *           colorId  Log the tag bgcolor before update
  *           bgcolor  Backgroud-Color to Set
  *
  * @author   qmLiang
  * @since    2006-8-18 16:08:19
  * @version  1.0
  */
function tbl_TRMouseOver(id,oldId,colorId,bgcolor)
{
  id = ALLTrim(id);
  oldId = ALLTrim(oldId);
  colorId = ALLTrim(colorId);
  bgcolor = ALLTrim(bgcolor);
  //this row has be clicked,then do nothing
  if(oldId != '' && id == document.getElementById(oldId).value)
    return;
  if(bgcolor == '')
    bgcolor = "#FFFFFF";
    
  //log the original bgcolor of this row
  document.getElementById(colorId).value = document.getElementById(id).style.backgroundColor;
  //update the bgcolor of this row
  document.getElementById(id).style.backgroundColor=bgcolor;
}//End Function

/**
  * Function Name: tbl_TRMouseOut
  * Function: It updates the backgroud-color of '<tr>' tag to original when mouse outed.
  *
  * @param    id       ID of <tr> tag
  *           oldId    ID of Clicked <tr> tag
  *           colorId  Original bgcolor of the tag
  *
  * @author   qmLiang
  * @since    2006-8-18 16:09:19
  * @version  1.0
  */
function tbl_TRMouseOut(id,oldId,colorId)
{
  id = ALLTrim(id);
  oldId = ALLTrim(oldId);
  colorId = ALLTrim(colorId);
  //this row has be clicked,then do nothing
  if(oldId != '' && id == document.getElementById(oldId).value)
    return;
    
  var bgcolor = "#FFFFFF";
  //get the original bgcolor of this row
  if(colorId != '' && document.getElementById(colorId).value != '')
    bgcolor = document.getElementById(colorId).value;
  //update the bgcolor of this row to original
  document.getElementById(id).style.backgroundColor=bgcolor;
}//End Function

/**
  * Function Name: tbl_TRClick
  * Function: It updates the backgroud-color of clicked tag last time to original when mouse click.
  *           Then log the tag id replace the old one.
  *
  * @param    id          ID of <tr> tag
  *           oldId       ID of Clicked <tr> tag
  *           oldColorId  Original bgcolor of clicked tag
  *           curColorId  Original bgcolor of clicking tag
  *
  * @author   qmLiang
  * @since    2006-8-18 16:11:19
  * @version  1.0
  */
function tbl_TRClick(id,oldId,oldColorId,curColorId)
{
  id = ALLTrim(id);
  oldId = ALLTrim(oldId);
  oldColorId = ALLTrim(oldColorId);
  curColorId = ALLTrim(curColorId);
  //this row has be clicked,then do nothing
  if(oldId != '' && id == document.getElementById(oldId).value)
    return;
    
  var bgcolor = "#FFFFFF";
  //get the original bgcolor of clicked row
  if(oldColorId != '' && document.getElementById(oldColorId).value != '')
    bgcolor = document.getElementById(oldColorId).value;
  //update the bgcolor of clicked row to original
  if(oldId != '' && document.getElementById(oldId).value != ''){
    var oldTag = document.getElementById(oldId).value;
    document.getElementById(oldTag).style.backgroundColor=bgcolor;
  }
  //log the original bgcolor of clicking row
  document.getElementById(oldColorId).value = document.getElementById(curColorId).value;
  //log the id of clicking row
  document.getElementById(oldId).value = id;
}//End Function

/**
  * Function Name: selectCBAll
  * Function: Select all checkbox.
  *
  * @param    name    Name of Checkbox
  *           allObj  Event Target Object
  *
  * @author   qmLiang
  * @since    2006-8-22 15:10:19
  * @version  1.0
  */
function selectCBAll(name,allObj)
{
  var elList =  document.getElementsByTagName("INPUT");
  for (var i = 0; i < elList.length; i++)
  {
    if (elList[i].name.substr(0,name.length)==name)
      elList[i].checked = allObj.checked;
  }//end for i
}//End Function

function chatOp_MonitorLiveChat()
{
  postXmlHttp( ajax_livechat_monitor_url+'&opMonitorLiveChat=Y', 'chatOp_MonitorLiveChatRefresh()' );
}
function chatOp_MonitorLiveChatRefresh()
{
  var returnHtml = ALLTrim(_xmlHttpRequestObj.responseText);
  if ( returnHtml.length>5 )
  {
    var inQueueDiv = document.getElementById('ajax_popup_notify_div');
    if ( inQueueDiv != null )
    {
      inQueueDiv.innerHTML = _xmlHttpRequestObj.responseText; 
      inQueueDiv.style.width = "600px";
      inQueueDiv.style.height = "40px";
      inQueueDiv.position = "relative";
      inQueueDiv.style.visibility = 'visible';
      inQueueDiv.style.display = "block";
      inQueueDiv.style.top   = "0px";
      inQueueDiv.style.left  = "0px";
      inQueueDiv.style.zIndex = 1000000;
      
      document.all.sound.src = 'alert.wav';
    }
  }
  else
  {
    var inQueueDiv = document.getElementById('ajax_popup_notify_div');
    if ( inQueueDiv != null )
    {
      inQueueDiv.style.display = "none";
    }  
  }
  setTimeout( 'chatOp_MonitorLiveChat()', 4000 );
}
function chatOp_MonitorLiveChatAction( additionalParam )
{
  postXmlHttp( ajax_livechat_monitor_url+'&opMonitorLiveChat=Y&'+additionalParam, 'chatOp_MonitorLiveChatActionRefresh()' );
}
function chatOp_MonitorLiveChatActionRefresh()
{
  var inQueueDiv = document.getElementById('ajax_popup_notify_div');
  if ( inQueueDiv != null )
  {
    inQueueDiv.style.display = "none";
  }  
}

function $() {
  var elements = new Array();

  for (var i = 0; i < arguments.length; i++) {
    var element = arguments[i];
    if (typeof element == 'string')
      element = document.getElementById(element);

    if (arguments.length == 1)
      return element;

    elements.push(element);
  }

  return elements;
}

function doPc( formName )
{
	submitUrl = 'gdzcDoPc.do?action=doPc&id=' + escape( document.forms[formName].elements['id'].value );
  submitUrl = submitUrl + '&result=' + escape( document.forms[formName].elements['result'].value );
  submitUrl = submitUrl + '&remark=' + ( document.forms[formName].elements['remark'].value );
  postXmlHttp( submitUrl, 'refreshpc()' );
}
function refreshpc()
{
	alert('±£´æ³É¹¦');
}
  