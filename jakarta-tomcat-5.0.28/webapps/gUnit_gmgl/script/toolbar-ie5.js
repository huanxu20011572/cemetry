function init(result, data) {
	result.innerHTML = data.transformNode( xsl.XMLDocument );
}

function buttonOver(b) {
	if (currentButton!=b) b.className = 'buttonOver';
}

function buttonOut(b) {
	if (currentButton!=b) b.className = 'buttonOut';
}

function buttonDown(b) {
	b.className = 'buttonDown';
}

function buttonClick(b) {
	if (currentButton) currentButton.className = 'buttonOut';
	b.className = 'buttonSelected';
	currentButton = b;
}

function os_init_toolbar() {
	var e = window.event.srcElement;
	init( document.all[e.id+'_result'] , e );
}

var currentButton;
