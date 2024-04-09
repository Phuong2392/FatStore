<div id="preloader-active">
	<div class="preloader d-flex align-items-center justify-content-center">
		<div class="preloader-inner position-relative">
			<div class="preloader-circle"></div>
			<div class="preloader-img pere-text">
				<img src="<c:url value='assets/user/img/logo/logo.jpg'/>" alt="">
			</div>
		</div>
	</div>
</div>
<!-- Preloader Start -->

<header>
	<!-- Header Start -->
	<div class="header-area">
		<div class="main-header ">
			<div class="header-top top-bg d-none d-lg-block">
				<div class="container-fluid">
					<div class="col-xl-12">
						<div class="row d-flex justify-content-between align-items-center">
							<div class="header-info-left d-flex">
								<div class="flag">
									<img
										src="<c:url value='assets/user/img/icon/header_icon.png'/>"
										alt="">
								</div>

							</div>
							<div class="header-info-right">
								<ul>
									<c:choose>
										<c:when test="${ not empty sessionScope.currentUser}">
											<li><a style="color: white">Welcome,
													${sessionScope.currentUser.username}</a></li>
											<li><a href="#" style="color: white" data-toggle="modal" data-target="#changePassModal">Change
													password</a></li>
											<li><a href="logout" style="color: white">Logout</a></li>
											 <li><a href="myorder" style="color: white">My Order</a></li>
											<c:if test="${!sessionScope.currentUser.isadmin}">
           										 <li><a href="adminIndex" style="color: white">Dashboard</a></li>
        									</c:if>
										</c:when>
										<c:otherwise>
											<li><a href="login">Sign In</a></li>
											<li><a href="login">Sign Up</a></li>
										</c:otherwise>
									</c:choose>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="header-bottom  header-sticky">
				<div class="container-fluid">
					<div class="row align-items-center">
						<!-- Logo -->
						<div class="col-xl-1 col-lg-1 col-md-1 col-sm-3">
							<div class="logo">
								<a href="index.html"><img
									src="<c:url value='assets/user/img/logo/logo.png'/>" alt=""></a>
							</div>
						</div>
						<div class="col-xl-6 col-lg-8 col-md-7 col-sm-5">
							<!-- Main-menu -->
							<div class="main-menu f-right d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li><a href="index">Home</a></li>
										<li class="hot"><a href="products">Product</a></li>
										<li><a href="contact.html">Contact</a></li>
									</ul>
								</nav>
							</div>
						</div>
						<div class="col-xl-5 col-lg-3 col-md-3 col-sm-3 fix-card">
							<ul
								class="header-right f-right d-none d-lg-block d-flex justify-content-between">
								<li class="d-none d-xl-block">
									<div class="form-box f-right ">
										<input type="text" name="Search" placeholder="Search products">
										<div class="search-icon">
											<i class="fas fa-search special-tag"></i>
										</div>
									</div>
								</li>
								<li class=" d-none d-xl-block">
									<div class="favorit-items">
										<i class="far fa-heart"></i>
									</div>
								</li>
								<li>
									<div class="shopping-card">
										<a href="cart.html"><i class="fas fa-shopping-cart"></i></a>
									</div>
								</li>
							</ul>
						</div>
						<!-- Mobile Menu -->
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Change Password -->
	<div class="modal fade" id="changePassModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
					</div>
					<div class="modal-body">
						<form action="changePass" method="post">
							<span>Old password</span> <input type="password"
								name="oldPass"  id="oldPass" placeholder="Old password" />
								<div>
								
								</div>
								<span>New password</span> <input type="password"
								name="newPass"  id="newPass" placeholder="New password" />
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="btnChangePass" >Send</button>
							</div>
						</form>
					</div>
				</div>
			</div>
	<!-- Header End -->
</header>