<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="pages/navbar.jsp" />

<html>
<head lang="it">
<meta charset="utf-8">
  		<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
	    <link rel="stylesheet" href="css/recipeCommon.css">
 <style>
  footer {

	padding: 50px 0;
	padding-left: 250px;
 
}
   </style>
 		
<title>Home | SoRecipes</title>
</head>
<body>	
<header>	

        		 <section class="recipe">
        		 	<c:forEach var="recipe" items="${recipes}">
	         <div class="container" style="padding-left: 200px;padding-top: 100px;">
	        	<div class=" col-lg-9 col-md-6 col-sm-12 col-xs-12"  data-aos="fade-right">
				
                    <div class="col-lg-6 col-sm-12 col-xs-12">
                  		<a href="GetRecipe?idRecipe=${recipe.id}"><img src="imageNames/${recipe.nameImmaginePrincipale}" alt="" width="100%"></a>
					</div>
					<div class="col-lg-6 col-sm-12 col-xs-12">
						 <div class="recipe-column">
						<a href="GetRecipe?idRecipe=${recipe.id}"><span>${recipe.titolo}</span></a>
							 <ul class="blog-detail list-inline"> 
							    <li><i class="fa fa-user "></i><a href="UserProfile?idUser=${recipe.utente.username}">${recipe.utente.username}</a></li> 
								<li><i class="fa fa-clock-o"></i>${recipe.dataPubblicazione}</li> 
							</ul> 
							<p>${recipe.descrizione.substring(0,350)}...<a href="GetRecipe?idRecipe=${recipe.id}">Read More</a></p>
							
						</div>
					</div>
					
                </div>
	          </div>
        		 	</c:forEach>
        		
        		 </section>	
        	
</header>
	<jsp:include page="pages/footer.html"></jsp:include>
    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>