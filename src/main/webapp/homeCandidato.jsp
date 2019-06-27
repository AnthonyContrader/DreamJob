<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.services.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Candidato</title>
<style>
body {
	background-image:
		url("http://1.bp.blogspot.com/-FLsi6FOuXJ8/UHHBwqDTLNI/AAAAAAAAEG0/KTBA9VtfDl0/s1600/viaggio-a-Paris.gif");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: blue;
}
</style>
</head>
<body>
<style>
.body{
text-aling:center;
}
.titolo {
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: times new roman;
	}
	
.body{
	text-align: center;
	}
</style>

<div class="body">
<%UserDTO user = (UserDTO) request.getAttribute("user");%>
<div class="titolo"> <h1>${user.getUsername()}</h1>	</div>
	 <br>
	 <br>
	 <br>
	Benvenuto su DreamJob, questo portale ti aiutera´ a trovare il lavoro dei tuoi sogni.
	 <br>
	 <br>
	 <br>
	 Clicca su "Modifica Profilo" per accedere ai tuoi dati.
		<br>
	 <br>
	 <br>

	<a href="/Candidato/candidatoManagement?idUser=<%= user.getId()%>">Modifica Profilo</a>
	<br>
	 <br>
 	  <a href="/home/logout" class="btn btn-primary">Logout</a>
	
</div>
</body>
</html>