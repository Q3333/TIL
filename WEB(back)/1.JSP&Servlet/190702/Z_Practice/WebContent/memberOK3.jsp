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


아이디 : ${user.userid}<br>
이름 :	${user.username} <br>
비밀번호 :${user.userpwd} <br>
전화번호 :${user.phone} <br>
이메일 : ${user.email}<br>
주소 :${user.address} <br>
직업 :${user.job} <br>


</body>
</html>