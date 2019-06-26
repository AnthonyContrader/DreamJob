package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Candidato;

import java.util.List;

public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {

	public Candidato findCandidatoByUsernameAndPassword(String username,String password);
	public List<Candidato> findAllByUsername(String username);
}
