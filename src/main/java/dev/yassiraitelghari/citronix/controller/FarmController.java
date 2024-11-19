package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.dto.Farm.FarmCreateDTO;
import dev.yassiraitelghari.citronix.service.FarmService;
import dev.yassiraitelghari.citronix.service.impl.FarmServiceImpl;
import dev.yassiraitelghari.citronix.vm.FarmCreationVM;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FarmService farmService;

    public FarmController(@Qualifier("FarmServiceImpl") FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Optional<Farm> farm = farmService.findById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(202)).body(new FarmCreationVM(farm.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody FarmCreateDTO farmCreateDTO) {
        Farm farm = farmService.create(farmCreateDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(new FarmCreationVM(farm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        farmService.delete(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(202)).body("Farm was deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable UUID id, @Valid @RequestBody FarmCreateDTO farmCreateDTO) {
        Farm farm = farmService.update(id, farmCreateDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(202)).body(new FarmCreationVM(farm));
    }

    @GetMapping("/farmsWithFieldsLessThen4000")
    public ResponseEntity<?> farmsWithFieldsAreaTotalLessThen4000() {
        List<FarmCreationVM> farms = farmService.farmsWithFieldsAreaLessThen4000M();
        if (farms.isEmpty()) {
            return ResponseEntity.status(200).body("There is no farm where its fields area total is less then 4000");
        } else {
            return ResponseEntity.status(200).body(farms);
        }
    }
}
