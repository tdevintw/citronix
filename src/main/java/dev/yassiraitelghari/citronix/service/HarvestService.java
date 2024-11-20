package dev.yassiraitelghari.citronix.service;


import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;

import java.util.Optional;
import java.util.UUID;

public interface HarvestService {

    Optional<HarvestDetail> findById(UUID id);


    HarvestTreeVM harvestTree(UUID id);

    void delete(UUID id);
}
