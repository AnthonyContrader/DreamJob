package it.contrader.view.candidato;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.view.View;

public class CandidatoInsertView extends AbstractView implements View {
	private Request request;

	private String name;
	private String surname;
	private int age;
	private String education;
	private String experience;
	private final String mode = "INSERT";
	private String password;
	private String username;
	
	public CandidatoInsertView() {
	}
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("HomeAdmin", null);
		}
	}
	
	public void showOptions() {
		System.out.println("Inserisci nome del candidato:");
		name = getInput();
		System.out.println("Inserisci cognome del candidato:");
		surname = getInput();
		System.out.println("Inserisci eta del candidato:");
		age = Integer.parseInt(getInput());
		System.out.println("Inserisci istruzione del candidato:");
		education = getInput();
		System.out.println("Inserisci esperienza del candidato:");
		experience = getInput();
		System.out.println("Inserisci password del candidato:");
		password = getInput();
		System.out.println("Inserisci username del candidato:");
		username = getInput();
	}
	
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("password", password);
		request.put("username", username);
		request.put("surname", surname);
		request.put("age", age);
		request.put("education", education);
		request.put("experience", experience);
		request.put("mode", "INSERT");
		MainDispatcher.getInstance().callAction("Candidato", "doControl", request);
	}
	
}
