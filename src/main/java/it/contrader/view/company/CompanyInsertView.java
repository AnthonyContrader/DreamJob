package it.contrader.view.company;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.view.View;

public class CompanyInsertView extends AbstractView implements View  {
	private Request request;
	

	private String name;
	private String info;
	private String openjob;
	private final String mode = "INSERT";
	private String password;
	private String username;

	public CompanyInsertView() {
	}

	public void showResults(Request request) {
	if (request!=null) {
		System.out.println("Inserimento andato a buon fine.\n");
		MainDispatcher.getInstance().callView("HomeAdmin", null);
	}
}

/**
 * Chiede all'utente di inserire gli attributi dell'utente da inserire
 */
public void showOptions() {
		System.out.println("Inserisci il nome dell'azienda:");
		name = getInput();
		System.out.println("Inserisci le informazione dell'azienda:");
		info = getInput();
		System.out.println("Inserisci le posizioni aperte dell'azienda:");
		openjob = getInput();
		System.out.println("Inserisci password della comapny:");
		password = getInput();
		System.out.println("Inserisci username del company:");
		username = getInput();
}

/**
 * Impacchetta la request con i dati inseriti nel metodo showOption()
 */
public void submit() {
	request = new Request();
	request.put("name", name);
	request.put("info", info);
	request.put("openjob", openjob);
	request.put("mode", "INSERT");
	request.put("password", password);
	request.put("username", username);
	MainDispatcher.getInstance().callAction("Company", "doControl", request);
}


}
