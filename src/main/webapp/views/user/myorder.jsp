<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Estore</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">
<%@ include file="/common/head.jsp"%>
</head>

<body>

	<%@ include file="/common/header.jsp"%>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Price</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="orders">
				<tr>
					<td>${orders.id}</td>
					<td>${orders.price}</td>
					<td><c:choose>
							<c:when test="${orders.status == true}">Đã thanh toán</c:when>
							<c:otherwise>Chưa thanh toán</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>