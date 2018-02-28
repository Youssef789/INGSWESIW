<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="recipe" class="model.Ricetta" scope="request" />


<jsp:include page="navbar.jsp" />
<html>
<head lang="it">
<title>${recipe.titolo}</title>
<%-- <meta charset="utf-8">
<meta property="og:url"           content="http://localhost:8080/INGSWESIW/" />
<meta property="og:type"          content="website" />
<meta property="og:title"         content="${recipe.titolo}" />
<meta property="og:description"   content="${recipe.descrizione}" />
<meta property="og:image"         content="http://localhost:8080/INGSWESIW/imageNames/${recipe.nameImmaginePrincipale}" />
 --%>

	
      <link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
      <link rel="stylesheet" href="/INGSWESIW/css/displayRecipe.css">
<style>
	#page{
	display: none;
	}
	#btnadd,#btnremove{
	float: right;
	margin-top: 10px;
	}
	#map{
    width: 100%;
    padding: 300px 0;
    text-align: center;
    background-color: lightblue;
    margin-top: 20px;
	}
	</style>
<body onload="displayComments(${recipe.id});getfavourite(${recipe.id});formatString();">

	
			<div id="recipe-body">
			<c:if test="${!empty username}">	
				<div>
				<form id="myForm">
						<div class="star-rating">
							<input type="radio" name="rating" id="resultvoto" value="${votoComplessivo}"/>
							<label for="resultvoto" title=""></label>
							<input type="radio" name="rating" id="star-5" value="5"/>
							<label for="star-5" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-4" value="4"/>
							<label for="star-4" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-3" value="3"/>
							<label for="star-3" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-2" value="2"/>
							<label for="star-2" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
							<input type="radio" name="rating" id="star-1" value="1"/>
							<label for="star-1" title=""><i class="fa fa-star" aria-hidden="true"></i></label>
						</div>
				</form>
					
				</div>	
				</c:if>
						
				
					<h3 id="categoria" style="display: none">${recipe.categoria}</h3>
					<h3 id="category"></h3>

					<h1 id="title">${recipe.titolo}</h1>
					<!--image--->
					<figure id="image">
						<img src="imageNames/${recipe.nameImmaginePrincipale}">
					</figure>
					<br>
					<div>
					<a onclick=""><i class="fa fa-twitter" style="font-size:50px"></i></a>
				    <a onclick="myFunction()"><i class="fa fa-facebook-square" style="font-size:50px"></i></a>
					 <c:if test="${!empty username}">
						<div id="warning">
						
						</div> 
						</c:if>						
					</div>
					<div>
						<ul id="information">
							<li class="difficolta">Difficoltà: <strong>${recipe.difficolta}</strong>
							</li>

							<li class="preptime">Timpo Di Preparazione: <strong>${recipe.tempoPreparazione}</strong>
							</li>
						</ul>
					</div>

					<div id="ingredient">
						<h2>
							<span>Ingredienti</span>
						</h2>
						<p>${recipe.ingredienti}</p>
						<button onclick="javascript:getMyLocation();supermarketmaps()" type="button" class="btn btn-primary btn-block btn-lg">Supermercati vicini a te</button>
						
						
    				<div id="map" style="display: none;">
     					<div id='yourlocation'>
    
    					</div>
    				</div>
					</div>

					<div id="description">
						<h2>
							<span>descrizione</span>
						</h2>
						<p>${recipe.descrizione}</p>
					</div>

					<div>
						<h2 id="preparation">
							<span>Preparazione</span>
						</h2>
						<h3 id="how">Come preparare la ricetta</h3>
						<br>
						<p>${recipe.preparazione}</p>
						
						</div>
					
			<div>
			<c:if test="${!empty username}">
				<form action ="javascript:addComment(${recipe.id})" >
					<div class="form-group" id="editcomment">
								<textarea name ="comment${recipe.id}"class="form-control" rows="5" id="comment${recipe.id}"  placeholder="scrivi il tuo commento "></textarea>
								<button id="commbtn" type="submit" class="btn btn-primary">comment</button>
						<div id="displaycomment">
											
						</div>
					
					</div>
					
				</form>
		</c:if>
				
			</div>
			<div id="comments" style="padding: 30px">
						<!-- here display comments -->
						
						
			</div>
		</div>
			
			
			
			
			
			
		
    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="js/recipe.js"></script>
	<script src='js/supermarketmaps.js'></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDqROcOwSv3WrpevOnSeN-_LsxGtZ0CBfw"></script>
	
	<script>
	function formatString() {
		var c = $('#categoria').text();
		c=c.replace("_", " ");
		//(c);
		$('#category').html(c);
	}
	
	function supermarketmaps() {
	    //document.getElementById("map").style.display = "block";
	    var x = document.getElementById("map");
	    if (x.style.display === "none") {
	        x.style.display = "block";
	    } else {
	        x.style.display = "none";
	    }
	}
	
	
	$('#myForm input').on('change', function() {
		var value =$('input[name=rating]:checked', '#myForm').val();
		var idRecipe=${recipe.id};
	$.ajax({
		type: "POST",		
		url: "Vote",
		datatype: "json",
		data: JSON.stringify({"value":value,"idRecipe":idRecipe}),
		success:function(data)
		{
			
			swal("Good job!", "Grazie per il tuo voto", "success");
			
		}
	});
});
	
	
	function displayComments(idRecipe){
		$.ajax({
			type: "GET",		
			url: "AllComments",			
			data: {idRecipe:idRecipe},
			success: function(data){
				$("#comments").html(data);
			}	
		});
	};
	
	function getfavourite(idRecipe){
		$.ajax({
			type: "GET",		
			url: "AddFavourite",			
			data: {idRecipe:idRecipe},
			success: function(response){
				if (response == "true"){
					$("#warning").replaceWith("<button id=\"add\" style=\"float:right; color:#8B0000;\" type=\"button\" onclick=\"javascript:addfavorite("+idRecipe+")\" class=\"btn btn-warning\" >Add to Favourites "
							+"<span id=\"heart\" class=\"glyphicon glyphicon-heart\"></span></button>");
				}
				else{
					$("#warning").replaceWith("<button id=\"remove\" style=\"float:right;\" type=\"button\" onclick=\"javascript:removefavorite("+idRecipe+")\" class=\"btn btn-primary\" >Remove from Favourites "
							+"<span id=\"ok\" class=\"glyphicon glyphicon-ok\"></span></button>");
				}
			}	
		});
	}
	function addfavorite(idRecipe) {
		var tipo="add";
		$.ajax({
			type: "POST",
			url: "AddFavourite",
			datatype: "json",
			data: JSON.stringify({"idRecipe" : idRecipe, "tipo" : tipo}),
			success: function(data){
				$("#add").replaceWith("<button id=\"remove\" style=\"float:right;\" type=\"button\" onclick=\"javascript:removefavorite("+idRecipe+")\" class=\"btn btn-primary\" >Remove from Favourites "
						+"<span id=\"ok\" class=\"glyphicon glyphicon-ok\"></span></button>");
			}
		});
	}

	function removefavorite(idRecipe) {
		 if (confirm("Sei sicuro di voler aggiungere questa Ricetta ai preferiti?") == true) {
		  var tipo="remove";
		$.ajax({
			type: "POST",
			url: "AddFavourite",
			datatype: "json",
			data: JSON.stringify({"idRecipe" : idRecipe, "tipo" : tipo}),
			success: function(data){
				$("#remove").replaceWith("<button id=\"add\" style=\"float:right; color:#8B0000;\" type=\"button\" onclick=\"javascript:addfavorite("+idRecipe+")\" class=\"btn btn-warning\" >Add to Favourites "
						+"<span id=\"heart\" class=\"glyphicon glyphicon-heart\"></span></button>");
			}
		});
		}
	}

	</script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>    
</head>
</html>