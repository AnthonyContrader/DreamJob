<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CandidatoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Candidato Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homecandidato.jsp">Home</a>
  <a class="active" href="CandidatoServlet?mode=read">Profilo</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<div class="row">
	

<br>

	<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Age</th>
			<th>Education</th>
			<th>Experience</th>
			<th>id</th>
			<th></th>
		</tr>
		<%CandidatoDTO u = (CandidatoDTO) request.getAttribute("dto");%>
		<tr>
			<td>
					<%=u.getUsername()%>
			</td>
			
			<td>
					<%=u.getPassword()%>
			</td>
			
			<td>
					<%=u.getName()%>
			</td>
			
			<td>
					<%=u.getSurname()%>
			</td>
			
			
			<td>
					<%=u.getAge()%>
			</td>
			
			<td>
					<%=u.getEducation()%>
			</td>
			
			<td>
					<%=u.getExperience()%>
			</td>
			<td>
					<%=u.getId()%>
			</td>
			<td><a href=CandidatoServlet?mode=read&update=true&id=<%=u.getId()%>>Modifica</a>
			</td>
			
		</tr>
		
	</table>
</div>
</div>	
<%@ include file="../css/footer.jsp" %>
</body>
</html>