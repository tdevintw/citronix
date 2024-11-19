package dev.yassiraitelghari.citronix.dto.Farm;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FarmCreateDTO {

    @NotBlank(message = "Farm name is required")
    @Size(min = 5 , max = 20 , message = "Farm name must be between 5 to 20 characters")
    private String name ;
    @NotBlank(message = "Location is required")
    @Size(min = 5 , max = 20 , message = "Location  must be between 5 to 20 characters")
    private String location ;
    @NotNull
    @Past( message = "Farm creation date can't be in the future")
    private LocalDateTime creationDate ;

}
