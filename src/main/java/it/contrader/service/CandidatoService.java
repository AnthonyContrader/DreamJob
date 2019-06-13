package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterCandidato;

import it.contrader.dao.CandidatoDAO;

import it.contrader.dto.CandidatoDTO;

import it.contrader.model.Candidato;


public class CandidatoService {

	private CandidatoDAO candidatoDAO;

	public CandidatoService() {
		this.candidatoDAO = new CandidatoDAO();
	}

	public List<Candidato> getAllCandidato() {
		return this.candidatoDAO.getAllCandidato();
	}

	public boolean insertCandidato(CandidatoDTO candidatoDTO) {
		return this.candidatoDAO.insertCandidato(ConverterCandidato.toEntity(candidatoDTO));
	}
	
	public CandidatoDTO readCandidato(int Id) {
		return ConverterCandidato.toDTO(this.candidatoDAO.readCandidato(Id));
	}
	
	public boolean updateCandidato(CandidatoDTO candidatoDTO) {
		return this.candidatoDAO.updateCandidato(ConverterCandidato.toEntity(candidatoDTO));
	}
	
	public boolean deleteCandidato(int Id) {
		return this.candidatoDAO.deleteCandidato(Id);
	}
	
	
}
