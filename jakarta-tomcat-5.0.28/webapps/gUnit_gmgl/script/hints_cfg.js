var HINTS_CFG = {
	'top'        : 5, // a vertical offset of a hint from mouse pointer
	'left'       : 5, // a horizontal offset of a hint from mouse pointer
	'css'        : 'hintsClass', // a style class name for all hints, TD object
	'show_delay' : 500, // a delay between object mouseover and hint appearing
	'hide_delay' : 2000, // a delay between hint appearing and hint hiding
	'wise'       : true,
	'follow'     : false,
	'z-index'    : 0 // a z-index for all hint layers
},

HINTS_ITEMS = [
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>�༭</b></td><td align="center" nowrap>�༭�û���Ϣ</td></tr></table></td></tr></table>',			//0
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>��¡</b></td><td align="center" nowrap>��¡�û�</td></tr></table></td></tr></table>',				//1
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>ɾ��</b></td><td align="center" nowrap>ɾ���û�</td></tr></table></td></tr></table>',				//2
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>Ȩ��</b></td><td align="center" nowrap>�޸��û�Ȩ��</td></tr></table></td></tr></table>',				//3
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>�༭</b></td><td align="center" nowrap>�༭��ɫ��Ϣ</td></tr></table></td></tr></table>',			//4
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>��¡</b></td><td align="center" nowrap>��¡��ɫ</td></tr></table></td></tr></table>',				//5
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>ɾ��</b></td><td align="center" nowrap>ɾ����ɫ</td></tr></table></td></tr></table>',				//6
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>�༭</b></td><td align="center" nowrap>�޸Ĳ�����Ϣ</td></tr></table></td></tr></table>',			//7
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>�����Ӳ���</b></td><td align="center" nowrap>�����ò��ŵ��Ӳ���</td></tr></table></td></tr></table>',		//8
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>�ƶ�</b></td><td align="center" nowrap>�ƶ��˲���</td></tr></table></td></tr></table>',			//9
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>ɾ��</b></td><td align="center" nowrap>ɾ���˲���</td></tr></table></td></tr></table>',			//10
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>��ʾ�û�</b></td><td align="center" nowrap>��ʾ�����û�</td></tr></table></td></tr></table>'			//11	
];

var myHint = new THints (HINTS_CFG, HINTS_ITEMS);

function wrap (s_, b_ques) {
	return "<table cellpadding='0' cellspacing='0' border='0' style='-moz-opacity:90%;filter:progid:DXImageTransform.Microsoft.dropShadow(Color=#777777,offX=4,offY=4)'><tr><td rowspan='2'><img src='img/1"+(b_ques?"q":"")+".gif'></td><td><img src='/img/pixel.gif' width='1' height='15'></td></tr><tr><td background='img/2.gif' height='28' nowrap>"+s_+"</td><td><img src='img/4.gif'></td></tr></table>"
}

function wrap_img (s_file, s_title) {
	return "<table cellpadding=5 bgcolor=white style='border:1px solid #777777'><tr><td><img src='img/k0"+s_file+".jpg' class='picI'></td></tr><tr><td align=center>"+s_title+"</td></tr></table>"
}
