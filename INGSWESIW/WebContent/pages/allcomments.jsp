<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="utf-8">

</head>
<body>
 <c:forEach var="comment" items="${comments}">
			<div class="media" id="comment__">
				<div class="media-left">
					<img src="image/unknown-user.png" class="media-object" style="width: 60px">
				</div>
				<div class="media-body">
					 <h4 class="media-heading">${comment.utente.username}<small><i> Posted on ${comment.dataPubblicazione}</i></small></h4>
					 <p>${comment.contenuto}</p>
				</div>
				<c:if test = "${comment.utente.username == utente.username}">
						<a onclick="javascript:deleteComment(${comment.id})"><span class="glyphicon glyphicon-trash" style="float:right"></span></a>
				 		<a onclick="javascript:editComment(${comment.id})"><span class="glyphicon glyphicon-edit" style="float:right"></span></a>	
				 </c:if>
			</div>
		</c:forEach> 
		
		 <script src="js/jquery-3.2.1.min.js"></script>
</body>
</html>