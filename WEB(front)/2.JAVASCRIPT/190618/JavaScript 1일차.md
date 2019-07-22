# JavaScript 1일차



#### 컴파일 언어와 인터프리터 언어



컴파일 언어 : 소스 코드를 실행하기에 앞서 기계어로 번역하는 행위를 컴파일이라고 하는데 이러한 컴파일 후에 실행되는 프로그래밍 언어를 말한다.

ex) C, C++, Java 등



인터프리터 언어 : 프로그램을 한 줄마다 기계어로 번역해서 실행하는 프로그래밍 언어

ex) Ruby, Python, LISP, Perl



#### 자바 스크립트의 특징



1. 인터프리터 언어다.

- 최근 웹 브라우저들에는 대부분  JIT(Just In time Compiler)가 내장되어 있어 실행속도가 매우 빨라졌다.

  

2. 동적 프로토 타입 기반 객체 지향 언어다.

- 자바스크립트는 클래스와 비슷한 프로토타입을 상속하며, 프로토타입 기반 객체 지향 언어다.

- 객체를 생성한 후에도 프로퍼티(속성)와 메서드(기능)를 동적으로 추가하거나 삭제할 수 있다.

  

3. 동적 타입 언어다.

- 자바스크립트는 변수 선언시 타입이 없다.

- 실행 도중에 변수에 저장되는 데이터 타입이 동적으로 바뀔 수 있다.

  

4. 함수가 일급 객체다.

- 자바스크립트의 함수는 객체이며 함수에 함수를 인수로 넘길 수 있다.

  

5. 함수가 클로저를 정의한다.

- 클로저는 변수를 은닉하거나 영속성을 보장하는 등 다양한 기능을 구현할 수 있다.



자바스크립트 코딩 시 출력 방법:

console.log : 콘솔창에 출력시킴

document.write : html문서 내의 바디에 출력시켜줌



## (중요)자바스크립트의 변수 선언 :

- 모든 변수 키워드를 var로 선언한다. (구분 X)

- 선언된 변수는 **위치에 상관없이 끌어올려서(hoisting, 호이스팅)** 프로그램 첫 부분에 선언된 것 처럼 처리된다.

  (but 선언과 동시에 대입하는 코드는 끌어올리지 않는다. 

  ex) 

  console.log(x);

  var x = 5; -> undefined

- 중복된 선언은 가장 아래에 선언된 값을 따른다.



### JavaScript의 타입들



원시 타입, Primitive Type

- Number = 정수, 실수 전부 똑같음

- String = javascript
- boolean = true,false
- 특수한 값 = undefined 타입 (정의되지 않은 상태), null 타입 (가져올 데이터가 없을 때)
- 심벌



객체 타입, Reference Type

- Object = [], {} ( JSON 객체)  

- Function = 함수들, function() {};





### #HTML 문서에 자바 스크립트를 넣을 때



```html
<head>
<!-- 1. 헤드에서 입력-->
    <script>
    //자바스크립트 코드 - 전역변수선언, 함수 선언
    //body의 요소를 참조하거나, 사용하는 자바스크립트 실행 문장은 오류 발생함.
    </script>
</head>
<body>
<!-- 2. 바디에서 입력-->
<script>
    //자바스크립트 코드 - 즉시 실행 문장 코드
</script>
</body>
```



#### ※ HTML문서와 자바스크립트를 분리하는 것을 권장.

```html
<head>
<script type = "text/javascript" src="경로/파일.js"></script>
</head>
<body>
</body>
```



**알림 실행 예제** (alert)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
window.alert("head 태그내에 포함된 javascript 실행")
</script>
</head>
<body>
<script>
alert("body 태그내에 포함된 javascript 실행")
</script>
</body>
</html>
```



외부파일 실행 예제 (src)

```http
<head>
<meta charset="utf-8">
<title>JS03</title>
	<script src="first.js">
</script>
</head>
```



헤더부분에 src로 가져와줌



 ( js 코드 - first.js )

```javascript
window.alert("first.js파일에 저장된 javascript 코드 실행")
```





#### == 와 === 연산자

== : 값만 비교

ex) : 전부 True를 리턴

```
	document.write("null == undefined : " + (null == undefined) + "<br>");
		document.write("1 == '1' : " + (1 == '1') + "<br>");
		document.write("255 == '0xff' : " + (255 == '0xff') + "<br>");
		document.write("true == 1 : " + (true == 1) + "<br>");
		document.write("true == '1': " + (true == '1') + "<br>");
		document.write("new String('a') == 'a' : " + (new String('a') == 'a') + "<br>");
		document.write("new Number(2) == 2 : " + (new Number(2) == 2) + "<br><br>");
		// ==은 값만 비교한다. 자바스크립트 엔진에서 자동 형변환이 수행됨
```



=== : 값 + 타입도 비교

ex) : 위와 같은 문제들이지만 전부 False를 리턴

```
document.write("null === undefined : " + (null === undefined) + "<br>");
		document.write("1 === '1' : " + (1 === '1') + "<br>");
		document.write("255 === '0xff' : " + (255 === '0xff') + "<br>");
		document.write("true === 1 : " + (true === 1) + "<br>");
		document.write("true === '1': " + (true === '1') + "<br>");
		document.write("new String('a') === 'a' : " + (new String('a') === 'a') + "<br>");
		document.write("new Number(2) === 2 : " + (new Number(2) === 2) + "<br><br>");
```



### 산술연산

javascript의 연산 특징

1. 정수끼리 나누어도 결과가 부동소수점이된다. 

   ex) 7/2 = 3.5 (자동형변환)

2. 연산자는 피연산자 중 하나가 문자열이면 나머지 피연산자를 문자열로 만든다.

   ex) 1+"2month" = "12month"

3. 계산할 수 없는 경우는 NaN(Not a Number)으로 평가한다.

   ex) 0/0 , "one" *1 = NaN

4. 논리값의 연산은 숫자로 바꾸어서 연산한다.

   ex) true+ture = 2 (false는 0)





### Math 객체



Math.abs(x), round(x), max(x,y), min(x,y), random()

등 자주 쓰이는 Math객체는 자바스크립트에도 있다.



### 명시적 타입 변환

* 자바스크립트는 자동으로 피연산자의 타입을 바꿔주지만 변수 값을 출력하기 위해서 명시적으로 변환을 해 주어야 하는 경우가 있다.



**String 함수**는 형변환 기능도 포함하고 있다.

String(true) = "true"

String [1,2,3] = "1,2,3"

String(26) = "26"



**Number 함수**는 숫자형태로 바꿔준다.



Number (true) = 1

Number(undefined) = NaN

Number(null) = 0



**parseInt() & parseFloat()** **함수**

정수 -> 실수

실수 -> 정수로 형 변환해주는 함수들

parseInt("3.14") = 3

parseFloat("3.14 meters") = 3.14 (숫자 다음에 등장하는 문자열은 무시)

##### 

#### 논리값으로 형 변환

!!값 또는 Boolean(값)

ex)

```javascript
document.write(!!" "+"<br>")
document.write(!!null+"<br>")
document.write(!!undefined+"<br>")
document.write(Boolean(NaN)+"<br>")
```

​	

## 제어문



#### ※ prompt(숫자, 스트링 받을 때)

#### ※ confirm(boolean 값 입력 받을 때 )



문1) if문

```javascript
var input = prompt("숫자를 입력하세요", 0)
if(Number(input)%2==0){
 		 document.write("짝수입니다.")
 	}
 	else if (Number(input)%2==1){
 		 document.write("홀수입니다.")
 	}
 	else{
 		 document.write("정수 값을 입력하시오")
 	}
```



문2) 삼항연산자 -> (조건식)? true일때 값 : false일때 값

```javascript
 var input2 = prompt("숫자를 입력하세요", 0)
 document.write((Number(input2%2==0)?"짝수입니다." : "홀수입니다" ))
```



문3) &&, || 연산으로 풀기 

```javascript
var input3 = prompt("숫자를 입력하세요", 0);
(input3%2==0) || document.write("홀수입니다");
(input3%2==0) && alert("짝수");
```



문4) case문

```javascript
var input4 = prompt("숫자를 입력하세요", 0)

switch(Math.trunc((Number(input4)/10),1)){
	case 10 :
	case 9 : document.write("A등급 입니다.")
	break;
	case 8: document.write("B등급 입니다.")
	break
	case 7: document.write("C등급 입니다.")
	break
	case 6: document.write("D등급 입니다.")
	break
	default : document.write("F등급 입니다.")
```



※ 자바스크립트는 case 문에 직접적인 조건식을 넣어줘도 실행이 된다.

ex)

```javascript
var input5 = prompt("숫자를 입력하세요", 0)
switch(true){
	case input5>89 : document.write("A등급 입니다.")
	break;
	case input5>79: document.write("B등급 입니다.")
	break
	case input5>69: document.write("C등급 입니다.")
	break
	case input5>59: document.write("D등급 입니다.")
	break
	default : document.write("F등급 입니다.")
}
```

input5>89로 직접적인 값을 넣어줘도 실행이 됨



## 반복문



for문

```javascript
 for(var i=0;i<10;i++){
  		if(i%2!=0)document.write(i);
  }
```



while문

```javascript
  var i=0;
  while (i<10){
  	if(i%2!=0)document.write(i);
  	i++;
  }
```



do while 문

```javascript
	var i =0;
  do{
  	if(i%2!=0)document.write(i);
	i++;

  }while(i<10);
```



배열 반복문

```javascript
  var nums = [1,2,3,4,5,6,7,8,9,10]
  for(var n in nums){
  	if(nums[n]%2!=0)
  		document.write(nums[n]);
  }
```



구구단 출력문

```
 for(var su = 1; su<10; su++ ){
 	for(var dan=2; dan<10; dan++){
 		document.write(`${dan} X ${su} = ${dan*su}\t`);
	}
	document.write("<br>")
 }
```





