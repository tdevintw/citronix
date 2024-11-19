package dev.yassiraitelghari.citronix.mapper;

import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.dto.Farm.FarmCreateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    Farm farmCreateDTOToFarm(FarmCreateDTO farmCreateDTO);
}
