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
public class HarvestDetail {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double quantity;

    private LocalDateTime harvestDate ;

    private Season season ;


    @ManyToOne
    private Tree tree ;

    @ManyToOne
    private Harvest harvest ;
}
