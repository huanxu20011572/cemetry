window.alert = function(msg){
	window.showModalDialog(getRoot()+'/common/alert.jsp?msg='+msg,'','status:no;scroll:no;help:no;dialogHeight:279px;dialogWidth:396px;unadorned:yes');	
}

window.confirm = function(msg){
	return window.showModalDialog(getRoot()+'/common/confirm.jsp?msg='+msg,'','status:no;scroll:no;help:no;dialogHeight:279px;dialogWidth:396px;unadorned:yes');
}

function getRoot(){
	var root = window.location.pathname;
	if(root.substring(0,1)=='/'){
			root = root.substring(1)
	}
	root = '/'+root.substring(0,root.indexOf('/'));
	return root;
}