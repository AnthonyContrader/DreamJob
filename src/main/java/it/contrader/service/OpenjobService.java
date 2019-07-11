package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.OpenjobRepository;
import it.contrader.dto.OpenjobDTO;
import it.contrader.model.Company;
import it.contrader.model.Openjob;

/**
 * Estende AbstractService con parametri User e UserDTO. Implementa il metodo di
 * login ed eredita quelli Abstract.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class OpenjobService extends AbstractService<Openjob, OpenjobDTO> {

	// ALL crud methods in AbstractService

	public List<OpenjobDTO> findAllByCompany(Company company) {
		return converter.toDTOList(((OpenjobRepository) repository).findAllByCompany(company));
	}
}
