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
          <label>AZIENDA</label>
        </li>
        <li>
          <label>MENU</label>
        </li>
        <li>
          <a href ="companyManagement" class = "btn btn-lg btn-primary btn-block" role = "button">Indietro</a>
        </li>
      </ul>
  </div>
  <div class="column content" id="visualizzazione">
		<div class="col-md-8 themed-grid-col data-header" >
      <form action="/Openjob/creaOpenjob" method="post" class="register" novalidate="novalidate">
      
		      <p class="form-row-wide">
		        <label for="reg_titolo">Titolo <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="titolo" id="titolo" placeholder="inserisci titolo" value="" required="">
		      </p>
		      
		      <p class="form-row-wide">
		        <label for="reg_descrizione">Descrizione <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="descrizione" id="descrizione" placeholder="inserisci descrizione" required="">
		      </p>
		      
		        <p class="form-row-wide">
		        <label for="reg_requisiti">Requisiti <span class="required">*</span></label>
		        <input type="text" class="input-text form-control " name="requisiti" id="requisiti" placeholder="inserisci requisiti" required="">
		      </p>
		      
		      
		          <p class="form-row">
		              <button class="btn btn-lg btn-primary btn-block" type="submit">Aggiungi Posizione</button>
		          <div class="invalid-feedback">This field is required</div></p>


      </form>
    </div>


  </div>
</div>
</body>
</html>