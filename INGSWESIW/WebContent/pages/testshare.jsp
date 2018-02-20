<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body onload="myFunction()">
<iframe id="page" src="" width="83" height="28" style="border:none;overflow:hidden" scrolling="no"  frameborder="0" allowTransparency="true"></iframe>

<div>
	<script src="//rss.bloople.net/?url=http%3A%2F%2Fxml2.corriereobjects.it%2Frss%2Fhomepage.xml&limit=7&showtitle=false&type=js"></script>
</div>



	<script src="../js/jquery-3.2.1.min.js"></script>
	<script>
	function myFunction() {
	   var x = document.URL;
	   document.getElementById("page").src = 'https://www.facebook.com/plugins/share_button.php?href='+x+'&layout=button_count&size=large&mobile_iframe=true&width=83&height=28&appId';
	  }
  </script>
</body>
</html>