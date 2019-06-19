package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Company {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;
	private String name;
	private String info;
	private String username;
	private String password;
	private String openjob;
	private String candidato;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Company() {
		
	}

	public Company (String name, String info, String username, String password, String openjob, String candidato) {
		this.name = name;
		this.info = info;
		this.username = username;
		this.password = password;
		this.openjob = openjob;
		this.candidato = candidato;
	}

	public Company (int id, String name, String info, String username, String password, String openjob, String candidato) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.username = username;
		this.password = password;
		this.openjob = openjob;
		this.candidato = candidato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public String getOpenjob() {
		return openjob;
	}

	public void setOpenjob(String openjob) {
		this.openjob = openjob;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	
}
