<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	카트다 이녀석아
	<br> 로그인된 아이디의 id값 : "${id}"
	<br> "${pname}"
	<br>
	<c:forEach var="cart" items="${cartlist}">
		<!-- 이미지나 상품 상세 링크 필요하면 추가하기.-->
		<li class="list-group-item">${cart.pname},${cart.quantity},
			${cart.price }원</li>
	</c:forEach>
	<form class="form-horizontal" action="/order" method="post">
		<input type="hidden" name="cartno" value="${cartno}">
		<input type="hidden" name="contentsno" value="${dto.contentsno}">
		<input type="hidden" name="pname" value="${dto.pname}"> 
		<input type="hidden" name="price" value="${dto.price}">
		<input type="hidden" name="detail" value="${dto.detail}">
		<input type="hidden" name="stock" value="${dto.stock}"> 
		<input type="hidden" name="quantity"> 
		<input type="submit" class="createcartbtn" value="주문하기!"></input>
	</form>

	cartno : "${cartno}"
</body>
</html>