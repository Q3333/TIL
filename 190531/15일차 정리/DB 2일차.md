# DB 2일차 (중요)



### nvl(column, expression) : 

column과 expression이 동일한 타입이어야 한다.



### nvl2(column, expression1, expression2) : 

expression1과 expression2가 동일한 타입이어야 한다.

널이 아니라면 expression1

널이면  expression2 값을 리턴해준다.



##### coalesce(column,  expression1, expression2, ... )

함수의 파라미터값에서 null이 아닌 최초의 값을 리턴하고 함수는 종료한다.

ex) expression1 이 null이면 expression2, 3.. 등등 뒤에서 null 이 아닌 값을 찾는다.



##### nullif(expression1, expression2) :

expression1과  expression2 동일한 타입이어야 한다.

expression1과 expression2의 값이 동일하면 null을 리턴하고, 값이 다르면 expression1을 리턴한다.



연습문제

문> 사원들중 커미션을 받지 않는 사원들은 -1으로 출력합니다. (이름, 급여, 커미션)

```sql
select ename, sal, nvl(comm,-1) "커미션" from emp;
```



문> 사원들중 커미션을 받는 사원은 급여+커미션을 출력하고, 커미션을 받지 않는 사원은 'No Commission'으로 출력합니다. (이름, 급여, 커미션, 비고)

```sql
select ename, sal, comm, nvl2(comm, to_char(sal+comm), 'NoCommission') "비고" from emp;
```

sal+com 은 문자형으로 변환이 되므로 to_char로 바꾸어서 동일 타입으로 바꾸어 주어야 한다.



## Decode , Case 함수

### Decode문

### -select에서 조건문을 걸어줄 수 있음.

decode(column, 

표현식1 , 리턴값1, 

표현식2 , 리턴값2,...)함수 -- 괄호 필요

ex)

```sql
select ename, deptno, sal, 
       decode(deptno , 10, sal*1.05
                     , 20, sal*1.1
                     , 30, sal*1.03 , sal+100) "Increase"
from emp;
```



일치가 아니라 크거나 작다는 조건을 주고 싶을 때

ex)

```sql
select ename, sal, 
decode(trunc(sal/1000),0, 0, -- 부등호 입력이 안되므로 trunc sal/1000으로 천 단위로 바꾼 뒤 일치 								데이터를 찾아줌
1, sal*0.05,
2, sal*0.1,
3, sal*0.15, sal*0.2) "Tax" from emp;
```





### Case문

### decode 와 동일

case [표현식] 

when [값|조건표현식] then 값  -- 여러번 와도 괜찮

[else 값] end

[]은 생략가능

ex)

```sql
select ename, deptno, sal, 
       case deptno when 10 then sal*1.05
                   when 20 then sal*1.1
                   when 30 then sal*1.03 
                   else sal+100 end "Increase"
from emp; 
```





일치가 아니라 크거나 작다는 조건을 주고 싶을 때

ex)

```sql
select ename, sal, case when sal < 1000 then 0
                            when sal <2000 then sal*0.05
                            when sal <3000 then sal*0.1
                            when sal <4000 then sal*0.15
                            else sal*0.2 end "TAX"
                            from emp;
```





### 프롬프트에서 값을 입력받아서 실행하는 문제를 풀 때

#### & 입력받을 컬럼

ex)

&emp_num 



방금 실행시킨 파일을 실행시키는 명렁어 : '' / ''



## 그룹함수

그룹핑된 행 집합, 테이블의 전체 행 집합의 컬럼이 함수의 인수로 전달되고 **결과는 반드시 1개 리턴**

*모든 그룹함수는 null을 함수 연산에 포함하지 않음

-> 반드시 null처리한 후에 연산하여아 한다.



**sum**(number타입|expression)

**avg**(number타입|expression)

**min**(number, char, date 컬럼타입 |expression)

**max**(number, char, date 컬럼타입 |expression)

**count**([distinct]number, char, date 컬럼타입 |expression) : null이아닌 값(행) 개수 리턴

-- null은 count 하지 않습니다.

**stddev**(number타입|expression) : 표준편차

**variance**(number타입|expression) : 분산



### 주의!

select deptno, avg(sal) from emp; 의 경우

deptno는 그룹함수가 적용되지 않은 컬럼이므로, 마지막에

group by deptno;를 붙여줘야 그룹핑이 된다.

-> select deptno, avg(sal) from emp group by deptno;



### group by  : 

##### --그룹함수를 적용한 컬럼과 그룹함수를 적용하지 않은 컬럼이 select절에 

##### 함께 선언될 경우 반드시 그룹함수를 적용하지 않은 컬럼은 group by절에 선언해야 합니다.

```sql
select deptno, avg(sal)
from emp
group by deptno;

```

##### 

##### --group by절에 선언한 컬럼이 select절에 반드시 선언은 선택적입니다.

```sql
select  avg(sal)
from emp
group by deptno;  -- 없어도 실행은 됨, but 다른결과
```



##### --group by절에는 column명만 선언할 수 있습니다.



# Having절

group by 절의 실행 순서 1

문>각 부서별로 인원수, 급여의 평균, 최저 급여, 최고 급여, 급여의 합을 
구하여  급여의 합이 많은 순으로 출력하여라.

```
select deptno, count(deptno), avg(sal), min(sal), max(sal), sum(sal)   ---3 (실행순서)
from emp                 ---1
group by deptno          ---2   
order by sum(sal) desc;  -- 4
```



-> 이 경우는 문제 X



문2> EMP 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 
급여의 합을 출력하여라

```
select deptno, count(*), sum(sal) ---4
from emp          ---1 
where count(*) > ---2
group by deptno;  ---3
```

이 경우 where 절이 그룹핑보다 빠르게 되서 에러가 뜬다.

##### 결국 where 절 대신 having절을 써서 그룹핑한 대상에 조건을 걸어주어야 한다.

```
select deptno, count(*), sum(sal) ---4
from emp          ---1 
group by deptno;  ---2
having count(*) > 4; --3
```

##### ※그룹함수의 조건은 having절에 선언합니다. having절은 group by절과 함께 사용됩니다.



## 그룹 예제 (어려운 난이도)

전체 사원수,
1995, 1996, 1997, 1998년도에 입사한 사원수를 출력하시오

방법 1

```
select count(distinct last_name) "TOTAL" ,   
count(decode(trunc(hire_date,'YY'),'95/01/01',1)) "1995",
count(decode(trunc(hire_date,'YY'),'96/01/01',1)) "1996",
count(decode(trunc(hire_date,'YY'),'97/01/01',1)) "1997",
count(decode(trunc(hire_date,'YY'),'98/01/01',1)) "1998"
from employees;
```

방법 2

```
select count(distinct last_name) "TOTAL" ,   
count(decode(to_char(hire_date,'YYYY'),'1995',1)) "1995",
count(case to_char(hire_date, 'YYYY') when '1996' then 1 end) "1996",
count(case to_char(hire_date, 'YYYY') when '1997' then 1 end) "1997",
count(case to_char(hire_date, 'YYYY') when '1998' then 1 end) "1998"
from employees;
```





 직무별로 월급의 합계와   각 부서내에 직무별 월급의 합계를 아래 보기와 같이 출력하시오   컬럼 타이틀은 Job, Dept 20, Dept 50, Dept 80, Dept 90로 출력하시오

```
select distinct job_id, 
nvl(to_char(sum(decode(department_id,'20',salary))),' ') "Dept 20" ,
nvl(to_char(sum(decode(department_id,'50',salary))),' ') "Dept 50" ,
nvl(to_char(sum(decode(department_id,'80',salary))),' ') "Dept 80" ,
nvl(to_char(sum(decode(department_id,'90',salary))),' ') "Dept 90" ,
nvl(to_char(sum(salary)),' ') "Total" 
from employees
group by job_id;
```





# JOIN

### join의 종류

- equi join (inner join) 

  각각의 테이블이 서로 같은 키를 가지고 있을 때

  (= natural 조인을 사용할 수 있음)

- non-equi join

- self-join (자기참조가 가능한 테이블에서만)

  ※ 조인 조건을 잘못 정의하거나 , 조인 조건을 누락하면 cartesian product (cross join)

  emp a emp b 같은 식으로 2개 만들어서 조인

  ex) from  emp a join emp b  on a.mgr = b.empno;

- outer join (조인컬럼값이 null인 경우 결과집합에 포함시키기 위한 조인)

  서로 같은 키를 가지고 있지 않은 별도의 테이블일 때

  (+)를 사용 (널을 보여주고 싶은 쪽에 +를 붙임)

  



### natural join

--natual join 은 oracle 서버가 조인할 테이블에서 동일한 이름의 컬럼으로 **자동 equi 방식 조인**을 수행

##### -> 자동으로 동일 키를 찾아서 조인해줌

--natual join 은 조인할 테이블에서 동일한 이름의 컬럼 앞에 소유자 테이블명 또는 alias를 선언하지 않음

--natual join 은 동일한 속성이지만, 설계할때 부모와 자식 테이블에서 이름을 다르게 정의하면 조인 수행 안됨

select a.last_name,  department_id, b.department_name
from  employees a natural join  departments b;  -->? 19rows?



#### 직접 where에 조건을 넣어줘서 join (아래의 using 이랑 동일)

```
select a.last_name, a.department_id, b.department_name
from  employees a, departments b
where a.department_id = b.department_id
and a.manager_id = b.manager_id;
```



#### Using

##### 특정 속성을 기준으로 Join할 때 -> 자동으로 동일 키를 찾아주는 게 싫을 경우 사용

#### 특정 속성을 기준으로 Join할 때

select a.last_name,  department_id, b.department_name
from  employees a  join  departments b using (department_id); 



##### desc

** desc salgrade;
desc emp;

를 치면 salgrade나 emp 테이블의 정보를 간략하게 볼 수 있다.



## Join ~ on

기존 where 절에 있는 조인 조건식을 on 키워드 옆에 작성.



ex) 

```
select a.empno, a.ename, a.deptno, b.dname
from emp a left outer join dept b on a.deptno = b.deptno;
```







## left, right, full outher join

 

left : 왼쪽에 널값

```
select b.deptno, b.dname, a.empno, a.ename 
from emp a left outer join dept b on a.deptno  = b.deptno
order by  b.deptno; 
```



<출력화면>

![](<https://github.com/Q3333/ITL/blob/master/190531/pic/1.PNG>)



right : 오른쪽에 널값

```
select b.deptno, b.dname, a.empno, a.ename 
from emp a right outer join dept b on a.deptno  = b.deptno
order by  b.deptno; 
```



<출력화면>

![](<https://github.com/Q3333/ITL/blob/master/190531/pic/2.PNG>)



full : 양쪽에 널값 

```
select b.deptno, b.dname, a.empno, a.ename
from emp a full outer join dept b on a.deptno  = b.deptno
order by  b.deptno; 
```



<출력화면>

![](<https://github.com/Q3333/ITL/blob/master/190531/pic/3.PNG>)



### ※ n개의 테이블을 조인할때 최소 조인 조건은  n-1개 