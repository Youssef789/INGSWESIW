<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navbar.jsp" />
<html>
<head lang="it">
<title>${recipe.titolo}</title>
<meta charset="utf-8">

<style>

#title {
	margin-bottom: 10px;
}

#btnfavorite {
	float: right;
	margin-top: 20px;
}

</style>

      <link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="/INGSWESIW/fonts/font-awesome.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
      <link rel="stylesheet" href="/INGSWESIW/css/displayRecipe.css">

<body onload="displayComments(${recipe.id})">

	
			<div class="col-xs-9" id="right">
				<div class="col-md-9">
				<div>
				<form id="myForm">
						<div class="star-rating">
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
					
						<div class="button">
						<button id="btnfavorite" type="button" class="btn btn-warning" onclick="addFavourite(${recipe.id})">Favourite <span id="heart" class="glyphicon glyphicon-heart"></span></button>
						</div>
					
					<h3 id="category">${recipe.categoria}</h3>
					<h1 id="title">${recipe.titolo}</h1>
					<!--image--->
					<figure id="image">
						<img src="imageNames/${recipe.nameImmaginePrincipale}">
					</figure>
					<br>

					<div>
						<ul id="information">
							<li class="difficolta">Difficoltà: <strong>${recipe.difficolta}</strong>
							</li>

							<li class="preptime">Tempo di preparazione: <strong>${recipe.tempoPreparazione}</strong>
							</li>
						</ul>
					</div>

					<div id="ingredient">
						<h2>
							<span>Ingredienti</span>
						</h2>
						<p>${recipe.ingredienti}</p>

					</div>

					<div id="description">
						<h2>
							<span>Descrizione</span>
						</h2>
						<p>${recipe.descrizione}</p>
					</div>

					<div>
						<h2 id="preparation">
							
						</h2>
						<h3 id="how">Come preparare la ricetta</h3>
						<br>
						<p>${recipe.preparazione}</p>
				
						
						
					</div>
		
			
			<div>
				<form action ="javascript:addComment(${recipe.id})" >
					<div class="form-group" id="editcomment">
								<textarea name ="comment${recipe.id}"class="form-control" rows="5" id="comment${recipe.id}"  placeholder="scrivi il tuo commento "></textarea>
								<button id="commbtn" type="submit" class="btn btn-primary">comment</button>
						<div id="displaycomment">
											
						</div>
					
					</div>
					
				</form>
				
				
			</div>
			<div id="comments" style="padding: 30px">
						<!-- here display comments -->
						
						
			</div>
		</div>
			
			
			
			
			
			</div>
		
	<footer></footer>
    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="js/recipe.js"></script>
	<script>
	
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
				
				//$('#voti').html("thank you for your vote: <b>"+value+"</b>");
				swal("Good job!", "Thank you for your vote", "success");

			}
		});
	});
/* 		$(document).ready(function({
			$('#btnfavorite').click(function({
				
			}));
		})); */
		function addFavourite(idRecipe){
			if (confirm("Are you sure you want to add this Recipe to favourite?") == true) {
				swal("Good job!", "You add this recipe to your favourite list!", "success");
			$ajax({
				type:"POST",
				url:"AddFavourite",
				data:{idRecipe: idRecipe},
				success:function(data){
					$("#btnfavorite"+idRecipe).html('span id="heart" class="glyphicon glyphicon-ok"></span>');
					swal("Good job!", "You clicked the button!", "success");
				}
			});
			}
		};	
		
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
	</script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>    
</head>
</html>

<!-- 
<form action="Comment?idRecipe=${recipe.id}" method="post">
					<div class="form-group col-md-9">
						<textarea name="comment" class="form-control" rows="5" id="comment" placeholder="scrivi il tuo commento "></textarea>
						<button id="commbtn" type="submit" class="btn btn-primary">comment</button>
					</div>
			</form>	
			
			
			 
 -->
 
 
 
			<%-- 
				<ul id = "listOfComments"  style="text-align:left;margin-left:-42px;margin-bottom:30px;">
						<c:forEach var="comment" items="${comments}">
							<li style="list-style-type: none;">
								<div id=comment_${comment.id}>
								<hr class="post-hr">
								<h4>${comment.utente.username}</h4>
								<c:if test = "${comment.utente.email == utente.email}">
										<a onclick="javascript:deleteCommento(${commento.id})"><span class="glyphicon glyphicon-trash" style="float:right"></span></a>
				   				</c:if>	
									<h4>${comment.contenuto}</h4>
									<small id="date${comment.id}" style="float:right">
										<script>convertDateComment('${comment.id}','${comment.dataPubblicazione}');</script>
									</small>
								</div>
							</li>
						</c:forEach>
				</ul> --%>
				
				<%-- 	</div>
					
						<div style=" position:relative;  text-align: center; padding:30px; ">
							<a href="AllComments?idRecipe=${recipe.id}">LEGGI TUTTI I COMMENTI</a>
						</div> --%>
			