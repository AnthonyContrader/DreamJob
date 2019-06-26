package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenjobDTO {

	private Integer id;

	private String titolo;
	
	private String descrizione;

	private String requisiti;
	
	private Integer idCompany;
	
	private Integer idRisultato;
	
}
