// 判断窗口关闭
function window.onbeforeunload() { 
	  var n = window.event.screenX - window.screenLeft;   
      var b = n > document.documentElement.scrollWidth-20;   
      if(b && window.event.clientY < 0 || window.event.altKey) {
	    if(confirm('是否关闭此窗口？')) {
	    	window.opener.location.reload();
	    	window.close();
	    } else {
	    	return '';
	    }
	  } else {
		if(confirm('是否关闭此窗口？')) {
    		window.opener.location.reload();
    	} else {
    		return '';
    	}
	  }
}
