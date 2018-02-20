<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navbar.jsp" />
<html>
<head lang="it">
<script>

</script>
<title>${recipe.titolo}</title>
<%-- <meta charset="utf-8">
<meta property="og:url"           content="http://localhost:8080/INGSWESIW/" />
<meta property="og:type"          content="website" />
<meta property="og:title"         content="${recipe.titolo}" />
<meta property="og:description"   content="${recipe.descrizione}" />
<meta property="og:image"         content="http://localhost:8080/INGSWESIW/imageNames/${recipe.nameImmaginePrincipale}" />
 --%>

	<style>
	#page{
	display: none;
	}
	#btnadd,#btnremove{
	float: right;
	margin-top: 10px;
	}
	</style>
      <link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="/INGSWESIW/fonts/font-awesome.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
      <link rel="stylesheet" href="/INGSWESIW/css/displayRecipe.css">

<body onload="displayComments(${recipe.id});displayvoto(${recipe.id})">

	
			<div id="recipe-body">
				
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
					<div id="favorite">
							<button id="btnadd" type="button" class="btn btn-warning" >Add to Favourites 
							 <span id="heart" class="glyphicon glyphicon-heart"></span>
							 <span id="ok" style="display: none;"  class="glyphicon glyphicon-heart"></span>
							</button>
							
							
						</div>
						
				<div id="favorite"></div> 
					<%--  <div id=favorite+${recipe.id}  style="display:inline" class="row">
						
				        <a onclick="javascript:addfavorite(${recipe.id})">
				        	<span id="heart" class="glyphicon glyphicon-heart" style="font-size:1.5em;float: right;"></span>
				        </a>
						</div> --%>
						
				
					<h3 id="category">${recipe.categoria}</h3>
					<h1 id="title${recipe.titolo}">${recipe.titolo}</h1>
					<!--image--->
					<figure id="image">
						<img src="imageNames/${recipe.nameImmaginePrincipale}">
					</figure>
					<br>
					<div>
					<a onclick=""><i class="fa fa-twitter" style="font-size:50px"></i></a>
				    <a onclick="myFunction()"><i class="fa fa-facebook-square" style="font-size:50px"></i></a>
				    <iframe id="page" src="" width="83" height="28" style="border:none;overflow:hidden" scrolling="no"  frameborder="0" allowTransparency="true"></iframe>
					
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
			
			
			
			
			
			
		
	<footer></footer>
    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="js/recipe.js"></script>
	<script>
	function addfavorite(idRecipe) {
		var tipo="add";
		$.ajax({
			type: "POST",
			url: "AddFavourite",
			datatype: "json",
			data: JSON.stringify({"idRecipe" : idRecipe, "tipo" : tipo}),
			success: function(data){
				$("#favorite"+idRecipe).replaceWith("<div id = favorite"+idRecipe+" style=\"display:inline\" class=\"row\">"
				    + "<a onclick=\"javascript:removefavorite("+idRecipe+")\">"
	        		+"<span id=\"ok\" class=\"glyphicon glyphicon-ok\" style=\"font-size:1.5em;padding-left:10%;padding-right:20%;color:#36c906\"></span>"
	       			+"</a></div>");
			}
		});
	}
	
	function removefavorite(idRecipe) {
		var tipo="remove";
		$.ajax({
			type: "POST",
			url: "AddFavourite",
			datatype: "json",
			data: JSON.stringify({"idRecipe" : idRecipe, "tipo" : tipo}),
			success: function(data){
				$("#favorite"+idRecipe).replaceWith("<div id = favorite"+idRecipe+" style=\"display:inline\" class=\"row\">"
				    + "<a onclick=\"javascript:addfavorite("+idRecipe+")\">"
	        		+"<span id=\"heart\" class=\"glyphicon glyphicon-heart\" style=\"font-size:1.5em;padding-left:10%;padding-right:20%;color:#36c906\"></span>"
	       			+"</a></div>");
			}
		});
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
				
				//$('#voti').html("thank you for your vote: <b>"+value+"</b>");
				swal("Good job!", "Thank you for your vote", "success");
				
			}
		});
	});

		 $("#btnadd").click(function() { 
			 if (confirm("Are you sure you want to add this Recipe to favourite?") == true) {
					var idRecipe=${recipe.id};
			$.ajax({
					type: 'POST',
					url:'AddFavourite',
					data: {'idRecipe':idRecipe},
					success:function(data){
					    $('#heart').css("display", "none");
					    $('ok').css("display", "block");
						//$('#favorite').html("<button id='removefavorite' type='button' class='btn btn-warning'>add to Favourites <span id='ok' class='glyphicon glyphicon-ok'></span></button>");
						//swal("Good job!", "added to your list of favorites !", "success");
						 //$("#btnremove").css("display", "black");
						// $('#ok').html('<span class="glyphicon glyphicon-ok"></span>');
						 swal("Good job!", "added to your list of favorites !", "success");
						
					}
				});
				}
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
				success: function(data){
					 $('#heart').remove();
					 $('#ok').html('<span class="glyphicon glyphicon-ok"></span>');
				}	
			});
		};
		function displayvoto(idRecipe) {
			$.ajax({
				type: "GET",
				url:"GetVotes",
				data: {idRecipe:idRecipe},
				success: function(data){
					$("#resultvoto").html(data);
				}
			});
		} 
		
		
		 (function(d, s, id) {
		    var js, fjs = d.getElementsByTagName(s)[0];
		    if (d.getElementById(id)) return;
		    js = d.createElement(s); js.id = id;
		    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1";
		    fjs.parentNode.insertBefore(js, fjs);
		  }(document, 'script', 'facebook-jssdk'));
		 function myFunction() {
			   var x = document.URL;
			   document.getElementById("page").src='https://www.facebook.com/plugins/share_button.php?href='+x+'&layout=button_count&size=large&mobile_iframe=true&width=83&height=28&appId';
			  }
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
			