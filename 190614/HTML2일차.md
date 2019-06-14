

# HTML 2일차



하이퍼링크 , 맵 관련 예제

```html
<img src="./navi.jpg" alt="" usemap="#Map1"/> 
<map name="Map1">
	<area shape = "rect" coords = "0,0,40,35" href="https://www.naver.com/" alt = "메일" border = "0" />

	<area alt = "카페" href="http://section.cafe.naver.com" 
	shape = "rect" border = "0" coords="40,0,70,35" />

	<area alt = "블로그" href="http://section.blog.naver.com" 
	shape = "rect" border = "0" coords="70,0,115,35" />

</map>

```



이미지 navi :

![](<https://github.com/Q3333/ITL/blob/master/190614/navi.jpg>)



iframe에서 하이퍼링크로 이동하는 예제

```html
<h2>국내 주요 사이트</h2>
<p><a href="https://www.naver.com/" target = "site">네이버</a></p>
<p><a href="http://www.daum.net" target = "site">다음</a></p>
<p><a href="https://www.google.com/?gws_rd=ssl" target = "site">구글</a></p>
<iframe width="800" height="300" src="http://www.yes24.com" name="site">
</iframe>
```





유튜브 영상 올리기 + 사진으로 하이퍼링크 이동하기 

```html
<p> 유튜브 </p>
<embed src = "https://www.youtube.com/embed/RkvwKz5KSkA"
width="640" height="360" allowfullscreen>


<p> 구글로 이동하기 </p>
<a href="http://www.google.com/"><img src = "Penguins.jpg" width = 300 height = 300></a>
```





select문 메뉴 포함해서 보여주기

```html
<form>
	<label>점심 메뉴를 고르시오.
		<select>
			<optgroup label="한식">
				<option> 비빔밥 </option>
				<option> 갈비탕 </option>
				<option> 김치찌개 </option>
				<option> 된장찌개 </option>
			</optgroup>

			<optgroup label="중식">
				<option> 짜장면 </option>
				<option> 짬뽕 </option>
				<option> 탕수육 </option>
				<option> 볶음밥 </option>
			</optgroup>

			<optgroup label="양식">
				<option> 오므라이스 </option>
				<option> 스테이크 </option>
				<option> 돈가스 </option>
			</optgroup>


		</select>
```



optgroup은 선택을 할 수 없고 카테고리만 나눠서 보여주는 역할.





frame을 이용해서 세가지 file을 화면에 띄우기

Top

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Top</title>
</head>

<body style="background-color:green">
	<H3>Top</H3>
```



Left

```html
<body style="background-color:purple">
	<H3>Left</H3>
```



Right

```html
<body style="background-color:Skyblue">
	<H3>Right</H3>
```



합친 프레임

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Frame</title>
</head>

<frameset rows = "40%, 60%">
	<frame src="top.html" />	
	<frameset cols="30%,70%">
		<frame src="left.html" />
		<frame src="right.html" />
	</frameset>

</frameset>
```



레이아웃 연습 2 

```html
<html>
<head>
<meta charset="utf-8">
<title>Layout2</title>
<style>
.clear{
	clear: both;
}
header{
	background: yellow;
	font: bold;
	font-size: 30px;
	width: 995px;
	height: 100px;
	margin-top: 10px;
	border : solid 2px blue;
}
	
	section{
		background: grey;
		width: 700px;
		height: 260px;
		float : left;
		margin-top: 10px;
		border : Solid 1px green;

	}

	article{
			background: ivory;
			width: 650px;
			height: 70px;
			float : left;
			margin-top: 10px;
			margin-left: 25px;
			border : 2px solid black;
			border-radius: 8px;
	
	aSide{
		background: orange;
		width: 290px;
		height: 35px;
		float: left;
		margin-top: 10px;
		margin-left: 29px;
		border: Solid 1px green;
	}
	footer{
		background: yellow;
		width: 995px;
		height: 20px;
		margin-top: 50px;
		border: solid 1px green;
	}

</style>
</head>
<body>

<header>
	머리말입니다.
</header>

<section>
	<article>
	첫 번째 기사
	</article>

	<article>
	두 번째 기사
	</article>

	<article>
	세 번째 기사
	</article>

</section>

<aside>
	광고입니다 계란 사세요 계란
</aside>
<div class ='clear'></div>

<footer>
	꼬리말입니다. 회사 연락처 등
</footer>

</body>
</html>
```





### 패딩과 마진



@ 패딩   내용@   마진  @ 내용 

​		

**마진은 내용과 내용 사이의 공백**



**패딩은 안쪽 부분의 공백**



ex) 패딩이 클 경우



@  																	내용 @



ex) 마진이 클 경우

@ 내용 @ 																	@내용@





**css 파일 참고용**

```css
@charset "utf-8"  
/* CSS문서에서 html과 호환성을 맞추기 위해 선언 */
/* CSS Document */

	body{
		font-family: "맑은 고딕", "고딕", "굴림";
	}

header{
	width: 620px;
	margin-right: auto;
	margin-left: auto;
	background-color: #069;
	padding: 10px;
	overflow: hidden;
}

header h1{
	width:140px;
	float:left;		/* 왼쪽에 붙여서 출력 */
	color:#ffffff;
}

header nav {
	width:460px;
	float:right;	/* 오른쪽에 붙여서 출력 */
	margin-top : 15px; /*헤드 태그와의 거리 */
}

nav ul{
	list-style-type: none;
}

nav ul li {
	display:  inline;  /* 줄바꿈 안한다는 의미 */
	float : left;  /* UI 기준으로 왼쪽 */
	margin: 10px;
}

nav ul li a {
	color: white;
	text-decoration: none; /* 텍스트에 대한 데코레이션 */
}

p{
	font-size: 15px;
	line-height:20px;
}

section{
	width: 600px;
	margin-right: auto;
	margin-left: auto;
	border: 5px solid #333;
	padding: 15px;
}

img#puppy{
	float:right;
	margin-left: 10px;
	border:1px solid #ccc;
	box-shadow: -2px 3px 5px #000;
	-moz-box-shadow : -2px 3px 5px #000;
	-webkit-box-shadow : -2px 3px 5px #000;
}

footer{
	width: 620px;
	margin-top: 0;
	margin-left: auto;
	margin-right: auto;
	padding : 10px;
	background-color : #333;
	color : white;
	text-align: center;
}

```



​	text-align: center; 을 하면 중앙에 위치하게 된다.

​	padding을 설정해줌으로써 넓어진 영역을 확보하게 된다.



### 가입정보 관련 예제 

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>가입 정보</title>

<style>
	body{
		background: #666;
	}
	h1{
		text-align: center;
	}

	#container{
		width:450px;
		margin:15px auto;
		padding: 10px;
		border: 1px solid #666;
		border-radius: 10px;
		background: white;
	}
	ul{
		list-style-type: none;
	}
	ul li {
		line-height: 25px;
		margin-bottom: 10px
	}

	label{
		width: 80px;
		float: left;
		text-align: right;
		padding-right: 5px;
		font-weight:bold;
	}
	.centered{
		text-align: center;
	}

</style>
</head>
<body>

<div id = "container">
<h1> 가입 정보</h1> 

<form method="post" action="register.jsp" name="" id="reg_form" >
	<ul>
		<li>
			<label for = "uname">이름 </label> 
			<input type ="text" id = "uname" placeholder="홍길동" required="" autofocus="">
		</li>
		<li>
			<label for = "email">이메일 </label>
			<input type ="EMAIL" id = "email" placeholder = "abcd@abcd.com">
		</li>
		<li>
			<label for = "pw">비밀번호 </label>
			<input type="password" id= pw required="">
		</li>
		<li>
			<label for = "sex">성별 </label>
			<select id ="sex">
				<option value ="w"> 여성 </option> <!-- register.jsp에는 여성,남성이아니라 value의 w,m값이 전송된다.-->
				<option value ="m"> 남성 </option>
			</select>
		</li>
	</ul>

<div class = "centered"> <!-- div는 영역만 잡아주고 형태는 없다. -->
	<input type="submit" value="가입하기">
</div>

</form>
</div>
    
</body>
</html>
```

