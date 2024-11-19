package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.dto.Field.FieldCreateDTO;
import dev.yassiraitelghari.citronix.service.FieldService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/field")
public class FieldController {

    private final FieldService fieldService ;
    public FieldController(@Qualifier("FieldServiceImp") FieldService fieldService){
        this.fieldService = fieldService;
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> create(@PathVariable UUID id, @Valid @RequestBody FieldCreateDTO fieldCreateDTO) {
        fieldService
    }
}
