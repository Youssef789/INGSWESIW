$.ajax({
			type : "POST",
			url : "Login",
			data : {
				username : username,
				password : password
			},
			success : function(username) {
				if(username!=null)
				{
					$("#username").text(" " +username)
				}else
					{
					swal ( "Oops" ,  "username or password is incorrect !" ,  "error" )
					//animazioneErrore();
					$("input[name='username']").val('');
					$("input[name='password']").val('');
					
					}
				
			}
		})