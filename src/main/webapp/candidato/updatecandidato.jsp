<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CandidatoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Candidato</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homecandidato.jsp">Home</a>
  <a class="active" href="CandidatoServlet?mode=candidatolist">Candidati</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CandidatoDTO u = (CandidatoDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CandidatoServlet?mode=update&id=<%=u.getId()%>" method="post">
 <div class="row">
    <div class="col-75" style="display:none;visibility:hidden;">
      <input type="text" id="candidato" name="id" value=<%=u.getId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="username">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="candidato" name="username" value=<%=u.getUsername()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="password">Password</label>
    </div>
    <div class="col-75">
      <input
			type="password" id="pass" name="password" value=<%=u.getPassword()%>> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="surname">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" value=<%=u.getSurname()%>>
    </div>
  </div>

 <div class="row">
    <div class="col-25">
      <label for="age">Age</label>
    </div>
    <div class="col-75">
      <input type="number" id="age" name="age" value=<%=u.getAge()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="education">Education</label>
    </div>
    <div class="col-75">
      <input type="text" id="education" name="education" value=<%=u.getEducation()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="experience">Experience</label>
    </div>
    <div class="col-75">
      <input type="text" id="experience" name="experience" value=<%=u.getExperience()%>>
    </div>
  </div>
 
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>