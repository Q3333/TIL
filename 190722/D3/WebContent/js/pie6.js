window.addEventListener("load",function(){
	
	//처음에는 2008년 데이터를 표시해둠
	drawPie("./datas/mydata2008.csv");
	
	//선택 메뉴가 선택되었을 때의 처리
	d3.select("#year").on("change",function(){
		d3.select("#myGraph").selectAll("*").remove();
		drawPie("./datas/mydata"+this.value+".csv",this.value);
		
	});
	
	function drawPie(filename){
		//데이터 셋은 CSV파일
		
		d3.csv(filename)
			.then(function(data){
				var dataSet = [] ;
					for(var i in data[0]){
						dataSet.push(data[0][i]);
					}
			
					var svgEle = document.getElementById("myGraph");
					var svgWidth = window.getComputedStyle(svgEle, null).getPropertyValue("width");
					var svgHeight = window.getComputedStyle(svgEle, null).getPropertyValue("height");
					
					svgWidth = parseFloat(svgWidth);
					svgHeight = parseFloat(svgHeight);
					
					var color = d3.scaleOrdinal(d3.schemeCategory10);
					//var color = d3.scaleOrdinal(d3.schemeCategory20c);

					// 원 그래프의 좌표값을 계산하는 메서드
					var pie = d3.pie().value(function(d,i){return d;})	// 원 그래프 레이아웃
					
					// 원 그래프의 외경,내경 설정 (원그래프 반지름 = outer, 도넛모양으로 만들고 싶으면 inner도 설정)
					var arc = d3.arc().innerRadius(40).outerRadius(100);
					
	
	
	

	
	//원 그래프 그리기
	
	var pieElements = d3.select("#myGraph")
	.selectAll("g")	// path 요소 지정
	.data(pie(dataSet))
	.enter()
	.append("g")// g는 요소
	.attr("transform", "translate("+svgWidth/2+", "+svgHeight/2+")")
	
	//데이터 추가
	pieElements.append("path") // 데이터 수만큼 path 요소가 추가됨
	.attr("class", "pie") // CSS클래스 설정
	.style("fill",function(d,i){
		return color(i);	//표준 10색 중 색을 변환
	})
	
	
	
	.transition()
	.duration(200)
	.delay(function(d,i){	// 그릴 원 그래프의 시간을 어긋나게 표시
		return i*200;
	})
	.ease(d3.easeLinear) //  직성적인 에니메이션 움직임으로 변경
	
	// 시간에 따라 도형을 변환시키기위해 시간에 따라 속성값을 변화시키는
	.attrTween("d",function(d,i){	// 보간 처리
		var interpolate = d3.interpolate(
				//각 부분의 시작 각도
		{	startAngle : d.startAngle, endAngle : d.startAngle },
				//각 부분의 종료 각도
		{	startAngle : d.startAngle, endAngle : d.endAngle }
	);
		return function(t){	//t는 시간
			return arc(interpolate(t));	//시간에 따라 처리
		}
			
	})
	
	//합계와 문자 표시
	var textElements = d3.select("#myGraph")
	.append("text")
	.attr("class", "total")
	.attr("transform", "translate("+svgWidth/2+", " +(svgHeight/2+5)+")")
	
	.text("점유율 : " + d3.sum(dataSet))	//합계표시
	
	// 숫자를 부채꼴의 가운데에 표시
	pieElements
	.append("text")
	.attr("class","pieNum")
	.attr("transform", function(d,i){
		return "translate("+arc.centroid(d)+")";	//부채질의 중심으로
	})
	.text(function(d,i){
		return d.value;	// 값 표시
	});
	
			})// then end
	}	//function end
	
});	// addEventListener() end



