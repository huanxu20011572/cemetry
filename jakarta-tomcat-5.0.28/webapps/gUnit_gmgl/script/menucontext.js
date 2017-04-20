function showToolbar()
{
// AddItem(id, text, hint, location, alternativeLocation);
// AddSubItem(idParent, text, hint, location); //主菜单定义
menu = new Menu();
menu.addItem("portalsetting", "门户设置", "设置门户布局", null, null);


//多媒体子菜单定义
menu.addSubItem("portalsetting", "设置布局", "设置门户布局", "http://localhost:8081/portal/columnLayout.do?action=edit&public=true&page=portalpage1");
menu.addSubItem("portalsetting", "设计新布局", "设计门户布局", "http://www.macromedia.com");
menu.addSubItem("portalsetting", "设置风格", "5D多媒体", "http://www.5dmedia.com");
menu.addSubItem("portalsetting", "设计新风格", "设计门户风格", "http://www.5dmedia.com");
menu.addSubItem("portalsetting", "首页", "", "http://localhost:8081/portal/showPortal.do?action=showAll&public=true&page=portalpage1");

//结束菜单定义
menu.showMenu();
}