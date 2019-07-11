package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	CompanyConverter converter;
	
	@Override
	public Openjob toEntity(OpenjobDTO openjobDTO) {
		Openjob openjob = new Openjob();
		if (openjobDTO != null) {
			openjob = new Openjob();
				openjob.setId(openjobDTO.getId());
				openjob.setTitolo(openjobDTO.getTitolo());
				openjob.setDescrizione(openjobDTO.getDescrizione());
				openjob.setRequisiti(openjobDTO.getRequisiti());
				openjob.setCompany(converter.toEntity(openjobDTO.getCompanyDTO()));	
		}
		return openjob;
	}

	@Override
	public OpenjobDTO toDTO(Openjob openjob) {
		OpenjobDTO openjobDTO = new OpenjobDTO();
		if (openjob != null) {
			openjobDTO.setId(openjob.getId());
			openjobDTO.setTitolo(openjob.getTitolo());
			openjobDTO.setDescrizione(openjob.getDescrizione());
			openjobDTO.setRequisiti(openjob.getRequisiti());
			openjobDTO.setCompanyDTO(converter.toDTO(openjob.getCompany()));	
		}
		return openjobDTO;
	}
}