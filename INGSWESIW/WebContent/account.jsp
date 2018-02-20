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

	<script>
	
		function validateUsername() {
			var username = $('#username').val();
			var result = false;
			if (username.length > 0 && username.length < 4) {
				$('#warning-username').html("Username troppo corto");
			} else if (username.length >= 4) {
				/* ajax call (if work...) */
				$.ajax({
					type: "GET",
					url: "AvailableUsername",
					async: false,
					data:{username:username},
					success : function(response) {
						if (response == "true") {
							$('#warning-username').html("");
							result = true;
						} else {
							$('#warning-username').html("Username non disponibile");
						}
					}
                });
			} else {
				$('#warning-username').html("");
			}
			return result;
		}
		
		function validateEmail() {
			var email = $('#email').val();
			var result=false;
			$.ajax({
				type: "GET",
				url: "AvailableEmail",
				async: false,
				data:{email:email},
				success : function(response) {
					if (response == "true") {
						$('#warning-email').html("");
						result= true;
					} else {
						$('#warning-email').html("L'email è già associata ad un altro utente");
					}
				}
            });
			return result;
		}
		
		function regexPassword() {
			var password1 = $('#password1').val();
			var regex = new RegExp("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.{8,})"); /* regex */
			if ( (password1.length == 0) || (regex.test(password1)) ) {
		    	$("#warning-regex-password").html(""); /* empty string or true regex */
		    	return true;
		    } else {
		    	$("#warning-regex-password").html("La password deve essere lunga almeno 8 caratteri, contenere almeno una lettera maiuscola, una lettera minuscola e un numero"); /* false regex */
		    	return false;
		    }
		}
		
		function checkEqualsPassword() {
			var password1 = $('#password1').val();
			var password2 = $('#password2').val();
		    if ( (password1 == password2) || (password2.length == 0) ) {
		    	$('#warning-not-equals-password').html("");
		    	return true;
		    } else {
		    	$('#warning-not-equals-password').html("Le password non coincidono");
		    	return false;
		    }
		}  
		
		function validate() {
			var result_validateUsername = validateUsername();
			var result_validateEmail = validateEmail();
			var result_regexPassword = regexPassword();
			var result_checkEqualsPassword = checkEqualsPassword();
			var result = result_validateUsername && result_validateEmail && result_regexPassword && result_checkEqualsPassword;
 			//alert(result_validateUsername + " " + result_validateEmail + " " + result_regexPassword + " " + result_checkEqualsPassword + " " + result);
			return result; 
		}
		
	</script>

	<c:if test="${!empty username}">
		<c:redirect url="AllRecipes"/>
	</c:if>

	<div class="col-md-4 col-md-offset-4">
	    <h2><span id="subscripe-title">Iscriviti</span> al sito</h2>

	    <hr class="colorgraph">

		<div class=".col-xl-12">
			<a href="" title="Facebook" class="btn btn-block btn-social btn-lg btn-facebook"> 
				<i class="fab fa-facebook"></i><span id="facebook-subtitle">Accedi con Facebook</span>
			</a>
		</div>

		<p><span id="or-subtititle">oppure</span></p>
		
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

</html>