<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CompanyDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Company</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homecompany.jsp">Home</a>
  <a href="CompanyServlet?mode=companylist">Companys</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${company.getUsername()}</h1>
<br>
<br>
<br>
Benvenuto su DreamJob, su questa piattaforma potrai trovare il candidato ideale per il progresso della tua azienda. 
<br>
<br>
<br>
</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>