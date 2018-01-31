<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navbar.jsp" />
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	

			<div class="col-xs-9" id="right">
        		<div id="profile"></div>
        		 
        		 <section class="recipe">
        		
        		 	
        		 	<c:forEach var="recipe" items="${myrecipes}">
        		 	<ul class="recipe-showcase">
        		 		<li>
        		 		<li>
        		 		<ul class="options">
        		 		<li><a href="EditRecipe?idRecipe=${recipe.id}" id="edit">Edit</a></li>
        		 		<li><a href="DeleteRecipe?idRecipe=${recipe.id}" id="delete">delete</a></li>
        		 		</ul>
        		 		<figure class="recipe-photo">
        		 		<a href="GetRecipe?idRecipe=${recipe.id}"><img src="image/image/${recipe.imageName}" width="214" height="138"></a>
        		 		<a href="GetRecipe?idRecipe=${recipe.id}" id="title" >${recipe.title}</a>
        		 		<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.category}</a>  
        		 		<a id="star">****</a> 
        		 		</figure>
        		 		
        		 		</li>
        		 		
        		 	</ul>
        		 	</c:forEach>
        		
        		 </section>	
        		<!-- <a href="GetRecipe" >${recipe.id}</a>
        		 		<a href="GetRecipes?id=${recipe.id}">  </a> -->
		
	</div>

	
</body>
</html>