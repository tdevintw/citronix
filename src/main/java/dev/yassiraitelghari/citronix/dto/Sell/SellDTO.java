package dev.yassiraitelghari.citronix.dto.Sell;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO {
    @Positive(message = "Price couldn't be negative")
    private double price ;
    @Positive(message = "Quantity couldn't be negative")
    private double quantity ;
}
