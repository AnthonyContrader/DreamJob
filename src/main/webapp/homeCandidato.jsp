<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.io.*,java.net.*"%>

<html>
<head> 
<meta charset="ISO-8859-1">
<link href= "Stile.css" rel="stylesheet" media = "screen">
<link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="/prova.css" rel="stylesheet" type="text/css">
<title>Candidato view</title>
</head>

<body class="text-center">
<h1>Benvenuto Candidato</h1>
<h2>Benvenuto su DreamJob, questo portale ti aiutera´ a trovare il lavoro dei tuoi sogni.</h2>

<%
		UserDTO userDTO = (UserDTO) session.getAttribute("utenteCollegato");
	%>
	<div class="clearfix" id="corpo">
		<div class="header" id="intestazione">
			<h1>DreamJob</h1>
		</div>

		<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Age</th>
			<th>Tipo Laurea</th>
			<th>Experience</th>
			<th>id</th>
			<th></th>
		</tr>
		<%CandidatoDTO u = (CandidatoDTO) request.getAttribute("dto");%>
		<tr>
			<td><%=u.getUsername()%></td>
			
			<td><%=u.getPassword()%></td>
			
			<td><%=u.getName()%></td>
			
			<td><%=u.getSurname()%></td>
			
			
			<td><%=u.getAge()%></td>
			
			<td><%=u.getTipolaurea()%></td>
			
			<td><%=u.getExperience()%></td>
			
			<td><%=u.getId()%></td>
			
			<td><a href=CandidatoService?mode=read&update=true&id=<%=u.getId()%> class=" btn btn-primary t-action">Modifica</a></td>
			
		</tr>
		
	</table>

		<div class="column menu intero" id="menu-destra">
			<ul style="list-style: none;">
				<li style="text-align: center">
				 <label> MENU</label></li>
				 
				 <li class="btMenu">
					<a href="/Candidato/read?id=<%=userDTO.getId() %>" class=" btn btn-primary t-action">Leggi Profilo</a>
				</li>

				<li class="btMenu">
					<a href="/Candidato/insert?id=<%=userDTO.getId() %>" class=" btn btn-primary t-action">Inserisci Profilo</a>
				</li>
			
				<li class="btMenu">
					<a href="/Home/logout" class=" btn btn-primary t-action">Logout</a>
				</li>
			</ul>
		</div>

		
	</div>

</body>
</html>