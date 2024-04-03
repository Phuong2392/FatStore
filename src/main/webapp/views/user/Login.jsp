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
<link rel="stylesheet"
	href="<c:url value='/assets/user/css/login.css'/>">
</head>

<body>

	<%@ include file="/common/header.jsp"%>

	<main>
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form action="register" method="post">
					<h1>Create Account</h1>
					<input type="text" placeholder="Username" name="username" /> <input
						type="password" placeholder="Password" name="password" /> <input
						type="text" placeholder="Phone" name="phone" /> <input
						type="text" placeholder="Email" name="email" /> <input
						type="text" placeholder="Address" name="address" />
					<button>Sign Up</button>
				</form>
			</div>
			<div class="form-container sign-in-container">
				<form action="login" method="post">
					<h1>Sign in</h1>
					<div class="social-container">
						<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
							href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
						<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
					</div>
					<span>or use your account</span> <input type="username"
						name="username" placeholder="Username" /> <input type="password"
						name="password" placeholder="Password" /> <a href="#"
						data-toggle="modal" data-target="#forgotPassModal">Forgot your
						password?</a>
					<button>Sign In</button>
				</form>
			</div>
			<div class="overlay-container">
				<div class="overlay">
					<div class="overlay-panel overlay-left">
						<h1>Welcome Back!</h1>
						<p>To keep connected with us please login with your personal
							info</p>
						<button class="ghost" id="signIn">Sign In</button>
					</div>
					<div class="overlay-panel overlay-right">
						<h1>Hello, Friend!</h1>
						<p>Enter your personal details and start journey with us</p>
						<button class="ghost" id="signUp">Sign Up</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Forgot Password -->
		<div class="modal fade" id="forgotPassModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Forgot your
							password?</h5>
					</div>
					<div class="modal-body">
						<form action="forgotPass" method="post">
							<span>Enter email information</span> <input type="email"
								name="email" id="email" placeholder="Email" />
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="sendBtnForgotPass">Send</button>
							</div>
						</form>
					</div>
				</div>
			</div>
	</main>
	<script> 
	 const signUpButton = document.getElementById('signUp');
     const signInButton = document.getElementById('signIn');
     const container = document.getElementById('container');
     
     signUpButton.addEventListener('click', () => {
         container.classList.add("right-panel-active");
     });
     
     signInButton.addEventListener('click', () => {
         container.classList.remove("right-panel-active");
     });
     </script>
	<script>
     $('#sendBtnForgotPass').click(function(){
		 $('#messageReturn').text('');
	var email = $('#email').val();
	var formData = {'email' : email};
	$.ajax({
		url : 'forgotPass',
		type: 'POST',
		data: formData
		}).then(function(data){
			$('#messageReturn').text('Password has been reset. please check your email');
			setTimeout(function() {
				windown.location.href = 'http://localhost:8080/FatStore/index';
			}, 5 * 1000);
		}).fail(function(error){
			$('#messageReturn').text('Your information not correct, please check again');
		});
	});
     </script>
</body>
</html>