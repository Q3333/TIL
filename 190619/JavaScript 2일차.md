# JavaScript 2일차

## 1일차 복습

### 자바스크립트란?

- 인터프리터 언어

- 동적 프로토타입 기반의 객체지향언어

- 동적 타입 언어

- 함수 기반 언어, 함수가 객체 => 함수형 프로그래밍 언어

  (함수를 변수에 저장, 함수의 인수로 함수를 전달, 함수 내부에 함수를 정의 가능하다.)

- 클로저 함수(은닉되어 있는 변수를 끌어올 수 있음)



#### 자바스크립트 구성 기술 요소 :

- EMCAScript Core
- 브라우저 제공 API(window, document, XMLHttpRequest, ...)
- HTML5 API (Geolocation, WebWorks, Canvas, Video, Audio, DragnDrop, ...)



#### 자바스크립트 분류

- 클라이언트 측 기술 (jQuery, Vue.js, React.js, ...)
- 서버 측 기술 (node.js)



#### 자바스크립트 코드 작성 문법 :

- 인코딩은 utf-8 권장
- 대소문자 구분
- .js 파일로 저장
- 한 문장 단위로 ;으로 구분합니다.



#### 자바스크립트의 주석 :

// 한줄 주석

/* 여러줄 주석 */



### 변수?

처리해야 할 값을 메모리에 저장하고 값을 참조하기 위해 사용하는 이름

변수 선언 : var 



#### 변수명 naming 규칙 : 

_, $, 영문자로 시작

두번째 문자부터는 숫자도 허용

길이 제한 없음.

키워드 X, 내장함수명 X, 내장객체명 X



#### 자바 스크립트의 데이터 유형 :

primitive type : number, string, null, symbol, undefined, boolean

reference type : function, object, interface, ... 배열 Array는 객체입니다.(object)



-선언되지 않은 변수를 참조하면 반환되는 값은 ?

- ReferenceError

-선언은 되었지만 초기값이 할당되지 않은 변수를 참조하면 반환되는 값은?

- undefined

-객체를 메모리에서 검색을 했는데, 검색되지 않으면 반환되는 값은?

- null



#### 자바 스크립트 출력 방법 :

document.write()

document.writeln() = html에서는 적용 안됨.

-> html 문서의 body 영역 내에 출력을 시켜줌



console.log(), 

console.dir() = 내부상태를 보여줌?

=브라우저 또는 node같은 자바스크립트의 실행창 콘솔에 출력을 시켜줌



window.alert ("메세지)" : 알림 출력 



자바 스크립트 입력 방법  :

window.prompt("메세지", 입력받지 않았을 때의기본값) - 반환 타입은 문자열2

window.confirm("메세지") - 반환타입은 boolean



#### 자바 스크립트 연산자  :

산술 연산자 - *, /, %, +, -

단항 연산자 - ~, !, +, -, ++, --

비교 연산자 - >, >=, <, <=, ==, != , ===, !===

※ == 은 값만 비교, ===은 값과 타입을 비교

비트 연산자 - &, |, ^

논리 연산자 - &&, ||

Shift 연산자 - <<, >>, >>>



삼항 연산자 - 조건?항1: 항2

조건이true일 때 항1 반환,

false일 때 항2 반환



기타 연산자 - typeof, in, instanceof, ...



### 제어문 :

#### 1.if문 

if (조건) {문장 ;}



if (조건) {

문장;

...

} else {

문장;

....

}





다중 if문

if (조건) {

문장;

...

} else if (조건) {

문장;

....

}

} else {

문장;

....

}



### 2.Switch문

​	switch(표현식){

​		case 값 : 문장; break;

​		case 값 : 문장; break;

​		case 값 : 문장; break;

​		default : 문장;

}



switch(true)

{

​		case 값 : 문장; break;

​		case 값 : 문장; break;

​		case 값 : 문장; break;

​		default : 문장;

}



### # 반복문

반복 횟수 알고 있을 때 for(var count < 조건 ; count 증감식){

반복 수행 문장

}



조건에 따라 반복 수행 여부를 결정해야 할 때 :

while(조건) {

반복 수행 문장;

}



최초 1번은 무조건 수행 후에 조건에 따라 반복 수행 여부를 결정해야 한다.

do{

​	반복 수행 문자;

​	}while(조건);



배열의 요소를 또는 객체의 속성을 순차적으로 꺼내올 때 사용할 수 있는 반복문

for ( var 변수 in 배열 또는 객체 ){

반복 수행 문장;

}



※ console.log(num);

var num =10; =

-> 정상 실행

-> 선언 문장은 hoisting 되어서 아래에 위치해있다 해도 소스 구성 상 맨 위로 끌어올린다.

-> global object인 window의 proeprty로 추가됨 ()



템플릿 리터러과 placeholder 포맷형식 문자열에 실행시에 인수를 전달해서 출력하려면



템플릿 리터럴 : `포맷형식 문자열`

placeholder : ${변수} 문자열 

-> 변수로 넘어오는 값이 문자열과 결합을 하게 됨.



#### 자바 스크립트의 형 변환 :

문자열로 형변환 - 값 + "", String()

정수나 실수로 형 변환 -  Number(), window.parseInt, window.parseFloat

논리형으로 변환 - !!값 , bololean()







## 객체

- 자바스크립트에서는 원시 타입(primitive type)을 제외한 모든 값이 객체다.

- 객체는 객체 리터럴과 생성자로 생성할 수 있다.



자바 스크립트 객체 생성 방법 :

1. 객체 리터럴 - JSON, 하나의 객체만 생성해서 사용하는 경우
2. 생성자 함수 정의 - new 사용, 필요할 때 마다 생성자 함수로부터 객체 생성



객체는 이름 과 값을 가지는데

이름은 **프로퍼티 이름** 또는 **키**라고 부르고 

값(데이터)는 **프로퍼티** 라고 부른다.



객체의 모든 키 값을 가져오기 : 

```javascript
for(var key in employee){ // key 변수에는 객체의 property가 저장된다.
		document.write(key + " : " + employee[key] + "<br>");
	}
```



toString을 오버라이드해서 출력 형태의 함수 만들어서 출력하기 :

```javascript
	employee.toString = function(){
		var output="";
		for(var key in this){
			if(key != 'toString'){
				output+=key+" : " + this[key]+"\n";
			}
		}
		return output;
	}
	
	document.write(employee + "<br>");	//둘 다 같은 값
	document.write(employee.toString() +"<br>"); //둘 다 같은 값
```



객체 키 값 삭제

delete



사용 예 : 

```
delete employee.address;
delete(employee.address);

둘 중 어느쪽도 ㄱㅊ

```





객체 키 값들의 합, 평균 구하기

```
var student = {이름 : '홍길동', 영어 : 88, 국어:90, 수학:77, 과학 : 75};

	document.write(student.이름+"의 총점 : " + (student.영어+student.국어+student.수학+student.과학) + "<br>"); // 이름과 총점 출력

	with(student){
		document.write(이름+"의 평균 : " + (영어+국어+수학+과학)/4 +"<br>")
	}// 평균 출력, 
```



#### with

with를 사용하면 해당 객체의 변수 값들을 객체.변수 에서 객체를 빼버리고 변수 이름으로만 참조 가능하게 된다.



### 객체 리터럴 생성 방식 : 

- for in 반복문을 객체의 속성에 접근할 때 사용 가능

- 객체에 대해서 사용하는 in 키워드는 속성 존재 여부를 체크할 떄 사용할 수 있습니다. 

- 객체의 속성을 객체.속성 대신 속성만으로 사용할 때 **with(객체){ }**(위의 예제 에서 사용)을 사용합니다. 

- 객체 리터럴 방식으로 정의되는 객체는 동적으로 속성, 메소드를 추가 하거나, 제거할 수 있습니다.





<h3>자바 스크립트 함수</h3>
- var 변수 = function(){} ; // 익명(anonymous) 함수

- function 이름() { } // name function, 선언적 함수 

- 사용자 정의 함수는 소스가 공개되지만, 내장함수등은 소스는 native code로 공개하지 않는다.

- 변수에 저장된 익명함수는 정의된 후에 호출이 가능하지만

- 자바스크립트 엔진은 실행코드보다 먼저 선언적 함수를 읽는다.(hoisting)

- 선언적 함수는 defintion전에 호출을 하더라도 실행 순서상 문제가 되지 않는다.

  

함수 선언은 변수처럼 끌어올림(hoisting)을 해준다.

아래에서 선언해도 위에서 사용 가능.



함수 예제 

```javascript
// 에러발생 func1(); //변수에 저장된 함수 호출
	func2(); // 선언적 함수(named function) 호출

	 var func1 = function(){
	 	var jum = prompt("1~100사이의 수를 입력하세요", 0);
  		document.write((Number(jum%2==0)?"짝수입니다." : "홀수입니다" ))
	}
	 function func2(){
		var jum = prompt("1~100사이의 수를 입력하세요", 0);
  		document.write((Number(jum%2==0)?"짝수입니다." : "홀수입니다" ))
	
	}	 

	func1(); // 정상실행
```





### 모든 함수 가변인자를 가지는 함수로 정의할 수 있다.

함수가 실행될때 실행 컨텍스트에서는 함수 내부에 arguments 배열과 유사한 타입의 속성이 생성된다.

arguments에 함수를 호출할때 입력값인 인수가 저장된다. 

함수에 정의된 매개변수의 개수보다 많은 매개변수로 호출하면 실행시에 무시된다.

함수에 정의된 매개변수의 개수보다 적은 매개변수로 호출하면 undefined로 전달된다.





### 내부함수, 외부함수

- 자바스크립트에서 배열은 모든 타입을 요소로 저장할 수 있습니다.

- 함수 내부에 함수를 정의 할 수 있다. 

   => 외부함수와 충돌이 발생되는 경우, 함수를 사용하는 내부에 정의할수 있으며, 

- 내부함수는 내부함수가 정의된 함수 내부에서만 호출할 수 있다.



내부함수 예제)

```javascript
function pythagoras(width,height){ // 직각 삼각형의 빗변의 길이
		function square(x){ // 내부함수
			return x*x;
			}
		return Math.sqrt(square(width)+square(height));
	}
```





### 함수 리턴 + 전역, 지역함수 (★)

- 함수를 매개변수로 전달하고, 함수를 리턴하는 함수를 정의 가능 

- **var 키워드를 생략한 함수 내부에 선언된 변수**는 **함수호출후에 전역변수**로 Global 실행 컨텍스트에 생성된다. 

  => 함수외부에서 참조가 가능해진다.



```javascript
var globalVar = 'korea';//전역변수 
	function test(name){
		globalVar2 = name;//var 키워드를 생략한 함수 내부에 선언된 변수는 함수호출후에 전역변수로 Global 실행 컨텍스트에 생성됩니다. 함수외부에서 참조가 가능해집니다.
	
	var localVar = "Hello~" +name + "!!";//로컬변수
	return function(){
		return localVar;
	}
}

document.write("전역변수 globalVar :"+ globalVar+"<br>"); // 정상수행 

//document.write("전역변수 globalVar2 :"+ globalVar2+"<br>"); 
// 에러 (function test 가 아직 실행이 안되었음.)

 test('독도');//함수 호출 후

document.write("전역변수 globalVar2 :"+ globalVar2+"<br>"); // 정상수행

//document.write("지역 변수 localVar :"+ localVar+"<br>");  
//에러 (지역 변수는 직접적으로 참조 불가능.))

document.write("지역 변수 localVar를 클로저 함수를 통해 참조 가능"+ test('제주도')()+"<br>");  


```



함수 test 안에 넣은 globalvar2는 한번 실행 된 후에 전역변수가 된다.

※ test 함수를 사용할 때 test('제주도')의 형태가 아니라 test('제주도')()로 써야한다. (괄호필요)



### let, const 

- let은 블록 유효 범위를 갖는 지역변수 선언

- const는 블록 유효 범위를 갖는 상수 선언 



let 예시

```javascript
<script>
let x = "outer x";
{
	let x = "inner x";
	let y = "inner y";
	document.write("블럭 내부에서 x : " + x + "<br>");
	document.write("블럭 내부에서 y : " + y + "<br>");
	}
	document.write("블럭 외부에서 x : " + x + "<br>");
//document.write("블럭 외부에서 y : " + y + "<br>");// 에러뜸 outer y는 선언 안했기 때문.
```



const 예시 

```javascript
const c =3;
document.write("블럭 내부에서 c : " + c + "<br>");
//c=5; -> 에러, const는 변경 안됨.
```
}





### 객체 리터럴 방식으로 객체 생성



- for in 반복문을 객체의 속성에 접근할때 사용 가능
- 객체에 대해서 사용하는 in키워드는 속성 존재 여부를 체크할 때 사용할 수 있습니다.
- 객체의 속성을 객체.속성 대신 속성명으로만 사용할때 with(객체){ } 사용합니다
- 객체 리터럴 방식으로 정의되는 객체는 동적으로 속성, 메소드를 추가하거나, 제거할 수 있습니다.



※ 함수리터럴 = 익명함수, 무명함수 

 이름이 없는 함수를 뜻함.



값 전달 : call by value

객체 전달 : call by reference



