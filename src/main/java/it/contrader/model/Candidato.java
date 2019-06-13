package it.contrader.model;

public class Candidato {
	private int id;
	private String name;
	private String surname;
	private int age;
	private String education;
	private String experience;


	public Candidato() {}
	//costruttore vuoto, stringa inizializzata vuota
	
	public Candidato(String name, String surname, int age, String education, String experience) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.education = education;
		this.experience = experience;
		
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
		
	

	public String toString() {
		return this.getId() + "\t" + this.getName() + "\t" +  this.getSurname() + "\t" + 
				this.getAge() + "\t" + this.getEducation() + "\t" + this.getExperience();
	}

	
}
