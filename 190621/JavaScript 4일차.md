# JavaScript 4일차

### 브라우저 객체

#### Location(location) - 

브라우저 객체 중 문서의 URL을 관리하기 위해 사용  



location.href

assign(url)

replace(url)

reload



#### Navigator -

요청을 보낸 클라이언트의 브라우저를 얻을 수 있는객체



html문서에 포함된 자바스크립트는 클라이언트에 보내져서 클라이언트의 브라우저에서 실행되므로 자바스크립트가 실행되는 브라우저 정보등을 얻기 위해 사용하는 객체 

geolocation

appName

onLine

platform



#### Screen - 

화면의 크기와 색상 정보를 관리 객체 

width, height, orientation, colorDepth, pixelDepth



#### History-

웹 페이지의 이력을 관리

length (이동했던 페이지 이력 갯수), back(), forward(), go( n | -n )





## 이벤트 처리 

1. 이벤트 소스 객체.on 이벤트 = function(){} // 이벤트 핸들러 함수

- 하나의 이벤트에 대해서 하나의 핸들러만 등록할 수 있다.



2. 이벤트 소스 객체.addEventListener("이벤트", 이벤트 핸들러 함수, 캡처링 여부(default는 false))



#등록된 이벤트 제거 



이벤트 소스 객체.on 이벤트 = null

이벤트 소스 객체.removeEventListener("이벤트", 이벤트 핸들러 함수)





#브라우저에서 처리해주는 기본 이벤트 취소 :

예 ) <a href=""></a>의 클릭이벤트

예) form태그의 submit 이벤트

방법 1. 이벤트 객체. on이벤트 = function(){ //이벤트 핸들러 함수 override해서 return false를 해줌;

...

return false; }



방법 2. event preventDefault()





#이벤트 전파 방식

-버블링 (대부분의 브라우저에게 기본으로 지원) : 자식 객체 -> 부모 객체로

-캡처링

이벤트 버블링을 중단시키려면 event.stopPropagation();



#### 뷰포트 (윈도우 좌표계) - 



#웹 브라우저에서 문서의 내용을 표시하는 영역



#문서의 요소 객체는 박스모델이 적용되며, 왼쪽 X 좌표는 left속성, 왼쪽 상단의 Y좌표는 top속성,원래 스타일 조절, 오른쪽 아래의 X좌표 right속성, 오른쪽 아래의 Y좌표 bottom속성

너비는 width, 높이는 height 속성



뷰포트의 너비 속성은 clientWidth, innerWidth로 참조를 해야하고, (스크롤 막대 포함)

높이 속성은 ClientHeight innerHeight로 참조해야된다.(스크롤 막대 포함)





```
문서의 요소 객체.innerHTML="<strong> 강조체 </strong>"
문서의 요소 객체.textContent="<strong> 강조체 </strong>"
문서의 요소 객체.innerText="<strong> 강조체 </strong>"
```





# JQuery

### 개요

- 모든 브라우저에서 동작하는 클라이언트 자바스크립트 라이브러리
- 2006년 1월, 존 레식 John Resig 이 BarCamp NYC에서 발표
- 무료로 사용 가능한 오픈소스 라이브러리
- jQuery의 제작 목표
  -  DOM 과 관련된 처리 쉽게 구현 ( CSS의 style 형식과 동일)
  -  일관된 이벤트  연결 쉽게 구현
  -  시각적 효과 쉽게 구현
  -  Ajax 애플리케이션 쉽게 개발





#### JQuery 기본

```javascript
$("h3").css("color", "blue").css("backgroundColor" ,"orange").css("border", "solid 5px"); //h3태그에만 css넣기

$("*").css("color", "blue").css("backgroundColor" ,"orange").css("border", "solid 5px"); // * = 전부에다가 css넣기

$("div, p").css("color", "blue").css("backgroundColor","orange"); // div와 p 에 css넣기

$("#simple").css("color", "blue").css("backgroundColor" ,"orange"); //id가 simple인 부분에 css넣기

$(".todo").css("color", "blue").css("backgroundColor" ,"orange"); // class가 todo인 부분에 css넣기

$("body>p").css("color", "blue").css("backgroundColor" ,"orange"); // body 밑에 있는 p 부분에 css넣기

$("input[type='text']").val("Hello, jQuery~"); // 인풋의 타입이 text인 것에 val(text값 을 입력.)

$("input:password").css("backgroundColor", "cyan"); // 인풋의 타입이 password인 것에 css

$("input:focus").css("backgroundColor", "lightgray")// autofocus 설정이 되어있는 부분에 css
```





#### select한 값 가져오기

```
//JQuery
<script>
	$(document).ready(function(){
		setTimeout(function () {
			var value = $('select > option:selected').val();

			alert(value);
		},5000)
	});
```



```
//body
<select>
		<option> A </option>
		<option> B </option>
		<option> C </option>
		<option> D </option>
		<option> E </option>
</select>
```





#### 테이블에 css넣기

```
//JQuery 부분
	$(document).ready(function(){
		$('tr:odd').css('background', 'cyan');
		$('tr:even').css('background', 'violet');
		$('tr:first').css('background', '#000000').css('color','#FFFFFF');
	});
	
/*
//1열 바이올렛 2열 싸이안 3열 노랑색 4열 바이올렛~ 순으로 계속 css 넣어주는 예제

	$(document).ready(function(){
		$('tr:eq(0)').css('background', '#000000').css('color','White');

		$('td:nth-child(3n+1)').css('background', 'violet');
		$('td:nth-child(3n+2)').css('background', 'cyan');
		$('td:nth-child(3n)').css('background', 'yellow');
	});

*/
```



```
//body부분
<table>
        <tr><th>이름</th><th>혈액형</th><th>지역</th></tr>
        <tr><td>강민수</td><td>AB형</td><td>서울특별시 송파구</td></tr>
        <tr><td>구지연</td><td>B형</td><td>미국 캘리포니아</td></tr>
        <tr><td>김미화</td><td>AB형</td><td>미국 메사추세츠</td></tr>
        <tr><td>김선화</td><td>O형</td><td>서울 강서구</td></tr>
        <tr><td>남기주</td><td>A형</td><td>서울 노량진구</td></tr>
        <tr><td>윤하린</td><td>B형</td><td>서울 용산구</td></tr>
  </table>
```

