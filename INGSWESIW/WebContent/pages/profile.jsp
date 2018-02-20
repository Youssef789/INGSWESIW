<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="model.Utente" scope="session" />
<jsp:setProperty name="user" property="username" value="fin."/>
<jsp:useBean id="recipe" class="model.Ricetta" scope="session" />
<jsp:include page="nav.jsp"/>

<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="INGSWESIW/../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></head>
	<link rel="stylesheet" href="/INGSWESIW/css/profile.css">
	
	
<title id="userid">${utente.username}</title>
</head>
<body  onload="getfollow();">
<c:if test="${empty username}">
		<c:redirect url="login.jsp" />
</c:if>


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
					<c:if test="${username != utente.username}">
					<div id="warning-follow">
					
					</div>
					</c:if>	
					
					
				</div>
				
				<div class="profile-usermenu">
					<ul class="nav">
						<li class="active">
							<a href="MyProfile">
							<i class="glyphicon glyphicon-home"></i>
							Overview </a>
						</li>
						<c:if test="${username == utente.username}">
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
						
						
						</c:if>
						
					</ul>
				</div>
			
			</div>
		</div>
		<div class="col-md-9">
            <div class="profile-content">
	 <section class="recipe" id="display">
        	<c:forEach var="recipe" items="${myrecipes}">
				<ul class="recipe-showcase">
        		 		<li>
        		 		<figure class="recipe-photo">
									<a href="GetRecipe?idRecipe=${recipe.id}"><img src="imageNames/${recipe.nameImmaginePrincipale}" width="214"height="138"></a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="title">${recipe.titolo}</a>
									<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.categoria}</a>
									<c:if test="${username == utente.username}">
									<a onclick="javascript:deleteRecipe(${recipe.id})"><span class="glyphicon glyphicon-trash" style="float:right;padding: 10px;margin-top: 30px;"></span></a>
				 					<a href="EditRecipe?idRecipe=${recipe.id}" ><span class="glyphicon glyphicon-edit" style="float:right;padding: 10px;margin-top: 30px;"></span></a>	
        		 					</c:if>
        		 		</figure>
        		 		</li>
        		 	</ul>
        	</c:forEach>
      </section>	
            </div>
		</div>
	</div>
</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="js/profile.js"></script>
 	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>