<%@ page contentType="text/html;charset = utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<style>
p{color:blue;}

</style>
<title>loginFail.jsp</title>
</head>
<body>


<C:if test="${empty authInfo}">
<font color="red">${authInfo.userid}님 아이디가 존재하지 않거나,
비밀번호 오류입니다.</font><br>
<a href="<c:url value='/login.do'/>">로그인</a><br>
<a href="<c:url value='/add.do'/>">회원가입</a><br>

</C:if>

</body>


</html>