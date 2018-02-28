<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<jsp:useBean id="recipe" class="model.Ricetta" scope="request" />

<jsp:include page="navbar.jsp" />
<head>
<meta charset="utf-8">
	 	
		<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
		<link rel="stylesheet" href="INGSWESIW/../css/recipeCommon.css">

<title>Categoria | SoRecipes</title>
</head>
<body>

			<div class="row">
        		 <section class="recipe">
        		 	<c:forEach var="recipe" items="${recipes}">
	         <div class="container" style="padding-left: 200px;padding-top: 100px;">
	        	<div class=" col-md-9 col-sm-6 col-xs-6"  data-aos="fade-right">
				
                    <div class="col-lg-6 col-xs-12">
                  		<a href="GetRecipe?idRecipe=${recipe.id}"><img src="imageNames/${recipe.nameImmaginePrincipale}" alt="" width="100%"></a>
					</div>
					<div class="col-lg-6 col-xs-12">
						 <div class="recipe-column">
						<a href="GetRecipe?idRecipe=${recipe.id}"><span>${recipe.titolo}</span></a>
							 <ul class="blog-detail list-inline"> 
							    <li><i class="fa fa-user "></i><a href="UserProfile?idUser=${recipe.utente.username}">${recipe.utente.username}</a></li> 
								<li><i class="fa fa-clock-o"></i>${recipe.dataPubblicazione}</li> 
							</ul> 
							<p>${recipe.descrizione.substring(0,250)}...<a href="GetRecipe?idRecipe=${recipe.id}">Read More</a></p>
							
						</div>
					</div>
					
                </div>
	          </div>
        		 	</c:forEach>
        		
        		 </section>	
        		</div>
	
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</body>
</html>