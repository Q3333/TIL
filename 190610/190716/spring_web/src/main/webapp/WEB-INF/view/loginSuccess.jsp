<%@ page contentType="text/html;charset = utf-8" pageEncoding="utf-8" %>

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
<p> ${user.userid}님 환영합니다.</p>
고객님의 정보를 수정하시겠습니까? <br>
이름 : ${user.username}<br>
전화번호 : ${user.phone}<br>
이메일 : ${user.email}<br>
주소 : ${user.address}<br>
업무 : ${user.job}<br>


<form name="f" method="get" action="./modify.do">
	  	<table border="0" cellpadding="0" cellspacing="1" width="590">
			<tr>
				<td align="right">
					<input type="hidden" value="${user.userid}" name="userid" />
					
					<input type="submit" value="정보 수정하기"/>
				</td>
			</tr>
		</table>		
	</td>
</tr>
</table>  
</form>

</body>
</html>