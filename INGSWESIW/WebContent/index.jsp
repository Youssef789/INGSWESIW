<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
  <link rel="stylesheet" href="https://bootswatch.com/3/cosmo/bootstrap.min.css">

  <style >
  #fb-btn{margin-top:15px;}
  #mainNav{
  position: fixed;
  left: 0px;
  width: 200px;
  top: 100px;
  }
  #right{
  position: absolute;
  top:100px;
  left: 200px;
  width: 750px;
 
  }
  #search{ width: 500px;}
  #home,#yourprofile{display:block;}
  .recipe-showcase{
  list-style: none;
  width:100%;
  }
  .recipe-showcase li{
  display: block;
  width: 75%;
  folat:left;
  }
  .recipe-photo
  {
  width: 100%;
  margin: 0;
  }
  .recipe-photo img
  {
  width: 100%;
  height: auto;
  
  }
  </style>
<title>SocialCook</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top" id=nav>
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SocialCook</a>
				<form class="navbar-form navbar-left" action="/action_page.php">
					<div class="form-group">
						<input id="search" type="text" class="form-control" placeholder="Search">
					</div>
					<button id="btnsearch" type="submit" class="btn btn-primary ">Search</button>
				</form>
			</div>
			<div id="navbar" class="collapse navbar-collapse">

				<ul class="nav navbar-nav navbar-right">
					<li><a id="logout" href="#" onclick="logout()">Logout</a></li>
					<fb:login-button id="fb-btn"
						scope="public_profile,email,user_birthday"
						onlogin="checkLoginState();">
					</fb:login-button>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a id="home" href="#">Home</a></li>
					<li><a id="yourprofile" href="profile.html">Profile</a></li>
					
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<li><a id="signup" href="pages/account.jsp">Sign Up</a></li>
					<li><a id="signin" href="login.jsp">Login</a></li>
					<li class="dropdown"><a id="user" class="dropdown-toggle"data-toggle="dropdown" href="#">welcome : ${username}<span class="caret"></span></a>
					<ul class="dropdown-menu ">
						<li><a href="/web/recipe">Profile</a></li>
						<li><a href="/web/recipe">Create Recipe</a></li>
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
							<li><a href="/INGSWESIW/web/antipasti.jsp">Antipasti</a></li>
							<li><a href="/INGSWESIW/web/primi.jsp">Primi Piatti</a></li>
							<li><a href="/INGSWESIW/web/secondi.jsp">Secondi Piatti</a></li>
							<li><a href="/INGSWESIW/web/contorni.jsp">Contorni</a></li>
							<li><a href="/INGSWESIW/web/lievitati.jsp">Lievitati</a></li>
							<li><a href="/INGSWESIW/web/piattiUnici.jsp">Piatti unici</a></li>
						</ul>
					
				</nav>
				
			</div>
			
			<div class="col-xs-9" id="right">
        		<div id="profile"></div>
        		 
        		 <section class="recipe">
        		 	<ul class="recipe-showcase">
        		 	
        		 		<li>
        		 		<figure class="recipe-photo">
        		 		<img src="image/table.jpg">
        		 		<a href="">title1</a>
        		 		</figure>
        		 		</li>
        		 		<li>
        		 		<figure class="recipe-photo">
        		 		<img src="image/table.jpg"<a href=""></a>>
        		 		<a href="GetRecipe">${prova}S</a>
        		 		</figure>
        		 		</li>
        		 	</ul>
        		 	<table>
        		 		<c:forEach var="recipe" items="${recipes}">
			<tr class="success recipes">
				<td>${recipe.id}</td>
				<td>${recipe.category}</td>
			</tr>	
					
		</c:forEach>
        		 	</table>
        		 
        		 
        		 </section>		
		
	</div>
	</div>
		   </div>

    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="js/loginwithfb.js" ></script>
	<script src="js/login.js" ></script>
	
</body>
</html>