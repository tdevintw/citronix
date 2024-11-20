package dev.yassiraitelghari.citronix.controller;

import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.service.TreeService;
import dev.yassiraitelghari.citronix.vm.TreeVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/tree")
public class TreeController {
    private final TreeService treeService;
    public TreeController(TreeService treeService){
        this.treeService = treeService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> create(@PathVariable UUID id) {
       Tree tree =  treeService.create(id);
        TreeVM treeVM = new TreeVM(tree);
        treeVM.setProductivity(treeService.treeProductivity(tree));
        return ResponseEntity.status(201).body(treeVM);
    }
}
