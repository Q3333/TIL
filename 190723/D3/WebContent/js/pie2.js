window.addEventListener("load",function(){
	
	var svgHeight = 240;	// SVG 요소의 높이
	var svgWidth = 320;		//SVG 요소의 넓이
	var dataSet = [50,30,12,5,3];	//데이터 셋, 비율을 나타냄 
	
	// 원 그래프의 좌표값을 계산하는 메서드
	var pie = d3.pie()	// 원 그래프 레이아웃
	
	// 원 그래프의 외경,내경 설정 (원그래프 반지름 = outer, 도넛모양으로 만들고 싶으면 inner도 설정)
	var arc = d3.arc().innerRadius(0).outerRadius(100);
	
	//원 그래프 그리기
	
	var pieElements = d3.select("#myGraph")
	.selectAll("path")	// path 요소 지정
	.data(pie(dataSet))	//데이터를 요소에 연결, d3.pie함수는 데이터의 부채꼴의 좌표를 계산해서 
	
	//데이터 추가
	pieElements.enter() // 데이터 수만큼 반복
	.append("path") // 데이터 수만큼 rect 요소가 추가됨
	.attr("class", "pie") // CSS클래스 설정
	.attr("d",arc)	//부채꼴 지정
	.attr("transform", "translate("+svgWidth/2+", "+svgHeight/2+")")//원의 정 중앙에 위치시키기
	.style("fill", function(d,i){
		return ["red","orange","yellow","cyan","#3f3"][i];	//원 안의 부채꼴 색깔 각각지정
	})

});	// addEventListener() end



