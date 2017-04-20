// JavaScript Document
var zIndex = 999;
function initialize() {  
	var map = new BMap.Map('map');
	map.centerAndZoom("天津",12);	
	map.addControl(new BMap.NavigationControl());  
	map.addControl(new BMap.ScaleControl());  
	map.addControl(new BMap.OverviewMapControl());  
	map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_SATELLITE_MAP]}));
	
	ComplexCustomOverlay.prototype = new BMap.Overlay();

	ComplexCustomOverlay.prototype.initialize = function(map){
		this._map = map;
		var div = this._div = document.createElement("div");
		div.style.position = "absolute";
		div.style.zIndex = BMap.Overlay.getZIndex(this._point.lat);
		div.style.width = "225px"; 
		div.style.height = "145px"; 
		div.style.background = "url('../images/bg-tanchuang.png') left center no-repeat"; 
		div.style.color = "#15729e" 
		div.style.lineHeight = "18px";
		div.style.whiteSpace = "nowrap";
		div.style.MozUserSelect = "none";
		div.style.fontSize = "12px"
		
		var title = document.createElement("div");
		title.style.width = "90px"; 
		title.style.height = "30px"; 
		title.style.fontSize = "14px"; 
		title.style.fontWeight = "bold"; 
		title.style.lineHeight = "30px"; 
		title.style.position = "absolute"; 
		title.style.left = "80px"; 
		title.style.top = "13px";
		div.appendChild(title);
		title.innerText = this._title;
		
		var content = document.createElement("div");
		content.style.width = "135px"; 
		content.style.fontSize = "12px";  
		content.style.position = "absolute"; 
		content.style.left = "50px"; 
		content.style.top = "45px";
		div.appendChild(content);
		content.innerHTML = this._content
		
		var that = this;
		
		/*var arrow = this._arrow = document.createElement("div");
		arrow.style.background = "url(http://map.baidu.com/fwmap/upload/r/map/fwmap/static/house/images/label.png) no-repeat";
		arrow.style.position = "absolute";
		arrow.style.width = "11px";
		arrow.style.height = "10px";
		arrow.style.top = "84px";
		arrow.style.left = "10px";
		arrow.style.overflow = "hidden";
		div.appendChild(arrow);		*/
		
		/*div.onmouseover = function(){
			this.style.backgroundColor = "#6BADCA";
			this.style.borderColor = "#0000ff";
			this.getElementsByTagName("span")[0].innerHTML = that._overText;
			arrow.style.backgroundPosition = "0px -20px";
		}*/
		div.onclick = function(){
			zIndex++;
			this.style.zIndex = zIndex;
		}
		
		/*div.onmouseout = function(){
			this.style.backgroundColor = "#EE5D5B";
			this.style.borderColor = "#BC3B3A";
			this.getElementsByTagName("span")[0].innerHTML = that._text;
			arrow.style.backgroundPosition = "0px 0px";
		}*/
		
		map.getPanes().labelPane.appendChild(div);      
		return div;
	}
	
	ComplexCustomOverlay.prototype.draw = function(){
		var map = this._map;
		var pixel = map.pointToOverlayPixel(this._point);
		this._div.style.left = pixel.x;
		this._div.style.top  = pixel.y - 30 + "px";
	}

	
	// 创建地址解析器实例  
	var myGeo = new BMap.Geocoder(); 
	
	$("div[id=results]").each(function(i){
		var area = $(this).children()[0].value;
		var content = $(this).children()[1].innerHTML;
		content = "<ul>" + content + "</ul>";
		
		// 将地址解析结果显示在地图上，并调整地图视野  
		myGeo.getPoint(area, function(point){  
			if (point) {
			   createWindow(area, map, point, content)
			} 
		}, "天津"); 
	});
	
	resizeFrame();
} 

function loadScript(){  
	var script = document.createElement("script");
	script.src = "http://api.map.baidu.com/api?v=1.3&callback=initialize&services=false";
	document.body.appendChild(script);
}

function createWindow(title, map, point, content){
    var myCompOverlay = new ComplexCustomOverlay(point, title, content);
    map.addOverlay(myCompOverlay);
}


function resizeFrame(){
	parent.document.all.tableFrame.style.height = document.body.scrollHeight;
}

function ComplexCustomOverlay(point, title, content){
	this._point = point;
	this._title = title;
	this._content = content;
}

window.onload = loadScript;