package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.service.HarvestService;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/harvest")
public class HarvestController {

    private final HarvestService harvestService;

    public HarvestController(@Qualifier("HarvestServiceImpl") HarvestService harvestService){
        this.harvestService = harvestService;
    }
    @PostMapping("/tree/{id}")
    public ResponseEntity<?> harvestTree(@PathVariable UUID id){
       HarvestTreeVM harvestTreeVM = harvestService.harvestTree(id);
       return ResponseEntity.status(201).body(harvestTreeVM);
    }

    @DeleteMapping("/tree/{id}")
    public ResponseEntity<?> deleteTreeHarvest(@PathVariable UUID id){
     harvestService.delete(id);
     ResponseEntity.status(202).body("The Harvest of the tree has been deleted");
    }
}
