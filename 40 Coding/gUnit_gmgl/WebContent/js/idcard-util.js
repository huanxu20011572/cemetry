function IdCard(value,areaId,sex,birth){
	this.value = value;
	this.areaId = areaId;
	this.sex = sex;
	this.birth = birth;
}

IdCard.prototype.create=function(){
	//身份证号码＝区域号码（6位，根据救助对象申请的受理所在地区域生成，生成规则见下表）
	//+出生年份（4位）+ 出生月份（2位）+ 出生日期（2位）+ 系统顺序生成2位数 
	//+ 性别标志（1表示男，2表示女）＋系统标志（表示为系统生成身份证，暂定为Z）共18位
	if(this.areaId==''){
		alert('区域信息不能为空！');	
		return;
	}
	if(this.birth==''){
		alert('请选择救助对象的出生日期！');
		return;
	}
	if(this.sex=='-1'){
		alert('请选择救助对象的性别！');
		return;
	}
	for(var i=0,j=areaCodes.length;i<j;i++){
		if(this.areaId==areaCodes[i].systemId){
			this.value += areaCodes[i].code;
			break;
		}
	}
	
	if(this.value==null||this.value==''){
		this.value += areaCodes[0].code;	
	}
	
	//年份
	this.value += this.birth.substring(0,4);
	//月份
	this.value += this.birth.substring(5,7);
	//日期
	this.value += this.birth.substring(8,10);
	//两位随机数
	this.value += createRandom(2);
	//性别标志
	this.value += this.sex==119?1:2;
	//系统标志
	this.value += systemSign;
	
	return this.value;
}

IdCard.prototype.check=function(){
	var len = this.value.length;
	if(len!=15&&len!=18){
		alert('身份证填写错误：身份证号码必须为15位或18位！');
		return false;
	}
	var temp = (len==15)?('19'+this.value.substring(6,12)):this.value.substring(6,14);
	var r = temp.match(/^(\d{4})(\d{2})(\d{2})/);
	if(r==null){
		alert('身份证填写错误：身份证号码日期不正确！');
		return false;
	}
	var year = parseInt(r[1]);
	var month = parseInt(r[2]);
	var date = parseInt(r[3]);
	var birthday = new Date(year,month-1,date);
	if(birthday.getFullYear()!=year||(birthday.getMonth()+1)!=month||birthday.getDate()!=date){
		alert('身份证填写错误：身份证号码日期不正确！');
		return false;
	}
}

IdCard.prototype.changeLength=function(){
	var len = this.value.length;
	//if(this.value.substring(6,7)=='0'){
	//	this.value = this.value.substring(0,6)+'20'+this.value.substring(6,15)
	//}else{
		this.value = this.value.substring(0,6)+'19'+this.value.substring(6,15)
	//}
	if(len==15){
		var v = 0;
		for(var i=0;i<17;i++){
			v+=this.value.charAt(i)*wi[i];
		}
		v = v%11;
		this.value +=code[v];
	}
}

function AreaCode(systemId,name,code){
	this.systemId = systemId;
	this.name = name;
	this.code = code;
}


function createRandom(num){
	var result = '';
	for(var i=0;i<num;i++){
		result+=parseInt(Math.random()*10);
	}
	return result;
}


function changeLength(idcard,msg){
	if(idcard&&idcard.value){
		if(idcard.value.length==15){
			var idcardNum = new IdCard(idcard.value,'','','');
			idcardNum.changeLength();
			idcard.value = idcardNum.value;
			if(msg){
				msg.innerHTML=	'<font color="red">该身份证号码为系统生成,仅供参考</font>';
			}
		}else{
			if(idcard.value.length==18){
				return;
			}
			alert('请填写15位身份证号码!');	
			idcard.focus();
		}
	}
}

function getIdcardCreator(idcard,msg){
 	var idcardNum = window.showModalDialog('../../common/idcard_creator.jsp','','scroll:no;status:no;resizable:no;dialogWidth:300px;dialogHeight:255px;');
	if(idcardNum&&idcardNum!=''){
		eval('document.all.'+idcard).value=idcardNum;
	}
}

function getIdcardCreatorWubao(idcard,msg){
 	var idcardNum = window.showModalDialog('../../../common/idcard_creator.jsp','','scroll:no;status:no;resizable:no;dialogWidth:300px;dialogHeight:255px;');
	if(idcardNum&&idcardNum!=''){
		eval('document.all.'+idcard).value=idcardNum;
	}
}

function setIdcard(){
	window.returnValue = eval('idcardnum').value;
	window.close();
}

function createIdcard(areaId,sex,birth,idcard,msg){
	if(idcard){
		var idcardNum = new IdCard('',areaId,sex,birth);
		if(idcardNum.create()){
			idcard.innerHTML = '<font color="red">身份证号码：'+idcardNum.value+'</font>';
			if(msg){
				msg.innerHTML = '<font color="red">此身份证号码为系统生成，仅供参考！</font>';
			}
			event.srcElement.value='重新生成';
			eval('submit_button').disabled = '';
			eval('idcardnum').value = idcardNum.value;
		}
	}
}

function checkRepeat(name,idcard,countyId,address){
	if(name==null||name==''){
		alert('救助对象的姓名不能为空！');
		return;
	}
	if(idcard==null||idcard==''){
		alert('救助对象的身份证号码不能为空！');	
		return;
	}
	var vurl = '../accept/getRepeatMember.do?method=getRepeatMembers&name='+name+'&idcard='+idcard;
	if(countyId!=null&&countyId!=''){
		vurl+='&countyId='+countyId;
	}
	if(address!=null&&address!=''){
		vurl+='&address='+address;
	}
	var idcardNum = window.showModalDialog(vurl,'','scroll:auto;status:no;resizable:no;dialogWidth:560px;dialogHeight:255px;');
}

var systemSign = "Z";
//15位升18位身份证计算方法
var wi=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);
var code = new Array('1','0','x','9','8','7','6','5','4','3','2');
//区域对应身份证编码
var areaCodes = new Array();
areaCodes[0] = new AreaCode(2,'北京市','110000');
areaCodes[1] = new AreaCode(461,'东城区','110101');
areaCodes[2] = new AreaCode(462,'西城区','110102');
areaCodes[3] = new AreaCode(463,'崇文区','110103');
areaCodes[4] = new AreaCode(464,'宣武区','110104');
areaCodes[5] = new AreaCode(4,'朝阳区','110105');
areaCodes[6] = new AreaCode(301,'丰台区','110106');
areaCodes[7] = new AreaCode(467,'石景山区','110107');
areaCodes[8] = new AreaCode(8,'海淀区','110108');
areaCodes[9] = new AreaCode(470,'门头沟区','110109');
areaCodes[10] = new AreaCode(469,'房山区','110111');
areaCodes[11] = new AreaCode(466,'通州区','110112');
areaCodes[12] = new AreaCode(476,'顺义区','110113');
areaCodes[13] = new AreaCode(475,'昌平区','110114');
areaCodes[14] = new AreaCode(468,'大兴区','110115');
areaCodes[15] = new AreaCode(473,'怀柔区','110116');
areaCodes[16] = new AreaCode(471,'平谷区','110117');
areaCodes[17] = new AreaCode(472,'密云区','110228');
areaCodes[18] = new AreaCode(474,'延庆区','110229');
