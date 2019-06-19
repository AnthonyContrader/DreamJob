package it.contrader.service;

import it.contrader.converter.OpenjobConverter;
import it.contrader.dao.OpenjobDAO;
import it.contrader.dto.OpenjobDTO;
import it.contrader.model.Openjob;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class OpenjobService extends AbstractService<Openjob, OpenjobDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public OpenjobService(){
		this.dao = new OpenjobDAO();
		this.converter = new OpenjobConverter();
	}
	

}
