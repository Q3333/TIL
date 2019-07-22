<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ELTest.jsp</title>
</head>
<body>
컨텍스트 파라미터 값 : <%=application.getInitParameter("db_driver") %><br>
컨텍스트 파라미터 값 : ${initParam.db_driver} <br>

</body>
</html>