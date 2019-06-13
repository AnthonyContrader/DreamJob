package it.contrader.controller;

import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.UserService;

public class UserController implements Controller {
	//già cìè una classe me ne devo creare un'altra

	private static String sub_package = "user.";
	private UserService usersService;
	private Request request;

	public UserController() {
		this.usersService = new UserService();
	}

	public List<User> getAllUser() {
		return this.usersService.getAllUser();
		//crea la lista di tutti gli utenti
	}

	public UserDTO readUser(int userId) {
		return this.usersService.readUser(userId);
		//visualizza utente tramite id
	}

	public boolean insertUser(UserDTO usersDTO) {
		return this.usersService.insertUser(usersDTO);
		//inserisce nuovo utente
	}

	public boolean updateUser(UserDTO usersDTO) {
		return this.usersService.updateUser(usersDTO);
		//aggiorna dati utente
	}

	public boolean deleteUser(Integer usersId) {
		return this.usersService.deleteUser(usersId);
		//cancella l'utente in base a id
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("User", null);
		} else
		{
	
			switch (choice.toUpperCase()) {
			//scelta, in base alla scelta vai alla view chiamata
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "UserInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				//torna indietro al login
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
