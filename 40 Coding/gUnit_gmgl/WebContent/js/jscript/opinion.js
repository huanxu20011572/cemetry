/*****
**ͨ����˼����JS��
**********/
function OpinionHelp(){
//������϶���
this. opinionArray = new Array();
//��������
this. containerObj = null;
//Ŀ�����
this. targeObj = null;
//Դ����
this. sourceObj = null;
//���������CSS��ʽ
this. containerClass = "opinion";
//����DIV�����CSS��ʽ
this. elClass = "el";
//��꾭��ʱ����ɫ
this. selectedColor = "#AAD5FB";
//����߹������ɫ
this. unSelectedColor = "#FFFFFF";

};
//������
OpinionHelp.prototype.putOpinion=function(opinion){
var divObj = document.createElement("DIV");

//divObj.innerText = opinion;
divObj.innerHTML = opinion;
this.opinionArray[this.opinionArray.length]=divObj;
divObj.className=this.elClass;
divObj.onclick = bindFunction(this,"setValue")
//divObj.onmouseover = bindFunction(this,"foucsOfDiv");
}
function  bindFunction(el, fucName) {
     return   function  () {
		 //el��ʾӰ�������ĵĶ��� ͨ�������滻���÷����е�this��arguments �ö����������ִ�еĺ����͵������ĺ����Ĳ���
         //Call��ʾ ����ĳһ�����һ������������һ�������滻��ǰ���� ��ʽ��call([thisObj[,arg1[, arg2[,   [,.argN]]]]])
		 //return  el[fucName].call(el);
		 //Apply��ʾ Ӧ��ĳһ�����һ������������һ�������滻��ǰ���� ��ʽ��apply([thisObj[,argArray]])
		 return el[fucName].apply(el,arguments);
    };
};


//��ʼ��Ŀ���������������
OpinionHelp.prototype.init=function(_sourceObj,_targeObj){
if(this.targeObj == null){
  this. _sourceObj = _sourceObj;
  this. targetObj = _targeObj;

}

if(this.containerObj == null){
   this.containerObj = document.createElement("DIV");
   this.containerObj.className = this.containerClass;
   for(var i=0 ;i<this.opinionArray.length;i++){
	this.containerObj.appendChild(this.opinionArray[i]);
   }

   this.containerObj.style.top=this.getOffset(_sourceObj,false)+20;
   this.containerObj.style.left=this.getOffset(_sourceObj,true);
   this.containerObj.style.display="none";
   document.body.appendChild(this.containerObj);
}
}
//��ʾ������Ϣ
OpinionHelp.prototype.show = function(){
this.containerObj.style.display=(this.containerObj.style.display==""?"none":"");
//alert(this.containerObj.style.height);
}
//���ذ�����Ϣ
OpinionHelp.prototype.hidden = function(){
this.containerObj.style.display="none";
}

//�õ�����
 OpinionHelp.prototype.foucsOfDiv = function(){
	  var eobj
	  event.cancelBubble=true;//ȡ���¼���ð�ݶ���
	  eobj=event.srcElement;//��ȡ�����¼��Ķ���
	  for(var i=0;i<this.opinionArray.length;){
	    this.opinionArray[i++].style.background=this.unSelectedColor;
	  }
	  eobj.style.background = this.selectedColor;
}
//��ֵ����
OpinionHelp.prototype.setValue = function(){
      var eobj
	  event.cancelBubble=true;//ȡ���¼���ð�ݶ���
	  eobj=event.srcElement;//��ȡ�����¼��Ķ���
	 // alert(eobj.previousSibling);
	  // alert(eobj.tagName);
	 // this.targetObj.value = eobj.innerText;
	 // this.hidden();
	 if(eobj.tagName == "DIV")
		 eobj = eobj.firstChild;
	 if(eobj.tagName == "INPUT"){
		 eobj.click();// == (eobj.checked?false:true);
	 }else if(eobj.tagName == undefined) {
	 	
	 	this.targetObj.value=eobj.nodeValue;
	 	this.hidden();
	 }
	 
	 /********
	 var inputs = this.containerObj.getElementsByTagName("INPUT");
	 this.targetObj.value="";
	 for(var i=0;i<inputs.length;i++){
		  if(inputs[i].checked){
			 if(this.targetObj.value.length>0)
				 this.targetObj.value+=",";
			 this.targetObj.value +=inputs[i].value;
		  }
	 }
	 ********/
}
//��ȡ����ľ���λ��
OpinionHelp.prototype.getOffset = function(el,isLeft){
	var retValue = 0;
	while(el != null){
	   retValue+=el["offset"+(isLeft ? "Left" : "Top")];
	   el = el.offsetParent;
	}
	return retValue;
}

