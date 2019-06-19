<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CandidatoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Candidato</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homecandidato.jsp">Home</a>
  <a class="active"  href="CandidatoServlet?mode=candidatolist">Candidati</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%CandidatoDTO u = (CandidatoDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Username</th>
		<th>Password</th>
		<th>Name</th>
		<th>Surname</th>
		<th>Age</th>
		<th>Education</th>
		<th>Experience</th>
	</tr>
	<tr>
		<td><%=u.getUsername()%></td>
		<td> <%=u.getPassword()%></td>
		<td> <%=u.getName()%></td>
		<td> <%=u.getSurname()%></td>
		<td> <%=u.getAge()%></td>
		<td> <%=u.getEducation()%></td>
		<td> <%=u.getExperience()%></td>
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