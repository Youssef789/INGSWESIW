<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" id=nav>
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="AllRecipes">SocialCook</a>
			
				<form class="navbar-form navbar-left" action="Search">
					<div class="form-group" class="col-xs-3">
						<input id="search" name="search" type="text" class="form-control"
							placeholder="Search">
					</div>
					<button id="btnsearch" type="submit" class="btn btn-primary ">Search</button>
				</form>
				 
			</div>
			<div class="collapse navbar-collapse" id="navbar">
				<!-- 
				<ul class="nav navbar-nav navbar-right">
					<li><a id="logout" href="#" onclick="logout()">Logout</a></li>
					<fb:login-button id="fb-btn"
						scope="public_profile,email,user_birthday"
						onlogin="checkLoginState();">
					</fb:login-button>
				</ul>
 -->

				<ul class="nav navbar-nav navbar-right">
					<li><a id="home" href="AllRecipes">Home</a></li>
					<li><a id="yourprofile" href="MyProfile">Profile</a></li>
					<li class="dropdown"><a id="user" class="dropdown-toggle"
						data-toggle="dropdown" href="#">welcome : ${username}<span
							class="caret"></span></a>
						<ul class="dropdown-menu ">
							<li><a href="recipe.jsp">Create Recipe</a></li>
							<li><a href="logout">Logout</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
	</nav>
			
	<div class="container">
		<div class="row">
			<div class="col-xs-3">
				<nav id=mainNav>
				
					<ul class="nav nav-pills nav-stacked">
						<li><a href="GetRecipeByCategory?category=ANTIPASTI">Antipasti</a></li>
						<li><a href="GetRecipeByCategory?category=PRIMI_PIATTI">Primi piatti</a></li>
						<li><a href="GetRecipeByCategory?category=SECONDI_PIATTI">Secondi piatti</a></li>
						<li><a href="GetRecipeByCategory?category=CONTORNI">Contorni</a></li>
						<li><a href="GetRecipeByCategory?category=DOLCI">Dolci</a></li>					
						<li><a href="GetRecipeByCategory?category=LIEVITATI">Lievitati</a></li>
						<li><a href="GetRecipeByCategory?category=SALSE_E_SUGHI">Salse e sughi</a></li>
						<li><a href="GetRecipeByCategory?category=MARMELLATE_E_CONSERVE">Marmellate e conserve</a></li>
						<li><a href="GetRecipeByCategory?category=BEVANDE">Bevande</a></li>
						<li><a href="GetRecipeByCategory?category=ALTRO">Altro</a></li>

					</ul>

				</nav>

			</div>
		</div>
	</div>

</body>
</html>