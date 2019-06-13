package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;

public class ConverterCandidato {

	public static CandidatoDTO toDTO(Candidato candidato) {
		CandidatoDTO candidatoDTO = null;
		if (candidato != null) {
			//collega model e DTO
			candidatoDTO = new CandidatoDTO();
			candidatoDTO.setName(candidato.getName());
			candidatoDTO.setSurname(candidato.getSurname());
			candidatoDTO.setAge(candidato.getAge());
			candidatoDTO.setEducation(candidato.getEducation());
			candidatoDTO.setExperience(candidato.getExperience());
			
		}
		return candidatoDTO;
	}

	public static Candidato toEntity(CandidatoDTO candidatoDTO) {
		Candidato candidato = null;
		if (candidatoDTO != null) {
			//collego DTO a model, verifica
			candidato = new Candidato();
			candidato.setName(candidatoDTO.getName());
			candidato.setSurname(candidatoDTO.getSurname());
			candidato.setAge(candidatoDTO.getAge());
			candidato.setEducation(candidatoDTO.getEducation());
			candidato.setExperience(candidatoDTO.getExperience());
			
		}
		return candidato;
	}

	public static List<CandidatoDTO> toListDTO(List<Candidato> list) {
		List<CandidatoDTO> listCandidatoDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Candidato candidato : list) {
				listCandidatoDTO.add(ConverterCandidato.toDTO(candidato));
				//trasforma la lista in array, conversione 1 
			}
		}
		return listCandidatoDTO;
	}

	public static List<Candidato> toListEntity(List<CandidatoDTO> listCandidatoDTO) {
		List<Candidato> list = new ArrayList<>();
		if (!listCandidatoDTO.isEmpty()) {
			for (CandidatoDTO candidatoDTO : listCandidatoDTO) {
				// conversione 2
				list.add(ConverterCandidato.toEntity(candidatoDTO));
			}
		}
		return list;
	}
}
