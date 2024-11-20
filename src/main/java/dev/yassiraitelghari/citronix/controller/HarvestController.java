package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.service.HarvestService;
import dev.yassiraitelghari.citronix.vm.HarvestTreeVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
