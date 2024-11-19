package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.Farm;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class FarmCreationVM {

    private String name  ;
    private String location ;
    private String date ;

    public FarmCreationVM(Farm farm){
        name = farm.getName();
        location = farm.getLocation() ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        date = farm.getCreationDate().format(formatter);
    }
}
