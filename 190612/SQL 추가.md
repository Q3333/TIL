# SQL 추가 연습



## Create

ex) create [Student] table

```sql
create table student (
studentNO   varchar2(5)  constraint student_pk primary key,
studentName varchar2(15)   not null,
c           number(3),
linux       number(3),
java        number(3),
careerYears number(2),
internYn     char(1) check (internYn in ('Y', 'N'))
);
```



### ※ 제약조건 넣는법

Primary key 설정

**studentNO   varchar2(5)  constraint student_pk primary key,**

뒤에 constraint를 붙여준다. 



Not null 제약조건 

**studentName varchar2(15)   not null,**



체크 조건

**internYn     char(1) check (internYn in ('Y', 'N'))**



## Alter

테이블변경



#### add

alter table student add (average number(5,2), pass char(1) check (pass in ('Y', 'N')));



#### rename

alter table student rename column average to avvvvv;



#### Modify

alter table student modify (

c           number(3) default 0,
linux       number(3) default 0,
java        number(3) default 0

);



### Drop

alter table student  drop column abc;



abc라는 컬럼을 삭제