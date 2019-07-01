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
          <label>CANDIDATO</label>
        </li>
        <li>
          <label>MENU</label>
        </li>
        <li>
          <a href ="candidatoManagement" class = "btn btn-lg btn-primary btn-block" role = "button">Indietro</a>
        </li>
      </ul>
  </div>
  <div class="column content" id="visualizzazione">
		<div class="col-md-8 themed-grid-col data-header" >
      <form action="/Candidato/creaCandidato" method="post" class="register" novalidate="novalidate">
      
		      <p class="form-row-wide">
		        <label for="reg_username">Username <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="username" id="username" placeholder="inserisci username" value="" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_password">Password <span class="required">*</span></label>
		        <input type="password" class="input-text form-control " name="password" id="password" placeholder="inserisci password" required="">
		      </p>
		      
		        <p class="form-row-wide">
		        <label for="reg_name">Name <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="name" id="name" placeholder="inserisci nome" required="">
		      </p>
		      
		        <p class="form-row-wide">
		        <label for="reg_surname">Surname <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="surname" id="surname" placeholder="inserisci cognome" required="">
		      </p>
		      
		        <p class="form-row-wide">
		        <label for="reg_age">Age <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="age" id="age" placeholder="inserisci età" required="">
		      </p>
		      
		        <p class="form-row-wide">
		        <label for="reg_tipolaurea">Tipolaurea <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="tipolaurea" id="ipolaurea" placeholder="inserisci il tipo di laurea" required="">
		      </p>
		      
		        <p class="form-row-wide">
		        <label for="reg_experience">Experience <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="experience" id="experience" placeholder="inserisci le tue esperienze lavorative" required="">
		      </p>
		      
		     
		 
		          <p class="form-row">
		              <button class="btn btn-lg btn-primary btn-block" type="submit">Aggiungi Profilo</button>
		          <div class="invalid-feedback">This field is required</div></p>


      </form>
    </div>


  </div>
</div>
</body>
</html>