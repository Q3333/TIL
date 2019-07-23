window.addEventListener("load",function(){
	var width = document.querySelector("svg").clientWidth;
	var height = document.querySelector("svg").clientHeight;
	var data = {
			"name": "A",
			"children": [
				{ "name" : "B", "value": 25},
				{ "name" : "C",
				  "children" : [
					  {  "name" : "D", "value" : 10 },
					  {  "name" : "E", "value" : 15 },
					  {  "name" : "F", "value" : 10 }
				  ]
			},
			{ "name" : "G", "value" : 15},
			{ "name" : "H", 
				 "children" : [
					 {  "name" : "I", "value" : 20 },
					 {  "name" : "J", "value" : 10 }
			
			]
			},
			 {  "name" : "K", "value" : 10 }
	]
	};
	  
			   
	root = d3.hierarchy(data); // 계층구조로 표현하기 위한 레이아웃
	root
	.sum(function(d) { return d.value; })
	.sort(function(a,b) { return b.height - a.height || b.value - a.value; });
	
	
	var treemap = d3.treemap()	//트리맵 레이아웃
	.size([width, height])
	.padding(1)	//안쪽 여백 (하얀색 구분선)
	.round(true);	//부드럽게 선 처리
	
	treemap(root);


	
	var g = d3.select("svg")
		.selectAll(".node")
		.data(root.leaves())
		.enter()
		.append("g")
		.attr("class","node")
		.attr("transform", function(d) {return "translate(" + d.x0 + "," + d.y0 + ")"; });
	
	g.append("rect")
		.style("width", function(d) {return d.x1 - d.x0; })
		.style("height", function(d) {return d.y1 - d.y0; })
		.style("fill", function(d) {
			while(d.depth > 1) d = d.parent;
			return d3.schemeCategory10[parseInt(d.value % 7)];
		})
		.style("opacity", 0.6)
		
		
		
		g.append("text")
			.attr("text-ancfhor", "start")
			.attr("x",5)
			.attr("dy",30)
			.attr("font-size", "150%")
			.attr("class", "node-label")
			.text(function(d)	{return d.data.name + " : " + d.value; });
});	// addEventListener() end



