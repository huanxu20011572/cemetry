<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>北京公墓管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#268ef0">
<script type="text/jscript">
var isShow=true;

function changeLeft(){
	var leftTab = document.all("leftTab");
	var contentTab = document.all("contentTab");
	var top2 = document.all("top2");
	var imgName = document.all("imgName");
	if(isShow==true){
		leftTab.style.display = 'none';
		contentTab.style.width='100%';
		isShow=false;
		imgName.src="images/left-hid.jpg";
		top2.style.left = "0";
	}else{
		leftTab.style.display = '';
		contentTab.style.width='';
		isShow=true;
		imgName.src="images/left-dis.jpg";
		top2.style.left = "195px";
	}
}

function changetop(){
	var imgName1 = document.all("imgName1");
	var top2 = document.all("top1");
	if (parent.full.rows.indexOf("0,*,")!=-1){
		parent.full.rows="109,*,"+parent.full.rows.split(",")[2]
		imgName1.src="images/top-dis.gif";
	}
	else{
		parent.full.rows="0,*,"+parent.full.rows.split(",")[2]
		imgName1.src="images/top-hid.gif";
	}
}

function showHidden(index){
	for (var i=1;i<=90;i++){
		if(document.getElementById ("sl"+i) != null && document.getElementById ("dl"+i) != null){
			document.getElementById ("sl"+i).className ="mar-t leftdiv-bt-2"; 
			document.getElementById ("dl"+i).style.display="none";
		}
	}
	document.getElementById ("sl"+index).className ="mar-t leftdiv-bt-1"; 
	document.getElementById ("dl"+index).style.display="block";
}

function showHidden1(index){
	for (var i=1;i<=900;i++){
		if(document.getElementById ("b"+i) != null){
			document.getElementById ("b"+i).className ="td-line-2 word-1"; 
		}
	}
	document.getElementById ("b"+index).className ="td-line-1 word-2"; 
}
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="195" align="right" valign="top" bgcolor="#60c6f6" id="leftTab"><table border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="214" height="10"><img src="images/left-4.jpg" width="195" height="55" /></td>
        </tr>
      <tr>
        <td height="680" align="center" valign="top">
          <div style="overflow:auto; width:90%;">
          
          <!--售前管理-->
		 <gOS:priority unitID="gEU_sqgl" priority="sqgl-01,sqgl-02">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl1">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(1)">售前管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl1" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_sqgl" priority="sqgl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b11" onClick="showHidden1(11)"><a href="cemetery/cemetery_location_fast_tree.jsp" target="frame1">墓区信息快速查询</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_sqgl" priority="sqgl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b12" onClick="showHidden1(12)"><a href="business/visitReturnController.fj?method=getVisitReturnList" target="frame1">来访登记</a></td>
                </tr>
                </gOS:priority>
              </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
		 <gOS:priority unitID="gEU_ywbl" priority="ywbl-01,ywbl-02,ywbl-03">
          <!--业务办理-->
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl2">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(2)">业务办理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl2" style="display:none">
          <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_ywbl" priority="ywbl-01">
                <tr>
                <td height="26" class="td-line-2 word-1" id="b21" onClick="showHidden1(21)"><a href="business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=1" target="frame1">租用登记</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_ywbl" priority="ywbl-02">
                <tr>
                <td height="26" class="td-line-2 word-1" id="b22" onClick="showHidden1(22)"><a href="business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=2" target="frame1">续租登记</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_ywbl" priority="ywbl-03">
                <tr>
                <td height="26" class="td-line-2 word-1" id="b23" onClick="showHidden1(23)"><a href="business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=3" target="frame1">合葬登记</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_ywbl" priority="ywbl-04">
                <tr>
                <td height="26" class="td-line-2 word-1" id="b25" onClick="showHidden1(25)"><a href="business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=4" target="frame1">迁出登记</a></td>
                </tr>
                </gOS:priority>
              </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
		  <!-- 售后管理分-->
		 <gOS:priority unitID="gEU_shgl" priority="shgl-01,shgl-02,shgl-03">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl3">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(3)">售后管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl3" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8">
              <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_shgl" priority="shgl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b31" onClick="showHidden1(31)"><a href="archives/archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryPageList"  target="frame1">承租人信息变更</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_shgl" priority="shgl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b32" onClick="showHidden1(32)"><a href="archives/cemeteryCertificateController.fj?method=getCemeteryCertificatePageList" target="frame1">补证业务登记</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_shgl" priority="shgl-03">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b33" onClick="showHidden1(33)"><a href="archives/cemeteryServiceController.fj?method=getCemeteryServicePageList" target="frame1">服务事项登记</a></td>
                </tr>
                </gOS:priority>
              </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
			<!-- 档案管理-->
		 <gOS:priority unitID="gEU_dagl" priority="dagl-01,dagl-02">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl4">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(4)">档案管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl4" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8">
              <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_dagl" priority="dagl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b41" onClick="showHidden1(41)"><a href="archives/archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryQueryList" target="frame1">档案查询</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_dagl" priority="dagl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b42" onClick="showHidden1(42)"><a href="business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageSupplyList&cemeteryRegistryType=1" target="frame1">档案补录</a></td>
                </tr>
                </gOS:priority>
              </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
		  <!-- 综合统计-->
		 <gOS:priority unitID="gEU_zhtj" priority="zhtj-01,zhtj-02,zhtj-03,zhtj-04">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl5">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(5)">综合统计</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl5" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_zhtj" priority="zhtj-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b51" onClick="showHidden1(51)"><a href="reprot/reprotController.fj?method=orgLocation" target="frame1">墓区信息一览表(市)</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_zhtj" priority="zhtj-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b52" onClick="showHidden1(52)"><a href="reprot/reprotController.fj?method=subOrgLocation" target="frame1">墓区信息一览表</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_zhtj" priority="zhtj-03">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b53" onClick="showHidden1(53)"><a href="reprot/reprotController.fj?method=caveUserCase" target="frame1">土地使用情况统计(市)</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_zhtj" priority="zhtj-04">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b54" onClick="showHidden1(54)"><a href="reprot/reprotController.fj?method=subCaveUserCase" target="frame1">土地使用情况统计</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_zhtj" priority="zhtj-05">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b55" onClick="showHidden1(55)"><a href="reprot/reprotController.fj?method=subPeriodBusiness" target="frame1">同期业务对比表</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_zhtj" priority="zhtj-06">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b56" onClick="showHidden1(56)"><a href="reprot/reprotController.fj?method=typeDetail" target="frame1">墓型明细统计</a></td>
                </tr>
                </gOS:priority>
              </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
          <!-- 墓区管理 -->
		 <gOS:priority unitID="gEU_mqgl" priority="mqgl-01,mqgl-02,mqgl-03,mqgl-04">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl6">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(6)">墓区管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl6" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_mqgl" priority="mqgl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b61" onClick="showHidden1(61)"><a href="cemetery/cemeteryTypeController.fj?method=getCemeteryTypeList" target="frame1">墓型管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_mqgl" priority="mqgl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b62" onClick="showHidden1(62)"><a href="cemetery/cemetery_zone_tree.jsp" target="frame1">区排管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_mqgl" priority="mqgl-03">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b63" onClick="showHidden1(63)"><a href="cemetery/cemetery_location_tree.jsp" target="frame1">墓位管理</a></td>
                </tr>
                </gOS:priority>
             </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
          <!-- 商品管理 -->
		 <gOS:priority unitID="gEU_spgl" priority="spgl-01,spgl-02">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl7">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(7)">商品管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl7" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_spgl" priority="spgl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b71" onClick="showHidden1(71)"><a href="cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList" target="frame1">入库信息</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_spgl" priority="spgl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b72" onClick="showHidden1(72)"><a href="cemetery/cemeteryChargeController.fj?method=getCemeteryChargeList" target="frame1">出库信息</a></td>
                </tr>
                </gOS:priority>
             </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
          <!-- 费用管理 -->
		 <gOS:priority unitID="gEU_fygl" priority="fygl-01,fygl-02">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl8">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(8)">费用管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl8" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_fygl" priority="fygl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b82" onClick="showHidden1(82)"><a href="charge/chargeTypeController.fj?method=getChargeTypeList" target="frame1">费用分类维护</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_fygl" priority="fygl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b83" onClick="showHidden1(83)"><a href="charge/charge_data_tree.jsp" target="frame1">费用明细维护</a></td>
                </tr>
                </gOS:priority>
             </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
          <!-- 分类管理 -->
		 <gOS:priority unitID="gEU_flgl" priority="flgl-01">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl9">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(9)">分类管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl9" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_flgl" priority="flgl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b91" onClick="showHidden1(91)"><a href="business/businessDataController.fj?method=getBusinessDataList" target="frame1">分类管理</a></td>
                </tr>
                </gOS:priority>
             </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       
          <!-- 系统管理 -->
		 <gOS:priority unitID="gEU_xtgl" priority="xtgl-01,xtgl-02,xtgl-03,xtgl-04,xtgl-05,xtgl-06">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl10">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(10)">系统管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl10" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_xtgl" priority="xtgl-06">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b104" onClick="showHidden1(104)"><a href="dict/dict_tree.jsp" target="frame1">字典管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgl" priority="xtgl-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b101" onClick="showHidden1(101)"><a href="tree/region_list.jsp" target="frame1">区划管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgl" priority="xtgl-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b102" onClick="showHidden1(102)"><a href="tree/office_list.jsp" target="frame1">机构管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgl" priority="xtgl-03">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b103" onClick="showHidden1(103)"><a href="main/system/priority_mgm/roleList.do?doMethod=roleList" target="frame1">角色管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgl" priority="xtgl-05">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b106" onClick="showHidden1(106)"><a href="main/system/user_mgm/userQueryList.do?queryName=userList&unavailable=true&inputPath=allList" target="frame1">用户管理</a></td>
                </tr>
                </gOS:priority>
             </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
            </table>
     </gOS:priority>       
          <!-- 子系统管理 -->
		 <gOS:priority unitID="gEU_xtgll" priority="xtgll-01,xtgll-02,xtgll-03">
          <table border="0" align="center" cellpadding="0" cellspacing="0" class="mar-t leftdiv-bt-2"id="sl11">
            <tr>
              <td height="27" valign="middle"  class="" style="cursor:pointer" onClick="showHidden(11)">子系统管理</td>
            </tr>
          </table>
          <table width="154" border="0" align="center" cellpadding="0" cellspacing="0" id="dl11" style="display:none">
            <tr>
              <td align="center" bgcolor="#7bd0f8"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              	<gOS:priority unitID="gEU_xtgll" priority="xtgll-01">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b111" onClick="showHidden1(111)"><a href="tree/user/sys_manager.jsp" target="frame1">子管理员管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgll" priority="xtgll-02">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b112" onClick="showHidden1(112)"><a href="main/system/zxt_mgm/subUserQueryList.do?queryName=managedSubUsers&unavailable=true&inputPath=subUsers" target="frame1">下属子系统管理员</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgll" priority="xtgll-03">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b113" onClick="showHidden1(113)"><a href="main/system/user_mgm/user_redirect_subUsers.jsp" target="frame1">子用户管理</a></td>
                </tr>
                </gOS:priority>
              	<gOS:priority unitID="gEU_xtgll" priority="xtgll-04">
                <tr>
                  <td height="26" class="td-line-2 word-1" id="b114" onClick="showHidden1(114)"><a href="main/system/priority_mgm/roleList.do?doMethod=subRoleList" target="frame1">子角色管理</a></td>
                </tr>
                </gOS:priority>
             </table></td>
            </tr>
            <tr>
              <td><img src="images/left-3.jpg" width="154" height="10"></td>
            </tr>
          </table>
     </gOS:priority>       


          </div>

          </td>
        </tr>
      <tr>
        <td height="10">&nbsp;</td>
        </tr>
    </table></td>
    <td valign="top" id="contentTab" class="td-bg-2"><iframe frameborder="0"  width="100%" src="business/firstPageController.fj?method=getFirstList" height="520" scrolling="auto" id="frame1" name="frame1" allowtransparency="true"  ></iframe></td>
  </tr>
</table>
<div style="position:absolute; left: 50%; top: 0px;" id="top1"><img src="images/top-dis.gif" width="75" height="9" style="cursor:pointer;" id="imgName1" onClick="changetop()"/></div>

<div style="position:absolute; left: 195px; top:40%" id="top2"><img src="images/left-dis.jpg" width="9" height="75" style="cursor:pointer;" id="imgName" onClick="changeLeft()"/></div>
</body>
</html>
