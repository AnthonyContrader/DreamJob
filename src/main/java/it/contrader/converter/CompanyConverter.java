package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;


/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class CompanyConverter extends AbstractConverter<Company,CompanyDTO> {

	@Override
	public Company toEntity(CompanyDTO companyDTO) {
		Company company = null;
		if (companyDTO != null) {
			company = new Company(companyDTO.getId(),companyDTO.getUsername(),companyDTO.getPassword(),companyDTO.getName(),companyDTO.getInfo());			
		}
		return company;
	}

	@Override
	public CompanyDTO toDTO(Company company) {
		CompanyDTO companyDTO = null;
		if (company != null) {
			companyDTO = new CompanyDTO(company.getId(),company.getUsername(),company.getPassword(),company.getName(),company.getInfo());
			
		}
		return companyDTO;
	}
}