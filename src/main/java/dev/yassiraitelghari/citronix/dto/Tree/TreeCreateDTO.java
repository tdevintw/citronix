package dev.yassiraitelghari.citronix.dto.Tree;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeCreateDTO {
    @Min(value = 0, message = "The minimum age is 0")
    @Max(value = 19, message = "The max tree age is 19 since the tree is unproductive  beyond 20")
    int age;
}