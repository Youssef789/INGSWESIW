<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<jsp:include page="navbar.jsp" />
<head>
<meta charset="utf-8">
	 	<link rel="stylesheet" href="https://bootswatch.com/3/cosmo/bootstrap.min.css">
		<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="INGSWESIW/../css/recipeCommon.css">

<title>Antipasti</title>
</head>
<body>

	


			<div class="col-xs-9" id="right">
				<section class="recipe">


					<c:forEach var="recipe" items="${recipes}">
						<ul class="recipe-showcase">
							<li>
								<figure class="recipe-photo">
									<a href="GetRecipe?idRecipe=${recipe.id}"><img
										src="image/image/${recipe.imageName}" width="214"
										height="138"></a>

									<a href="GetRecipe?idRecipe=${recipe.id}" id="title">${recipe.title}</a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.category}</a>
									<a href="" id="star">****</a>
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