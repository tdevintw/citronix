package dev.yassiraitelghari.citronix.vm;

import dev.yassiraitelghari.citronix.domain.Harvest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HarvestVM {

    private FieldVM fieldVM;
    List<TreeHarvestVM> treeHarvestVMS ;
    public HarvestVM(Harvest harvest) {
        this.fieldVM = new FieldVM(harvest.getHarvestDetails().getFirst().getTree().getField());
    }
}
