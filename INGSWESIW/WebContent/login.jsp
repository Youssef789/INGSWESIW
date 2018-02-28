<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="pages/nav.jsp"/>

<html>

<head lang="it">
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1, width=device-width, height=device-height">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet"><link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<title>Login | SoRecipes</title>
</head>

<body>	

<c:if test="${!empty username}">
		<c:redirect url="AllRecipes" />
</c:if>
<form style="display:none" action="LoginByFB" method="post">
	<input type="text" name="email" id="email">
	<input type="text" name="name" id="name">
	<input type="text" name="passwordfb" id="passwordfb">
	
	<input type="submit" id="submitLoginFB">
</form>

	<div class="col-md-4 col-md-offset-4" >
	    <h2><span>Accedi</span> al sito</h2> 
	    <hr class="colorgraph">
	    <div class="col-xl-12" style="">
			    <fb:login-button id="fb-button" scope="public_profile,email,user_birthday" onlogin="checkLoginState();"><h3>Entra con Facebook</h3></fb:login-button>	
		</div>
		<form method="post" action="javascript:checkLogin()">
			<div class="form-group">
				<label for="username"></label> <input name="username" id="username" type="text" class="form-control" placeholder="Username" required/>
			</div>
			<div class="form-group">
				<label for="password"></label> <input name="password" id="password" type="password" class="form-control" placeholder="password" required/>
			</div>
			<div id="warning"></div>
			<div class="form-group">
				<input name="create" type="submit" id='submit' value="Login" class="btn btn-success"/>
			</div>
		</form>
	</div>
	
</body>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="js/login.js"></script>

</html>