window.addEventListener("load",function(){
	var svgWidth =320;	// SVG 요소의 넓이
	var svgHeight = 240;	// SVG 요소의 높이
	var offsetX = 30;		//X 좌표의 오프셋
	var offsetY = 20;		//Y 좌표의 오프셋
	var scale = 2.0;
	
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
	    		return d[0] +offsetX;
	    	})
	    	.attr("cy",function(d,i){	// 
		return svgHeight -d[1] -offsetY; // Y 좌표를 설정
	})
	.attr("r", 5)	// 반지름을 지정
	    
	}
	
	function drawScale(){
		
		d3.select("#myGraph").selectAll("g").remove();	// 데이터 다 지우고 새로 만듬
		
		
		var maxX = d3.max(dataSet, function(d, i){
				return d[0];
		});
		var maxY = d3.max(dataSet, function(d, i){
				return d[1];	
		});	
		

		
		//눈금을 표시하기 위한 스케일 설정
		var yScale = d3.scaleLinear() // 스케일 설정
		.domain([0,maxY])	// 원래 크기
		.range([maxY, 0])	// 실제 출력 크기
		
		//눈금의 표시 위치를 왼쪽으로 지정
		var axis = d3.axisLeft(yScale)

		//눈금을 설정하여 표시
		d3.select("#myGraph")//SVG 요소를 지정
		.append("g")	// g 요소 추가
		.attr("class", "axis")
		.attr("transform", "translate("+offsetX+", "+(svgHeight-maxY-offsetY)+")")	//눈금을 오프셋 X,Y만큼 움직여준다.
		.call(axis)
		
	   var xScale = d3.scaleLinear()	//스케일 설정
		  	.domain([0, maxX])	//원래 데이터 범위 
		  	.range([0,maxX])	//실제표시크기
		  
		  	var	bottomAxis = d3.axisBottom(xScale)
		
		  	
		// 가로 방향의 선을 표시
		d3.select("#myGraph")
		  .append("g")	
		  .attr("class", "axis") 
		  .attr("transform", "translate("+offsetX+", "+(svgHeight-offsetY)+")")	
		.call(bottomAxis)

	}	//drawScale() end
	
	drawScale()
	
	// 타이머를 사용하여 2초마다 단위를 변화시킴
	setInterval(function(){
		dataSet = updateData(dataSet);	//데이터 갱신
		updateGraph(dataSet);	// 그래프 갱신
		drawScale();
	}, 2000)
	
});	// addEventListener() end



