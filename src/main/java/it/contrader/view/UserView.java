package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class UserView extends AbstractView {

	private Request request;
	private String choice;

	public UserView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
			System.out.println("ID\tUsername\tPassword\tTipo Utente");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) request.get("users");
			for (User u: users)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		

		
	}
	


	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}

}