# REST



### REST란 ?

#### (Representational State Transfer)

Roy Fielding 논문으로 아키텍쳐 발표

##### - http 설계의 우수성에 비해 제대로 활용하고 있지 않아 발표한 논문 





### HTTP

#### - Request / Response 로 서버와 클라이언트간에 Http로 통신





#### 웹서버는 웹 리소스를 관리하고 제공을 함.

#### 1. 미디어 타입 : 수천가지 데이터 타입이 존재

##### MIME(Multipurpose Internet Mail Extensions) 라는 방식으로 관리



##### html : text/html

##### jpeg : imgae/jpeg

##### ASCII : text/plain





### 2. URI (URL + URN)

##### URL : 리소스의 위치 (스킴://서버위치/경로) 스킴 : 리소스에 접근하기 위한 프로토콜

##### URN : 위치에 독립적임.



REST의 구성

자원 - URI

행위 - HTTP Method(GET/POST/PUT/DELETE/PATCH)

표현



REST 디자인 가이드

'/' 는 계층 관계를 나타내는데 사용

'_'대신 '-'를 활용

정보의 자원을 표현해야함.



기존 : GET /boards/show/1 show라는 행위가 있기 때문에 REST하지 않음.

REST : GET /boards/1



기존 : GET /boards/create (REST X)

REST : POST /boards



기존 : GET /boards/1/update (REST X)

REST : PUT /boards/1



기존 : GET /boards/1/delete (REST X)

REST : DELETE /boards/1



기존의 방식을 더 효율적이고 짧게 바꿔주는 프로토콜





Django 에서는 Http method를 GET/POST만 지원을 한다.



/boards/new

데이터를 생성하기 위한 폼을 불러오는 것이기 때문에  GET

/boards/create

데이터를 생성하기 때문에 POST





GET / boards/new

POST/ boards/new



request.GET

request.POST

request.method(어떤 방식으로 받아오는 지 확인 가능)







