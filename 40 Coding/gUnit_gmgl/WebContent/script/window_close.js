// �жϴ��ڹر�
function window.onbeforeunload() { 
	  var n = window.event.screenX - window.screenLeft;   
      var b = n > document.documentElement.scrollWidth-20;   
      if(b && window.event.clientY < 0 || window.event.altKey) {
	    if(confirm('�Ƿ�رմ˴��ڣ�')) {
	    	window.opener.location.reload();
	    	window.close();
	    } else {
	    	return '';
	    }
	  } else {
		if(confirm('�Ƿ�رմ˴��ڣ�')) {
    		window.opener.location.reload();
    	} else {
    		return '';
    	}
	  }
}
