<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CompanyDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Company</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="CompanyServlet?mode=companylist">Company</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%CompanyDTO u = (CompanyDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Info</th>
		<th>Username</th>
		<th>Password</th>
		<th>Openjob</th>
		<th>Candidato</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getInfo()%></td>
		<td> <%=u.getUsername()%></td>
		<td> <%=u.getPassword()%></td>
		<td> <%=u.getOpenjob()%></td>
		<td> <%=u.getCandidato()%></td>
		
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>