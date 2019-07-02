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
<%
	UserVO user = new UserVO();
	user.setUserid(request.getParameter("userid"));
	user.setUserpwd(request.getParameter("userpwd"));
	user.setUsername(request.getParameter("username"));
	user.setEmail(request.getParameter("email"));
	user.setPhone(request.getParameter("phone"));
	user.setAddress(request.getParameter("address"));
	user.setJob(request.getParameter("job"));
	
	LoginDAO dao = new LoginDAO();
	if(dao.joinProc(user)>0){

%>
아이디 : <%=user.getUserid() %>
이름 :	<%=user.getUsername() %>
비밀번호 :<%=user.getUserpwd() %>
전화번호 :<%=user.getPhone() %>
이메일 :<%=user.getEmail() %>
주소 : <%=user.getAddress() %>
직업 :<%=user.getJob() %>


<%
	}else{
%>
회원가입 처리 실패 <br>
<%
	}
%>
</body>
</html>