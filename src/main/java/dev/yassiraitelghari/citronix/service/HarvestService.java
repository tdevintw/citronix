package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Harvest;

import java.util.Optional;
import java.util.UUID;

public interface HarvestService {
    Harvest createHarvestField(UUID id);

    Optional<Harvest> findById(UUID id);
}
