package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Openjob;

import java.util.List;

public interface OpenjobRepository extends CrudRepository<Openjob, Integer> {

	public Openjob findOpenjobById(int id);
	public List<Openjob> findAllById(int id);
	public Openjob findOpenjobByTitolo(String titolo);
	public void readById(int id);
}
