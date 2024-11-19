package dev.yassiraitelghari.citronix.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldVM {
    private String farmName;
    private double totalArea;
    private double fieldArea;
}
