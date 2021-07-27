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
							<c:forEach var="order" items="${cartAndContents}">
								<!-- ${fn:substring(order.odate,0,10)} 추가 필요-->
								<li class="list-group-item">${order.cartno}, ${fn:substring(order.odate,0,10)},
									${order.pname}, ${order.quantity}, ${order.price }원 <a
									href="review/create/{order.contentsno}"><span class="badge">Rivew</span></a>
								</li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>