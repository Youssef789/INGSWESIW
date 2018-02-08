<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navbar.jsp" />
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="assets/favicon/favicon.ico"/>
<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="INGSWESIW/../css/recipeCommon.css">

<title>Modifica la ricetta | SoRecipes</title>
</head>
<body>
	<div class="col-xs-9" id="right">
		<div class="col-md-9">
			<h2 style="text-align: center">
				<strong>Modifica la tua ricetta</strong>
			</h2>
			<form action="EditRecipe?idRecipe=${recipe.id}" method="post" enctype='multipart/form-data'>
				<div class="form-group">
					<label for="title">Titolo:</label><input name="title" type="text"
						value="${recipe.titolo}" class="form-control" required/>
				</div>
				<div class="form-group">
					<label for="photo">Inserisci la foto principale:</label><input
						type="file" name="photo" value="${recipe.nameImmaginePrincipale}" id="file">
				</div>
				<div class="form-group">
					<label for="category">Categoria:</label> <select name="category"
						class="form-control" required>
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
					<label for="preparationTime">Tempo di preparazione:</label>
					<input value="${recipe.tempoPreparazione}" name="preparationTime" type="text" class="form-control" />
				</div>

				<label for="difficulty" >Difficoltà</label>
				<div class="radio">
					<label><input type="radio" name="difficulty" value="FACILE" required>Facile</label>
					<label><input type="radio" name="difficulty" value="MEDIA" required>Medio</label>
					<label><input type="radio" name="difficulty" value="DIFFICILE" required>Difficile</label>
				</div>

				<div class="form-group">
					<br> <label for="ingredient" >Ingredienti:</label>
					<textarea name="ingredient" class="form-control" rows="5"
						id="ingredient" required>${recipe.ingredienti}</textarea>
					<br> <label for="description">Descrizione:</label>
					<textarea name="description" class="form-control" rows="5"
						id="description" required>${recipe.descrizione}</textarea>
					<br> <label for="preparation">Preparazione:</label>
					<textarea name="preparation" class="form-control" rows="10"
						id="preparazione" required>${recipe.preparazione}</textarea>
				</div>
				<div class="form-group">
					<input name="edit" type="submit" value="Applica le modifiche alla ricetta" class="btn btn-success" />
				</div>
			</form>
		</div>
	</div>
	<script src="INGSWESIW/../js/jquery-3.2.1.min.js"></script>
	<script src="INGSWESIW/../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>