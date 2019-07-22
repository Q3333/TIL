var req;
window.onload = function(){
	document.querySelector("#btn_load").onclick = function() {
	var url = "images.jsp" ;
	req = new XMLHttpRequest();
	req.onreadystatechange = createImages;
	req.open("Get",url,"true");
	req.send(null);
};
}

function createImages(){
	if(req.readyState==4) {	// 요청객체의 상태가 모든 데이터를 받을 수 있을 때 
		if(req.status == 200){  // 서버로부터 응답받는 HTTP 상태가 정상일 때 
			var obj = JSON.parse(req.responseText);
			var images = obj["rows"];
			var strDom = "";
			for (var i=0; i<images.length; i++){
				// 2. N번째 이미지 정보를 구합니다.
			 var image = images[i];
			 	// 3. N번째 이미지 패널을 생성합니다.
			 strDom += '<div class = "image_panel">'
			 strDom += '	<img src= "'+image.url+'">';
			 strDom += ' 	<p class = "title">' + image.title +'</p>';
			 strDom += '</div>';

		}

		document.querySelector("#image_container").innerHTML = strDom;

	}else{
		alert("처리중 에러가 발생했습니다.");
		}
	}
}


