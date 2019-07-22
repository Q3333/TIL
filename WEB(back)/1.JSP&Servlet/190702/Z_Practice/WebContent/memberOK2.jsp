<%@page import="lab.web.model.LoginDAO"%>
<%@page import="lab.web.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "user" class ="lab.web.model.UserVO">
<jsp:setProperty name ="user" property="*" />
</jsp:useBean>

<jsp:useBean id = "dao" class ="lab.web.model.LoginDAO"/>
<%
	if(dao.joinProc(user)>0){

%>
아이디 : <jsp:getProperty name ="user" property="userid" /> <br>
이름 :	<jsp:getProperty name ="user" property="username" /> <br>
비밀번호 :<jsp:getProperty name ="user" property="userpwd" /> <br>
전화번호 :<jsp:getProperty name ="user" property="phone" /> <br>
이메일 :<jsp:getProperty name ="user" property="email" /> <br>
주소 : <jsp:getProperty name ="user" property="address" /> <br>
직업 :<jsp:getProperty name ="user" property="job" /> <br>


<%
	}else{
%>
회원가입 처리 실패 <br>
<%
	}
%>
</body>
</html>