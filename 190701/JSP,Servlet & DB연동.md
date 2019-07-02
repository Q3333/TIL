# JSP, Servlet 3 & DB연동

## 전날 복습

 

#JSP요소
정적 지시자 

​			<%@ page ---%>

​            <%@ include  --- %>

​            <%@ taglib --- %>



동적 지시자 

​					<jsp:include ~ > </jsp:include >

​         		   <jsp:useBean ~><jsp:getProperty  ~~~ />

​					<jsp:setProperty ~~/></jsp:useBean>
 		                        



자바코드와 관련된 JSP 요소

1. <%!

​		변수 선언 초기화; //

​		메서드 정의 //

%>



2. <%

​	자바 실행 문장 ; // 변환된 서블릿에 _jspService() 포함

...

%>



3. <%= 출력내용 %> 는 <% out.print(출력 내용); %> 와 동일.

${출력내용 }





# ※ (중요) DB연동 

LoginDAO

```
package lab.web.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class LoginDAO {
	public Connection dbCon() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/workspace2/Web07_01_2/WebContent/WEB-INF/dbinfo.properties"));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"),
			prop.getProperty("user"), prop.getProperty("pwd"));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void dbClose(Connection con, Statement stat, ResultSet rs)
	{
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean loginProc(String uid, String upwd) {
		boolean success = false;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "select * from userinfo where userid=? and userpwd =?";
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, uid);
			stat.setString(2, upwd);
			stat.executeQuery();
			rs = stat.executeQuery();
			if(rs.next()) {
				success = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con,stat,rs);
		}
		return success;
	}	
}
```



소스 코드 사용할 때 dbinfo.properties의 경로를 확인 하는 것이 중요하다. 



LoginSevlet

```
package lab.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.web.model.LoginDAO;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html);charset=utf-8");
		response.sendRedirect("./login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html);charset=utf-8");
		String uid = request.getParameter("userid");
		String upwd = request.getParameter("userpwd");
		LoginDAO dao = new LoginDAO();
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = null;
		if(dao.loginProc(uid,upwd)) {
			rd = sc.getRequestDispatcher("/loginSuc.jsp");
			request.setAttribute("userid", uid);
			rd.forward(request, response);
			
		}
		else {
			rd = sc.getRequestDispatcher("/loginFail.jsp");
			rd.forward(request, response);
		}			
			}
}
```

@WebServlet("/Login") 명령어로 들어올 수 있다.

로그인 성공 , 실패 여부에 따라 다른 jsp 파일들을 불러와줌.



loginSuc.jsp

```
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>loginSuc.jsp</title>
<style>
p{
color : blue;
}
</style>
</head>
<body>
<p> ${userid}님 환영합니당 </p>

</body>
</html>
```

 ${userid} 로 로그인한 유저의 아이디를 따올 수 있다.





loginFail.jsp

```
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>loginFail.jsp</title>
<style>
p{
	color:red;
}
</style>
</head>
<body>
<p> 아이디가 존재하지 않거나 패스워드가 일치하지 않습니다. </p>
<a href="login.jsp">다시 로그인 하기</a><br>
</body>
</html>
```



실패화면

href 안 헷갈리게 주의

Hyper + REFenrece 이다.



​	



Login.jsp

```
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>우리 회사</h3>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>우리회사</b></font></td></tr>
      <tr>
                <td><form action="Login" method="post">
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" id="userid" name = "userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" id="userpwd" name="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="submit" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
         <td width="400"><img src="dog.jpg"></td>
      </tr>
      <tr><td colspan="2" align="center">찾아오시는길 |회사소개|정보보호정책</td></tr>
    </table>
  </body>
</body>
</html>
```



아마도 메인화면

실행 시킬 때 얘로 실행시킴.

form action="Login"을 통해 /Login의 서블릿이 실행됨.