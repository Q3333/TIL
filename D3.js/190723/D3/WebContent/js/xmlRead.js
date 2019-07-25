window.addEventListener("load",function(){
	var dataSet = [ ]; //데이터를 저장할 배열을 준비
	
d3.xml("datas/data.xml").then(function(xmlRoot){
	var xmlData = xmlRoot.querySelectorAll("data"); // data요소를 추출
	var salesRoot = xmlData[0]; // 상품 A의 데이터만 추출
	var salesData = salesRoot.querySelectorAll("sales"); // sales 요소를 추출

	for(var i=0; i<salesData.length; i++){	// sales 요소 개수만큼 반복
		var d = salesData[i].firstChild.nodeValue; // 데이터 읽어들이기
		dataSet.push(d);	// 
	}

//그래프 그리기
d3.select("#myGraph")
	.selectAll("rect")	//rect 요소 지정
	.data(dataSet)	//데이터를 요소에 연결
	.enter()	//데이터 개수만큼 반복
	.append("rect")	//데이터 개수만큼 rect 요소가 추가됨
	.attr("class","bar")	//CSS클래스를 지정
	.attr("width",function(d,i){//넓이를 지정, 두 번째의 파라미터
		return d;	//데이터 값을 그대로 넓이로 변환
	})
	.attr("height", 40)	//높이를 지정
	.attr("x",0)	// x좌표를 0으로 함
	.attr("y",function(d,i){	//Y좌표를 지정함
		return i*65	//표시 순서에 25를 곱해 위치를 계산
	})

})	
});



