<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h3>
					<span class="glyphicon glyphicon-user"></span> 나의 정보
				</h3>
				<img class="img-rounded" src="/storage/${member.fname}"
					style="width: 280px">${member.fname}
				<div class="caption">
					<p>ID:${member.id}, 성명:${member.mname}</p>
					<p>배송지:(${member.zipcode })${member.address1 }
						${member.address2}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<h3>
					<span class="glyphicon glyphicon-gift"></span> 주문 내역 및 리뷰 작성
				</h3>
				<ul class="list-group">
					<c:choose>
						<c:when test="${empty cartAndContents }">주문한 상품이 없습니다.</c:when>

						<c:otherwise>
							<c:forEach var="dto" items="${cartAndContents}">
								<table class="table table-bordered">
									<tr>
										<th class="col-sm-2">주문일</th>
										<td class="col-sm-8">${dto.odate}</td>
									</tr>
									<tr>
										<th class="col-sm-2">아이디</th>
										<td class="col-sm-8"><a
											href="javascript:read('${dto.id}')">${dto.id}</a></td>
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
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<script>
		var quantity = $('#quantity').text();
		var price = $('#price').text();
		var sum = price * quantity;
		console.log(quantity);
		console.log(price);
		document.getElementById('sum').innerHTML = sum;
	</script>
</body>
</html>