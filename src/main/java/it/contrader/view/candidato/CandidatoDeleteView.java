package it.contrader.view.candidato;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.view.View;

public class CandidatoDeleteView extends AbstractView implements View {

	private Request request;

	private int id;
	private final String mode = "DELETE";

	public CandidatoDeleteView() {
	}
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("HomeAdmin", null);
		}
	}
	
	public void showOptions() {
		System.out.println("Inserisci id del candidato:");
		id = Integer.parseInt(getInput());
	}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Candidato", "doControl", request);
	}
	
}
