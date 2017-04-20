function showGroup(name) {
	currentGroup = name;
	var reachedItem = false;
	var headerHeight = 22;
	for ( var i = 0; i < groups.length; i++ ) {
		var g = groups[i];
		var lyr = document.layers["outlook"].document.layers[g];
		var cnt = lyr.document.layers["content"];
		lyr.top = reachedItem  
			? document.layers["outlook"].clip.height 
			  - ( headerHeight * ( groups.length - i ) ) - 5 
			: headerHeight * i;
		if ( name == g ) reachedItem = true;
		cnt.clip.height = document.layers["outlook"].clip.height 
			          - (headerHeight * (groups.length + 1)) - 9;
		cnt.visibility = name == g ? "show" : "hidden";

	}

/*	var up = document.layers["outlook"].document.layers["arrowUp"];
	var down = document.layers["outlook"].document.layers["arrowDown"];
	up.visibility = "hidden";
	down.visibility = "hidden";
	var groupPane = document.layers["outlook"].document.layers[name];
	alert(groupPane.clip.height+ ","+groupPane.document.height);
	if ( groupPane.clip.height > groupPane.document.height ) {
		alert(1);
		up.visibility = "show";
		down.visibility = "show";
		up.left = 20;
		up.top = 40;
	}
*/

}

function refreshGroups() {
	if ( currentGroup == -1 ) currentGroup = groups[0];
	showGroup( currentGroup );
}

var groups = new Array();
var currentGroup = -1;

onresize = refreshGroups;
