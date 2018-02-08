<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica il profilo | SoRecipes</title>
</head>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body>

<div class="container" style="padding-top: 60px;">
	<h1 class="page-header">Modifica il profilo</h1>
  		<div class="row">
    		<!-- left column -->
    		<div class="col-md-4 col-sm-6 col-xs-12">
      		<div class="text-center">
        		<img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="avatar">
     	  		<h6>Scegli una foto</h6>
        		<input type="file" class="text-center center-block well well-sm" style="width: 22.5em;">
      		</div>
   		 </div>
   		 
   		 
    <!-- edit form column -->
    	<div class="col-md-8 col-sm-6 col-xs-12 personal-info">
     		<div class="alert alert-info alert-dismissable">
        		<a class="panel-close close">×</a> 
        		<i class="fa fa-coffee"></i>
        		This is an <strong>.alert</strong>. Use this to show important messages to the user.
      		</div>
     		<h3>Informazioni personali</h3>
     		<form class="form-horizontal">
     		        <div class="form-group">
          <label class="col-md-3 control-label">Username:</label>
          <div class="col-md-8">
            <input class="form-control" value="janeuser" type="text">
          </div>
        </div>
     		
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label>
          <div class="col-lg-8">
            <input class="form-control" value="janesemail@gmail.com" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password:</label>
          <div class="col-md-8">
            <input class="form-control" value="11111122333" type="password">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Conferma password:</label>
          <div class="col-md-8">
            <input class="form-control" value="11111122333" type="password">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8">
            <input class="btn btn-primary" value="Salva modifiche" type="button">
            <span></span>
            <input class="btn btn-default" value="Reset modifiche" type="reset">
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>