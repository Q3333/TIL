# [연습문제]

문제1)  EMP Table의 모든 자료를 출력하여라.

```sql
select * from emp;
```



문제2)  EMP Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.

```sql
select empno,ename,sal,job from emp;
```



문제3) 모든 사원의 급여를 $300 증가시키기 위해 덧셈 연산자를 사용하고 결과에 SAL+300을 조회한다

```sql
select ename, sal, sal+300 from emp;
```



문제4) EMP 테이블에서 사원번호, 이름, 급여보너스를 출력하여라.

```sql
select empno, ename, comm from emp;
```



문제5) EMP 테이블에서 ENAME를 NAME로 SAL을 SALARY로 출력하여라.

```sql
select ename as NAME, sal as SALARY from emp;
```



문제6) EMP 테이블에서 ENAME를 Name로 SAL*12를 Annual Salary 로 출력하여라.

```sql
select ename as "Name", sal*12 as "Anniual Salary" from emp;
```



문제7) EMP 테이블에서 ENAME를 '성 명'으로, SAL를 ‘급 여'로  출력하여라.

```sql
select ename as "성 명", sal as "급 여" from emp;
```



문제8) EMP 테이블에서 이름과 업무를 연결하여 출력하여라.

```sql
select ename || ' ' || job from emp;
```



문제9) EMP 테이블에서 이름과 업무를 "King is a PRESIDENT" 형식으로 출력하여라.

```sql
select ename || ' ' || job as "King is a PRESIDENT" from emp;
```



문제10) EMP 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 

```sql
select ename || ' 1 Year salary = ' || sal*12  from emp;
```



문제11) EMP 테이블에서 JOB을 모두 출력하여라.

```sql
 select job from emp;
```





문제12) EMP 테이블에서 담당하고 있는 업무의 종류를 출력하여라.

```sql
select distinct job from emp;
```



문제13) EMP 테이블이 부서번호를 중복 값을 제거해서 조회하라

```sql
select distinct deptno from emp;
```



문제14) 부서별로 담당하는 업무를 한번씩 출력하여라.

```sql
 select distinct deptno, job from emp;
```



문제15) EMP 테이블에서 사원번호, 이름, rowid를 조회하라.

```sql
select empno, ename, rowid from emp;
```



문제17) EMP 테이블에서 급여가 3000 이상인 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.

```sql
select empno, ename,job,sal from emp where sal>=3000;
```



문제18) EMP 테이블에서 담당업무가 Manager인 사원의 정보를 사원정보, 성명, 담당업무, 급여, 부서

번호를 출력하라.

```sql
select empno, ename, job, sal ,deptno from emp where job = 'MANAGER';
```



문제19) EMP 테이블에서 1982년 1월 1일 이후에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사

일자, 부서번호를 출력하라.

```sql
select empno, ename, job, sal , hiredate from emp where hiredate like '82%';
```



문제20) EMP 테이블에서 급여가 1300에서 1700사이의 사원의 성명, 담당업무, 급여, 부서 번호를 출

력하여라.

```sql
select ename, job, sal, deptno 
from emp 
where sal between 1300 and 1700;
```



문제21) EMP 테이블에서 사원번호가 7902, 7788, 7566인 사원의 사원번호, 성명, 담당업무, 급여, 입

사일자를 출력하여라.

```sql
select empno, ename, job, sal, hiredate 
from emp 
where empno=7902 or empno=7788 or empno=7566;
```





문제22) EMP 테이블에서 입사일자가 82년도에 입사한 사원의 사번, 성명, 당당업무, 급여, 입사일자, 

부서번호를 출력하여라.

```sql
select empno, ename, job, sal, hiredate, deptno 
from emp 
where hiredate like '82%';
```





문제23) EMP 테이블 이름의 첫 글자가 'M'인 사원의 이름, 급여 조회하라

```sql
select ename, sal from emp where ename like 'M%';
```



문제24) EMP 테이블 이름의  두 번째 글자가 ‘L'인 사원의 이름,업무를  조회하라

```sql
select ename, job from emp where ename like '_L%';
```



문제25) EMP 테이블에서 보너스가 NULL인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번

호를 출력하여라.

```sql
select empno, ename, job, sal, hiredate, deptno from emp where comm is null;
```





문제26) EMP 테이블에서 급여가 1100 이상이고 JOB이 Manager인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.

```sql
select empno, ename, job, sal, hiredate, deptno from emp where sal>1100 and job ='MANAGER';
```

