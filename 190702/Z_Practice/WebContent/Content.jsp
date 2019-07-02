<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
 <body>
    <h3>부분페이지 갱신, POST요청, XML응답처리</h3>
    <table border="1">
      <tr>
      <td colspan="2" align="center">
     <jsp:include page="header.jsp">
     	<jsp:param name="company" value="인공지능기반 매칭서비스"/>
     	</jsp:include>
      </td></tr>
      
         <td>
        <jsp:include page ="menu.jsp"/>
         </td>
         <td width="400"><img src="dog.jpg"></td>
      </tr>
      
      <tr>
      <td colspan="2" align="center">
     	<jsp:include page ="footer.jsp">
     		<jsp:param name="address" value="서울 광화문"/>
     		</jsp:include>
      </td></tr>
    </table>
  </body>
</html>