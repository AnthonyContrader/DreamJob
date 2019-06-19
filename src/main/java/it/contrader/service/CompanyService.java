package it.contrader.service;

import it.contrader.converter.CompanyConverter;
import it.contrader.dao.CompanyDAO;
import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CompanyService extends AbstractService<Company, CompanyDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public CompanyService(){
		this.dao = new CompanyDAO();
		this.converter = new CompanyConverter();
	}
	

}
