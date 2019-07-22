# Subquery 예제

문> ADAMS 보다 급여를 많이 받는 사원

```sql
select ename
from emp
where sal >(
select sal
from emp
where ename='ADAMS'
);
```





문> 사원번호 7839번과 동일한 직무를 담당하는 사원정보 검색

```sql
select *
from emp
where job =(
select job
from emp
where empno=7839
);
```





문> emp 테이블에서 최소 월급을 받는 사원 정보 검색

```
select *
from emp
where sal =(
select min(sal)
from emp
);
```





문> emp 테이블에서 전체 사원 평균 월급보다 급여가 적게 받는 사원 검색

```sql
select *
from emp
where sal < (
select avg(sal)
from emp
);
```





문>EMP 테이블에서 사원번호가 7521인 사원과 업무가 같고 
급여가 7934인 사원보다 많은 사원의 사원번호, 이름, 담당업무, 입사일자, 급여를 조회하라.

```sql
select empno, ename, job, hiredate, sal
from emp
where job = (select job from emp where empno=7521)and 
sal > (select sal from emp where empno = 7934);
```



문> EMP 테이블에서 부서별 최소 급여가 20번 부서의 최소 급여보다 많은 

부서의 부서번호와 부서의 최소급여를 조회하라.

#### ** group 함수는 where가 아니라 having에 서브쿼리를 넣는다.

```sql
select deptno, min(sal)
from emp 
group by deptno
having min(sal) >(
select min(sal)
from emp
where deptno = 20
);
```





문> 10번부서 사원의 월급과 동일한 월급을 받는 다른 부서의 사원을 검색하시오

```sql
select *
from emp
where sal in (select sal from emp where deptno = 10)
and deptno<> 10;
```







문>부서별로 가장 급여를 많이 받는 사원의  사원번호 , 이름, 급여, 부서번호를 
조회하라

```sql
select empno, ename, sal, deptno
from emp
where (deptno, sal) in (
select deptno, max(sal)
from emp
group by deptno);
--multiple column subquery, pair-wise 비교
```





문>업무가 SALESMAN인 최소 한명 이상의 사원보다 급여를 많이 받는 사원의 이름,  급여, 업무를 조회하라

```sql
select ename, sal ,job
from emp
where sal >any (select sal from emp where job = 'SALESMAN')
and job <> 'SALESMAN';
```





문>업무가 SALESMAN인 모든 사원이 받는 급여보다 급여를 많이 받는 사원의 이름,  급여, 업무를 조회하라

```sal
select ename, sal ,job
from emp
where sal >all (select sal from emp where job = 'SALESMAN')
and job <> 'SALESMAN';
```





문> 직무별 평균 급여중에서 직무별 평균급여가 가장 작은 직무를 조회하시오 
(직무, 평균월급)

```sql
select job, avg(sal)
from emp
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job);
```






문> 사원번호 뒷자리가 80번인 사원들중에서 월급이 높은 3사람을 조회하시오

```sql
select rownum, empno, sal
from (select empno, sal from emp order by sal desc)
where rownum <4 and empno like '__8%';
```



문>subquery를 사용해서 관리자인 사원들만 검색

```sql
select ename, empno
from emp
where empno in (select mgr from emp);
```



문>subquery를 사용해서 관리자가 아닌 사원들만 검색

```
select ename, empno
from emp
where empno not in (select mgr from emp where mgr is not null);
-- null을 제외시킴.
```



**-- subquery의 모든 값을 비교해야 하는 연산에서는 null이 포함되어 있는지 여부를** 
**먼저 체크해서 null 을 처리하거나 제외시켜야 한다.**




문> 각 부서별로 평균급여보다 급여를 많이 받는 사원 검색 (이름, 부서, 급여) - corelated subquery, join

```sql
select a.ename, a.deptno, a.sal 
from emp a , (select deptno, avg(sal) avgsal
             from emp
             group by deptno) b
where a.deptno = b.deptno
and a.sal > b.avgsal;
```



앨리아스를 이용한 응용문제

avg sal을 하나의 별칭으로 지정하고, avg가 담긴 테이블을 b라고 별칭하여 from에 서브쿼리로 넣어버림

이 경우 실행 순서는 서브쿼리가 더 빠름.

-> corelated subquery 상관관계, 조인으로 해결하는게 더 나음.



조인해결

```sql
select a.ename, a.deptno, a.sal
from emp a
where  a.sal  > (select avg(sal) 
                 from emp  
                 where a.deptno = deptno);
```



문> 사원들 중에서 2번이상 부서 또는 직무를 변경한 이력이 있는  사원의 사번, 이름(last_name) 출력하시오

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



