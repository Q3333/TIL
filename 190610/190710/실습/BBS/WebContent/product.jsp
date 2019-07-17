<%@ page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<html><head><title>상품 상세 정보</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="mystyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {		
			document.addForm.reset();
		}
	}
</script>

</head>
 
<body>
 

<h3 id="header">상품 상세 정보</h3>

<div id='menu'>
<%@ include file="mymenu.jsp" %>
</div>


</div>

<div id="main" >
 <div class="container" >
		<div class="row">
			<div class="col-md-5">
				<img src="./image/${prod.filename}" style="width: 100%" />
			</div>
			<div class="col-md-6">
				<h3>상품이름 : </h3> ${prod.pname}
				<p>상품설명 : </p> ${prod.description}
				<p><b>상품 코드 : ${prod.productid}</b><span class="badge badge-danger">  </span>
				<p><b>제조사</b> :  ${prod.manufacturer}
				<p><b>분류</b> :  ${prod.category}
				<p><b>재고 수</b> :  ${prod.unitsInStock}
				<h4>가격 원</h4> : ${prod.unitPrice }
				
				
				<p><form name="addForm" action="./addCart.jsp?prodid= " method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()"> 상품 주문 &raquo;</a>
					<a href=" " class="btn btn-warning"> 장바구니 &raquo;</a> 
					<a href=" " class="btn btn-secondary"> 상품 목록 &raquo;</a>
				</form>
			</div>
		</div>
		<hr>
	</div>
</div>



</body>
</html>
