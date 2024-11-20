package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class HarvestTreeVM {

    private TreeVM treeVM;
    private String harvestDate ;

    public HarvestTreeVM(HarvestDetail harvestDetail){
        this.treeVM = new TreeVM(harvestDetail.getTree());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        this.harvestDate = harvestDetail.getHarvestDate().format(formatter);
    }
}
