<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="model.Ricetta" scope="session" />
<jsp:setProperty name="user" property="title" value="fin."/>
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
  left: 200px;
  width: 700px;
 
  }
  #search{ width: 500px;}
  
  #home,#yourprofile{display:block;}
  </style>
<title>SocialCook</title>
</head>
<body>

	<nav class="navbar navbar-default">
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
					<li><a id="signup" href="account.jsp">Sign Up</a></li>
					<li><a id="signin" href="login.jsp">Login</a></li>
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
				<h3  id="heading">log in to view your profile</h3>
        		<div id="profile"></div>
        		 
        		 <div class="table-responsive">
        		 <table class="table">
		<thead>
		<tr>
			<th>Titilo</th>
			<th>categoria</th>
			<th></th>			
		</tr>
		</thead>
		
		<tbody id="elenco ricette">
		
		<c:forEach items="${ricette}" var="ricetta">
			<tr class="success ricetta">
				<td>${ricetta.title}</td>
				<td>${ricetta.category}</td>			
			</tr>			
		</c:forEach>
							
		</tbody>
        		 </table>
        		 </div>

			</div>
		
		</div>
	
	</div>

    <script src="js/loginwithfb.js" ></script>
</body>
</html>