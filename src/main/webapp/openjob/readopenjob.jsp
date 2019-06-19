<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OpenjobDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Open job</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="OpenjobServlet?mode=userlist">Open jobs</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%OpenjobDTO u = (OpenjobDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Titolo</th>
		<th>Descrizione</th>
		<th>Requisiti</th>
	</tr>
	<tr>
		<td><%=u.getTitolo()%></td>
		<td> <%=u.getDescrizione()%></td>
		<td> <%=u.getRequisiti()%></td>
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