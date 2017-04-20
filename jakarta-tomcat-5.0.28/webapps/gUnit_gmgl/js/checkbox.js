/**
 * 将复选框的全选或全不选
 */	
function checkAll(checkall,subchecked)
{ 
  	var OnOffItem = document.getElementsByName(checkall)[0];
  	if (OnOffItem!=null)
  	{ 
    	var OnOff = OnOffItem.checked;
    	var theItem = document.getElementsByName(subchecked); 
    	if (theItem!=null)
    	{ 
      		if (typeof(theItem.value)=='undefined')
      		{ 
        		for (var i=0;i<theItem.length; i++)
        		{
          			var SubItem = theItem[i];
          			if(SubItem.disabled==false)
          			{ 
          				SubItem.checked = OnOff; 
          			}
        		} 
            }
            else
            { 
      			if(theItem.disabled==false)
      			{
        			theItem.checked = OnOff; 
        		}
      		} 
    	} 
  	} 
} 
/**
 * 将复选框的全选或全不选
 */	
function checkOne(checkall,subchecked)
{ 
  	var OnOffItem = document.getElementsByName(checkall)[0];
  	if (OnOffItem!=null)
  	{ 
    	var i_checked = 0;
    	var theItem = document.getElementsByName(subchecked); 
    	if (theItem!=null)
    	{
      		if (typeof(theItem.value)=='undefined')
      		{ 
        		for (var i=0;i < theItem.length; i++)
        		{ 
          			var SubItem = theItem[i]; 
          			if(SubItem.checked)
          			{
          				i_checked++;
          			}
        		} 
        		if(i_checked==theItem.length)
        		{
        			 OnOffItem.checked = true;
        		}else
        		{
        			OnOffItem.checked = false;
        		}
      		}
      		else
      		{ 
      			var o = theItem.checked;
        		OnOffItem.checked = o; 
      		} 
    	} 
  	} 
}
/**
 * 复选框:选择或取消选择所有
 * 设定已有:
 * <input type="checkbox" name="CbGroup" value="1" />
 * <input type="checkbox" name="CbGroup" value="2" />
 * ...
 * 使用 <input type="checkbox" name="CbSelectAll" id="CbSelectAll" onclick="selectAll('CbGroup', this.checked)" />
 * 即可设定选择或取消选择所有
 */
function selectAll(checkboxGroup, isChecked)
{
	var cbg = document.getElementsByName(checkboxGroup);
	if( cbg.length )
	{ 
		for(var i=0; i<cbg.length; i++)
		{
			if(cbg[i].disabled==false)
			{
				cbg[i].checked = isChecked;
			}
		}
	}
	else
	{
		if(cbg.disabled==false)
		{
			cbg.checked = isChecked;
		}
	}
}

/**
 * 复选框:更改全选选框状态
 * 设定已有:
 * <input type="checkbox" name="CbSelectAll" id="CbSelectAll" onclick="selectAll('CbGroup', this.checked)" />
 * 使用 
 * <input type="checkbox" name="CbGroup" value="1" onclick="selectOne('CbSelectAll', this)" />
 * <input type="checkbox" name="CbGroup" value="2" onclick="selectOne('CbSelectAll', this)" />
 * ...
 * 即可设定CbSelectAll的选择状态
 */
function selectOne(CbSelectAll, CbOne)
{
	var cbx = document.getElementById(CbSelectAll) || document.getElementsByName(CbSelectAll)[0];
	if ( !cbx ) return;

	if( !CbOne.checked )
	{
		cbx.checked = false;
	}
	else
	{
		var cbg = document.getElementsByName(CbOne.name);
		for(var i=0; i<cbg.length; i++)
		{
			if( !cbg[i].checked )
			{
				cbx.checked = false;
				return;
			}				
		}
		cbx.checked = true;
	}
}

/**
 * 复选框:取得所选复选框的id列,形如: (1, 3, 10)
 * 设定已有:
 * <input type="checkbox" name="CbGroup" value="1" />
 * <input type="checkbox" name="CbGroup" value="2" />
 * 被选择，则 getSelectedIds("CbGroup") 返回字符串"(1,2)"
 */
function getSelectedIds(checkboxGroup)
{
	var ids = ""; 
	var cbg = document.getElementsByName(checkboxGroup);
	if( !cbg ) return ids;

	if( cbg.length )
	{ 
		for(var i=0; i<cbg.length; i++)
		{
			if(cbg[i].checked )
			{
				ids += "," + cbg[i].value;
			}				
		}
	}
	else
	{
		if(cbg.checked )
		{
			ids +=  "," + cbg.value;
		}
	}
	if( ids!="" )
	{
		ids = ids.substring(1) ;
	}
	return ids;
}