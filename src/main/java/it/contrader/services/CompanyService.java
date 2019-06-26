package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCompany;
import it.contrader.dao.CompanyRepository;
import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;

@Service
public class CompanyService {

	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<CompanyDTO> getListaCompanyDTO() {
		return ConverterCompany.toListDTO((List<Company>) companyRepository.findAll());
	}

	public CompanyDTO getCompanyDTOById(Integer id) {
		return ConverterCompany.toDTO(companyRepository.findById(id).get());
	}

	public CompanyDTO getByUsernameAndPassword(String username, String password) {

		final Company company = companyRepository.findCompanyByUsernameAndPassword(username, password);

		return ConverterCompany.toDTO(company);
	}

	public boolean insertCompany(CompanyDTO companyDTO) {
		return companyRepository.save(ConverterCompany.toEntity(companyDTO)) != null;
	}

	public boolean updateCompany(CompanyDTO companyDTO) {
		return companyRepository.save(ConverterCompany.toEntity(companyDTO)) != null;
	}
	
	public void deleteCompanyById(Integer id) {
		companyRepository.deleteById(id);
	}
	
	public List<CompanyDTO> findCompanyDTOByUsername(String username) {
		
		final List<Company> list = companyRepository.findAllByUsername(username);
		final List<CompanyDTO> companyDTOs = new ArrayList<>();
		list.forEach(i -> companyDTOs.add(ConverterCompany.toDTO(i)));
		return companyDTOs;
		
	
	}
}
