<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="recipe" class="model.Ricetta" scope="request" />

<jsp:include page="navbar.jsp" />
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="INGSWESIW/../css/recipeCommon.css">

<title>Edit your recipe</title>
</head>
<body>

<c:if test="${empty username}">
		<c:redirect url="login.jsp" />
</c:if>
	<div class="col-xs-9" id="right">
		<div class="col-md-9">
			<form action="EditRecipe?idRecipe=${recipe.id}" method="post" enctype='multipart/form-data'>
				<div class="form-group">
					<label for="title">Titolo:</label>
					<input name="title" type="text" value="${recipe.titolo}" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="photo">sceglie la foto principale:</label>
					<input type="file" name="photo" value="${recipe.nameImmaginePrincipale}" id="file">
					<img id="image" src="imageNames/${recipe.nameImmaginePrincipale}" alt="" />
				</div>
				<div class="form-group">
					<label for="category">Categoria:</label> 
					<select class="form-control" name="category" >
						
						<optgroup>
						
							<c:if test="${recipe.categoria == 'ANTIPASTI'}">
								<option selected value="ANTIPASTI">Antipasti</option>
							</c:if>
							<c:if test="${recipe.categoria != 'ANTIPASTI'}">
								<option value="ANTIPASTI">Antipasti</option>
							</c:if>
							
							<c:if test="${recipe.categoria == 'PRIMI_PIATTI'}">
								<option selected value="PRIMI_PIATTI">Primi piatti</option>
							</c:if>
							<c:if test="${recipe.categoria != 'PRIMI_PIATTI'}">
								<option value="PRIMI_PIATTI">Primi piatti</option>
							</c:if>
							
							<c:if test="${recipe.categoria == 'SECONDI_PIATTI'}">
								<option selected value="SECONDI_PIATTI">Secondi piatti</option>
							</c:if>
							<c:if test="${recipe.categoria != 'SECONDI_PIATTI'}">
								<option value="SECONDI_PIATTI">Secondi piatti</option>
							</c:if>
							
							<c:if test="${recipe.categoria == 'PIATTI_UNICI'}">
								<option selected value="PIATTI_UNICI">Piatti unici</option>
							</c:if>
							<c:if test="${recipe.categoria != 'PIATTI_UNICI'}">
								<option value="PIATTI_UNICI">Piatti unici</option>
							</c:if>
							
							<c:if test="${recipe.categoria == 'CONTORNI'}">
								<option selected value="CONTORNI">Contorni</option>
							</c:if>
							<c:if test="${recipe.categoria != 'CONTORNI'}">
								<option value="CONTORNI">Contorni</option>
							</c:if>
							
							<c:if test="${recipe.categoria == 'DOLCI'}">
								<option selected value="DOLCI">Dolci</option>
							</c:if>
							<c:if test="${recipe.categoria != 'DOLCI'}">
								<option value="DOLCI">Dolci</option>
							</c:if>

							<c:if test="${recipe.categoria == 'DOLCI'}">
								<option selected value="DOLCI">Dolci</option>
							</c:if>
							<c:if test="${recipe.categoria != 'DOLCI'}">
								<option value="DOLCI">Dolci</option>
							</c:if>

							<c:if test="${recipe.categoria == 'LIEVITATI'}">
								<option selected value="LIEVITATI">Lievitati</option>
							</c:if>
							<c:if test="${recipe.categoria != 'LIEVITATI'}">
								<option value="LIEVITATI">Lievitati</option>
							</c:if>

							<c:if test="${recipe.categoria == 'SALSE_E_SUGHI'}">
								<option selected value="SALSE_E_SUGHI">Salse e sughi</option>
							</c:if>
							<c:if test="${recipe.categoria != 'SALSE_E_SUGHI'}">
								<option value="SALSE_E_SUGHI">Salse e sughi</option>
							</c:if>

							<c:if test="${recipe.categoria == 'MARMELLATE_E_CONSERVE'}">
								<option selected value="MARMELLATE_E_CONSERVE">Marmellate e conserve</option>
							</c:if>
							<c:if test="${recipe.categoria != 'MARMELLATE_E_CONSERVE'}">
								<option value="MARMELLATE_E_CONSERVE">Marmellate e conserve</option>
							</c:if>

							<c:if test="${recipe.categoria == 'BEVANDE'}">
								<option selected value="BEVANDE">Bevande</option>
							</c:if>
							<c:if test="${recipe.categoria != 'BEVANDE'}">
								<option value="BEVANDE">Bevande</option>
							</c:if>

							<c:if test="${recipe.categoria == 'ALTRO'}">
								<option selected value="ALTRO">Altro</option>
							</c:if>
							<c:if test="${recipe.categoria != 'ALTRO'}">
								<option value="ALTRO">Altro</option>
							</c:if>
										
							</optgroup>
						</select>
					

				</div>
				<div class="form-group">
					<label for="preparationTime">Tempo Di Preparazione:</label>
					<input value="${recipe.tempoPreparazione}" name="preparationTime" type="text" class="form-control" />
				</div>

				<label for="difficulty">Difficoltà:</label>
				<div class="radio">
				
					<c:if test="${recipe.difficolta == 'FACILE'}">
						<label><input checked type="radio" name="difficulty" value="FACILE">Facile</label>
					</c:if>
					<c:if test="${recipe.difficolta != 'FACILE'}">
						<label><input type="radio" name="difficulty" value="FACILE">Facile</label>
					</c:if>
					
					<c:if test="${recipe.difficolta == 'MEDIA'}">
						<label><input checked type="radio" name="difficulty" value="MEDIA">Media</label>
					</c:if>
					<c:if test="${recipe.difficolta != 'MEDIA'}">
						<label><input type="radio" name="difficulty" value="MEDIA">Media</label>
					</c:if>
					
					<c:if test="${recipe.difficolta == 'DIFFICILE'}">
						<label><input checked type="radio" name="difficulty" value="DIFFICILE">Difficile</label>
					</c:if>
					<c:if test="${recipe.difficolta != 'DIFFICILE'}">
						<label><input type="radio" name="difficulty" value="DIFFICILE">Difficile</label>
					</c:if>
					
				</div>

				<div class="form-group">
					<br> <label for="ingredient">Ingredienti:</label>
					<textarea name="ingredient" class="form-control" rows="5"
						id="ingredient">${recipe.ingredienti}</textarea>
					<br> <label for="description">Descrizione:</label>
					<textarea name="description" class="form-control" rows="10"
						id="description">${recipe.descrizione}</textarea>
					<br> <label for="preparation">Preparazione:</label>
					<textarea name="preparation" class="form-control" rows="10"
						id="preparazione">${recipe.preparazione}</textarea>
				</div>
				<div class="form-group">
					<input name="edit" type="submit" value="Edit" class="btn btn-success" />
				</div>
			</form>
		</div>
	</div>
	<script src="INGSWESIW/../js/jquery-3.2.1.min.js"></script>
	<script src="INGSWESIW/../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="INGSWESIW/../js/preview.js"></script>
	
</body>
</html>