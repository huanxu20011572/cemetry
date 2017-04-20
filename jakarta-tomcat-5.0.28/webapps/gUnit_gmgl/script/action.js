function os_itemClick(item) {
	if (item.action) {
		var f = new Function(item.action);
		if (!f()) return false;
	}
	if (item.href) {
		var target = item.target ? findFrame(top, item.target) : document;
		if (target) {
			target.location.href = item.href;
		}
		else {
			window.open(item.href, item.target);
		}
	}
}

function findFrame(f, name) {
	if (f.name == name) return f;
	for (var i=0; i<f.frames.length; i++) {
		var result = findFrame(f.frames(i),name);
		if (result) return result;
	}
}
