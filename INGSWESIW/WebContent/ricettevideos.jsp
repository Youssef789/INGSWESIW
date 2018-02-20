<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="pages/nav.jsp"/>
<style>
body{
background: #f4f4f4;
font-family: "Arial",sans-serif;
font-size: 12px;
color: #666;
}
#contain{
width: 800px;
margin: auto;
overflow: auto;
padding-top: 100px;
padding: 50px;
}
</style>
<html>
<head>
<meta charset="utf-8">
		<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Videos | SoRecipes</title>
</head>
<body>
<div id="nav">
</div>
<div id="body">
	<div class="container" id="contain">
	<h1 style="text-align: center; color: #3d3257">GialloZafferano videos</h1>
	<div>
		  <form action="#">
                	<div class="input-group">
	        			<input type="text" id="search" class="form-control" placeholder="Search" name="search">
	        				<div class="input-group-btn">
	          					<button class="btn btn-default" type="submit"> <i class="glyphicon glyphicon-search" style="padding: 3px;"></i></button>
	        				</div>
	      			</div>
					                
                     </form>	
	</div>
	<ul id="results"></ul>
	</div>
	
</div>	
       <script src="js/jquery-3.2.1.min.js"></script>
	   <script src="js/ricettevideos.js"></script>
	   <script src="js/searchyoutube.js"></script>
       <script src="https://apis.google.com/js/client.js?onload=init"></script>
</body>
</html>