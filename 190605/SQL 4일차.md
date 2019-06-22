# SQL 4일차(중요)

## 3일차 복습

### subquery 

-  select문 내부에 정의된 select문(inner query, nested query)
- 외부의 select 문은 outer query, main query이라고 한다.



2번 이상 select를 수행해서 결과 집합을 생성해야 할때 ..하나의 select문으로 정의해서 실행시킴


single row subquery - scalar subquery
multiple row subquery - mutiple column subquery

subquery가 main query보다 먼저 수행하고, 1번 수행
co-related subquery(상관관계 subquery) - subquery가 main query의 컬럼을 참조해서, main query의 행수만큼 subquery 반복적으로 수행하는 Query



subquery가 올 수 있는 위치 
select절
from절  ---inline view
where절  --연산자 오른쪽 (subquery)
having절  --연산자 오른쪽 (subquery)
order by절



subquery를 where절이나 having절에 정의할때 single row subquery는 single row operator(>, >=, <, <=, !=, <>) 함께 사용
multiple row subquery는 multiple row operator (in, any>, any<, all<, all>)

subquery에는 모든 select절, 함수등 제약없이 사용 가능하지만, 
order by절은 from절의 inline view에서만 허용됨





rownum -결과행에 순차적인 번호를 발행 내장 컬럼
rownum은 order by 전에 발생되므로, order by 후에 rownum으로 순차적인 번호를 발행하려면 subquery를 사용합니다.



## co-related subquery(상관관계 subquery)

형태

 **select~~**
 **from ** **table1 a**
 **where column 연산자 (select ~**
                      **from table2**
                      **where a.column = column2)**

서브쿼리에서 메인쿼리인 a를 참조함 (= 이중포문 같이 돌아감)




co-related subquery에서 존재 유무를 체크해주는 연산자 - **exists**, **not exists**





## With

- 긴 query문에서 반복적으로 사용하는 subquery를 먼저 정의해서 재사용하기 위한 메소드



형태

**with** 
**별칭 as (subquery),**
**별칭 as (subquery),**
**별칭 as (subquery),**
**....**
**별칭 as (subquery)**
**select ~**
**from ~**
**where ~**







## set operator - 

- 서로 다른 select의 결과를 단일 결과집합으로 만들기 위해 사용하는 연산자

#### 합집합 - union, union all

union - 각 select의 결과 행에서 중복된 행을 제외하기 위해 sorting

union all - append방식

#### 교집합 - intersect

intersect - 각 select의 결과 행에서 중복된 행만 결과로 생성하기 위해 sorting비교합니다.

#### 차집합 - minus

minus - 첫번째 select의 결과에만 속한 행을 선택하기 위해 sorting비교합니다.



형태

select ~
from  ~
[where ~]
[group by ~]
[having ~]
**union | union all |intersect|minus**
select ~
from  ~
[where ~]
[group by ~]
[having ~]
[order by~];

※ 각 select문에서 **컬럼개수와 컬럼타입이 일치해야** 합니다.
※ 결과는 첫번째 컬럼값을 기준으로 정렬된 결과가 리턴되므로 다른 컬럼으로 정렬하려면 **order by절은 마지막 select문에만 허용됩니다.**





### ROLLUP - 추가필요

```
select to_number(null), to_char(null), avg(sal)
from emp
union all
select deptno, to_char(null), avg(sal)
from emp
group by deptno
union all
select deptno, job, avg(sal)
from emp
group by deptno, job;
```





```
select deptno, job, avg(sal)
from emp
group by rollup (deptno, job);
```





# 데이터 추가, 수정, 삭제하기

### Create

- 테이블 생성



방법 1 - 복제생성

create table emp10
as select *
from emp
where 1=2;--false 조건, 생성 안됨, emp테이블이랑 구조만 같게 복제한다(CTAS).



방법 2 - 인자를 직접 설정하는 생성

create table customer(
custid number(7),
custname varchar2(15),
point number(5) default 1000);









### Insert

- 데이터 추가 (새로운 데이터를 추가하려면 대상 테이블에 insert권한 또는 테이블의 소유자여야 함)



형태1 -특정 컬럼에만 값 넣은 상태로 추가하기

**insert into 테이블명  (컬럼명, 컬럼명,...)** 
**values (컬럼리스트의 순서대로 값...);**



※새로 추가되는 행의 데이터로 일부 컬럼값만 정의할 경우, 필수 컬럼은 반드시 포함되어야 한다.



형태2- 모든 컬럼에 값 넣은 상태로 추가하기

**insert into 테이블명  
values (테이블에 정의된 컬럼 순서대로 모든 값이 선언);**



insert ex)

```sql
insert into dept (dname,loc)
values ('IT','Seoul'); --에러남, 프라이머리 키가 없어서

insert into dept (deptno,dname)
values (50,'IT');

insert into dept 
values (150,'HR',null); -- 에러 넘버가 2자리수여야한다.

insert into dept 
values (50,'HR',null); -- 에러 프라이머리키가 동일하면 안된다. (중복허용X)

insert into emp(empno,ename, deptno) 
values (9000,'Kim',70);
--deptno 컬럼은 dept에 참조를 하는데, dept테이블에 50번까지만 있으므로 70번은 안됨.
--참조 무결성 제약조건 오류
```



#### ※ 참조 무결성 제약 조건이란?

참조하려는 table에 Foreign key가 있을 때 부모 테이블의 조건에 안 맞는 데이터나 없는 데이터를 참조하면

에러가 나오는데 그걸 참조 무결성 제약조건 오류라고 한다.



insert ex2)

```sql
insert into emp(empno,ename, deptno, hiredate) 
values (9000,'Kim',50, sysdate); -- 정상수행, 함수 사용 가능

insert into emp(empno,ename, deptno, hiredate) 
values (9000,'Kim',70, '19년3월2일'); -- 에러, 세션의포맷에 안맞음

insert into emp(empno,ename, deptno, hiredate) 
values (9001,'Lee',50, '19/03/02'); -- 실행됨 
-- 에러가 날 시엔? -> to_date()함수 사용합니다.(자동 형변환으로 될 때도 있음)

insert into emp(empno,ename, deptno, hiredate) 
values (9001,'Lee',50, to_date('19/03/02'));



insert into emp10
select * from emp where deptno=10;
--values 절 대신 subquery를 선언하면 subquery의 결과행수만큼 추가된다.



insert into emp10(empno,ename,deptno,sal)
select empno,job,hiredate,mgr from emp where deptno=20; 
-- subquery에서 insert에 선언된 컬럼 개수나 타입과 일치하지 않으면 error
```







##### Insert 문에서 서브쿼리를 사용할 때의 유의점

- VALUES절은 사용 X
- 데이터가 추가되는 테이블의 열 개수와 서브쿼리의 열 개수가 일치해야 한다.
- 데이터가 추가되는 테이블의 자료형과 서브쿼리의 자료형이 일치해야한다.





### Update

- 데이터 수정

- 테이블에 이미 존재하는 행의 데이터를 ***컬럼단위***로 수정한다.

  

형태1 - 조건없음

**update 테이블명**

**set 칼럼명 = new 컬럼값 [ , 칼럼명 = new 컬럼값, ...]**



형태2 - 조건있음

**update 테이블명**

**set 칼럼명 = new 컬럼값 [ , 칼럼명 = new 컬럼값, ...]**

**where 조건;**



문> SMITH사원의 급여를 KING사원의 급여와 동일하도록 변경하세요

```sql
update emp
set sal = (
select sal
from emp
where ename = 'KING')
where ename = 'SMITH';
```



Update의 set절에도 subquery(Scalar Subquery 만 가능 )를 사용 가능

Update의 where절에도 subquery를 사용 가능.





### Delete

- 테이블이 이미 저장되어 있는 레코드를 삭제

**delete from 테이블명 ;  ---전체 행 삭제**

**delete  테이블명 ; --오라클에서는 from절 생략 가능**

**delete from 테이블명 where 조건 ; ---조건을 만족하는 행만 삭제**

**delete from 테이블명 where 컬럼 연산자 (subquery) ;** 



ex)

```sql
delete from emp;
delete from emp where deptno = 30;
delete from dept; -- 참조무결성에러, 자식테이블이 있으므로 부모테이블은 삭제 안된다.

```







#### Merge

- 데이터 이관 관련 작업을 해줌.

  

운용계DB = 목적 Transaction 처리, Data 변경, insert update등등

정보계DB = 변경이 일어난 데이터들을 가져와서 select를 많이 수행, Datamining, 예측



두 DB사이에서 정보를 수시로 서로 맞춰줘야한다.

두 DB사이에서 데이터 이관하는 작업을 ETL이라고 하는데, 이런 작업에 쓰여지는 구문 중 하나가 **Merge**



형태 : 

merge into 대상 테이블 t

using 소스테이블 s 					-- (s와 t는 앨리어스, 별칭)

on t.pk컬럼 = s.pk컬럼

when matched then  				-- 일치하는 로우가 있으면

update set t.컬럼 = s.컬럼, ....

[delete where 조건]

when not matched then 		-- 일치하는 로우가 없으면 추가

insert (t.컬럼리스트)

values (s.컬럼리스트);







#### ※참고

#### 0-1. rollback

수정한 데이터를 원래대로 되돌림 (한 스텝만 되돌리는게 아님, 다 사라지는거 주의)

#### 0-2. commit

변경한 데이터를 적용(확정)시킴.



1. substitution variable 기능을 OFF시킨다.

1) SQL > SET DEFINE OFF;

2) SQL > SET SCAN OFF;



2. substitution variable 기능을 사용해야 할 경우 &대신 다른문자로 지정한다.

SQL > SET DEFINE @        -- '&' 대신  '@'로 지정



3. 특수문자를 문자로 인식하도록 지정하는 방법

1) escape 문자를 인식하는 기능이 켜져있는지 확인한다. (default : OFF)

SQL > SHOW ESCAPE;

2) ON으로 변경하여 셋팅한다.

SQL > SET ESCAPE ON;

3) Query 에서 특수문자 앞에 '\'를 붙여 사용한다.

SQL >  INSERT INTO "TABLE_NAME" ("COLUNM_NAME") VALUES ('test\&value');]





## Transaction 

#### Unit of Work (분리되어 수행 될 수 없는 작업단위)

ACID - 원장성, 일관성, 격리성, 영속성



#### DB관점의 Transaction 

- DB관점의 Transaction은 변경(DML, DDL, DCL)이 포함될 경우를 의미한다.

- select는 Transaction으로 포함되지 않는다.



Transaction 단위

1개 이상의 DML들로 구성 - 명시적 commit, rollback

1개의 DDL - auto commit;

1개의 DCL - auto commit;



수행중인 DML 트랜잭션의 세션이 비정상종료하면 oracle server는 rollback 한다.

수행중인 DML 트랜잭션의 세션을 정상종료(exit;)하면 oracle server는 commit한다.



##### 읽기 일관성 

- select 하는 user들이 변경중인 user 작업이 종료될 때 까지 기다리지 않고,
- 변경 작업하려는 user들은 select하는 user들이 검색을 종료할때까지 기다리지 않고,
- 변경 작업중인 user들은 변경중인 값을 조회 결과로 볼 수 있고, 
- 변경 작업중이 아닌 user들은 DB에 저장된(commit된) 데이터 값을 조회 결과로 볼 수 있도록 하는 게 **읽기일관성**이다.



오라클 서버는 읽기 일관성을 위해서 Lock, undo segment등을 지원한다.





### 데이터베이스의 객체

#### ※DDL 구문 = 객체를 다루는 명령어

## **Table** 

- Row + Column 으로 구성됨, 가장 기본적인 객체
- 물리적 Data를 저장.
- 종류는 Heap, IOT, Partition 등이 있다.



#### Table 생성

- 테이블 생성하려면 create table 시스템 권한이 있어야 한다.

- tablespace (data container)저장소에 quota가 할당되어 있어야 한다.

  - quota = 사용할 수 있는 용량 (서버에서 할당해주는 용량)

    

#### ※생성된 테이블 확인하는 방법

```sql
desc user_tables
select table_name, tablespace_name from user_tables;
```



#### Table 제거

drop table @@@; 으로 제거를 할 시에

data가 Undo data 생성 없이 물리적 삭제가 된다. (구조도 삭제됨)



복구하려면 backup을 사용

이때 log Recycle bin(휴지통)속에 있는 걸 복구할 수 있는데 

**purge**를 붙이면 휴지통에 넣지 않고 완전 삭제를 실행한다는 의미다.



##### 테이블 일시 제거 복구 방법

flashback table 테이블이름 to before drop;

```sql
select tname from tab; -- BIN~~~~이름의 테이블을 구함
select * from recyclebin; -- BIN~~ 구하기 2
select * from "BIN$HtODUrwnRLm6ygu+FUNnsA==$0"; -- 그 이름의 테이블에 쌍따옴표 붙여서 실행

flashback table emp20 to before drop; -- 삭제한 table emp20을 복구시키는 명령어
```





테이블 완전 제거 방법

```
 drop table emp20 purge;
```



**CTAS**

create table 테이블이름

as

(subquery);



생성 ex)

```sql
create table emp20
as select empno, ename, deptno, sal*12 salary
   from emp
   where deptno = 20;


create table emp20 (empid, name, deptid, salary)
as select empno, ename, deptno, sal*12  
   from emp
   where deptno = 20;

```



**형태** : 

create table 테이블명 (
컬럼명 컬럼타입(size) ,
컬럼명 컬럼타입(size) [default 값],
컬럼명 컬럼타입(size) [제약조건], -- 컬럼 레벨의 제약조건

.......

[제약조건] -- 테이블 레벨의 제약조건

)



생성 예제 2

```sql
create table emp30 (empno, ename, deptno, job, sal)
as select empno, ename, deptno, '  ' job, 0 sal
from emp
where deptno = 30;
```





## **제약조건** constraint - table의 DML 수행시 규칙

#### **Primary key :**  지정한 열이 유일한 값이면서 NULL을 허용하지 않음, 

#### 								Primary Key는 테이블에 하나만 지정 가능.

#### **not null :** 지정한 열에 NULL을 허용하지 않음, 데이터의 중복은 허용

#### **Unique :** 지정한 열이 유일한 값을 가져아함, 중복X, (NULL은 중복 가능)

#### **Foreign key :** 다른 테이블의 열을 참조하여 존재하는 값만 입력할 수 있음

#### **check  :** 설정한 조건식을 만족하는 데이터만 입력 가능 (NULL은 가능)



**table 또는 컬럼 이름 규칙** :

영문자 또는 _, $, #로 시작, 
두번째 문자부터 숫자 허용
키워드 안됨 -- *같은 것도 안됨



#### 제약조건 확인 + 제거 EX

```sql
 select constraint_name, constraint_type
    from user_constraints
    where table_name = 'USERINFO';		-- 제약조건 이름 확인하기, 타입확인하기
    
alter table userinfo disable constraint userinfo_nn; -- 제약조건을 disable로 만들어주기
													-- userinfo_nn 은 제약조건이름이다.
```



#### Unique 제약조건

--oracle server는 unique제약조건이 선언된 컬럼에 자동으로 unique index 생성한다.



인덱스 확인

```
select index_name, uniqueness
from user_indexes
where table_name = 'USERINFO';
```



#### Primary 제약조건

- primary key = not null+unique

- 다른 제약조건은 하나의 테이블에 여러개 선언가능하지만 primary key 제약조건은 하나만 선언 가능하다.



#### Check 제약조건

값의 범위를 결정해주거나 문자의 형태를 정해진 값만 입력받음.



**schema** 

- 서로 연관된 table, index등의 객체를 그룹핑하는 논리적 개념
- 객체 명을 재사용할 수 있는 namespace역할을 한다.
- **오라클은 user명을 schema명으로 사용한다.**
- schema내에서 중복된 이름 사용 불가
- 길이 제한 30자
- DB이름 길이 제한 8자



**컬럼타입** :

char 고정길이 문자열 ~2000byte

varchar2 가변길이 문자열  ~4000byte

number(p, s)

date  --@@세기 @@년 @@월 @@일 @@시 @@분@@초

timestamp  --date타입 확장, 1/10^9의 정밀한 초값 저장

timestamp with timezone

interval year to month

interval day to second

rowid

CLOB(character large object) ~4G

raw - binary 형식의 값 저장 (지문,증명사진 같은 작은 사진) ~200byte

BLOB (Binary large object) ~4G

BFILE -read only 가능한 file을 DB외부에 운영체제의 폴더에 저장, Transaction 처리는 불가

(스트리밍 같은 곳에서 사용 )







## **View**

- Table의 Data에 대한 Window
- 물리적 Data X
- 논리적 Table
- Select 문으로 정의
- 예외 : MV(Matarial View)



##### View의 용도

- **보안**이 필요한 Master Table에서 수정에 필요한 데이터들만 보여주는 용도로 View를 사용함.(간접적 Access)

- **복잡한 Query문을** 저장하여 **간결하게 처리**하기 위해서 사용.**



## Index

- select 문의 처리 속도를 늘리기 위해서 사용하는 객체

- 바이너리 트리 같은 트리 구조를 가지며, Root Block / Branch Block / Leaf Block 등이 있으며, Leaf Block 에서 row id를 가져와서 찾는다.











## 

## Window 함수

### [그룹 내 순위 함수]



### ※ partition by란?

by 뒤에 오는 값을 기준으로 나눠서 정렬한다.

ex) partition by mgr

​	 partition by job



#### RANK

- 특정 컬럼에 대한 순위를 구하는 함수로서 동일한 값에 대해서 동일한 순위를 가지며, 동일한 순위의 수만큼
  다음 순위는 건너뛴다

  

​	ex) emp 테이블에서 사원이름, 직무, 급여 데이터와 전체 사원의 급여가 높은 순서와 JOB별로 급여가 높은 순서 출력하시오

```sql
select ename,job,sal,rank()over( order by sal desc) sal_rank,
-- over 뒤 괄호에 partition by / order by 들가도댐)
            rank() over(partition by job order by sal desc) job_rank,
from emp;
```



#### **DENSE_RANK **

- 특정 컬럼에 대한 순위를 구하는 함수로서 동일한 순위 다음의 순위는
  동일 순위의 수와 상관없이 1 증가된 값을 돌려준다**.**

  

ex) emp사원 테이블에서 사원이름, 직무, 급여 데이터와 전체 사원의 급여를 높은 순서로 출력하되,동일한 순위를 하나의 등수로 간주하여 출력하시오

```sql
select  ename, job, sal, 
        dense_rank( ) over ( order by sal desc ) sal_rank
         , dense_rank() over (partition by job order by sal desc) job_rank
from emp;
```



#### **ROW_NUMBER** 

- 특정 컬럼에 대한 순위를 구하는 함수로서 동일한 값이라도 고유한 순위를 부여한다 

​       (동일한 순위를 배제하기 위해 unique한 순위를 oracle의 경우 rowid가 적은 행이 먼저 나온다.) 

- PARTITION내의 ROW들에 순서대로 UNIQUE한 일련번호를 부여한다.



ex) emp사원 테이블에서 사원이름, 직무, 급여 데이터와  전체 사원의 급여가 높은 순서와 동일한 순위에 대하여 고유한 순위 같이 출력

```
select ename,job,sal,
            row_number() over (order by sal desc) sal_rank2
from emp;
```





#### SUM

- 함수를 이용해 파티션별로 윈도우의 합을 구할 수 있다.
- 그룹화 할 필요 없음

ex)

사원들의 급여와 같은 매니저를 두고 있는 사원들의  salary 합을 구하여 출력한다

```sql
select ename, mgr, sal, sum(sal)over (partition by mgr)
from emp;
```





#### **RANGE UNBOUNDED  PRECEDING ** 

- 현재 행을 기준으로 파티션 내의 첫번째 행까지의 범위를 지정한다.

ex)

emp사원 테이블에서 사원이름, 관리자, 급여 데이터와 사원들의 급여와 같은 매니저를 두고 있는 사원들의 
salary 합을 파티션내에 현재 행을 기준으로 이전행의 salary들의 누적합을 함께 출력한다.

```sql
select ename, mgr, sal, sum(sal)over (partition by mgr order by sal
      range unbounded preceding)
from emp;
```



**

SAL의 범위가 +- 200의 범위 안에 있는 숫자를 카운트 하는 함수

```sql
select  ename, mgr, sal, 
        count(sal) over (order by sal
                         range between 200 preceding and 200 following   ) 
from emp;
```



## **[**그룹 내 행 순서 함수]

**FIRST_VALUE :**  파티션별 윈도우에서 가장 먼저 나온 값을 구한다. 
다른 함수와 달리 공공 등수를 인정하지 않고 처음 나온 행만을 처리한다.
PARTION BY에 의해 분류된 범위 내에서 ORDER BY 에 의해 정렬을 한후 ROWS 또는 RANGE에 의해 범위가 지정되면 그 중 제일 앞에
위치하는 ROW의 값들을 읽어 올때 사용



**LAST_VALUE :**  파티션별 윈도우에서 가장 나중에 나온 값을 구한다. 
 다른 함수와 달리 공공 등수를 인정하지 않고 가장 나중에 나온 행만을 처리한다.
 PARTION BY에 의해 분류된 범위 내에서 ORDER BY 에 의해 정렬을 한후 ROWS 또는 RANGE에 의해 범위가 지정되면 그 중 제일 뒤에 위치하는 ROW의 값들을 읽어 올때 사용

**FIRST_VALUE****와 LAST_VALUE는 정렬된 ROW의 순서에 의해 값이 결정된다.**



간략 ex)

```sql
select  ename, mgr, sal, 
        first_value(sal) over (partition by mgr order by sal) fs,
        last_value(sal) over (partition by mgr order by sal) ls
from emp;
```

이 경우 본인 값이 Last_Value가 되어버리므로 unbounded following을 실행시켜주어야 한다.



정확한 ex)

```sql
select  ename, mgr, sal, 
        first_value(sal) over (partition by mgr order by sal ) fs,
        last_value(sal) over (partition by mgr order by sal 
        range between current row and  unbounded following ) ls
from emp; 
```



**LAG :** 
파티션별 윈도우에서 이전 몇 번째 행의 값을 가져올 수 있다 .



ex) 직원들을 입사 일자가 빠른 기준을 정렬을 하고, 본인보다 입사일자가 한 명 앞선 사원의 급여를 본인의 급여와 함께 출력

```sql
select  ename, mgr, sal, hiredate,
        lag(sal) over (order by hiredate) , -- 널값출력 
        lag(sal, 2, 0) over (order by hiredate) -- 널 대신 인수 0 을 넣어서 널이 나올 때 0 출력
 from emp;
```



