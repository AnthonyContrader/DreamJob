package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Risultato;

import java.util.List;

public interface RisultatoRepository extends CrudRepository<Risultato, Integer> {

	public Risultato findRisultatoById(int id);
	public List<Risultato> findAllById(int id);
	public Risultato findRisultatoByDescrizione(String descrizione);
	
}
