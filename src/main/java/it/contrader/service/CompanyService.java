package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CompanyRepository;
import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;
import it.contrader.model.Openjob;


/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class CompanyService extends AbstractService<Company,CompanyDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public CompanyDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((CompanyRepository)repository).findByUsernameAndPassword(username, password));
	}
	
	public CompanyDTO findByUsername(String username) {
		return converter.toDTO(((CompanyRepository)repository).findByUsername(username));
	}
	
	public CompanyDTO findByOpenjob(Openjob o) {
		return converter.toDTO(((CompanyRepository)repository).findByOpenjob(o));
	}

}
