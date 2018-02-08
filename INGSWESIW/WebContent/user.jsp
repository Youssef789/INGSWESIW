<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"/>


<html>

<head lang="it">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, height=device-height">
<link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navbar.css">

</head>

<body>

<nav>
	<div id='superNavBar' style='position: absolute; background-size: cover; background-position: center; z-index: -10000; height: 350px; width: 100%;'></div>
		<table class='navBar'>
				

			<td class='navBar' style='width: 230px; font-size: 28px; text-align: right;'>
				
							<table style='float: right;'>
								<tr>
									<td style='vertical-align: top;'>
										<img src='/immagini/utenti/utente-r0cky909.jpg?v=1468047841' class='navBar' onClick='location.href="/profilo.php?utente=r0ckY909"' title='Vai al tuo profilo' style='cursor: pointer; border-radius: 50%; margin-right: 20px;' />
									</td>
									<td style='color: white; vertical-align: middle; padding-left: 10px;'>
										<i class='fa fa-cog' onClick='location.href="/impostazioni.php"' style='cursor: pointer;'></i>
									</td>
								</tr>
							</table>
						
								<div style='clear: both;'></div>
								<button class='btnInfoSerie' onClick='location.href="logout.php"' style='width: 100px; background-color: #EF5350; padding: 7px; margin-top: 12px;'><i class='fa fa-lock'></i> Logout</button>
										</td>
		
	</table>
</nav>


				<table class='container titoloMedio' style='margin-top: 40px; font-size: 28px;'>
			<tr>
				<td style='width: 33%; vertical-align: bottom;'>
					Immagine profilo
				</td>
				<td style='width: 33%; vertical-align: bottom;'>
					Modifica password
				</td>
				<td style='width: 33%; vertical-align: bottom;'>
					Modifica email
				</td>
			</tr>
		</table>
		<div class='sfondoBianco'>
			<table class='container'>
				<tr>
					<td style='width: 33%; padding-right: 20px; vertical-align: top;'>
						<table style='width: 100%;'>
							<tr>
								<td style='width: 1%; vertical-align: top;'>
									<img src='immagini/utenti/utente-r0cky909.jpg?v=1468047841' style='width: 130px; height: 130px; border-radius: 50%;' />
								</td>
								<td style='vertical-align: top; padding-left: 15px;'>
									<form action='setImpostazione.php' method='post' enctype="multipart/form-data">
										<input type='file' name='photo' style='position: relative; width: 100%; font-family: "MuseoSans"; display: block; margin-bottom: 15px;' />
										<input type='submit' value='Carica foto' class='btnInfoSerie' style='margin-top: 0px; background-color: #4CAF50;' />
										<input type='button' value='Rimuovi foto' onClick="location.href='setImpostazione.php?via_immagine=1'" class='btnInfoSerie' style='margin-top: 0px; background-color: #EF5350;'>
									</form>
								</td>
							</tr>
						</table>
					</td>
					<td style='width: 33%; padding-right: 30px; vertical-align: top;'>
						<form action='setImpostazione.php' method="POST">
							<input type='password' name='password1' class='form' placeholder="Vecchia password" />
							<input type='password' name='password2' class='form' placeholder="Nuova password" />
							<input type='password' name='password3' class='form' placeholder="Ripeti nuova password" />

							<input type='submit' value='Conferma' class='form' />
						</form>
					</td>
					<td style='width: 33%; vertical-align: top;'>
						<form action='setImpostazione.php' method="POST">
							<input type='email' name='email1' class='form' placeholder="Vecchia email" />
							<input type='email' name='email2' class='form' placeholder="Nuova email" />
							<input type='email' name='email3' class='form' placeholder="Ripeti nuova email" />

							<input type='submit' value='Conferma' class='form' />
						</form>
					</td>
				</tr>
			</table>
		</div>

</body>

</html>