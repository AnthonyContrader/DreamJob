package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView implements View {

	private String nomeUtente;
	private String password;

	public void showResults(Request request) {
		
	}

	public void showOptions() {
		System.out.println("----- .:LOGIN:. ----");
		System.out.println("Nome utente:");
		nomeUtente = getInput();
		//dammi la possib di scrivere dalla tastiera
		System.out.println("Password:");
		password = getInput();
	}

	public void submit() {
		//inizializzo array request che è indicizzato a stringhe
		Request request = new Request();
		//inserisco nell'array request nome utente e password
		request.put("username", nomeUtente);
		request.put("password", password);
		
		//chiama il Controller e gli passa l'array request cioè nomeutente e pass
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
		
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
