	
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
		
