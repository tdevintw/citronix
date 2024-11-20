package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Harvest;
import dev.yassiraitelghari.citronix.vm.HarvestVM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HarvestService {
    Harvest createHarvestField(UUID id);
}
