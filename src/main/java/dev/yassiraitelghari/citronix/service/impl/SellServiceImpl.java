package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.Harvest;
import dev.yassiraitelghari.citronix.domain.Sell;
import dev.yassiraitelghari.citronix.dto.Sell.SellDTO;
import dev.yassiraitelghari.citronix.exception.HarvestWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.repository.HarvestRepository;
import dev.yassiraitelghari.citronix.repository.SellRepository;
import dev.yassiraitelghari.citronix.service.HarvestService;
import dev.yassiraitelghari.citronix.service.SellService;
import dev.yassiraitelghari.citronix.vm.SellVM;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service("SellServiceImpl")
public class SellServiceImpl implements SellService {

    private final HarvestService harvestService;
    private final SellRepository sellRepository;

    public SellServiceImpl(@Qualifier("HarvestServiceImpl") HarvestService harvestService, SellRepository sellRepository) {
        this.harvestService = harvestService;
        this.sellRepository = sellRepository;
    }

    public SellVM save(UUID id, SellDTO sellDTO) {
        Optional<Harvest> harvest = harvestService.findById(id);
        if (harvest.isEmpty()) {
            throw new HarvestWithUUIDNotFoundException();
        }
        Sell sell = new Sell();
        sell.setHarvest(harvest.get());
        sell.setSellDate(LocalDateTime.now());
        sell.setPrice(sellDTO.getPrice());
        sell.setPrice(sellDTO.getQuantity());
        sell.setRevenue(sellDTO.getPrice() * sell.getQuantity());
        sell = sellRepository.save(sell);
        return new SellVM(sell);

    }
}
