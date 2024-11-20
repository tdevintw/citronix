package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.repository.HarvestDetailRepository;
import dev.yassiraitelghari.citronix.repository.HarvestRepository;
import dev.yassiraitelghari.citronix.service.HarvestService;
import dev.yassiraitelghari.citronix.service.TreeService;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service("HarvestServiceImpl")
public class HarvestServiceImpl implements HarvestService {
    private final TreeService treeService;
    private final HarvestDetailRepository harvestDetailRepository;

    public HarvestServiceImpl(@Qualifier("TreeServiceImpl") TreeService treeService, HarvestDetailRepository harvestDetailRepository) {
        this.treeService = treeService;
        this.harvestDetailRepository = harvestDetailRepository;
    }

    public HarvestTreeVM harvestTree(UUID id) {
        Tree tree = treeService.findById(id);
        HarvestDetail harvestDetail = this.TreeToHarvestDetail(tree);
        HarvestDetail harvestDetail1 = harvestDetailRepository.save(harvestDetail);
        HarvestTreeVM harvestTreeVM = new HarvestTreeVM(harvestDetail1);
        harvestTreeVM.getTreeVM().setProductivity(treeService.treeProductivity(tree));
        return harvestTreeVM;
    }

    public HarvestDetail TreeToHarvestDetail(Tree tree) {
        HarvestDetail harvestDetail = new HarvestDetail();
        harvestDetail.setTree(tree);
        harvestDetail.setHarvestDate(LocalDateTime.now());
        harvestDetail.setQuantity(treeService.treeProductivity(tree));
        return harvestDetail;
    }

    public boolean isTreeAlreadyHarvestedInSeason(Tree tree) {
        return false;
    }

}
