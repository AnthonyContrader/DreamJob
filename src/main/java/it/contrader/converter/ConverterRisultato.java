package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.RisultatoDTO;
import it.contrader.model.Risultato;


public class ConverterRisultato {

	public static RisultatoDTO toDTO(Risultato risultato) {
		RisultatoDTO risultatoDTO = null;
		if (risultato != null) {
			risultatoDTO = new RisultatoDTO();
			risultatoDTO.setId(risultato.getId());
			risultatoDTO.setDescrizione(risultato.getDescrizione());
		}
		return risultatoDTO;
	}

	public static Risultato toEntity(RisultatoDTO risultatoDTO) {
		Risultato risultato = null;
		if (risultatoDTO != null) {
			risultato = new Risultato();
			risultato.setId(risultatoDTO.getId());
			risultato.setDescrizione(risultatoDTO.getDescrizione());
		}
		return risultato;
	}

	public static List<RisultatoDTO> toListDTO(List<Risultato> list) {
		List<RisultatoDTO> listRisultatoDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Risultato risultato : list) {
				listRisultatoDTO.add(ConverterRisultato.toDTO(risultato));
			}
		}
		return listRisultatoDTO;
	}

	public static List<Risultato> toListEntity(List<RisultatoDTO> listRisultatoDTO) {
		List<Risultato> list = new ArrayList<>();
		if (!listRisultatoDTO.isEmpty()) {
			for (RisultatoDTO risultatoDTO : listRisultatoDTO) {
				list.add(ConverterRisultato.toEntity(risultatoDTO));
			}
		}
		return list;
	}
}
