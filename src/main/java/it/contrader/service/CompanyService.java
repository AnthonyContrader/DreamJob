package it.contrader.service;

import java.util.List;

import it.contrader.dao.CompanyDAO;
import it.contrader.model.Company;

public class CompanyService {

	private CompanyDAO companyDAO;
	/**
	 * Costruisce un oggetto di tipo CompanyDAO per poterne usare i metodi
	 */
	public CompanyService() {
		this.companyDAO = new CompanyDAO();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti gli user
	public List<Company> getAll() {
		return this.companyDAO.getAllCompany();
	}
	
	//chiama il metodo del DAO che restituisce uno user in base al suo id
	public Company read(int id) {
		return this.companyDAO.readCompany(id);
	}

	//chiama il metodo del DAO che cancella uno user in base al suo id
	public boolean delete(int Id) {
		return companyDAO.deleteCompany(Id);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto User
	public boolean insert(Company company) {
		return companyDAO.insertCompany(company);
	}

	//chiama il metodo del DAO che modifica un utente
	public boolean update(Company company) {
		return companyDAO.updateCompany(company);
	}


}
