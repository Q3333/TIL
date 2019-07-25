window.addEventListener("load",function(){
var svgWidth =320;	//SVG요소의 넓이
var svgHeight =240;	//SVG요소의 높이
var offsetX = 30;
var offsetY = 20;
var scale = 2.0;
var dataSet1 = [10,47,65,8,64,99,75,22,63,80];	//데이터셋
var dataSet2 = [90,77,55,48,64,90,85,42,13,40];	
var dataSet3 = [50,27,45,58,84,70,45,22,30,90];	
var margin = svgWidth/(dataSet1.length - 1); // 꺾은 선 그래프의 간격 계산
drawGraph(dataSet1, "itemA");	//itemA의 꺽은선 그래프 표시
drawGraph(dataSet2, "itemB");	//itemB의 꺽은선 그래프 표시
drawGraph(dataSet3, "itemC");	//itemC의 꺽은선 그래프 표시
drawScale();	//눈금 표시


//꺾은 선 그래프의 좌표를 계산하는 메소드
function drawGraph(dataSet, cssClassName){
	//꺽은선 그래프의 좌표를 계산하는 메소드
	var line = d3.line()	//svg의 선
	.x(function(d,i){					//X 좌표는 표시 순서x 간격
		return  offsetX + i * margin;	//X는 꺽은선 따라 움직이기 때문에 index * margin 으로
	})									//marign(전체길이/데이터셋갯수나누기) 을 더해준다.)
	.y(function(d,i){
		return svgHeight - (d * scale) - offsetY;	//데이터로부터 Y 좌표 빼기
	})												//y는고정이라 i(index)안씀.
	
	//꺾은 선 그래프 그리기
	var LineElements = d3.select("#myGraph")
	.append("path")			//데이터 수만큼 path 요소가 추가됨
	.attr("class", "line " + cssClassName)		// CSS 클래스 지정
	.attr("d", line(dataSet))		//연속선 지정
	
}


function drawScale(){

	//눈금을 표시하기 위한 스케일 설정
	var yScale = d3.scaleLinear() // 스케일 설정
	.domain([0,100])	// 원래 크기
	.range([scale*100, 0])	// 실제 출력 크기
	
	//눈금의 표시 위치를 왼쪽으로 지정
	var axis = d3.axisLeft(yScale)

	//눈금을 설정하여 표시
	d3.select("#myGraph").append("g")
	.attr("class", "axis")
	.attr("transform", "translate("+offsetX+", "+offsetY+")")	//눈금을 오프셋 X,Y만큼 움직여준다.
	.call(axis)
	
	// 가로 방향의 선을 표시
	d3.select("#myGraph")
	  .append("rect")	
	  .attr("class", "axis_x")	
	  .attr("width", svgWidth)	
	  .attr("height", 1)	// 
	  .attr("transform", "translate("+offsetX+", "+(svgHeight-offsetY-0.5)+")")	
}	
	
	

});	// addEventListener() end



