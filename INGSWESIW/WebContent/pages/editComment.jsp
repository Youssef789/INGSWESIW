<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<c:if test="${empty username}">
		<c:redirect url="login.jsp" />
</c:if>
<form action ="javascript:updateComment({${idComment})">
					<div class="form-group">
								<textarea name ="updatecomment{${idComment}"class="form-control" rows="5" id="updatecomment{${idComment}" >${commento}</textarea>
								<button id="commbtn" type="submit" class="btn btn-primary">Save change</button>
					</div>
</form>

    <script src="js/jquery-3.2.1.min.js"></script>
<script>
function updateComment(idComment){
	 var comment = $("#updatecomment"+idComment).val();
		$.ajax({
			type: "POST",
			url: "EditComment",
			datatype: "json",
			data: JSON.stringify({"idComment":idComment, "comment": comment}),
			success: function(data){	
				var out = JSON.parse(data);
				$("#displaycomment").prepend(
						"<div class=\"media\">"
						+"<div class=\"media-left\">"
						+"<img src=\"image/unknown-user.png\" class=\"media-object\" style=\"width:60px\">"
						+"</div>"
						+"<div class=\"media-body\">"
						+"<h4 class=\"media-heading\">"+out.username+"<small><i> Posted on "+out.dataUltimaModifica+"</i></small></h4>"
						+"<p>"+out.containComment+"</p>"
						+"</div>"
						+"</div>");	
				$("#comment"+idRecipe).val("");
			}
		});	 
	
}
</script>
</body>
</html>