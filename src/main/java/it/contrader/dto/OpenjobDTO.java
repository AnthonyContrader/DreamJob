package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenjobDTO {

	public OpenjobDTO(String titolo2, String descrizione2, String requisiti2) {
		this.setTitolo(titolo2);
		this.setDescrizione(descrizione2);
		this.setRequisiti(requisiti2);
		// TODO Auto-generated constructor stub
	}

	private Integer id;

	private String titolo;
	
	private String descrizione;

	private String requisiti;
	
	private Integer idCompany;
	
	private Integer idRisultato;
	
}
