<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

<script>

function deleteCart(){
	
	alert("장바구니가 삭제되었습니다.");
}

</script>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${empty cartlist }">장바구니 목록이 없습니다.</c:when>
	
			<c:otherwise>
				<h2 class="col-sm-offset-2 col-sm-10">장바구니 목록</h2>
				<c:forEach var="dto" items="${cartlist}" >
				
				<button class="btn btn-fail" onclick="deleteCart()"><a href="${root}/cart/delete/${cartno}/${dto.contentsCartNo}">장바구니 삭제하기</a></button>
					<table class="table table-bordered">
						<tr>
							<th class="col-sm-2">아이디</th>
							<td class="col-sm-8"><a href="javascript:read('${dto.id}')">${dto.id}</a></td>
						</tr>
						<tr>
							<th class="col-sm-2">상품명</th>
							<td class="col-sm-8">${dto.pname}</td>
						</tr>
						<tr>
							<th class="col-sm-2">가격</th>
							<td class="col-sm-8" id="price">${dto.price}</td>
						</tr>
						<tr>
							<th class="col-sm-2">수량</th>
							<td class="col-sm-8" id="quantity">${dto.quantity}</td>
						</tr>
						<tr>
							<th class="col-sm-2">합계</th>
							<td class="col-sm-8" id="sum">${dto.sum }</td>
						</tr>
					
					</table>
						
				</c:forEach>
		${paging}

	
	
	
	
	
			<form class="form-horizontal" action="/order" method="post">
				<input type="hidden" name="cartno" value="${cartno}"> <input
					type="hidden" name="contentsno" value="${dto.contentsno}"> <input
					type="hidden" name="pname" value="${dto.pname}"> <input
					type="hidden" name="price" value="${dto.price}"> <input
					type="hidden" name="detail" value="${dto.detail}"> <input
					type="hidden" name="stock" value="${dto.stock}"> <input
					type="hidden" name="quantity">
				<p class="text-center">
					<input type="submit" class="btn btn-success " value="주문하기!"></input>
				</p>
			</form>
		</c:otherwise>
	</c:choose>
	</div>

	<script>
/* 		var quantity = $('#quantity').text();
		var price = $('#price').text();
		var sum = price * quantity;
		console.log(quantity);
		console.log(price);
		document.getElementById('sum').innerHTML = sum; */
	</script>
</body>
</html>