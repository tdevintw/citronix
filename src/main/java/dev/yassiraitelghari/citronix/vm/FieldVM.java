package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FieldVM {
    public FieldVM(Field field) {
        this.farmName = field.getFarm().getName();
        this.totalArea = field.getFarm().getArea();
        this.fieldArea = field.getArea();
    }

    private String farmName;
    private double totalArea;
    private double fieldArea;
}
