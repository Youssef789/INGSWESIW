<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>Login | SoRecipes</title>
<link rel="icon" href="assets/favicon/favicon.ico"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="wrap-login col-md-4 col-md-offset-4">
				<h2>Effettua il login</h2>
				<form method="post" action="Login">
					<div class="form-group">
						<label for="email">Username</label> <input name="username" type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label for="pwd">Password</label> <input name="password" type="password" class="form-control" required>
					</div>
					<div class="checkbox">
						<label><input type="checkbox">Ricordami</label>
					</div>
					<div class="forgot-password-div">
						 <a id="forgot-password-a" href="">Hai dimenticato la password?</a> 
						 <p></p>
					</div>
					<button class="btn" type="submit" class="btn btn">Accedi</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>