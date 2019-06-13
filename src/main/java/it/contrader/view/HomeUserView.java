package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;

	public void showResults(Request request) {
		System.out.println("/n-----Purtroppo in questo sample l'utente non puà fare nulla, ci scusiamo per il disagio.-----");

	}

	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("[U]tenti  [E]sci");
		System.out.println("/n Esatto, puoi solo uscire...");
		choice = this.getInput();

	}

	public void submit() {

		switch (choice) {

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
