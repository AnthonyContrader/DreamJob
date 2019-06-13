package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserUpdateView implements View {

	private UserController userController;
	private Request request;

	public UserUpdateView() {
		this.userController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idToUpdate;
		String username, password, usertype;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UserDTO userDTO = new UserDTO();

		System.out.println("Digita l'Id dell'utente da modificare:");
		try {
			idToUpdate = Integer.parseInt(getInput());
			if (idToUpdate != 0) {
				userDTO.setId(idToUpdate);

				System.out.println("Digita la nuova username:");
				username = getInput();
				if (!username.equals(""))
					userDTO.setUsername(username);
				System.out.println("Digita la nuova password:");
				password = getInput();
				if (!password.equals(""))
					userDTO.setPassword(password);
				System.out.println("Digita la nuova usertype:");
				usertype = getInput();
				if (!usertype.equals(""))
					userDTO.setUsertype(usertype);
				
				userController.updateUser(userDTO);

			}
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
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
