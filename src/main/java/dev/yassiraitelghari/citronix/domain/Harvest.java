package dev.yassiraitelghari.citronix.domain;

import dev.yassiraitelghari.citronix.domain.enums.Season;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Harvest {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    private double totalQuantity ;

    private LocalDateTime harvestDate ;

    @OneToMany(mappedBy = "harvest")
    private List<HarvestDetail> harvestDetails ;

    @OneToMany(mappedBy = "harvest")
    private List<Sell> sells;
}
