<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="pages/navbar.jsp" />

<html>
<head lang="it">
<meta charset="utf-8">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/recipeCommon.css">
<title>Home | SoRecipes</title>
</head>

<style>

.options {
	float: right;
	position: relative;
	padding-right: 30px;
	margin-top: 50px;
}

.test:after {
	content: '\2807';
	font-size: 20px;
	margin-top: 20px;
	float: right;
}

</style>

<script>

	$(document).ready(function() {
		$("#title").click(function() {
			var selected = $("#title").val();
			$ajax({
				type : "GET",
				url : "GetRecipe",
				data : {
					RecipeSelected : selected
				},
				success : function(data) {
					$("#id").html(data);
				}
			});
		});
	});

	function doajax() {
		var selected = $("#title").val();
		$ajax({
			type : "GET",
			url : "GetRecipe",
			data : {
				RecipeSelected : selected
			},
			success : function(data) {
				alert(data.RecipeSelected);
			}
		});

	}
	
</script>

<body>
	<div class="col-md-6" id="right">
		<div id="profile">
			<section class="recipe">
				<c:forEach var="recipe" items="${recipes}">
					<ul class="recipe-showcase">
						<li>
							<figure class="recipe-photo">
								<a><img src="imageNames/${recipe.nameImmaginePrincipale}" width="250" height="150"></a>
								<a href="GetRecipe?idRecipe=${recipe.id}" id="title">${recipe.titolo}</a>
								<a id="category">${recipe.categoria}</a>
								<a id="voti">5.0</a>
								<label class="star-rating" for="voti" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							</figure>
						</li>
					</ul>
				</c:forEach>
			</section>

			<!-- 
        		<ul class="options">
        		 	<li><a href="EditRecipe?idRecipe=${recipe.id}" id="edit">Edit</a></li>
        		 	<li><a href="DeleteRecipe?idRecipe=${recipe.id}" id="delete">delete</a></li>
        		</ul>
        	 -->

		</div>
	</div>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>