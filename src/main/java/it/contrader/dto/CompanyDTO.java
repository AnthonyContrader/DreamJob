package it.contrader.dto;

public class CompanyDTO {

	private String name;
	private String info;
	private String openjob;
	
	public CompanyDTO()
	{
		
	//costruttore vuoto, usato per creare l'oggetto di una classe
		}
	

	public CompanyDTO(String name, String info, String openjob) {
		super();
		this.name = name;
		this.info = info;
		this.openjob = openjob;
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

	public String getOpenjob() {
		return openjob;
	}

	public void setOpenjob(String openjob) {
		this.openjob = openjob;
	}

	@Override
	public String toString() {
		return this.getName() + "\t" + this.getInfo() + "\t" + this.getOpenjob();
	}

}
