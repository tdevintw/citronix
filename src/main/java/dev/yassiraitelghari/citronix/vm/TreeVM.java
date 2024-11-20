package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.Tree;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class TreeVM {
    private String farmName;
    private double farmArea ;
    private String farmLocation ;
    private double fieldArea;
    private int treeAge ;
    private String plantingDate ;

    public  TreeVM(Tree tree){
        this.farmName = tree.getField().getFarm().getName();
        this.farmArea = tree.getField().getFarm().getArea() ;
        this.farmLocation = tree.getField().getFarm().getLocation();
        this.fieldArea = tree.getField().getArea();
        this.treeAge = tree.getAge();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        this.plantingDate = tree.getPlantingDate().format(formatter);
    }

}
