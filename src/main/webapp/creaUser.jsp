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

  <div class="column menu intero" id="menu-destra">
      <ul style="list-style: none;">
        <li>
          <label>Benvenuto</label>
        </li>
        <li>
          <label>ADMIN</label>
        </li>
        <li>
          <label>MENU</label>
        </li>
        <li>
          <a href ="userManagement" class = "btn btn-lg btn-primary btn-block" role = "button">Indietro</a>
        </li>
      </ul>
  </div>
  <div class="column content" id="visualizzazione">
		<div class="col-md-8 themed-grid-col data-header" >
      <form action="/User/creaUser" method="post" class="register" novalidate="novalidate">
      
		      <p class="form-row-wide">
		        <label for="reg_username">Username <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="username" id="username" placeholder="inserisci username" value="" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_password">Password <span class="required">*</span></label>
		        <input type="password" class="input-text form-control " name="password" id="password" placeholder="inserisci password" required="">
		      </p>
		      
		      <p class="form-row form-group user-usertype">
		        <label for="reg_sr_lastname" style="padding-right:10px">Tipo Utente <span class="required">*</span></label>
		          <label class="radio" style="padding-right:10px">
		           <input type="radio" name="usertype" value="admin" checked="checked"> Admin   </label>
		
		          <label class="radio">
		              <input type="radio" name="usertype" value="candidato"> Candidato    </label>
		              
		           <label class="radio">
		              <input type="radio" name="usertype" value="company"> Company   </label>
		      </p>
		
		          <p class="form-row">
		              <button class="btn btn-lg btn-primary btn-block" type="submit">Aggiungi utente</button>
		          <div class="invalid-feedback">This field is required</div></p>


      </form>
    </div>


  </div>
</div>
</body>
</html>