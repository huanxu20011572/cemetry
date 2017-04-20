


function linkageSelect(options) {
	
	var bindEls	= new Array();
	var items	= null;
	
	// 默认参数
	var settings = {
		data		: null	,
		file		: null	,
		root		: '0'
	}; 
	
	// 自定义参数
	if(options) {  
		jQuery.extend(settings, options); 
	}
	
	if (settings.file) {	// 从外部文件获取数据
		jQuery.getJSON(settings.file , function(json) {
			items	= json;
			for(el_id in bindEls) {
				_bind(bindEls[el_id].element , bindEls[el_id].key , bindEls[el_id].value);
			}
		});
	} else if (typeof(settings.data) == 'object') {	// 直接传入的数据
		items	= settings.data;
	}

	/**
	 * 绑定元素
	 * @param {Object} element
	 * @param {Object} value
	 */
	function _bind(element , key , value) {
		
		// 查找自身id
		for (el_id in bindEls) {
			if (bindEls[el_id].element == element) {
				var self_id	= el_id;
			}
		}
		
		
		for(el_id in bindEls){
			
			// 为所有前面的对象增加onchange事件，onchange时，清空自身
			if (el_id < self_id){
				bindEls[el_id].element.change(function() {
					_fill(element);
				})
			}
			
		}
		
		// 为上一级对象增加onchange事件，以刷新自身列表
		if (self_id > 0) {
			bindEls[self_id-1].element.change(function() {
				var self_key	= $(this).val()?bindEls[self_id-1].key + ',' + $(this).val():'';
				bindEls[self_id].key	= self_key;
				_fill(element , self_key);
			});
		}
			
		_fill(element , key , value);
		
	}
	
	/**
	 * 填充option
	 * @param {Object} element
	 * @param {Object} key
	 * @param {Object} value
	 */
	function _fill(element , key , value) {
		element.empty();
		element.append('<option value="">请选择</option>');
		
		var json	= _find(key);
		var index	= 1;
		var selected_index	= 0;
		for(opt_value in json) {
			var opt_title	= json[opt_value];
			var selected	= '';
			if (opt_value == value) {
				selected_index	= index;
				selected		= 'selected="selected"';
			}
			var option	= $('<option value="' + opt_value + '" ' + selected + '>' + opt_title + '</option>');
			element.append(option);
			index++;
		}
		
		if (element[0]) {
			//IE6
			setTimeout(function(){
				element[0].options[selected_index].selected = true;
			}, 0);
			// 让FF选中默认项
			element[0].selectedIndex	= 0;
			element.attr('selectedIndex' , selected_index);
		}
		
	}
	
	/**
	 * 查找元素
	 * @param {Object} key
	 */
	function _find(key) {
		if(typeof(items[key]) == "undefined")
			return false;
		return items[key];
	}
	
	/**
	 * 获取对象
	 * @param {Object} element
	 */
	function _getEl(element) {
		if (typeof element == 'string') {
			return $(element);
		} else {
			return element;
		}
	}
	
	
	return {
		
		// 绑定元素
		bind	: function(element , value) {
			element	= _getEl(element);
			value	= value?value:'';
			
			// 对象关联的key
			var key	= bindEls.length ?
				bindEls[bindEls.length - 1].key + ',' + bindEls[bindEls.length - 1].value :
				settings.root;
			
			// 将绑定的元素放入数组
			bindEls.push({
				element	: element,
				key		: key,
				value	: value
			});
			
			if (items) {
				_bind(element , key , value);
			}
			
		}
	}
	
}