package it.contrader.dto;

public class UserDTO {

	private String username;
	private String password;
	private String usertype;
	
	public UserDTO()
	{
		
	//costruttore vuoto, usato per creare l'oggetto di una classe
		}
	

	public UserDTO(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return this.getId() + "\t" + this.getUsername() + "\t" + this.getPassword() + "\t" + this.getUsertype();
	}

}
