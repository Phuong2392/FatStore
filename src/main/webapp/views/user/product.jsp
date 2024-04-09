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

	<main>
		<section class="latest-product-area padding-bottom">
			<div class="container">
				<div class="tab-content" id="nav-tabContent">
					<!-- card one -->
					<div class="tab-pane fade show active" id="nav-home"
						role="tabpanel" aria-labelledby="nav-home-tab">
						<div class="row">
							<c:forEach items="${products}" var="products">
								<div class="col-xl-4 col-lg-4 col-md-6">
									<div class="single-product mb-60">
										<div class="product-img">
											<img
												src="<c:url value='assets/user/img/categori/${products.image}'/>"
												alt="">
											<div class="new-product">
												<span>New</span>
											</div>
										</div>
										<div class="product-caption">
											<div class="product-ratting">
												<i class="far fa-star"></i> <i class="far fa-star"></i> <i
													class="far fa-star"></i> <i class="far fa-star low-star"></i>
												<i class="far fa-star low-star"></i>
											</div>
											<h4>
												<a href="#">${products.name}</a>
											</h4>
											<div class="price">
												<ul>
													<li>VND${products.price}</li>
													<li class="discount">VND 40.00</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<%-- <div class="row tm-mb-90">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:if test="${currentPage == 1}">
								<li class="page-item disabled"><a class="page-link"
									href="javascript:void(0);" tabindex="-1">Previous</a></li>
							</c:if>
							<c:if test="${currentPage > 1}">
								<li class="page-item"><a class="page-link"
									href="products?page=${currentPage - 1}" tabindex="-1">Previous</a></li>
							</c:if>
							<c:forEach varStatus="i" begin="1" end="${maxPage}">
								<a
									class="page-link ${currentPage == i.products ? 'active' : ''}"
									href="products?page=${i.products}">${i.products}</a>
							</c:forEach>
							<c:if test="${currentPage == maxPage}">
								<li class="page-item"><a class="page-link"
									href="javascript:void(0);">Next</a>
							</c:if>
							<c:if test="${currentPage < maxPage}">
								<li class="page-item disabled"><a class="page-link"
									href="products?page=${currentPage + 1}">Next</a>
							</c:if>
							</li>
						</ul>
					</nav>
				</div> --%>
		</section>
	</main>
</body>
</html>