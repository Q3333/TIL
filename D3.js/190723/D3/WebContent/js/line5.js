window.addEventListener("load",function(){
var svgWidth =740;	//SVG요소의 넓이, 원래는 320
var svgHeight =300;	//SVG요소의 높이
var offsetX = 30;
var offsetY = 20;
var scale = 2.0;


var dataSet = [
	[
	{ year :2004, value : 10 },
	{ year :2005, value : 47 },
	{ year :2006, value : 65},
	{ year :2007, value : 8 },
	{ year :2008, value : 64 },
	
	{ year :2009, value : 99 },
	{ year :2010, value : 75 },
	{ year :2011, value : 22 },
	{ year :2012, value : 63 },
	{ year :2013, value : 80 }
	],
	
	[
		{ year :2004, value : 90 },
		{ year :2005, value : 77 },
		{ year :2006, value : 55},
		{ year :2007, value : 48},
		{ year :2008, value : 64},
		
		{ year :2009, value : 90},
		{ year :2010, value : 85},
		{ year :2011, value : 42},
		{ year :2012, value : 13},
		{ year :2013, value : 40 }
			
	],
	
	[
		{ year :2004, value : 50},
		{ year :2005, value : 27 },
		{ year :2006, value : 45},
		{ year :2007, value : 58},
		{ year :2008, value : 84},
		
		{ year :2009, value : 70},		
		{ year :2010, value : 45},
		{ year :2011, value : 22},
		{ year :2012, value : 30},
		{ year :2013, value : 90 }
		
	]

	
	];	//데이터셋

var margin = svgWidth/(dataSet[0].length - 1); // 꺾은 선 그래프의 간격 계산
drawGraph(dataSet[0], "itemA");	//itemA의 꺽은선 그래프 표시
drawGraph(dataSet[1], "itemB");	//itemB의 꺽은선 그래프 표시
drawGraph(dataSet[2], "itemC");	//itemC의 꺽은선 그래프 표시
drawScale();	//눈금 표시


//꺾은 선 그래프의 좌표를 계산하는 메소드
function drawGraph(dataSet, cssClassName){
	//꺽은선 그래프의 좌표를 계산하는 메소드
	var line = d3.line()	//svg의 선
	.x(function(d,i){					//X 좌표는 표시 순서x 간격
		return  offsetX + i * margin;	//X는 꺽은선 따라 움직이기 때문에 index * margin 으로
	})									//marign(전체길이/데이터셋갯수나누기) 을 더해준다.)
	.y(function(d,i){
		return svgHeight - (d.value * scale) - offsetY;	//데이터로부터 Y 좌표 빼기
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
	


//가로 눈금을 표시하기 위해 D3 스케일 설정
var xScale = d3.scaleLinear()	//스케일 설정
	//.domain([2004,2013])	//2004년부터 2013년까지
.domain([new Date("2004/1/1"), new Date("2013/1/1")])	//2004~2013
	.range([0,svgWidth])	//표시크기
	
	
// 	var	bottomAxis = d3.axisBottom(xScale).ticks(5)	; //2년에 1번 표시함
	var	bottomAxis = d3.axisBottom(xScale)
	.ticks(5)
	.tickFormat(function(d,i){
		var	formatTime = d3.timeFormat("%Y년%m월");
		return formatTime(d);	
	})

//가로 눈금 표시
	d3.select("#myGraph")	// SVG 요소를 지정
	  .append("g")			// g 요소 추가, 이것이 눈금을 표시하는 요소가 됨
	  .attr("class", "axis")	// CSS 클래스 지정
	  .attr("transform", "translate("+offsetX+", "+(svgHeight-offsetY-0.5)+")")	
	  .call(
		bottomAxis	  
	  )
	  
}	//drawScale() end
});	// addEventListener() end



