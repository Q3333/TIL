# SQL - Join 연습 문제

#### 데이터 샘플 : 

##### employees

![](<https://github.com/Q3333/ITL/blob/master/190603/pic/emp.PNG>)



##### job_grades

![](<https://github.com/Q3333/ITL/blob/master/190603/pic/grd.PNG>)



##### locations

![](<https://github.com/Q3333/ITL/blob/master/190603/pic/loc.PNG>)



##### countries

![](<https://github.com/Q3333/ITL/blob/master/190603/pic/cont.PNG>)



##### departments

![](<https://github.com/Q3333/ITL/blob/master/190603/pic/dept.PNG>)





#### ex7) 사원이름, 직무, 부서이름, 급여, 등급을 출력하시오

```sql
select e.last_name, e.job_id, d.department_name, e.salary, 
case when (salary/1000)<3 and (salary/1000)>0 then 'A'
    when (salary/1000)<6 and (salary/1000)>2 then 'B'
    when (salary/1000)<10 and (salary/1000)>5 then 'C'
    when (salary/1000)<15 and (salary/1000)>9 then 'D'
    when (salary/1000)<25 and (salary/1000)>14 then 'E'
    when (salary/1000)<41 and (salary/1000)>24 then 'F'
    end "GRA"
from employees e join departments d on (e.department_id = d.department_id)
order by gra;
--job_grades 라는 별도의 테이블을 이용해서 더 깔끔하게 푸는 방법이 있음
--나중에질문
```

위가 어제 한 코드



아래가 수정한 코드

```sql
select e.last_name, e.job_id, d.department_name, e.salary, g.grade_level
from employees e, departments d, job_grades g
where e.department_id = d.department_id and e.salary between g.lowest_sal and g.highest_sal
order by grade_level;
```



e.salary between g.lowest_sal and g.highest_sal을 활용하는게 포인트

grade 테이블의 로우, 하이값을 이용해서 between에 넣어주면 그에 맞는 등급이 자동으로 나오기 때문에 case문을 안 써도 된다.



#### ex8) Davies. 사원 입사날짜 이후에 입사한 모든 사원의 이름과 입사날짜를 출력하시오

```sql
select last_name, hire_date
from employees 
where hire_date > (
select hire_date
from employees
where last_name = 'Davies');
```

