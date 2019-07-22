# SQL 3일차

## SQL 복습

#### 그룹함수 : 

여러 행의 컬럼이 함수의 인수로 전달되고, 리턴 값은 한개

- sum, avg, min, max, count, stddev, variance

- 날짜, 숫자, 문자 데이터 유형에 사용 가능 함수 : min, max, count

※ 그룹함수는 null을 연산에 포함시키지 않는다.

ex) 

count(column) - null이 아닌 개수를 리턴
count(*) - 테이블의 전체 행수를 리턴, 내부적으로는 not null 또는 PK 제약조건이 선언된 컬럼을 기준으로 



#### 그룹함수의 실행 순서

1. 그룹함수(all | distinct 컬럼) 

select ~   컬럼, 그룹함수(컬럼)   ---4
from ~             ------1
[where 필터조건]   ------2
[group by 컬럼, ...]   ----3

※ 그룹함수를 적용한 컬럼과 그룹함수를 적용하지 않은 컬럼이 select절에 선언될 경우
group by 절에 그룹함수를 적용하지 않은 컬럼을 반드시 선언해 줘야 한다.



2. having을 사용하는 그룹함수

※ 그룹함수의 조건은 having절에 선언한다.
select ~   컬럼, 그룹함수(컬럼)   ---  5
from ~             ------ 1
[where 필터조건]   ------  2
[group by 컬럼, ...]   ----  3
[having 그룹함수 조건]  -----  4
[order by 컬럼 정렬방식]  ----- 6



ㅡ정리

검색방법 - projection, selection, join
join?  하나 이상의 테이블에서 동일한 속성의 컬럼값이 일치할때 테이블의 row를 결합해서 결과집합으로 생성

inner join = equi join
non-equi join
self join ( 자기참조가 가능한 테이블)
outer join -일치하는 조인컬럼값이 없거나, 조인컬럼값이 null인 row도 조인 결과로 생성하려면
cartesian product -조건 조건을 생략하거나, 조인 조건을 논리적으로 잘 못 정의하면 두 테이블의 모든 row가 한번씩 join되는 경우

오라클에서 초기 버전부터 사용했었던 조인 구문
where  조인조건

select e.ename, e.deptno, d.dname
from emp e, dept d; ---cartesian product

--부서번호가 null인 사원데이터를 조인 결과에 포함하려면
select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+);

--소속 사원이 없는 부서정보를 조인 결과에 포함하려면
select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;

--부서번호가 null인 사원데이터와 소속 사원이 없는 부서정보를 조인 결과에 포함하려면
select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno(+); --error

오라클에서 지원하는 sql1999 조인 구문
from tab1 a natural join tab2 b 
from tab1 a join    tab2 b  using (조인컬럼명) 

from tab1 a  join tab2 b  on a.col=b.col2 
from tab1 a  join tab1 b  on a.col=b.col2 

select e.ename, e.deptno, d.dname
from emp e cross join  dept d;

##### -- cross join = 카티션 곱, 관계성 있는 모든 row를 조인한다.


--부서번호가 null인 사원데이터를 조인 결과에 포함하려면
select e.ename, e.deptno, d.dname
from emp e left outer join dept d  on e.deptno = d.deptno;


--소속 사원이 없는 부서정보를 조인 결과에 포함하려면
select e.ename, e.deptno, d.dname
from emp e right outer join dept d on e.deptno = d.deptno;


--부서번호가 null인 사원데이터와 소속 사원이 없는 부서정보를 조인 결과에 포함하려면
select e.ename, e.deptno, d.dname
from emp e full outer join dept d on e.deptno = d.deptno;



※ N개의 테이블을 조인 하려면 최소 조인조건은 N-1개 선언해야 합니다.







## Subquery

조건 값을 알수 없어서 query를 2번 수행해야 하는 경우 subquery를 사용한다.



select~ = QueryBlock



select의 결과 집합 = Result set = cursor



즉 셀렉트 문 하나를 Main Query, Outer Query라고 부르고

그 셀렉트 문 안에 있는 Query문을 SubQuery, InnerQuery, Nested Query라고 한다.

주로 괄호를 치고 쓴다. (where에 가장 많이 오고 select , from, having, order 절등에도 서브쿼리가 올 수 있다.)

- **Main보다 Subquery쪽이 먼저 실행이 된다.**



#### Subquery를 쓸 때는 괄호 안의 select문이 where 절의 비교대상과 같아야 한다

ex)  ADAMS 보다 급여를 많이 받는 사원

```sql
select ename
from emp
where sal >(  -- where의 sal과 select의 sal이 같음.
select sal
from emp
where ename='ADAMS'
);
```



#### group 함수의 Subquery는 where문이 아니라 having절에 쓴다.

ex) EMP 테이블에서 부서별 최소 급여가 20번 부서의 최소 급여보다 많은  부서의 부서번호와 부서의 최소급여를 조회하라.

```sql
select deptno, min(sal)
from emp 
group by deptno
having min(sal) >( -- having절에 조건을 씀)
select min(sal)
from emp
where deptno = 20
);
```



ㅡ정리

subquery 는 mainquery의  select절, from절, where절, having절, order by절 에  subquery가 정의될 수 있습니다.

where절과 having절의 subquery는 연산자 오른쪽에 () 안에 정의합니다.

단일 행을 리턴하는 subquery : **single row subquery**
복수행을 리턴하는 subquery : **multiple row subquery**
단일 행, 단일 컬럼값을 리턴 subquery : **scalar subquery**
두개 이상의 컬럼값을 리턴하는 subquery : **multiple column subquery**

where절에 single row subquery 를 사용할 경우 반드시 single row operator(>, >=, <=, <, =, <>)와 함께 사용합니다.
where절에 multiple row subquery를 사용할 경우 반드시 multiple row operator(In, any, all)와 함께 사용합니다.



#### IN

다항 연산을 할 때 사용

값 1,2,3이 한 컬럼에 있다고 할때

**a = 값1 or** 

**a = 값2 or**

**a = 값3** 

와 같은 연산을 수행해줌.



**※ IN의 부정인 NOT IN은 != or 이 아니라  != and가 되어버린다.**

그러므로 subquery의 모든 값을 비교해야 하는 연산에서는 null이 포함되어 있는지 여부를  먼저 체크해서 null 을 처리하거나 제외시켜야 한다.**



### <>

!= 과 같은 의미

<> 10 이면 10과 같지 않은 모든 것들



#### ANY

다항 연산을 할 때 사용

값 1,2,3이 한 컬럼에 있다고 할때

**a >값1 or** 

**a > 값2 or**

**a > 값3** 

와 같은 연산을 수행해줌.

**즉 최솟값, a > 값1 과 같은 결과**



#### ALL

다항 연산을 할 때 사용

값 1,2,3이 한 컬럼에 있다고 할때

**a >값1 and**

**a > 값2 and**

**a > 값3** 

와 같은 연산을 수행해줌.

**즉 최댓값, a > 값3 과 같은 결과**





#### --multiple column subquery, pair-wise 비교

```sql
select empno, ename, sal, deptno
from emp
where (deptno, sal) in (
select deptno, max(sal)
from emp
group by deptno);
```



# Co-related Subquery

- 메인쿼리의 값을 서브쿼리 실행할때 사용하는 쿼리
- 메인 쿼리의 한 ROW에 대해서 서브쿼리가 한번씩 실행 (이중 for 문 처럼)
- 상관관계 subquery  라고도 한다.

-> co-related subquery 상관관계는, 조인으로 해결하는게 더 나음.





ex) 사원들 중에서 2번이상 부서 또는 직무를 변경한 이력이 있는  사원의 사번, 이름(last_name) 출력하시오

#### join으로 풀기

```sql
select a.employee_id, a.last_name
from employees a, (select employee_id, count(employee_id) cnt
                   from job_history
                   group by employee_id) b
where a.employee_id = b.employee_id
and b.cnt >=2;
```



#### co-related sub query로 풀기

```sql
select a.employee_id, a.last_name
from employees  a                     
where 2 <=  (select count(employee_id)
             from job_history
             where a.employee_id =employee_id)
```





## Exists

True, False값을 반환하는 SQL문









## With와 서브쿼리

ex) 부서별 총 급여가 전체 부서의 평균급여보다 큰 부서번호와 총급여를 출력합니다.



```sql
with 
dept_sum as (select department_id, sum(salary) sum_sal
             from employees
             group by department_id),
emp_avg as (select avg(sum_sal) total_avg
             from dept_sum)
select a.department_id, a.sum_sal
from dept_sum a, emp_avg b
where a.sum_sal > b.total_avg;
```



## 집합 연산자

Select ~ where까지 다 끝난 문장 사이에 넣은 뒤 하나의 Select~ 풀 문장을 하나 더 넣어줌



**Intersect** = 교집합, 중복체크, Sort



**Union** = 합집합  



**Union all** = 합집합 - 중복제거



**minus** = 차집합



-위4개의 연산을 할 때는 각각의 Select문의 **컬럼개수와 타입은 일치**해야 한다.



-order by절은 마지막 select문에 선언 가능

#####  

ex)

```sql
select employee_id, job_id, department_id
from employees
union all
select employee_id,  job_id, department_id
from job_history;

```







## group by rollup?

- 추후 설명 보강 필요

```sql
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



select deptno, job, avg(sal)
from emp
group by rollup (deptno, job);
```



group by rollup (A,B)를 실행하면

-> group by (A,B)

-> group by (A)

-> group by ()

의 결과를 전부 가져옴



group by rollup (A,B,C)를 실행하면

-> group by (A,B,C)

-> group by (A,B)

-> group by (A)

-> group by () [전체집합]

의 결과를 가져온다.





#### Cube

모든 경우의 수를 전부 출력하는 방식 (rollup과 동일, but 수가 다름)



group by cube (A,B)를 실행하면

-> group by (A,B)

-> group by (A)

-> group by (B)

-> group by ()

의 결과를 전부 가져옴



group by cube (A,B,C)를 실행하면

-> group by (A,B,C)

-> group by (A,B) , (B,C) , (A,C)

-> group by (A) (B) (C)

-> group by () [전체집합]

의 결과를 가져온다.

