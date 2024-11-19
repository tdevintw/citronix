package dev.yassiraitelghari.citronix.service.impl;


import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.dto.Field.FieldCreateDTO;
import dev.yassiraitelghari.citronix.exception.FarmWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.exception.FieldAreaPassedHalfOfFarmException;
import dev.yassiraitelghari.citronix.exception.PassTenFieldsPerFarmException;
import dev.yassiraitelghari.citronix.service.FarmService;
import dev.yassiraitelghari.citronix.service.FieldService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("FieldServiceImp")
public class FieldServiceImpl implements FieldService {

    private FarmService farmService ;
    public FieldServiceImpl(@Qualifier("FarmServiceImpl") FarmService farmService){
        this.farmService = farmService ;
    }
    public FieldServiceImpl()
    public Field create(UUID id , FieldCreateDTO fieldCreateDTO){
        Optional<Farm> farmOptional = farmService.findById(id);
        if(farmOptional.isEmpty()){
            throw  new FarmWithUUIDNotFoundException();
        }else if(this.isAreaLessThenHalf(fieldCreateDTO , farmOptional.get())){
            throw  new FieldAreaPassedHalfOfFarmException();
        }else if(farmService.countFieldsOfAFarm(farmOptional.get())>=10){
            throw new PassTenFieldsPerFarmException();
        }

    }

    public boolean isAreaLessThenHalf(FieldCreateDTO fieldCreateDTO , Farm farm){
        return farm.getArea() / 2 >= fieldCreateDTO.getArea() ;
    }

}
