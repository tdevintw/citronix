package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.domain.Harvest;
import dev.yassiraitelghari.citronix.service.HarvestService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/harvest")
public class HarvestController {

    private final HarvestService harvestService ;
    public HarvestController(@Qualifier("HarvestServiceImpl") HarvestService harvestService){
        this.harvestService = harvestService;
    }
    @GetMapping("/field/{id}")
    public ResponseEntity<?> harvestField(@PathVariable UUID id){
        Harvest harvest = harvestService.createHarvestField(id);
        return ResponseEntity.status(201).body(harvest);
    }
}
