<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.OpenjobDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Open job Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="openjobServlet?mode=joblist">Open jobs</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<OpenjobDTO> list = (List<OpenjobDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>Requisiti</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (OpenjobDTO u : list) {
		%>
		<tr>
			<td><a href=OpenjobServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getTitolo()%>
			</a></td>
			
			<td><a href=OpenjobServlet?mode=read&id=<%=u.getId()%>>
			      <%=u.getDescrizione()%>
			      </a></td>
			      
			<td><a href=OpenjobServlet?mode=read&id=<%=u.getId()%>>
				<%=u.getRequisiti()%>
			</a></td>
			<td><a href=OpenjobServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=OpenjobServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="OpenjobServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="titolo">Titolo</label>
    </div>
    <div class="col-75">
      <input type="text" id="titolo" name="titolo" placeholder="Titolo posizione">
    </div>
  </div>

  <div class="row">
    <div class="col-25">
     <label for="descrizione">Descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione" name="descrizione" placeholder="inserisci descrizione posizione lavorativa"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="requisiti">Requisiti</label>
    </div>
    <div class="col-75">
      <input type="text" id="requisiti" name="requisiti" placeholder="inserisci requisiti posizione lavorativa"> 
    </div>
  </div>
</form>

</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>