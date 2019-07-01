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
<title>Company view</title>
</head>

<body class="text-center">
<h1>Benvenuta Azienda</h1>
<h2>Benvenuto su DreamJob, su questa piattaforma potrai trovare il candidato ideale per il progresso della tua azienda. </h2>

	<%
		UserDTO userDTO = (UserDTO) session.getAttribute("utenteCollegato");
	%>
	<div class="clearfix" id="corpo">
		<div class="header" id="intestazione">
			<h1>DreamJob</h1>
		</div>

		<div class="column menu intero" id="menu-destra">
			<ul style="list-style: none;">
				<li style="text-align: center">
				 <label> MENU</label></li>

				<li class="btMenu">
					<a href="/Company/crea?id=<%=userDTO.getId() %>" class=" btn btn-primary t-action">Inserisci Info</a>
				</li>
				
				<li class="btMenu">
					<a href="/Company/myCompany?id=<%=userDTO.getId() %>" class=" btn btn-primary t-action">Visualizza le informazioni aziendali</a>
				</li>
				
				<li class="btMenu">
					<a href="/Openjob/crea?id=<%=userDTO.getId() %>" class=" btn btn-primary t-action">Inserisci Open Job</a>
				</li>
				
				<li class="btMenu">
					<a href="/Openjob/myJobs?id=<%=userDTO.getId() %>" class=" btn btn-primary t-action">Visualizza Open Job</a>
				</li>
				
				<li class="btMenu">
					<a href="/Home/logout" class=" btn btn-primary t-action">Logout</a>
				</li>
			</ul>
		</div>

		
	</div>
</body>
</html>