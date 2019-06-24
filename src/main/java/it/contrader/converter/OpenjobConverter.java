package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OpenjobDTO;

import it.contrader.model.Openjob;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class OpenjobConverter  implements Converter<Openjob, OpenjobDTO> {
	
	/**
	 * Crea un oggetto di tipo OpenjobDTO e lo riempie con i campi del parametro user di tipo Openjob.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public OpenjobDTO toDTO(Openjob openjob) {
		if (openjob == null) {
			System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			return null;

				} else {
					OpenjobDTO openjobDTO = new OpenjobDTO (openjob.getId(),  openjob.getTitolo(), openjob.getDescrizione(), openjob.getRequisiti());
					return openjobDTO;

				}
	}
	/**
	 * Crea un oggetto di tipo Openjob e lo riempie con i campi del parametro user di tipo OpenjobDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Openjob toEntity(OpenjobDTO openjobDTO) {
		Openjob openjob = new Openjob(openjobDTO.getId(), openjobDTO.getTitolo(), openjobDTO.getDescrizione(), openjobDTO.getRequisiti());
		return openjob;
	}
	
	/**
	 * Metodo per convertire le liste di Openjob.
	 */
	@Override
	public List<OpenjobDTO> toDTOList(List<Openjob> openjobList) {
		//Crea una lista vuota.
		List<OpenjobDTO> openjobDTOList = new ArrayList<OpenjobDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Openjob openjob : openjobList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			openjobDTOList.add(toDTO(openjob));
		}
		return openjobDTOList;
	}

	
	
}
