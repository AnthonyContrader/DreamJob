package it.contrader.service;

import java.util.List;

import it.contrader.dao.UserDAO;
import it.contrader.model.User;

public class UserService {

	private UserDAO userDAO;
	/**
	 * Costruisce un oggetto di tipo UserDAO per poterne usare i metodi
	 */
	public UserService() {
		this.userDAO = new UserDAO();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti gli user
	public List<User> getAll() {
		return this.userDAO.getAllUser();
	}
	
	//chiama il metodo del DAO che restituisce uno user in base al suo id
	public User read(int id) {
		return this.userDAO.readUser(id);
	}

	//chiama il metodo del DAO che cancella uno user in base al suo id
	public boolean delete(int Id) {
		return userDAO.deleteUser(Id);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto User
	public boolean insert(User user) {
		return userDAO.insertUser(user);
	}

	//chiama il metodo del DAO che modifica un utente
	public boolean update(User user) {
		return userDAO.updateUser(user);
	}


}