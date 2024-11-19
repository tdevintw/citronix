package dev.yassiraitelghari.citronix.domain;

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
public class Tree {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime plantingDate;

    private int age ;
    @ManyToOne
    private Field field ;

    @OneToMany(mappedBy = "tree")
    private List<HarvestDetail> harvestDetails;

}
