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





#### ex1)  모든 사원의 소속 부서의 주소를 출력하시오

```sql
select location_id, street_address, city, state_province, country_name
from locations natural join countries country_id;
```





#### ex2) 사원들의 last_name과 부서번호와 부서이름을 출력하시오

```sql
select last_name, department_id, department_name
from employees join departments using (department_id) order by department_id;
```





#### ex3) Toronto에서 근무하는 사원정보(last_name, 직무, 부서번호, 부서이름)를 출력하시오 .  

```sql
select e.last_name, e.job_id ,d.department_name, d.department_id, l.city
from  employees e join departments d on (e.department_id = d.department_id)
      join locations l on (d.location_id = l.location_id)
where l.city='Toronto';
```





#### ex4) 사원번호(last_name), 사원이름, 관리자번호, 관리자 이름(last_name)을 출력하시오

```sql
select a.last_name Employee ,a.employee_id EMP# ,b.last_name Manager ,b.employee_id Mgr#
from employees a , employees b
where (b.employee_id = a.manager_id);
```





#### ex5) 4번에서 관리자가 없는 King사원 데이터가 누락되었습니다. 관리자가 없는 King사원 데이터를 포함하여 사원번호(last_name), 사원이름, 관리자번호, 관리자 이름(last_name)을 출력하시오

```sql
select a.last_name Employee ,a.employee_id EMP# ,b.last_name Manager ,b.employee_id Mgr#
from employees a left outer join employees b on (b.employee_id = a.manager_id);
```





#### ex6 )모든 사원에 대해서 동일한 부서에 근무하는 동료사원이름(last_name)을 함께 출려하시오

````sql
select a.department_id, a.last_name, b.last_name
from employees a join employees b on (a.department_id = b.department_id)
where a.last_name != b.last_name
order by department_id;
````



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





