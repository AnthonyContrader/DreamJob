package it.contrader.dto;

public class CandidatoDTO {
	
	private String name;
	private String surname;
	private int age;
	private String education;
	private String experience;
	
	

	public CandidatoDTO(String name, String surname, int age, String education, String experience) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.education = education;
		this.experience = experience;
	}
	
	public CandidatoDTO() {} 
	
	

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

	public String getEperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
}