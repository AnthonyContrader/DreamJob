package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CandidatoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Candidato and its DTO CandidatoDTO.
 */
@Mapper(componentModel = "spring", uses = {QuestionaryMapper.class})
public interface CandidatoMapper extends EntityMapper<CandidatoDTO, Candidato> {

    @Mapping(source = "candquest.id", target = "candquestId")
    CandidatoDTO toDto(Candidato candidato);

    @Mapping(source = "candquestId", target = "candquest")
    Candidato toEntity(CandidatoDTO candidatoDTO);

    default Candidato fromId(Long id) {
        if (id == null) {
            return null;
        }
        Candidato candidato = new Candidato();
        candidato.setId(id);
        return candidato;
    }
}
