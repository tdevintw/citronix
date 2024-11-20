package dev.yassiraitelghari.citronix.service;


import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;

import java.util.UUID;

public interface HarvestService {
    HarvestTreeVM harvestTree(UUID id);
}
