package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;


/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class CandidatoConverter  implements Converter<Candidato, CandidatoDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public CandidatoDTO toDTO(Candidato candidato) {
		CandidatoDTO candidatoDTO = new CandidatoDTO ( candidato.getUsername(), candidato.getPassword(), candidato.getName(), candidato.getSurname(), candidato.getEducation(), candidato.getExperience());
		return candidatoDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Candidato toEntity(CandidatoDTO candidatoDTO) {
		Candidato candidato = new Candidato(candidatoDTO.getId(), candidatoDTO.getUsername(), candidatoDTO.getPassword(), candidatoDTO.getName(), candidatoDTO.getAge(), candidatoDTO.getSurname(), candidatoDTO.getEducation(), candidatoDTO.getExperience());
		return candidato;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<CandidatoDTO> toDTOList(List<Candidato> candidatoList) {
		//Crea una lista vuota.
		List<CandidatoDTO> candidatoDTOList = new ArrayList<CandidatoDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Candidato candidato : candidatoList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			candidatoDTOList.add(toDTO(candidato));
		}
		return candidatoDTOList;
	}

	
	
}
