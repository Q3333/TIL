window.addEventListener("load",function(){

d3.html("data.html").then(function(docFragment){
	var tr = docFragment.querySelectorAll("table tr");
	var dataSet = [ ]; //데이터를 저장할 배열을 준비
	for(var i=1; i<tr.length; i++){	//데이터 줄 수 만큼 반복
		var d = tr[i].querySelectorAll("td")[0].firstChild.nodeValue;
		dataSet.push(d);
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
	.attr("height", 20)	//높이를 지정
	.attr("x",0)	// x좌표를 0으로 함
	.attr("y",function(d,i){	//Y좌표를 지정함
		return i*25	//표시 순서에 25를 곱해 위치를 계산
	})

})	
});



