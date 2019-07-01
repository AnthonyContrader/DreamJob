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

<h3>Da questa pagina puoi visualizzare le informazioni relative alla tua azienda.</h3>
<br>
<br>

	

	<table>
		<tr>
			<th>Name</th>
			<th>Info</th>

			
			
		</tr>
		
		<%List<CompanyDTO> list = (List<CompanyDTO>) request.getAttribute("list");%>
		<tr>
			<%for (CompanyDTO u:list) { %>
			<td><%=u.getName()%></td>
			<td><%=u.getInfo()%></td>
			
			
		<%} %>
		</tr>
		
	</table>
</body>
</html>