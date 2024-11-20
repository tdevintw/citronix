package dev.yassiraitelghari.citronix.service.impl;


import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.dto.Field.FieldCreateDTO;
import dev.yassiraitelghari.citronix.exception.*;
import dev.yassiraitelghari.citronix.repository.FieldRepository;
import dev.yassiraitelghari.citronix.service.FarmService;
import dev.yassiraitelghari.citronix.service.FieldService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("FieldServiceImp")
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;
    private final FarmService farmService;

    public Optional<Field> findById(UUID id) {
        return fieldRepository.findById(id);
    }

    public FieldServiceImpl(@Qualifier("FarmServiceImpl") FarmService farmService, FieldRepository fieldRepository) {
        this.farmService = farmService;
        this.fieldRepository = fieldRepository;
    }

    public Field create(UUID id, FieldCreateDTO fieldCreateDTO) {
        Optional<Farm> farmOptional = farmService.findById(id);
        if (farmOptional.isEmpty()) {
            throw new FarmWithUUIDNotFoundException();
        } else if (!this.isAreaLessThenHalf(fieldCreateDTO, farmOptional.get())) {
            throw new FieldAreaPassedHalfOfFarmException();
        } else if (farmService.countFieldsOfAFarm(farmOptional.get()) >= 10) {
            throw new PassTenFieldsPerFarmException();
        } else if (!this.isFieldAreaLessThenLeftFarmSize(fieldCreateDTO, farmOptional.get())) {
            throw new FieldAreaPassLeftFarmSize();
        }
        Field field = new Field();
        field.setArea(fieldCreateDTO.getArea());
        field.setFarm(farmOptional.get());
        return fieldRepository.save(field);
    }

    public boolean isAreaLessThenHalf(FieldCreateDTO fieldCreateDTO, Farm farm) {
        return farm.getArea() / 2 >= fieldCreateDTO.getArea();
    }

    public boolean isFieldAreaLessThenLeftFarmSize(FieldCreateDTO fieldCreateDTO, Farm farm) {
        return (farm.getArea() - farmService.sumOfFieldAreaOfFarm(farm)) > fieldCreateDTO.getArea();
    }

    public boolean isFieldAreaLessThenLeftFarmSize(FieldCreateDTO fieldCreateDTO, Farm farm, Field field) {
        return (farm.getArea() - farmService.sumOfFieldAreaOfFarm(farm) + field.getArea()) > fieldCreateDTO.getArea();
    }


    public void delete(UUID id) {
        Optional<Field> field = this.findById(id);
        if (field.isEmpty()) {
            throw new FieldWithUUIDNotFoundException();
        }
        fieldRepository.deleteById(id);
    }

    public Field update(UUID id, FieldCreateDTO fieldCreateDTO) {
        Optional<Field> field = this.findById(id);
        if (field.isEmpty()) {
            throw new FieldWithUUIDNotFoundException();
        }
        Farm farm = field.get().getFarm();
        if (!this.isAreaLessThenHalf(fieldCreateDTO, farm)) {
            throw new FieldAreaPassedHalfOfFarmException();
        } else if (!this.isFieldAreaLessThenLeftFarmSize(fieldCreateDTO, farm, field.get())) {
            throw new FieldAreaPassLeftFarmSize();
        }
        field.get().setArea(fieldCreateDTO.getArea());
        return fieldRepository.save(field.get());
    }


    public boolean isTreePlantingAvailableInField(Field field) {
        int maxTreesToBePlanted = (int)(field.getArea() / 10 );
        int TreeCurrentCount = field.getTrees().size();
        return maxTreesToBePlanted > TreeCurrentCount ;
    }
}
