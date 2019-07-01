package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import it.contrader.model.Openjob;

import java.util.List;

public interface OpenjobRepository extends CrudRepository<Openjob, Integer> {

	public Openjob findOpenjobById(int id);
	public List<Openjob> findAllById(int id);
	public Openjob findOpenjobByTitolo(String titolo);
	public Openjob readById(int id);
	
	// questa è una query in HQL che presuppone Hibernate
	@Query("SELECT oJ FROM Openjob oJ WHERE oJ.id = :idCompany")
	public List<Openjob> findAllByIdCompany(int idCompany);
}
