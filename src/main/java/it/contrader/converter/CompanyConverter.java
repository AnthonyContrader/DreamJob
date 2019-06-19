package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;


/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class CompanyConverter  implements Converter<Company, CompanyDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public CompanyDTO toDTO(Company company) {
		CompanyDTO companyDTO = new CompanyDTO ( company.getName(), company.getInfo(), company.getUsername(), company.getPassword(), company.getOpenjob(), company.getCandidato());
		return companyDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Company toEntity(CompanyDTO companyDTO) {
		Company company = new Company(companyDTO.getId(), companyDTO.getName(), companyDTO.getInfo(), companyDTO.getUsername(), companyDTO.getPassword(), companyDTO.getOpenjob(), companyDTO.getCandidato());
		return company;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<CompanyDTO> toDTOList(List<Company> companysList) {
		//Crea una lista vuota.
		List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Company company : companysList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			companyDTOList.add(toDTO(company));
		}
		return companyDTOList;
	}

	
	
}
