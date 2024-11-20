package dev.yassiraitelghari.citronix.service.impl;

import dev.yassiraitelghari.citronix.domain.Field;
import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.dto.Tree.TreeCreateDTO;
import dev.yassiraitelghari.citronix.exception.FieldWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.repository.TreeRepository;
import dev.yassiraitelghari.citronix.service.FieldService;
import dev.yassiraitelghari.citronix.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TreeServiceImpl implements TreeService {

    private final TreeRepository treeRepository;
    private final FieldService fieldService;

    private TreeServiceImpl(TreeRepository treeRepository, FieldService fieldService) {
        this.treeRepository = treeRepository;
        this.fieldService = fieldService;
    }

    public Tree create(UUID id, TreeCreateDTO treeCreateDTO) {
        Optional<Field> fieldOptional = fieldService.findById(id);
        if (fieldOptional.isEmpty()) {
            throw new FieldWithUUIDNotFoundException();
        }
        Tree tree = new Tree();
        tree.setAge(treeCreateDTO.getAge());
        tree.setField(fieldOptional.get());
        tree.setPlantingDate(LocalDateTime.now());
        return treeRepository.save(tree);
    }

}
