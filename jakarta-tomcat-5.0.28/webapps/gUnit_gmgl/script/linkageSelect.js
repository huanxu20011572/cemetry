


function linkageSelect(options) {
	
	var bindEls	= new Array();
	var items	= null;
	
	// Ĭ�ϲ���
	var settings = {
		data		: null	,
		file		: null	,
		root		: '0'
	}; 
	
	// �Զ������
	if(options) {  
		jQuery.extend(settings, options); 
	}
	
	if (settings.file) {	// ���ⲿ�ļ���ȡ����
		jQuery.getJSON(settings.file , function(json) {
			items	= json;
			for(el_id in bindEls) {
				_bind(bindEls[el_id].element , bindEls[el_id].key , bindEls[el_id].value);
			}
		});
	} else if (typeof(settings.data) == 'object') {	// ֱ�Ӵ��������
		items	= settings.data;
	}

	/**
	 * ��Ԫ��
	 * @param {Object} element
	 * @param {Object} value
	 */
	function _bind(element , key , value) {
		
		// ��������id
		for (el_id in bindEls) {
			if (bindEls[el_id].element == element) {
				var self_id	= el_id;
			}
		}
		
		
		for(el_id in bindEls){
			
			// Ϊ����ǰ��Ķ�������onchange�¼���onchangeʱ���������
			if (el_id < self_id){
				bindEls[el_id].element.change(function() {
					_fill(element);
				})
			}
			
		}
		
		// Ϊ��һ����������onchange�¼�����ˢ�������б�
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
	 * ���option
	 * @param {Object} element
	 * @param {Object} key
	 * @param {Object} value
	 */
	function _fill(element , key , value) {
		element.empty();
		element.append('<option value="">��ѡ��</option>');
		
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
			// ��FFѡ��Ĭ����
			element[0].selectedIndex	= 0;
			element.attr('selectedIndex' , selected_index);
		}
		
	}
	
	/**
	 * ����Ԫ��
	 * @param {Object} key
	 */
	function _find(key) {
		if(typeof(items[key]) == "undefined")
			return false;
		return items[key];
	}
	
	/**
	 * ��ȡ����
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
		
		// ��Ԫ��
		bind	: function(element , value) {
			element	= _getEl(element);
			value	= value?value:'';
			
			// ���������key
			var key	= bindEls.length ?
				bindEls[bindEls.length - 1].key + ',' + bindEls[bindEls.length - 1].value :
				settings.root;
			
			// ���󶨵�Ԫ�ط�������
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