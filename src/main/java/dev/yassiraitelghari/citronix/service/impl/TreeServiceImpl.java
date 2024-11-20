package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.exception.FieldWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.exception.SpaceBetweenTreesException;
import dev.yassiraitelghari.citronix.exception.TreePlantingException;
import dev.yassiraitelghari.citronix.exception.TreeWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.repository.TreeRepository;
import dev.yassiraitelghari.citronix.service.FieldService;
import dev.yassiraitelghari.citronix.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;
import java.util.UUID;

@Service("TreeServiceImpl")
public class TreeServiceImpl implements TreeService {

    private final TreeRepository treeRepository;
    private final FieldService fieldService;

    private TreeServiceImpl(TreeRepository treeRepository, FieldService fieldService) {
        this.treeRepository = treeRepository;
        this.fieldService = fieldService;
    }

    public  Tree findById(UUID id){
        return treeRepository.findById(id).orElseThrow(TreeWithUUIDNotFoundException::new);
    }

    public Tree create(UUID id) {
        Optional<Field> fieldOptional = fieldService.findById(id);
        if (fieldOptional.isEmpty()) {
            throw new FieldWithUUIDNotFoundException();
        }
//        else if (!this.isPlantingMonthAccurate()) {
//            throw new TreePlantingException();
//        }
        else if (!fieldService.isTreePlantingAvailableInField(fieldOptional.get())) {
            throw new SpaceBetweenTreesException();
        }

        Tree tree = new Tree();
        tree.setField(fieldOptional.get());
        tree.setPlantingDate(LocalDateTime.now());
        return treeRepository.save(tree);
    }

    public boolean isPlantingMonthAccurate() {
        int month = LocalDateTime.now().getMonthValue();
        switch (month) {
            case 3, 4, 5:
                return true;
            default:
                return false;
        }
    }

    public double treeProductivity(Tree tree) {
        int ageInYears = Period.between(LocalDate.now(), tree.getPlantingDate().toLocalDate()).getYears();
        if (ageInYears < 3) {
            return 2.5;
        } else if (ageInYears < 10) {
            return 12;
        } else if (ageInYears < 20) {
            return 20;
        } else {
            return 0;
        }
    }


}
