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
					$("#user").text(" " +username)
				}else
					{
					animazioneErrore();
					$("input[name='username']").val('');
					$("input[name='password']").val('');
					}
				
			}
		})