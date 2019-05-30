## SQL관련 중요 팁들

### * sql문장은 대소문자 구분 하는가? ->

- ##### sql문장의 키워드와 테이블명, 컬럼명등은 대소문자 구별 안함

  ##### but 컬럼값은 대소문자 구별 함 -> 중요!!!!!!

#### * sql 문장의 주석은?

- -- 를 붙이면 된다.

#### *Null은 부등호로 비교하는게 아니라 is null, is not null 로 비교 해 주어야 한다.

ex) 

```sql
select ename, comm
from emp 
where comm is null;
```



#### *논리 연산자는 and, or , not로 표현해주어야 한다.

ex)

```
select ename, sal
from emp
where  sal >= 3000 and sal <=5000;
```



#### *범위연산자 between 하한값 and 상한값

ex)

```sql
select ename, sal
from emp
where  sal between 3000 and  5000;
```

#### * in 리스트 연산자 : in (값, 값, 값, .....) or연산자가 많아질 때 사용

ex) 

```sql
select ename, job
from emp
where job in ('CLERK' ,'ANALYST');
```



#### * as "이름" = alias : 별칭만들기

```sql
select sal, sal*12  as "연봉"
from emp;
```



#### * --nvl(column, null일때리턴값)

ex)

```sql
select sal, comm, (sal+nvl(comm, 0))*2 as salary
from emp;
```



#### ※ character pattern matching 연산자 : like '%, _'

%는 문자 종류는 모든 문자, 개수는 0~M
_는 문자 종류는 모든 문자, 개수는 1을 의미합니다.



ex) 사원이름중에서 두번째 문자가 'D'인 사원 검색

```
select ename
from emp
where ename like '_D%';
```



ex) 81년도 이후에 태어난 사원 검색

```sql
select ename, hiredate
from emp
where  hiredate like '81%';

select ename, hiredate
from emp
where  hiredate between '81/01/01' and '81/12/31';
```



#### distinct = 중복된 값 제거 

- 앞에 써야함, 순서 중요 

```
select distinct job from emp; 
-- select job from emp; 으로 해보면 중복된 값 전부 출력됨,
```



### ※ SQL의 기본 구조 :

select ~ -- 검색 컬럼 리스트, 표현식

from ~ -- from 테이블

[where 필터 조건]  where 조건 ; => 컬럼 비교연산자 값 ( >, <, >=, =, !=, <>, <=)

[group by 컬럼] -- 대괄호은 Optional하다는 의미, 생략가능

[having 조건]

[order by 정렬기준컬럼 정렬방식] --asc(연봉, 숫자 등등)오름차순이 **default**, 내림차순은 **desc 내림차순**





#### 정렬 조건 2개 넣기



```sql
select empno, ename, deptno, sal, nvl(comm,0), nvl(((sal+comm)*12),sal*12) as "연봉" 
from emp 
order by deptno, "연봉" desc;
```



order by deptno, "연봉" desc; 처럼 and 가 아니라 콤마(,)를 써서 2개를 넣어야함.

```
order by depno, 6 desc;
order by 3 asc, "연봉" desc;
```

같은 식으로 순서의 번호로 넣어줘도 된다.



### 데이터 타입

**varchar** : 가변 가능 데이터 속성

varchar2(1)** ~4000byte

ex) char(10) 에 'A'를 넣으면

'A           '가 되는데

VARCHAR에 넣으면

'A'로 저장된다.



**char(1)** ~2000byte 

**

**number 타입** binary 형식으로 **정수 ,실수** 저장하는데 사용 

**date 날짜 타입** 7byte를 사용해서 수치 값으로 저장 (@@세기,@@년도,@@월,@@일,@@시,@@분,@@초)





### select sysdate from dual; 

:-- 시스템의 현재 시간을 리턴하는 함수



but 기본 세션이 년/월/일 만 출력이 됨.

-> 세션의 날짜 출력 형식을 변경하는 명령어 

alter session set nls_date_format ='YYYY/MM/DD HH24:MI:SS';



세션을 종료한 후에 다시 시작하면 세션의 기본 날짜 출력 형식으로 변경됩니다.



#### Data dictionary

meta정보가 저장된 oracle data dictionary view는

**user_tables** - 특정 user 소유의 테이블 목록 확인 (별칭 : tab)

ex) dexc tab 

​	 select tname(table_name) from tab;



**all_tables** - 특정 user 소유 + 권한을 받은 테이블 목록 확인

​	 select table_name from all_tables;

**dba_tables** - DB의 모든 테이블 목록 확인 (DBA권한으로만 확인 가능)

​	 select table_name from dba_tables; // 오류발생, **conn / as sysdba** 로 들어가야함





--조회할 컬럼의 순서는 테이블에 정의된 컬럼 순서에 맞추지 않아도 됩니다.



#### Number 타입 칼럼은 산술연산  : +,-,*,/

#### char/varchar2 타입 칼럼은 문자열 결합 : || 

#### date 타입 칼럼은 : date ± n, date ± date



ex) select sal+100,sal-100, sal*2, sal/100 from emp;



select sal, comm, (sal+comm)*2 from emp; (comm이 null값을 보유하고 있음.)

--데이터가 추가될때 입력되지 않는 컬럼값은 null입니다.
--null은 아직 값이 없다 , 0도 아니고, ''도 아닙니다.
--null은 산술연산 수행 결과는 항상 null입니다.
--null을 포함하는 컬럼들은 null아닌 값으로 변환 후에 산술연산을 수행해야 합니다.
--모든 DBMS에서는 null아닌 값으로 변환해주는 내장 함수를 제공합니다.
--nvl(column, null일때리턴값)



-> 변경 

select sal, comm, (sal+nvl(comm,0))*2  as salary from emp;



select sal, comm, (sal+nvl(comm,0))*2  as "Salary" from emp; --큰따옴표하면 대소문자 구별.



select sal, comm, (sal+nvl(comm,0))*2  as "Total Salary" from emp; -- 공백도 포함



#### ※ 문자, 날짜 데이터는 반드시 ' ' 를 사용해서 표현, 처리

#### ※ 날짜 데이터 세션에 설정된 포맷 형식하고 일치해야 합니다.('RR/MM/DD')


ex) 시간 관련 문제

```sql
alter session set nls_date_format ='YYYY/MM/DD HH24:MI:SS'; 
-- 원래 세션이 년,월,일만 출력되서 시간 분 초 전부 출력하게 바꿔주는 과정 
select sysdate, sysdate +1/24, sysdate +5/1440 
-- 현재시간 , 현재 시간 + 1시간, 현재시간 +5분의 과정
from dual;
```





select ename||job from emp; // 문자열 통합



select ename||' works as '|| job from emp; // 중간에 문자열을 하나 넣어줌



Quiz> 'A' 결과로 출력하려면 ?

-> **dual 테이블**을 사용해야함.

※ select~ from절이 필수절입니다.
※ 단순계산 결과, 함수 결과, 문자 데이터 출력등은 dual테이블을 사용합니다.
desc dual
select * from dual;



Quiz2> 

```sql
select 10||10 from dual; --? // 1010

 --?oracle server가 정수10을 문자열로 자동 형변환
```



Quiz3>

```sql
select '10'+'10' from dual ; --? // 20

---? 문자열10을 정수로 자동 형변환
```



select sysdate1+1, sysdate-1 from dual;

 --날짜와 산술연산하는 정수는 Number of Days입니다.



slelect sysdate - hiredate from dual;

기간이 리턴



select sysdate_hiridate from dual;

--error








문> 부서 번호 30번인 사원 검색
문> 직무가 ANALYST인 사원 검색
문> 급여가 3000이상인 사원 검색



--부서 번호 30번인 사원 검색

```sql
select ename, deptno
from emp
where deptno = 30;
```



--직무가 ANALYST인 사원 검색

```sql
select ename, job
from emp
where job = 'ANALYST'
```



--급여가 3000이상인 사원 검색

```sql
select ename, sal
from emp
where sal >= 3000
```






### SQL의 제약사항

조건처리 -> SQL에서 **함수**를 제공해줌

반복처리 -> table의 행 단위 반복처리 (명시적 for , While 없음)

Exception 처리 X

변수사용 X



## 함수 - SQL의 더 강력한 사용을 보조함

- #### where 절에 써야함.

predefine -> DB벤더 (nvl, sysdate, user)

custom (PL/SQL)



*DB의 함수는 **반드시** 결과가 **1개 리턴**되어야한다.



### **단일행 함수** 

: input (1) -> 함수 처리 -> output(1)  -- 인풋 아웃풋 하나씩 

-> Character, Number, Date, null처리, 기타, Conversion함수(형 변환)

#### 

### 문자열 관련 단일행 함수

**initcap()**

첫 글자만 대문자로 바꿔줌

```sql
select initcap(ename), lower(ename), upper(ename)
from emp;
```



**lenghth()**

문자열길이

```sql
select length('korea') length('대한민국')
from dual;
```



**lengthb()**

바이트길이

```sql
select lengthb('korea') lengthb('대한민국')
from dual;
```



**concat()**

-- 함수 안에 함수를 nested하면 nested된 함수부터 처리

문자열을 합쳐줌

```sql
select concat(concat(ename, ' is '), job)
from emp;
```



**substr()**

범위 내의 문자열을 가져와줌

```sql
select substr('today is 2015년 4월 26일', 1, 5),
       substr('today is 2015년 4월 26일', 10, 5),
       substr('today is 2015년 4월 26일', 15),
       substr('today is 2015년 4월 26일', -3, 2)
from dual;
```



**instr()**

해당 문자의 위치를 리턴해줌

```sql
select instr('korea is wonderful', 'o'),
       instr('korea is wonderful', 'o', 1, 2),
       instr('korea is wonderful', 'o', 9),
       instr('korea is wonderful', 'x')
from dual;
```



**lpad()**

왼쪽을 전부 문자로 채움

```sql
select ename, sal, lpad(sal, 10, '*')
from emp;
```



**rpad()** 

오른쪽을 전부 문자로 채움.

```sql
select ename, sal, rpad(sal, 10, '*')
from emp;
```



**trim()**

공백을 다 지워줌

```sql
select length('  hello  '),  length(trim('  hello  '))
from dual;
```



**ltrim(), rtrim()**

왼쪽, 오른쪽부터 시작해서 해당 문자를 지워줌

```sql
select ltrim('Hello wonderful', 'He' ), rtrim( 'Hello wonderful' , 'ful')
from dual;
```



### Number 관련 단일행함수



**round**

반올림 해주는 함수

```sql
select round(12.345, 2), round(12.345, 0), round(12.345, -1)
from dual;
```



**trunc()**

절삭(해당 자릿수에서 떼버리기) 해주는 함수

```sql
select trunc(12.345, 2), trunc(12.345), trunc(12.345, -1)
from dual;
```





**mod**

나머지연산을 해주는 함수

```sql
select mod(99, 4)
from dual;
```





**ceil**, **floor**

가장 가까운 정수를 찾아주는 함수 ceil는 위, floor 는 아래

```sql
select ceil(12.345), floor(12.345) from dual;
```





**power**

제곱 해주는 함수

```sql
select power(3, 2), power(5, 2)
from dual;
```



### 시간 관련 함수

**timestamp()**

timestamp컬럼 타입 (YYYY/MM/DD HH24:MI:SS.SSSSSSSSS)
timestamp(3)  -- 6이 default라서 3으로 줄여줌
timestamp는 time zone 함수와 관련이 있다.



**timezone()**

```sql
select sessiontimezone from dual; -- 기본실행
alter session set time_zone='+3:00';
select sessiontimezone from dual; -- 바꿔주고실행
```



**sysdate 시스템의 현재 리턴**

- current_date 세션의 timezone기반 현재시간을 date타입으로 리턴

- current_timestamp 세션의 timezone기반 현재시간을 timestamp타입으로 리턴

```sql
select   sysdate, current_date, current_timestamp
from dual;
```



**add_months(date, n)**

- n 개월 수를 더한 날짜가 리턴

```sql
select add_months(sysdate, 6) // sysdate에는 다른 날짜 데이터를 넣어야함
from dual;
```



**months_between(date1, date2)**

- date1에서 date2를 빼준 기간을 리턴해줌

```sql
select months_between(sysdate, hiredate)
from emp;
```



**next_day(date, '요일명')**

- 다음에 돌아오는 요일을 구해줌

```sql
select next_day(sysdate, '목')
from emp;
```



**Month, Year의 반올림 and 버리기**

- trunc, round 를 사용

```sql
select trunc(to_date('14/02/14'), 'MONTH'), 
       trunc(to_date('14/02/14'), 'YEAR')
from dual;

select round(to_date('14/02/16'), 'MONTH'), --기준은 16일
       round(to_date('14/07/14'), 'YEAR')  -- 기준은 7월
from dual;
```





**last_day(date)** 

- 달의 마지막 날 구해주기 (윤년 계산됨)

```sql
select last_day(to_date('14/02/14')), last_day(to_date('2000/02/14'))
       , last_day(to_date('2100/02/14'))
from dual;
```





**연습문제** ) 사원들의 입사 날짜로부터 6개월후날짜로부터 다음 금요일이 **연봉 조정 면담 날짜**입니다. 
사원들의 사번과 입사날짜와 연봉 조정 면담날짜를 출력하세요

```sql
select empno, hiredate, 
next_day(add_months(hiredate, 6), '금') "연봉 조정 면담 날짜"  -- as 생략해도 실행됐음
from emp;
```





### 형변환

to_date

to_char

to_number



#### **char <-> number 의 형 변환시** 

format 형식이 틀리면 에러가 뜸

9 = 필요 없는 0이 나올 시 제거

0 = 필요 없는 0이 나와도 출력(주로 소숫점표시할때)

```sql
select to_char(123456.789, '$9,999,999.9999') -- char로 바꿔줌, 
											  -- $표시를 붙여서 저장할 형태를 붙여줘야함
from dual;

select to_number('$1,234,567.999', '9,999,999.999') -- $가 빠져있어서 오류
from dual; --error


select to_number('$1,234,567.999', '$99,999,999.9999')
from dual;  
```



#### char <-> date 의 형 변환시

```sql

select sysdate, to_char(sysdate, 'YYYY"년" MM"월" DD"일" DY') -- YYYY,MM 같이 상용되는건 ''
														   -- 년,월,일 같이 상용 안되는건 ""
from dual;
```



미국식 날짜로 바꿔서 출력해주기

```sql
alter session set nls_language=american;
select sysdate,  to_char(sysdate, 'Year Month DDspth Day')
from dual;
```



**char에서 date로 바꿔주기**

```sql
select '2019-05-30 5:43' 
       , to_date('2019-05-30 5:43' 'HH12:MI YYYY-MM-DD')
from dual;  --error, 앞의 char 데이터랑 뒤의 형식이 맞지 않음.


select '2019-05-30 5:43' 
, to_date('2019-05-30 5:43' , 'YYYY-MM-DD HH12:MI') 
from dual; -- 정상 실행, 변환이 정상적으로 수행되면 세션 포맷형식으로 출력됨

```





### 복수행 함수 : 

all low or grouping row 의 많은 수의 row가 들어가고 **1개의 output**이 나옴





### 분석함수(Window 함수) : 

특정 범위의 row들 사이에서 실행됨. 주로 순위, 비율 등을 구하는 함수