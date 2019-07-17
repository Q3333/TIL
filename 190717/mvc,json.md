# mvc, json



### 인터셉터(Interceptor)



컨트롤러에 공동 작업을 수행할 때 Dispatcher Servlet과 Controller들 사이에서 공동 작업을 실행시켜주는 것을 인터셉터 라고 한다.



# JSON

{

​	"key" : "값"

}



값이 boolean이나 int이면 따옴표 필요 없음.



참고 사이트 : http://www.json.org/json-ko.html



### Jackson

자바객체와 JSON 형식의 문자열 간 변환을 처리하는 라이브러리.

ex) VO 객체들을 JSON형식으로 바꿔줌





#### ※RestController Annotation

- 일반 Controller는 jsp로 이동이 되지만, 

- RestController는 일반 String으로 처리가 되서 return을 해준다.