function addComment(idRecipe){
	  var comment = $("#comment"+idRecipe).val();
	$.ajax({
		type: "POST",
		url: "Comment",
		datatype: "json",
		data: JSON.stringify({"idRecipe":idRecipe, "comment": comment}),
		success: function(data){	
			var out = JSON.parse(data);
			$("#comments").prepend(
					"<div class=\"media\">"
					+"<div class=\"media-left\">"
					+"<img src=\"image/unknown-user.png\" class=\"media-object\" style=\"width:60px\">"
					+"</div>"
					+"<div class=\"media-body\">"
					+"<h4 class=\"media-heading\">"+out.username+"<small><i> Posted on "+out.dataPubblicazione+"</i></small></h4>"
					+"<p>"+out.containComment+"</p>"
					+"</div>"
					+"</div>");	
			$("#comment"+idRecipe).val("");
		}
	});	 
};

function deleteComment(idComment){
	if (confirm("Sei sicuro di voler eliminare questo commento?") == true) {
		  var idRecipe = $("#idRecipe").text();
		  var remove = "true";
		  $.ajax({
				type: "POST",
				url: "DeleteComment",
				datatype: "json",
				data: JSON.stringify({"idComment": idComment, "remove" : remove}),
				success: function(data){
					 $("#comments"+idComment).remove();
			    	}
				});
	}
		  
};


function editComment(idComment){
	if (confirm("Sei sicuro di voler modificare questo commento?") == true) {
		  $.ajax({
				type: "GET",
				url: "EditComment",
				data: {idComment: idComment},
				success: function(data){
					$("#editcomment").html(data);
			    	}
				});
	}
		  
};





	

	
	function displayvoto(idRecipe) {
		$.ajax({
			type: "GET",
			url:"GetVotes",
			data: {idRecipe:idRecipe},
			success: function(data){
				$("#resultvoto").html(data);
			}
		});
	} 
	

	
	 (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));
	 function myFunction() {
		   var x = document.URL;
		   document.getElementById("page").src='https://www.facebook.com/plugins/share_button.php?href='+x+'&layout=button_count&size=large&mobile_iframe=true&width=83&height=28&appId';
		  }