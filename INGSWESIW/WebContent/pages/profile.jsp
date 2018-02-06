<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

.profile-userbuttons .btn:last-child {
  margin-right: 0px;
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
<title>${username}</title>
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

				<a class="navbar-brand" href="AllRecipes">SocialCook</a>
			
				<form class="navbar-form navbar-left" action="Search">
					<div class="form-group" class="col-xs-3">
						<input id="search" type="text" class="form-control"
							placeholder="Search">
					</div>
					<button id="btnsearch" type="submit" class="btn btn-primary ">Search</button>
				</form>
				 
			</div>
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a id="home" href="AllRecipes">Home</a></li>
					<li><a id="yourprofile" href="MyProfile">Profile</a></li>
					<li class="dropdown"><a id="user" class="dropdown-toggle"
						data-toggle="dropdown" href="#">welcome : ${username}<span
							class="caret"></span></a>
						<ul class="dropdown-menu ">
							<li><a href="recipe.jsp">Create Recipe</a></li>
							<li><a href="logout">Logout</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
	</nav>
	<div class="container"style="margin-top: 100px;">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				
				<div class="profile-userpic">
					<img src="image/unknown-user.png" class="img-responsive" alt="">
				</div>
				
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
					${username}
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
							<a href="#">
							<i class="glyphicon glyphicon-user"></i>
							Account Settings </a>
						</li>
						<li>
							<a href="MyFavourites" target="_blank">
							<i class="glyphicon glyphicon-ok"></i>
							Favourite </a>
						</li>
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-edit"></i>
							Drafts </a>
						</li>
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
									<a onclick="javascript:deleteRecipe(${recipe.id})"><span class="glyphicon glyphicon-trash" style="float:right;padding: 10px;"></span></a>
				 					<a href="EditRecipe?idRecipe=${recipe.id}" ><span class="glyphicon glyphicon-edit" style="float:right;padding: 10px;"></span></a>	
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