package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CandidatoRepository;
import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;


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
public class CandidatoService extends AbstractService<Candidato,CandidatoDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public CandidatoDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((CandidatoRepository)repository).findByUsernameAndPassword(username, password));
	}

	public CandidatoDTO findByUsername(String username) {
		return converter.toDTO(((CandidatoRepository)repository).findByUsername(username));
	}
}
