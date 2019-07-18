package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.OpenjobDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Openjob and its DTO OpenjobDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OpenjobMapper extends EntityMapper<OpenjobDTO, Openjob> {



    default Openjob fromId(Long id) {
        if (id == null) {
            return null;
        }
        Openjob openjob = new Openjob();
        openjob.setId(id);
        return openjob;
    }
}
