# JSP & Servlet 2

## 전날 복습

 **Servlet** : www 웹 서비스 제공하는 **웹 서버에서 실행되는 웹 컴포넌트를 구현하는 기술**
           웹 요청을 처리, **처리 결과를 동적**으로 응답 페이지 (html) 생성, 응답 보낸다.



**WAS** : **Web Server + Application Server**
      (http listener, http daemon) + WebContainer(서버에서 실행되는 웹 컴포넌트의 실행환경을 제공, NamingContext 기능, Resource Pooling 기능,...)
              



#### JSP(Java Server Page) - script 

웹 컨텍스트 표준 구조 :
웹 컨텍스트 (http://ip:8080/web1)
  |----html, js, css, image,...jsp 
  |---WEB-INF  (보안 폴더)
        |---classes (패키지형태-class파일)
        |---lib (jar파일형태 -외부 자바 library)
        |---web.xml(웹 컨텍스트의 환경설정파일 - 컨텍스트의 파라미터, 리스너, 필터, 전역세션timeout, 전역 에러 								페이지, 서블릿, 리소스 참조, welcome-file-list,...)
        |---src
        |---tld, tags
        





JSP - 브라우저로 보내지는 데이터를 한글 처리해주는 명령어

```
response.setContentType("text/html;charset=utf-8");
```





 [Servlet Spec]
 1. 패키지 선언
 2. public class로 선언
 3. HttpServlet 상속 받고
 4. life cycle 메서드 override 
    반드시 override해야 할 메서드는 service(), doGet(), doPost(), doPut(), ...메서드는 요청 처리 및 응답을 위해 반드시 override해야 합니다.
        

```
service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {} 
```



[JSP Spec]
정적 페이지 선언 <%@ page .....%>





회원가입 예제



html

```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3> 회원가입 페이지</h3>
<form id="f1" action="join" method="post" >
userid : <input type="text" name="userid" ><br>
password : <input type="password" name="userpwd" ><br>
  <input type="hidden" name="address" value="서울" ><br>
관심사항 : <input type="checkbox" name="interest" value="영화">영화 
           <input type="checkbox" name="interest" value="게임">게임
           <input type="checkbox" name="interest" value="경제">경제 
           <input type="checkbox" name="interest" value="여행">여행
           <input type="checkbox" name="interest" value="낚시">낚시
           <input type="checkbox" name="interest" value="등산">등산<br> 
  <input type="submit"   value="회원가입" >
  <input type="reset"   value="취소" ><br>
</form>


</form>
</body>
</html>
```

html 중 action = join을 통해서 servlet으로 이동이 되서 서블릿의 내용을 실행해 준다.





Servlet

```
package lab.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class Join_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Join_servlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Request로 파라미터 처리</title><head>");
		out.print("<body>");
		out.print("<h3>Request로 파라미터 처리 </h3>");
		out.print("<ul>");
		out.print("<li> userid : "+request.getParameter("userid") +"</li>");
		out.print("<li> password : "+request.getParameter("userpwd") +"</li>");
		out.print("<li> address : "+request.getParameter("address") +"</li>");
		out.print("<li> userid : "+request.getParameter("userid") +"</li>");
		String interest[] = request.getParameterValues("interest");
		out.print("<li> 관심사항 :");
		for(String inter : interest) {
			out.print(inter + ", ");
		}
		out.print("</li>");
		out.print("</body></html>");
	
	}

}
```



체크박스의 interest를 이터레이터로 돌려서 체크된 것들을 전부 출력 해 준다.