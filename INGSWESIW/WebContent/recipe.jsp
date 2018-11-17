<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="pages/navbar.jsp" />

<html>

<head>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="INGSWESIW/../css/recipeCommon.css">
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Crea ricetta | SoRecipes</title>
</head>

<body>

	<!-- 	<div class="col-md-8 col-md-offset-2" id="recipe" >  -->
	<div class="col-xs-9" id="right">
		<div class="col-md-9">
			<h2 style="text-align: center">
				<strong>Crea la tua ricetta</strong>
			</h2>
			<form action="CreateRecipe" method="post" id="fromrecipe"
				enctype='multipart/form-data'>
				<div class="form-group">
					<label for="title">Titolo:</label><input name="title" type="text"
						placeholder="Titolo" class="form-control" />
				</div>
				<div class="form-group">
					<label for="photo">Scegli la foto principale:</label>
					<input type="file" name="photo" id="file">
					<img id="image" src="#" alt="" />
					
				</div>
				<div class="form-group">
					<label for="category">Categoria:</label> <select name="category"
						class="form-control">
						<optgroup>
							<option value="ANTIPASTI">Antipasti</option>
							<option value="PRIMI_PIATTI">Primi piatti</option>
							<option value="SECONDI_PIATTI">Secondi piatti</option>
							<option value="PIATTI_UNICI">Piatti unici</option>
							<option value="CONTORNI">Contorni</option>
							<option value="DOLCI">Dolci</option>
							<option value="LIEVITATI">Lievitati</option>
							<option value="SALSE_E_SUGHI">Salse e sughi</option>
							<option value="MARMELLATE_E_CONSERVE">Marmellate e conserve</option>
							<option value="BEVANDE">Bevande</option>
							<option value="ALTRO">Altro</option>
						</optgroup>
					</select>

				</div>
				<div class="form-group">
					<label for="preparationTime">Tempo Di Preparazione:</label><input
						name="preparationTime" type="text"
						placeholder="Tempo Di Preparazione" class="form-control" />
				</div>

				<label for="difficulty">Difficoltà:</label>
				<div class="radio">
					<label><input type="radio" name="difficulty" value="FACILE">Facile</label>
					<label><input type="radio" name="difficulty" value="MEDIA">Medio</label>
					<label><input type="radio" name="difficulty" value="DIFFICILE">Difficile</label>
				</div>

				<div class="form-group">
					<br> <label for="ingredient">Ingredienti:</label>
					<textarea name="ingredient" class="form-control" rows="5"
						id="ingredient"></textarea>
					<br> <label for="description">Descrizione:</label>
					<textarea name="description" class="form-control" rows="10"
						id="discrezione"></textarea>
					<br> <label for="preparation">Preparazione:</label>
					<textarea name="preparation" class="form-control" rows="10"
						id="preparazione"></textarea>
				</div>
				<div class="form-group">
					<input name="create" type="submit" value="Crea" class="btn btn-success"/>
					
				</div>
			</form>
		</div>
	</div>
	
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/preview.js"></script>




</body>
</html>