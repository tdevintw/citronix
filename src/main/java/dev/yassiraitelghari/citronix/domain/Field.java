package dev.yassiraitelghari.citronix.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;
    private double area ;
    @ManyToOne
    private Farm farm ;
    @OneToMany(mappedBy = "field")
    private List<Tree> trees ;
}
