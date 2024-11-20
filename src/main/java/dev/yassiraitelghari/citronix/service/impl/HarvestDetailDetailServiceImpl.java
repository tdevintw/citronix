package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.domain.enums.Season;
import dev.yassiraitelghari.citronix.exception.HarvestDetailWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.exception.TreeAlreadyHarvestedException;
import dev.yassiraitelghari.citronix.repository.HarvestDetailRepository;
import dev.yassiraitelghari.citronix.service.HarvestDetailService;
import dev.yassiraitelghari.citronix.service.TreeService;
import dev.yassiraitelghari.citronix.utils.GetSeason;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service("HarvestDetailServiceImpl")
public class HarvestDetailDetailServiceImpl implements HarvestDetailService {
    private final TreeService treeService;
    private final HarvestDetailRepository harvestDetailRepository;

    public HarvestDetailDetailServiceImpl(@Qualifier("TreeServiceImpl") TreeService treeService, HarvestDetailRepository harvestDetailRepository) {
        this.treeService = treeService;
        this.harvestDetailRepository = harvestDetailRepository;
    }

    public Optional<HarvestDetail> findById(UUID id){
        return harvestDetailRepository.findById(id);
    }

    public HarvestTreeVM harvestTree(UUID id) {
        Tree tree = treeService.findById(id);
        if (isTreeAlreadyHarvestedInSeason(tree)) {
            throw new TreeAlreadyHarvestedException();
        }
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
        harvestDetail.setSeason(GetSeason.season(LocalDateTime.now()));
        return harvestDetail;
    }

    public boolean isTreeAlreadyHarvestedInSeason(Tree tree) {
        Season season = GetSeason.season(LocalDateTime.now());
        return harvestDetailRepository.countHarvestDetailByTreeAndSeason(tree, season) > 0;
    }

    public void delete(UUID id) {
        Optional<HarvestDetail> harvestDetail = this.findById(id);
        if(harvestDetail.isEmpty()){
            throw new HarvestDetailWithUUIDNotFoundException();
        }
        harvestDetailRepository.deleteById(id);
    }

}
