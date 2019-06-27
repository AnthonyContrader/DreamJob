package it.contrader.converter;

public interface Converter<Entity,DTO> {

	public Entity convertToEntity(DTO dto); //convertToEntity effettua la conversione da DTO ad un'entità
	
	public DTO covertToDTO(Entity entity); //convertToDTO effettua la conversione da un'entità al DTO
	
}
