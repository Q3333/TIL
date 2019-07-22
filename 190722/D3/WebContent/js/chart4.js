window.addEventListener("load",function(){

//1.데이터 준비
var dataSet = [300,50,10,80,230];

d3.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)	//데이터 설정
	.enter()	//설정한 데이터 수에 따라서 rect 요소를 생성
	.append("rect")
	.attr("x",0)
	.attr("y",function(d,i){	//배열의 값과 값의 인덱스 파라미터가 전달됨
		return i*30;
	})
	
	.attr("width",function(d,i){
		return d + "px";
	})
	
	.attr("height", "20px");


d3.select("#updateButton")
.on("click", function(){
     dataSet=[20, 230, 150,10, 20]; //새로운 데이터로 변경
     d3.select("#myGraph")
       .selectAll("rect")
       .data(dataSet)
       .attr("width", function(d, i) {
           return d+"px";
        });
   });


//2.

});