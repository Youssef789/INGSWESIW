<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Social Cook</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styleingsw.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" id=nav>
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="AllRecipes">SocialCook</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar">

			<ul class="nav navbar-nav navbar-right">
				<li><a id="signup" href="account.jsp">Sign Up</a></li>
				<li><a id="signin" href="login.jsp">Login</a></li>
				<li><a id="aboutus" href="">About Us</a></li>
				<fb:login-button id="fb-btn"
					scope="public_profile,email,user_birthday"
					onlogin="checkLoginState();">
				</fb:login-button>
			</ul>
		</div>

	</div>
	</nav>
	<header>
	<div class="welcome">
		<h1>WELCOME TO SOCIAL COOK</h1>

		<div class="button">
			<a href="account.jsp" class="btn btn-half">Sign Up</a> <a
				href="login.jsp" class="btn btn-full">Login</a>
		</div>
	</div>

	</header>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>