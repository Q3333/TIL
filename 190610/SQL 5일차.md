# SQL 5일차

## 4일차 복습 및 용어정리

#지금 접속중인 유저 CMD에서 확인하기

-> select user from dual; -- dual 의 owner 는 sys

dual의 목적 : from 절이 필수이므로 단순 계산결과, 함수 결과를 확인할 때 사용한다.



### DCL(Data Contol Language)

- 데이터 제어어
- ex) Commit, Rollback, Grant, Revoke
- 권한 및 서버 저장 등에 사용



### DML(Data Manipulation Language)

- 데이터 조작어
- ex) Select, Insert, Update, Delete
- 데이터 수정 및 검색 등등에 사용



### DDL(Data Definition Language)

- 데이터 정의어 
- ex) Create, Alter, Drop, Rename
- 테이블 생성 및 관리에 사용



#### 데이터 삭제 시에 FK에 걸린다면?

- 외래키 (On Delete Cascade/ On Delete set Null)

: 외래키로 참조 하고 있는 테이블에서 부모 테이블의 참조된 데이터를 삭제하고 싶을때 해당 데이터를 참조 하고 있기 때문에 삭제 할 수가 없다.

이럴 경우를 대비해서 Foreign key를 생성할 때 On Delete cascade/On delete set null 옵션을 사용할 수 있다. 




* On Delete Cascade

: 부모 테이블이 데이터가 삭제 되면 참조된 자식 데이터도 삭제 된다.



-  On Delete set Null

: 부모 테이블이 데이터가 삭제 되면 참조된 자식 데이터는 NULL값이 된다.





### #데이터베이스의 객체

### Table

- 구조, 물리적 data (Record+Column)
     heap , partition,  IOT,  clustered,....종류



##### @테이블 생성

```sql
create table 테이블명 (
컬럼명 컬럼타입(크기) 제약조건|default 기본값,
...
)
[tablespace 저장소명
 storage...];


```



#####  @테이블 생성을 위해 필요한 권한 

- create table 권한, tablespace에 대한 quota가 할당되어 있어야 합니다.

  

##### @테이블명, 컬럼명 이름규칙

- 대소문자 구별 안함 - Data Dictionary에는 대문자로 저장됨
- 첫문자로 영문자, _, $, # 허용
- 두번째 문자부터 숫자 허용
- 키워드 허용 안됨
- 동일 schema내에서 같은 이름의 객체 안됨 - **Schema란?**
- 길이제한 30자 ( 데이터베이스이름 길이 제한 8자)



#### ※ Schema 

- user소유의 객체들을 그룹핑해서 다른 user소유의 객체들을 구별하는 namespace역할을 
- 동일한 이름의 객체를 다른 schema에서 사용 가능하다.

- 원래 의미는 서로 연관된 객체들을 그룹핑하는 의미지만,  오라클에서는 user명을 schema명으로 사용함
        



##### @컬럼타입

char
varchar2
number
date
timestamp
timestamp with timezone
interval year to month
interval day to second
Bfile
BLOB (LONG RAW)
CLOB (LONG)
RAW
rowid - 행주소 (objectid+fileid+blockid+행순서번호)

create table 테이블명 (컬럼명 리스트)
as select ~ 
   from ~
  [where~]
   ....;
select절의 컬럼 리스트와 create table 절에 선언된 컬럼명 리스트의 순서 개수, 타입이 일치해야 합니다.



##### @테이블의 구조 복제

```sql
create table 테이블명  

as select ~ 
   from ~
   where 1=2;   --false조건을 넣어줌으로써 모든 테이블을 복제 안하고 구조만 복제한다.

```



##### @ 제약조건(constraint) 

- DML 수행시 컬럼값의 허용 또는 제한규칙

- 컬럼에 index가 자동 생성되는 제약조건- primary key, unique key

  

Primary key :  Unique + not null , Primary Key는 테이블에 하나만 지정 가능.

not null : not null , 중복 O, 컬럼레벨에서만 제약조건 선언가능

Unique : Unique + 중복 X(NULL은 중복 가능)

Foreign key : 다른 테이블의 열을 참조하여 존재하는 값만 입력할 수 있음

check  :설정한 조건식을 만족하는 데이터만 입력 가능 (NULL은 가능)



```sql
create table emp2 (
empno  number(4),
ename varchar2(15) [constraint 이름] not null,  ---컬럼 레벨에서 제약조건 선언
hiredate date [constraint 이름] not null, -- 다른 컬럼에도 제약조건 선언 가능
job  varchar2(15),
sal  number(8, 2),
constraint emp2_pk  primary key (empno, ename) ---테이블 레벨에서 제약조건 선언
);
```



- 제약조건 메타 정보 조회 -  user_constraints, all_constraints, dba_constraints
- 테이블의 메타 정보 조회 -  user_tables (tab), all_tables, dba_tables
- 컬럼 메타 정보 조회 - user_tab_columns



**@ alter table 테이블명 modify (컬럼 컬럼타입(크기) );**

- 컬럼 타입 변경할 때  컬럼값이 존재하더라도 char5->varchar2(10) 변경은 가능

- 컬럼 타입 변경할 때 호환되지 않는 컬럼타입으로 변경할때는 컬럼값을 null로 변경한후에 컬럼타입을 변경할 수 있다.

- 컬럼 크기를 변경할 때 크기 증가는 항상 가능하지만, 컬럼값이 존재할때 컬럼 크기를 줄이려면 저장된 컬럼값의 최대 길이보다 작게 줄일 수 없다.

- not null제약조건 추가



ex) Alter로 가능한 변경

```sql
alter table 테이블명 add constraint~;
alter table 테이블명 drop constraint~;
alter table 테이블명  add (컬럼 컬럼타입(크기), 컬럼 컬럼타입(크기),..);
alter table 테이블명 drop (컬럼 컬럼타입(크기), 컬럼 컬럼타입(크기),..);
alter table 테이블명 drop column 컬럼명;
alter table 테이블명 rename column old명 to new명;
alter table 테이블명 enable constraint~;
alter table 테이블명 disable constraint~;
```



#### @Drop table

drop table 테이블명;  --테이블이름 rename되어 recyclebin에 저장됨..조회가능..저장 공간이 부족할때 oracle server가 제거함 

-> 휴지통 비우기 : purge recyclebin;



drop table 테이블명 purge;  --recyclebin을 bypass하고 물리적으로 완전 삭제

drop table ~ ; --table메타정보, data, 제약조건, index도 함께 삭제된다.



truncate table 테이블명 [reuse storage]; --구조만 남겨두고, data는 완전 삭제(recyclebin에도 undo data도 생성하지 않음)

- 관리형 테이블, 이런 테이블이 있다는 것 정도만 알아두는 것이 좋음.





#### Index  

- 테이블의 컬럼에 생성

-  where절에 검색조건으로 사용되는 컬럼, join 컬럼, order by 절의 컬럼 내부적으로 oracle server가 select 수행시 사용
- b*tree구조로 저장



##### PK와 UK에 index 자동 생성 목적 - 정합성 체크, 중복값 체크를 빠르게 수행

##### @index 생성에 적합한 조건

- where 조건에 사용되는 컬럼 
- join 컬럼
- order by 컬럼
- 컬럼중에서 distinct value(선택도)값이 많아야 한다. (중복값이 거의 없는)
- where절의 = 연산조건의 결과 행이 5%이내 
- 인덱스 생성 컬럼으로 조회 결과 행수가 10%를 초과하면 손익분기점으로 table full scan이 더 유리하다.
- 자주 Update 되는 컬럼은 인덱스 생성하면 성능 저하(거의 Update가 발생하지 않는 컬럼을 인덱스로)
- 4개 블럭 이상에 데이터가 저장된 테이블



##### @인덱스의 종류

- 단일컬럼인덱스
- 복합컬럼 인덱스
- unique 인덱스
- non-unique 인덱스
- funcation-based 인덱스 (컬럼값의 내림차순으로 생성, 컬럼표현식)



ex) 생성, 변경, 삭제의 형태

```
create index 인덱스명 on 테이블(컬럼);
alter index 인덱스명 on 테이블(컬럼 desc);
drop index 인덱스명;
```



#### View 

- table에 대해서 select로 정의된 table의 window역할

  

사용 목적 2가지 : 보안, 간결한 select문 사용을 위해서



view를 사용하기 위해 base가 되는 table이나 view가 있어야 한다.
예외) MeterializedView - 성능향상이 목적인 물리적 data를 가지는 View



##### simple view  

- 하나의 대상 테이블로부터 view 생성, not null 제약조건이 선언된 컬럼은 모두 포함, 컬럼표현식X, group by X, 그룹함수 X, rowid X, rownum 컬럼x DML이 가능한 View (간접적 table access DML 수행됨)



##### complex view  

- 하나 이상의 테이블에 대한 select문으로 정의, 컬럼표현식 , group by  , 그룹함수  , 조인, rowid  , rownum 컬럼 등 포함된 경우 DML이 불가능한 View



View를 생성, 수정, 삭제할 때

```sql
create view emp20_vu
as select empno, ename, deptno, job, sal*12 salary		--뷰 생성
from emp
where deptno = 20;

create or replace view emp20_vu
as select empno, ename, deptno, job, sal			--뷰 수정 or 생성
from emp
where deptno = 20;

drop view emp20_vu;								-- 뷰 삭제

```









#### Sequence 

- 순차적으로 숫자값이 저장되어야 하는 컬럼(주문번호, 게시판의 글번호등)의 값을 자동으로 발행해주는 객체
  최소값, 최대값, 증감값을 설정한다.



create sequence 시퀀스 이름

[increment by n] -- 시퀀스 증가값 (기본값1)

[start with n :] 시퀀스 시작값 (기본값1)

[maxvalue n : NOMAXVALUE] 시퀀스 최대값

[minvalue n : NOMINVALUE] 시퀀스 최솟값

[cycle  : NOCYCLE] 시퀀스가 최댓값에 도달했을 경우 시작값에서 다시 시작

[cache n : NOCACHE] 시퀀스가 생성할 번호를 메모리에 미리 할당해 놓은 수, NOCACHE는 미리 생성하지 않도록 설정, 기본값은 20

;



alter sequence 시퀀스명

increment by ~

maxvalue ~

minvalue ~

cycle ~

cache~;

(Start with 를 제외하고는 전부 변경 가능)





#### Synonym(동의어) 

- schema명.객체@dblink명 과 같은 객체이름을 간결하게 사용하기 위한 동의어



create [ public ] synonym 동의어 이름

for [ 사용자. ] [ 객체 이름 ];



public :  동의어를 DB내의 모든 사용자가 사용 가능하게 설정 (선택)

동의어 이름 : 필수, 생성할 동의어 이름 (필수)

사용자. : 생성할 동의어의 본래 객체 소유자, 생략할 경우 현재 접속한 사용자 (선택)

객체이름 : 동의어를 생성할 대상 객체 이름 (필수)



### 권한

시스템 권한 

- DB에서 특정 SQL을 수행할 수 있는 권한, DBA(DB관리자)
- 객체 권한 - 예) table에는 insert, update, select, alter, delete등을 수행 권한
                  view에는 select, drop , insert, update, delete
                  sequence는 select, alter, drop
              객체의 소유자, DBA

ex)

```sql
grant select on emp to kim; -- 권한 주기
grant select on emp to kim with grant option; -- 남에게 권한을 줄 수있는 권한을 주기

revoke select on emp from kim; -- 권한 회수하기
revoke select on emp from hr;  -- error, 객체 권한은 직접 권한을 준 user가 회수 가능하다.
```



#### Role

권한 관리를 쉽게 하기 위한 그룹핑

ex) 직무별, 업무별로 필요한 기능을 Role로 묶어놔서 권한을 준다.

Role의 또 하나의 장점은 동적 권한 관리 가능



Role을 생성할 수 있는 권한은 DBA
1. create role 롤이름;

2. grant 시스템권한, 객체 권한 to 롤이름;

3. grant 롤이름 to 사용자|롤이름|public;

   revoke 롤이름 from 사용자|롤이름|public;

   -- 확인하는 법 : user_role_privs

   -- 삭제하는 법 : drop role 롤이름

