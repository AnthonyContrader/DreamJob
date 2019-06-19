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
public class OpenjobDTO {
	
	private int id;

	private String titolo;
	
	private String descrizione;
	
	private String requisiti;

	
	public OpenjobDTO() {
		
	}

	public OpenjobDTO (String titolo, String descrizione, String requisiti) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.requisiti = requisiti;
	}

	public OpenjobDTO (int id, String titolo, String descrizione, String requisiti) {
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.requisiti = requisiti;
	}

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

	public void setRequisiti(String requisiti) {
		this.requisiti = requisiti;
	}

	public String getRequisiti() {
		return requisiti;
	}

	@Override
	public String toString() {
		return  id + "\t"  + titolo +"\t\t" +   descrizione + "\t\t" + requisiti;
	}
}
