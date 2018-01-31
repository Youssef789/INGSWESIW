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
		            document.getElementById('fb-btn').style.display='none';
		            document.getElementById('signin').style.display='none';
		            document.getElementById('signup').style.display='none';

				}else
					{
					animazioneErrore();
					$("input[name='username']").val('');
					$("input[name='password']").val('');
					document.getElementById('signup').style.display='black';
			        document.getElementById('signin').style.display='black';
			        document.getElementById('fb-btn').style.display='black';
					}
				
			}
		})