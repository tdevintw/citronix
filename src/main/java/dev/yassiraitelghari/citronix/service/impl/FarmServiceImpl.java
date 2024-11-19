package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.dto.Farm.FarmCreateDTO;
import dev.yassiraitelghari.citronix.exception.FarmWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.mapper.FarmMapper;
import dev.yassiraitelghari.citronix.repository.FarmRepository;
import dev.yassiraitelghari.citronix.service.FarmService;
import dev.yassiraitelghari.citronix.vm.FarmCreationVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("FarmServiceImpl")
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;

    public Optional<Farm> findById(UUID id) {
        return farmRepository.findById(id);
    }

    public Farm create(FarmCreateDTO farmCreateDTO) {
        Farm farm = farmMapper.farmCreateDTOToFarm(farmCreateDTO);
        return farmRepository.save(farm);
    }

    public void delete(UUID id) {
        Optional<Farm> farmOptional = this.findById(id);
        if (farmOptional.isEmpty()) {
            throw new FarmWithUUIDNotFoundException();
        }
        farmRepository.deleteById(id);
    }

    public Farm update(UUID id, FarmCreateDTO farmCreateDTO) {
        Optional<Farm> farmOptional = this.findById(id);
        if (farmOptional.isEmpty()) {
            throw new FarmWithUUIDNotFoundException();
        }
        Farm farm = farmMapper.farmCreateDTOToFarm(farmCreateDTO);
        farm.setId(id);
        return farmRepository.save(farm);
    }

    public List<FarmCreationVM> farmsWithFieldsAreaLessThen4000M() {
        List<Farm> farms = farmRepository.farmsWithFieldsAreaLessThen4000M();
        return farms.stream().map(FarmCreationVM::new).toList();
    }
}
