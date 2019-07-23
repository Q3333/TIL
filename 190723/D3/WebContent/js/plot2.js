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
	
	
	// 데이터셋 갱신
	function updateData(data){
		var result = data.map(function(d,i){
			var x = Math.random() * svgWidth;
			var y = Math.random() * svgHeight;
			return [x,y];
		})
		
		return result;
	}

	//산포도 갱신
	
	function updateGraph(dataSet){
		d3.select("#myGraph").selectAll("*").remove();	// 데이터 다 지우고 새로 만듬
		circleElements = d3.select("#myGraph")
						 .selectAll("circle")
						 .data(dataSet)
	    circleElements.enter()
	    .append("circle")
	    .attr("class", "mark") // CSS클래스 설정
	    	.transition()	//cx,cy 애니메이션
	    	.attr("cx", function(d,i){
	    		return d[0];
	    	})
	    	.attr("cy",function(d,i){	// 
		return svgHeight -d[1]; // Y 좌표를 설정
	})
	.attr("r", 5)	// 반지름을 지정
	    
	}
	
	// 타이머를 사용하여 2초마다 단위를 변화시킴
	setInterval(function(){
		dataSet = updateData(dataSet);	//데이터 갱신
		updateGraph(dataSet);	// 그래프 갱신
	}, 2000)
	
});	// addEventListener() end



