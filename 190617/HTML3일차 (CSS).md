# HTML3일차 (CSS)



# CSS의 기본 구조



Selector {

​	Property : value value value;

}



ex)

```css
h2{

color : blue;

text-Shadow: 2px 2px 10px gray;

}
```





같은 스타일 태그인데 구분을 주고 싶을 경우

id, name, class등을 부여하여 구분함.





html은 markup 언어로 해당 형식은 dtd문서에 저장이 된다.

이 때 dtd언어의 Validator 가 잘 구현된 형식인지 판단하고, 검증이 된 html문서를 Wellformed 문서라고 한다.





xml은 extension = 확장 가능 형 언어로 dtd의 단점을 보완한 Schema의 형식을 사용한다.

Xml schema

- DTD의 결점을 극복하기 위해서 만들어진 언어 (DTD는 data 사용 횟수 제한등 namespace의 지원이 미흡하다.)
- DTD와 달리 Schema는 XML문서의 문법과 동일하다.



#### id 선택자

웹 페이지에서 유일무이한 단 하나의 특정 영역 지정하여 CSS 명령 적용
id명 앞에 샵(#) 붙여야한다.

ex)

(style)

```css
p{
color : gray;
}

#p1 {
color : blue;
}
```

(body)

```css
<p id = 'p1'> 안녕 </p>
```

-> 파란색 출력





#### 클래스 선택자 

두 군데 이상의 특정 영역 지정하여 동일한 CSS 적용
클래스명 앞에 점(.) 붙여야한다.

ex)

(style)

```css
.green {
color : green
}
```



(body)

```html
<span class = 'green'> 예시 초록색 클래스
```





## 박스모델 

### border

예시의 청색 경계선 등 그리는 데 사용하는 속성



##### 경계선 스타일

solid (실선)

double (이중실선)

dotted (점선)

dashed (줄 선)



##### 경계선 두께

px 단위

경계선 색상

색상 이름 혹은 코드



### padding

경계선 내부 간격

예시의 콘텐츠 ‘웹이란?’과 경계선 사이의 간격

글자와 경계선 사이의 간격



### margin

경계선 외부 간격

경계선과 외부의 요소 사이의 간격

width / height

박스의 너비 / 높이



참고 사진 :

![](<https://github.com/Q3333/ITL/blob/master/190617/pic/boxmodel.png>)







Client 제공 :

Web 페이지

html - 구조

css - 스타일

javascript -  이벤트/ 동작



서버  요청:

jsp/server (70%)

asp (15~20%)

php (10%)





##### 테이블 경계선 



§border: solid 1px #000000;§

•태그 선택자 table, th, td

•border 속성 이용하여 실선, 1픽셀 두께, 흑색 경계선 그림





##### border-collapse: collapse; 

•border-collapse 속성

•collapse 속성값

•테이블 경계선을 하나의 가는 실선으로 그림

–생략할 경우 이중실선





## 레이아웃

html5 로 넘어오면서 생긴 레이아웃 디자인



```
<header>
<nav>
<aside>
<section>
<article>

<footer>

```

+@ div, spam(구분을 짓고 스타일을 따로 주기 위해서 선언하는 분류)



### 인라인과 블록의 차이점



1.인라인(수평 방향 레이아웃)

```
display: inline;
```





2. 블록(수직 방향 레이아웃)

```
display: block;
```





#### *div 와 span

 div, span이 있는데 div를 쓰는 이유는 div는 전 페이지에서 설명했던 block의 개념이고 

span은 inline의 개념이다.



페이지를 만들 때는 영역을 아예 나눠야 되기 때문에 주로 div를 사용한다.





### float :

왼쪽, 오른쪽으로 붙여서 출력

왼쪽에 2개의 플롯 을 넣으면 순서대로 1 - 2 로 나열되서 출력됨 



#### 

#### clear:both;

float으로 사진이 겹쳐서 깨질 때 사용 





![](<https://github.com/Q3333/ITL/blob/master/190617/pic/색관련.png>)



alpha : 투명도

hsl 은 색조, 채도, 명도를 조절해줌.





### 디자인 예제 1 - 책 구매 사이트

```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
*{
	margin: 0;
	padding: 0;
}

ul {
    list-style-type: none;
}


#main_title {
    font-family:'맑은고딕';
    margin:10px;
    padding-bottom:6px;
    border-bottom:solid 2px #aaaaaa;
}

.list_item {
    clear: both;
    height: 130px;
    margin: 10px;
    border-bottom: solid 1px #cccccc;
}



.image{
	float: left;
	width: 100px;
	height: 100px;
}

.intro{
	float: left;
	width: 300px;
	margin-left: 20px
}

.price{
	float: left;
	width: 150px;
}

.red{
	font-weight: bold;
	color: red;
}
.small{
	font-size: 12px;
	margin-top: 5px;
}
.writer {
    float:left;
    width: 100px;
}

.img {
	 width: 100px;
     height: 120px;	 
}


</style>
</head>
<body>

	<h1 id="main_title"> 판매 도서 목록</h1>

	<div class='list_item'>
		<div class = 'image'><img class="img" src="cheese.jpg"></div>
		<div class = 'intro'>[문학동네] 여행의 이유</div>
		<ul class = 'price'>
			<li class = 'red'>  13,500 원</li>
			<li class = 'small'> 배송비 2,500원 </li>
		</ul>

		<div class = 'writer'> 김영하 저 </div>
		
	</div>

<div class='list_item'>
		<div class = 'image'><img class="img" src="cheese.jpg"></div>
		<div class = 'intro'>[해냄] 천년의 질문</div>
		<ul class = 'price'>
			<li class = 'red'>  14,800 원</li>
			<li class = 'small'> 배송비 2,500원 </li>
		</ul>

		<div class = 'writer'> 조정래 저 </div>
		
	</div>

			
</body>
</html>
```



※  border-bottom:solid 2px #aaaaaa; 을 해줌으로써 테두리를 아래만 선을 그어줄 수 있다.

※  image, intro, price, writer를 float으로 선언해서 한 줄로 붙여 나오게 하고, margin-left로 거리를 조절해줬다.





### 속성값으로 스타일 주는 예제

```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	input[type=text] { background : red; }
	input[type=password]{background-color : blue;}


	img[src$=png]{
		border: 3px dashed skyblue;
	}

	img[src$=jpg]{
		border: 3px dotted black;
	}

</style>
</head>
<body>

	<input type="text" name="">
	<br>
	<input type="password" name="">
	<br>
	<img src = ./images/logo2.png>
	<br>
	<img src = ./images/main.jpg>


</body>
</html>
```



참고용 사진 :

![](<https://github.com/Q3333/ITL/blob/master/190617/pic/속성.png>)



png, jpg로 끝나는 속성에만 스타일을 주기 위해 src$=png, jpg를 사용했다.



그 외의 정규 표현식은 위의 사진 참고.





# 반응형 선택자

```css
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	
	h1:hover {color : white;
				background-color: black;}

	h1:active {color : yellow;}

</style>
</head>
<body>
	<h1>User Acion Example</h1>
</body>
</html>
```



마우스를 올리면 하얀글씨, 선택하면 노란글씨로 설정



##### 추후 반응형 웹 만들 때 도움이 될 듯



### 동위 선택자 관련 예제

```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	h1+ h2 {color: white;}

	h1 ~h2 {background-color: orange}

</style>

</head>
<body>

<h1>Header -1 </h1>
<h2>Header -2 </h2>
<h2>Header -2 </h2>
<h2>Header -2 </h2>
<h2>Header -2 </h2>


</body>
</html>
```



h1의 바로 뒤에 있는 h1를 변환할 때 +를 하고 (h1 + h2 )

그 뒤에 있는 모든 h2를 변환하고 싶을 때는 ~를 쓴다. (h1 ~ h2)



### 구조 선택자 관련 예제

```css
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	ul {overflow: hidden;}
	li{
		list-style: none;
		float:left; padding:15px;
	}

	li:first-child{border-radius: 10px 0 0 10px;}
	li:last-child{border-radius: 0 10px 10px 0;}

	li:nth-child(2n){background-color: #04Ef30}
	li:nth-child(2n+1){background-color: #1f88fd}

</style>
</head>
<body>
	<ul>
		<li>First</li>
		<li>Second</li>
		<li>Third</li>
		<li>Fourth</li>
		<li>Fifth </li>
		<li>Sixth</li>
		<li>Seventh</li>
	</ul>
</body>
</html>
```

지렁이 모양으로 색이 바뀐 배열이 나타남.





#### 그 외 수업 시간에 연습한 예제

```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	h2{
		border: dashed 1px blue;
		
		
	}
	#Serengeti{
		border: dashed 1px blue;
		
		color:blue;
		text-shadow: 2px 2px 10px gray;
		

		padding: 0;
		margin: 0;
	}
p{
	border: dashed 1px blue;
	/*
	color: #444444;
	font-size: 18px;
	font-family: '바탕';
	line-height: 150%;
	margin-top: 20px;
	*/

}
span{
	border: dashed 1px blue;
	/*
	font-weight: bold;
	color: #0e9bdc;
	text-decoration: underline;
	*/

}
li{
	border: dashed 1px blue;
	/*
	list-style-type: square;
	*/

}

h3{
	border: dashed 1px blue;
	/*	padding: 50px;
	margin: 30px;

*/

}

h4{
	border: double 1px green;

/*
	padding-top: 80px;
	padding-right: 100px;
	padding-bottom: 120px;
	padding-left:  140px;

	margin: 30px;
	*/
}

body{background-color: #0000009);}
#button {
	width: 120px;
	height: 25px;
	padding: 8px;
	background-color: blue;
	color: white;
	text-align: center;
}
table,th,td{
	border: solid 1px #000000;
}

table{
	border-collapse: collapse;
}

th{
	width: 80px;
	padding: 6px;
}

td{
	padding: 6px;
	text-align: center;
}

#day{
	background-color: #adf0f4;
}

#title{
	background-color: #abcff4;
}

#v_menu li{
	padding: 5px;
	border-bottom: dotted 1px black;
}


#h_menu li{
	display: inline;
}

</style>

</head>
<body>
<h2 id="Serengeti">세렝게티 국립공원</h2>
<p><span>탄자니아의 킬리만자로산 서쪽</span>에 위치한 세렝게티(Serengeti)의 광활한 평원은 면적이 1,500,000ha 이며, 사바나 지역에 있습니다. <span>사자, 코끼리 들소, 얼룩말</span> 등 약 300만 마리의 대형 포유류가 살고 있습니다. </p>
</p>


<h3>축제명 : 제주 마을박람회 축제</h3>
<ul>
	<li> 일 시 : 2018년 9월 중</li>
	<li> 월대천 및 외도동 일대</li>
	<li> 주요 프로그램 : 어린이 사생대회, 뜸돌들기, 은어 낚시, 소원 빌기</li>
</ul>



<h4>웹이란?</h4>
<p>
	웹은 ~~~ 이다.
</p>

<h3> 캠핑장 9월 예약</h3>
<ul>
	<li>
		9월분 예약 2019년 8월 16일(수)
		14:00부터~
	</li>
	<li>
		문의전화 : 031-222-1234
	</li>
</ul>
<div id = 'button'>
	자세히보기 &gt;
</div>


<h2> 고속버스 예매 </h2>

<table>
  <tr id = 'day'>
    <th colspan='4'>서울 &lt=&gt 대전 2020.9.6 수</th>
  </tr>
  <tr id='title'>
    <th>출발</th>
    <th>버스회사</th>    
    <th>등급</th>  
    <th>예약가능</th>    
  </tr>
  <tr>
    <td>11:50</td>
    <td>한진고속</td>
    <td>우등</td>
    <td><img src='./full.png'></td>
  </tr>
  <tr>
    <td>12:50</td>
    <td>천일고속</td>
    <td>고속</td>
    <td><img src='./empty.png'></td>
  </tr>
  <tr>
    <td>13:50</td>
    <td>한진고속</td>
    <td>우등</td>
    <td><img src='./full.png'></td>
  </tr> 
</table>


<h2>인라인과 블록의 차이점</h2>

<h3>1. 인라인(수평 방향 레이아웃)</h3>
<img src="./cheese.jpg">
<span>치즈</span>
<img src="./juice.jpg">
<span>오렌지 주스</span>

<h3>2. 블록(수직 방향 레이아웃)</h3>
<p>이것은 단락입니다.</p>
<div>박스 A</div>
<div>박스 B</div>
	

	<h3> 1. 세로메뉴</h3>
	<ul id='v_menu'>
	<li>
		9월분 예약 2019년 8월 16일(수)
		14:00부터~
	</li>
	<li>
		문의전화 : 031-222-1234
	</li>
</ul>

	<h3> 2. 가로메뉴</h3>
	<ul id='h_menu'>
	<li>
		9월분 예약 2019년 8월 16일(수)
		14:00부터~
	</li>
	<li>
		문의전화 : 031-222-1234
	</li>
</ul>


</body>
</html>
```

