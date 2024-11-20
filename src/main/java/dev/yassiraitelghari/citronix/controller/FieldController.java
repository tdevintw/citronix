package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.dto.Field.FieldCreateDTO;
import dev.yassiraitelghari.citronix.service.FieldService;
import dev.yassiraitelghari.citronix.vm.FieldVM;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/field")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(@Qualifier("FieldServiceImp") FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> create(@PathVariable UUID id, @Valid @RequestBody FieldCreateDTO fieldCreateDTO) {
        Field field = fieldService.create(id, fieldCreateDTO);
        FieldVM fieldVM = new FieldVM(field);
        return ResponseEntity.status(201).body(fieldVM);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        fieldService.delete(id);
        return ResponseEntity.status(202).body("Field was deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody FieldCreateDTO fieldCreateDTO) {
        Field field = fieldService.update(id, fieldCreateDTO);
        FieldVM fieldVM = new FieldVM(field);
        return ResponseEntity.status(202).body(fieldVM);
    }
}
