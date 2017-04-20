var Topsuntech = function() {};

Topsuntech.toPropertyStr = function(propertyName, propertyValue) {
	if(propertyName != null){
		return propertyName + '=' + '"' + propertyValue + '"';
	}
	return '';
};
Topsuntech.toPropertyStrFromMap = function(propertys) {
	if(propertys){
		var strBuf = [];
		for(var key in propertys) {
			if(key){
				var include = false;
				for(var i = 1; i < arguments.length; i++){
					if(key == arguments[i]){
						include = true;
						break;
					}
				}
				if(!include){
					strBuf[strBuf.length] = Topsuntech.toPropertyStr(" " + key, propertys[key]);	
				}
			}
		}
		return strBuf.join("");
	}
	return '';
};

Topsuntech.TreeNode = function(oData, oParent, expanded) { 
	    Topsuntech.TreeNode.superclass.constructor.call(this,oData,oParent,expanded);
};
YAHOO.extend(Topsuntech.TreeNode, YAHOO.widget.Node, {
	
	id: null,
	
	name: '',
	
	code: '',
	
	pId: null,
	
	nameLink: null,
	
	getNameHtml: function(){
		var sb = [];
		sb[sb.length] = '<span';
		sb[sb.length] = Topsuntech.toPropertyStr(" id", this.id + '_t_name');
		sb[sb.length] = '>';
		if(this.nameLink){
			sb[sb.length] = '<a';
			sb[sb.length] = Topsuntech.toPropertyStrFromMap(this.nameLink);
			sb[sb.length] = '>';
		}
		sb[sb.length] = this.name;
		if(this.nameLink){
			sb[sb.length] = '</a>';
		}
		sb[sb.length] = '</span>';
		return sb.join("");
	}
});

Topsuntech.LinksNode = function(oData, oParent, expanded) { 
	    Topsuntech.LinksNode.superclass.constructor.call(this,oData,oParent,expanded);
};
YAHOO.extend(Topsuntech.LinksNode, Topsuntech.TreeNode, {
	
	links: [],
	
	spaceStyle: 'margin-left: 10px',
	
	getContentHtml: function() {
		var sb = [];
		sb[sb.length] = '<td></td><td>';
		sb[sb.length] = this.getNameHtml();
		sb[sb.length] = '<span';
		sb[sb.length] = Topsuntech.toPropertyStr(" style", this.spaceStyle);
		sb[sb.length] = '></span>';
		for(var i in this.links) {
			sb[sb.length] = '<a';
			sb[sb.length] = Topsuntech.toPropertyStrFromMap(this.links[i], 'name');
			sb[sb.length] = '>';
			sb[sb.length] = this.links[i]['name'] != null ? this.links[i]['name'] : '';
			sb[sb.length] = '</a><span';
			sb[sb.length] = Topsuntech.toPropertyStr(" style", this.spaceStyle);
			sb[sb.length] = '></span>';
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
	
	inputPropertys: null,
	
	getContentHtml: function() {
		var sb = [];
		sb[sb.length] = '<td></td><td>';
		sb[sb.length] = '<input';
		sb[sb.length] = Topsuntech.toPropertyStr(" type", this.type);
		if(this.inputPropertys){
			sb[sb.length] = Topsuntech.toPropertyStrFromMap(this.inputPropertys, 'type');
		}else{
			sb[sb.length] = Topsuntech.toPropertyStr(" name", this.formName);
			sb[sb.length] = Topsuntech.toPropertyStr(" value", this.value);
		}
		sb[sb.length] = '/>';
		sb[sb.length] = this.getNameHtml();
		sb[sb.length] = '</td>';
    	return sb.join("");                                                                                                                   
	}   
});

Topsuntech.TreeView = function(divId, buildMode) {
	this.divId = divId;
	this.buildMode = buildMode ? buildMode : 'pId';
	this.allNode = {};
	this.treeView = null;
	this.rootNodeName = null;
	this.rootNodeContentStyle = null;
	this.rootNodeLink = null;
	this.preloadUrl = null;
	this.preloadPostData = null;
	this.getChildUrl = null;
	this.getChildPostData = null;
};
Topsuntech.TreeView.prototype = {
	BUILD_MODE_PID: 'pId',
	
	BUILD_MODE_CHILDREN: 'children',
	
	getNodeById: function(id){
		return this.allNode[id];
	},
	
	createNode: function(){},
	
	processNewNode: function(newNode, nodeData){
		newNode.id = nodeData.id;
		this.allNode[newNode.id] = newNode;
	},
	
	buildNodeFromData: function(nodeData, pNode){
		var newNode = this.createNode(nodeData, pNode);
		this.processNewNode(newNode, nodeData);
		if(nodeData.children && nodeData.children.length > 0){
			newNode.expanded = true;
			for(var i = 0; i < nodeData.children.length; i++){
				this.buildNodeFromData(nodeData.children[i], newNode);
			}
		}else{
			var thisTreeView = this;
			newNode.setDynamicLoad(function(node, fnLoadComplete){ thisTreeView.loadNodeData(node, fnLoadComplete) });	
		}
	},
	
	buildTreeNodesByChildren: function(nodeData, pNode){
		if(nodeData == null){
			return;
		}
		if(nodeData.length != null){
			for(var i = 0; i < nodeData.length; i++){
				this.buildNodeFromData(nodeData[i], pNode);
			}
		}else{
			this.buildNodeFromData(nodeData, pNode);
		}
	},
	
	buildTreeNodesByPId: function(nodeData, pNode){
		var nodeMap = {};
		var pn = null;
		for(var i = 0; i < nodeData.length; i++){
			pn = nodeMap[nodeData[i].pId];
			if(pn == null){
				pn = pNode;
			}
			var newNode = this.createNode(nodeData[i], pn);
			this.processNewNode(newNode, nodeData[i]);
			nodeMap[newNode.id] = newNode;
		}
		for(var key in nodeMap){
			var tNode = nodeMap[key];
			if(tNode.children && tNode.children.length > 0){
				tNode.expanded = true;
			}else{
				var thisTreeView = this;
				tNode.setDynamicLoad(function(node, fnLoadComplete){ thisTreeView.loadNodeData(node, fnLoadComplete) });	
			}
		}
	},
	
	loadNodeDataCallback: null,
	
	loadNodeData: function(node, fnLoadComplete){
		var thisTreeView = this;
		if(this.getChildUrl){
			if(this.getChildPostData == null){
				this.getChildPostData = {};
			}
			this.getChildPostData.nodeId = node.id;
			
			$.post(this.getChildUrl, this.getChildPostData, function(data){
				thisTreeView.buildTree(data, node);
				fnLoadComplete();
				if(thisTreeView.loadNodeDataCallback){
					thisTreeView.loadNodeDataCallback();
				}
			}, "json");
		}else{
			fnLoadComplete();
			if(this.loadNodeDataCallback){
				this.loadNodeDataCallback();
			}
		}
	},
	
	buildTree: function(data, node){
		if(this.buildMode == this.BUILD_MODE_PID){
			this.buildTreeNodesByPId(data, node);
		}else if(this.buildMode == this.BUILD_MODE_CHILDREN){
			this.buildTreeNodesByChildren(data, node);
		}
	},
	
	preLoadNodeDataCallback: null,
	
	drawTree: function(treeData){
		if(this.treeView){
			this.destroy();
		}
		
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
		
		if(treeData){
			this.buildTree(treeData, rootNode);
			this.treeView.draw();
			if(this.preLoadNodeDataCallback){
				this.preLoadNodeDataCallback();
			}
			return;
		}
		
		var thisTreeView = this;
		//_treeView.setDynamicLoad(_loadNodeData);
		if(this.preloadUrl){
			$.post(this.preloadUrl, this.preloadPostData , function(data){
				thisTreeView.buildTree(data, rootNode);
				//rootNode.expand();
				thisTreeView.treeView.draw();
				if(thisTreeView.preLoadNodeDataCallback){
					thisTreeView.preLoadNodeDataCallback();
				}
	  		}, "json");
		}
		
	},
	
	destroy: function(){this.treeView.destroy()}
};

Topsuntech.OneSNodeCheckboxTree = function(divId) {
	this.treeView = new Topsuntech.TreeView(divId);
	
	var thisOneSNodeCheckboxTree = this;
	this.treeView.createNode = function(nodeData, parentNode){
		return thisOneSNodeCheckboxTree.doCreateNode(nodeData, parentNode);
	};
	
	this.checkedIds = null;
	this.treeView.preLoadNodeDataCallback = function(){
		thisOneSNodeCheckboxTree.doAllLoadNodeDataCallback();
		thisOneSNodeCheckboxTree.checkChbox(thisOneSNodeCheckboxTree.checkedIds);
	};
	this.treeView.loadNodeDataCallback = function(){
		thisOneSNodeCheckboxTree.doAllLoadNodeDataCallback();
	};
};
Topsuntech.OneSNodeCheckboxTree.prototype = {
	chboxIdPostfix: '_chbox',
	
	chboxName: '_n_chbox',
	
	doCreateNode: function(nodeData, parentNode){
		var inputNode = new Topsuntech.InputNode("l" + nodeData.id, parentNode, false);
	  	inputNode.type = 'checkbox';
	  	inputNode.name = nodeData.name;
	  	inputNode.inputPropertys = {id: nodeData.id + this.chboxIdPostfix, name: this.chboxName, value: nodeData.id };
	  	var pChbox = $("#" + parentNode.id + this.chboxIdPostfix).get(0);
	  	var disabled = pChbox && (pChbox.disabled || pChbox.checked);
	  	if(disabled){
	  		inputNode.inputPropertys.disabled = 'disabled';
	  	}
	  	return inputNode;
	},
	
	checkChbox: function(checkedIds){
		for(var i = 0; checkedIds && i < checkedIds.length; i++){
			if(checkedIds[i]){
				$("#" + checkedIds[i] + this.chboxIdPostfix).attr( 'checked', true );
				$("#" + checkedIds[i] + '_t_name').css('color', 'blue');
			}
		}
	},
	
	doAllLoadNodeDataCallback: function(){
		var thisOneSNodeCheckboxTree = this;
		$(":checkbox[name='" + this.chboxName + "']").unbind().click(function(){
			var id = this.value;
			$("#" + id + '_t_name').css('color', this.checked ? 'blue' : '');
			
			var node = thisOneSNodeCheckboxTree.treeView.getNodeById(id);
			var children = node ? node.children : [];
			
			while(children && children.length > 0){
				var ctNode = [];
				for(var i = 0; i < children.length; i++){
					$("#" + children[i].id + thisOneSNodeCheckboxTree.chboxIdPostfix).attr('checked', false);
					$("#" + children[i].id + '_t_name').css('color', '');
					$("#" + children[i].id + thisOneSNodeCheckboxTree.chboxIdPostfix).attr('disabled', this.checked);
					
					for(var j = 0; j < children[i].children.length; j++){
						ctNode[ctNode.length] = children[i].children[j];	
					}
				}
				children = ctNode;
			}
		});
	},
	
	draw: function(treeData, checkedIds){
		if(checkedIds != null){
			this.checkedIds = checkedIds;			
		}
		this.treeView.drawTree(treeData);
	},
	
	getCheckedValueString: function(hasComma){
		if(hasComma == null){
			hasComma = true;
		}
		var valueStr = hasComma ? ',':'';
		var chboxs = document.getElementsByName(this.chboxName);
		for(var i = 0; i < chboxs.length; i++){
			if(chboxs[i].checked){
				valueStr += (chboxs[i].value + ',');
			}
		}
		return hasComma ? (valueStr == ',' ? '' : valueStr) : valueStr.substr(0, valueStr.length - 1);
	}
}