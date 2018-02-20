function getfollow() {
		var idUser= $("#userid").text();
		$.ajax({
			type: "GET",		
			url: "Follow",			
			data: {idUser:idUser},
			success: function(response){
				if (response == "true"){
					$("#warning-follow").replaceWith("<button id=\"add\" type=\"button\" onclick=\"javascript:addfollow()\" class=\"btn btn-primary btn-sm\" >follow "
							+"</button>");
				}
				else{
					$("#warning-follow").replaceWith("<button id=\"remove\" type=\"button\" onclick=\"javascript:removefollow()\" class=\"btn btn-primary btn-sm\" >unfollow "
							+"</button>");
				}
			}	
		});
	}
	
	
	function addfollow(){
		var idUser= $("#userid").text();
		var tipo="add";
		$.ajax({
			type: "POST",
			url: "Follow",
			datatype: "json",
			data: JSON.stringify({"idUser" : idUser, "tipo" : tipo}),
			success: function(data){
				$("#add").replaceWith("<button id=\"remove\"  type=\"button\" onclick=\"javascript:removefollow()\" class=\"btn btn-primary btn-sm\" >unfollow"
						+"</button>");
			}
		});
	}
	
	function removefollow(){
		 if (confirm("Are you sure unfollow?") == true) {
		  var idUser= $("#userid").text();
		  var tipo="remove";
		$.ajax({
			type: "POST",
			url: "Follow",
			datatype: "json",
			data: JSON.stringify({"idUser" : idUser, "tipo" : tipo}),
			success: function(data){
				$("#remove").replaceWith("<button id=\"add\"  type=\"button\" onclick=\"javascript:addfollow("+idUser+")\" class=\"btn btn-primary btn-sm\" >follow"
						+"</button>");
			}
		});
		}
	}