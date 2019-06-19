package it.contrader.service;

import it.contrader.converter.CandidatoConverter;
import it.contrader.dao.CandidatoDAO;
import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CandidatoService extends AbstractService<Candidato, CandidatoDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public CandidatoService(){
		this.dao = new CandidatoDAO();
		this.converter = new CandidatoConverter();
	}
	

}
