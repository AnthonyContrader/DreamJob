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
  <a class="active" href="CompanyServlet?mode=companylist">Companys</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<CompanyDTO> list = (List<CompanyDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		   
			<th>name</th>
			<th>info</th>
			<th>username</th>
			<th>password</th>
			<th>openjob</th>
			<th>candidato</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CompanyDTO u : list) {
		%>
		<tr>
			<td><a href=CompanyServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getName()%></td>
			<td><%=u.getInfo()%></td>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getOpenjob()%></td>
			<td><%=u.getCandidato()%></td>
			<td><a href=CompanyServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=CompanyServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<form id="floatright" action="CompanyServlet?mode=insert" method="post">



  <div class="row">
    <div class="col-25">
      <label for="company">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci name">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="info">Info</label>
    </div>
    <div class="col-75">
      <input type="text" id="info" name="info" placeholder="inserisci info"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="username">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="username" name="username" placeholder="inserisci username"> 
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
     <label for="openjob">Openjob</label>
    </div>
    <div class="col-75">
      <input type="text" id="openjob" name="openjob" placeholder="inserisci openjob"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="candidato">Candidato</label>
    </div>
    <div class="col-75">
      <input type="text" id="candidato" name="candidato" placeholder="inserisci candidato"> 
    </div>
  </div>
</form>
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>