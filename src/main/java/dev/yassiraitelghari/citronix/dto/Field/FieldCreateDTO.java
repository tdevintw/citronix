package dev.yassiraitelghari.citronix.dto.Field;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldCreateDTO {
    @Positive(message = "Area required and must be greater then 0")
    @Min(value = 1000 , message = "Area size must be greater or equal 1000m²")
    private double area ;
}
