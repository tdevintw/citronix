package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.dto.Field.FieldCreateDTO;

import java.util.Optional;
import java.util.UUID;

public interface FieldService {

    Optional<Field> findById(UUID id);
    Field create(UUID id, FieldCreateDTO fieldCreateDTO);

    void delete(UUID id);

    Field update(UUID id , FieldCreateDTO fieldCreateDTO);
}
