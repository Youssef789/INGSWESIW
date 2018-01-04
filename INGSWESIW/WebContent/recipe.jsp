<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="ricetta" class="model.Ricetta" scope="request" />

<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/recipe.css">

<title>Create your recipe</title>
</head>
<body>
	
	<div class="col-md-6 col-md-offset-3" id="recipe" >
		
		<h2 style="text-align: center">
			<strong>crea la tua ricetta</strong>
		</h2>
		<form action="CreateRecipe" method="post">
			<div class="form-group"><label for="title">Titolo:</label><input name="title" type="text" placeholder="Titolo" class="form-control" /> </div> 
			<div class="form-group"><label for="photo">sceglie la foto principale:</label><input type="file" name="photo" id="file"> </div>			
			<div class="form-group"><label for="category">Categoria:</label>
				<select name="category" class="form-control">
				<optgroup>
				<option value="antipasto">Antipasti</option>
				<option value="primo">Primi Piatti</option>
				<option value="secondo">Secondi Piatti</option>
				<option value="contorno">Contorni</option>
				<option value="lievito">Lievitati</option>
				<option value="piatto_unico">Piatti unici</option>
				</optgroup>
				</select>
			
			</div> 
			<div class="form-group"><label for="preparationTime">Tempo Di Preparazione:</label><input name="preparationTime" type="text" placeholder="Tempo Di Preparazione" class="form-control" /> </div> 
			
			<label for="difficulty" >Difficoltà:</label>		
			<div class="radio">
				  <label><input type="radio" name="difficulty" value="facile">Facile</label>
				  <label><input type="radio" name="difficulty" value="medio">Medio</label>
				  <label><input type="radio" name="difficulty" value="difficile">Difficile</label>
			</div>
			
			<div class="form-group">
				<br>
				<label for="ingredient">Ingredienti:</label><textarea name="ingredient" class="form-control" rows="5" id="ingredient"></textarea>
				<br>
				<label for="description">Discrezione:</label><textarea name="description" class="form-control" rows="10" id="discrezione"></textarea>
				<br>
				<label for="preparation">Preparazione:</label><textarea name="preparation" class="form-control" rows="10" id="preparazione"></textarea>			
			</div>
				<div class="form-group"><input name="create" type="submit" value="Create"  class="btn btn-success"/></div>		
	
		</form>
	</div>	

</body>
</html>