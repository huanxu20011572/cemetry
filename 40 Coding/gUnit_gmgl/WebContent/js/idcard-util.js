function IdCard(value,areaId,sex,birth){
	this.value = value;
	this.areaId = areaId;
	this.sex = sex;
	this.birth = birth;
}

IdCard.prototype.create=function(){
	//���֤���룽������루6λ�����ݾ�������������������ڵ��������ɣ����ɹ�����±�
	//+������ݣ�4λ��+ �����·ݣ�2λ��+ �������ڣ�2λ��+ ϵͳ˳������2λ�� 
	//+ �Ա��־��1��ʾ�У�2��ʾŮ����ϵͳ��־����ʾΪϵͳ�������֤���ݶ�ΪZ����18λ
	if(this.areaId==''){
		alert('������Ϣ����Ϊ�գ�');	
		return;
	}
	if(this.birth==''){
		alert('��ѡ���������ĳ������ڣ�');
		return;
	}
	if(this.sex=='-1'){
		alert('��ѡ�����������Ա�');
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
	
	//���
	this.value += this.birth.substring(0,4);
	//�·�
	this.value += this.birth.substring(5,7);
	//����
	this.value += this.birth.substring(8,10);
	//��λ�����
	this.value += createRandom(2);
	//�Ա��־
	this.value += this.sex==119?1:2;
	//ϵͳ��־
	this.value += systemSign;
	
	return this.value;
}

IdCard.prototype.check=function(){
	var len = this.value.length;
	if(len!=15&&len!=18){
		alert('���֤��д�������֤�������Ϊ15λ��18λ��');
		return false;
	}
	var temp = (len==15)?('19'+this.value.substring(6,12)):this.value.substring(6,14);
	var r = temp.match(/^(\d{4})(\d{2})(\d{2})/);
	if(r==null){
		alert('���֤��д�������֤�������ڲ���ȷ��');
		return false;
	}
	var year = parseInt(r[1]);
	var month = parseInt(r[2]);
	var date = parseInt(r[3]);
	var birthday = new Date(year,month-1,date);
	if(birthday.getFullYear()!=year||(birthday.getMonth()+1)!=month||birthday.getDate()!=date){
		alert('���֤��д�������֤�������ڲ���ȷ��');
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
				msg.innerHTML=	'<font color="red">�����֤����Ϊϵͳ����,�����ο�</font>';
			}
		}else{
			if(idcard.value.length==18){
				return;
			}
			alert('����д15λ���֤����!');	
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
			idcard.innerHTML = '<font color="red">���֤���룺'+idcardNum.value+'</font>';
			if(msg){
				msg.innerHTML = '<font color="red">�����֤����Ϊϵͳ���ɣ������ο���</font>';
			}
			event.srcElement.value='��������';
			eval('submit_button').disabled = '';
			eval('idcardnum').value = idcardNum.value;
		}
	}
}

function checkRepeat(name,idcard,countyId,address){
	if(name==null||name==''){
		alert('�����������������Ϊ�գ�');
		return;
	}
	if(idcard==null||idcard==''){
		alert('������������֤���벻��Ϊ�գ�');	
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
//15λ��18λ���֤���㷽��
var wi=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);
var code = new Array('1','0','x','9','8','7','6','5','4','3','2');
//�����Ӧ���֤����
var areaCodes = new Array();
areaCodes[0] = new AreaCode(2,'������','110000');
areaCodes[1] = new AreaCode(461,'������','110101');
areaCodes[2] = new AreaCode(462,'������','110102');
areaCodes[3] = new AreaCode(463,'������','110103');
areaCodes[4] = new AreaCode(464,'������','110104');
areaCodes[5] = new AreaCode(4,'������','110105');
areaCodes[6] = new AreaCode(301,'��̨��','110106');
areaCodes[7] = new AreaCode(467,'ʯ��ɽ��','110107');
areaCodes[8] = new AreaCode(8,'������','110108');
areaCodes[9] = new AreaCode(470,'��ͷ����','110109');
areaCodes[10] = new AreaCode(469,'��ɽ��','110111');
areaCodes[11] = new AreaCode(466,'ͨ����','110112');
areaCodes[12] = new AreaCode(476,'˳����','110113');
areaCodes[13] = new AreaCode(475,'��ƽ��','110114');
areaCodes[14] = new AreaCode(468,'������','110115');
areaCodes[15] = new AreaCode(473,'������','110116');
areaCodes[16] = new AreaCode(471,'ƽ����','110117');
areaCodes[17] = new AreaCode(472,'������','110228');
areaCodes[18] = new AreaCode(474,'������','110229');
