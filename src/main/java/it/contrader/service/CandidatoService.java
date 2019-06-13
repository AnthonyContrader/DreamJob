package it.contrader.service;

import java.util.List;

import it.contrader.dao.CandidatoDAO;
import it.contrader.model.Candidato;

public class CandidatoService {

	private CandidatoDAO candidatoDAO;

	public CandidatoService() {
		this.candidatoDAO = new CandidatoDAO();
	}

	public List<Candidato> getAll() {
		return this.candidatoDAO.getAllCandidato();
	}

	//chiama il metodo del DAO che restituisce uno candidato in base al suo id
	public Candidato read(int id) {
		return this.candidatoDAO.readCandidato(id);
	}

	//chiama il metodo del DAO che cancella uno candidato in base al suo id
	public boolean delete(int Id) {
		return candidatoDAO.deleteCandidato(Id);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto Candidato
	public boolean insert(Candidato candidato) {
		return candidatoDAO.insertCandidato(candidato);
	}

	//chiama il metodo del DAO che modifica un candidato
	public boolean update(Candidato candidato) {
		return candidatoDAO.updateCandidato(candidato);
	}
	
}
