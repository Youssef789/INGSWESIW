<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head lang="it">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, height=device-height">
<link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navbar.css">
</head>

<body>

	<nav id="navbar-principal-1" class="navbar navbar-toggleable-md navbar-light bg-faded">

		<a class="navbar-brand">
			 <img class="img-responsive" id="so-recipes-inscription" src="assets/logo/logo-4.png" alt="SoRecipes"> 
		</a>
	
		<div class="navbar-search-div">
			<form id="navbar-search-form" action="SearchRecipesByTitle" method="GET">
				<input id="navbar-search-input" value="" type="text" placeholder="Cerca una ricetta per titolo" >
			</form>
		</div>
	
		<table>
			<tbody>
				<tr>				
					<td class="navbar-option" onclick="home.jsp;"><a href="home.jsp">Home</a></td>
					<td class="navbar-option" onclick="login.jsp;"><a href="login.jsp">Login</a></td>
					<td class="navbar-option" onclick="signUp.jsp;"><a href="signUp.jsp">Iscriviti</a></td>
				</tr>
			</tbody>
		</table>
	
	</nav>

	<!-- Categories -->

	<nav id="navbar-principal-2" class="navbar navbar-toggleable-md navbar-light bg-faded">
		<table>
			<tbody>
				<tr>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=ANTIPASTI">Antipasti</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=PRIMI_PIATTI">Primi piatti</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=SECONDI_PIATTI">Secondi piatti</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=CONTORNI">Contorni</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=DOLCI">Dolci</a></td>					
					<td class="navbar-option"><a href="GetRecipeByCategory?category=LIEVITATI">Lievitati</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=SALSE_E_SUGHI">Salse e sughi</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=MARMELLATE_E_CONSERVE">Marmellate e conserve</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=BEVANDE">Bevande</a></td>
					<td class="navbar-option"><a href="GetRecipeByCategory?category=ALTRO">Altro</a></td>
				</tr>
			</tbody>
		</table>
	</nav>

</body>

<script src="bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>

</html>