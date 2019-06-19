package it.contrader.model;

public class Openjob {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String titolo;
	
	private String descrizione;
	
	private String requisiti;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Openjob() {
		
	}

	public Openjob (String titolo, String descrizione, String requisiti) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.requisiti = requisiti;
	}

	public Openjob (int id, String titolo, String descrizione, String requisiti) {
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.requisiti = requisiti;
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

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getRequisiti() {
		return requisiti;
	}
	
	public void setRequisiti(String requisiti) {
		this.requisiti = requisiti;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + titolo +"\t\t" +   descrizione + "\t\t" + requisiti;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Openjob other = (Openjob) obj;
		if (id != other.id)
			return false;
		
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} 
		
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} 
		
		if (requisiti == null) {
			if (other.requisiti != null)
				return false;
		}
		return true;
	}
	
}
