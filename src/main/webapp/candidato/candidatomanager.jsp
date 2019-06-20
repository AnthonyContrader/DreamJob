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
  <a class="active" href="CandidatoServlet?mode=candidatolist">Candidati</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<div class="row">
	<%
		List<CandidatoDTO> list = (List<CandidatoDTO>) request.getAttribute("list");
	%>

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
			<th></th>
			<th></th>
		</tr>
		<%
			for (CandidatoDTO u : list) {
		%>
		<tr>
			<td><a href=CandidatoServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getUsername()%>
			</a></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getSurname()%></td>
			<td><%=u.getAge()%></td>
			<td><%=u.getEducation()%></td>
			<td><%=u.getExperience()%></td>
			<td><a href=CandidatoServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
</div>

<div class="row">
	<form id="floatright" action="CandidatoServlet?mode=update" method="post">
	  <div class="row">
	    <div class="col-25">
	      <label for="candidato">Username</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="candidato" name="username" placeholder="inserisci username">
	    </div>
	  </div>
	  
	  <div class="row">
	    <div class="col-25">
	     <label for="pass">Password</label>
	    </div>
	    <div class="col-75">
	      <input type="password" id="pass" name="password" placeholder="inserisci password"> 
	    </div>
	  </div>
	  
	  <div class="row">
	    <div class="col-25">
	      <label for="type">Name</label>
	      </div>
	    <div class="col-75">
	      <input type="text" id="name" name="name" placeholder="inserisci nome"> 
	    </div>
	  </div>
	  
	    <div class="row">
	    <div class="col-25">
	      <label for="type">Surname</label>
	      </div>
	    <div class="col-75">
	      <input type="text" id="surname" name="surname" placeholder="inserisci cognome"> 
	    </div>
	  </div>
	  
	    <div class="row">
	    <div class="col-25">
	      <label for="type">Age</label>
	      </div>
	    <div class="col-75">
	      <input type="text" id="age" name="age" placeholder="inserisci età"> 
	    </div>
	  </div>
	  
	      <div class="row">
	    <div class="col-25">
	      <label for="type">Education</label>
	      </div>
	    <div class="col-75">
	      <input type="text" id="education" name="education" placeholder="inserisci studi"> 
	    </div>
	  </div>
	  
	    <div class="row">
	    <div class="col-25">
	      <label for="type">Experience</label>
	      </div>
	    <div class="col-75">
	      <input type="text" id="experience" name="experience" placeholder="inserisci esperienze"> 
	    </div>
	  </div>
	  <div class="row">
  	<button type="submit" value="pulsante" name="pulsante">Modifica Profilo</button>
	</div>
	</form>
</div>	
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>