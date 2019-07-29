<%@ page contentType="text/html;charset = utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<style>
p{color:red;}

</style>
<title>loginSuccess.jsp</title>
</head>
<body>
<C:if test="${!empty authInfo}">

<font color="blue">${authInfo.userid}님 환영합니다.</font><br>
<a href="<c:url value='/view.do?userid=${authInfo.userid}'/>">고객 정보 </a><br>
<a href="<c:url value='/list.do'/>">고객 정보 리스트</a><br>
<a href="<c:url value='/logout.do'/>">로그 아웃</a><br>


</C:if>
</body>
</html>

