<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>

<jsp:include page="nav.jsp" />
<head>
<meta charset="utf-8">
	 	
		<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
		<link rel="stylesheet" href="/INGSWESIW/css/profile.css">
	
<title>Favorites | SoRecipes</title>
</head>
<body>
	<div class="container"style="margin-top: 100px;">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				
				<div class="profile-userpic">
					<img src="image/unknown-user.png" class="img-responsive" alt="">
				</div>
				
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
					${utente.username}
					</div>
					
				</div>
				
				<div class="profile-userbuttons">
				
								
					<button type="button" class="btn btn-success btn-sm">Followers</button>
					<button type="button" class="btn btn-danger btn-sm">Following</button>
					
					
				</div>
				
				<div class="profile-usermenu">
					<ul class="nav">
						<li class="active">
							<a href="MyProfile">
							<i class="glyphicon glyphicon-home"></i>
							Overview </a>
						</li>
						<li>
							<a href="EditProfile">
							<i class="glyphicon glyphicon-user"></i>
							Modifica il profilo </a>
						</li>
						
						<li>
							<a href="Favorites">
							<i class="glyphicon glyphicon-ok"></i>
							favoriti </a>
						</li>
						
						
						
					</ul>
				</div>
			
			</div>
		</div>
	<div class="col-md-9">
            <div class="profile-content">
	 <section class="recipe" >
        	<c:forEach var="recipe" items="${ricette}">
				<ul class="recipe-showcase" id="displayrecipe${recipe.id}">
        		 		<li>
        		 		<figure class="recipe-photo">
									<a href="GetRecipe?idRecipe=${recipe.id}"><img src="imageNames/${recipe.nameImmaginePrincipale}" width="214"height="138"></a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="title">${recipe.titolo}</a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.categoria}</a>
									<a onclick="javascript:removefavorite(${recipe.id})"><span class="glyphicon glyphicon-trash" style="float:right"></span></a>
        		 		</figure>
        		 		</li>
        		 	</ul>
        	</c:forEach>
      </section>	
            </div>
		</div>
	
	</div>
</div>


<script type="text/javascript">
function removefavorite(idRecipe) {
	 if (confirm("Sei sicuro di voler rimuovere questa ricetta dai preferiti?") == true) {
	var tipo="remove";
	$.ajax({
		type: "POST",
		url: "AddFavourite",
		datatype: "json",
		data: JSON.stringify({"idRecipe" : idRecipe, "tipo" : tipo}),
		success: function(data){
			swal("OK!", "La ricetta è stata rimossa dai preferiti.", "success");
			$("#displayrecipe"+idRecipe).remove();

		}
	});
}
}

</script>
    <script src="js/jquery-3.2.1.min.js"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
</body>
</html>