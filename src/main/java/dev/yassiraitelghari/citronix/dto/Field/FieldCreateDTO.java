package dev.yassiraitelghari.citronix.dto.Field;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldCreateDTO {
    @NotBlank(message = "Area is required")
    @Positive(message = "Area must be greater then 0")
    @Size(min = 1000 , message = "Area size must be greater or equal 1000m²")
    private double area ;
}
