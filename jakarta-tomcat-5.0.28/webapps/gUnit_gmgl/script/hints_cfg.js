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
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>编辑</b></td><td align="center" nowrap>编辑用户信息</td></tr></table></td></tr></table>',			//0
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>克隆</b></td><td align="center" nowrap>克隆用户</td></tr></table></td></tr></table>',				//1
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>删除</b></td><td align="center" nowrap>删除用户</td></tr></table></td></tr></table>',				//2
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>权限</b></td><td align="center" nowrap>修改用户权限</td></tr></table></td></tr></table>',				//3
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>编辑</b></td><td align="center" nowrap>编辑角色信息</td></tr></table></td></tr></table>',			//4
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>克隆</b></td><td align="center" nowrap>克隆角色</td></tr></table></td></tr></table>',				//5
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>删除</b></td><td align="center" nowrap>删除角色</td></tr></table></td></tr></table>',				//6
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>编辑</b></td><td align="center" nowrap>修改部门信息</td></tr></table></td></tr></table>',			//7
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>创建子部门</b></td><td align="center" nowrap>创建该部门的子部门</td></tr></table></td></tr></table>',		//8
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>移动</b></td><td align="center" nowrap>移动此部门</td></tr></table></td></tr></table>',			//9
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>删除</b></td><td align="center" nowrap>删除此部门</td></tr></table></td></tr></table>',			//10
	'<table border="0" cellspacing="0" cellpadding="0" bgcolor="#4682B4"><tr><td><table border="0" cellspacing="1" cellpadding="3"><tr class="tr1"><td nowrap><b>显示用户</b></td><td align="center" nowrap>显示部门用户</td></tr></table></td></tr></table>'			//11	
];

var myHint = new THints (HINTS_CFG, HINTS_ITEMS);

function wrap (s_, b_ques) {
	return "<table cellpadding='0' cellspacing='0' border='0' style='-moz-opacity:90%;filter:progid:DXImageTransform.Microsoft.dropShadow(Color=#777777,offX=4,offY=4)'><tr><td rowspan='2'><img src='img/1"+(b_ques?"q":"")+".gif'></td><td><img src='/img/pixel.gif' width='1' height='15'></td></tr><tr><td background='img/2.gif' height='28' nowrap>"+s_+"</td><td><img src='img/4.gif'></td></tr></table>"
}

function wrap_img (s_file, s_title) {
	return "<table cellpadding=5 bgcolor=white style='border:1px solid #777777'><tr><td><img src='img/k0"+s_file+".jpg' class='picI'></td></tr><tr><td align=center>"+s_title+"</td></tr></table>"
}
