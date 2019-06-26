package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RisultatoDTO {

	private Integer id;
	
	private String descrizione;
	
	private Integer idOpenjob;
	
	private Integer idCandidato;
	
	
}
