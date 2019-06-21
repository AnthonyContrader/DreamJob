package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class CandidatoDTO {
	
	private int id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	private String education;
	private String experience;

	
	public CandidatoDTO() {
		
	}

	public CandidatoDTO (String username, String password, String name, String surname, int age, String education, String experience) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.education = education;
		this.experience = experience;
	}

	public CandidatoDTO (int id, String username, String password, int age, String name, String surname, String education, String experience) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.education = education;
		this.experience = experience;
	}



	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}	
	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}



	@Override
	public String toString() {
		return  id + "\t"  + username +"\t" +   password + "\t" + name + "\t"  + surname + "\t"  + age + "\t"  + education + "\t"  + experience;
	}
}
