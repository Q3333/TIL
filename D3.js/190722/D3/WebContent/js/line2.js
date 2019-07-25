window.addEventListener("load",function(){
var svgWidth =320;	//SVG요소의 넓이
var svgHeight =240;	//SVG요소의 높이
var offsetX = 30;
var offsetY = 20;
var scale = 2.0;
var dataSet = [10,47,65,8,64,99,75,22,63,80];	//데이터셋
var margin = svgWidth/(dataSet.length - 1); // 꺾은 선 그래프의 간격 계산

//꺾은 선 그래프의 좌표를 계산하는 메소드
var line = d3.line()	//svg의 선
	.x(function(d,i){
		return  offsetX + i * margin;	//X 좌표는 표시 순서x 간격
	})
	.y(function(d,i){
		return svgHeight - (d * scale) - offsetY;	//데이터로부터 Y 좌표 빼기
	})
	
	//꺾은 선 그래프 그리기
	var LineElements = d3.select("#myGraph")
	.append("path")			//데이터 수만큼 path 요소가 추가됨
	.attr("class", "line")		// CSS 클래스 지정
	.attr("d", line(dataSet))		//연속선 지정
	
	//눈금을 표시하기 위한 스케일 설정
	var yScale = d3.scaleLinear() // 스케일 설정
	.domain([0,100])	// 원래 크기
	.range([scale*100,0])	// 실제 출력 크기
	
	//눈금의 표시 위치를 왼쪽으로 지정
	var axis = d3.axisLeft(yScale)
	.ticks(10) // 눈금간격
	.tickValues([0,10,20,30,40,50,60,70,80,90,100])
	
	//눈금을 설정하여 표시
	d3.select("#myGraph").append("g")
	.attr("class", "axis")
	.attr("transform", "translate("+offsetX+", "+offsetY+")")
	.call(axis)
	
	d3.select("#myGraph")
	  .append("rect")	
	  .attr("class", "axis_x")	
	  .attr("width", svgWidth)	
	  .attr("height", 1)	// 
	  .attr("transform", "translate("+offsetX+", "+(svgHeight-offsetY-0.5)+")")	
	

});	// addEventListener() end



