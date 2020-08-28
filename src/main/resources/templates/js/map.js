// 百度地图API功能
var map = new BMap.Map("lyMap");
var point = new BMap.Point(104.067086,30.578642);
map.centerAndZoom(point, 17);
var marker = new BMap.Marker(point);  // 创建标注
map.addOverlay(marker);               // 将标注添加到地图中
marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画