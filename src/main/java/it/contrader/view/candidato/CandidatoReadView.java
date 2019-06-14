package it.contrader.view.candidato;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Candidato;
import it.contrader.view.AbstractView;
import it.contrader.view.View;

public class CandidatoReadView extends AbstractView implements View {

	private int id;
	private Request request;
	private final String mode = "READ";

	public CandidatoReadView() {
	}
	
	public void showResults(Request request) {
		if (request != null) {
			Candidato candidato = (Candidato) request.get("candidato");
			System.out.println(candidato);
			MainDispatcher.getInstance().callView("Candidato", null);
		}
	}
	
	public void showOptions() {
		System.out.println("Inserisci l'ID del candidato:");
		id = Integer.parseInt(getInput());
	}

	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Candidato", "doControl", request);
	}
	
}
