package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.domain.Harvest;
import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import dev.yassiraitelghari.citronix.exception.FieldAlreadyHarvestedForTheSeasonException;
import dev.yassiraitelghari.citronix.exception.FieldWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.exception.NoTreesPlantedInFieldException;
import dev.yassiraitelghari.citronix.repository.HarvestRepository;
import dev.yassiraitelghari.citronix.service.FieldService;
import dev.yassiraitelghari.citronix.service.HarvestDetailService;
import dev.yassiraitelghari.citronix.service.HarvestService;
import dev.yassiraitelghari.citronix.service.TreeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("HarvestServiceImpl")
public class HarvestServiceImpl implements HarvestService {
    private final FieldService fieldService;
    private final HarvestRepository harvestRepository;
    private final HarvestDetailService harvestDetailService;
    private final TreeService treeService;

    public HarvestServiceImpl(@Qualifier("FieldServiceImp") FieldService fieldService, HarvestRepository harvestRepository, @Qualifier("HarvestDetailServiceImpl") HarvestDetailService harvestDetailService, @Qualifier("TreeServiceImpl") TreeService treeService) {
        this.fieldService = fieldService;
        this.harvestRepository = harvestRepository;
        this.harvestDetailService = harvestDetailService;
        this.treeService = treeService;
    }

    public Harvest createHarvestField(UUID id) {
        Optional<Field> field = fieldService.findById(id);
        if (field.isEmpty()) {
            throw new FieldWithUUIDNotFoundException();
        } else if (field.get().getTrees().isEmpty()) {
            throw new NoTreesPlantedInFieldException();
        }else if(fieldService.isFieldHarvestedForThisSeason(field.get())){
            throw new FieldAlreadyHarvestedForTheSeasonException();
        }
        double count = harvestRepository.totalQuantityOfHarvestTreesOfAField(id);
        Harvest harvest = new Harvest();
        harvest.setHarvestDate(LocalDateTime.now());
        List<HarvestDetail> harvestDetails = harvestDetailService.harvestDetailsOfAField(field.get());
        harvestDetails.forEach(harvestDetail -> harvestDetail.setHarvest(harvest));
        harvest.setHarvestDetails(harvestDetails);
        harvest.setTotalQuantity(count);
        harvestRepository.save(harvest);
        return harvestRepository.save(harvest);
    }


}
