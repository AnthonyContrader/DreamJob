package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Company;
import it.contrader.service.CompanyService;

public class CompanyController implements Controller {

	/**
	 * definisce il pacchetto di vista company.
	 */
	private static String sub_package = "company.";
	
	private CompanyService companyService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public CompanyController() {
		this.companyService = new CompanyService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		String info;
		String openjob;
		String password;
		String username;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			Company company = companyService.read(id);
			request.put("company", company);
			MainDispatcher.getInstance().callView(sub_package + "CompanyRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			info = request.get("info").toString();
			openjob = request.get("openjob").toString();
			password = request.get("password").toString();
			username = request.get ("username").toString();
			
			//costruisce l'oggetto company da inserire
			Company companytoinsert = new Company(name, info, openjob, username, password, "company");
			//invoca il service
			companyService.insert(companytoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView("company.CompanyInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			companyService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView("company.CompanyDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			info = request.get("info").toString();
			openjob = request.get("openjob").toString();
			password = request.get("password").toString();
			username = request.get ("username").toString();
			Company companytoupdate = new Company(name, info, openjob, username, password, "company");
			companytoupdate.setId(id);
			companyService.update(companytoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView("company.CompanyUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "COMPANYLIST":
			List<Company> companys = companyService.getAll();
			//Impacchetta la request con la lista degi company
			request.put("companys", companys);
			MainDispatcher.getInstance().callView("Company", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CompanyRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CompanyInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CompanyUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CompanyDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}

