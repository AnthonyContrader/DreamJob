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
public class CompanyDTO {
	
	private int id;
	private String name;
	private String info;
	private String username;
	private String password;
	private String openjob;
	private String candidato;

	
	public CompanyDTO() {
		
	}

	public CompanyDTO (String name, String info, String username, String password, String openjob, String candidato) {
		this.name = name;
		this.info = info;
		this.username = username;
		this.password = password;
		this.openjob = openjob;
		this.candidato = candidato;
	}

	public CompanyDTO (int id, String name, String info, String username, String password, String openjob, String candidato) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.username = username;
		this.password = password;
		this.openjob = openjob;
		this.candidato = candidato;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getOpenjob() {
		return this.openjob;
	}

	public void setOpenjob(String openjob) {
		this.openjob = openjob;
	}	
	public String getCandidato() {
		return this.candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}



	@Override
	public String toString() {
		return  id + "\t"  + name +"\t" +   info + "\t" + username + "\t"  + password + "\t"  + openjob + "\t"  + candidato;
	}
}
