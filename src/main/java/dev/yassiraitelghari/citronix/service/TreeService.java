package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Tree;

import java.util.UUID;

public interface TreeService {

    Tree create(UUID id);

    double treeProductivity(Tree tree);
}
