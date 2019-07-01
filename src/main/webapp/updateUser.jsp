<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>LOGIN PAGE</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- Custom styles for this template -->
<link href="/prova.css" rel="stylesheet" type="text/css">
</head>

<body class="text-center">
<div class="clearfix" id="corpo">
  <div class="header" id="intestazione">
    <h1>DreamJob</h1>
  </div>
  <%
	UserDTO u = (UserDTO) request.getAttribute("user");
%>
  
  <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/User/update">
			<input type="hidden" name="username" value="<%=u.getUsername()%>" />
			<input type="hidden" name="password" value="<%=u.getPassword()%>" />
			<input type="hidden" name="usertype" value="<%=u.getUsertype()%>" />
			<table class="table">

			<tr>
				<td><b>Username:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=u.getUsername()%>" /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td> 
				<td> <input type="password" size="40" maxlength="40" name="password" value="<%=u.getPassword()%>" /></td>
			</tr>
			<tr>
				<td><b>Usertype:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="usertype" value="<%=u.getUsertype()%>" /></td>
			</tr>
			
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/User/read">Back</a>

		</form>
            </div>
        </div>
  