package dev.yassiraitelghari.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Farm {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;
    private String name ;
    private String location ;
    private double area;
    private LocalDateTime creationDate ;
    @OneToMany(mappedBy = "farm")
    private List<Field> fields;

}
