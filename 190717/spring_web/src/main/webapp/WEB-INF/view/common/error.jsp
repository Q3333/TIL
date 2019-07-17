<%@ page contentType="text/html; charset=utf-8"
	isErrorPage = "true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
예외가 발생하였습니다. : <br>
<%=exception.getMessage() %> <br>
${exception.message}
</body>
</html>