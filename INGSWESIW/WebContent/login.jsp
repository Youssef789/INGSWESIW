<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"/>

<html>

<head lang="it">
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1, width=device-width, height=device-height">
<script defer src="fontawesome-free-5.0.6/svg-with-js/js/fontawesome-all.js"></script>
<link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<title>Login | SoRecipes</title>
</head>

<body>

	<div class="col-md-4 col-md-offset-4">
	    <h2><span>Accedi</span> al sito</h2> 
	    <hr class="colorgraph">
		<form action="CreateAccount" method="POST" id="form-sign-up">
			<div class="form-group">
				<label for="username"></label> <input name="username" id="username" type="text" class="form-control" placeholder="Username" required/>
			</div>
			<div class="form-group">
				<label for="email"></label> <input name="email" id="email" type="email" class="form-control" placeholder="Email" required/>
			</div>
			<div class="form-group">
				<input name="create" type="submit" id='submit' value="Login" class="btn btn-success"/>
			</div>
		</form>
	</div>
	
</body>

<script src="bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
<script src="jquery-3.3.1/jquery-3.3.1.min.js"></script>

</html>