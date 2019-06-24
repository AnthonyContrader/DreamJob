<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Candidato</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>
<%UserDTO user = (UserDTO) request.getAttribute("user");%>

<div class="navbar">
  <a href="homecandidato.jsp">Home</a>
   
  <a href="CandidatoServlet?mode=read&id=<%= user.getId()%>">Modifica Profilo</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>
<br>
<br>
<br>
Benvenuto su DreamJob, questo portale ti aiutera´ a trovare il lavoro dei tuoi sogni.
<br>
<br>
<br>
</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>