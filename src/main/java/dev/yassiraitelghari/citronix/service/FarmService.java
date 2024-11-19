package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.dto.Farm.FarmCreateDTO;
import dev.yassiraitelghari.citronix.vm.FarmCreationVM;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FarmService {


    Optional<Farm> findById(UUID id);

    Farm create(FarmCreateDTO farmCreateDTO);

    void delete(UUID id);

    Farm update(UUID id, FarmCreateDTO farmCreateDTO);

    List<FarmCreationVM> farmsWithFieldsAreaLessThen4000M();

}
