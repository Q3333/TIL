# JavaScript 3일차



##### 복습(이 날은 실습 위주)



[자바스크립트 함수를 정의하는 방법]

	// 함수 선언문으로 정의
	function square(x) { return x*x ;}
		console.log (square(5));
		
	// 함수 리터럴 (익명 함수) 로 정의
	var square1 = function(x) { return x*x;}
	console.log(square1(5));
	
	// Function 생성자로 정의
	var square2 = new Function("x","return x*x");
	console.log(square2(5));
	
	// 화살표 함수 표현식 ( 람다식 ) 으로 정의
	var square3 = x => x*x;
	console.log(square3(5));
	
	


// 즉시 실행 함수 - 익명 함수를 정의하고 바로 실행하는 함수
한번 실행하므로 초기화 작업할 때 사용하며 , 전역 유효 범위를 오염시키지 않는 함수다.

```
console.log( function(x) { return x*x;} (5));
		console.log( function(x) { return x*x;}) (5);
		console.log( function square(x) {return x*x}) (5);
```



모든 함수의 인수는 가변 길이를 가진다.

- 선언된 인수보다 적으면 인수를 참조할 때 undefined

- 선언된 인수보다 많으면 무시

- 모든 함수가 생성될 때 전달되는 인수가 저장되는 함수의 property는 Arguments객체의 arguments 입니다.

  ex) -> arguments.length, arguments[index]



자바 스크립트에서 재귀함수를 정의하고 사용할 수 있습니다.

```
function fact(n) {

if(n<=1) return n;

return n*fact(n-1);

}

fact(5);


```



#함수가 호출되어 실행되는 시점에서 this 값이 결정된다.

- 최상위 레벨의 코드에서 this는 Window객체의 참조변수 window
- 이벤트 핸들러 함수 내부에서 this는 이벤트 소스 객체



window.onload = 이벤트 핸들러 함수()

window.onload = function(){

this........//?}

};



button.onclick = function(){

this.... // 클릭 이벤트가 발생한 버튼

};



- 생성자 함수 안에서 this는 생성자 함수로부터 생성되는 객체 자신 
- 함수 내부에서 this는 window입니다.



#객체 정의 방법 :

1. 객체 리터털로 정의 

   {속성 : 값, 속성 : 값, 속성 : function(){} ...}

2. 생성자 함수를 정의하고 생성자 함수로부터 객체 생성할 수 있습니다.

   function Person(name, age){

   var_ name = name // prviate 성격의 속성 ( 외부에서 접근 불가)

   var _ age  = age;

   return {

   ​	getName : function() { return_name; }}, // 클로저

   ​	getAge : function() { return _age;

   ​	setAge (function*n) (_age = n;)

   };

   }



var p = new Person("kim", 30);

console.log(p_name) ; // 오류

console.log(p.age) ;// 오류

 

console.log(p.getName) ; // 

console.log(p.getAge) ;// 



### ※클로저 복습 필요(js01,02)



#함수적 프로그래밍 특성

변수에 함수를 저장할 수 있습니다.

배열의 요소로 함수를 저장할 수 있습니다.

함수 내부에 함수를 정의할 수 있습니다. (nested function, ) @

함수에서 함수를 반환할 수 있습니다. @



@에 관련된 용어] 내부에 함수를 정의하거나 함수를 반환하는 함수를 **고차 함수**라고 합니다.

함수의 인수로 함수를 전달할 수 있습니다. $



$에 관련된 용어] 인수로 함수를 **콜백 함수**라고 합니다.



#자바스크립트 객체 분류

내장 객체 - Object, String, Boolean, Number, Array, Date, Regexp, ..

브라우저 객체 - Window

ECMAScript 객체 



Window - close(), open(url, name, {... Optional data }, moveBy(), moveTo() 

alert(), confirm(), prompt(), 



setTimeout(function(){}) , time ) -> 실행 대기 큐에 들어감.

clearTimeout -> 실행 대기 큐에 있는 이벤트 setTimeout을 취소함.



setInterval(function(){}, time), clearInterval(id) -> 일정 시간 간격으로 함수를 실행시킴

clearInterval(id) - > 인터벌 취소



Window객체의 속성 document는 Document로서 HTML요소관련 처리 객체

Document - getElementById(""), getElementsByName(""), 

getElementsByTagName(""), getElementsByClassName(),

querySelector("css의 select형식"), 

querySelectorAll("css의 select형식"), 



createElement() [내용 추가] , createComment()[주석추가] ,

createDocumentFragement,

createAttribute(), createTextNode()



set Attribute(), getAttribute(), removeAttribute()

parentNode, childNode, body, appendChild()







### HTML 요소의 위치 

좌표를 표시하는 좌표계가 2개로 나뉘어짐



1.뷰 포트 좌표계(윈도우 좌표계)



2.문서 좌표계

스크롤 해도 바뀌지 않으므로 뷰포트 좌표계를 따르는 요소보다 다루기 쉽다는 특징이 있음.



## 폼에서 입력한 값들을 가져오는 방법 (중요)

### **.value**를 사용한다.

```
var pass = document.getElementById('pass').value;
```

```
nTotalMember = Number(labTotal.value);
```



## onload 와 addEventListener 의 차이점

1. onload 는 창이 실행될때 자동으로 실행되는 명령이다.
3. addEventListener는 이벤트를 만들어내는 명령어이다.

사용예시 ) onload

```
window.onload =function(){
	 alert("load event handler1");
	 }
window.onload =function(){
	 alert("load event handler2");
	 }
window.onload =function(){
	 alert("load event handler3");
	 }

```



) addEventListener

```

window.addEventListener("load",function(){
 alert("load event handler1");}, false);

window.addEventListener("load",function(){
  alert("load event handler2");}, false);

window.addEventListener("load",function(){
 alert("load event handler3");}, false);

```

뒤에 인자로 false가 들어가야함. 