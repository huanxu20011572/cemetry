function addCookie(objName,objValue,objHours){//���cookie 
        var str = objName + "=" + escape(objValue); 
        if(objHours > 0){//Ϊ0ʱ���趨����ʱ�䣬������ر�ʱcookie�Զ���ʧ 
            var date = new Date(); 
            var ms = objHours*3600*1000; 
            date.setTime(date.getTime() + ms); 
            str += "; expires=" + date.toGMTString(); 
        } 
        document.cookie = str; 
        //alert("���cookie�ɹ�"); 
    } 

    function getCookie(objName){//��ȡָ�����Ƶ�cookie��ֵ 
        var arrStr = document.cookie.split("; ");    
        for(var i = 0;i < arrStr.length;i ++){    
            var temp = arrStr[i].split("=");      
            if(temp[0] == objName) return unescape(temp[1]); 
        }
        return null;
    } 

    function allCookie(){//��ȡ���б����cookie�ַ��� 
        var str = document.cookie; 
        if(str == ""){ 
            str = "û�б����κ�cookie"; 
        } 
        alert(str); 
    }

    function get_(){ 
        var obj_form = document.all("loginForm");
        var strContainerName = obj_form.UniqueID.value;	 
        var cookie_value = getCookie(strContainerName);   
        return cookie_value; 
    } 
  
    function del_(){ 
        var cookie_name = $("loginForm","userName"); 
        delCookie(cookie_name); 
        alert("ɾ���ɹ�"); 
    } 
  
    function delCookie(name){//Ϊ��ɾ��ָ�����Ƶ�cookie�����Խ������ʱ���趨Ϊһ����ȥ��ʱ�� 
        var date = new Date(); 
        date.setTime(date.getTime() - 1000000000000000000); 
        document.cookie = name + "=a; expires=" + date.toGMTString(); 
    } 