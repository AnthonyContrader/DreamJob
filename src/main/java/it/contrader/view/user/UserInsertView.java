package it.contrader.view.user;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;



public class UserInsertView implements View {

	private UserController usersController;
	private Request request;
	private String username ;
	private String password ;
	private String usertype ;

	
	public UserInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	
	
	
	@Override
	public void showOptions() {
		try {
			
		System.out.println("Inserisci i campi dell'utente:");
		System.out.println("Insersci l'username:");
		username = getInput();
		System.out.println("Digita la nuova password:");
		password = getInput();
		System.out.println("Digita la nuova usertype:");
		usertype = getInput();
		

		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
		}
		
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	public int getInt() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	

	
	@Override
	public void submit() {
		request = new Request();
		request.put("username", username);
		request.put("password", password);
		request.put("usertype", usertype);
		request.put("mode", "INSERT");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
