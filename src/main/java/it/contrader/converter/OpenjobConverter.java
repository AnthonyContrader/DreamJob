package it.contrader.converter;

import org.springframework.stereotype.Component;


import it.contrader.dto.OpenjobDTO;
import it.contrader.model.Openjob;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class OpenjobConverter extends AbstractConverter<Openjob,OpenjobDTO> {

	@Override
	public Openjob toEntity(OpenjobDTO openjobDTO) {
		Openjob openjob = null;
		if (openjobDTO != null) {
			openjob = new Openjob(openjobDTO.getId(),openjobDTO.getTitolo(),openjobDTO.getDescrizione(),openjobDTO.getRequisiti());			
				
			
		}
		return openjob;
	}

	@Override
	public OpenjobDTO toDTO(Openjob openjob) {
		OpenjobDTO openjobDTO = null;
		if (openjob != null) {
			openjobDTO = new OpenjobDTO(openjob.getId(),openjob.getTitolo(),openjob.getDescrizione(),openjob.getRequisiti());
			
		}
		return openjobDTO;
	}
}