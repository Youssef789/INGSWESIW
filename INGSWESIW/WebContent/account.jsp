<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="pages/nav.jsp"/>

<html>

<head lang="it">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap-social-gh-pages/bootstrap-social.css">
<link rel="stylesheet" href="css/account.css">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<title>Iscriviti | SoRecipes</title>
</head>

<body>
	<c:if test="${!empty username}">
		<c:redirect url="AllRecipes"/>
	</c:if>

	<div class="col-md-4 col-md-offset-4">
	    <h2><span id="subscripe-title">Iscriviti</span> al sito</h2>

	    <hr class="colorgraph">
		
		<form action="CreateAccount" method="POST" id="form-sign-up" onSubmit="return validate();">
			<div class="form-group">
				<label for="username"></label> <input name="username" id="username" type="text" onKeyUp='validateUsername()' class="form-control" placeholder="Username" required autocomplete="off"/>
			</div>
			<div id='warning-username'></div>
			<div class="form-group">
				<label for="email"></label> <input name="email" id="email" type="email" onKeyUp='validateEmail()' class="form-control"  placeholder="Email" required autocomplete="off"/>
			</div>
			<div id='warning-email'></div>
			<div class="form-group">
				<label for="password"></label> <input name="password1" id="password1" type="password" onKeyUp='regexPassword()' class="form-control" placeholder="Password"/>
			</div>
			<div id='warning-regex-password'></div>
			<div class="form-group">
				<label for="password"></label> <input name="password2" id="password2" type="password" onKeyUp='checkEqualsPassword()' class="form-control" placeholder="Ripeti password" required/>
			</div>
			<div id='warning-not-equals-password'></div>
			<div class="form-group">
				<input name="create" type="submit" id='submit' value="Iscriviti" class="btn btn-success"/>
			</div>
		</form>
	</div>

</body>

<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/account.js"></script>


</html>