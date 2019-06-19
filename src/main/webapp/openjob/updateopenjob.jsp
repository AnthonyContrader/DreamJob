<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OpenjobDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Open job</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="OpenjobServlet?mode=userlist">Open jobs</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%OpenjobDTO u = (OpenjobDTO) request.getAttribute("dto");%>


<form id="floatleft" action="OpenjobServlet?mode=update&id=<%=u.getId()%>" method="post">

  <div class="row">
    <div class="col-25">
      <label for="user">Titolo</label>
    </div>
    <div class="col-75">
      <input type="text" id="titolo" name="titolo" value=<%=u.getTitolo()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="pass">Descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione" name="descrizione" value=<%=u.getDescrizione()%>> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="type">Requisiti</label>
    </div>
   		 <div class="col-75">
		      <input type="text" id="requisiti" name="requisiti" value=<%=u.getRequisiti()%>> 
    	</div>
  </div>

<button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>