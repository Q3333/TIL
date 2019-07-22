<%@ page language="java" contentType="text/html; charset=utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>send2.jsp</title>
</head>
<body>
<h3>send2.jsp</h3>
메시지 1: ${param.msg1 }<br>
메시지 2: ${param["msg2"]}<br>

컨텍스트 파라미터 값 : <%=application.getInitParameter("db_driver")%><br>
컨텍스트 파라미터 값 : ${initParam.db_driver} <br>

request에 저장된 key1의 값 : ${key1} <br>
request에 저장된 key1의 값 : ${requestScope.key1} <br>

session에 저장된 key2의 값 : ${key2} <br>
session에 저장된 key2의 값 : ${sessionScope.key2} <br>

application에 저장된 key3의 값 : ${key3} <br>
application에 저장된 key3의 값 : ${applicationScope.key3} <br>

request의 헤더 user-agent : ${header["user-agent"]}<br>

</body>
</html>