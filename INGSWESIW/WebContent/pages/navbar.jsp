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

				<a class="navbar-brand" href="AllRecipes">
				<img alt="Dispute Bills" src="image/logo.png" style="width:130px;">
				</a>
			
				<form class="navbar-form navbar-left" action="Search">
					<div class="input-group">
	        			<input type="text" class="form-control" placeholder="Search" name="search">
	        				<div class="input-group-btn">
	          					<button class="btn btn-default" type="submit"> <i id="iconsearch" class="glyphicon glyphicon-search"></i></button>
	        				</div>
	      			</div>
				</form>
				 
			</div>
			<div class="collapse navbar-collapse" id="navbar">

				<ul class="nav navbar-nav navbar-right">
				<c:if test="${!empty username}">
				<li><a id="home" href="AllRecipes">Home</a></li>
					<li><a id="yourprofile" href="MyRecipes">Profile</a></li>
					<li class="dropdown"><a id="user" class="dropdown-toggle"
						data-toggle="dropdown" href="">welcome : ${username}<span
							class="caret"></span></a>
						<ul class="dropdown-menu ">
							<li><a href="recipe.jsp">Crea ricetta</a></li>
							<li><a href="logout">Logout</a></li>
						</ul></li>
				</c:if>
				<c:if test="${empty username}">
				 <li><a id="signup" href="account.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			     <li><a id="signin" href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>				
				</c:if>					
				</ul>
			</div>

		</div>
	</nav>
			
	<div class="container ">
			<div class="sidenav">
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
						<li><a href="ricettevideos.jsp">Videos</a></li>
					</ul>

			</div>
	</div>

</body>
</html>