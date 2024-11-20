package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.service.TreeService;
import dev.yassiraitelghari.citronix.service.impl.TreeServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class TreeVM {
    private String farmName;
    private double farmArea;
    private String farmLocation;
    private double fieldArea;
    private int treeAge;
    private String plantingDate;
    private double productivity;
    public TreeVM(Tree tree) {
        this.farmName = tree.getField().getFarm().getName();
        this.farmArea = tree.getField().getFarm().getArea();
        this.farmLocation = tree.getField().getFarm().getLocation();
        this.fieldArea = tree.getField().getArea();
        this.treeAge = Period.between(tree.getPlantingDate().toLocalDate() , LocalDateTime.now().toLocalDate()).getYears();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        this.plantingDate = tree.getPlantingDate().format(formatter);
    }

}
