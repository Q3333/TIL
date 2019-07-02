<%@ page language="java" contentType="text/html; charset=utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<% request.setAttribute("key1","request에 저장된 정보");
	session.setAttribute("key2","session에서 저장된 정보");
	application.setAttribute("key3","ServerContext객체에서 저장된 정보");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>send1.jsp</title>
</head>
<body>
<jsp:forward page="send2.jsp">
	<jsp:param name="msg2" value="두번째 메세지 입니다."/>
</jsp:forward>
</body>
</html>