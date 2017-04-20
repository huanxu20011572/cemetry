/*
**************************************************
Title:			BJCA SecX Web Application Interface
Version:		2.1
Author:			HeMeng, hemeng@bjca.org.cn
Date:			2003/12/08
Last Modify:	2003/12/18
Copyright:		BeiJing Certification Authentication
				http://www.bjca.org.cn
**************************************************
*/

/*
**************************************************
Define Global Information
*/

//BJCA SecX support these item types of form /////
function CFormR()
{
	this.ReITag = new Array();
	this.ReIType = new Array();
	this.ReCIType = new Array();

	this.FT1 = "application/x-www-form-urlencoded";
	this.FT2 = "multipart/form-data";

	//SecX Support These Form Tags & Types ///////
	this.ReITag[0] = "INPUT";
	this.ReITag[1] = "TEXTAREA";
	this.ReITag[2] = "SELECT";

	this.ReIType[0] = "text";
	this.ReIType[1] = "password";
	this.ReIType[2] = "hidden";
	this.ReIType[3] = "textarea";
	this.ReIType[4] = "file";
	this.ReIType[5] = "textarea";
	this.ReIType[6] = "select-one";

	this.ReCIType[0] = "checkbox";
	this.ReCIType[1] = "radio";
	this.ReCIType[2] = "select-multiple";
}

//BJCA SecX NamingRule Object ////////////////////
function CNamingRule()
{
	//Need SecX Naming Rule , Set Flag = 1 ///////
	this.Flag = 0;
	this.RuleString = "SecX_";
}

//BJCA SecX EncryptRule Object ///////////////////
function CEncRule()
{
	//Need Encrypt Data , Set Flag = 1 ///////////
	this.Flag = 1;
	//this.ReplaceString = "SecX_NULL";

	this.XMLHeader = "<?xml version=\"1.0\" encoding=\"GB2312\"?>";
	this.XMLDoc = new ActiveXObject("Microsoft.XMLDOM");
	this.XMLDoc.async = false;
	this.XMLDoc.loadXML("<SecXMSG></SecXMSG>");

	//var objPI = this.XMLDoc.createProcessingInstruction("xml", "version=\"1.0\" encoding=\"gb2312\" ");
	//this.XMLDoc.insertBefore(objPI, this.XMLDoc.childNodes(0));

}

//BJCA SecX Server Information Object ///////////
function CSvrInfo()
{
	//Use to Get Info From Server ////////////////
	this.SvrCert = "";
	this.SvrSignData = "";
	this.SvrOriData = "";

	this.UniqueID = "";

}

//BJCA SecX Addition Form Item Object ////////////
function CAdditionHTML()
{
	//Reserved These Content /////////////////////
	this.ItemName = new Array();
	this.ItemName[0] = "SecX_SignData";
	this.ItemName[1] = "SecX_EncData";
	this.ItemName[2] = "SecX_UserCert";

	this.ItemNum = 3;

	//Add a SecX Form ////////////////////////////
	this.HTMLFormString = "<Form ID=\"SecX_Form\" Name=\"SecX_Form\" action=\"\" Method=\"POST\" >";
	this.HTMLFormString += "<input type=\"hidden\" ID=\"SecX_SignData\" name=\"SecX_SignData\" value=\"\">";
	this.HTMLFormString += "<input type=\"hidden\" ID=\"SecX_EncData\" name=\"SecX_EncData\" value=\"\">";
	this.HTMLFormString += "<input type=\"hidden\" ID=\"SecX_UserCert\" name=\"SecX_UserCert\" value=\"\">";
	this.HTMLFormString += "</Form>";

	//Add These Item to Original Form ////////////
	this.HTMLItemString = "<input type=\"hidden\" ID=\"SecX_SignData\" name=\"SecX_SignData\" value=\"\">";
	this.HTMLItemString += "<input type=\"hidden\" ID=\"SecX_NameList\" name=\"SecX_NameList\" value=\"\">";
	this.HTMLItemString += "<input type=\"hidden\" ID=\"SecX_UserCert\" name=\"SecX_UserCert\" value=\"\">";

	this.HTMLOtherString = "";

}

//BJCA SecX Return Code Object ////////////////////
function CRetCode()
{

	//General Error Code /////////////////////////
	this.Success = 0; //操作成功
	this.Fail = -1; //操作失败
	this.ErrForm = -2; //HTML表单错误
	this.ErrPara = -3; //输入参数错误

	//Cert Error Code ////////////////////////////
	this.ErrCert = -11; //证书无效
	this.ErrCertValid = -12; //证书过期
	this.ErrCertPath = -13; //证书路径错误
	this.ErrCertChain = -14; //证书链错误
	this.ErrCertChainPath = -15; //证书链路径错误
	this.ErrCertKeyPWD = -16; //私钥保护口令错误
	this.ErrCertKeyPath = -17; //私钥设备错误
	this.ErrCertParse = -18; //解析证书错误
	this.ErrCertChangePWD = -19; //修改私钥保护口令错误

	//Cert App Error Code ////////////////////////
	this.ErrEnc = -101; //加密错误
	this.ErrDenc = -102; //解密错误
	this.ErrSgn = -103; //签名错误
	this.ErrVeriSgn = -104 //验证签名错误
	this.ErrModifyPWD = -105; //修改私钥保护口令错误
	this.ErrSvrCert = -106; //服务器端证书错误
	this.ErrEncFile = -107; //加密文件错误
	this.ErrDencFile = -108; //解密文件错误

	//Other Error Code ///////////////////////////
	this.ErrUnknown = -999; //异常错误

	//ActiveX Control Error Code /////////////////
	this.ErrOcxRet = -1000; //返回控件错误代码
	this.ErrOcxPalace = ""; //返回控件错误函数

}

/*
End Define
**************************************************
*/

//Create Global Object ///////////////////////////
var g_objF = new CFormR();
var g_objNR = new CNamingRule();
var g_objER = new CEncRule();
var g_objAH = new CAdditionHTML();
var g_objRet = new CRetCode();
var g_objSI = new CSvrInfo();
//////////////////////////////////////////////////

//Create ActiveX Object //////////////////////////
document.writeln("<OBJECT classid=\"clsid:21336F5A-8C51-463A-81B9-B5D37CD4D6FB\" height=1 id=BJCASecClt CodeBase=GWY_BJCASecClt.CAB#version=1,0,0,1 style=\"HEIGHT: 1px; LEFT: 10px; TOP: 28px; WIDTH: 1px\" width=1 VIEWASTEXT>");
document.writeln("	<PARAM NAME=\"_Version\" VALUE=\"65536\">");
document.writeln("	<PARAM NAME=\"_ExtentX\" VALUE=\"26\">");
document.writeln("	<PARAM NAME=\"_ExtentY\" VALUE=\"26\">");
document.writeln("	<PARAM NAME=\"_StockProps\" VALUE=\"0\">");
document.writeln("	<PARAM NAME=\"_StockProps\" VALUE=\"0\">");
document.writeln("</OBJECT>");
//////////////////////////////////////////////////

/*
**************************************************
Begin Application Development Interface
*/

/*
描述：
	取得UniqueID列表
参数：
	strListID：下拉菜单的完整ID（框架ID、表单ID、下拉列表ID）
返回：
	无
*/
function gFuncGetCertList(strListID) {

	var strTemp;
	var strOption;
	var len;
	var strName;
	var strUniqueID;
	var objListID = eval(strListID);

	strTemp = BJCASecClt.GetCertList();
	len = strTemp.length;

	while (1) {
		i=strTemp.indexOf("&&&");
		if (i <= 0) {
			break;
		}
		strOption = strTemp.substring(0,i);
		strName = strOption.substring(0, strOption.indexOf("||"));
		strUniqueID = strOption.substring(strOption.indexOf("||") + 2, strOption.length);
		var objItem = new Option(strName,strUniqueID)
		objListID.add(objItem);
		len = strTemp.length;
        strTemp = strTemp.substring(i+3,len);
	}

	var objListID = null;
}

/*
Function:	gFuncLogin
Parameter:	strFormName	表单的ID名称
			strUniqueID	证书的UniqueID
			strPassword	私钥保护口令
*/
function gFuncLogin(strFormName, strUniqueID, strPassword)
{
	gFuncResetGRet();

	var ret;
	var objForm = gFuncCheckForm(strFormName);

	if (!objForm)
	{
		gFuncGetLastError(g_objRet.ErrPara);
		return false;
	}

	if (strUniqueID == "" || strPassword == "")
	{
		gFuncGetLastError(g_objRet.ErrPara);
		return false;
	}

	ret = gFuncGetCertDetail(strUniqueID, 23);

	if (ret != g_objRet.ErrCertParse)
	{
		if (parseInt(ret) < 30)
		{
			alert("证书还有" + parseInt(ret) + "天过期，请您尽快更新\n详细情况请访问:\nhttp://www.bjca.org.cn");
		}
	}

	ret = gFuncInitialSession(strUniqueID, strPassword);

	switch(ret)
	{
		case -1:
			alert("UniqueID 输入错误");
			//gFuncGetLastError(g_objRet.ErrPara);
			return false;
			break;
		case -2:
			alert("读取证书路径错误");
			//gFuncGetLastError(g_objRet.ErrCertPath);
			return false;
			break;
		case -3:
			alert("读取证书链路径错误");
			//gFuncGetLastError(g_objRet.ErrCertChainPath);
			return false;
			break;
		case -4:
			alert("私钥设备出错");
			//gFuncGetLastError(g_objRet.ErrCertKeyPath);
			return false;
			break;
		case -5:
			alert("密码错误");
			//gFuncGetLastError(g_objRet.ErrCertKeyPWD);
			return false;
			break;
		case -6:
			alert("证书链设备错误");
			//gFuncGetLastError(g_objRet.ErrCertChain);
			return false;
			break;
		case -7:
			alert("系统异常错误");
			//gFuncGetLastError(g_objRet.ErrUnknown);
			return false;
			break;
		case 0:
			//Initial Ocx Success ////////////////
			BJCASecClt.serverCertPEM = g_objSI.SvrCert;
			ret = gFuncVerifySign(g_objSI.SvrSignData, g_objSI.SvrCert, g_objSI.SvrOriData);
			if (ret != g_objRet.Success)
			{
				BJCASecClt.ClearSession();
				gFuncGetLastError(g_objRet.ErrVeriSgn);
				return false;
			}
			objForm.SecX_SignedData.value = gFuncSign(g_objSI.SvrOriData);
			objForm.SecX_UserCert.value = BJCASecClt.UserCert;
			//objForm.submit();
	}

	return true;;
}

/*
Function:	gFuncSubmit
Parameter:	strFormName	表单的ID名称
*/
function gFuncSubmit(strFormName)
{
	gFuncResetGRet();

	var strToPost;

	var objForm = eval(strFormName)

	//Check Parameter ////////////////////////////
	if (!objForm)
	{
		gFuncGetLastError(g_objRet.ErrPara);
		return false;
	}

	if (g_objER.Flag == 0)
	{
		//Call Sign Form Method //////////////////
		gFuncSignForm(objForm);
		return true;
	}

	//Encrypt Data & Sign Data ///////////////
	if (!document.all("SecX_Form"))
	{
		document.body.insertAdjacentHTML("BeforeEnd",g_objAH.HTMLFormString);
	}
	else
	{
		document.all("SecX_Form").SecX_SignData.value = "";
		document.all("SecX_Form").SecX_EncData.value = "";
		document.all("SecX_Form").SecX_UserCert.value = "";
	}

	//End Check //////////////////////////////////

	var strToPost = gFuncAllOverForm(objForm);

	//Sign & Encrypt /////////////////////////////
	document.all("SecX_Form").SecX_SignData.value = gFuncSign(strToPost);
	document.all("SecX_Form").SecX_UserCert.value = gFuncGetDetailNoInit(g_objSI.UniqueID, 0);
	document.all("SecX_Form").SecX_EncData.value = gFuncEncrypt(strToPost);


	//Modify SecX Form Action ////////////////////
	document.all("SecX_Form").action = objForm.action;
	document.all("SecX_Form").target = objForm.target;

	//Submit Form/////////////////////////////////
	document.all("SecX_Form").submit();

	return false;
}

/*
Function:	gFuncUploadFile
Parameter:	strFormName	表单的ID名称
			strFileItem	文件域名称
*/
function gFuncUploadFile(strFormName, strFileItem)
{
	gFuncResetGRet();

	var strFileContent;

	var objForm = eval(strFormName)
	var objItem = eval(strFormName + "." + strFileItem)

	//Check Parameter ////////////////////////////
	if (!objForm || !objItem)
	{
		gFuncGetLastError(g_objRet.ErrPara);
		return false;
	}

	if (!document.all("SecX_Form"))
	{
		document.body.insertAdjacentHTML("BeforeEnd",g_objAH.HTMLFormString);
	}
	else
	{
		document.all("SecX_Form").SecX_SignData.value = "";
		document.all("SecX_Form").SecX_EncData.value = "";
		document.all("SecX_Form").SecX_UserCert.value = "";
	}
	//End Check //////////////////////////////////

	if (objItem.length > 3)
	{
		strFileContent = gFuncEncryptFileToPEM(objItem.value);
	}
	else
	{
		gFuncGetLastError(g_objRet.ErrPara);
		return false;
	}

	if (strFileContent < 150)
	{
		gFuncGetLastError(g_objRet.ErrEncFile);
		return false;
	}
	else
	{
		document.all("SecX_Form").SecX_EncData.value = strFileContent;
		//Modify SecX Form Action ////////////////////
		document.all("SecX_Form").action = objForm.action;
		document.all("SecX_Form").target = objForm.target;
		document.all("SecX_Form").submit();
	}

	return false;
}

/*
Function:	gFuncModifyPWD
Parameter:	strUniqueID		证书用户标识
			strKeyPWD		原始口令
			strNewPWD		新口令
*/
function gFuncModifyPWD(strUniqueID, strKeyPWD, strNewPWD)
{
	gFuncResetGRet();
	var ret;
	/* add by lzx  */
	ret = gFuncInitialSession(strUniqueID, strKeyPWD);
	if(ret == -5){
		alert('原密码输入错误！');
		return ret;
	}
	/*   add by lzx finished*/
	ret = BJCASecClt.ChangePWD(strUniqueID, strKeyPWD, strNewPWD);
	if (ret != 0)
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "ChangePWD";
		return g_objRet.ErrModifyPWD;
	}
	/* add by lzx  */
	alert('修改密码成功！');
	/*   add by lzx finished*/
	return g_objRet.Success;
}

/*
Function:	gFuncGetLastError
Parameter:	AppError		SecX错误代码
*/
function gFuncGetLastError(AppError)
{
	var ErrMsg = "SecX Error Code:";

	ErrMsg += AppError + "\n";

	if (g_objRet.ErrOcxRet == -1000)
	{
		ErrMsg += "Ocx No Error";
	}
	else
	{
		ErrMsg += "Ocx Error Code: " + g_objRet.ErrOcxRet + "\n";
		ErrMsg += "Ocx Error Palace: " + g_objRet.ErrOcxPalace + "\n";
	}
	alert(ErrMsg);
}
/*
End Application Developmet Interface
**************************************************
*/

/*
**************************************************
Reserved Functions
*/

/*
Begin About Ocx Crypt Operation
*/

//Initial Session ////////////////////////////////
function gFuncInitialSession(strUniqueID, strPassword)
{
	return BJCASecClt.InitialSession(strUniqueID, strPassword);
}

//Clear Session ///////////////////////////////////
function gFuncClearSession()
{
	return BJCASecClt.ClearSession();
}

//Parse Cert /////////////////////////////////////
function gFuncGetCertDetail(strUniqueID, ItemNo)
{
	if (ItemNo > 23 || ItemNo < 0) {
		return g_objRet.ErrCertParse;
	}

	var ret;

	ret = BJCASecClt.GetCertDetail(strUniqueID, ItemNo);
	if (ret == "Read_Cert_Error!" || ret == "Invalid_Cert" || ret == "-1")
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "GetCertDetail";
		return g_objRet.ErrCertParse;
	}

	return ret;
}

//Parse Cert Without Initial /////////////////////
function gFuncGetDetailNoInit(strUniqueID, ItemNo)
{
	if (ItemNo > 23 || ItemNo < 0) {
		return g_objRet.ErrCertParse;
	}

	var ret;

	ret = BJCASecClt.GetDetailNoInit(strUniqueID, ItemNo);
	if (ret == "Read_Cert_Error!" || ret == "Invalid_Cert" || ret == "-1")
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "GetCertDetail";
		return g_objRet.ErrCertParse;
	}

	return ret;
}

//Encrypt Data ///////////////////////////////////
function gFuncEncrypt(s)
{

	var ret;
	if (s == "") {
		alert("Parameter is empty!");
		return g_objRet.ErrPara;
	}

	BJCASecClt.serverCertPEM = g_objSI.SvrCert;

	if (BJCASecClt.serverCertPEM == "")
	{
		alert("Server Cert Is Empty");
		return g_objRet.ErrSvrCert;
	}

	ret = BJCASecClt.EncryptPEM(s);

	if (ret.length < 150)
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "EncryptPEM";
		return g_objRet.ErrEnc;
	}

	return ret;
}

//Dencrypt Data //////////////////////////////////
function gFuncDencrypt(s)
{
	var ret;
	if (s == "")
	{
		alert("Parameter is empty!");
		return g_objRet.ErrPara;
	}

	ret = BJCASecClt.DeEncryptPEM(s);

	if (ret == "SE_Initial_Error" || ret == "DeCode_Error" || ret == "Envelope_Error")
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "DeEncryptPEM";
		return g_objRet.ErrDenc;
	}

	return ret;
}

//Sign Data //////////////////////////////////////
function gFuncSign(s)
{
	var ret;
	if (s == "")
	{
		alert("Parameter is empty!");
		return g_objRet.ErrPara;
	}

	ret = BJCASecClt.Sign(s);

	if (ret == "SE_Initial_Error" || ret == "Sign_Error")
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "Sign";
		return g_objRet.ErrSgn;
	}

	return ret;
}

//Verify Signed Data /////////////////////////////
function gFuncVerifySign(strSignedData, strUserCert, strOrigindata)
{
	var ret;
	ret = BJCASecClt.VerifySign(strSignedData, strUserCert, strOrigindata);

	if (ret == 1)
	{
		return g_objRet.Success;
	}
	else
	{
		g_objRet.ErrOcxRet = ret;
		g_objRet.ErrOcxPalace = "VerifySign";
		return g_objRet.ErrVeriSgn;
	}
}

//Encrypt File ///////////////////////////////////
function gFuncEncryptFileToPEM(strFilePath)
{
	var ret;

	BJCASecClt.serverCertPEM = g_objSI.SvrCert;

	if (BJCASecClt.serverCertPEM == "")
	{
		alert("Server Cert Is Empty");
		return g_objRet.ErrSvrCert;
	}

	ret = BJCASecClt.EncryptFileToPEM(strFilePath);

	if (ret < 150)
	{
		g_objRet.ErrOcxRet = -1;
		g_objRet.ErrOcxPalace = "EncryptFileToPEM" + "\n";
		g_objRet.ErrOcxPalace += "Description:" + ret;
	}
	return ret;
}

//Dencrypt File //////////////////////////////////
function gFuncDencryptFileByPEM(strFileContent, strFilePath, Flag)
{
	Flag = 0;

	ret = BJCASecClt.DownloadFile(strFileContent, strFilePath, Flag);

	if (ret != g_objRet.Success)
	{
		g_objRet.ErrOcxRet = ret;

		g_objRet.ErrOcxPalace = "DownloadFile" + "\n";
		g_objRet.ErrOcxPalace += "Para -> strFilePath:" + strFilePath + "\n";
		g_objRet.ErrOcxPalace += "Para -> File Length:" + strFileContent.length;

		return g_objRet.ErrDencFile;
	}
	else
	{
		return g_objRet.Success;
	}

}

//Get Cert Detail Form Medium ////////////////////
function gFuncGetCertDetailInfo(strCertPath, ItemNo, CertType)
{
	var ret;

	ret = BJCASecClt.GetCertDetailInfo(strCertPath, ItemNo, CertType);

	if (ret == "Get_Error")
	{
		g_objRet.ErrOcxRet = -1;
		g_objRet.ErrOcxPalace = "GetCertDetailInfo" + "\n";
		g_objRet.ErrOcxPalace += "Description:" + ret;
	}

	return ret;
}
/*
End About Ocx Crypt Operation
**************************************************
*/


//Reset Global Return Code Object ////////////////
function gFuncResetGRet()
{
	g_objRet.ErrOcxRet = -1000;
	g_objRet.ErrOcxPalace = "";

	g_objER = new CEncRule();
}


//Check Login Form ///////////////////////////////
function gFuncCheckForm(strFormName)
{
	var objForm = eval(strFormName);

	if (objForm == null)
	{
		g_objRet.ErrOcxRet = "-100";
		g_objRet.ErrOcxPalace = "No This Form";
		return null;
	}

	if (objForm.SecX_SignedData == null)
	{
		g_objRet.ErrOcxRet = "-100";
		g_objRet.ErrOcxPalace = "No SignData Area";
		return null;
	}

	if (objForm.SecX_UserCert == null)
	{
		g_objRet.ErrOcxRet = "-100";
		g_objRet.ErrOcxPalace = "No UserCert Area";
		return null;
	}

	return objForm;
}

//Sign Form Data /////////////////////////////////
function gFuncSignForm(objForm)
{
	var strToSign = "";
	var strNameList = "";

	var i, j;

	if (!objForm.SecX_SignData)
	{
		objForm.insertAdjacentHTML("BeforeEnd",g_objAH.HTMLItemString)
	}
	else
	{
		objForm.SecX_SignData.value = "";
		objForm.SecX_NameList.value = "";
		objForm.SecX_UserCert.value = "";
	}

	for (i = 0;i < objForm.length ; i++ )
	{
		for (j = 0; j < 5; j++)
		{
			if (objForm.item(i).type == g_objF.ReIType[j] && (objForm.item(i).name.indexOf("SecX") < 0))
			{
				strToSign += objForm.item(i).value;
				strNameList += objForm.item(i).name + ";";
			}
		}
	}


	objForm.SecX_SignData.value = gFuncSign(strToSign);
	objForm.SecX_NameList.value = strNameList;
	objForm.SecX_UserCert.value = gFuncGetDetailNoInit(g_objSI.UniqueID, 0);


	return true;
}


//All Over User`s Form ///////////////////////////
function gFuncAllOverForm(objForm)
{
	var strNameList = "";
	var strName = "";
	var strType = "";
	var strValue = "";

	var i, j;

	if (g_objNR.Flag)
	{
		//Need Naming Rule ///////////////////////
		for (i = 0; i < objForm.elements.length; i++ )
		{
			if (objForm.elements(i).name.indexOf(g_objNR.RuleString) > 0)
			{
				////Not Support ////
				break;
			}
		}
	}
	else
	{
		//No Naming Rule /////////////////////////

		for (i = 0; i < objForm.length; i++)
		{
			strName = objForm(i).name;
			strType = objForm(i).type;

			for (j = 0; j < g_objF.ReIType.length; j++)
			{
				////Support These simple item ////
				if (objForm(i).type == g_objF.ReIType[j])
				{
					strValue = objForm(i).value;
					gFuncFormItem2XML(strName, strType, strValue);
					strNameList += strName +  + "&&&";
					break;
				}
			}

			if (objForm(i).type == "select-multiple" && (strNameList.indexOf(strName) == -1))
			{
				////Is Multi Select //////////////
				for (j = 0; j < objForm(i).length; j++)
				{
					if (objForm(i).item(j).selected)
					{
						strValue += ", " + objForm(i).item(j).value;
					}
				}
				////Set Item Value ///////////////
				strValue = strValue.substr(2, strValue.length - 2);
				gFuncFormItem2XML(strName, strType, strValue);
				strNameList += strName + "&&&";
			}

			if ((objForm(i).type == "checkbox") && (strNameList.indexOf(strName) == -1))
			{
				////Is CheckBox //////////////////
				for (j = 0; j < objForm.length; j++)
				{
					if (objForm(j).checked && (objForm(j).name == strName))
					{
						strValue += ", " + objForm(j).value;
					}
				}
				strValue = strValue.substr(2, strValue.length - 2);
				gFuncFormItem2XML(strName, strType, strValue);
				strNameList += strName + "&&&";
			}

			if ((objForm(i).type == "radio") && (strNameList.indexOf(strName) == -1))
			{
				////Is CheckBox //////////////////
				for (j = 0; j < objForm.length; j++)
				{
					if (objForm(j).checked && (objForm(j).name == strName))
					{
						strValue += ", " + objForm(j).value;
					}
				}
				strValue = strValue.substr(2, strValue.length - 2);
				gFuncFormItem2XML(strName, strType, strValue);
				strNameList += strName + "&&&";
			}

			strValue = "";
		}
	}

	return g_objER.XMLHeader + g_objER.XMLDoc.xml;
}

//Generate XML String ////////////////////////////
function gFuncFormItem2XML(strTag, strType, strValue)
{
	if (strTag == "")
	{
		return g_objRet.ErrPara;
	}

	strTag = gFuncURLEncode(strTag);

	var strPath = "/SecXMSG";
	var objNode = g_objER.XMLDoc.selectSingleNode(strPath);

	var objTemp = g_objER.XMLDoc.createElement(strTag);
	objNode.appendChild(objTemp);

	var objNode = g_objER.XMLDoc.selectSingleNode(strPath + "/" + strTag);
	objNode.setAttribute("Type", strType);

	//Need CDATA Tag /////////////////////////////
	var objCDATA = g_objER.XMLDoc.createCDATASection(strTag);
	objCDATA.text = strValue;
	objNode.appendChild(objCDATA);

	return g_objRet.Success;
}


//URL Encode /////////////////////////////////////
function gFuncURLEncode(str)
{
	//return str;
	var str1 = str;
	var i, c;
	var ret = ""
	var strSpecial = "!\"#$%&'()*+,/:;<=>?@[\]^`{|}~%";
	for(i = 0; i < str1.length ;i++ ){
			c=str1.charAt(i);
			if(c==" ")
				str1=str1.replace(" ","+");
			else if(strSpecial.indexOf(c)!=-1)
			{
				var temp = "%"+str1.charCodeAt(i).toString(16);
				str1 =str1.replace(c,temp);
				i=i+temp.length - 1;
			}

	}
	return str1;
}

//Get Real URL ///////////////////////////////////
function gFuncGetRealURL(strAbsURL, strRelURL) {

	var strRealURL = "";
	var strWebPath = "";
	var strTemp = strRelURL;

	strTemp = strRelURL.toUpperCase();

	//The strRelURL aleady is AbsURL ...
	if (strTemp.indexOf("HTTP://") != -1) {
		strRealURL = strRelURL;
	}
	else {
		if (strRelURL.substr(0,1) != "/") {
			//The first of strRelURL is not '/' ...
			strWebPath = strAbsURL.substr(0, strAbsURL.lastIndexOf("/") + 1);
			strRealURL = strWebPath + strRelURL;
		}
		else {
			//The first of strRelURL is '/' ...
			strTemp = strAbsURL;
			strTemp = strTemp.substr(strTemp.indexOf("//") + 2, strTemp.length);
			strTemp = strTemp.substr(strTemp.indexOf("/") + 1, strTemp.length);
			strAbsURL = strAbsURL.substr(0, strAbsURL.indexOf(strTemp) - 1);
			strRealURL = strAbsURL + strRelURL;
		}
	}

	return strRealURL;
}

/*
End Reserved Functions
**************************************************
*/