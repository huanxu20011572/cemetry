var Topsuntech = function() {};

Topsuntech.addProperty = function(propertyName, propertyValue) {
	if(propertyName != null){
		return propertyName + '=' + '"' + propertyValue + '"';
	}
	return '';
};

Topsuntech.TreeNode = function(oData, oParent, expanded) { 
	    Topsuntech.TreeNode.superclass.constructor.call(this,oData,oParent,expanded);
};
YAHOO.extend(Topsuntech.TreeNode, YAHOO.widget.Node, {
	
	id: null,
	
	name: '',
	
	code: ''
});

Topsuntech.LinksNode = function(oData, oParent, expanded) { 
	    Topsuntech.LinksNode.superclass.constructor.call(this,oData,oParent,expanded);
};
YAHOO.extend(Topsuntech.LinksNode, Topsuntech.TreeNode, {
	
	links: [],
	
	getContentHtml: function() {
		var sb = [];
		sb[sb.length] = '<td></td><td>';
		sb[sb.length] = this.name;
		sb[sb.length] = '&nbsp;';
		for(var i in this.links) {
			sb[sb.length] = '<a';
			sb[sb.length] = Topsuntech.addProperty(" href", this.links[i]['href']);
			sb[sb.length] = Topsuntech.addProperty(" target", this.links[i]['target']);
			sb[sb.length] = '>';
			sb[sb.length] = this.links[i]['name'] != null ? this.links[i]['name'] : '';
			sb[sb.length] = '</a>';
			sb[sb.length] = '&nbsp;';
		}
		sb[sb.length] = '</td>';
    	return sb.join("");                                                                                                                   
	}   
});

Topsuntech.InputNode = function(oData, oParent, expanded) { 
	    Topsuntech.InputNode.superclass.constructor.call(this,oData,oParent,expanded);
};
YAHOO.extend(Topsuntech.InputNode, Topsuntech.TreeNode, {
	
	type: null,
	
	formName: null,
	
	value: null,
	
	getContentHtml: function() {
		var sb = [];
		sb[sb.length] = '<td></td><td>';
		sb[sb.length] = '<input';
		sb[sb.length] = Topsuntech.addProperty(" type", this.type);
		sb[sb.length] = Topsuntech.addProperty(" name", this.formName);
		sb[sb.length] = Topsuntech.addProperty(" value", this.value);
		sb[sb.length] = '/>';
		sb[sb.length] = this.name;
		sb[sb.length] = '</td>';
    	return sb.join("");                                                                                                                   
	}   
});

Topsuntech.TreeView = function() {};

Topsuntech.TreeView.prototype = {
	
	divId: null,
	
	treeView: null,
	
	rootNodeName: null,
	
	rootNodeContentStyle: null,
	
	rootNodeLink: null,
	
	preloadUrl: '',
	
	getChildUrl: '',
	
	createNode: function(){},
	
	loadNodeData: function(node, fnLoadComplete){
		$.post(node._n_getChildUrl, { nodeId: node.id },
		function(data){
			if(data != null){
				for(var i=0; i<data.length; i++) {
					var newNode = node._n_createNode(data[i], node);
					newNode._n_getChildUrl = node._n_getChildUrl;
					newNode._n_createNode = node._n_createNode;
					newNode._n_loadNodeData = node._n_loadNodeData;
					newNode.setDynamicLoad(node._n_loadNodeData);
				}
			}
			fnLoadComplete();
		}, "json");
	},
	
	drawTree: function(){
		this.treeView = new YAHOO.widget.TreeView(this.divId);
		var rootNode = this.treeView.getRoot();
		if(this.rootNodeName != null){
			rootNode = new Topsuntech.LinksNode(this.rootNodeName, this.treeView.getRoot(), true);
			rootNode.name = this.rootNodeName;
			if(this.rootNodeContentStyle != null){
				rootNode.contentStyle = this.rootNodeContentStyle;				
			}
			if(this.rootNodeLink != null){
				rootNode.links = this.rootNodeLink;
			}
		}
		
		var _treeView = this.treeView;
		var _getChildUrl = this.getChildUrl;
		var _createNode = this.createNode;
		var _loadNodeData = this.loadNodeData;
		//_treeView.setDynamicLoad(_loadNodeData);
		$.post(this.preloadUrl, {}, function(data){
				if(data != null){
					for(var i=0; i<data.length; i++) {
						var newNode = _createNode(data[i], rootNode);
						newNode._n_getChildUrl = _getChildUrl;
						newNode._n_createNode = _createNode;
						newNode._n_loadNodeData = _loadNodeData;
						newNode.setDynamicLoad(_loadNodeData);
					}
				}
				//rootNode.expand();
				_treeView.draw();
	  		}, "json");
	}
	
};