<%@ page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html><head><title>상품 목록</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="mystyle.css" rel="stylesheet" type="text/css">
</head>

<body>
 
<h3 id="header">상품 목록</h3>
 

<div id='menu'>
<%@ include file="mymenu.jsp" %>
</div>

<div id="main">

<div class="container">
	<div class="row" align="center">
	<c:forEach var="prod" items="${products}">
		<div class="col-md-4">
			<img src="./image/${prod.filename}" style="width: 100%">
			<h3>${prod.pname}</h3>
			<p>${prod.description}
			<p>${prod.unitPrice} 원
			
			<!-- <form id='product' action='./productView2.do?prodid=${prod.productid }' method='post'>
				<input type='hidden' name='PID' value='${pord.PRODUCTID}' >
 -->

		 <p><a href="./productView2.do?prodid=${prod.productid }" class="btn btn-secondary" role="button"> 상세 정보 &raquo;</a>
		 

		 
		</div>
		
		</c:forEach>
	</div>
	</div>
	</div>




</body>
</html>
