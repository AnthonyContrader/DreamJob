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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	
	
	
}
