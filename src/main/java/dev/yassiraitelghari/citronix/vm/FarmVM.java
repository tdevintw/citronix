package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.Farm;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class FarmVM {

    private String name  ;
    private String location ;
    private double area;
    private String date ;

    public FarmVM(Farm farm){
        name = farm.getName();
        location = farm.getLocation() ;
        area = farm.getArea();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        date = farm.getCreationDate().format(formatter);
    }
}
