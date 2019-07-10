package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.OpenjobRepository;
import it.contrader.dto.OpenjobDTO;
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
public class OpenjobService extends AbstractService<Openjob,OpenjobDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public OpenjobDTO findById(Integer id) {
		return converter.toDTO(((OpenjobRepository)repository).findById(id));
	}

	public OpenjobDTO findByIdCompany(Integer idCompany) {
		return converter.toDTO(((OpenjobRepository)repository).findByIdCompany(idCompany));
	}
}
