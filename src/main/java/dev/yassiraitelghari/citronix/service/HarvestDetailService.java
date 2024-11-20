package dev.yassiraitelghari.citronix.service;


import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HarvestDetailService {

    Optional<HarvestDetail> findById(UUID id);


    HarvestTreeVM harvestTree(UUID id);

    void delete(UUID id);

    List<HarvestDetail> harvestDetailsOfAField(Field field);
}
