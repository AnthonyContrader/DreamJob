package it.contrader.model;

public class Company extends User{
	private String name;
	private String info;
	private String openjob;


	public Company() {}
	//costruttore vuoto, stringa inizializzata vuota
	
	public Company(String name, String info, String openjob, String username, String password,String usertype) {
		super(username,password,usertype);
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

	public String toString() {
		return this.getId() + "\t" + this.getInfo() + "\t" + 
				this.getOpenjob();
	}

	
}
