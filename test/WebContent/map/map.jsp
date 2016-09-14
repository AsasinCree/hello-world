<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
	body, html {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	#allmap{height:500px;width:100%;}
	#r-result{width:100%; font-size:14px;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=faUNGntpPHmrr1UnYjCMkQW4"></script>
	<title>地图展示</title>
</head>
<body>
	<div id="allmap"></div>
	<div id="r-result">
		经度: <input id="longitude" type="text" style="width:100px; margin-right:10px;" />
		纬度: <input id="latitude" type="text" style="width:100px; margin-right:10px;" />
		<input type="button" value="查询" onclick="theLocation()" />
	</div>
	<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");    // 创建Map实例
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	
//	map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
	
	//单击获取点击的经纬度
	map.addEventListener("click",function(e){
		alert(e.point.lng + "," + e.point.lat);
	});
	
	// 用经纬度设置地图中心点
	function theLocation(){
		if(document.getElementById("longitude").value != "" && document.getElementById("latitude").value != ""){
			map.clearOverlays(); 
			var new_point = new BMap.Point(document.getElementById("longitude").value,document.getElementById("latitude").value);
			var marker = new BMap.Marker(new_point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			map.panTo(new_point);      
		}
	}
	</script>
</body>
</html>
