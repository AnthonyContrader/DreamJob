package it.contrader.view.company;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CompanyUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private String info;
	private String openjob;
	private final String mode = "UPDATE";

	public CompanyUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Company", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */

	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'azienda:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci name dell'azienda:");
			name = getInput();
			System.out.println("Inserisci le informazioni dell'azienda:");
			info = getInput();
			System.out.println("Inserisci posizioi aperte dell'azienda:");
			openjob = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("info", info);
		request.put("openjob", openjob);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Company", "doControl", request);
	}

}
