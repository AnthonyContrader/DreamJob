package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;


/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class CandidatoConverter extends AbstractConverter<Candidato,CandidatoDTO> {

	@Override
	public Candidato toEntity(CandidatoDTO candidatoDTO) {
		Candidato candidato = null;
		if (candidatoDTO != null) {
			candidato = new Candidato(candidatoDTO.getId(),candidatoDTO.getUsername(),candidatoDTO.getPassword(),candidatoDTO.getName(),candidatoDTO.getSurname(),candidatoDTO.getAge(),candidatoDTO.getTipolaurea(),candidatoDTO.getExperience());			
		}
		return candidato;
	}

	@Override
	public CandidatoDTO toDTO(Candidato candidato) {
		CandidatoDTO candidatoDTO = null;
		if (candidato != null) {
			candidatoDTO = new CandidatoDTO(candidato.getId(),candidato.getUsername(),candidato.getPassword(),candidato.getName(),candidato.getSurname(),candidato.getAge(),candidato.getTipolaurea(),candidato.getExperience());
			
		}
		return candidatoDTO;
	}
}