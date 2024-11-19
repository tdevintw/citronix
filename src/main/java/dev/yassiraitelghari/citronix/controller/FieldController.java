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
        FieldVM fieldVM = new FieldVM(field.getFarm().getName(), field.getFarm().getArea(), field.getArea());
        return ResponseEntity.status(201).body(fieldVM);
    }
}
