package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.dto.Sell.SellDTO;
import dev.yassiraitelghari.citronix.service.SellService;
import dev.yassiraitelghari.citronix.vm.SellVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sell")
public class SellController {
    private final SellService sellService ;
    public SellController(@Qualifier("SellServiceImpl") SellService sellService){
        this.sellService = sellService;
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> create(@PathVariable UUID id , @RequestBody SellDTO sellDTO){
       SellVM sellVM =  sellService.save(id , sellDTO);
       return ResponseEntity.status(201).body(sellVM);
    }
}
