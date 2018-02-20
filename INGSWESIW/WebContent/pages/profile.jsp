<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="nav.jsp"/>

<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<style>
/* Profile container */
.profile {
  margin: 20px 0;
}

/* Profile sidebar */
.profile-sidebar {
  padding: 20px 0 10px 0;
  background: #fff;
}

.profile-userpic img {
  float: none;
  margin: 0 auto;
  width: 30%;
  height: 30%;
  -webkit-border-radius: 50% !important;
  -moz-border-radius: 50% !important;
  border-radius: 50% !important;
}

.profile-usertitle {
  text-align: center;
  margin-top: 20px;
}

.profile-usertitle-name {
  color: #5a7391;
  font-size: 16px;
  font-weight: 600;
  margin-bottom: 7px;
}


.profile-userbuttons {
  text-align: center;
  margin-top: 10px;
}

.profile-userbuttons .btn {
  text-transform: uppercase;
  font-size: 11px;
  font-weight: 600;
  padding: 6px 15px;
  margin-right: 5px;
}

.profile-userbuttons .btn.btn-primary{
  margin-top: 20px;
}
    
.profile-usermenu {
  margin-top: 30px;
}

.profile-usermenu ul li {
  border-bottom: 1px solid #f0f4f7;
}

.profile-usermenu ul li:last-child {
  border-bottom: none;
}

.profile-usermenu ul li a {
  color: #93a3b5;
  font-size: 14px;
  font-weight: 400;
}

.profile-usermenu ul li a i {
  margin-right: 8px;
  font-size: 14px;
}

.profile-usermenu ul li a:hover {
  background-color: #fafcfd;
  color: #5b9bd1;
}

.profile-usermenu ul li.active {
  border-bottom: none;
}

.profile-usermenu ul li.active a {
  color: #5b9bd1;
  background-color: #f6f9fb;
  border-left: 2px solid #5b9bd1;
  margin-left: -2px;
}


  #title{
  	position: absolute;
    font-size: 25px;
    margin-top: 5px;
    padding-left: 30px;
    color: #54437e;
    order: 2;
  }
  #category{
  	position: absolute;
    font-size: 14px;
    margin-top: 50px;
    padding-left: 30px;
    color: #54437e;
    order: 1;
  }
  .recipe-showcase li{
  display: block;
  width: 75%;

  }
 #search{ width: 300px;}
  .profile-content{
   width:100%;
 
  }
	</style>
<title>${utente.username}</title>
</head>
<body>
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
						<button type="button" class="btn btn-primary btn-sm">Follow</button>
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
							Account Settings </a>
						</li>
						
						<li>
							<a href="Favorites">
							<i class="glyphicon glyphicon-ok"></i>
							Favorites </a>
						</li>
						
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-edit"></i>
							Drafts </a>
						</li>
						</c:if>
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-flag"></i>
							Help </a>
						</li>
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
									<a onclick="javascript:deleteRecipe(${recipe.id})"><span class="glyphicon glyphicon-trash" style="float:right;padding: 10px;"></span></a>
				 					<a href="EditRecipe?idRecipe=${recipe.id}" ><span class="glyphicon glyphicon-edit" style="float:right;padding: 10px;"></span></a>	
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
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
	function deleteRecipe(idRecipe){
		if (confirm("Are you sure you want to delete this Recipe?") == true) {
				// swal("Good job!", "idRecipe"+ idRecipe, "success");
			$.ajax({
				type: "POST",
				url:"DeleteRecipe",
				data: {"idRecipe" :idRecipe},
				success:function(data){
					$("#display"+idRecipe).remove();
					swal("Good job!", "The recipe was deleted. ", "success");

				}
			});
		}
	}

	</script>
	
</body>
</html>