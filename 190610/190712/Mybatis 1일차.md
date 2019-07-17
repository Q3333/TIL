# Mybatis



## AOP

- 여러 객체에 공통으로 적용할 수 있는 기능을 분리해서 재사용성을 높여주는 프로그래밍 기법.

- 핵심기능과 공통기능의 구현을 분리함으로써 핵심 기능을 구현한 코드의 수정 없이 공통 기능을 적용할 수 있게 만들어 준다.



#### Advice

공통 관심 기능을 핵심 로직에 적용할 지를 정의하는 것

ex) before, after, after returning, after throwing, around



#### Joinpoint 

Advice를 적용할 수 있는 위치



#### Pointcut

Jointpoint와 Advice를 결합 시킨 것을 부르는 용어



#### Weaving 

동적 개념, Advice를 핵심 로직 코드에 적용하는 것.



#### Aspect

타겟객체 + Pointcut



ex)

```xml
<bean id = "target" class=""/>
<bean id = "advice" class=""/>
<aop:aspect>
	<aop:pointcut ref="target">
	<aop:before ~ advice-ref..>
	<aop:after ~
	..
	</aop:pointcut>
	
```





## Mybatis

#### 데이터 영속성 관리 프레임 워크 (SQL Mapping)

- Mybatis는 개발자가 지정한 SQL, 저장프로시저 그리고 몇가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크이다. 
- Mybatis는 JDBC로 처리하는 상당부분의 코드와 파라미터 설정및 결과 매핑을 대신해준다. 
- Mybatis는 데이터베이스 레코드에 원시타입(Java의 Primitive 타입) 과 Map 인터페이스 그리고 자바 POJO 를 설정해서 매핑하기 위해 XML과 애노테이션을 사용할 수 있다.





흐름

설정파일 XML  -> Mybatis Framework -> SQL Session Factory Builder -> SQL Session Factory



SQL Session Factory 는 여태까지 써왔던 Connection이나 Jdbc Template 과 같은 역할을 한다.



## Mybatis 와 Spring 연동



해당 3개의 빈을 pom.xml에 추가해 주어야 함.

```
<bean id ="dataSource"
class = "org.springframework.jdbc.datasource.DriverManagerDataSource"
p:driverClassName="oracle.jdbc.OracleDriver"
p:url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"
p:username="scott" p:password="oracle" />

<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  <property name="dataSource" ref="dataSource" />
   <property name="mapperLocations" value="classpath*:lab/mybatis/user/*.xml" />
</bean>

<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
  <constructor-arg index="0" ref="sqlSessionFactory" />
</bean>
```

※ 상세 내용은 개발환경에 맞게 변경해야함.



# 실습(spring_orm)

Mybatis 사용, 오류 확인용 LOG4J

※ 오토커밋 해주는 명령어

```
SqlSession sqlSession = sqlSessionFactory.openSession(true);
```

괄호 안에 true만 넣어주면 됨