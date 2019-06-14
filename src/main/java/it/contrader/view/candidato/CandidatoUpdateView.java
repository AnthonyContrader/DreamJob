package it.contrader.view.candidato;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.view.View;

public class CandidatoUpdateView extends AbstractView implements View {

	private Request request;

	private int id;
	private String name;
	private String surname;
	private int age;
	private String education;
	private String experience;
	private final String mode = "UPDATE";
	
	public CandidatoUpdateView() {
	}
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Candidato", null);
		}
	}
	
	public void showOptions() {
		try {
			System.out.println("Inserisci id del candidato:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci name del candidato:");
			name = getInput();
			System.out.println("Inserisci surname del candidato:");
			surname = getInput();
			System.out.println("Inserisci l'eta del candidato:");
			age = Integer.parseInt(getInput());
			System.out.println("Inserisci istruzione del candidato:");
			education = getInput();
			System.out.println("Inserisci esperienze del candidato:");
			experience = getInput();
		} catch (Exception e) {

		}
	}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("surname", surname);
		request.put("age", age);
		request.put("education", education);
		request.put("experience", experience);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Candidato", "doControl", request);
	}
	
}
