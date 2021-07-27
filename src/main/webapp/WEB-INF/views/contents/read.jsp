<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제품 상세 페이지 입니다.
	<br> 제품 번호 : ${dto.contentsno}
	<div class="container">

		<h2 class="col-sm-offset-2 col-sm-10">상품명 : ${dto.pname}</h2>
		<table class="table table-bordered">

			<tr>
				<td colspan="2" style="text-align: center"><img
					src="${root}/pstorage/${dto.filename}" width="250px" height="250px"
					class="img-rounded"></td>
			</tr>


			<tr>
				<th>가격</th>
				<td>${dto.price}</td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td>${dto.detail}</td>
			</tr>
			<tr>
				<th>재고</th>
				<td>${dto.stock}</td>
			</tr>

		</table>

			<form class="form-horizontal" action="/cart/create" method="post">
				<input type="hidden" name="contentsno" value="${dto.contentsno}">
				<input type="hidden" name="pname" value="${dto.pname}"> 
				<input type="hidden" name="price" value="${dto.price}"> 
				<input type="hidden" name="detail" value="${dto.detail}"> 
				<input type="hidden" name="stock" value="${dto.stock}"> 
				<input placeholder="수량 입력" type="text" name="quantity"> 
				<input type="submit" class="createcartbtn" value="장바구니 등록!"></input>
			</form>
 </div>
</body>


</html>

