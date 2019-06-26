package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CandidatoDTO;
import it.contrader.model.Candidato;


public class ConverterCandidato {

	public static CandidatoDTO toDTO(Candidato candidato) {
		CandidatoDTO candidatoDTO = null;
		if (candidato != null) {
			candidatoDTO = new CandidatoDTO();
	        
			candidatoDTO.setId(candidato.getId());
			candidatoDTO.setUsername(candidato.getUsername());
			candidatoDTO.setPassword(candidato.getPassword());
			candidatoDTO.setName(candidato.getName());
			candidatoDTO.setSurname(candidato.getSurname());
			candidatoDTO.setAge(candidato.getAge());
			candidatoDTO.setTipolaurea(candidato.getTipolaurea());
			candidatoDTO.setExperience(candidato.getExperience());
		}
		return candidatoDTO;
	}

	public static Candidato toEntity(CandidatoDTO candidatoDTO) {
		Candidato candidato = null;
		if (candidatoDTO != null) {
			candidato = new Candidato();
			candidato.setId(candidatoDTO.getId());
			candidato.setUsername(candidatoDTO.getUsername());
			candidato.setPassword(candidatoDTO.getPassword());
			candidato.setName(candidatoDTO.getName());
			candidato.setSurname(candidatoDTO.getSurname());
			candidato.setAge(candidatoDTO.getAge());
			candidato.setTipolaurea(candidatoDTO.getTipolaurea());
			candidato.setExperience(candidatoDTO.getExperience());
		}
		return candidato;
	}

	public static List<CandidatoDTO> toListDTO(List<Candidato> list) {
		List<CandidatoDTO> listCandidatoDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Candidato candidato : list) {
				listCandidatoDTO.add(ConverterCandidato.toDTO(candidato));
			}
		}
		return listCandidatoDTO;
	}

	public static List<Candidato> toListEntity(List<CandidatoDTO> listCandidatoDTO) {
		List<Candidato> list = new ArrayList<>();
		if (!listCandidatoDTO.isEmpty()) {
			for (CandidatoDTO candidatoDTO : listCandidatoDTO) {
				list.add(ConverterCandidato.toEntity(candidatoDTO));
			}
		}
		return list;
	}
}
