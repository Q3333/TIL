window.addEventListener("load",function(){
var dataSet = [ ]; //데이터를 저장할 배열을 준비
//1.데이터 준비 CSV 파일 불러와 그래프 그리기

//d3.csv("data.csv").then(function(data){
//	console.log(data);
//});

d3.csv("datas/data.csv").then(function(data){
	for(var i=0; i<data.length; i++){
		dataSet.push(data[i].item1);
	}


d3.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)	//데이터 설정
	.enter()	//설정한 데이터 수에 따라서 rect 요소를 생성
	.append("rect")
	.attr("x",0)
	.attr("y",function(d,i){	//배열의 값과 값의 인덱스 파라미터가 전달됨
		return i*30;
	})
	.attr("width","0px")	// 애니메이션 - 딜레이를 줘서 천천히 보여주기
	.attr("height", "20px")
	.transition()
	.delay(function(d,i){
		return i*500;
	})
	.duration(2500)
	.attr("width",function(d,i){	
		return d+"px";
	})
	
	d3.select("#myGraph")
	.selectAll("rect")
	.on("click",function(){
		d3.select(this)//이벤트가 발생한 객체
		.style("fill","cyan")
})	
});


	

//.attr("y",function(d,i){	//배열의 값과 값의 인덱스 파라미터가 전달됨
//	return i*30;
//})
//.attr("height", "20px")
//.attr("width",function(d,i){	
//	return d+"px";
//})


	

d3.select("#updateButton")
.on("click", function(){
    for(var i=0; i<dataSet.length;i++){
    	dataSet[i] = Math.floor(Math.random()*320);
    } 
     d3.select("#myGraph")
       .selectAll("rect")
       .data(dataSet)
       .transition() // 애니메이션, 자연스럽게 늘리고 줄이기
       .attr("width", function(d, i) {
           return d+"px";
        });
   });

});