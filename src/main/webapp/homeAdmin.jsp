<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
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
<div class="titolo"> <h1>${user.getUsername()}</h1>	</div>
	 <br>
	 <br>
	 <br>
	Benvenuto su DreamJob, dove potrai visualizzare, inserire, modificare ed eliminare gli account iscritti su questa piattaforma.
	 <br>
	 <br>
	 <br>
	 Clicca Users per accedere agli utenti.
		<br>
	 <br>
	 <br>

	<a href="UserService?mode=userlist">Users</a>
	<br>
	 <br>
 	 <a href="LogoutService" id="logout">Logout</a>
	
</div>
</body>
</html>