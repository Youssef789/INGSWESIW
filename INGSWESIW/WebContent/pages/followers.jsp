<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<c:forEach var="follow" items="${Followers}">
	<div class="media">
	    <div class="media-left">
	      <img src="image/unknown-user.png" class="media-object" style="width:60px">
	    </div>
	    <div class="media-body">
	      <h4 class="media-heading"><a href="UserProfile?idUser=${follow.username}">${follow.username}</a> </h4>
	      <button  style="float: right;" type="button" class="btn btn-success">Follow</button>
	    </div>
	</div>
	</c:forEach>
	
			 <script src="js/jquery-3.2.1.min.js"></script>
	
</body>
</html>