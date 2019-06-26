package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Company;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

	public Company findCompanyByUsernameAndPassword(String username,String password);
	public List<Company> findAllByUsername(String username);
}
