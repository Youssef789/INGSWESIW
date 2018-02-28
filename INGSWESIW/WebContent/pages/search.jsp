<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="recipe" class="model.Ricetta" scope="request" />

<jsp:include page="navbar.jsp" />
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/recipeCommon.css">
</head>
<body>
<div class="col-md-6" id="right">
 <section class="recipe">
        		 	<c:forEach var="recipe" items="${result}">
				<ul class="recipe-showcase">
        		 		<li>
        		 		<figure class="recipe-photo">
									<a href="GetRecipe?idRecipe=${recipe.id}"><img src="imageNames/${recipe.nameImmaginePrincipale}" width="214"height="138"></a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="title">${recipe.titolo}</a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.categoria}</a>
        		 					
        		 		</figure>
        		 		</li>
        		 	</ul>
        		 	
        		 	</c:forEach>
        		
        		 </section>	
</div>
<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>