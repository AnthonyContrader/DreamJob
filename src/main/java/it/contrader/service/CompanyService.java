package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterCompany;

import it.contrader.dao.CompanyDAO;

import it.contrader.dto.CompanyDTO;

import it.contrader.model.Company;


public class CompanyService {

	private CompanyDAO companyDAO;

	public CompanyService() {
		this.companyDAO = new CompanyDAO();
	}

	public List<Company> getAllCompany() {
		return this.companyDAO.getAllCompany();
	}

	public boolean insertCompany(CompanyDTO companyDTO) {
		return this.companyDAO.insertCompany(ConverterCompany.toEntity(companyDTO));
	}
	
	public CompanyDTO readCompany(int Id) {
		return ConverterCompany.toDTO(this.companyDAO.readCompany(Id));
	}
	
	public boolean updateCompany(CompanyDTO companyDTO) {
		return this.companyDAO.updateCompany(ConverterCompany.toEntity(companyDTO));
	}
	
	public boolean deleteCompany(int Id) {
		return this.companyDAO.deleteCompany(Id);
	}
	
	
}
