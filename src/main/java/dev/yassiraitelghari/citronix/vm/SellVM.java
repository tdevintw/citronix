package dev.yassiraitelghari.citronix.vm;


import dev.yassiraitelghari.citronix.domain.Harvest;
import dev.yassiraitelghari.citronix.domain.Sell;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SellVM {

    private double price;
    private double quantity;
    private double revenue;
    private LocalDateTime sellDate;
    public  SellVM(Sell sell){
        this.price = sell.getPrice();
        this.quantity = sell.getQuantity() ;
        this.sellDate = sell.getSellDate();
        this.revenue = sell.getRevenue();
    }
}
