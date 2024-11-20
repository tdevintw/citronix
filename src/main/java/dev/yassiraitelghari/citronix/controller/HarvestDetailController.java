package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.service.HarvestDetailService;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/harvest")
public class HarvestDetailController {

    private final HarvestDetailService harvestDetailService;

    public HarvestDetailController(@Qualifier("HarvestDetailServiceImpl") HarvestDetailService harvestDetailService){
        this.harvestDetailService = harvestDetailService;
    }
    @PostMapping("/tree/{id}")
    public ResponseEntity<?> harvestTree(@PathVariable UUID id){
       HarvestTreeVM harvestTreeVM = harvestDetailService.harvestTree(id);
       return ResponseEntity.status(201).body(harvestTreeVM);
    }

    @DeleteMapping("/tree/{id}")
    public ResponseEntity<?> deleteTreeHarvest(@PathVariable UUID id){
     harvestDetailService.delete(id);
     return ResponseEntity.status(202).body("The Harvest of the tree has been deleted");
    }

}
