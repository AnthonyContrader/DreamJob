package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractConverter
 * @see Converter
 */
@Component
public class CompanyConverter extends AbstractConverter<Company, CompanyDTO> {

	@Override
	public Company toEntity(CompanyDTO companyDTO) {
		Company company = new Company();
		if (companyDTO != null) {
			company.setId(companyDTO.getId());
			company.setUsername(companyDTO.getUsername());
			company.setPassword(companyDTO.getPassword());
			company.setName(companyDTO.getName());
			company.setInfo(companyDTO.getInfo());
		}
		return company;
		
	}

	@Override
	public CompanyDTO toDTO(Company company) {
		CompanyDTO companyDTO = new CompanyDTO();
		if (company != null) {
			companyDTO.setId(company.getId());
			companyDTO.setUsername(company.getUsername());
			companyDTO.setPassword(company.getPassword());
			companyDTO.setName(company.getName());
			companyDTO.setInfo(company.getInfo());
		}
		return companyDTO;
	}
}