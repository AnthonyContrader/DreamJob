<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.OpenjobDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Open job Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homecompany.jsp">Home</a>
  <a class="active" href="CompanyServlet?mode=read">Profilo Azienda</a>
  <a class="active">Open jobs</a>

  <a  href="homeopenjob.jsp">Home</a>
  <a class="active" href="OpenjobServlet?mode=joblist">Open jobs</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	
<br>

	<table>
		<tr>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>Requisiti</th>
			<th>id</th>
			<th></th>
		</tr>
		
		<%OpenjobDTO u = (OpenjobDTO) request.getAttribute("dto");%>
		<tr>

			
			<td><%=u.getTitolo()%></td>
			<td><%=u.getDescrizione()%></td>
			<td><%=u.getRequisiti()%></td>
			<td><%=u.getId()%></td>
			
			<td><a href=OpenjobServlet?mode=read&update=true&id=<%=u.getId()%>>Modifica</a>
			<td><a href=OpenjobServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getTitolo()%>
			</a></td>

			<td><%=u.getTitolo()%></td>
			<td><%=u.getDescrizione()%></td>
			<td><%=u.getRequisiti()%></td>
			<td><%=u.getId()%></td>
			
			<td><a href=OpenjobServlet?mode=read&update=true&id=<%=u.getId()%>>Modifica</a>
			</td>
			

		</tr>
		
	</table>




  
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
		
	