    //返回radio选中的顺序号，0－表没有选中,-1－表异常
    function indexOfChecked(radioItem){
        if(radioItem == null){
            return -1;
        }
        var size = radioItem.length;
        var checkflag = false;
        var index = 0;
        if(size > 1){
            if(radioItem[0].type != 'radio'){
                return -1;
            }
            for(var i = 0;i < size;i++){
                checkflag = radioItem[i].checked;
                if(checkflag){
                    index = i + 1;
                    break;
                }
            }
        }else{
            if(radioItem.type != 'radio'){
                return -1;
            }
            if(radioItem.checked){
                index = 1;
            }
        }
        return index;
    }