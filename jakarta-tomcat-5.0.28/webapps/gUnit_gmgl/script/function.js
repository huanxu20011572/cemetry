/*
function openwin(url) {
window.open (url,"", "height=350, width=800, toolbar=no, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no") 
}

function openwin(url, width, height) {
window.open (url,"", "height=" + height + ", width=" + width +　", toolbar=no, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no") 
}


function submitClick(form){
	if (form == null)
		return;
	event.returnValue = false;
	form.submit();
}

function cancelClick(){
    event.returnValue = false;    
    history.back();
}

function gotoPage(url){
    event.returnValue = false;
    parent.mainFrame.location = url;
}

function f_resize_table(){
    var oTab = document.all("_main_table");
    if (oTab == null)
        return;        
    var oH = oTab.previousSibling;
    var h = 0;        
    while (oH != null){            
        h += oH.clientHeight;            
        oH = oH.previousSibling;
    }        
    var height = document.body.clientHeight - h;
    oTab.height = height;
}

function f_resize_main_span(){
    document.all("_main_Span").style.height = document.body.clientHeight;
    f_resize_table();
}

function f_goto_top_menu(URL){
    if (URL == null || URL == "")
        return;
    try{
        parent.location = URL;
    }
    catch (E){}
}

function f_page_onsubmit(form){
	
    var va;
    var param = form.to_page.value;
    if (param == ""){        
        alert("请输入正确的页数");
        return false;
    }
    var intParam = parseInt(param * 1);
    if (isNaN(intParam)){
        alert("请输入正确的页数");
        form.to_page.focus();
        return false;
    }
    else{
        va = intParam;
    }
    form.goto_page.value = va;
}


function f_goto_page(form, param){
    
    event.returnValue = false;
        
    var va;
    if (param == "first"){
        va = "first";
    }
    else if (param == "prev"){
        va = "prev";
    }
    else if (param == "next"){
        va = "next";
    }
    else if (param == "last"){
        va = "last";
    }
    else{
        
        if (param == ""){
            alert("请输入您要跳转的页数");
            form.to_page.focus();
            return;            
        }
        var intParam = parseInt(param * 1);
        if (isNaN(intParam)){
            alert("请输入正确的页数");
            form.to_page.focus();
            return;
        }
        else{
            va = intParam;
        }
    }
    //alert(va);
    form.goto_page.value = va;
    form.submit();
}

function f_menu_change(oSel, sTarget){
    if (oSel == null)
        return;    
    var URL = oSel.options[oSel.selectedIndex].value;
    if (URL == null || URL == "#")
        return;
    
    try{
        if (sTarget == null || sTarget == ""){
            var pos = URL.indexOf("module=");
            if (pos != -1){
                URL = "module.do?" + URL.substr(pos);
            }
            parent.location = URL;
        }
        else if (sTarget == "top"){            
            parent.parent.location = URL;
        }
    }
    catch (E){}
}



function f_goto_module(URL, sTarget){
    if (URL == null || URL == "#")
        return;
    
    try{
        if (sTarget == null || sTarget == ""){
            var pos = URL.indexOf("module=");
            if (pos != -1){
                URL = "module.do?" + URL.substr(pos);
            }
            parent.location = URL;
        }
        else if (sTarget == "top"){
            parent.parent.location = URL;
        }
        else if (sTarget == "menu"){
            parent.leftFrame.location = URL;
        }
        else if (sTarget == "content"){
            parent.mainFrame.location = URL;
        }
    }
    catch (E){}
}


*/