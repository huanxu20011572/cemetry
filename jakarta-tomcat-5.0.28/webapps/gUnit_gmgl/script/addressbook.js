function onAddressSubmit(path, fm) 
{ 
	window.open(path + "addressbook.jsp?chooseid=1&formname=" + fm.name + "&userid=" + fm.userid.value + "&in2="+fm.in2.value,"first","width=470,height=330"); 
} 