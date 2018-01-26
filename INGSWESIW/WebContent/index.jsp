<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="ricetta" class="model.Ricetta" scope="session" />
<jsp:setProperty name="ricetta" property="title" value="fin."/>
<html>
<head>
<meta charset="utf-8">
  <link rel="stylesheet" href="https://bootswatch.com/3/cosmo/bootstrap.min.css">
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/recipeCommon.css">
  <script>
  $(document).ready(function(){
  	$("#title").click(function(){
  		var selected=$("#title").val();
 		 $ajax({
			 type:"GET",
			 url:"GetRecipe",
			 data:{RecipeSelected :selected},
			 success:function(data){
				 $("#id").html(data);
			 }
		  });
		  });
});
  
  function doajax(){	
	  var selected=$("#title").val();
	  $ajax({
		 type:"GET",
		 url:"GetRecipe",
		 data:{RecipeSelected :selected},
		 success:function(data){
			 alert(data.RecipeSelected);
		 }
	  });
	
  }
  </script>
		
<title>SocialCook</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top" id=nav>
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="GetRecipes">SocialCook</a>
				<form class="navbar-form navbar-left" action="/action_page.php">
					<div class="form-group">
						<input id="search" type="text" class="form-control" placeholder="Search">
					</div>
					<button id="btnsearch" type="submit" class="btn btn-primary ">Search</button>
				</form>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
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
					<li><a id="home" href="GetRecipes">Home</a></li>
					<li><a id="yourprofile" href="Profile">Profile</a></li>
				<li class="dropdown"><a id="user" class="dropdown-toggle"data-toggle="dropdown" href="#">welcome : ${username}<span class="caret"></span></a>
					<ul class="dropdown-menu ">
						<li><a href="/web/recipe">Create Recipe</a></li>
						<li><a href="">Edit Recipe</a></li>
						<li><a href="">Logout</a></li>
					</ul>	
				</li>				
				</ul>
			</div>

		</div>
	</nav>

   
	<div class="container">
		<div class="row">
			<div class="col-xs-3">
				<nav id=mainNav>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="GetRecipeAppetizers">Antipasti</a></li>
							<li><a href="GetRecipefirstPiatti">Primi Piatti</a></li>
							<li><a href="GetRecipeSecondPiatti">Secondi Piatti</a></li>
							<li><a href="GetRecipeContorni">Contorni</a></li>
							<li><a href="GetRecipeLievitati">Lievitati</a></li>
							<li><a href="GetRecipeUniqDishes">Piatti unici</a></li>
							<li><a href="GetRecipeDesserts">Dolci</a></li>						
						</ul>
					
				</nav>
				
			</div>
			
			<div class="col-xs-9" id="right">
        		<div id="profile"></div>
        		 
        		 <section class="recipe">
        		
        		 	
        		 	<c:forEach var="recipe" items="${recipes}">
        		 	<ul class="recipe-showcase">
        		 		<li>
        		 		<figure class="recipe-photo">
        		 		<a href="GetRecipe?idRecipe=${recipe.id}"><img src="image/image/${recipe.imageName}" width="214" height="138"></a>
        		 		<a href="GetRecipe?idRecipe=${recipe.id}" id="title" >${recipe.title}</a>
        		 		<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.category}</a>  
        		 		<a id="star">****</a> 
        		 		</figure>
        		 		
        		 		</li>
        		 		
        		 	</ul>
        		 	</c:forEach>
        		
        		 </section>	
        		<!-- <a href="GetRecipe" >${recipe.id}</a>
        		 		<a href="GetRecipes?id=${recipe.id}">  </a> -->
		
	</div>
	</div>
		   </div>

    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	<script src="js/loginwithfb.js" ></script>
	
	<script src="js/login.js" ></script>
	
</body>
</html>