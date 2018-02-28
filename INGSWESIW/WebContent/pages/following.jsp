<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="following" class="model.Utente" scope="request" />

<html>
<head>
<meta charset="utf-8">
</head>
<body>

<c:forEach var="following" items="${Followings}">
	<div class="media">
	    <div class="media-left">
	      <img src="image/unknown-user.png" class="media-object" style="width:60px">
	    </div>
	    <div class="media-body">
	      <h4 class="media-heading"><a href="UserProfile?idUser=${following.username}">${following.username}</a> </h4>
	      <button  style="float: right;" type="button" class="btn btn-success">Unfollow</button>
	    </div>
	</div>
</c:forEach>

</body>
</html>