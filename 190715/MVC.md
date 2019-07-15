# MVC

MVC = model View Controller

**Model** = 주로 자바 코드로 작성, 어플리케이션의 데이터와 비즈니스 로직을 담는 객체이다.

**View** = 주로 JSP로 작성, Model의 정보를 사용자에게 표시한다. 하나의 Model을 다양한 View에서 사용할 수 있다.

**Controller** = Model과 View의 중계역활로 view를 선택한다. 사용자의 요청을 받아 Model에 변경된 상태를 반영하고, 응답
을 위한 View를 선택해준다.





#### Spring MVC

- **DispatcherServlet**, **HandlerMapping**, **Controller**, **Interceptor**, **ViewResolver**, **View등** 각 컴포넌트들의 역할이 명확하게 분리된다.
- HandlerMapping, Controller, View등 컴포넌트들에 다양한 인터페이스 및 구현 클래스를 제공한다.
- Controller(@MVC)나 폼 클래스(커맨드 클래스) 작성시에 특정 클래스를 상속받거나 참조할 필요 없이 POJO 나 POJOstyle의 클래스를 작성함으로써 비지니스 로직에 집중한 코드를 작성할 수 있다.
- 웹요청 파라미터와 커맨드 클래스간에 데이터 매핑 기능을 제공한다.
- 데이터 검증을 할 수 있는, Validator와 Error 처리 기능을 제공한다.
- JSP Form을 쉽게 구성하도록 Tag를 제공한다.





#### DispatcherServlet

**-Spring MVC Framework의 Front Controller, 웹요청과 응답의 Life Cycle을 주관한다.**

- FrontController (web.xml에 설정)

- IOC Controller - 빈 설정 파일도 DispatcherServlet에 등록해줘야함.

위의 두가지 역할을 한다.

ex) list.do, view.do 같은 명령어를 DispatcherServlet가 받고 HandlerMapping에 전달한다.



#### HandlerMapping

**-웹요청시 해당 URL을 어떤 Controller가 처리할지 결정한다.**

list.do, view.do 같은 명령어를 전달받고 해당 이름에 맞는 빈 클래스를 찾고, 해당 컨트롤러 이름을 다시 

DispatcherServlet에 전달한다. (DispatcherServlet는 IOC Controller이기도 하기 때문에, 전달받은 빈클래스를 이용하여 DispatcherServlet가 Controller에 다시 연결 )



#### Controller

**-비지니스 로직을 수행하고 결과 데이터를 ModelAndView에 반영한다.**



#### ModelAndView

**-Controller가 수행 결과를 반영하는 Model 데이터 객체와 이동할 페이지 정보(또는 View객체)로 이루어져 있다.**



#### ViewResolver

**-어떤 View를 선택할지 결정한다.**



#### View

**-결과 데이터인 Model 객체를 display한다.**



개발자는 Controller와 View만 만들면 된다. (나머지는 제공이 됨.)





참고용 사진



![](https://github.com/Q3333/ITL/blob/master/190715/img/pic1.PNG)



![](https://github.com/Q3333/ITL/blob/master/190715/img/pic2.PNG)







@RequestMapping

요청에 대한 어떤 COntroller, 어떤 메소드가 처리할지를 맵핑하기 위한 어노테이션



value : String [] - 값으로 매핑



# 흐름 파악하는 것이 매우 중요!

SqlSessionFactoryBean

▼

SqlSessionTemplate

▼

SqlSession

▼

@@@DAO(ex - UserDAO)             ◀         UserSevice 

