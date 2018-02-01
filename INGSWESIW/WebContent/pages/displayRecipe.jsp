<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navbar.jsp" />
<html>
<head lang="it">
<title>${recipe.title}</title>
<meta charset="utf-8">
	<style>
	#btnfavorite{
	float: right;
	margin-top: 20px;
	}
	</style>
      <link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="/INGSWESIW/fonts/font-awesome.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
      <link rel="stylesheet" href="/INGSWESIW/css/displayRecipe.css">

<body>
			<div class="col-xs-9" id="right">
				<div class="col-md-9">
				<form action="Vote?idRecipe=${recipe.id}" method="post">
						<div class="star-rating">
							<h3 id="voti">${votoComplessivo}</h3>
							<input type="radio" name="rating" id="star-5" value="1"/>
							<label for="star-5" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-4" value="2"/>
							<label for="star-4" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-3" value="3"/>
							<label for="star-3" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-2" value="4"/>
							<label for="star-2" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-1" value="5"/>
							<label for="star-1" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
						</div>
					</form>
					<form action="AddFavourite?idRecipe=${recipe.id}" method="post">
						<div class="button">
						<button id="btnfavorite" type="submit" class="btn btn-warning">Favourite <span id="heart" class="glyphicon glyphicon-heart"></span></button>
						</div>
					</form>
					<h3 id="category">${recipe.category}</h3>
					<h1 id="title">${recipe.title}</h1>
					<!--image--->
					<figure id="image">
						<img src="image/image/${recipe.imageName}">
					</figure>
					<br>

					<div>
						<ul id="information">
							<li class="difficolta">Difficoltà: <strong>${recipe.difficulty}</strong>
							</li>

							<li class="preptime">Timpo Di Preparazione: <strong>${recipe.preparationTime}</strong>
							</li>
						</ul>
					</div>

					<div id="ingredient">
						<h2>
							<span>Ingredienti</span>
						</h2>
						<p>${recipe.ingredient}</p>

					</div>

					<div id="description">
						<h2>
							<span>descrizione</span>
						</h2>
						<p>${recipe.description}</p>
					</div>

					<div>
						<h2 id="preparation">
							<span>Preparazione</span>
						</h2>
						<h3 id="how">Come preparare la ricetta</h3>
						<br>
						<p>${recipe.preparation}</p>
					</div>
					</div>
		<c:forEach var="comment" items="${comments}">
			<div class="media">
				<div class="media-left">
					<img src="image/unknown-user.png" class="media-object" style="width: 60px">
				</div>
				<div class="media-body">
					<h4 class="media-heading"></h4>
					 <h4 class="media-heading">${username}<small><i>Posted on ${comment.dataPubblicazione}</i></small></h4>
					<p>${comment.contenuto}</p>
				</div>
			</div>
		</c:forEach>
		<div>
			
		</div>
		<form action="Comment?idRecipe=${recipe.id}" method="post">
				<div class="form-group col-md-9">
					<textarea name="comment" class="form-control" rows="5" id="comment" placeholder="scrivi il tuo commento "></textarea>
					<button id="commbtn" type="submit" class="btn btn-primary">comment</button>
				</div>
			</form>	
			
			
			</div>
	
	
    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>    
</head>
</html>