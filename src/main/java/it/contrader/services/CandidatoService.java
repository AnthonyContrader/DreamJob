package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCandidato;
import it.contrader.dao.CandidatoRepository;
import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;

@Service
public class CandidatoService {

	private final CandidatoRepository candidatoRepository;

	@Autowired
	public CandidatoService(CandidatoRepository candidatoRepository) {
		this.candidatoRepository = candidatoRepository;
	}

	public List<CandidatoDTO> getListaCandidatoDTO() {
		return ConverterCandidato.toListDTO((List<Candidato>) candidatoRepository.findAll());
	}

	public CandidatoDTO getCandidatoDTOById(Integer id) {
		return ConverterCandidato.toDTO(candidatoRepository.findById(id).get());
	}

	public CandidatoDTO getByUsernameAndPassword(String username, String password) {

		final Candidato candidato = candidatoRepository.findCandidatoByUsernameAndPassword(username, password);

		return ConverterCandidato.toDTO(candidato);
	}
	
	public boolean readCandidato(CandidatoDTO candidatoDTO) {
		return candidatoRepository.save(ConverterCandidato.toEntity(candidatoDTO)) != null;
	}
	
	public boolean insertCandidato(CandidatoDTO candidatoDTO) {
		return candidatoRepository.save(ConverterCandidato.toEntity(candidatoDTO)) != null;
	}

	public boolean updateCandidato(CandidatoDTO candidatoDTO) {
		return candidatoRepository.save(ConverterCandidato.toEntity(candidatoDTO)) != null;
	}
	
	public void deleteCandidatoById(Integer id) {
		candidatoRepository.deleteById(id);
	}
	
	public List<CandidatoDTO> findCandidatoDTOByUsername(String username) {
		
		final List<Candidato> list = candidatoRepository.findAllByUsername(username);
		final List<CandidatoDTO> candidatoDTOs = new ArrayList<>();
		list.forEach(i -> candidatoDTOs.add(ConverterCandidato.toDTO(i)));
		return candidatoDTOs;
		
	
	}
}
