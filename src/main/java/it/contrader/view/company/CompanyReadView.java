package it.contrader.view.company;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Company;
import it.contrader.view.AbstractView;
import it.contrader.view.View;

public class CompanyReadView extends AbstractView implements View {

private int id;
private Request request;
private final String mode = "READ";

public CompanyReadView() {
}

/**
 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
 * il metodo è vuoto.
 * 
 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
 * gli altri due metodi
 */

public void showResults(Request request) {
	if (request != null) {
		Company company = (Company) request.get("company");
		System.out.println(company);
		MainDispatcher.getInstance().callView("Company", null);
	}
}


/**
 * chiede all'utente di inserire l'id dell'utente da leggere
 */
public void showOptions() {
	System.out.println("Inserisci l'ID dell'azienda:");
	id = Integer.parseInt(getInput());
}

/**
 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
 */
public void submit() {
	request = new Request();
	request.put("id", id);
	request.put("mode", mode);
	MainDispatcher.getInstance().callAction("Company", "doControl", request);
}

}
