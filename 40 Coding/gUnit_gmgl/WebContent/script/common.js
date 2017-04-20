

//��"###,###.00"��ת���ɡ�######.00��
function strMoneyToString(strMoney){   
        
    var sv=strMoney.split(".");  
    var s = "";
    if(sv[0] != null){
    	s=sv[0].split(",");	
    }else{
    	s=strMoney.split(",");	
    }	
        
    var value="0";
    
    for(var i=0;i<s.length;i++){
        if(Jtrim(value)=="0")
            value=s[i];
        else
            value+=s[i];    
    }  
      
    if(sv[1]!=null)
       value+="."+sv[1];
    
    return value;
    
}

function isusername (s)
{
         var regu = "^([a-zA-Z]+[_0-9a-zA-Z@.-]*)$"
         var re = new RegExp(regu);
         if (s.search(re) != -1) {
               return true;
         } else {
               window.alert ("��ʹ�ù淶�Ļ�Ա����")
               return false;
         }
}

function isID(s)
{
         var regu = "^([a-zA-Z]+[_0-9a-zA-Z@.-]*)$"
         var re = new RegExp(regu);
         if (s.search(re) != -1) {
               return true;
         } else {
               window.alert ("��ʹ�ù淶��ID�ţ�")
               return false;
         }
}

function Jtrim(str)
{

        var i = 0;
        var len = str.length;
        if ( str == "" ) return( str );
        j = len -1;
        flagbegin = true;
        flagend = true;
        while (( flagbegin == true) && (i< len))
        {
           if ( str.charAt(i) == " " )
                {
                  i=i+1;
                  flagbegin=true;
                }
                else
                {
                        flagbegin=false;
                }
        }

        while  ((flagend== true) && (j>=0))
        {
            if (str.charAt(j)==" ")
                {
                        j=j-1;
                        flagend=true;
                }
                else
                {
                        flagend=false;
                }
        }

        if ( i > j ) return ("");

        trimstr = str.substring(i,j+1);
        return trimstr;
}

function isdigstr(obj)
{  
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if (cc <"0" || cc >"9")
		{
			return false;
		}
	}
	return true;
}



function isZip(obj)
{  
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if (cc <"0" || cc >"9")
		{
			return false;
		}
	}
	return true;
}

function isdigit(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if (cc <"0" || cc >"9")
		{
			return false;
		}
	}
	return true;
}


function isphone(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if ((cc <"0" || cc >"9") && cc != "-" && cc!="+" && cc!="(" && cc !=")" && cc !="/")
		{
//			error(obj,"����Ϊ���֣�");
			return false;
		}
	}
	return true;
}

function isreal(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if ((cc <"0" || cc > "9") && cc != ".")
		{
//			error(obj,"����Ϊ��Ч���֣�");
			return false;
		}
	}
	return true;
}


function ismoney(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if ((cc <"0" || cc > "9") && cc != ".")
		{
			return false;
		}
	}
	return true;
}

function isdate(obj)
{
	slen=obj.value.length;
	if (!isdigstr(obj))
	{
		error(obj,"�������󣬲��ܺ��з����ֵ��ַ���");
		return false;
	}
	else if (slen < 8)
	{
		error(obj,"���ڸ�ʽ������ȷ�ĸ�ʽΪ��YYYYMMDD,��:19990102");
		return false;
	}
	cc = obj.value.substr(0,4);
	if (cc < "1800")
	{
		error(obj,"��ݸ�ʽ������ȷ�ĸ�ʽΪ��YYYY,��:1999");
		return false;
	}
	cc = obj.value.substr(4,2);
	if (cc < "01" || cc > "12")
	{
		error(obj,"�·ݸ�ʽ������ȷ�ĸ�ʽΪ��MM,��:01");
		return false;
	}
	cc = obj.value.substr(6,2);
	if (cc < "01" || cc > "31")
	{
		error(obj,"�ո�ʽ������ȷ�ĸ�ʽΪ��DD,��:02");
		return false;
	}
	return true;
}

function isemail(obj)
{
	i=obj.value.indexOf("@");
	j=obj.value.lastIndexOf(".");
	if (! ifhavegb(obj))
		i = -1;
	if (i == -1 || j == -1 || i > j)
	{
		error(obj,"Email��д����");
		return false;
	}
	return true;
}

function havegb(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		cc = escape(cc);
		if (cc.indexOf("%u") >= 0)
		{
			error(obj,"�����Ϊ���֣�");
			return false;
		}
	}
	return true;
}

function ifdigit(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if (cc <"0" || cc >"9")
		{
			return false;
		}
	}
	return true;
}

function ifphone(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if ((cc <"0" || cc >"9") && cc != "-" && cc!="+" && cc!="(" && cc !=")" && cc !="/")
		{
			return false;
		}
	}
	return true;
}

function ifreal(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		if ((cc <"0" || cc > "9") && cc != ".")
		{
			return false;
		}
	}
	return true;
}

function ifdate(obj)
{
	slen=obj.value.length;
	if (!isdigstr(obj))
	{
		return false;
	}
	else if (slen < 8)
	{
		return false;
	}
	cc = obj.value.substr(0,4);
	if (cc < "1800")
	{
		return false;
	}
	cc = obj.value.substr(4,2);
	if (cc < "01" || cc > "12")
	{
		return false;
	}
	cc = obj.value.substr(6,2);
	if (cc < "01" || cc > "31")
	{
		return false;
	}
	return true;
}

function ifemail(obj)
{
	i=obj.value.indexOf("@");
	j=obj.value.lastIndexOf(".");
	if (i == -1 || j == -1 || i > j)
	{
		return false;
	}
	return true;
}

function ifhavegb(obj)
{
	slen=obj.value.length;
	for (i=0; i<slen; i++){
		cc = obj.value.charAt(i);
		cc = escape(cc);
		if (cc.indexOf("%u") >= 0)
		{
			return false;
		}
	}
	return true;
}

function isyear(obj)
{
	slen=obj.value.length;
	if (!isdigstr(obj))
	{
		error(obj,"�������󣬲��ܺ��з����ֵ��ַ���");
		return false;
	}
	if (obj.value < "1800" || slen < 4)
	{
		error(obj,"��ݸ�ʽ������ȷ�ĸ�ʽΪ��YYYY,��:1999");
		return false;
	}
}

function ifyear(obj)
{
	slen=obj.value.length;
	
	if (!isdigstr(obj))
	{
		return false;
	}
	if (obj.value < "1800" || slen < 4)
	{
		return false;
	}
}

function ismonth(obj)
{	
	if (!isdigstr(obj))
	{
		return false;
	}
	if (obj.value < "01" || obj.value > "12")
	{
		error(obj,"�·ݸ�ʽ������ȷ�ĸ�ʽΪ��MM,��:01");
		return false;
	}
}

function ifmonth(obj)
{	
	if (!isdigstr(obj))
	{
		return false;
	}
	if (obj.value < "01" || obj.value > "12")
	{
		return false;
	}
}

function isday(obj)
{
	if (!isdigstr(obj))
	{
		return false;
	}
	if (obj.value < "01" || obj.value > "31")
	{
		error(obj,"�ո�ʽ������ȷ�ĸ�ʽΪ��DD,��:02");
		return false;
	}
	return true;
}

function ifday(obj)
{
		
	if (!isdigstr(obj))
	{
		return false;
	}
	if (obj.value < "01" || obj.value > "31")
	{
		return false;
	}	
	return true;
}

function error(obj,msg)
{
	obj.value="";
	obj.focus();
	alert(msg);
}

function isFloat(str) {
	
	var tn =  str.split(".");	
	if(tn.length != null){
		if(tn.length >2)
		  return false;
	}	
	
	var ch=str.charAt(0);
	if( ch == "." ) return false;
    for (var i=0; i < str.length; i++)
	{	ch=str.charAt(i);
		if ((ch != ".") && (ch != "0") && (ch != "1") && (ch != "2") && (ch != "3") && (ch != "4") && (ch != "5") && (ch != "6") && (ch != "7") && (ch != "8") && (ch != "9"))
			return false;
	}
    return true;
}