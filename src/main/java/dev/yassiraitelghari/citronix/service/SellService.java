package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.dto.Sell.SellDTO;
import dev.yassiraitelghari.citronix.vm.SellVM;

import java.util.UUID;

public interface SellService {
    public SellVM save(UUID id , SellDTO sellDTO); ;
}
