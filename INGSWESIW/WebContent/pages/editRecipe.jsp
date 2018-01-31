<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navbar.jsp" />
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="INGSWESIW/../css/recipeCommon.css">

<title>Edit your recipe</title>
</head>
<body>
	<div class="col-xs-9" id="right">
		<div class="col-md-9">
			<form action="EditRecipe" method="get" enctype='multipart/form-data'>
				<div class="form-group">
					<label for="title">Titolo:</label><input name="title" type="text"
						value="${recipe.title}" class="form-control" />
				</div>
				<div class="form-group">
					<label for="photo">sceglie la foto principale:</label><input
						type="file" name="photo" value="${recipe.imagePath}" id="file">
				</div>
				<div class="form-group">
					<label for="category">Categoria:</label> <select name="category"
						class="form-control">
						<optgroup>
							<option value="${recipe.category}">${recipe.category}</option>
							<option value="antipasto">Antipasti</option>
							<option value="primo">Primi Piatti</option>
							<option value="secondo">Secondi Piatti</option>
							<option value="contorno">Contorni</option>
							<option value="lievitato">Lievitati</option>
							<option value="piattoUnico">Piatti unici</option>
							<option value="dolce">Dolce</option>
						</optgroup>
					</select>

				</div>
				<div class="form-group">
					<label for="preparationTime">Tempo Di Preparazione:</label><input
						value="${recipe.preparationTime}" name="preparationTime"
						type="text" class="form-control" />
				</div>

				<label for="difficulty">Difficoltà: ${recipe.difficulty}</label>
				<div class="radio">
					<label><input type="radio" name="difficulty" value="facile">Facile</label>
					<label><input type="radio" name="difficulty" value="medio">Medio</label>
					<label><input type="radio" name="difficulty"
						value="difficile">Difficile</label>
				</div>

				<div class="form-group">
					<br> <label for="ingredient">Ingredienti:</label>
					<textarea name="ingredient" class="form-control" rows="5"
						id="ingredient">${recipe.ingredient}</textarea>
					<br> <label for="description">Discrezione:</label>
					<textarea name="description" class="form-control" rows="10"
						id="description">${recipe.description}</textarea>
					<br> <label for="preparation">Preparazione:</label>
					<textarea name="preparation" class="form-control" rows="10"
						id="preparazione">${recipe.preparation}</textarea>
				</div>
				<div class="form-group">
					<input name="edit" type="submit" value="Edit"
						class="btn btn-success" />
				</div>


			</form>
		</div>
	</div>
	<script src="INGSWESIW/../js/jquery-3.2.1.min.js"></script>
	<script src="INGSWESIW/../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>