<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- Custom styles for this template -->
<link href="/Stile.css" rel="stylesheet" type="text/css">
</head>

<body>

<h3>Da questa pagina puoi visualizzare tutti gli utenti iscritti alla piattaforma.</h3>
<br>
<br>

<%
		List<UserDTO> list = (List<UserDTO>) request.getAttribute("read");
	 %>

<table>
					<tr><th>Id</th><th>Username</th><th>Password</th><th>Usertype</th></tr>
						<%
							for(UserDTO u: list){
						 %>
		 			<tr>
		 				<td><%=u.getId()%></td>
		 				<td><%=u.getUsername()%></td>
		 				<td><%=u.getPassword()%></td>
		 				<td><%=u.getUsertype()%></td>
		 				<td><a href="/User/delete?id=<%=u.getId() %>">Elimina</a></td>
		 				<td><a href="/User/redirectUpdate?id=<%=u.getId()%>">Modifica</a></td>
		 			</tr>
						<% 
							}
						%>
				</table>
</body>
</html>