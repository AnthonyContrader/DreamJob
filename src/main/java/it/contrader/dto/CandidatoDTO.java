package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //crea in automatico i get e i set
@AllArgsConstructor //crea il costruttore pieno
@NoArgsConstructor  //crea il costruttore vuoto
public class CandidatoDTO {

	private Integer id;

	private String username;
	
	private String password;

	private String name;
	
	private String surname;
	
	private Integer age;
	
	private String tipolaurea;
	
	private String experience;
	
	private Integer idRisultato; //indica il legame con l'entità Risultato
	
}
