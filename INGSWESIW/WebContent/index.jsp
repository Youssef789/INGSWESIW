<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="pages/navbar.jsp" />

<html>
<head lang="it">
<meta charset="utf-8">
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/recipeCommon.css">
 <style>
 .options{
 	
 	float :right;
 	position: relative;
 	padding-right: 30px;
 	margin-top: 50px;
 }
 
 .test:after {
  content: '\2807';
  font-size: 20px;
  margin-top:20px;
  float: right;
  }
  
   </style>
  <script>
  $(document).ready(function(){
  	$("#title").click(function(){
  		var selected=$("#title").val();
 		 $ajax({
			 type:"GET",
			 url:"GetRecipe",
			 data:{RecipeSelected :selected},
			 success:function(data){
				 $("#id").html(data);
			 }
		  });
		  });
});
  
  function doajax(){	
	  var selected=$("#title").val();
	  $ajax({
		 type:"GET",
		 url:"GetRecipe",
		 data:{RecipeSelected :selected},
		 success:function(data){
			 alert(data.RecipeSelected);
		 }
	  });
	
  }
  </script>
    
<style>
               
                .icons li {
                    background: none repeat scroll 0 0 fuchsia;
                    height: 5px;
                    width: 5px;
                    line-height: 0;
                    list-style: none outside none;
                    margin-right: 10px;
                    margin-top: 2px;
                    vertical-align: top;
                    border-radius:50%;
                    pointer-events: none;
                }

                

                .dotsbtn {
                    
                    font-size: 20px;
  					margin-top:20px;
  					float: right;
                    border: none;
                    cursor: pointer;
                }

               

                .dropdown {
                    position: absolute;
                    display: inline-block;
                    right: 0.5em;
                }

                .dotsmenu-content {
                    display: none;
                    margin-top: 60px;
                    min-width: 160px;
                    overflow: auto;
                    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                    z-index: 1;
                }

                .dotsmenu-content a {
                    color: black;
                    padding: 12px 16px;
                    text-decoration: none;
                    display: block;
                }
                .show {display:block;}

            </style>

		
<title>SocialCook</title>
</head>
<body>		
			<div class="col-md-6" id="right">
        		<div id="profile">
        		 <section class="recipe">
        		 	<c:forEach var="recipe" items="${recipes}">
						
        		 			
				<ul class="recipe-showcase">
        		 		<li>
        		 		<!-- three dot menu -->
					<div class="dropdown" onclick="showDropdown()">
						<!-- three dots -->
						<ul class="dotsbtn icons">
							<li></li>
							<li></li>
							<li></li>
						</ul>
						<!-- menu -->
						<div id="dotsmenu" class="dotsmenu-content" >
							<a href="EditRecipe?idRecipe=${recipe.id}" id="edit">Edit</a> 
							<a href="DeleteRecipe?idRecipe=${recipe.id}" id="delete">delete</a>
						</div>
					
				</div>
        		 		</li>
        		 		<li>
        		 		<figure class="recipe-photo">

        		 		<a href="GetRecipe?idRecipe=${recipe.id}" id="title" >${recipe.titolo}</a>
        		 		<a href="GetRecipe?idRecipe=${recipe.id}" id="category">${recipe.categoria}</a>  
        		 		<a id="star">****</a> 
        		 		</figure>
        		 		</li>
        		 		
        		 		
        		 		
        		 	</ul>
        		 	
        		 	</c:forEach>
        		
        		 </section>	
        		
        		<!-- 
        		<ul class="options">
        		 		<li><a href="EditRecipe?idRecipe=${recipe.id}" id="edit">Edit</a></li>
        		 		<li><a href="DeleteRecipe?idRecipe=${recipe.id}" id="delete">delete</a></li>
        		 		</ul>
        		 -->
		
	</div>
	</div>
	

    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	<script src="js/loginwithfb.js" ></script>
	
	<script src="js/login.js" ></script>
	            <script>
          

                function showDropdown() {
                    document.getElementById("dotsmenu").classList.toggle("show");
                }

                // Close the dropdown if the user clicks outside of it
                window.onclick = function(event) {
                    if (!event.target.matches('.dotsbtn')) {
                        var dropdowns = document.getElementsByClassName("dotsmenu-content");
                        var i;
                        for (i = 0; i < dropdowns.length; i++) {
                            var openDropdown = dropdowns[i];
                            if (openDropdown.classList.contains('show')) {
                                openDropdown.classList.remove('show');
                            }
                            openDropdown=null;
                            
                        }
                        dropdowns=null;
                    }
                }
            </script>
</body>
</html>