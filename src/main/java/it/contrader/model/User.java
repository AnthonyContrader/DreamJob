package it.contrader.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String usertype;


	public User() {}
	//costruttore vuoto, stringa inizializzata vuota
	
	public User(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	
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

	public String toString() {
		return this.getId() + "\t" + this.getUsername() + "\t" +  this.getPassword() + "\t" + 
				this.getUsertype();
	}

	
}
