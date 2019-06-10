# SQL 5일차 실습

#### PK, FK연습

- category 테이블 생성

```sql
create table category (
cid number(5),
cname varchar2(20)
);
```



- 데이터 입력

```sql
insert into category values (10000,'BOOK');
insert into category values (20000,'Music');
insert into category values (30000,'Game');
insert into category values (40000,'Moive');
```



- product 테이블 생성

```sql
create table product (
proid number(5),
pname varchar2(50),
price number(6),
cid number(5) constraint product_fk REFERENCES category(cid)
); -- error
```

위에 category 테이블을 만들 때 프라이머리 키를 지정 안해주었기 때문에 에러가 난다.



- 프라이머리 키 설정

```sql
alter table category add constraint category_pk primary key(cid);
```



- 제약조건 확인

```sql
select constraint_name, constraint_type
from user_constraints
where table_name = 'PRODUCT';
```

제약조건의 product_fk를 보여준다.



- 에러 없는 예제 (primary key, foreign key 관련)

```sql
insert into product values (1, 'java', 5000, 10000);
insert into product values (3, 'BTS', 15000, 20000);
delete from category where cid = 40000;
update category set cid = 15000 where cid = 10000;
```



- 에러 있는 예제 

```sql
insert into product values (2, 'oracle', 5000, 50000); 
--참조하는 부모키에 없는 키 값

update product 
set cid = 2222 where prodid = 3;
-- 참조하는 부모키의 값이 없음

delete from category where cid = 10000; 
-- error, 자식레코드가 있음

update category set cid = 15000 where cid = 10000; 
-- 무결성 제약조건 오류 
```



#### Index

-책갈피 같은 느낌?

생성, 삭제, 확인

```sql
create index idxs_emp_sal -- 인덱스 생성
on emp(sal);

select * from USER_IND_COLUMNS; -- 생성된 인덱스 확인

drop index idxs_emp_sal; -- 인덱스 삭제
```





#### View

생성, 삭제, 확인

```sql
create view emp20_vu
as select empno, ename, deptno, job, sal*12 salary		--뷰 생성
from emp
where deptno = 20;

select text
from user_views
where view_name = 'EMP20_VU'; -- 생성된 뷰를 한줄로 확인

drop view emp20_vu; -- 삭제
```



수정

```sql
create or replace view emp20_vu		--alter와 같은 기능, (create or replace)
as select empno, ename, deptno, job, sal	
from emp
where deptno = 20;

create or replace view emp20_vu
as select empno, ename, deptno, job, sal
from emp
where deptno = 20
with check option; -- 체크 조약조건, dept가 20이 아니면 에러가 나옴
```





#### Sequence

생성,삭제,확인

```sql
create sequence emp_seq;	--생성
drop sequence emp_seq;		--삭제

select * from user_sequences;
-- 시퀀스 객체를 생성하면 자동으로 시퀀스의 내장컬럼 currval, nextval을 생성함.

```



sequence 의 현재값, 다음값

```sql
select emp_seq.currval
from dual; -- 시퀀스를 생성하면 최초값을 생성(nextval)한 다음에 currval을 확인 가능

select emp_seq.nextval -- sequence를 생성할 때 입력한 증가값에 따라 값이 증가
from dual;	
```



실행 예

```sql
insert into emp (empno, ename)
values (emp_seq.nextval, 'Kang'); 	--nextval로 증가시킨 값을 넣어주면서 insert

update dept
set deptno = emp_seq.nextval		--deptno 를 다음 값으로 업데이트
where deptno = 50;
```



#### Synonym

생성,확인,삭제

```sql
create synonym E			--생성
for emp;	

select * from E;			--확인

Drop synonym E;				--삭제
```



emp 테이블을 E라는 이름의 동의어로 사용할 수 있다.

