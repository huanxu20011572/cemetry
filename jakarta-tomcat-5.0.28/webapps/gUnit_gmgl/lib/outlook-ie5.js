
var os_currentGroup;

function os_showGroup(header) {
	var panel = header.parentNode.nextSibling.firstChild;
	if (os_currentGroup) os_currentGroup.className = 'groupPanelHidden';
	panel.className = 'groupPanel';
	os_currentGroup = panel;
}

function os_init() {
	os_result.innerHTML = os_data.transformNode( os_xsl.XMLDocument );
	os_showGroup( os_result.getElementsByTagName("TD")[0] );
}

