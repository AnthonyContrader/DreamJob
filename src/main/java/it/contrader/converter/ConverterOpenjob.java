package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OpenjobDTO;
import it.contrader.model.Openjob;


public class ConverterOpenjob {

	public static OpenjobDTO toDTO(Openjob openjob) {
		OpenjobDTO openjobDTO = null;
		if (openjob != null) {
			openjobDTO = new OpenjobDTO();
	        
			openjobDTO.setId(openjob.getId());
			openjobDTO.setTitolo(openjob.getTitolo());
			openjobDTO.setDescrizione(openjob.getDescrizione());
			openjobDTO.setRequisiti(openjob.getRequisiti());
			
		}
		return openjobDTO;
	}

	public static Openjob toEntity(OpenjobDTO openjobDTO) {
		Openjob openjob = null;
		if (openjobDTO != null) {
			openjob = new Openjob();
			openjob.setId(openjobDTO.getId());
			openjob.setTitolo(openjobDTO.getTitolo());
			openjob.setDescrizione(openjobDTO.getDescrizione());
			openjob.setRequisiti(openjobDTO.getRequisiti());
			
		}
		return openjob;
	}

	public static List<OpenjobDTO> toListDTO(List<Openjob> list) {
		List<OpenjobDTO> listOpenjobDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Openjob openjob : list) {
				listOpenjobDTO.add(ConverterOpenjob.toDTO(openjob));
			}
		}
		return listOpenjobDTO;
	}

	public static List<Openjob> toListEntity(List<OpenjobDTO> listOpenjobDTO) {
		List<Openjob> list = new ArrayList<>();
		if (!listOpenjobDTO.isEmpty()) {
			for (OpenjobDTO openjobDTO : listOpenjobDTO) {
				list.add(ConverterOpenjob.toEntity(openjobDTO));
			}
		}
		return list;
	}
}
