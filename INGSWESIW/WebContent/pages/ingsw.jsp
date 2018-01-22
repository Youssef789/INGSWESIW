<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Social Cook</title>

 <link rel="stylesheet" href="https://bootswatch.com/3/cosmo/bootstrap.min.css">
 <link rel="stylesheet" href="../css/styleingsw.css" >
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
					<li><a id="signup" href="account.jsp">Sign Up</a></li>
					<li><a id="signin" href="login.jsp">Login</a></li>
					<li><a id="aboutus" href="">About Us</a></li>
					<li><a id="aboutus" href="">${name}</a></li>
				</ul>

				

				
			</div>

		</div>
	</nav>

	<header>
		<div class="welcome">
		<h1>WELCOME TO SOCIAL COOK</h1>
		
		<div class="button">
		<a href="account.jsp" class="btn btn-half">Sign Up</a>
		<a href="login.jsp" class="btn btn-full">Login</a>
			<c:forEach items="${utenti}" var="utente" >
        		 		<li>
        		 		<img src="image/table.jpg"<a href=""></a>>
        		 		<h3>${utente.name}</h3>
        		 		<h3>${utente.username}</h3>
        		 		</figure>
        		 		</li>
        		 			
        		 		</c:forEach>
		</div>
		</div>

	</header>
	
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>