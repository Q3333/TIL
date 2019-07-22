# SQL 5일차 복습

### SQL 복습

##### 테이블 컬럼 변경 관련

테이블 컬럼 추가 :  alter table ~ add (컬럼 컬럼타입 [제약조건]);

테이블 컬럼 삭제 :  alter table ~ drop column 컬럼명;
                   			  alter table ~ drop (컬럼, 컬럼);

테이블 컬럼 이름 변경  : alter table ~ rename column  old to new;

테이블 컬럼타입 또는 size 변경 : alter table ~ modify (컬럼 컬럼타입(size));



##### 제약조건 변경 관련

제약조건을 컬럼추가 : alter table ~ add constraint 이름 타입 ;

컬럼에 정의되어 있는 제약조건 삭제 : alter table ~ drop constraint 이름;

제약조건을 활성화 : alter table ~ enable constraint 이름;

제약조건을 비활성화 : alter table ~ disable constraint 이름;



##### 테이블 삭제 관련

테이블 삭제 :  drop table ~ ;  또는 drop table ~ purge;

테이블 복원 (recyclebin으로부터 drop된 테이블):  flashback table ~ to before drop;

테이블의 구조는 남겨두고 데이터만 물리적으로 완전시키고, 사용했던 공간 할당 해제하지 않기 위해 사용하는 명령어 :  truncate table ~;  / truncate table ~ reuse storage;



##### View 관련

- View : 논리적 테이블, table에 대한 window
- View 사용 목적 - 보안, 간결한 sql 사용
- 



Simple View - DML이 가능한 뷰 (base table의 not null 컬럼 모두 포함, 표현식 X, 그룹핑 X, rowid X, rownum X)

Complex View -  DML이 불가능한 뷰 (2개 이상의 테이블로부터 join 포함, 그룹핑, 함수 표현식 등이 포함된 경우)



View 생성 : create [force|noforce] view 뷰이름 

View 수정 및 생성 : create or replace  [force|noforce] view 뷰이름 

※ alter view 구문 X

※ drop view 뷰이름 ---테이블에 영향을 주지 않습니다.

※ 테이블 삭제하면 - 구조, 데이터, 제약조건, 인덱스 함께 삭제됩니다.

※ 테이블에 대한 view가 존재하는데..테이블이 삭제(drop)되면 뷰는 status는 invalid상태로 변경되어 사용 불가



View의 형태 :

```sql
as 
  select ~
  from ~
  [where ~]
  [group by ~]
  [having ~]
  [order by ~]
  [with check option]  ---체크 제약 조건
  [with read only]  --read only 제약조건
```

※ View의 제약조건은 Check와 read only 2개다.



View 생성을 확인하는 테이블 : user_views, all_views, dba_views - text컬럼



##### Index 관련

- index - 검색속도를 향상(select 수행 성능향상)을 위해서 사용하는 객체



Index의 종류

b*tree index : -- root node - branch node - leaf node 의 형태의 인덱스

​							 (컬럼값rowid형태로 인덱스 엔트리들이 저장됨, 컬럼값의 오름차순)

bitmap index  

단일 컬럼 인덱스

복합 컬럼 인덱스

function based index - 컬럼표현식의 결과값으로 인덱스 생성



Index 생성, 수정, 삭제

create index ~ on 테이블(컬럼 [desc]);
alter index ~ on 테이블(컬럼....);
drop index ~ ;



##### Sequence 관련

- 최소값~최대값 범위내에서 설정된 증감값에 따라 정수를 생성 객체



형태 (생성) : 

```sql
create sequence ~
[start with ~]
[increment by ~]
[minvalue ~ | nominvalue]
[maxvalue ~ | nomaxvalue]
[cache n | nocache]
[cycle | nocycle];
-- [] 은 다 생략 가능
```



수정 , 삭제 :

```sql
alter sequence ~ ; -- start with는 alter로 변경 못 하는 속성이다. 
drop sequence ~; 
```



##### Synonym 관련

- 'schema.객체@dblink명' 처럼 긴 객체이름을 간결하게 줄여서 쓰기 위한 동의어



생성 형태 :

```sql
create synonym ~ for schema.객체@dblink명;
```





##### 권한 관련

- 데이터베이스에 connect하려면 대상 데이터베이스에 user명이 등록되어 있어야 하며, 인증방식도 정의되어 있어야 한다.
- create session권한이 있어야 한다.



형태 : 

```sql
create user ~     --권한은 DBA(sys, system , drop user~로 삭제없음)
identified by 비밀번호
[default tablespace ~] 	-- 사용 가능한 디폴트 테이블
[temp tablespace ~]		-- 임시로 사용 가눙한 테이블
[tablespace quota XXM]	-- DB에서 사용 가능한 용량(M = MB)
[profile ~]
[consumer group ~]

-- identified by 말고는 전부 생략 가능 (default 값이 있음.)
```



권한의 종류 :

1. 시스템권한 -- DBA가 관리

```sql
grant 권한,.... to user명,..., role명,...public;
revoke 권한,...from user명,..., role명,...public;

-- role 이란? 특정 업무, 직무와 연관된 권한들을 그룹핑한 것
```



2. 객체권한  -- 객체의 소유자, DBA

```sql
grant 권한,...on 객체[(컬럼,...)] to user명,..., role명,...public;
revoke 권한,...on 객체[(컬럼,...)] from user명,..., role명,...public;
```



3. role 생성 권한 -- DBA가 관리

```sql
create role ~ ;
grant 권한,.... to 롤명;
grant 롤,..to user명,..., role명,...public;
```



