<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>클릭한 위치에 마커 표시하기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:700px;"></div>
<p><em>지도를 클릭해주세요!</em></p> 
<div id="clickLatlng"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=048d3839f2032025c0d6225330618498"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.50123113557268, 127.039593325687), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var mapTypeControl = new kakao.maps.MapTypeControl();// 지도 컨트롤 버튼 생성
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

/// 마커찍기start
var marker2 = new kakao.maps.Marker({
    position: new kakao.maps.LatLng(37.501199784802495, 127.0390391611555)
});

var marker3 = new kakao.maps.Marker({
    position: new kakao.maps.LatLng(37.50027261805745, 127.03631320881472)
});

marker2.setMap(map);

marker3.setMap(map);
/// 마커찍기 end


// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
  
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);  
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});



</script>
</body>
</html>