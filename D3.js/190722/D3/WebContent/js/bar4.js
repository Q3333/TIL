window.addEventListener("load",function(){
	var svgHeight = 300;	// SVG 요소의 높이
	var offsetX = 30;	// X 좌표의 오프셋(어긋남의 정도)
	var offsetY = 10;	// Y 좌표의 오프셋(어긋남의 정도)
	var barElements;	//막대그래프의 막대 요소를 저장할 변수
	var dataSet = [120,70,175,80,220]; 
	
	// 그래프 그리기	
	barElements = d3.select("#myGraph")
	.selectAll("rect")	// rect 요소를 지정
	.data(dataSet) // 데이터를 요소에 연결
	
	//데이터 추가
	barElements.enter() // 데이터 수만큼 반복
	.append("rect") // 데이터 수만큼 rect 요소가 추가됨
	.attr("class", "bar") // CSS클래스 설정
	.attr("height", function(d,i){	// 넓이 설정. 2번쨰 파라미터에 함수를
		return d; // 데이터 값을 그대로 높이로 지정
	})
	
	.attr("width",20) //넓이 지정
	.attr("x", function(d,i){
		return i * 25 +  offsetX; 		// X 좌표를 표시 순서로 x 25로 함
	})
	.attr("y",function(d,i){	// Y 좌표를 지정
		return svgHeight - d - offsetY; // Y 좌표를 계산
	})
	
barElements.enter()	// text 요소 지정
	.append("text") // text 요소 추가
	.attr("class" , "barNum")	// CSS 클래스 설정
	.attr("x", function(d,i){	// X 좌표를 지정
		return i * 25 + 10 + offsetX;		// 막대 그래프의 표시 간격을 맞춤
	})
	
	.attr("y", svgHeight - 5 - offsetY) // Y 좌표를 지정
	.text(function(d,i){	// 데이터 표시
		return svgHeight - d;
	})
	
//눈금을 표시하기 위한 스케일 설정
	var yScale = d3.scaleLinear() // 스케일 설정
	.domain([0,300])	// 원래 크기
	.range([300,0])	// 실제 출력 크기
	
//눈금의 표시 위치를 왼쪽으로 지정
	var axis = d3.axisLeft(yScale)
		.ticks(10) // 눈금간격
		.tickValues([10,20,30,50,100,150,200])
		//tickFormat(d3,format(".2f"))
		
//눈금을 설정하여 표시
	d3.select("#myGraph").append("g")
	.attr("class", "axis")
	.attr("transform", "translate("+offsetX + ", " + ((svgHeight-300)-offsetY)+")")
	.call(axis)
	
});	// addEventListener() end



