<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CompanyDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Company</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeacompany.jsp">Home</a>
  <a class="active" href="ComapnyServlet?mode=companylist">Company</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CompanyDTO u = (CompanyDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CompanyServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-75" style="display:none;visibility:hidden;">
      <input type="text" id="company" name="id" value=<%=u.getId()%>>
    </div>
  </div>
  
  
  <div class="row">
    <div class="col-25">
      <label for="company">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="info">Info</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="info" name="info" value=<%=u.getInfo()%>> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="username">Username</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="username" name="username" value=<%=u.getUsername()%>> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="password">Password</label>
    </div>
    <div class="col-75">
      <input
			type="password" id="password" name="password" value=<%=u.getPassword()%>> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="openjob">Openjob</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="openjob" name="openjob" value=<%=u.getOpenjob()%>> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="candidato">Candidato</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="candidato" name="candidato" value=<%=u.getCandidato()%>> 
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>