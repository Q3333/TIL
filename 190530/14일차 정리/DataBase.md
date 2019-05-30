# DataBase

### 데이터 베이스의 유래

`파일 시스템`을 이용하여 각 데이터를 관리하다가 아래의 단점들로 인해 Database가 등장하게 됨.

- 데이터를 파일 단위로 저장하므로 중복 가능
- 데이터의 중복 저장으로 일관성이 결여됨
- 데이터 정의와 프로그램의 독립성 유지 불가능
- 프로그램 개발 생산성 나쁨



### 데이터 베이스란?

: 특정 기업이나 조직 또는 개인이 필요에 의해 `논리적으로 연관된 데이터`를 모아 일정한 형태로 저장해 놓은것



### 데이터 베이스의 특징

- **통합된 데이터** - 데이터의 중복을 최소화하여 중복으로 인한 데이터 불일치 현상을 제거
- **저장된 데이터** - 디스크, 테이프 같은 컴퓨터 저장장치에 저장된 데이터
- **운영 데이터** - 업무를 위한 검색을 할 목적으로 저장된 데이터
- **공용 데이터** - 동시 공유
- **실시간 접근이 가능**
- **지속적인 변화가 가능**
- **내용에 따른 참조가 가능**



### DBMS?

:**데이터베이스 관리 프로그램**
데이터 입력, 수정, 삭제 등의 기능을 제공한다



### 계층형 DBMS

참조관계가 1:M형식

물리적 Pointer를 참조하기 때문에 관리하기 어려웠다.

(피라미드형태)



### 망형 DBMS

참조관계가 M : M

그물망처럼 수평적으로 다대다 관계가 가능



### RDBMS(관계형 DBMS)

- 1970년에 오라클이 만든 DBMS

- 주 목적은 Transaction 처리.

- 하나의 레코드를 식별할 수 있는 식별키(Primary key, [Not Null + Unique이어야함.])를 가진 각각의 table들을 만들어서 연결함 ex) 학생 table, 교수 table, 과목 table

- 외래키(Foreign key)를 사용하여 각 테이블의 값을 가져옴

  

- 고정된 데이터들을 가져야 한다. -> 정형 Schema구조

- but 데이터들은 가변적임 (특성 속성들이 있을수도 있고 없을 수도 있음.)



### 객체 지향 DBMS

데이터들의 수정 입력등을 객체 지향으로 보완

but 트랜잭션이 RDBMS보다 좋지 않아서 결국 RDBMS를 보완하기로 결정



Table = Entity (Record 집합)

Row = Record = Tuple ( 속성값 모음)

Column = Attribute (속성)

Primary key 속성 = Not null Unique

Foreign key =  외래 키

SQL (Structured Query language) S = Standard의 의미도 있음



### DML

DQL(검색) : Select

추가 : Insert

수정 : Update

삭제 : Delete



추가,수정,삭제는 Merge과정



### DDL

생성 Create

변경 Alter

삭제 Drop



DDL에 쓰는거

table

view

index

Sequence

ex ) Drop table



### DCL(Data Control Language)

DBMS 보안

1. 인증
2. 권한 권한을 줄 땐 Grantm, 회수할 땐 revoke로 회수함
3. 









### TCL(Transaction Control Language)

A계좌에서 B계좌로 이체하는 과정에서 오류가 발생하면 이체하기 전의 과정으로 돌아가야 한다 .

-> Unit of Work, 원자성)



온라인 쇼핑 => 

​	1.결제(insert)

2. 제품수량변경

      						  3. 배송정보추가
      						  4. 고객구매 history 추가

이 과정들이 다 끝나고 저장되는 것을 영속성이라고함 . (commit으로 저장, 과정에 오류가 생길 시 rollback으로 처음으로 이동)





1.**Syntax Checking**



2.**Library cache** **검색** -> 동일한 SQL context가 있으면 실행 

이 과정까지를 Soft parsing이라고함.

3 부터는 하드파싱



3.**Semantic Checking** : emp? user? 권한? 등등을 체크 

User,table, 컬럼 등등 : meta정보, System catalog, Datadictionary(오라클은 데이터딕셔너리라고함)

Datadictionary를 이용해서 체크하는 과정을 Semantic Checking 이라고함.



SQL = 선언적, 결과중심언어

프로그램언어 - 점차적(과정 기술)



4.**Optimizer**

데이터베이스에 있는 통계 정보를 이용. 옵티멀한 선택을 함.

옵티마이저에 옵션 선택 가능 -> 네비의 경우 경로, 비용 등등

실행 가능한 결과를 리턴해줌







## DB 검색

### Projection

- 1table, 칼럼 기준 검색 (세로)

### Selection

- 1table, row 기준 검색 (가로)

### Join

- 2개이상의 table, 공통 속성값 기준으로 Row 결합



#### 