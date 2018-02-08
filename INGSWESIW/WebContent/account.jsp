<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/account.css">
<title>Crea il tuo account | SoRecipes</title>
</head>

<body>
<section class="moduleRegistration" class="row">
<div class="col-md-4 col-md-offset-4" id="fm">
	<form action="CreateAccount" method="post">
		<h2>Crea il tuo account</h2>
		<div class="form-group"><label for="username">Username</label> <input name="username" id="username" type="text" class="form-control" required/></div> 
		<div class="form-group"><label for="email">Email</label> <input name="email" id="email" type="email" class="form-control" required/></div> 
		<div class="form-group"><label for="password">Password</label> <input name="password" id="password" type="password" class="form-control" required/> </div> 	
		<div class="form-group"><input name="create" type="submit" id='submit' value="Crea account" class="btn btn-success"/></div>		
	</form>
</div>
</section>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>

</html>

