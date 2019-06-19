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
    <div class="col-25">
      <label for="candidato">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="candidato" name="username" value=<%=u.getUsername()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input
			type="password" id="pass" name="password" value=<%=u.getPassword()%>> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="candidato">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="candidato">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" value=<%=u.getSurname()%>>
    </div>
  </div>

 <div class="row">
    <div class="col-25">
      <label for="candidato">Age</label>
    </div>
    <div class="col-75">
      <input type="number" id="age" name="age" value=<%=u.getAge()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="candidato">Education</label>
    </div>
    <div class="col-75">
      <input type="text" id="education" name="education" value=<%=u.getEducation()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="candidato">Experience</label>
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