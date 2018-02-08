<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"/>

<html>

<head lang="it">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script defer src="fontawesome-free-5.0.6/svg-with-js/js/fontawesome-all.js"></script>
<link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="fontawesome-free-5.0.6/web-fonts-with-css/fontawesome-all.css">
<link rel="stylesheet" href="bootstrap-social-gh-pages/bootstrap-social.css">
<link rel="stylesheet" href="css/signUp.css">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<title>Iscriviti | SoRecipes</title>
</head>

	<script>
	
		function validateUsername() {
			var username = $('#username').val()
			if (username.length > 0 && username.length < 3) {
				$('#warning-username').html("Nome utente troppo corto");
			} else {
				$('#warning-username').html("");
			}
		}
		
	</script>

<body>

	<div class="col-md-4 col-md-offset-4">
	    <h2><span id="subscripe-title">Iscriviti</span> al sito</h2>

	    <hr class="colorgraph">

		<div class=".col-xl-12">
			<a href="" title="Facebook" class="btn btn-block btn-social btn-lg btn-facebook"> 
				<i class="fab fa-facebook"></i>Iscriviti tramite <span id=span-facebook>Facebook</span>
			</a>
		</div>

		<p><span id="or-subtititle">oppure</span></p>
		
		<form action="CreateAccount" method="POST" id="form-sign-up">
			<div class="form-group">
				<label for="username"></label> <input name="username" id="username" type="text" onKeyUp='validateUsername()' class="form-control" placeholder="Username" required/>
			</div>
			<div id='warning-username'></div>
			<div class="form-group">
				<label for="email"></label> <input name="email" id="email" type="email" class="form-control" placeholder="Email" required/>
			</div>
			<div class="form-group">
				<label for="password"></label> <input name="password1" id="password1" type="password" class="form-control" placeholder="Password" required/>
			</div>
			<div class="form-group">
				<label for="password"></label> <input name="password2" id="password2" type="password" class="form-control" placeholder="Ripeti password" required/>
			</div>
			<div class="form-group">
				<input name="create" type="submit" id='submit' value="Iscriviti" class="btn btn-success"/>
			</div>
		</form>
	</div>

</body>

<script src="bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
<script src="jquery-3.3.1/jquery-3.3.1.min.js"></script>

</html>