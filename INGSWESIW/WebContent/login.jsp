<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="https://bootswatch.com/3/darkly/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
<title>Login</title>
</head>
<body>
	<div class="container"> 
		<div class="row">
			<div class="wrap-login col-md-4 col-md-offset-4">
			<h2>Login</h2>
				<form method="post" action="Login">
				  <div class="form-group">
				    <label for="email">Email address:</label>
				     <input name="email" type="email" class="form-control" >
				  </div>
				  <div class="form-group">
				    <label for="pwd">Password:</label>
				    <input name="password"  type="password" class="form-control">
				  </div>
				  <div class="checkbox">
				    <label><input type="checkbox"> Remember me</label>
				  </div>
                                    
                <div class="Forgot">
                    <p>Forgot password ?</p>
                </div>
				  <button class="btn" type="submit" class="btn btn">Login</button>
				</form>
		</div>
		</div>
	</div>
		
</body>
</html>