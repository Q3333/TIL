# Ajax 1일차	

#### Ajax 

-비동기 통신

(페이지) 부분 갱신



핵심은 AJAX Enabled HTML Page임.

데이터를 받아서 call back 함수를 호출.



사진 ) 

![](C:\Users\student\Desktop\ajax1.png)







### Ajax 의 특성(634p)

- 비동기방식이다. 

  (페이지 전체를 refresh하지 않고서도 수행된다.)

- 수행 속도가 빠르다. 

  (웹 브라우저가 요청을 송신하면 응답을 기다리지 않는다. )

- 전체 페이지를 렌더링하는 게 아니라 받은 페이지를 가지고 일부만 변경하기 때문에 고속의 렌더링이 가능하다. ( 그 부분만 빠르게 렌더링이 가능하다. / 필요한 데이터만 응답한다.)





### Ajax의 사용차 요청 처리 과정 ?

사용자가 이벤트(마우스 클릭 등)를 발생

 자바스크립트는 DOM을 사용해서 필요한 정보를 구함

 XMLHttpRequest 객체를 통해서 웹 서버에 요청을 전달

 웹 서버는 XMLHttpRequest로부터의 요청을 알맞게 처리

 웹 서버는 결과를 XML이나 단순 텍스트로 생성해서
XMLHttpRequest에 전송

 클라이언트 브라우저로 서버로부터의 응답이 도착하면
XMLHttpRequest 객체는 자바스크립트에 도착 사실을 알림

 자바 스크립트는 응답 데이터와 DOM을 조작해서 사용자 화면에 반영





### 주요 프로퍼티

responseText

ex ) 에러 403 포비든 이 뜰 경우 그 텍스트를 가져와줌 

responseXML

-> 응답 결과를 저장하는 프로퍼티다.

onreadystatechange

-> 클라이언트 페이지를 응답 내용으로 갱신하기 위해서 호출되는 프로퍼티



### 주요 메소드

요청 시 : open(method, url, async)

요청을 받고 서버로 보낼 시 : send(content)





#### ajax 연습 1

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajax 처리 1</title>

<script type="text/javascript">
window.onload = function(){			// 이벤트 발생
	var req = new XMLHttpRequest(); // 1. XMLHttpRequest()
	req.onloadstart = function(){
		console.log("loadstart : 요청을 보낼때");
	}
	req.onload = function() {
		console.log("load : 요청 성공, 응답 가져올 수 있을 때")
	}

	req.onloadend = function() {
		console.log("loadend : 요청 완료")
	}

	req.onprogress = function() {
		console.log("progress : 데이터를 주고 받을 때")
	}


	req.onreadystatechange = function(){
		if(req.readyState==4){	// 4 = completed 데이터를 전부 받은 상태, 완전한 데이터의 이용 가능
			if(req.status == 200){ // 응답이 성공일 때 200 
				document.getElementById("view").innerHTML = req.responseText;
			}
		}
		
	} // 응답 처리 함수

	req.open("GET","http://70.12.50.148:8080/data.txt") // 2.요청 보낼 준비
	req.send(null); //3.요청 보냄



};	

</script>
</head>
<body>
	<p id = 'view'></p>
</body>
</html>

```





data. txt

```
<mark>Ajax 요청에 대한 응답</mark> 입니다. 
```



#### Ajax연습1 파일을 JQuery로 바꿔주기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jQuery Ajax 처리 1</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){// 이벤트 발생
		$.ajax({
			url : "data.txt",
			success : function(data){
				$("#view").html(data);
			}

		}
		);
	

});	

</script>
</head>
<body>
	<p id = 'view'></p>
</body>
</html>

```









#### 연습2 ( 이미지 불러오기 )

-html

```html
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
	<title></title>
	<style>
		.image_panel{
			border:1px solid eeeeee;
			text-align:center;
			margin:5px;
		}
		.image_panel .title{
			font-size:9pt;
			color:#ff0000;
			
		}
		
	</style>
	 
	<script src="ajax_json.js"></script>	 
</head>

<body>
	<div>
		<button id="btn_load">이미지 읽어들이기</button>
	</div>
	<div id="image_container">
		<!-- 1. 이곳에 이미지를 넣어주세요-->
	</div>
	
	<!-- 2. 이 내용은 이미지 패널 템플릿입니다. -->
	<div style="display:none;" id="image_panel_template">
		<div class="image_panel">
			<img >
			<p class="title"></p>
		</div>
	</div>
</body>
</html>

```



ajax_json.js

```js
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
```



images.jsp

```jsp
<%@ page contentType = "text/plain; charset=utf-8"
	pageEncoding = "utf-8"%>
{"rows":[
	{"title":"이미지1","url":"images/img1.jpg"},
	{"title":"이미지2","url":"images/img2.jpg"},
	{"title":"이미지4","url":"images/img4.jpg"},
	{"title":"이미지5","url":"images/img5.jpg"},
	{"title":"이미지3","url":"images/img3.jpg"},
	{"title":"이미지6","url":"images/img6.jpg"},
	{"title":"이미지7","url":"images/img7.jpg"},
	{"title":"이미지8","url":"images/img8.jpg"},
	{"title":"이미지10","url":"images/img10.jpg"}
]}
```



#### Ajax연습2 파일을 JQuery로 바꿔주기

```html
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
	<title></title>
	<style>
		.image_panel{
			border:1px solid eeeeee;
			text-align:center;
			margin:5px;
		}
		.image_panel .title{
			font-size:9pt;
			color:#ff0000;
			
		}
		
	</style>
	 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#btn_load").click(function(){
				$.getJSON("images.jsp", null, createImages);
		});
	});

	function createImages(data){
			var images = data.rows;
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
	var $imageContainer = $("#image_container");
	$imageContainer.append(strDom);

	$(document).ajaxComplete(function(){
		console.log("ajax event : complete");
	});

	$(document).ajaxSend(function(){
		console.log("ajax event : send");
	});

	$(document).ajaxStart(function(){
		console.log("ajax event : start");
	});

	$(document).ajaxSuccess(function(){
		console.log("ajax event : success");
	});
}
</script>
```











#### 연습3 로그인 화면

-html

```html
<!DOCTYPE html>
<html>
  <head>
    <meta  charset="utf-8">
    <title>부분페이지 동적 갱신</title>     
    <link rel="stylesheet" href="partPage.css" type="text/css" />
    <script src="partPage.js"></script>
  </head>
  <body>
    <h3>부분페이지 갱신, POST요청, XML응답처리</h3>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>우리회사</b></font></td></tr>
      <tr>
         <td><form action="#">
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" id="userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" id="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="button" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
         <td width="400"><img src="dog.jpg"></td>
      </tr>
      <tr><td colspan="2" align="center">찾아오시는길 |회사소개|정보보호정책</td></tr>
    </table>
  </body>
</html>
```



partPage.css

```css
@CHARSET "utf-8";
div#confirmed{
  width            : 250px;
  height           : 100px;
  background-color : #e0ffff;
  border-color     : #b0e0e6;
  border-style     : dotted;
}
```



partPage.js

```js
var req;	//XMLHttpRequest객체를 저장할 변수를 전역변수로 선언 

window.onload = function(){	// 브라우저가 로드 되었을 떄 처리를 실행하는 함수
	req = new XMLHttpRequest();	// XMLHttpRequest 객체 생성
	document.getElementById("login").onclick = startMethod;
};

function startMethod(){
	var uid = document.getElementById("userid").value;
	var upwd = document.getElementById('userpwd').value;
	var url = "partPage.jsp";	//요청 URL 설정 
	req.onreadystatechange = resultProcess; // 응답결과를 처리 메소드입력
	req.open("post",url,"true");	// 서버의 요청 설정 - url 변수에 설정된다.
	req.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");
	req.send("userid="+uid+"&userpwd=" + upwd); //서버로 요청을 보냄 
};

function resultProcess(){ // partPageDBuse.jsp 페이지에서 응답 결과가 오면 
	if(req.readyState == 4){ // 요청객체의 상태가 모든 데이터를 받을 수 있을 때 
		if(req.status == 200){ // 서버로부터 응답받는 HTTP 상태가 정상일 때 
				confirmedProcess();
				 // confirmedProcess() 메소드 호출 
			}
	}
}

function confirmedProcess(){//로그인의 성공과 실패에 따라 표시되는 내용을 결정하는 메소드
    var result =req.responseXML.getElementsByTagName("result")[0].firstChild.data;
    var name = req.responseXML.getElementsByTagName("id")[0].firstChild.data;
     
    if (result == 1){//사용자 인증성공시
      var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
      str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"
    	  document.getElementById("confirmed").innerHTML = str;
    }else if(result==0){//사용자 인증실패시 - 비밀번호가 틀림
      alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value=name;
      document.getElementById("userpwd").value="";
      document.getElementById("userpwd").focus();
    }else{//사용자 인증실패시 - 아이디가가 틀림
      alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value="";
      document.getElementById("userpwd").value="";
      document.getElementById("userid").focus();
    }
}
```



#### Ajax연습3 파일을 JQuery로 바꿔주기

```html
<!DOCTYPE html>
<html>
  <head>
    <meta  charset="utf-8">
    <title>부분페이지 동적 갱신</title>     
    <link rel="stylesheet" href="partPage.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
    <script>
     $(document).ready(function(){
        $("#login").click(function(){
          var uid = $("#userid").val();
          var upwd = $("#userpwd").val();
         console.log(uid +"  @  " + upwd);
          $.ajax({
            url: "partPage.jsp",
            data: {userid: uid, userpwd:upwd},
            success : function(data){
              var result = $(data).find("result").text();
              var name = $(data).find("id").text();
              if (result == 1){//사용자 인증성공시
                  var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
                  str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"

                  $("#confirmed").html(str);
                   
                }else if(result==0){//사용자 인증실패시 - 비밀번호가 틀림
                  alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
                  $("#userid").val(name);
                  $("#userpwd").val("");
                  $("#userpwd").focus();

                  // document.getElementById("userid").value=name;
                  // 의 형식이 위처럼 변함. 
                   // document.getElementById("userpwd").value="";
                  // document.getElementById("userpwd").focus(); 
                  
                }else{//사용자 인증실패시 - 아이디가가 틀림
                  alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");

                  $("#userid").val("");
                  $("#userpwd").val("");
                  $("#userid").focus();
                
                }

            }
          });

		});
 });

     
     </script>

```





## @@@@ JQurey로 바꾸는 문제 다시 보기