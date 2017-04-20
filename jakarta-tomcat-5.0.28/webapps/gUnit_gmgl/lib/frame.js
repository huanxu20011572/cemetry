
var isShow=true;
function changeLeft(){
	var leftTab = document.all("leftTab");
	var contentTab = document.all("contentTab");
	var imgName = document.all("imgName");
	if(isShow==true){
		leftTab.style.display = 'none';
		contentTab.style.width='1024';
		isShow=false;
		imgName.src="../images/grbg2_01_11a.jpg";
	}else{
		leftTab.style.display = '';
		contentTab.style.width='99%';
		isShow=true;
		imgName.src="../images/grbg2_01_11.jpg";
	}
}
