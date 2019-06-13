package it.contrader.controller;

import java.util.List;


import it.contrader.main.MainDispatcher;
import it.contrader.model.Candidato;
import it.contrader.service.CandidatoService;

public class CandidatoController implements Controller {

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "user.";
	
	private CandidatoService candidatoService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public CandidatoController() {
		this.candidatoService = new CandidatoService();
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
		String surname;
		int age;
		String education;
		String experience;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			Candidato candidato = candidatoService.read(id);
			request.put("candidato", candidato);
			MainDispatcher.getInstance().callView(sub_package + "CandidatoRead", request);
			break;
		
		// Arriva qui dalla cANDIDATOInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			education = request.get("education").toString();			
			experience = request.get("experience").toString();

			
			//costruisce l'oggetto CANDIDATO da inserire
			Candidato candidatotoinsert = new Candidato(name, surname, age, education, experience);
			//invoca il service
			candidatoService.insert(candidatotoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "UserInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id CANDIDATO da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			candidatoService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			education = request.get("education").toString();
			experience = request.get("experience").toString();
			Candidato candidatotoupdate = new Candidato(name, surname, age, education, experience);
			candidatotoupdate.setId(id);
			candidatoService.update(candidatotoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CandidatoUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "CANDIDATOSLIST":
			List<Candidato> candidatos = candidatoService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("candidatos", candidatos);
			MainDispatcher.getInstance().callView("Candidato", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CandidatoRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CandidatoInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CandidatoUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CandidatoDelete", null);
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

