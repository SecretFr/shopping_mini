<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문하기</title>
</head>
<body>
	<div class="container">
		<h1 class="col-sm-offset-2 col-sm-10">주문하기</h1>
		<c:choose>
			<c:when test="${empty cartAndContents }">장바구니에 상품이 없습니다.</c:when>
			<c:otherwise>
				<c:forEach var="contents" items="${cartAndContents}">
					<!-- 이미지나 상품 상세 링크 필요하면 추가하기.-->
					<li class="list-group-item">${contents.pname},${contents.quantity},
						${contents.price }원</li>
				</c:forEach>

				<form class="form-horizontal" action="/order" method="post">

					<div class="form-group">
						<label class="control-label col-sm-2" for="cateno">결제방식</label>
						<div class="col-sm-6">
							<select class="form-control" name="payment">
								<option value="신용카드" selected>신용 카드</option>
								<option value="계좌이체">계좌 이체</option>
								<option value="카카오페이">카카오페이</option>
								<option value="토스">토스</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-5">
							<button class="btn">등록</button>
							<button type="reset" class="btn">취소</button>
						</div>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>