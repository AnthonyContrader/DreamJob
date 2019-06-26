package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;


public class ConverterCompany {

	public static CompanyDTO toDTO(Company company) {
		CompanyDTO companyDTO = null;
		if (company != null) {
			companyDTO = new CompanyDTO();
	        
			companyDTO.setId(company.getId());
			companyDTO.setUsername(company.getUsername());
			companyDTO.setPassword(company.getPassword());
			companyDTO.setName(company.getName());
			companyDTO.setInfo(company.getInfo());
			
		}
		return companyDTO;
	}

	public static Company toEntity(CompanyDTO companyDTO) {
		Company company = null;
		if (companyDTO != null) {
			company = new Company();
			company.setId(companyDTO.getId());
			company.setUsername(companyDTO.getUsername());
			company.setPassword(companyDTO.getPassword());
			company.setName(companyDTO.getName());
			company.setInfo(companyDTO.getInfo());
			
		}
		return company;
	}

	public static List<CompanyDTO> toListDTO(List<Company> list) {
		List<CompanyDTO> listCompanyDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Company company : list) {
				listCompanyDTO.add(ConverterCompany.toDTO(company));
			}
		}
		return listCompanyDTO;
	}

	public static List<Company> toListEntity(List<CompanyDTO> listCompanyDTO) {
		List<Company> list = new ArrayList<>();
		if (!listCompanyDTO.isEmpty()) {
			for (CompanyDTO companyDTO : listCompanyDTO) {
				list.add(ConverterCompany.toEntity(companyDTO));
			}
		}
		return list;
	}
}
