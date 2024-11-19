package dev.yassiraitelghari.citronix.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sell {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;
    private  double price ;
    @ManyToOne
    private Harvest harvest ;
}
