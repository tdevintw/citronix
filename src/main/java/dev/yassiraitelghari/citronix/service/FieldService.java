package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.dto.Field.FieldCreateDTO;

import java.util.UUID;

public interface FieldService {
    Field create(UUID id, FieldCreateDTO fieldCreateDTO);

    void delete(UUID id);
}
