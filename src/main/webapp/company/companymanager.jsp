<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CompanyDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Company Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homecompany.jsp">Home</a>
  <a class="active" href="CompanyServlet?mode=read">Profilo Azienda</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	

<br>

	<table>
		<tr>
		   
			<th>name</th>
			<th>info</th>
			<th>username</th>
			<th>password</th>
			<th>openjob</th>
			<th>candidato</th>
			<th>id</th>
			<th></th>
		</tr>
		<%CompanyDTO u = (CompanyDTO) request.getAttribute("dto");%>
		<tr>
			<td>
					<%=u.getName()%>
			</td>
			<td><%=u.getInfo()%></td>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getOpenjob().toString()%></td>
			<td><%=u.getCandidato().toString()%></td>
			<td><%=u.getId()%></td>
			
			<td><a href=CompanyServlet?mode=read&update=true&id=<%=u.getId()%>>Modifica</a>
			</td>
			

		</tr>
		
	</table>

<br>
<br>
<br>
  <br>
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>