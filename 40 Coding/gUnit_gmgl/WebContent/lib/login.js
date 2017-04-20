// You can find instructions for this file at http://www.treeview.net

//Environment variables are usually set at the top of this file.
USETEXTLINKS = 1
STARTALLOPEN = 1
USEFRAMES = 0
USEICONS = 0
WRAPTEXT = 1
PERSERVESTATE = 1
HIGHLIGHT = 1


foldersTree = gFld("<b>所有用户</b>", "")
	aux1 = insFld(foldersTree, gFld("业务管理员", ""))
		insDoc(aux1, gLnk("S", "表单管理员", "login.do?action=login&username=mjzz&password=123&unitID=gTU_ywgl"))			
	
		

 