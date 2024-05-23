<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Browser</title>
	<!-- Add Bootstrap CSS -->"#"><h1>🔑</h1> <h5>인증키 발급</h5></a>
		</div>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom CSS for background image and input field -->
		<style>
			body {
				background-image: url("https://velog.velcdn.com/images/zihooy/post/6e977005-c268-4c28-bd0c-4d968ca3684e/image.png");
				background-size: cover;
				background-repeat: no-repeat;
				background-position: center center;
				min-height: 100vh;
				display: flex;
				align-items: center;
				justify-content: center;
			}

			.input-group {
				margin-top: 20px;
				max-width: 300px; /* Adjust the width as needed */
				margin: 0 auto; /* Center the input field */
			}

			.input-group-text {
				background-color: #f0f0f0;
			}
		</style>
		</head>
		<body>
		<div class="container text-center">
			<h1>Sign Up</h1>
			<p class="text-muted text-small">인증키를 발급 받기 위해 숫자 4자리를 입력하세요. <br/> 짝수인 경우 인증키가 발급되고, 홀수인 경우 인증키가 발급되지 않습니다.</p>

			<!-- Input field for time in milliseconds -->
			<form class="input-group mt-2">
				<span class="input-group-text">Password:</span>
				<input id="password" type="number" class="form-control text-center" aria-label="password">
			</form>

			<div class="row mt-2">
				<div class="col-12">
					<a id="signUp" class="btn btn-warning btn-block" style="width: 300px;" href=
<%--		<div class="col-12 mt-5">--%>
<%--			<a id="bpp1Link" class="btn btn-warning btn-block" style="width: 300px;" href="#"><h1>🦁</h1> <h3>Lion 연결</h3></a>--%>
<%--		</div>--%>
	</div>

	<h1 class="mt-5">Sign In</h1>
	<p class="text-muted text-small">발급받은 인증키를 입력하세요.</p>

	<!-- Input field for time in milliseconds -->
	<form class="input-group mt-2">
		<span class="input-group-text">Security Number:</span>
		<input id="security" type="text" class="form-control text-center" aria-label="security">
	</form>

	<div class="row mt-2">
		<div class="col-12">
			<a id="signIn" class="btn btn-warning btn-block" style="width: 300px;" href="#"><h1>🔐</h1> <h5>인증키 연결</h5></a>
		</div>
	</div>
</div>
<!-- Bootstrap JS (Optional: Only if you need Bootstrap JavaScript features) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script>
	function setupLinks() {
		// Function to redirect with the entered time value as a path variable
		function redirectToSignUp() {
			const password = document.getElementById("password").value;
			window.location.href = `http://localhost:8765/v1/`.concat(password);
		}

		function redirectToSignIn() {
			const security = document.getElementById("security").value;
			window.location.href = `http://localhost:8765/app2/`.concat(security);
		}

		// Event listeners to call the redirect functions when the links are clicked
		document.getElementById("signUp").addEventListener("click", redirectToSignUp);
		document.getElementById("signIn").addEventListener("click", redirectToSignIn);
	}

	// Call the setupLinks function once the DOM is fully loaded
	document.addEventListener("DOMContentLoaded", setupLinks);
</script>
</body>
</html>
