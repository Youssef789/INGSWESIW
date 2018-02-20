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
	<div class="col-md-4 col-md-offset-4" >
	    <h2><span>Accedi</span> al sito</h2> 
	    <hr class="colorgraph">
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
<script type="text/javascript">
function checkLogin() {
	 var username=$("#username").val();
	 var password=$("#password").val();
	 $.ajax({
			type : "POST",
			url : "Login",
			data : {
				username : username,
				password : password
			},
			success : function(response) {
				if (response == "true") {
					//$('#warning').html("");
					  window.location.replace("AllRecipes");
				} else {
					$('#warning').html("Username o Password sbagliato");
				}
				
			}
		});

}


</script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>

</html>