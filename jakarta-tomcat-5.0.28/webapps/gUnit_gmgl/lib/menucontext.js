function showToolbar()
{
// AddItem(id, text, hint, location, alternativeLocation);
// AddSubItem(idParent, text, hint, location); //���˵�����
menu = new Menu();
menu.addItem("portalsetting", "�Ż�����", "�����Ż�����", null, null);


//��ý���Ӳ˵�����
menu.addSubItem("portalsetting", "���ò���", "�����Ż�����", "http://localhost:8081/portal/columnLayout.do?action=edit&public=true&page=portalpage1");
menu.addSubItem("portalsetting", "����²���", "����Ż�����", "http://www.macromedia.com");
menu.addSubItem("portalsetting", "���÷��", "5D��ý��", "http://www.5dmedia.com");
menu.addSubItem("portalsetting", "����·��", "����Ż����", "http://www.5dmedia.com");
menu.addSubItem("portalsetting", "��ҳ", "", "http://localhost:8081/portal/showPortal.do?action=showAll&public=true&page=portalpage1");

//�����˵�����
menu.showMenu();
}