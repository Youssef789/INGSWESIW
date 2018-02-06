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
	if (confirm("Are you sure you want to delete this comment?") == true) {
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
	if (confirm("Are you sure you want to edit this comment?") == true) {
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





//function deleteRecipe(idRecipe){
//	if (confirm("Are you sure you want to delete this Recipe?") == true) {
//		$ajax({
//			type:"POST",
//			url:"DeleteRecipe",
//			datatype: "json",
//			data: JSON.stringify({"idRecipe" :idRecipe}),
//			success:function(data){
//				$("#display"+idRecipe).remove();
//			}
//		});
//	}
//};



function removeFavourite(idRecipe){
	
};