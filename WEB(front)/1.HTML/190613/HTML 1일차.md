# HTML 1일차

## 웹 요청, 응답의 구조

**HTML의 구조**

<명령어>
내용

</명령어>



HTML은 메모리에 객체 모델(트리구조) 로 생성함.

Renderer가 HTML구조에 작용하여 CSS디자인을 적용함.



**Header와 Body**

Header : 서버가 원하는 정보들, Browser의 정보, Request 에 필요한 내용들

Body : 로그인 정보, id , password , 응답에 필요하거나 관련된 내용들





**Server의 구조**(수업하다보면 설명이 됨)

Web Server + WebContainer(JSP/Server)

​						 WebContainer -> JVM포함

​						 웹컨테이너 쪽을 Application Server라고 부름

​						+ DB연결 지원 Pooling 자원들

이 총합을 WAS(WebApplicationServer)라고 부름.



웹의 기본은 요청을 하고 응답을 주는 것.



소켓통신 : 계속 상태가 유지되는 것, 주로 채팅을 만들 때 사용 , 전화개념

HTTP 통신은 요청을 보내고 응답 받고 끝.





**에러의 종류**



404 = URL 주소값 오류, 요청값 오류

500 = 서버에서 처리하는 중에 오류, 응답 결과 생성 X



### **HTTP 요청**

- 주로 GET or POST방식으로 사용한다.



### **GET** : 

정보를 가져 올 때 - 단순 페이지 요청, 검색어 요청, URL에 그대로 노출(중요정보를 보내면 안됨), 길이 제한이 있음

URL에 정보를 직접 입력할 경우 GET방식으로 보면 됨



### **POST** : 

정보를 보낼 때 - **회원가입, 로그인시 사용** , Body에 보안 데이터를 실어서 보내는 경우가 많음



도메인 /(Root Context) BBS / list.html



구조상으로는

/

bbs

list.html

순임



Accept  : 해당 사이트에서 받을 수 있는 데이터 형식



## 웹의 역사

WWW(World Wide Web) : 1990년대 초반 팀 버너스 리 라는 사람이 만듬.

-> 단순 HTML, View서비스, 동기방식 ( 응답이 올 때 까지 기다려야함.), 전체 페이지 개선방식

-> Web 1.0

-> 이 때는 아직 동적서비스가 불가능했음



동적 서비스를 해결하기 위해 웹 서버측에서 OS와 연동을해서 응답

-> 리퀘스트가 많아지면 과부하가 걸려서 응답을 못함.



그래서 Webserver에 따로 응답용 Container를 만듬.



Browser관련, CGI를 거쳐서 스레드 방식 동적 서비스가 가능해짐 : Front End



WebServer와 관련된 모든 작업 : BackEnd

-> 분산작업 (EJB : 분산작업이지만 무겁고 응답도 느려서 실패함)

-> JSP/servlet 단위로 개발



### BackEnd

Servlet (Server Applet)

-> 추후에 JSP(Java Sereve Page, Model1방식)가 등장

-> 그후에 EJB(분산처리)가 등장, 실패하고 사라짐 (요새는 EJB3.0이 재등장하긴 함)

-> Servlet이 <Controller>, JSP가 <View> 를 담당해서 Model2방식이 등장.

-> FrameWork가 등장(Spring)

-> 자바 웹은 FrameWork를 기반으로 만들게 됨.

-> 표준화 : 전자정보표준FrameWork(Spring 기반)



### FrontEnd

Html - 문서구조

CSS

JavaScript

-> Flash가 등장 , IE(Internet Exploer)기반이라서 ActiveX설치가 필요한 것들이 많았었음.(지금은 거의 걷어냄)

-> MS가 OS기반의 IE를 제공



W3C -> 웹 표준화 단체가 표준화 기준을 만듬.

Html - 문서구조

CSS - 스타일 

JavaScript - 동작 

담당



##### 웹의 한계 :

응답 페이지의 단위가 전체 단위라서 일부만 바뀌는 게 아니라 페이지 전체가 바뀌게 됨.



#### Ajax :

 비동기 자바스크립트를 이용한 And XML

간단한 스크롤 같은 것만 사용해도 즉시 응답이 와서 페이지의 일부분이 변화, 응답됨.

-> 연관 검색어 10개씩 보여주는 게 실시간으로 바뀌는 이유도 Ajax를 사용해서임.



즉 부분 부분 응답은 Ajax를 이용해서 보내게 된다.



#### Ajax의 특징 : 

- 비동기 요청
- 부분 페이지 갱신.



2007/2008 년도에 스마트 폰이 등장.

원래 소리, 영상 등 과 같은 멀티미디어를 태그로 바꿔버림.



#### 결론 :

정적 웹 -> 동적 웹 -> 스마트폰 등장으로 인한 오프라인에서 구동 

으로 패러다임이 바뀜.



## HTML

- HyperText Markup Language
- Markup : <> 로 Header, Body등을 마크업 해주는 것 
- HyperText : 하이퍼 링크 처럼 누르면 특정 결과를 보여주는 것





/ 루트

Html - Head와 Body로 나뉨



#### Head  : meta, link, style, scirpt, title 등의 구조를 가짐

Body : 여러가지 요청 문을 가짐



Web 표준 1.0

Html - 문서구조

CSS - 스타일 

JavaScript - 동작 을 담당



Web 표준 2.0

하위호환성을 보장

끝태크 </body> 같은 걸 생략해도 괜찮게됨.



## 주석 쓰는 법

### <!-- 

### 할말 

### -->



HTML 첫 예제

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> <!-- 한글을 표현하기 위해 utf-8을 설정해주는 게 좋다. -->
<title>HTML 기본구조 </title>
</head>
<body>
	안녕안녕
</body>
</html>

```





#### 글씨 색깔 바꾸기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>HTML 기본구조 </title>
<style >					<!-- CSS 부분-->
body{
	font-size: 20px;
	color: red;
}
></style>					<!-- CSS 부분끝 -->
</head>
<body>
	안녕안녕
</body>
</html>
```





* 권장하지 않는 스타일 방식

```html
<body style="background-color:powderblue;">
```

와 같은 형식은 권장하지 않는다.

동작, 구현, 스타일 등은 분리해서 사용하는게 재사용성이 높다.

 

그 외 스타일 태그 정리:

참고 사이트(사용법 등) : <https://www.w3schools.com/tags/default.asp>





#### 하이퍼링크 넣기 : a herf

ex)

```html
<a href="https://www.naver.com">네이버!</a> <!-- 현재 탭에서 이동 -->
<a href="https://www.naver.com" target="_blank">네이버!</a><br> <!-- 새 탭에서 이동 -->
```

<a name = "이름">



ex)

```html
<a href="#C8">8번으로</a>

<h2>1번</h2>

<h2>2번</h2>

<h2>3번</h2>

<h2>4번</h2>

<h2>5번</h2>

<h2>6번</h2>

<h2>7번</h2>

<h2><a name="C8">8번</a></h2>

```



#### 줄임말 - abbr :

```html
<abbr title="설명">숨김</abbr> 상자
```



#### h1 ~  h6 태그

글자 크기 순서, 1이 제일 크고 6이 제일 작다.

```html
<h1>1번 </h1> <!-- Block 태그, br이 없어도 자동으로 줄 바꿈을 해줌 -->
<h2>2번 </h2>
<h3>3번 </h3>
<h4>4번 </h4>
<h5>5번 </h5>
<h6>6번 </h6>
```



#### p 태그

본문 글씨 크기 

```html
<p> 글씨연습 </p>
```

자동 줄 바꿈 및 줄 간격을 맞춰준다.

(창 크기에 맞춰서 조절을 해줌)



#### br

줄바꿈

#### hr 

수평선

#### b

볼드체

#### i

기울임체

#### ins

밑줄긋기

#### del

중앙 선 긋기 (지워진 것 처럼 보이게)



ex) 위에6개 

```html
<b> 빠라밤 </b><br>
<I> 밤밤</I><hr>
<ins>밑줄</ins><br>
<del>삭제</del><hr>
```





#### ruby

후리가나 같이 위에 작은 문자를 넣어주는 방법

주로 span과 rt랑 같이 쓴다.

```html
<ruby>
	<span>大韓民國</span>
	<rt>대한민국</rt>
</ruby>
```





#### ol, ui

ordered list, unordered list

ol은 1,2,3순서

ul은 ● 과 같은 문자로 나타내준다.

```html
<ol>
	<li>테 </li>
	<li> 스</li>
	<li> 트</li>
</ol>
<ul>
	<li>테 </li>
	<li> 스</li>
	<li> 트</li>	
	
</ul>
```



#### Table

ex) 이력서 폼 만들기



```html
<table border =1>
	<tr><td rowspan="6" width="150" height=" 200" ></td><td rowspan="2">성명</td><td>한글 </td><td></td><td>나이 (만) </td><td>&nbsp;</td><td rowspan="2">성별</td><td rowspan="2">&nbsp;</td></tr><br>
	<tr><td>영문</td><td>&nbsp;</td><td>주민등록번호</td><td></td></tr><br>
	<tr><td colspan="2">현주소</td><td colspan="5"></td></tr><br>
	<tr><td colspan="2" >e-mail</td><td colspan="5"></td></tr><br>
	<tr><td colspan="2">신장</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cm</td><td>몸무게</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kg</td><td>혈액형</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형</td></tr><br>
	<tr><td colspan="2">전화번호</td><td colspan="2"></td><td>휴대폰</td><td colspan="2"></td></tr><br>
</table>
<br>
```

th가 행 제목 

tr이 행

tb가 열

border는 구분선의 굵기

width,height로 크기조절도 된다.



#### Image 넣기



```html
<img src = "Penguins.jpg" title="큰펭귄"> <br>
<img src = "Penguins.jpg" width="200" height="200" title="작은펭귄"> <br>
<img src = "./Tulips.jpg" width="200" height="200" title="튤립"> <br>
<img src = "C:/Users/Public/Pictures/Sample Pictures/Lighthouse.jpg" width="200" height="200"> <br>
<img src = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg"> <br>
```



title로 마우스를 올려놨을 때 설명을 볼 수 있음

html과 같은 위치면 그냥 파일 이름만으로 추가 가능하고, 다른 폴더면 전체 경로에서 가져와야한다.



#### audio 넣기



```html
<audio src="C:/Users/Public/Music/Sample Music/Sleep Away.mp3" controls autoplay loop> </audio>
```



#### video 넣기



```html
<video width="800" height="640" autoplay="" controls="" loop="" >
	<source src="test.mp4" type="video/mp4">
</video>
```





### 텍스트 입력 창 (Form)



ex) 회원가입

```html
<h1>회원가입 </h1>
<form method="post" action="login.jsp" name="" id="" > <!-- get은 보안에 안좋음, post가 로그인에 적합-->

아 이 디 : <input type="text" name="userid" id = "userid"><br>
비밀번호 : <input type="password" name="userpw" id = "userpw" required><br>
<!-- required를 입력하면 그냥 넘어가지 못하게 한다. -->

URL :<input type="url" name="url" ><br> <!-- url 타입의 형식 데이터만 받아줌. -->
EMAIL : <input type="EMAIL" name="email" ><br>
연락처 : <input type="tel" name="phon" pattern="\d{3}-\d{4}-\d{4}" placeholder="000-0000-0000"><br>
<!-- pattern 과 정규표현식으로 원하는 값의 형식을 받을 수 있다. -->
<!-- placeholder 는 힌트와 같은 기능을 한다. -->

<input type="submit" value = "로그인">
<input type="reset" value = "취소">
</form>
```





ex) 그 외 유용한 메소드들

```html
number : <input type ="number" max = "100" min=0 step=5
title = "0~100사이의 값만 허용합니다. "> <br>

취미 : <input type="checkbox" name="hobby" value="등산"> 등산 
	  <input type="checkbox" name="hobby" value="등산"> 수영
	  <input type="checkbox" name="hobby" value="등산"> 코딩 <br>
<!-- 다중 선택 가능 -->

기술 : <input type="radio" name="skill" value="자바"> 자바 
	   <input type="radio" name="skill" value="오라클"> 오라클
	   <input type="radio" name="skill" value="디비"> 디비 <br>
<!-- 하나만 선택 가능 -->

<!-- 유용한 input type들 -->
date : <input type="date"><br>
time : <input type="time"><br>
week : <input type="week"><br>
month : <input type="month"><br>
color : <input type="color"><br>
range : <input type="range"><br>

Search : <input type = "Search"> <br> <!-- 검색창 -->

넓은 메모장 : <textarea rows="5" col="30">	
</textarea><br><!-- 넓은 텍스트 입력창 -->

파일 선택 : <input type= file><br> <!-- 파일 올리는 창 -->

셀렉트 연습 : <select>
	<option>서울</option>	
	<option>경기</option>
	<option>강원</option>	
	<option>경상</option>
	<option>전라</option>	
</select> <br>

리스트 검색창 : <input type=text name="fruit" list="fruits">
<datalist id = "fruits">
<option value="apple" label = "사과">	
<option value="orange" label = "오렌지">
<option value="grape" label = "포도">
<option value="lemon" label = "레몬">
<option value="mango" label = "망고">
<option value="mellon" label = "메론">
</datalist><br>

<details open>
	<summary> summary 테스트
	열린공간 : 
	</summary>
	닫힌공간 : <br>
	A<br>
	B<br>
	C<br>
	D<br>
</details>

<input type = "button" value ="버튼"> <br>

```





header, nav, section, aside, fotter 등등의 위치와 크기는 CSS로 잡아준다.



## CSS 사용 예제

※ 웹 디자인 관련 공부하고 싶으면 레이아웃 관련 예제 or 이론을 더 찾아봐야 함.



헤더에서 CSS을 사용한 부분 (Style 란에)



```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>타이틀</title>
<style>
.clear{
	clear: both;
}
header{
	width: 995px;
	height: 100px;
	margin-top: 10px;
	border : solid 1px green;
}
	nav{
		width: 995px;
		height: 70px;
		margin-top : 10px;
		border : Solid 1px green;
	}
	section{
		width: 674px;
		height: 240px;
		float : left;
		margin-top: 10px;
		border : Solid 1px green;
	}
	aSide{
		width: 290px;
		height: 240px;
		float: left;
		margin-top: 10px;
		margin-left: 29px;
		border: Solid 1px green;
	}
	footer{
		width: 995px;
		height: 130px;
		margin-top: 10px;
		border: solid 1px green;
	}


</style>
</head>
```



바디	

```html
<body>

<header>
	상단 헤더
</header>

<nav>
	내비게이션 메뉴
</nav>

<section>
	메인 콘텐츠
</section>

<aside>
	사이드바
</aside>
<div class ='clear'></div>

<footer>
	하단 푸터
</footer>

</body>
</html>
```



