package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Candidato {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	private String education;
	private String experience;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Candidato() {
		
	}

	public Candidato (String username, String password, String name, String surname, int age, String education, String experience) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.education = education;
		this.experience = experience;
	}

	public Candidato (int id, String username, String password, String name, String surname, int age, String education, String experience) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.education = education;
		this.experience = experience;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}
}
