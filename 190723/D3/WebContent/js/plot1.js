window.addEventListener("load",function(){
	var svgWidth =320;	// SVG 요소의 넓이
	var svgHeight = 240;	// SVG 요소의 높이

	var dataSet = [
				  [30,40], [120,115], [125,90], [150,160], [300,190],
				  [60.40], [140,145], [165,110], [200,170], [250,190]
	];	//데이터셋
	
	
	// 산포도 그리기	
	var circleElements = d3.select("#myGraph")
	.selectAll("circle")	// circle 요소를 지정
	.data(dataSet) // 데이터를 요소에 연결
	.enter()	//데이터 추가
	.append("circle") // 데이터 수만큼 rect 요소가 추가됨
	.attr("class", "mark") // CSS클래스 설정
	.attr("cx", function(d,i){	
		return d[0]; // 최초 요소를 X 좌표로 함
	})
	.attr("cy",function(d,i){	// 
		return svgHeight -d[1]; // 2번째의 요소를 Y좌표로 함
	})
	.attr("r", 5)	// 반지름을 지정

});	// addEventListener() end



