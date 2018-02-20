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

window.fbAsyncInit = function() {
    FB.init({
      appId      : '157070194928528',
      cookie     : true,
      xfbml      : true,
      version    : 'v2.11'
    });
      

      
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));


function statusChangeCallback(response){
	if(response.status === 'connected'){
    FB.api('me/?fields=name,email,birthday,picture.width(150).height(150)',function(response){
        if(response&&!response.error){
        	  $("#name").val(response.name);
        	  $("#email").val(response.email);
        	  $("#submitLoginFB").trigger("click");
        }
    });
}else
		  console.log('not logged');
	
}

function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
}